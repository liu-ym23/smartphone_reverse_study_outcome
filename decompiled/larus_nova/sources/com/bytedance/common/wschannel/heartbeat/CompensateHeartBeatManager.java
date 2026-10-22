package com.bytedance.common.wschannel.heartbeat;

import android.os.Handler;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.channel.impl.ok.ws.CustomHeartBeatWebSocket;
import com.bytedance.common.wschannel.heartbeat.model.AppState;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes15.dex */
public class CompensateHeartBeatManager {
    private AppState currentAppState;
    private Handler mHandler;
    private AtomicBoolean mIsWaitingPong;
    private Runnable mTimeoutCheckRunnable;
    private CustomHeartBeatWebSocket mWebSocket;
    private OnHeartBeatTimeoutListener timeoutListener;

    public interface OnHeartBeatTimeoutListener {
        void onTimeout();
    }

    private void waitingForPong() {
        this.mIsWaitingPong.set(true);
        this.mHandler.removeCallbacks(this.mTimeoutCheckRunnable);
        this.mHandler.postDelayed(this.mTimeoutCheckRunnable, 5000);
    }

    public boolean isWaitingPong() {
        return this.mIsWaitingPong.get();
    }

    public void onReceivePong() {
        Logger.d("WsChannelSdk_ok", "After compensating for ping, received pong");
        this.mIsWaitingPong.set(false);
        this.mHandler.removeCallbacks(this.mTimeoutCheckRunnable);
    }

    public static /* synthetic */ AtomicBoolean access$000(CompensateHeartBeatManager r100) {
        return r100.mIsWaitingPong;
    }

    public static /* synthetic */ OnHeartBeatTimeoutListener access$100(CompensateHeartBeatManager r100) {
        return r100.timeoutListener;
    }

    private boolean isBackToFore(AppState r100) {
        if (this.currentAppState == AppState.STATE_BACKGROUND) goto L5;
    L7:
        return false;
    L5:
        if (r100 != AppState.STATE_FOREGROUND) goto L7;
        return true;
    }

    public void setWebSocket(CustomHeartBeatWebSocket r100) {
        this.mWebSocket = r100;
    }

    public void updateCurrentAppState(AppState r100) {
        if (this.mIsWaitingPong.get() == false) goto L5;
    L15:
        this.currentAppState = r100;
        return;
    L5:
        if (isBackToFore(r100) == false) goto L7;
        Logger.d("WsChannelSdk_ok", "Switch the foreground in the background, send compensation ping");
        boolean r101 = true;
    L8:
        if (r101 == false) goto L15;
        CustomHeartBeatWebSocket r102 = this.mWebSocket;     // Catch: Exception -> L13
        if (r102 == null) goto L15;
        r102.sendPing();     // Catch: Exception -> L13
        waitingForPong();     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L7:
        r101 = false;
        goto L8
    }

    public CompensateHeartBeatManager(OnHeartBeatTimeoutListener r100, Handler r101) {
        this.mIsWaitingPong = new AtomicBoolean(false);
        this.mTimeoutCheckRunnable = new AnonymousClass1(this);
        this.timeoutListener = r100;
        this.mHandler = r101;
    }
}
