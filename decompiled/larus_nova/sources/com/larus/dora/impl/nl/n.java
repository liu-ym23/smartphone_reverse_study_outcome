package com.larus.dora.impl.nl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import androidx.core.app.NotificationManagerCompat;
import com.larus.dora.api.INLService;
import com.larus.dora.impl.settings.DoraPushSummaryConfig;
import com.larus.dora.impl.settings.DoraSetting;
import com.obric.assistant.spi.dora.IObricDoraService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f336286a = null;

    static {
        f336286a = new AtomicBoolean(false);
    }

    public static boolean d() {
        Set<String> r100 = NotificationManagerCompat.getEnabledListenerPackages(pk4.n.f529659c);
        Context r101 = com.bytedance.apm.d.f190513a;
        if (r101 != null) goto L5;
        String r102 = "";
    L7:
        if (r100.contains(r102) == false) goto L10;
        return true;
    L10:
        return false;
    L5:
        r102 = r101.getPackageName();
        goto L7
    }

    public static boolean a() {
        sk4.e r100 = kj4.a.g().requestProtocolInfo();
        DoraSetting.f338023a.getClass();
        DoraPushSummaryConfig r101 = DoraSetting.e();
        g49.d.d("NLUtils", "isAIPushFeatureEnabled, doraPushSummaryConfig: " + r101 + ", protocolInfo: " + r100);
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r101 != null) goto L10;
    L12:
        boolean r103 = false;
    L13:
        if (r102 == false) goto L17;
        if (r103 == false) goto L18;
        return true;
    L18:
        return false;
    L17:
        return false;
    L10:
        if (r101.getProactiveMessage() == false) goto L12;
        r103 = true;
        goto L13
    L5:
        if (r100.b("startVUI") == false) goto L7;
        r102 = true;
        goto L8
    }

    public static boolean b() {
        sk4.e r100 = kj4.a.g().requestProtocolInfo();
        DoraSetting.f338023a.getClass();
        DoraPushSummaryConfig r101 = DoraSetting.e();
        g49.d.d("NLUtils", "isNLFeatureEnabled, doraPushSummaryConfig: " + r101 + ", protocolInfo: " + r100);
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r101 != null) goto L10;
    L12:
        boolean r103 = false;
    L13:
        if (r102 == false) goto L17;
        if (r103 == false) goto L18;
        return true;
    L18:
        return false;
    L17:
        return false;
    L10:
        if (r101.getNotificationSummary() == false) goto L12;
        r103 = true;
        goto L13
    L5:
        if (r100.b("startVUI") == false) goto L7;
        r102 = true;
        goto L8
    }

    public static boolean c() {
        NLServiceImpl r100 = (NLServiceImpl) ServiceManager.get().getService(INLService.class);
        if (r100 != null) goto L5;
        return false;
    L5:
        IObricDoraService r101 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);
        if (r101 != null) goto L8;
    L10:
        boolean r102 = false;
    L11:
        int r103 = 2;
        if (r102 == false) goto L15;
    L17:
        if (r103 != 1) goto L20;
        return true;
    L20:
        return false;
    L15:
        if (r100.f() == null) goto L17;
        r103 = r100.f().getInt("nl_state", 2);
        goto L17
    L8:
        if (r101.n() == false) goto L10;
        r102 = true;
        goto L11
    }

    public static void f() {
        g49.d.d("NLUtils", "toggleNLService");
        PackageManager r100 = pk4.n.f529659c.getPackageManager();     // Catch: Throwable -> L5
        r100.setComponentEnabledSetting(new ComponentName(pk4.n.f529659c, NLService.class), 2, 1);     // Catch: Throwable -> L5
        r100.setComponentEnabledSetting(new ComponentName(pk4.n.f529659c, NLService.class), 1, 1);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        g49.d.b("NLUtils", "toggleNLService: " + Log.getStackTraceString(th));
    }

    public static void e(Context r100) {
        g49.d.d("NLUtils", "openNLSettings");     // Catch: Throwable -> L10
        if (Build.VERSION.SDK_INT < 22) goto L7;
        Intent r101 = new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS");     // Catch: Throwable -> L10
    L8:
        r100.startActivity(r101);     // Catch: Throwable -> L10
        return;
    L7:
        r101 = new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        g49.d.b("NLUtils", "openNLSettings: " + Log.getStackTraceString(th));
    }
}
