package com.bytedance.common.wschannel;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.alipay.sdk.m.u.i;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.livesdkapi.minigame.SeiMessageConst;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.wschannel.app.OnBindWsChannelServiceListener;
import com.bytedance.common.wschannel.app.OnMessageReceiveListener;
import com.bytedance.common.wschannel.client.WsChannelApi;
import com.bytedance.common.wschannel.client.WsChannelMultiProcessImpl;
import com.bytedance.common.wschannel.heartbeat.BaseHeartBeatPolicy;
import com.bytedance.common.wschannel.heartbeat.model.IHeartBeatMeta;
import com.bytedance.common.wschannel.heartbeat.monitor.HeartBeatMonitor;
import com.bytedance.common.wschannel.model.SsWsApp;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.common.wschannel.monitor.IWsSdkMonitor;
import com.bytedance.common.wschannel.server.PushChannelManager;
import com.bytedance.common.wschannel.server.WsChannelReceiver;
import com.bytedance.common.wschannel.utils.Utils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.android.lark.monitor.traffic.TrafficMetrics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class WsChannelSdk {
    private static final long DELAY_POST_APPSTATE_INETRVAL = 2000;
    private static WsChannelApi impl;
    private static AppStateListener mAppStateChangedListener;
    private static MemTrimListener mMemTrimListener;
    private static Map<Integer, ChannelInfo> mRegisterMap;
    private static Application sApplication;
    private static boolean sCalculateAppState;
    private static DelayParam sDelayParams;
    private static Map<Integer, BaseHeartBeatPolicy> sHeartbeatPolicy;
    private static volatile boolean sInit;
    private static boolean sIsCurrentBackground;
    private static final Object sLock = null;
    private static String sProcessName;

    public static class AppStateListener implements LifeCycleMonitor.AppStateListener {
        private AppStateListener() {
        }

        @Override // com.bytedance.common.wschannel.LifeCycleMonitor.AppStateListener
        public void onEnterToBackground() {
            WsChannelSdk.access$302(true);
            if (WsChannelSdk.access$700() != null) goto L5;
        L6:
            WsChannelSdk.access$500().onEnterToBackground(WsChannelSdk.access$400());
            return;
        L5:
            if (DelayParam.access$100(WsChannelSdk.access$700()) == true) goto L6;
        }

        @Override // com.bytedance.common.wschannel.LifeCycleMonitor.AppStateListener
        public void onEnterToForeground() {
            WsChannelSdk.access$302(false);
            if (WsChannelSdk.access$700() != null) goto L5;
        L6:
            WsChannelSdk.access$500().onEnterToForeground(WsChannelSdk.access$400());
            return;
        L5:
            if (DelayParam.access$100(WsChannelSdk.access$700()) == true) goto L6;
        }

        public /* synthetic */ AppStateListener(AnonymousClass1 r100) {
            this();
        }
    }

    /* JADX INFO: loaded from: classes15.dex */
    public static class DelayParam {
        private boolean finishDelay;
        private Map<Integer, ChannelInfo> mDelayMap;

        private DelayParam() {
            this.finishDelay = false;
            this.mDelayMap = new ConcurrentHashMap();
        }

        public /* synthetic */ DelayParam(AnonymousClass1 r100) {
            this();
        }

        public static /* synthetic */ boolean access$100(DelayParam r100) {
            return r100.finishDelay;
        }

        public static /* synthetic */ Map access$200(DelayParam r100) {
            return r100.mDelayMap;
        }

        public static /* synthetic */ boolean access$102(DelayParam r100, boolean r101) {
            r100.finishDelay = r101;
            return r101;
        }
    }

    public static MemTrimListener getMemTrimListener() {
        return null;
    }

    public static void setMemTrimListener(MemTrimListener r100) {
    }

    static {
        sLock = new Object();
        impl = new WsChannelMultiProcessImpl();
        mAppStateChangedListener = new AppStateListener(null);
        mRegisterMap = new ConcurrentHashMap();
        sHeartbeatPolicy = new ConcurrentHashMap();
    }

    private static void checkInit() {
        if (sInit == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("please init first");
    }

    public static void enterToBackground() {
        if (sInit == true) goto L6;
        return;
    L6:
        if (sCalculateAppState == true) goto L9;
        mAppStateChangedListener.onEnterToBackground();
        return;
    }

    public static void enterToForeground() {
        if (sInit == true) goto L6;
        return;
    L6:
        if (sCalculateAppState == true) goto L9;
        mAppStateChangedListener.onEnterToForeground();
        return;
    }

    private static void registerNetChangeReceiver() {
        IntentFilter r100 = new IntentFilter();     // Catch: Exception -> L4
        r100.addAction("android.net.conn.CONNECTIVITY_CHANGE");     // Catch: Exception -> L4
        Application r101 = sApplication;     // Catch: Exception -> L4
        Application r102 = sApplication;     // Catch: Exception -> L4
        INVOKEVIRTUAL_com_bytedance_common_wschannel_WsChannelSdk_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r101, new WsChannelReceiver(r102, PushChannelManager.inst(r102)), r100);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static void finishDelay() {
        checkInit();
        Object r100 = sLock;
        monitor-enter(r100);
        DelayParam r101 = sDelayParams;     // Catch: Throwable -> L22
        if (r101 != null) goto L7;
    L20:
        monitor-exit(r100);     // Catch: Throwable -> L22
        return;
    L7:
        if (DelayParam.access$100(r101) == true) goto L20;
        DelayParam.access$102(sDelayParams, true);     // Catch: Throwable -> L22
        if (DelayParam.access$200(sDelayParams).isEmpty() == true) goto L16;
        Iterator r102 = DelayParam.access$200(sDelayParams).values().iterator();     // Catch: Throwable -> L22
    L13:
        if (r102.hasNext() == false) goto L15;
        registerChannel((ChannelInfo) r102.next());     // Catch: Throwable -> L22
        goto L13
    L15:
        DelayParam.access$200(sDelayParams).clear();     // Catch: Throwable -> L22
    L17:
        new Handler(Looper.getMainLooper()).postDelayed(new AnonymousClass1(), 2000);     // Catch: Throwable -> L22
        monitor-exit(r100);     // Catch: Throwable -> L22
        return;
    L16:
        impl.tryStartPushProcess(sApplication, true, true);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    private WsChannelSdk() {
    }

    public static /* synthetic */ boolean access$300() {
        return sIsCurrentBackground;
    }

    public static /* synthetic */ Application access$400() {
        return sApplication;
    }

    public static /* synthetic */ WsChannelApi access$500() {
        return impl;
    }

    public static /* synthetic */ DelayParam access$700() {
        return sDelayParams;
    }

    public static Context getContext() {
        return sApplication;
    }

    public static /* synthetic */ boolean access$302(boolean r100) {
        sIsCurrentBackground = r100;
        return r100;
    }

    private static SsWsApp createParameterMap(ChannelInfo r110) {
        Map<String, String> r100 = r110.extra;
        ArrayList r101 = new ArrayList();
        Iterator<Map.Entry<String, String>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        Map.Entry<String, String> r103 = r102.next();
        if (r103 == null) goto L4;
        r101.add(r103.getKey() + ContainerUtils.KEY_VALUE_DELIMITER + Uri.encode(r103.getValue()));
        goto L4
    L9:
        int r104 = r110.aid;
        if (r104 <= 0) goto L46;
        String r105 = r110.deviceId;
        if (StringUtils.isEmpty(r105) == true) goto L44;
        String r106 = r110.installId;
        if (StringUtils.isEmpty(r106) == true) goto L42;
        int r107 = r110.fpid;
        if (r107 <= 0) goto L40;
        String r108 = r110.appKey;
        if (StringUtils.isEmpty(r108) == true) goto L38;
        int r109 = r110.updateVersionCode;
        if (r109 <= 0) goto L36;
        int r111 = r110.channelId;
        if (r111 <= 0) goto L34;
        boolean r112 = r110.privateProtocolEnabled;
        List<Integer> r113 = r110.serviceIdList;
        if (r112 == false) goto L31;
        if (r113 == null) goto L30;
        if (r113.isEmpty() == false) goto L31;
    L30:
        throw new IllegalArgumentException("ServiceIdList cannot be empty when private protocol is enabled.");
    L31:
        boolean r114 = r110.disableFallbackWs;
        WsConstants.initServiceState(r111, r113);
        return new SsWsApp.SsWsAppBuilder().setAppId(r104).setDeviceId(r105).setInstallId(r106).setFPID(r107).setAppKey(r108).setConnectUrls(r110.urls).setAppVersion(r109).setPlatform(0).setChannelId(r111).setExtra(TextUtils.join("&", r101.toArray())).setHeaders(r110.headers).enableNewPrivateProtocol(r112).setServiceIdList(r113).setPrivateProtocolUrl(r110.privateProtocolUrl).setTransportMode(r110.transportMode.getTypeValue()).disableFallbackWS(r114).build();
    L34:
        throw new IllegalArgumentException("channelId <= 0 ,please set channelId first");
    L36:
        throw new IllegalArgumentException("appVersion <= 0 ,please set appVersion first");
    L38:
        throw new IllegalArgumentException("appKey is empty,please set appKey first");
    L40:
        throw new IllegalArgumentException("fpid <= 0 ,please set fpid first");
    L42:
        throw new IllegalArgumentException("installId is empty ,please set installId first");
    L44:
        throw new IllegalArgumentException("deviceId is empty ,please set deviceId first");
    L46:
        throw new IllegalArgumentException("aid == 0 ,please set aid first");
    }

    private static void doInitWithParam(WschannelSdkInitParam r100) {
        if (sInit == false) goto L5;
        return;
    L5:
        Application r101 = r100.getApplication();
        OnMessageReceiveListener r102 = r100.getListener();
        boolean r103 = r100.isCalculateAppState();
        boolean r104 = r100.isDelayStartPushProcess();
        boolean r105 = r100.isEnableOfflineDetect();
        sInit = true;
        sApplication = r101;
        sCalculateAppState = r103;
        String r106 = Utils.getCurProcessName(r101);
        sProcessName = r106;
        boolean r107 = Utils.isMainProcess(r101, r106);
        AnonymousClass1 r108 = null;
        if (r104 == false) goto L9;
        if (r107 == false) goto L9;
        DelayParam r109 = new DelayParam(r108);
        sDelayParams = r109;
        DelayParam.access$102(r109, false);
    L9:
        if (r107 == false) goto L18;
        if (r103 == false) goto L12;
        LifeCycleMonitor r110 = new LifeCycleMonitor();
        r110.setAppStateChangedListener(mAppStateChangedListener);
        r101.registerActivityLifecycleCallbacks(r110);
    L12:
        WsConstants.setOnMessageReceiveListener(r102);
        WsConstants.setOptLogic(r100.getOptLogic());
        WsConstants.setBindWsChannelServiceListener(null);
        if (r101 == null) goto L21;
        WsChannelSettings r111 = WsChannelSettings.inst(r101);
        if (r111 == null) goto L21;
        r111.setEnableOfflineDetect(r105);
    L21:
        if (sDelayParams != null) goto L24;
        impl.tryStartPushProcess(sApplication, r107, true);
        return;
    L24:
        return;
    L18:
        if (Utils.isMessageProcess(sProcessName) == false) goto L21;
        registerNetChangeReceiver();
        goto L21
    }

    private static void doRealRegisterOrParametersChangedMethod(ChannelInfo r100) {
        mRegisterMap.put(Integer.valueOf(r100.channelId), r100);
        SsWsApp r101 = createParameterMap(r100);
        impl.registerApp(sApplication, r101);
    }

    public static <T extends IHeartBeatMeta> BaseHeartBeatPolicy<T> getHeartBeatPolicy(int r100) {
        return sHeartbeatPolicy.get(Integer.valueOf(r100));
    }

    public static void init(WschannelSdkInitParam r100) {
        doInitWithParam(r100);
    }

    public static boolean isEnable(Context r100) {
        return WsChannelSettings.inst(r100).isEnable();
    }

    public static boolean isOkChannelEnable(Context r100) {
        return WsChannelSettings.inst(r100).isOkChannelEnable();
    }

    public static boolean isPrivateProtocolEnabled(int r100) {
        return WsConstants.isPrivateProtocolEnabled(r100);
    }

    public static boolean isWsConnected(int r100) {
        DelayParam r101 = sDelayParams;
        if (r101 != null) goto L5;
    L6:
        WsChannelApi r102 = impl;
        Application r103 = sApplication;
        r102.tryStartPushProcess(r103, Utils.isMainProcess(r103, sProcessName));
    L8:
        return WsConstants.isWsChannelConnected(r100);
    L5:
        if (DelayParam.access$100(r101) == false) goto L8;
        goto L6
    }

    public static void onParametersChanged(ChannelInfo r100) {
        checkInit();
        Object r101 = sLock;
        monitor-enter(r101);
        DelayParam r102 = sDelayParams;     // Catch: Throwable -> L13
        if (r102 != null) goto L7;
    L10:
        SsWsApp r103 = createParameterMap(r100);     // Catch: Throwable -> L13
        mRegisterMap.put(Integer.valueOf(r100.channelId), r100);     // Catch: Throwable -> L13
        impl.onParameterChange(sApplication, r103);     // Catch: Throwable -> L13
    L11:
        monitor-exit(r101);     // Catch: Throwable -> L13
        return;
    L7:
        if (DelayParam.access$100(r102) == true) goto L10;
        DelayParam.access$200(sDelayParams).put(Integer.valueOf(r100.channelId), r100);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public static void onTrimMemory(int r100) {
        if (sInit == true) goto L5;
        return;
    L5:
        impl.onTrimMemory(sApplication, r100);
    }

    private static JSONObject parseServerTiming(String r110) throws Exception {
        String r100 = r110;
        LinkedHashMap r101 = new LinkedHashMap();
        if (splitStringIntoKeyValueMap(r100, ContainerUtils.KEY_VALUE_DELIMITER, i.f25853b, ",", r101) == true) goto L6;
        return null;
    L6:
        if (r101.containsKey(TrafficMetrics.FRPM_TTNET) == true) goto L8;
        return null;
    L8:
        Map r102 = (Map) r101.get(TrafficMetrics.FRPM_TTNET);
        if (r102.containsKey("recv_time") == true) goto L11;
        return null;
    L11:
        long r103 = CastLongProtector.parseLong((String) r102.get("recv_time"));
        long r104 = 0;
        if (r103 >= 0) goto L14;
        return null;
    L14:
        JSONObject r105 = new JSONObject();
        if (r102.containsKey("sta") == false) goto L17;
        long r111 = CastLongProtector.parseLong((String) r102.get("sta"));
    L18:
        long r112 = System.currentTimeMillis();
        if (r111 <= 0) goto L21;
        r104 = r103 - r111;
        boolean r113 = true;
    L22:
        long r114 = r112 - r103;
        r105.put(WsConstants.KEY_IS_ACK, r113);
        r105.put("tt_dur", r104);
        r105.put("recv_call_dur", r114);
        StringBuilder r106 = new StringBuilder();
        r106.append(r103);
        String r107 = "";
        r106.append("");
        r105.put("receive_time", r106.toString());
        r105.put("im_recv_time", r112);
        Iterator r108 = r101.keySet().iterator();
    L24:
        if (r108.hasNext() == false) goto L31;
        String r109 = (String) r108.next();
        if (r109.startsWith("client_") == false) goto L24;
        if (r109.length() <= 7) goto L24;
        r107 = r109;
    L31:
        if (TextUtils.isEmpty(r107) == true) goto L38;
        r105.put(SeiMessageConst.MSG_TYPE, r107.substring(7));
        Map r115 = (Map) r101.get(r107);
        if (r115.containsKey("sta") == false) goto L38;
        long r116 = CastLongProtector.parseLong((String) r115.get("sta"));
        if (r116 <= 0) goto L38;
        r105.put("im_dur", r112 - r116);
        r105.put("send_call_dur", r111 - r116);
    L38:
        if (r100.substring(r110.length() - 1) == ",") goto L40;
        r100 = r100.concat(",");
    L40:
        r105.put("server_timing", r100 + "im_recv;dur=" + r114);
        return r105;
    L21:
        r113 = false;
        goto L22
    L17:
        r111 = -1;
        goto L18
    }

    public static void registerChannel(ChannelInfo r100) {
        checkInit();
        Object r101 = sLock;
        monitor-enter(r101);
        DelayParam r102 = sDelayParams;     // Catch: Throwable -> L13
        if (r102 != null) goto L7;
    L10:
        doRealRegisterOrParametersChangedMethod(r100);     // Catch: Throwable -> L13
    L11:
        monitor-exit(r101);     // Catch: Throwable -> L13
        return;
    L7:
        if (DelayParam.access$100(r102) == true) goto L10;
        DelayParam.access$200(sDelayParams).put(Integer.valueOf(r100.channelId), r100);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public static void sendPayload(WsChannelMsg r100) {
        checkInit();
        if (r100 == null) goto L28;
        if (r100.getChannelId() <= 0) goto L26;
        if (r100.getService() < 0) goto L24;
        if (r100.getMethod() <= 0) goto L22;
        if (r100.getPayload() == null) goto L20;
        DelayParam r101 = sDelayParams;
        if (r101 != null) goto L15;
    L17:
        impl.sendPayload(sApplication, r100);
        return;
    L15:
        if (DelayParam.access$100(r101) == true) goto L17;
        finishDelay();
        goto L17
    L20:
        throw new IllegalArgumentException("illegal payload");
    L22:
        throw new IllegalArgumentException("illegal method");
    L24:
        throw new IllegalArgumentException("illegal service");
    L26:
        throw new IllegalArgumentException("illegal channelId");
    L28:
        throw new IllegalArgumentException("WsChannelMsg can't be null");
    }

    public static String sendPayloadWithAck(WsChannelMsg r100) {
        checkInit();
        if (r100 == null) goto L28;
        if (r100.getChannelId() <= 0) goto L26;
        if (r100.getService() < 0) goto L24;
        if (r100.getMethod() <= 0) goto L22;
        if (r100.getPayload() == null) goto L20;
        DelayParam r101 = sDelayParams;
        if (r101 != null) goto L15;
    L17:
        String r102 = UUID.randomUUID().toString().replace("-", "");
        r100.setUUID(r102);
        impl.sendPayload(sApplication, r100);
        return r102;
    L15:
        if (DelayParam.access$100(r101) == true) goto L17;
        finishDelay();
        goto L17
    L20:
        throw new IllegalArgumentException("illegal payload");
    L22:
        throw new IllegalArgumentException("illegal method");
    L24:
        throw new IllegalArgumentException("illegal service");
    L26:
        throw new IllegalArgumentException("illegal channelId");
    L28:
        throw new IllegalArgumentException("WsChannelMsg can't be null");
    }

    public static void setMonitorInPush(IWsSdkMonitor r100) {
        HeartBeatMonitor.getInstance().setHeartBeatMonitor(r100);
    }

    public static void unregisterChannel(int r100) {
        checkInit();
        WsConstants.remove(r100);
        mRegisterMap.remove(Integer.valueOf(r100));
        Object r101 = sLock;
        monitor-enter(r101);
        DelayParam r102 = sDelayParams;     // Catch: Throwable -> L12
        if (r102 != null) goto L7;
    L9:
        monitor-exit(r101);     // Catch: Throwable -> L12
        finishDelay();
        impl.unRegisterApp(sApplication, r100);
        return;
    L7:
        if (DelayParam.access$100(r102) == true) goto L9;
        DelayParam.access$200(sDelayParams).remove(Integer.valueOf(r100));     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public static void init(Application r100, OnMessageReceiveListener r101) {
        doInit(r100, r101, false, true, null);
    }

    public static void initWithoutLifeCycle(Application r100, OnMessageReceiveListener r101) {
        doInit(r100, r101, false, false, null);
    }

    public static boolean isWsServiceConnected(int r100, int r101) {
        return WsConstants.isServiceConnected(r100, r101);
    }

    public static void onToutiaoWsChannelParametersChanged(ChannelInfo r100, String r101) {
        r100.extra.put(WsConstants.KEY_SESSION_ID, r101);
        onParametersChanged(r100);
    }

    public static void registerService(int r100, int r101) {
        checkInit();
        impl.registerServiceId(sApplication, r100, r101);
    }

    public static void registerToutianChannel(ChannelInfo r100, String r101) {
        r100.extra.put(WsConstants.KEY_SESSION_ID, r101);
        registerChannel(r100);
    }

    public static JSONObject reportFrontierMessageMetrics(WsChannelMsg r100, int r101) {
        ChannelInfo r102 = mRegisterMap.get(Integer.valueOf(r101));
        if (r102 == null) goto L21;
        if (r100 == null) goto L21;
        JSONObject r103 = parseServerTiming(r100.getServerTiming());     // Catch: Exception -> L19
        if (r103 != null) goto L10;
        return null;
    L10:
        r103.put("im_rt", true);     // Catch: Exception -> L19
        r103.put("msgid", r100.getMsgId());     // Catch: Exception -> L19
        r103.put("service_id", r100.getService());     // Catch: Exception -> L19
        r103.put(WsConstants.KEY_FPID, r102.fpid);     // Catch: Exception -> L19
        r103.put(MapBundleKey.MapObjKey.OBJ_QID, r102.aid);     // Catch: Exception -> L19
        if (r102.privateProtocolEnabled == false) goto L14;
        r103.put("mode", r102.transportMode.getTypeValue());     // Catch: Exception -> L19
        r103.put("host", r102.privateProtocolUrl);     // Catch: Exception -> L19
    L16:
        if (Logger.debug() == false) goto L18;
        Logger.d(TrafficMetrics.FRPM_TTNET, "user_msg:" + r103);     // Catch: Exception -> L19
    L18:
        return r103;
    L14:
        r103.put("mode", 4);     // Catch: Exception -> L19
        r103.put("host", ListProtector.get(r102.urls, 0));     // Catch: Exception -> L19
    L19:
        e = move-exception;
        e.printStackTrace();
    L21:
        return null;
    }

    public static void setAutoConnectDisabledChannelIds(Context r100, ArrayList<Integer> r101) {
        WsChannelSettings.inst(r100).setAutoConnectDisabledChannelIds(r101);
    }

    public static void setEnable(Context r100, boolean r101) {
        boolean r102 = WsChannelSettings.inst(r100).isEnable();
        WsChannelSettings.inst(r100).setEnable(r101);
        if (r102 == true) goto L9;
        if (r101 == false) goto L11;
        Iterator<ChannelInfo> r103 = mRegisterMap.values().iterator();
    L7:
        if (r103.hasNext() == false) goto L12;
        registerChannel(r103.next());
        goto L7
    L12:
        return;
    L11:
        return;
    }

    public static void setEnableReportAppState(Context r100, boolean r101) {
        WsChannelSettings.inst(r100).setReportAppStateEnable(r101);
    }

    public static <T extends IHeartBeatMeta> void setHeartBeatPolicy(int r100, BaseHeartBeatPolicy<T> r101) {
        sHeartbeatPolicy.put(Integer.valueOf(r100), r101);
    }

    public static void setOkChannelEnable(Context r100, boolean r101) {
        WsChannelSettings.inst(r100).setOKChannelEnable(r101);
    }

    public static void setRetrySendMsgDelayTimeMillis(Context r100, long r101) {
        WsChannelSettings.inst(r100).setRetrySendMsgDelay(r101);
    }

    public static void setSocketLimit(Context r100, long r101) {
        WsChannelSettings.inst(r100).setSocketReadLimitSize(r101);
    }

    public static void unregisterService(int r100, int r101) {
        checkInit();
        impl.unregisterServiceId(sApplication, r100, r101);
        WsConstants.removeService(r100, r101);
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_bytedance_common_wschannel_WsChannelSdk_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Application r100, BroadcastReceiver r101, IntentFilter r110) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
        throw e;
    L40:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r110 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100);     // Catch: Exception -> L36
        int r103 = r102.result;     // Catch: Exception -> L36
        if (r103 == 1) goto L23;
        if (r103 == 2) goto L21;
        if (r103 == 3) goto L19;
        return r100.registerReceiver(r101, r110);
    L19:
        return r102.intent;
    L21:
        return new Intent();
    L23:
        return r100.registerReceiver(r101, r110);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L35:
        return r100.registerReceiver(r101, r110);
    }

    public static void init(Application r100, OnMessageReceiveListener r101, boolean r102) {
        doInit(r100, r101, r102, true, null);
    }

    public static void init(Application r100, OnMessageReceiveListener r101, OnBindWsChannelServiceListener r102, boolean r103) {
        doInit(r100, r101, r103, true, r102);
    }

    private static void doInit(Application r100, OnMessageReceiveListener r101, boolean r102, boolean r103, OnBindWsChannelServiceListener r104) {
        doInitWithParam(new WschannelSdkInitParam.Builder().application(r100).messageReceiveListener(r101).delayStartPushProcess(r102).calculateAppState(r103).enableOfflineDetect(false).bindWsChannelServiceListener(r104).build());
    }

    private static boolean splitStringIntoKeyValueMap(String r100, String r110, String r111, String r112, Map<String, Map<String, String>> r113) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r110) == false) goto L7;
        return false;
    L7:
        if (TextUtils.isEmpty(r111) == false) goto L9;
        return false;
    L9:
        if (TextUtils.isEmpty(r112) == true) goto L68;
        if (r113 == null) goto L70;
        String[] r101 = r100.split(r112);
        if (r101 != null) goto L15;
        return false;
    L15:
        int r114 = 0;
    L17:
        if (r114 >= r101.length) goto L49;
        if (TextUtils.isEmpty(r101[r114]) == true) goto L47;
        String[] r102 = r101[r114].trim().split(r111);
        if (r102 == null) goto L47;
        if (r102.length < 2) goto L47;
        String r103 = r102[0];
        LinkedHashMap r104 = new LinkedHashMap();
        int r105 = 1;
    L28:
        if (r105 >= r102.length) goto L45;
        if (TextUtils.isEmpty(r102[r105]) == true) goto L43;
        String[] r106 = r102[r105].trim().split(r110);
        if (r106 == null) goto L43;
        if (r106.length != 2) goto L43;
        if (TextUtils.isEmpty(r106[0]) == true) goto L43;
        if (TextUtils.isEmpty(r106[1]) == true) goto L43;
        r104.put(r106[0], r106[1]);
    L43:
        r105 = r105 + 1;
        goto L28
    L45:
        if (r104.size() <= 0) goto L47;
        r113.put(r103, r104);
    L47:
        r114 = r114 + 1;
        goto L17
    L49:
        if (r113.size() == 0) goto L69;
        return true;
    L69:
        return false;
    L70:
        return false;
    L68:
        return false;
    }
}
