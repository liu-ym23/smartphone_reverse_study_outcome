package com.bytedance.common.wschannel.client;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.SocketHandler;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.model.ClientServiceTrace;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.common.wschannel.utils.TimeCompactUtil;

/* JADX INFO: loaded from: classes15.dex */
public abstract class AbsWsClientService extends Service implements WeakHandler.IHandler, ClientMsgParser.ParserListener {
    private final Handler mHandler;
    private Messenger mMessenger;
    private final ClientMsgParser parser;

    @Override // com.bytedance.common.wschannel.client.ClientMsgParser.ParserListener
    public void onReceive(WsChannelMsg r100) {
    }

    @Override // com.bytedance.common.wschannel.client.ClientMsgParser.ParserListener
    public void onSendResult(String r100, boolean r101) {
    }

    public AbsWsClientService() {
        this.mHandler = new WeakHandler(this);
        this.parser = new ClientMsgParser(this);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mMessenger = new Messenger(this.mHandler);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (Logger.debug() == false) goto L6;
        Logger.d("AbsWsClientService", LiveCommonConstants.REASON_ON_DEDTROY);
        return;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r100) {
        final long r101 = TimeCompactUtil.getTimeStampNanos();     // Catch: Exception -> L15
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.what != 10123) goto L20;
        final Intent r102 = (Intent) r100.getData().getParcelable(WsConstants.DATA_INTENT);     // Catch: Exception -> L15
        if (Logger.debug() == false) goto L11;
        Logger.d("AbsWsClientService", "handleMsg = " + r102);     // Catch: Exception -> L15
    L11:
        if (r102 == null) goto L13;
        SocketHandler.inst().postRunnable(new AnonymousClass2(this, r102, r101));     // Catch: Exception -> L15
        return;
    L13:
        Logger.e("AbsWsClientService", "handleMsg but intent isnull");     // Catch: Exception -> L15
        return;
    L20:
        return;
    L15:
        e = move-exception;
        Logger.e(e.toString());
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r100) {
        return this.mMessenger.getBinder();
    }

    private void handleIntent(Intent r100, long r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        ClientServiceTrace r102 = new ClientServiceTrace(r101);
        this.parser.parse(r100, r102);
    }

    public static /* synthetic */ void access$000(AbsWsClientService r100, Intent r101, long r102) {
        r100.handleIntent(r101, r102);
    }

    @Override // android.app.Service
    public int onStartCommand(final Intent r100, int r101, int r102) {
        if (Logger.debug() == false) goto L9;
        StringBuilder r103 = new StringBuilder("onStartCommand intent = ");
        if (r100 == null) goto L7;
        String r104 = r100.toString();
    L8:
        r103.append(r104);
        Logger.d("AbsWsClientService", r103.toString());
        goto L9
    L7:
        r104 = "null";
    L9:
        final long r105 = TimeCompactUtil.getTimeStampNanos();
        SocketHandler.inst().postRunnable(new AnonymousClass1(this, r100, r105));
        return 2;
    }
}
