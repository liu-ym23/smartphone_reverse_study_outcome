package com.bytedance.common.wschannel.server;

import android.content.Intent;
import android.os.Message;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.common.wschannel.WsChannelSdk;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.app.AbsMessengerService;
import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;

/* JADX INFO: loaded from: classes3.dex */
public class WsChannelService extends AbsMessengerService {

    /* JADX INFO: loaded from: classes15.dex */
    public static class Msg {
        final int channelId;
        final byte[] data;
        final WsChannelMsg message;

        /* JADX INFO: renamed from: ts, reason: collision with root package name */
        final long f202965ts;

        public Msg(int r100, WsChannelMsg r101, long r102) {
            this.channelId = r100;
            this.message = r101;
            this.f202965ts = r102;
            this.data = null;
        }

        public Msg(int r100, byte[] r101, long r102) {
            this.channelId = r100;
            this.data = r101;
            this.f202965ts = r102;
            this.message = null;
        }
    }

    @Override // com.bytedance.common.wschannel.app.AbsMessengerService, android.app.Service
    public void onCreate() {
        if (Logger.debug() == false) goto L5;
        Logger.d("WsChannelService", WidgetCostModule.TYPE_ON_CREATE);
    L5:
        super.onCreate();
    }

    public WsChannelService() {
    }

    @Override // com.bytedance.common.wschannel.app.AbsMessengerService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    public static int getClientKey(IWsApp r100) {
        if (r100 != null) goto L6;
        return Integer.MIN_VALUE;
    L6:
        return r100.getChannelId();
    }

    private void handleIntent(Intent r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        String r101 = r100.getAction();
        if (WsConstants.APP_STATE_ACTION.equals(r101) == false) goto L8;
        int r102 = r100.getIntExtra("app_state", -1);
        Message r103 = new Message();
        r103.what = 2;
        r103.arg1 = r102;
        handleMsg(r103);
        return;
    L8:
        if (WsConstants.NETWORK_STATE_ACTION.equals(r101) == false) goto L11;
        int r104 = r100.getIntExtra(WsConstants.KEY_NETWORK_STATE, -1);
        Message r105 = new Message();
        r105.what = 3;
        r105.arg1 = r104;
        handleMsg(r105);
        return;
    L11:
        if (WsConstants.MEM_TRIM_ACTION.equals(r101) == false) goto L16;
        r100.getIntExtra(WsConstants.KEY_MEM_TRIM, -1);
        WsChannelSdk.getMemTrimListener();
        return;
    }

    @Override // com.bytedance.common.wschannel.app.AbsMessengerService, com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r100) {
        super.handleMsg(r100);
        if (r100 != null) goto L6;
        return;
    L6:
        if (Logger.debug() == false) goto L8;
        Logger.d("WsChannelService", "handleMsg msg.what = " + r100.what);
    L8:
        PushChannelManager.inst(this).handleMsg(r100);
    }

    public static /* synthetic */ void access$000(WsChannelService r100, Intent r101) {
        r100.handleIntent(r101);
    }

    @Override // android.app.Service
    public int onStartCommand(final Intent r100, int r101, int r102) {
        if (Logger.debug() == false) goto L5;
        Logger.d("WsChannelService", "onStartCommand");
    L5:
        ThreadPlus.submitRunnable(new AnonymousClass1(this, r100));
        return 2;
    }
}
