package com.bytedance.common.wschannel.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.os.SystemClock;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.common.wschannel.WsChannelSettings;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.model.IntegerParcelable;
import com.bytedance.common.wschannel.model.ServiceParcelable;
import com.bytedance.common.wschannel.model.SsWsApp;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.common.wschannel.server.WsChannelService;
import java.lang.ref.WeakReference;
import java.util.concurrent.LinkedBlockingDeque;

/* JADX INFO: loaded from: classes3.dex */
public class WsChannelMultiProcessImpl implements WsChannelApi {
    private static boolean mAsync;
    private long bindServiceConnectedTime;
    private long bindServiceStartTime;
    private final Runnable checkConnectionRunnable;
    private final LinkedBlockingDeque<WsChannelApi.ServiceHolder> mServiceHolderQueue;
    private WeakReference<Context> sContextRef;
    Messenger service;
    ServiceConnection serviceConnection;

    /* JADX INFO: loaded from: classes15.dex */
    public class MessengerServiceConnection implements ServiceConnection {
        final /* synthetic */ WsChannelMultiProcessImpl this$0;

        public MessengerServiceConnection(WsChannelMultiProcessImpl r100) {
            this.this$0 = r100;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r100) {
            if (r100 != null) goto L5;
            return;
        L5:
            if (Logger.debug() == false) goto L13;
            Logger.d("WsChannelSdk", "onServiceDisconnected name = " + r100.toString());
        L13:
            WsChannelMultiProcessImpl r101 = this.this$0;     // Catch: Throwable -> L9
            r101.service = null;     // Catch: Throwable -> L9
            WsChannelMultiProcessImpl.access$300(r101).clear();     // Catch: Throwable -> L9
            WsChannelMultiProcessImpl.access$500(this.this$0, r100);     // Catch: Throwable -> L9
        L11:
            WsChannelMultiProcessImpl.access$100(this.this$0, 2, SystemClock.uptimeMillis() - WsChannelMultiProcessImpl.access$600(this.this$0));
            return;
        L9:
            th = move-exception;
            th.printStackTrace();
            goto L11
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(final ComponentName r100, IBinder r101) {
            if (r100 == null) goto L18;
            if (r101 != null) goto L6;
            return;
        L6:
            if (Logger.debug() == false) goto L17;
            Logger.d("WsChannelSdk", "onServiceConnected name = " + r100.toString() + ", " + WsChannelMultiProcessImpl.access$700());
        L17:
            this.this$0.service = new Messenger(r101);     // Catch: Throwable -> L13
            if (WsChannelMultiProcessImpl.access$700() == false) goto L11;
            ThreadPlus.submitRunnable(new AnonymousClass1(this, r100));     // Catch: Throwable -> L13
        L15:
            WsChannelMultiProcessImpl.access$602(this.this$0, SystemClock.uptimeMillis());
            WsChannelMultiProcessImpl.access$100(this.this$0, 0, SystemClock.uptimeMillis() - WsChannelMultiProcessImpl.access$000(this.this$0));
            return;
        L11:
            WsChannelMultiProcessImpl.access$400(this.this$0, r100);     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            th.printStackTrace();
            goto L15
        }
    }

    public WsChannelMultiProcessImpl() {
        this.checkConnectionRunnable = new AnonymousClass1(this);
        this.bindServiceStartTime = 0;
        this.bindServiceConnectedTime = 0;
        this.mServiceHolderQueue = new LinkedBlockingDeque();
    }

    private void startConnectCheckTimeout() {
        this.bindServiceStartTime = SystemClock.uptimeMillis();
        WsConstants.getBindWsChannelServiceListener();
    }

    public static /* synthetic */ boolean access$700() {
        return mAsync;
    }

    public static /* synthetic */ long access$000(WsChannelMultiProcessImpl r100) {
        return r100.bindServiceStartTime;
    }

    public static /* synthetic */ WeakReference access$200(WsChannelMultiProcessImpl r100) {
        return r100.sContextRef;
    }

    public static /* synthetic */ LinkedBlockingDeque access$300(WsChannelMultiProcessImpl r100) {
        return r100.mServiceHolderQueue;
    }

    public static /* synthetic */ long access$600(WsChannelMultiProcessImpl r100) {
        return r100.bindServiceConnectedTime;
    }

    private synchronized void bindOrSendMsg(ComponentName r100) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.service != null) goto L6;
        doBindService(r100);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L6:
        onServiceConnected(r100);     // Catch: Throwable -> L9
        goto L7
    }

    private void doBindService(ComponentName r100) {
        WeakReference<Context> r101 = this.sContextRef;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.get() == null) goto L24;
        Context r102 = r101.get();
        if (Logger.debug() == false) goto L10;
        Logger.d("WsChannelSdk", "doBindService");
    L10:
        if (r100 != null) goto L21;
        return;
    L21:
        Intent r103 = new Intent();     // Catch: Throwable -> L18
        r103.setComponent(r100);     // Catch: Throwable -> L18
        r102.startService(r103);     // Catch: Throwable -> L18
    L19:
        Intent r104 = new Intent();     // Catch: Throwable -> L15
        r104.setComponent(r100);     // Catch: Throwable -> L15
        MessengerServiceConnection r105 = new MessengerServiceConnection(this);     // Catch: Throwable -> L15
        this.serviceConnection = r105;     // Catch: Throwable -> L15
        startConnectCheckTimeout();     // Catch: Throwable -> L15
        r102.bindService(r104, r105, 1);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    private void onServiceConnected(ComponentName r100) {
        if (r100 != null) goto L17;
        return;
    L17:
        if (this.mServiceHolderQueue.peek() == null) goto L27;
        WsChannelApi.ServiceHolder r101 = this.mServiceHolderQueue.poll();     // Catch: Throwable -> L16
        if (r101 == null) goto L8;
        Message r102 = new Message();     // Catch: Throwable -> L16
        r102.what = r101.what;     // Catch: Throwable -> L16
        r102.getData().putParcelable(r101.key, r101.obj);     // Catch: Throwable -> L16
        sendMsg(r100, r102);     // Catch: Throwable -> L12 DeadObjectException -> L14
    L14:
        this.service = null;     // Catch: Throwable -> L16
        this.mServiceHolderQueue.offerFirst(r101);     // Catch: Throwable -> L16
        onReportServiceConnect(3, SystemClock.uptimeMillis() - this.bindServiceConnectedTime);     // Catch: Throwable -> L16
        return;
    L12:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L16
        goto L17
    L8:
        return;
    L27:
        return;
    }

    private synchronized void onServiceDisconnected(ComponentName r100) {
        monitor-enter(this);
        monitor-exit(this);
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void onEnterToBackground(Context r100) {
        sendAppState(r100, 2);
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void onEnterToForeground(Context r100) {
        sendAppState(r100, 1);
    }

    public static /* synthetic */ WeakReference access$202(WsChannelMultiProcessImpl r100, WeakReference r101) {
        r100.sContextRef = r101;
        return r101;
    }

    public static /* synthetic */ void access$400(WsChannelMultiProcessImpl r100, ComponentName r101) {
        r100.bindOrSendMsg(r101);
    }

    public static /* synthetic */ void access$500(WsChannelMultiProcessImpl r100, ComponentName r101) {
        r100.onServiceDisconnected(r101);
    }

    public static /* synthetic */ long access$602(WsChannelMultiProcessImpl r100, long r101) {
        r100.bindServiceConnectedTime = r101;
        return r101;
    }

    private void onReportServiceConnect(int r100, long r101) {
        WsConstants.getBindWsChannelServiceListener();
    }

    private void register(Context r100, IWsApp r101) {
        if (r100 == null) goto L23;
        if (r101 == null) goto L24;
        WeakReference<Context> r102 = this.sContextRef;
        if (r102 != null) goto L8;
    L9:
        this.sContextRef = new WeakReference(r100.getApplicationContext());
    L11:
        if (Logger.debug() == false) goto L14;
        Logger.d("WsChannelSdk", "register wsApp = " + r101.toString());
    L14:
        if (WsChannelSettings.inst(r100).isEnable() == true) goto L21;
        return;
    L21:
        ComponentName r103 = new ComponentName(r100, WsChannelService.class);     // Catch: Throwable -> L18
        WsChannelApi.ServiceHolder r104 = new WsChannelApi.ServiceHolder();     // Catch: Throwable -> L18
        r104.key = WsConstants.KEY_WS_APP;     // Catch: Throwable -> L18
        r104.obj = r101;     // Catch: Throwable -> L18
        r104.what = 0;     // Catch: Throwable -> L18
        this.mServiceHolderQueue.offer(r104);     // Catch: Throwable -> L18
        bindOrSendMsg(r103);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        th.printStackTrace();
        return;
    L8:
        if (r102.get() != null) goto L11;
    L24:
        return;
    }

    private void sendAppState(final Context r100, final int r101) {
        if (r100 == null) goto L20;
        if (r101 > 0) goto L5;
        return;
    L5:
        if (r101 > 3) goto L22;
        WeakReference<Context> r102 = this.sContextRef;
        if (r102 != null) goto L10;
    L11:
        this.sContextRef = new WeakReference(r100.getApplicationContext());
    L13:
        if (Logger.debug() == false) goto L16;
        Logger.d("WsChannelSdk", "sendAppState appState = " + r101);
    L16:
        if (WsChannelSettings.inst(r100).isEnable() == true) goto L18;
        return;
    L18:
        ThreadPlus.submitRunnable(new AnonymousClass4(this, r100, r101));
        return;
    L10:
        if (r102.get() != null) goto L13;
    L22:
        return;
    }

    private void sendMsg(ComponentName r100, Message r101) throws RemoteException {
        if (r100 != null) goto L5;
        return;
    L5:
        if (Logger.debug() == false) goto L7;
        Logger.d("WsChannelSdk", "sendMsg msg = " + r101.toString() + " , + what = " + r101.what);
    L7:
        Messenger r102 = this.service;
        if (r102 != null) goto L10;
        return;
    L10:
        r102.send(r101);
    }

    private void sendParameterChange(Context r100, IWsApp r101) {
        if (r100 == null) goto L23;
        if (r101 == null) goto L24;
        WeakReference<Context> r102 = this.sContextRef;
        if (r102 != null) goto L8;
    L9:
        this.sContextRef = new WeakReference(r100.getApplicationContext());
    L11:
        if (Logger.debug() == false) goto L14;
        Logger.d("WsChannelSdk", "sendParameterChange wsApp = " + r101.toString());
    L14:
        if (WsChannelSettings.inst(r100).isEnable() == true) goto L21;
        return;
    L21:
        ComponentName r103 = new ComponentName(r100, WsChannelService.class);     // Catch: Throwable -> L18
        WsChannelApi.ServiceHolder r104 = new WsChannelApi.ServiceHolder();     // Catch: Throwable -> L18
        r104.key = WsConstants.KEY_WS_APP;     // Catch: Throwable -> L18
        r104.obj = r101;     // Catch: Throwable -> L18
        r104.what = 4;     // Catch: Throwable -> L18
        this.mServiceHolderQueue.offer(r104);     // Catch: Throwable -> L18
        bindOrSendMsg(r103);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        th.printStackTrace();
        return;
    L8:
        if (r102.get() != null) goto L11;
    L24:
        return;
    }

    private void startPushProcess(final Context r100, final boolean r101) {
        ThreadPlus.submitRunnable(new AnonymousClass3(this, r100, r101));
    }

    private void unregister(Context r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        WeakReference<Context> r102 = this.sContextRef;
        if (r102 != null) goto L7;
    L8:
        this.sContextRef = new WeakReference(r100.getApplicationContext());
    L10:
        if (Logger.debug() == false) goto L17;
        Logger.d("WsChannelSdk", "unregister channelId = " + r101);
    L17:
        ComponentName r103 = new ComponentName(r100, WsChannelService.class);     // Catch: Throwable -> L14
        WsChannelApi.ServiceHolder r104 = new WsChannelApi.ServiceHolder();     // Catch: Throwable -> L14
        r104.key = WsConstants.KEY_WS_APP;     // Catch: Throwable -> L14
        r104.obj = new IntegerParcelable(r101);     // Catch: Throwable -> L14
        r104.what = 1;     // Catch: Throwable -> L14
        this.mServiceHolderQueue.offer(r104);     // Catch: Throwable -> L14
        bindOrSendMsg(r103);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        th.printStackTrace();
        return;
    L7:
        if (r102.get() != null) goto L10;
        goto L8
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void onParameterChange(Context r100, SsWsApp r101) {
        if (r100 == null) goto L18;
        if (r101 == null) goto L19;
        WeakReference<Context> r102 = this.sContextRef;
        if (r102 != null) goto L8;
    L9:
        this.sContextRef = new WeakReference(r100.getApplicationContext());
    L11:
        if (Logger.debug() == false) goto L14;
        Logger.d("WsChannelSdk", "onParameterChange" + r101.toString());
    L14:
        if (WsChannelSettings.inst(r100).isEnable() == true) goto L16;
        return;
    L16:
        sendParameterChange(r100, r101);
        return;
    L8:
        if (r102.get() != null) goto L11;
    L19:
        return;
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void onTrimMemory(final Context r100, final int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        WeakReference<Context> r102 = this.sContextRef;
        if (r102 != null) goto L7;
    L8:
        this.sContextRef = new WeakReference(r100.getApplicationContext());
    L10:
        if (Logger.debug() == false) goto L13;
        Logger.d("WsChannelSdk", "onTrimMemory level = " + r101);
    L13:
        if (WsChannelSettings.inst(r100).isEnable() == true) goto L15;
        return;
    L15:
        ThreadPlus.submitRunnable(new AnonymousClass5(this, r100, r101));
        return;
    L7:
        if (r102.get() != null) goto L10;
        goto L8
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void registerApp(Context r100, SsWsApp r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        WeakReference<Context> r102 = this.sContextRef;
        if (r102 != null) goto L7;
    L8:
        this.sContextRef = new WeakReference(r100.getApplicationContext());
    L10:
        if (WsChannelSettings.inst(r100).isEnable() == true) goto L12;
        return;
    L12:
        if (r101 == null) goto L15;
        register(r100, r101);
        return;
    L15:
        return;
    L7:
        if (r102.get() != null) goto L10;
        goto L8
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void sendPayload(Context r100, WsChannelMsg r101) {
        if (r100 == null) goto L23;
        if (r101 == null) goto L24;
        WeakReference<Context> r102 = this.sContextRef;
        if (r102 != null) goto L8;
    L9:
        this.sContextRef = new WeakReference(r100.getApplicationContext());
    L11:
        if (Logger.debug() == false) goto L14;
        Logger.d("WsChannelSdk", "sendPayload wsChannelMsg = " + r101.toString());
    L14:
        if (WsChannelSettings.inst(r100).isEnable() == true) goto L21;
        return;
    L21:
        ComponentName r103 = new ComponentName(r100, WsChannelService.class);     // Catch: Throwable -> L18
        WsChannelApi.ServiceHolder r104 = new WsChannelApi.ServiceHolder();     // Catch: Throwable -> L18
        r104.key = WsConstants.KEY_PAYLOAD;     // Catch: Throwable -> L18
        r104.obj = r101;     // Catch: Throwable -> L18
        r104.what = 5;     // Catch: Throwable -> L18
        this.mServiceHolderQueue.offer(r104);     // Catch: Throwable -> L18
        bindOrSendMsg(r103);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        th.printStackTrace();
        return;
    L8:
        if (r102.get() != null) goto L11;
    L24:
        return;
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void tryStartPushProcess(Context r100, boolean r101) {
        tryStartPushProcess(r100, r101, false);
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void unRegisterApp(Context r100, int r101) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (Logger.debug() == false) goto L7;
        Logger.d("WsChannelSdk", "unRegisterApp");
    L7:
        unregister(r100, r101);
    }

    public static /* synthetic */ void access$100(WsChannelMultiProcessImpl r100, int r101, long r102) {
        r100.onReportServiceConnect(r101, r102);
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void registerServiceId(Context r100, int r101, int r102) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (Logger.debug() == false) goto L12;
        Logger.d("WsChannelSdk", "register serviceId = " + r102);
    L12:
        ComponentName r103 = new ComponentName(r100, WsChannelService.class);     // Catch: Throwable -> L9
        WsChannelApi.ServiceHolder r104 = new WsChannelApi.ServiceHolder();     // Catch: Throwable -> L9
        r104.key = WsConstants.KEY_WS_APP;     // Catch: Throwable -> L9
        r104.obj = new ServiceParcelable(r101, r102);     // Catch: Throwable -> L9
        r104.what = 12;     // Catch: Throwable -> L9
        this.mServiceHolderQueue.offer(r104);     // Catch: Throwable -> L9
        bindOrSendMsg(r103);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void tryStartPushProcess(final Context r100, boolean r101, boolean r102) {
        if (r101 == false) goto L4;
        startPushProcess(r100, r102);
        return;
    L4:
        ThreadPlus.submitRunnable(new AnonymousClass2(this, r100));
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void unregisterServiceId(Context r100, int r101, int r102) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (Logger.debug() == false) goto L12;
        Logger.d("WsChannelSdk", "unregister serviceId = " + r102);
    L12:
        ComponentName r103 = new ComponentName(r100, WsChannelService.class);     // Catch: Throwable -> L9
        WsChannelApi.ServiceHolder r104 = new WsChannelApi.ServiceHolder();     // Catch: Throwable -> L9
        r104.key = WsConstants.KEY_WS_APP;     // Catch: Throwable -> L9
        r104.obj = new ServiceParcelable(r101, r102);     // Catch: Throwable -> L9
        r104.what = 13;     // Catch: Throwable -> L9
        this.mServiceHolderQueue.offer(r104);     // Catch: Throwable -> L9
        bindOrSendMsg(r103);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        th.printStackTrace();
    }
}
