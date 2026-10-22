package com.ttnet.org.chromium.base;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import android.preference.PreferenceManager;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.compat.ApiHelperForM;
import com.ttnet.org.chromium.base.compat.ApiHelperForO;
import com.ttnet.org.chromium.build.BuildConfig;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes5.dex */
@JNINamespace("base::android")
public class ContextUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int RECEIVER_EXPORTED = 2;
    public static final int RECEIVER_NOT_EXPORTED = 4;
    private static final String TAG = "ContextUtils";
    private static Context sApplicationContext;

    /* JADX INFO: loaded from: classes6.dex */
    public static class Holder {
        private static SharedPreferences sSharedPreferences;

        private Holder() {
        }

        static {
            sSharedPreferences = ContextUtils.access$000();
        }

        public static /* synthetic */ SharedPreferences access$100() {
            return sSharedPreferences;
        }

        public static /* synthetic */ SharedPreferences access$102(SharedPreferences r100) {
            sSharedPreferences = r100;
            return r100;
        }
    }

    public ContextUtils() {
    }

    public static void clearApplicationContextForTests() {
        sApplicationContext = null;
        Holder.access$102(null);
    }

    public static boolean isProcess64Bit() {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        String[] r100 = Build.SUPPORTED_64_BIT_ABIS;
        if (r100.length > 0) goto L9;
        return false;
    L9:
        if (r100[0].equals(Build.CPU_ABI) == false) goto L13;
        return true;
    L13:
        return false;
    L5:
        return ApiHelperForM.isProcess64Bit();
    }

    public static boolean isSdkSandboxProcess() {
        if (Build.VERSION.SDK_INT >= 33) goto L5;
        return false;
    L5:
        return Process.isSdkSandbox();
    }

    public static /* synthetic */ SharedPreferences access$000() {
        return fetchAppSharedPreferences();
    }

    private static SharedPreferences fetchAppSharedPreferences() {
        StrictModeContext r100 = StrictModeContext.allowDiskWrites();
        SharedPreferences r101 = PreferenceManager.getDefaultSharedPreferences(sApplicationContext);     // Catch: Throwable -> L7
        if (r100 == null) goto L6;
        r100.close();
    L6:
        return r101;
    L7:
        th = move-exception;
        if (r100 != null) goto L16;
    L13:
        throw th;
    L16:
        r100.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    }

    public static SharedPreferences getAppSharedPreferences() {
        return Holder.access$100();
    }

    public static AssetManager getApplicationAssets() {
        Context r100 = getApplicationContext();
    L4:
        if ((r100 instanceof ContextWrapper) == false) goto L7;
        r100 = ((ContextWrapper) r100).getBaseContext();
        goto L4
    L7:
        return r100.getAssets();
    }

    public static String getProcessName() {
        return ApiCompatibilityUtils.getProcessName();
    }

    public static boolean isIsolatedProcess() {
        return Process.isIsolated();
    }

    static {
    }

    public static Context getApplicationContext() {
        return sApplicationContext;
    }

    public static Activity activityFromContext(Context r100) {
    L3:
        if ((r100 instanceof ContextWrapper) == false) goto L9;
        if ((r100 instanceof Activity) == true) goto L7;
        r100 = ((ContextWrapper) r100).getBaseContext();
        goto L3
    L7:
        return (Activity) r100;
    L9:
        return null;
    }

    public static void initApplicationContext(Context r100) {
        initJavaSideApplicationContext(r100);
    }

    public static void initApplicationContextForTests(Context r100) {
        initJavaSideApplicationContext(r100);
        Holder.access$102(fetchAppSharedPreferences());
    }

    private static void initJavaSideApplicationContext(Context r100) {
        if (BuildConfig.ENABLE_ASSERTS == true) goto L5;
    L7:
        sApplicationContext = r100;
        return;
    L5:
        if ((r100 instanceof Application) == false) goto L7;
        r100 = new ContextWrapper(r100);
        goto L7
    }

    public static Intent registerNonExportedBroadcastReceiver(Context r100, BroadcastReceiver r101, IntentFilter r102) {
        return registerBroadcastReceiver(r100, r101, r102, null, null, 4);
    }

    public static Intent registerExportedBroadcastReceiver(Context r100, BroadcastReceiver r101, IntentFilter r102, String r103) {
        return registerBroadcastReceiver(r100, r101, r102, r103, null, 2);
    }

    public static Intent registerNonExportedBroadcastReceiver(Context r100, BroadcastReceiver r101, IntentFilter r102, Handler r103) {
        return registerBroadcastReceiver(r100, r101, r102, null, r103, 4);
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_ttnet_org_chromium_base_ContextUtils_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110, String r111, Handler r112) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L32;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L32:
    L26:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L30;
        throw e;
    L30:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110, r111, r112);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r110 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, r111, r112, 4, r100);     // Catch: Exception -> L26
        int r103 = r102.result;     // Catch: Exception -> L26
        if (r103 == 1) goto L23;
        if (r103 == 2) goto L21;
        if (r103 == 3) goto L19;
        return r100.registerReceiver(r101, r110, r111, r112);
    L19:
        return r102.intent;
    L21:
        return new Intent();
    L23:
        return r100.registerReceiver(r101, r110, r111, r112);
    L25:
        return r100.registerReceiver(r101, r110, r111, r112);
    }

    private static Intent registerBroadcastReceiver(Context r100, BroadcastReceiver r101, IntentFilter r102, String r103, Handler r104, int r105) {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return ApiHelperForO.registerReceiver(r100, r101, r102, r103, r104, r105);
    L7:
        return INVOKEVIRTUAL_com_ttnet_org_chromium_base_ContextUtils_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r100, r101, r102, r103, r104);
    }
}
