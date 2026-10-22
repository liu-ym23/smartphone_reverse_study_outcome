package com.bytedance.common.wschannel.heartbeat.normal;

import android.os.Handler;
import android.text.TextUtils;
import com.alipay.sdk.m.u.i;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.heartbeat.BaseHeartBeatPolicy;
import com.bytedance.common.wschannel.heartbeat.HeartBeatReactListener;
import com.bytedance.common.wschannel.heartbeat.model.AppState;
import com.bytedance.common.wschannel.heartbeat.monitor.HeartBeatMonitor;
import com.bytedance.common.wschannel.utils.Utils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.Response;

/* JADX INFO: loaded from: classes15.dex */
public class NormalHeartBeatPolicy extends BaseHeartBeatPolicy<NormalHeartBeatMeta> {
    private Handler mHandler;
    private HeartBeatReactListener mReactListener;
    private Runnable mSendHeartBeatRunnable;
    private Runnable mTimeoutCheckRunnable;
    private AtomicBoolean mWaitingForPong;

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onAppStateUpdate(AppState r100) {
    }

    private void disConnect() {
        this.mHandler.removeCallbacks(this.mTimeoutCheckRunnable);
        this.mHandler.removeCallbacks(this.mSendHeartBeatRunnable);
        this.mWaitingForPong.set(false);
    }

    private void schedule() {
        long r100 = ((NormalHeartBeatMeta) this.mMeta).getPingInterval();
        Logger.d("WsChannelSdk_ok", "interval :" + r100 + " ms,the next time to send heartbeat is " + Utils.getTimeFormat(System.currentTimeMillis() + r100));
        this.mHandler.removeCallbacks(this.mSendHeartBeatRunnable);
        this.mHandler.postDelayed(this.mSendHeartBeatRunnable, r100);
    }

    private void waitingForPong() {
        this.mWaitingForPong.set(true);
        this.mHandler.removeCallbacks(this.mTimeoutCheckRunnable);
        this.mHandler.postDelayed(this.mTimeoutCheckRunnable, ((NormalHeartBeatMeta) this.mMeta).getTimeout());
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onDisconnected() {
        Logger.d("WsChannelSdk_ok", "disconnected，stop to send ping");
        disConnect();
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onPingSendSuccess() {
        Logger.d("WsChannelSdk_ok", "ping sent，waiting for pong");
        waitingForPong();
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onReceivePong() {
        Logger.d("WsChannelSdk_ok", "receive pong");
        this.mWaitingForPong.set(false);
        this.mHandler.removeCallbacks(this.mTimeoutCheckRunnable);
        HeartBeatMonitor.getInstance().onPingSuccess();
    }

    public NormalHeartBeatPolicy(NormalHeartBeatMeta r100) {
        super(r100);
        this.mWaitingForPong = new AtomicBoolean(false);
        this.mTimeoutCheckRunnable = new AnonymousClass1(this);
        this.mSendHeartBeatRunnable = new AnonymousClass2(this);
    }

    public static /* synthetic */ AtomicBoolean access$000(NormalHeartBeatPolicy r100) {
        return r100.mWaitingForPong;
    }

    public static /* synthetic */ void access$100(NormalHeartBeatPolicy r100) {
        r100.disConnect();
    }

    public static /* synthetic */ HeartBeatReactListener access$200(NormalHeartBeatPolicy r100) {
        return r100.mReactListener;
    }

    public static /* synthetic */ void access$300(NormalHeartBeatPolicy r100) {
        r100.schedule();
    }

    private void updatePingInterval(Response r110) {
        if (((NormalHeartBeatMeta) this.mMeta).getPingInterval() == (-1)) goto L6;
        return;
    L6:
        if (r110 != null) goto L9;
        ((NormalHeartBeatMeta) this.mMeta).setPingInterval(270000);
        return;
    L9:
        String r111 = r110.header("Handshake-Options");
        if (r111 == null) goto L22;
        String[] r112 = r111.split(i.f25853b);
        int r100 = r112.length;
        long r101 = -1;
        int r102 = 0;
    L12:
        if (r102 >= r100) goto L24;
        String r103 = r112[r102];
        if (TextUtils.isEmpty(r103) == true) goto L21;
        String[] r104 = r103.split(ContainerUtils.KEY_VALUE_DELIMITER);
        if ("ping-interval".equals(r104[0]) == false) goto L21;
        r101 = CastLongProtector.parseLong(r104[1]) * 1000;
    L20:
        r101 = 270000;
    L21:
        r102 = r102 + 1;
    L24:
        if (r101 != (-1)) goto L26;
        ((NormalHeartBeatMeta) this.mMeta).setPingInterval(270000);
        return;
    L26:
        ((NormalHeartBeatMeta) this.mMeta).setPingInterval(r101);
        return;
    L22:
        r101 = -1;
        goto L24
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onConnected(Response r100) {
        Logger.d("WsChannelSdk_ok", "connect success，ready to send ping");
        updatePingInterval(r100);
        schedule();
    }

    @Override // com.bytedance.common.wschannel.heartbeat.BaseHeartBeatPolicy
    public void init(HeartBeatReactListener r100, Handler r101) {
        this.mReactListener = r100;
        this.mHandler = r101;
    }
}
