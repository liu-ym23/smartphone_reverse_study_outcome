package com.ss.ttvideoengine.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.core.content.ContextCompat;
import com.bytedance.crash.Npth;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import f06.b;
import f06.d;
import g06.a;
import java.util.ArrayList;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes34.dex */
public class NetUtils {
    public static final int NETTYPE_UNKNOWN = -1;
    public static long netUpdateTimeMs = -1;
    private static final BroadcastReceiver networkReceiver = null;
    public static boolean registerNetworkReceiver;

    public NetUtils() {
    }

    static {
        networkReceiver = new AnonymousClass1();
    }

    private static String com_ss_ttvideoengine_net_NetUtils_android_net_NetworkInfo_getExtraInfo(NetworkInfo r110) {
        ArrayList r100 = new ArrayList();
        Object[] r111 = new Object[0];
        b r112 = new b();
        a r101 = ApiHookConfig.f245611b.get(102026);
        if (r101 == null) goto L5;
        f06.a[] r102 = r101.f479473i;
    L6:
        f06.a[] r113 = r102;
        int r103 = r113.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L15;
        f06.a r105 = r113[r104];
        int r114 = r104;
        int r115 = r103;
        d r106 = r105.preInvoke(102026, "android/net/NetworkInfo", "getExtraInfo", r110, r111, "java.lang.String", r112);     // Catch: Exception -> L22
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L22
    L17:
        if (r106.f474982a == false) goto L21;
        return (String) r106.f474983b;
    L21:
        return r110.getExtraInfo();
    L14:
        r104 = r114 + 1;
        r103 = r115;
        goto L8
    L15:
        r106 = new d(false, null);
        goto L17
    L5:
        r102 = ApiHookConfig.f245613d;
        goto L6
    }

    public static String getNetExtraInfo(Context r100) {
        NetworkInfo r101 = getNetworkInfo(r100);     // Catch: Throwable -> L10
        if (r101 == null) goto L9;
        if (r101.isAvailable() == false) goto L9;
        return com_ss_ttvideoengine_net_NetUtils_android_net_NetworkInfo_getExtraInfo(r101);
    L9:
        return null;
    }

    public static int getNetType(Context r100) {
        NetworkInfo r101 = getNetworkInfo(r100);     // Catch: Throwable -> L10
        if (r101 == null) goto L9;
        if (r101.isAvailable() == false) goto L9;
        return r101.getType();
    L9:
        return -1;
    }

    public static NetworkInfo getNetworkInfo(Context r100) {
        if (r100 != null) goto L22;
        return null;
    L22:
    L19:
        return null;
    L6:
        if (registerNetworkReceiver == true) goto L18;
        BroadcastReceiver r101 = networkReceiver;     // Catch: Throwable -> L19
        monitor-enter(r101);     // Catch: Throwable -> L19
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L10:
        if (registerNetworkReceiver == true) goto L12;
        registerNetworkReceiver = true;     // Catch: Throwable -> L14
        INVOKEVIRTUAL_com_ss_ttvideoengine_net_NetUtils_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r100.getApplicationContext(), r101, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));     // Catch: Throwable -> L14
    L12:
        monitor-exit(r101);     // Catch: Throwable -> L14
    L18:
        return ((ConnectivityManager) r100.getSystemService("connectivity")).getActiveNetworkInfo();
    }

    public static boolean isNetAvailable(Context r100) {
        NetworkInfo r101 = getNetworkInfo(r100);
        if (r101 != null) goto L5;
        return false;
    L5:
        if (r101.isConnected() == false) goto L10;
        return true;
    L10:
        return false;
    }

    public static void release(Context r100) {
        BroadcastReceiver r101 = networkReceiver;     // Catch: Exception -> L13
        monitor-enter(r101);     // Catch: Exception -> L13
    L10:
        th = move-exception;
        throw th;     // Catch: Exception -> L13
    L5:
        if (registerNetworkReceiver == false) goto L8;
        if (r100 == null) goto L8;
        registerNetworkReceiver = false;     // Catch: Throwable -> L10
        INVOKEVIRTUAL_com_ss_ttvideoengine_net_NetUtils_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(r100.getApplicationContext(), r101);     // Catch: Throwable -> L10
    L8:
        monitor-exit(r101);     // Catch: Throwable -> L10
    L20:
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void INVOKEVIRTUAL_com_ss_ttvideoengine_net_NetUtils_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(Context r100, BroadcastReceiver r101) {
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

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_ss_ttvideoengine_net_NetUtils_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110) {
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
