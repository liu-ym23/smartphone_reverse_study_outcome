package nz2;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;

/* JADX INFO: loaded from: classes12.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f521375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f521376b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f521377c = null;

    static {
        com.bytedance.android.anniex.assemble.a.h();
        f521375a = false;
        f521376b = Log.isLoggable("HBMonitorSDK_V2", 3);
        f521377c = new c();
    }

    public static String d(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return "HBMonitorSDK_V2";
    L6:
        if (r100.startsWith("HBMonitorSDK_V2") == true) goto L9;
        r100 = "HBMonitorSDK_V2_".concat(r100);
    L9:
        return r100 + "(" + Process.myPid() + "-" + Process.myTid() + ")";
    }

    public static String e(WebView r100) {
        if (r100 != null) goto L6;
        return "null";
    L6:
        return r100.getClass().toString();
    }

    public static void a(String r100, String r101) {
        if (f521375a == false) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
        return;
    L11:
        c r103 = f521377c;
        String r104 = d(r100);
        r103.getClass();
        HybridLogger r105 = HybridLogger.f246343a;
        if (HybridLogger.c(r104, r101, LogLevel.D) == false) goto L15;
        return;
    L15:
        if (r101.length() <= 3000) goto L23;
        if (c.f521378a == true) goto L20;
        String r106 = r101.substring(0, 3000);
        if (a.c(a.b("d"), r104, r106) == false) goto L20;
    L21:
        r101 = r101.substring(3000);
    L20:
        r101.substring(0, 3000);
        goto L21
    L23:
        if (c.f521378a == true) goto L27;
        if (a.c(a.b("d"), r104, r101) == false) goto L27;
        return;
    L27:
        return;
    L5:
        if (f521376b == true) goto L8;
        r102 = false;
        goto L9
    }

    public static void b(String r100, String r101) {
        c r102 = f521377c;
        String r103 = d(r100);
        r102.getClass();
        HybridLogger r104 = HybridLogger.f246343a;
        if (HybridLogger.c(r103, r101, LogLevel.E) == false) goto L6;
        return;
    L6:
        if (r101.length() <= 3000) goto L14;
        if (c.f521378a == true) goto L11;
        String r105 = r101.substring(0, 3000);
        if (a.c(a.b("e"), r103, r105) == false) goto L11;
    L12:
        r101 = r101.substring(3000);
    L11:
        r101.substring(0, 3000);
        goto L12
    L14:
        if (c.f521378a == true) goto L18;
        if (a.c(a.b("e"), r103, r101) == false) goto L18;
        return;
    }

    public static void c(String r100, String r101) {
        c r102 = f521377c;
        String r103 = d(r100);
        r102.getClass();
        HybridLogger r104 = HybridLogger.f246343a;
        if (HybridLogger.c(r103, r101, LogLevel.E) == false) goto L6;
        return;
    L6:
        if (c.f521378a == true) goto L10;
        if (a.c(a.b("e"), r103, r101) == false) goto L10;
        return;
    }

    public static void f(String r100, String r101) {
        c r102 = f521377c;
        String r103 = d(r100);
        r102.getClass();
        HybridLogger r104 = HybridLogger.f246343a;
        if (HybridLogger.c(r103, r101, LogLevel.I) == false) goto L6;
        return;
    L6:
        if (r101.length() <= 3000) goto L14;
        if (c.f521378a == true) goto L11;
        String r105 = r101.substring(0, 3000);
        if (a.c(a.b(RXScreenCaptureService.KEY_INDEX), r103, r105) == false) goto L11;
    L12:
        r101 = r101.substring(3000);
    L11:
        r101.substring(0, 3000);
        goto L12
    L14:
        if (c.f521378a == true) goto L18;
        if (a.c(a.b(RXScreenCaptureService.KEY_INDEX), r103, r101) == false) goto L18;
        return;
    }
}
