package com.bytedance.common.wschannel.server;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.WsChannelSettings;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.channel.IMessageHandler;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.common.wschannel.channel.WsChannelClient;
import com.bytedance.common.wschannel.converter.MsgConverterFactory;
import com.bytedance.common.wschannel.log.WsChannelLog;
import com.bytedance.common.wschannel.model.IntegerParcelable;
import com.bytedance.common.wschannel.model.ServiceParcelable;
import com.bytedance.common.wschannel.model.SocketState;
import com.bytedance.common.wschannel.model.SsWsApp;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
public class ChannelManager implements WeakHandler.IHandler, IEnableObserver.OnWsChannelEnableChangedObserver {
    private final ChannelKeeper mChannelKeeper;
    private final IWsChannelSaver mChannelSaver;
    private final Context mContext;
    private AtomicLong mCounter;
    private boolean mIsForeground;
    private final Object mLock;
    private final IMessageHandler mMessageHandler;
    private final WeakHandler mThreadHandler;
    private IEnableObserver mWsChannelEnableObserver;

    private boolean isEnable() {
        return this.mWsChannelEnableObserver.isEnable();
    }

    private boolean isEnableOfflineDetect() {
        Context r100 = this.mContext;
        if (r100 != null) goto L5;
        return false;
    L5:
        WsChannelSettings r101 = WsChannelSettings.inst(r100);
        if (r101 != null) goto L9;
        return false;
    L9:
        return r101.isEnableOfflineDetect();
    }

    private void stopAllSocket() {
        Object r100 = this.mLock;     // Catch: Throwable -> L17
        monitor-enter(r100);     // Catch: Throwable -> L17
        Iterator<Map.Entry<Integer, IWsChannelClient>> r101 = this.mChannelKeeper.mWsChannelClientMap.entrySet().iterator();     // Catch: Throwable -> L14
    L6:
        if (r101.hasNext() == false) goto L10;
        IWsChannelClient r102 = r101.next().getValue();     // Catch: Throwable -> L14
        if (r102 == null) goto L6;
        r102.destroy();     // Catch: Throwable -> L14
        goto L6
    L10:
        this.mChannelKeeper.mWsChannelClientMap.clear();     // Catch: Throwable -> L14
        monitor-exit(r100);     // Catch: Throwable -> L14
        this.mChannelKeeper.mWsAppMap.clear();     // Catch: Throwable -> L17
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        th.printStackTrace();
    }

    public WsChannelMsg createStateChangedMsg() {
        WsChannelMsg.Builder r100 = WsChannelMsg.Builder.create(Integer.MAX_VALUE).setMethod(4).setService(9000).setLogId(1008601).setPayload(new byte[0]).setPayloadEncoding("pb").setPayloadType("pb");
        if (isForeground() == false) goto L5;
        String r101 = "0";
    L7:
        return r100.addMsgHeader("IsBackground", r101).build();
    L5:
        r101 = "1";
        goto L7
    }

    private boolean isForeground() {
        return this.mIsForeground;
    }

    public static /* synthetic */ IWsChannelSaver access$000(ChannelManager r100) {
        return r100.mChannelSaver;
    }

    public static /* synthetic */ IEnableObserver access$200(ChannelManager r100) {
        return r100.mWsChannelEnableObserver;
    }

    private void doHandleMsg(Message r110) {
        int r100 = r110.what;     // Catch: Throwable -> L134
        if (r100 == 0) goto L130;
        boolean r101 = true;
        if (r100 == 1) goto L107;
        boolean r102 = false;
        if (r100 != 2) goto L10;
        int r111 = r110.arg1;     // Catch: Throwable -> L134
        if (Logger.debug() == false) goto L96;
        Logger.d("WsChannelService", "appState = " + r111);     // Catch: Throwable -> L134
    L96:
        if (r111 == 1) goto L99;
        r101 = false;
    L99:
        this.mIsForeground = r101;     // Catch: Throwable -> L134
        this.mMessageHandler.tryResendMsg();     // Catch: Throwable -> L134
        if (isEnable() == false) goto L166;
        sendAppStateChangeEvent(this.mChannelKeeper.mWsChannelClientMap.values());     // Catch: Throwable -> L134
        Iterator<IWsChannelClient> r103 = this.mChannelKeeper.mWsChannelClientMap.values().iterator();     // Catch: Throwable -> L134
    L103:
        if (r103.hasNext() == false) goto L172;
        IWsChannelClient r104 = r103.next();     // Catch: Throwable -> L134
        if (r104 == null) goto L103;
        r104.onAppStateChanged(r111);     // Catch: Throwable -> L134
        goto L103
    L172:
        return;
    L166:
        return;
    L10:
        if (r100 != 3) goto L12;
        int r112 = r110.arg1;     // Catch: Throwable -> L134
        if (Logger.debug() == false) goto L85;
        Logger.d("WsChannelService", "networkState = " + r112);     // Catch: Throwable -> L134
    L85:
        this.mMessageHandler.tryResendMsg();     // Catch: Throwable -> L134
        if (isEnable() == false) goto L165;
        Iterator<IWsChannelClient> r105 = this.mChannelKeeper.mWsChannelClientMap.values().iterator();     // Catch: Throwable -> L134
    L89:
        if (r105.hasNext() == false) goto L171;
        IWsChannelClient r106 = r105.next();     // Catch: Throwable -> L134
        if (r106 == null) goto L89;
        r106.onNetworkStateChanged(r112);     // Catch: Throwable -> L134
        goto L89
    L171:
        return;
    L165:
        return;
    L12:
        if (r100 != 4) goto L14;
        r110.getData().setClassLoader(SsWsApp.class.getClassLoader());     // Catch: Throwable -> L134
        Parcelable r113 = r110.getData().getParcelable(WsConstants.KEY_WS_APP);     // Catch: Throwable -> L134
        if ((r113 instanceof IWsApp) == false) goto L163;
        doOnParamChange((IWsApp) r113);     // Catch: Throwable -> L134
        return;
    L163:
        return;
    L14:
        if (r100 != 5) goto L16;
    L40:
        if (r100 == 10) goto L43;
        r101 = false;
    L43:
        r110.getData().setClassLoader(WsChannelMsg.class.getClassLoader());     // Catch: Throwable -> L134
        Parcelable r107 = r110.getData().getParcelable(WsConstants.KEY_PAYLOAD);     // Catch: Throwable -> L134
        if ((r107 instanceof WsChannelMsg) == false) goto L160;
        WsChannelMsg r108 = (WsChannelMsg) r107;     // Catch: Throwable -> L134
        if (r108.getSeqId() > 0) goto L48;
        r108.setSeqId(this.mCounter.incrementAndGet());     // Catch: Throwable -> L134
    L48:
        IWsChannelClient r109 = this.mChannelKeeper.mWsChannelClientMap.get(Integer.valueOf(r108.getChannelId()));     // Catch: Throwable -> L134
        if (r101 == false) goto L51;
        Logger.d("WsChannelService", "retry send msg");     // Catch: Throwable -> L134
    L51:
        if (r109 == null) goto L75;
        if (r100 == 10) goto L59;
        if ((r109 instanceof WsChannelClient) == false) goto L59;
        if (((WsChannelClient) r109).isOkChannelImpl() == false) goto L59;
        r108 = tryAddOkWsPayloadOpaque(r109, r108);     // Catch: Throwable -> L134
    L59:
        if (r109.privateProtocolEnabled() == true) goto L61;
    L63:
        boolean r114 = r109.sendMessage(MsgConverterFactory.getConverter().encode(r108));     // Catch: Throwable -> L134
    L64:
        r102 = r114;
        long r115 = WsChannelSettings.inst(this.mContext).getRetryDelay();     // Catch: Throwable -> L134
        if (r102 == true) goto L70;
        if (r101 == true) goto L70;
        if (r115 <= 0) goto L70;
        Message r116 = Message.obtain(r110);     // Catch: Throwable -> L134
        r116.what = 10;     // Catch: Throwable -> L134
        this.mThreadHandler.sendMessageDelayed(r116, r115);     // Catch: Throwable -> L134
    L70:
        if (r102 == false) goto L72;
    L74:
        this.mMessageHandler.replySendMsgResult(r108, r102);     // Catch: Throwable -> L134
    L77:
        if (Logger.debug() == false) goto L161;
        Logger.d("WsChannelService", "send payload success = " + r102);     // Catch: Throwable -> L134
        return;
    L161:
        return;
    L72:
        if (r115 <= 0) goto L74;
        if (r101 == false) goto L77;
    L61:
        if (r109.privateProtocolProxyEnabled() == true) goto L63;
        r114 = r109.sendMessage(r108);     // Catch: Throwable -> L134
        goto L64
    L75:
        this.mMessageHandler.replySendMsgResult(r108, false);     // Catch: Throwable -> L134
        goto L77
    L160:
        return;
    L16:
        if (r100 == 9) goto L39;
        if (r100 == 10) goto L40;
        if (r100 != 12) goto L21;
        r110.getData().setClassLoader(ServiceParcelable.class.getClassLoader());     // Catch: Throwable -> L134
        Parcelable r117 = r110.getData().getParcelable(WsConstants.KEY_WS_APP);     // Catch: Throwable -> L134
        if ((r117 instanceof ServiceParcelable) == false) goto L156;
        int r118 = ((ServiceParcelable) r117).getChannelId();     // Catch: Throwable -> L134
        int r119 = ((ServiceParcelable) r117).getServiceId();     // Catch: Throwable -> L134
        IWsChannelClient r120 = this.mChannelKeeper.mWsChannelClientMap.get(Integer.valueOf(r118));     // Catch: Throwable -> L134
        if (r120 != null) goto L36;
        return;
    L36:
        if (Logger.debug() == false) goto L38;
        Logger.d("WsChannelService", "register serviceId = " + r119);     // Catch: Throwable -> L134
    L38:
        r120.registerService(r119);     // Catch: Throwable -> L134
        return;
    L156:
        return;
    L21:
        if (r100 != 13) goto L152;
        r110.getData().setClassLoader(ServiceParcelable.class.getClassLoader());     // Catch: Throwable -> L134
        Parcelable r121 = r110.getData().getParcelable(WsConstants.KEY_WS_APP);     // Catch: Throwable -> L134
        if ((r121 instanceof ServiceParcelable) == false) goto L153;
        int r122 = ((ServiceParcelable) r121).getChannelId();     // Catch: Throwable -> L134
        int r123 = ((ServiceParcelable) r121).getServiceId();     // Catch: Throwable -> L134
        IWsChannelClient r124 = this.mChannelKeeper.mWsChannelClientMap.get(Integer.valueOf(r122));     // Catch: Throwable -> L134
        if (r124 != null) goto L28;
        return;
    L28:
        if (Logger.debug() == false) goto L30;
        Logger.d("WsChannelService", "unregister serviceId = " + r123);     // Catch: Throwable -> L134
    L30:
        r124.unregisterService(r123);     // Catch: Throwable -> L134
        return;
    L153:
        return;
    L152:
        return;
    L39:
        this.mMessageHandler.syncSocketState();     // Catch: Throwable -> L134
        return;
    L107:
        r110.getData().setClassLoader(SsWsApp.class.getClassLoader());     // Catch: Throwable -> L134
        Parcelable r125 = r110.getData().getParcelable(WsConstants.KEY_WS_APP);     // Catch: Throwable -> L134
        if ((r125 instanceof IntegerParcelable) == false) goto L167;
        int r126 = ((IntegerParcelable) r125).getData();     // Catch: Throwable -> L134
        monitor-enter(WsChannelService.class);     // Catch: Throwable -> L134
        this.mChannelKeeper.mWsAppMap.remove(Integer.valueOf(r126));     // Catch: Throwable -> L127
        this.mChannelSaver.saveWsChannels(this.mChannelKeeper.mWsAppMap);     // Catch: Throwable -> L127
        monitor-exit(WsChannelService.class);     // Catch: Throwable -> L127
        Object r127 = this.mLock;     // Catch: Throwable -> L134
        monitor-enter(r127);     // Catch: Throwable -> L134
        IWsChannelClient r128 = this.mChannelKeeper.mWsChannelClientMap.remove(Integer.valueOf(r126));     // Catch: Throwable -> L124
        monitor-exit(r127);     // Catch: Throwable -> L124
        if (r128 != null) goto L119;
    L122:
        this.mChannelKeeper.mChannelState.remove(Integer.valueOf(r126));     // Catch: Throwable -> L134
        this.mThreadHandler.sendMessageDelayed(this.mThreadHandler.obtainMessage(8, r128), 1000);     // Catch: Throwable -> L134
        return;
    L119:
        if (Logger.debug() == false) goto L121;
        Logger.d("WsChannelService", "stopConnection,channelId = " + r126);     // Catch: Throwable -> L134
    L121:
        r128.destroy();     // Catch: Throwable -> L134
        goto L122
    L124:
        th = move-exception;
        throw th;     // Catch: Throwable -> L134
    L127:
        th = move-exception;
        throw th;     // Catch: Throwable -> L134
    L167:
        return;
    L130:
        r110.getData().setClassLoader(SsWsApp.class.getClassLoader());     // Catch: Throwable -> L134
        Parcelable r129 = r110.getData().getParcelable(WsConstants.KEY_WS_APP);     // Catch: Throwable -> L134
        if ((r129 instanceof IWsApp) == false) goto L168;
        doRegisterChannel((IWsApp) r129);     // Catch: Throwable -> L134
        return;
    L168:
        return;
    L134:
        th = move-exception;
        th.printStackTrace();
    }

    private void doOnParamChange(IWsApp r100) {
        if (Logger.debug() == false) goto L5;
        Logger.d("WsChannelService", "doOnParamChange");
    L5:
        int r101 = WsChannelService.getClientKey(r100);
        if (isEnable() == false) goto L33;
        IWsChannelClient r102 = this.mChannelKeeper.mWsChannelClientMap.get(Integer.valueOf(r100.getChannelId()));     // Catch: Throwable -> L28
        monitor-enter(WsChannelService.class);     // Catch: Throwable -> L28
        IWsApp r103 = this.mChannelKeeper.mWsAppMap.get(Integer.valueOf(r101));     // Catch: Throwable -> L25
        if (r102 != null) goto L12;
    L23:
        monitor-exit(WsChannelService.class);     // Catch: Throwable -> L25
        return;
    L12:
        if (r100.equals(r103) == true) goto L14;
    L16:
        this.mChannelKeeper.mWsAppMap.put(Integer.valueOf(r101), r100);     // Catch: Throwable -> L25
        this.mChannelSaver.saveWsChannels(this.mChannelKeeper.mWsAppMap);     // Catch: Throwable -> L25
        monitor-exit(WsChannelService.class);     // Catch: Throwable -> L25
        Map<String, Object> r104 = getConfigMap(r100);     // Catch: Throwable -> L28
        if (r104 == null) goto L22;
        r102.onParameterChange(r104, r100.getConnectUrls());     // Catch: Throwable -> L28
        return;
    L22:
        throw new IllegalArgumentException("configMap is empty !!!");     // Catch: Throwable -> L28
    L14:
        if (r102.isConnected() == false) goto L16;
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    private void doRegisterChannel(IWsApp r100) {
        int r101 = WsChannelService.getClientKey(r100);
        if (isEnable() == true) goto L6;
        return;
    L6:
        monitor-enter(WsChannelService.class);
        IWsApp r102 = this.mChannelKeeper.mWsAppMap.get(Integer.valueOf(r101));     // Catch: Throwable -> L22
        IWsChannelClient r103 = this.mChannelKeeper.mWsChannelClientMap.get(Integer.valueOf(r101));     // Catch: Throwable -> L22
        boolean r104 = false;
        boolean r105 = true;
        if (r102 != null) goto L10;
    L14:
        if (r102 != null) goto L16;
        this.mChannelKeeper.mWsAppMap.put(Integer.valueOf(r101), r100);     // Catch: Throwable -> L22
        this.mChannelSaver.saveWsChannels(this.mChannelKeeper.mWsAppMap);     // Catch: Throwable -> L22
    L12:
        r104 = true;
    L13:
        r105 = false;
    L16:
        monitor-exit(WsChannelService.class);     // Catch: Throwable -> L22
        if (r104 == false) goto L19;
        tryOpenConnection(r100);
        return;
    L19:
        if (r105 == false) goto L28;
        doOnParamChange(r100);
        return;
    L28:
        return;
    L10:
        if (r100.equals(r102) == false) goto L14;
        if (r103 != null) goto L13;
    L22:
        th = move-exception;
        throw th;
    }

    private Map<String, Object> getConfigMap(IWsApp r110) {
        HashMap r100 = new HashMap();
        r100.put("app_key", r110.getAppKey());
        r100.put(WsConstants.KEY_FPID, Integer.valueOf(r110.getFPID()));
        r100.put("sdk_version", 2);
        r100.put("platform", 0);
        r100.put("app_version", Integer.valueOf(r110.getAppVersion()));
        r100.put("aid", Integer.valueOf(r110.getAppId()));
        r100.put("device_id", r110.getDeviceId());
        r100.put(WsConstants.KEY_INSTALL_ID, r110.getInstallId());
        r100.put(WsConstants.KEY_HEADERS, r110.getHeaders());
        String r101 = r110.getExtra();
        if (r101 != null) goto L6;
        onNullParamLog("extra");
        r101 = "";
    L6:
        if (WsChannelSettings.inst(this.mContext).isReportAppStateEnable() == false) goto L17;
        String[] r102 = r101.split("&");
        if (isForeground() == false) goto L10;
        String r103 = "0";
    L11:
        String r104 = "is_background=".concat(r103);
        if (r102.length > 0) goto L14;
    L16:
        r101 = r104;
        goto L17
    L14:
        if (TextUtils.isEmpty(r102[0]) == true) goto L16;
        r101 = r101 + "&" + r104;
        goto L17
    L10:
        r103 = "1";
    L17:
        r100.put("extra", r101);
        if (r110.getDeviceId() != null) goto L21;
        onNullParamLog("device_id");
    L21:
        if (r110.getInstallId() != null) goto L24;
        onNullParamLog("install_id");
    L24:
        if (StringUtils.isEmpty(r110.getAppKey()) == false) goto L26;
        onNullParamLog("app_key");
    L26:
        r100.put(WsConstants.KEY_PRIVATE_PROTOCOL_ENABLE, Boolean.valueOf(r110.newPrivateProtocolEnabled()));
        if (r110.getServiceIdList() == null) goto L30;
        r100.put(WsConstants.KEY_SERVICE_ID_LIST, r110.getServiceIdList());
    L30:
        if (TextUtils.isEmpty(r110.getPrivateProtocolUrl()) == true) goto L32;
        r100.put(WsConstants.KEY_PRIVATE_PROTOCOL_URL, r110.getPrivateProtocolUrl());
    L32:
        r100.put(WsConstants.KEY_TRANSPORT_MODE, Integer.valueOf(r110.getTransportMode()));
        r100.put(WsConstants.KEY_DISABLE_FALLBACK_WEBSOCKET, Boolean.valueOf(r110.disableFallbackWSEnabled()));
        return r100;
    }

    private void onNullParamLog(String r100) {
        Bundle r101 = new Bundle();
        r101.putString("param_name", r100);
        WsChannelLog.onEventV3Bundle(this.mContext, "wschannel_param_null", r101);
    }

    private void runOnHandlerThread(Runnable r100) {
        this.mThreadHandler.post(r100);
    }

    private void sendAppStateChangeEvent(Collection<IWsChannelClient> r100) {
        if (WsChannelSettings.inst(this.mContext).isReportAppStateEnable() == true) goto L5;
        return;
    L5:
        Iterator<IWsChannelClient> r101 = r100.iterator();
    L7:
        if (r101.hasNext() == false) goto L13;
        sendAppStateChangeMessage(r101.next());     // Catch: Exception -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    private void sendAppStateChangeMessage(IWsChannelClient r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        WsChannelMsg r101 = createStateChangedMsg();
        if (r100.privateProtocolEnabled() == false) goto L8;
        r100.sendMessage(r101);
        return;
    L8:
        r100.sendMessage(MsgConverterFactory.getConverter().encode(r101));
    }

    private void tryConnectIfEnable(Map<Integer, IWsApp> r100) {
        if (isEnableOfflineDetect() == false) goto L8;
        if (NetworkUtils.isNetworkAvailable(this.mContext) == true) goto L8;
        return;
    L8:
        if (this.mWsChannelEnableObserver.isEnable() == false) goto L17;
        if (r100 == null) goto L23;
        Iterator<IWsApp> r101 = r100.values().iterator();
    L12:
        if (r101.hasNext() == false) goto L24;
        IWsApp r102 = r101.next();
        if (r102 == null) goto L12;
        doRegisterChannel(r102);
        goto L12
    L24:
        return;
    L23:
        return;
    }

    private void tryOpenConnection(IWsApp r100) {
        if (Logger.debug() == false) goto L5;
        Logger.d("WsChannelService", "tryOpenConnection");
    L5:
        Object r101 = this.mLock;
        monitor-enter(r101);
        IWsChannelClient r102 = this.mChannelKeeper.mWsChannelClientMap.get(Integer.valueOf(r100.getChannelId()));     // Catch: Throwable -> L28
        if (r102 != null) goto L10;
        r102 = WsChannelClient.newInstance(r100.getChannelId(), this.mMessageHandler, this.mThreadHandler);     // Catch: Throwable -> L28
        r102.init(this.mContext, r102);     // Catch: Throwable -> L28
        this.mChannelKeeper.mWsChannelClientMap.put(Integer.valueOf(r100.getChannelId()), r102);     // Catch: Throwable -> L28
    L10:
        monitor-exit(r101);     // Catch: Throwable -> L28
        if (r102.isConnected() == false) goto L36;
        SocketState r103 = this.mChannelKeeper.mChannelState.get(Integer.valueOf(r100.getChannelId()));
        Logger.d("WsChannelService", "state = " + r103);
        if (r103 == null) goto L37;
        this.mMessageHandler.onConnection(r102, r103);     // Catch: Throwable -> L31
        return;
    L40:
        return;
    L37:
        return;
    L36:
    L25:
        th = move-exception;
        th.printStackTrace();
        return;
    L18:
        if (Logger.debug() == false) goto L20;
        Logger.d("WsChannelService", "try to open connection ,channelId = " + r100.getChannelId());     // Catch: Throwable -> L25
    L20:
        Map<String, Object> r104 = getConfigMap(r100);     // Catch: Throwable -> L25
        if (r104 == null) goto L24;
        r102.openConnection(r104, r100.getConnectUrls());     // Catch: Throwable -> L25
        return;
    L24:
        throw new IllegalArgumentException("configMap is empty !!!");     // Catch: Throwable -> L25
    L28:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r100) {
        final Message r101 = Message.obtain(r100);
        runOnHandlerThread(new AnonymousClass2(this, r101));
    }

    @Override // com.bytedance.common.wschannel.server.IEnableObserver.OnWsChannelEnableChangedObserver
    public void onWsChannelEnableChange(boolean r100) {
        if (r100 == false) goto L4;
        tryConnectIfEnable(this.mChannelSaver.loadWsChannels());
        return;
    L4:
        stopAllSocket();
    }

    public void syncCurrentState(final IWsChannelClient r100) {
        if (r100.isConnected() == true) goto L5;
        return;
    L5:
        this.mThreadHandler.post(new AnonymousClass3(this, r100));
    }

    public static /* synthetic */ void access$100(ChannelManager r100, Map r101) {
        r100.tryConnectIfEnable(r101);
    }

    public static /* synthetic */ void access$300(ChannelManager r100, Message r101) {
        r100.doHandleMsg(r101);
    }

    public static /* synthetic */ void access$400(ChannelManager r100, IWsChannelClient r101) {
        r100.sendAppStateChangeMessage(r101);
    }

    public WsChannelMsg tryAddOkWsPayloadOpaque(IWsChannelClient r100, WsChannelMsg r101) {
        WsChannelSettings.getOkOpaqueCallback();
        return r101;
    }

    public ChannelManager(Context r100, Looper r101, IWsChannelSaver r102, ChannelKeeper r103, IMessageHandler r104, final IEnableObserver r105) {
        this.mLock = new Object();
        this.mCounter = new AtomicLong(0);
        this.mIsForeground = false;
        this.mContext = r100.getApplicationContext();
        this.mThreadHandler = new WeakHandler(r101, this);
        this.mChannelSaver = r102;
        this.mChannelKeeper = r103;
        this.mMessageHandler = r104;
        this.mWsChannelEnableObserver = r105;
        r105.setEnableListener(this);
        runOnHandlerThread(new AnonymousClass1(this, r105));
    }
}
