package com.bytedance.bdlocation.scan.networklistener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import androidx.core.content.ContextCompat;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import com.bytedance.crash.Npth;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkManager {
    public static String TAG = "NetworkManager";
    private volatile boolean isRegisterNetworkCallback;
    private volatile boolean mIsRegister;
    private List<WifiChangeListener> mListeners;
    private ConnectivityManager.NetworkCallback mNetworkCallback;
    private final Object mNetworkCallbackLock;
    private NetworkChangeReceiver mReceiver;

    public static class SingletonHolder {
        private static NetworkManager instance;

        private SingletonHolder() {
        }

        static {
            instance = new NetworkManager(null);
        }

        public static /* synthetic */ NetworkManager access$000() {
            return instance;
        }
    }

    private NetworkManager() {
        this.mNetworkCallbackLock = new Object();
        this.mListeners = new ArrayList();
        this.mReceiver = new NetworkChangeReceiver();
        this.mNetworkCallback = new AnonymousClass1(this);
    }

    public static NetworkManager getInstance() {
        return SingletonHolder.access$000();
    }

    public List<WifiChangeListener> getListener() {
        return this.mListeners;
    }

    public /* synthetic */ NetworkManager(AnonymousClass1 r100) {
        this();
    }

    public void notifyWifiChangedTwo(NetworkInfo r100) {
        List<WifiChangeListener> r101 = this.mListeners;     // Catch: Exception -> L11
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.size() <= 0) goto L19;
        Iterator<WifiChangeListener> r102 = this.mListeners.iterator();     // Catch: Exception -> L11
    L8:
        if (r102.hasNext() == false) goto L20;
        r102.next().notifyWifiChangedTwo(r100);     // Catch: Exception -> L11
        goto L8
    L20:
        return;
    L19:
        return;
    L11:
        e = move-exception;
        Logger.e("notifyWifiChangedTwo error", e);
    }

    public void registerNetworkCallback(Context r100) {
        if (BDLocationConfig.enableStationaryScenePolicy() == true) goto L5;
        return;
    L5:
        Object r101 = this.mNetworkCallbackLock;
        monitor-enter(r101);
    L22:
        th = move-exception;
        throw th;
    L8:
        if (this.isRegisterNetworkCallback == false) goto L12;
        monitor-exit(r101);     // Catch: Throwable -> L22
        return;
    L12:
        if (this.mNetworkCallback != null) goto L15;
        monitor-exit(r101);     // Catch: Throwable -> L22
        return;
    L15:
        Logger.i("registerNetworkCallback");     // Catch: Throwable -> L22
        NetworkRequest r102 = new NetworkRequest.Builder().addTransportType(1).build();     // Catch: Exception -> L18 Throwable -> L22
        ((ConnectivityManager) r100.getSystemService("connectivity")).registerNetworkCallback(r102, this.mNetworkCallback);     // Catch: Exception -> L18 Throwable -> L22
        this.isRegisterNetworkCallback = true;     // Catch: Exception -> L18 Throwable -> L22
    L20:
        monitor-exit(r101);     // Catch: Throwable -> L22
        return;
    L18:
        e = move-exception;
        LocationMonitor.registerNetworkCallbackError("registerNetworkCallback", e);     // Catch: Throwable -> L22
        Logger.e("registerNetworkCallback error", e);     // Catch: Throwable -> L22
        goto L20
    }

    public void registerObserver(Context r100) {
        Logger.i("WifiCollect:register network mIsRegister is:" + this.mIsRegister);
        if (this.mIsRegister == false) goto L10;
        return;
    L10:
        IntentFilter r101 = new IntentFilter();     // Catch: Throwable -> L7
        r101.addAction("android.net.conn.CONNECTIVITY_CHANGE");     // Catch: Throwable -> L7
        this.mReceiver.doRegister(true);     // Catch: Throwable -> L7
        INVOKEVIRTUAL_com_bytedance_bdlocation_scan_networklistener_NetworkManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r100, this.mReceiver, r101);     // Catch: Throwable -> L7
        this.mIsRegister = true;     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        Logger.e("WifiCollect register network change error", th);
    }

    public void setListener(WifiChangeListener r100) {
        this.mListeners.add(r100);
    }

    public void unRegisterObserver(Context r100) {
        Logger.i("WifiCollect:unregister network mIsRegister is:" + this.mIsRegister);
        if (this.mIsRegister == true) goto L5;
        return;
    L5:
        if (r100 == null) goto L15;
        NetworkChangeReceiver r101 = this.mReceiver;     // Catch: Exception -> L10
        if (r101 == null) goto L16;
        INVOKEVIRTUAL_com_bytedance_bdlocation_scan_networklistener_NetworkManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(r100, r101);     // Catch: Exception -> L10
        this.mIsRegister = false;     // Catch: Exception -> L10
        return;
    L16:
        return;
    L10:
        e = move-exception;
        Logger.e("WifiCollect:unregister network change error", e);
        return;
    }

    public void unregisterNetworkCallback(Context r100) {
        if (BDLocationConfig.enableStationaryScenePolicy() == true) goto L5;
        return;
    L5:
        Object r101 = this.mNetworkCallbackLock;
        monitor-enter(r101);
    L22:
        th = move-exception;
        throw th;
    L8:
        if (this.isRegisterNetworkCallback == true) goto L12;
        monitor-exit(r101);     // Catch: Throwable -> L22
        return;
    L12:
        if (this.mNetworkCallback != null) goto L15;
        monitor-exit(r101);     // Catch: Throwable -> L22
        return;
    L15:
        Logger.i("unregisterNetworkCallback");     // Catch: Throwable -> L22
        ((ConnectivityManager) r100.getSystemService("connectivity")).unregisterNetworkCallback(this.mNetworkCallback);     // Catch: Exception -> L18 Throwable -> L22
        this.isRegisterNetworkCallback = false;     // Catch: Exception -> L18 Throwable -> L22
    L20:
        monitor-exit(r101);     // Catch: Throwable -> L22
        return;
    L18:
        e = move-exception;
        LocationMonitor.registerNetworkCallbackError("unregisterNetworkCallback", e);     // Catch: Throwable -> L22
        Logger.e("unregisterNetworkCallback error", e);     // Catch: Throwable -> L22
        goto L20
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void INVOKEVIRTUAL_com_bytedance_bdlocation_scan_networklistener_NetworkManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(Context r100, BroadcastReceiver r101) {
        ReceiverRegisterLancet.loge(r101, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L14;
        r100.unregisterReceiver(r101);
        return;
    L14:
    L8:
        e = move-exception;
        if (r101 == null) goto L11;
        Npth.addTag("unregisterReceiver", r101.toString());
    L11:
        e.printStackTrace();
        return;
    L5:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r101, r100) == false) goto L16;
        r100.unregisterReceiver(r101);     // Catch: Exception -> L8
        return;
    }

    public void notifyWifiChanged(Network r100, NetworkCapabilities r101) {
        List<WifiChangeListener> r102 = this.mListeners;     // Catch: Exception -> L11
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.size() <= 0) goto L19;
        Iterator<WifiChangeListener> r103 = this.mListeners.iterator();     // Catch: Exception -> L11
    L8:
        if (r103.hasNext() == false) goto L20;
        r103.next().notifyWifiChanged(r100, r101);     // Catch: Exception -> L11
        goto L8
    L20:
        return;
    L19:
        return;
    L11:
        e = move-exception;
        Logger.e("notifyWifiChanged error", e);
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_bytedance_bdlocation_scan_networklistener_NetworkManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110) {
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
}
