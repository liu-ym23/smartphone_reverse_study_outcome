package com.bytedance.common.wschannel;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.wschannel.app.OnMessageAckListener;
import com.bytedance.common.wschannel.app.OnMessageReceiveListener;
import com.bytedance.common.wschannel.app.OnServiceConnectListener;
import com.bytedance.common.wschannel.client.WsChannelApi;
import com.bytedance.common.wschannel.client.WsChannelSingleProcessImpl;
import com.bytedance.common.wschannel.model.SsWsApp;
import com.bytedance.common.wschannel.server.MainChannelManager;
import com.bytedance.common.wschannel.server.WsChannelReceiver;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public class WsChannelSdk2 {
    private static WsChannelApi impl;
    private static Map<Integer, WsChannelImpl> mChannels;
    private static AtomicBoolean sInited;
    private static boolean sIsCurrentBackground;

    public static class AppStateListener implements LifeCycleMonitor.AppStateListener {
        private final Application mApp;

        @Override // com.bytedance.common.wschannel.LifeCycleMonitor.AppStateListener
        public void onEnterToBackground() {
            WsChannelSdk2.access$002(true);
            if (WsChannelSdk2.access$100().get() == false) goto L6;
            WsChannelSdk2.access$200().onEnterToBackground(this.mApp);
            return;
        }

        @Override // com.bytedance.common.wschannel.LifeCycleMonitor.AppStateListener
        public void onEnterToForeground() {
            WsChannelSdk2.access$002(false);
            if (WsChannelSdk2.access$100().get() == false) goto L6;
            WsChannelSdk2.access$200().onEnterToForeground(this.mApp);
            return;
        }

        public AppStateListener(Application r100) {
            this.mApp = r100;
        }
    }

    static {
        impl = new WsChannelSingleProcessImpl();
        mChannels = new ConcurrentHashMap();
        sInited = new AtomicBoolean(false);
        sIsCurrentBackground = true;
    }

    public static /* synthetic */ AtomicBoolean access$100() {
        return sInited;
    }

    public static /* synthetic */ WsChannelApi access$200() {
        return impl;
    }

    public static /* synthetic */ boolean access$002(boolean r100) {
        sIsCurrentBackground = r100;
        return r100;
    }

    public static SsWsApp createParameterMap(ChannelInfo r110) {
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
        if (r104 <= 0) goto L38;
        String r105 = r110.deviceId;
        if (StringUtils.isEmpty(r105) == true) goto L36;
        String r106 = r110.installId;
        if (StringUtils.isEmpty(r106) == true) goto L34;
        int r107 = r110.fpid;
        if (r107 <= 0) goto L32;
        String r108 = r110.appKey;
        if (StringUtils.isEmpty(r108) == true) goto L30;
        int r109 = r110.updateVersionCode;
        if (r109 <= 0) goto L28;
        int r111 = r110.channelId;
        if (r111 <= 0) goto L26;
        return new SsWsApp.SsWsAppBuilder().setAppId(r104).setDeviceId(r105).setInstallId(r106).setFPID(r107).setAppKey(r108).setConnectUrls(r110.urls).setAppVersion(r109).setPlatform(0).setChannelId(r111).setHeaders(r110.headers).setExtra(TextUtils.join("&", r101.toArray())).enableNewPrivateProtocol(r110.privateProtocolEnabled).setServiceIdList(r110.serviceIdList).setPrivateProtocolUrl(r110.privateProtocolUrl).setTransportMode(r110.transportMode.getTypeValue()).disableFallbackWS(r110.disableFallbackWs).build();
    L26:
        throw new IllegalArgumentException("channelId <= 0 ,please set channelId first");
    L28:
        throw new IllegalArgumentException("appVersion <= 0 ,please set appVersion first");
    L30:
        throw new IllegalArgumentException("appKey is empty,please set appKey first");
    L32:
        throw new IllegalArgumentException("fpid <= 0 ,please set fpid first");
    L34:
        throw new IllegalArgumentException("installId is empty ,please set installId first");
    L36:
        throw new IllegalArgumentException("deviceId is empty ,please set deviceId first");
    L38:
        throw new IllegalArgumentException("aid == 0 ,please set aid first");
    }

    public static WsChannelImpl getChannel(int r100) {
        return mChannels.get(Integer.valueOf(r100));
    }

    public static void monitorLifeCycle(Context r100) {
        Application r101 = (Application) r100.getApplicationContext();
        LifeCycleMonitor r102 = new LifeCycleMonitor();
        r102.setAppStateChangedListener(new AppStateListener(r101));
        r101.registerActivityLifecycleCallbacks(r102);
    }

    private static void registerNetChangeReceiver(Context r100) {
        IntentFilter r101 = new IntentFilter();     // Catch: Exception -> L4
        r101.addAction("android.net.conn.CONNECTIVITY_CHANGE");     // Catch: Exception -> L4
        INVOKEVIRTUAL_com_bytedance_common_wschannel_WsChannelSdk2_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r100, new WsChannelReceiver(r100, MainChannelManager.inst(r100)), r101);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    private static void tryInit(Context r100) {
        if (sInited.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        if (sIsCurrentBackground == false) goto L7;
        impl.onEnterToBackground(r100);
    L8:
        registerNetChangeReceiver(r100);
        return;
    L7:
        impl.onEnterToForeground(r100);
        goto L8
    }

    public static void unregister(int r100) {
        mChannels.remove(Integer.valueOf(r100));
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_bytedance_common_wschannel_WsChannelSdk2_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110) {
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

    public static WsChannel registerChannel(Context r100, ChannelInfo r101, OnMessageReceiveListener r102) {
        return registerChannel(r100.getApplicationContext(), r101, r102, null, null);
    }

    public static WsChannel registerChannel(Context r100, ChannelInfo r101, OnMessageReceiveListener r110, OnServiceConnectListener r111, OnMessageAckListener r112) {
        tryInit(r100.getApplicationContext());
        WsChannelImpl r102 = new WsChannelImpl(r100.getApplicationContext(), impl, r101, r110, r111, r112);
        mChannels.put(Integer.valueOf(r101.channelId), r102);
        r102.register();
        return r102;
    }
}
