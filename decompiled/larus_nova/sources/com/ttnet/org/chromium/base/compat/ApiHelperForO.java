package com.ttnet.org.chromium.base.compat;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.autofill.AutofillManager;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.ttnet.org.chromium.base.StrictModeContext;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes5.dex */
public final class ApiHelperForO {
    private ApiHelperForO() {
    }

    public static void addItem(ClipData r100, ContentResolver r101, ClipData.Item r102) {
    }

    public static boolean areAnimatorsEnabled() {
        return ValueAnimator.areAnimatorsEnabled();
    }

    public static void cancelAutofillSession(Activity r100) {
        AutofillManager r101 = (AutofillManager) r100.getSystemService(AutofillManager.class);
        if (r101 == null) goto L6;
        r101.cancel();
        return;
    }

    public static String getNotificationChannelId(Notification r100) {
        return r100.getChannelId();
    }

    public static String[] getSplitNames(ApplicationInfo r100) {
        return r100.splitNames;
    }

    public static long getTimestamp(ClipDescription r100) {
        return r100.getTimestamp();
    }

    public static boolean isInstantApp(PackageManager r100) {
        return r100.isInstantApp();
    }

    public static boolean isScreenWideColorGamut(Configuration r100) {
        return r100.isScreenWideColorGamut();
    }

    public static boolean isWideColorGamut(Display r100) {
        return r100.isWideColorGamut();
    }

    public static void notifyValueChangedForAutofill(View r100) {
        AutofillManager r101 = (AutofillManager) r100.getContext().getSystemService(AutofillManager.class);
        if (r101 == null) goto L6;
        r101.notifyValueChanged(r100);
        return;
    }

    public static Context createContextForSplit(Context r100, String r101) throws PackageManager.NameNotFoundException {
        StrictModeContext r102 = StrictModeContext.allowDiskReads();
        Context r103 = r100.createContextForSplit(r101);     // Catch: Throwable -> L7
        if (r102 == null) goto L6;
        r102.close();
    L6:
        return r103;
    L7:
        th = move-exception;
        if (r102 != null) goto L14;
    L13:
        throw th;
    L14:
        r102.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    }

    public static Notification.Builder setChannelId(Notification.Builder r100, String r101) {
        return r100.setChannelId(r101);
    }

    public static void setColorMode(Window r100, int r101) {
        r100.setColorMode(r101);
    }

    public static void setDefaultFocusHighlightEnabled(View r100, boolean r101) {
        r100.setDefaultFocusHighlightEnabled(r101);
    }

    public static Notification.Builder setTimeoutAfter(Notification.Builder r100, long r101) {
        return r100.setTimeoutAfter(r101);
    }

    public static void registerDefaultNetworkCallback(ConnectivityManager r100, ConnectivityManager.NetworkCallback r101, Handler r102) {
        r100.registerDefaultNetworkCallback(r101, r102);
    }

    public static void registerNetworkCallback(ConnectivityManager r100, NetworkRequest r101, ConnectivityManager.NetworkCallback r102, Handler r103) {
        r100.registerNetworkCallback(r101, r102, r103);
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_ttnet_org_chromium_base_compat_ApiHelperForO_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110, String r111, Handler r112, int r113) {
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
        return ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110, r111, r112, r113);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r110 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, r113, r111, r112, 5, r100);     // Catch: Exception -> L26
        int r103 = r102.result;     // Catch: Exception -> L26
        if (r103 == 1) goto L23;
        if (r103 == 2) goto L21;
        if (r103 == 3) goto L19;
        return r100.registerReceiver(r101, r110, r111, r112, r113);
    L19:
        return r102.intent;
    L21:
        return new Intent();
    L23:
        return r100.registerReceiver(r101, r110, r111, r112, r113);
    L25:
        return r100.registerReceiver(r101, r110, r111, r112, r113);
    }

    public static Intent registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r102, String r103, Handler r104, int r105) {
        return INVOKEVIRTUAL_com_ttnet_org_chromium_base_compat_ApiHelperForO_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r100, r101, r102, r103, r104, r105);
    }
}
