package com.bytedance.salamander.anniex;

import android.net.Uri;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.lynx.devtoolwrapper.ScreenshotMode;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class b2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b2 f267974c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<String> f267975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<String> f267976b;

    public static final class a {
    }

    static {
        b2 r100 = new b2();
        r100.f267975a.add("lynx_page");
        r100.f267975a.add(ScreenshotMode.SCREEN_SHOT_MODE_LYNX_VIEW);
        r100.f267975a.add("lynx_popup");
        r100.f267975a.add("lynxview_popup");
        r100.f267976b.add(AppConstants.HOST_WEBVIEW_DIALOG);
        r100.f267976b.add("webview_page");
        r100.f267976b.add("webview");
        f267974c = r100;
    }

    public b2() {
        this.f267975a = com.bytedance.rts.foundation.q.b(new String[0]);
        this.f267976b = com.bytedance.rts.foundation.q.b(new String[0]);
    }

    public final AnnieXSLEngineType a(String r100) {
        if (r100 == null) goto L4;
        int r101 = com.bytedance.anniex.bd.foundation.impl.u.f190155c;
        com.bytedance.anniex.bd.foundation.impl.u r102 = com.bytedance.anniex.bd.foundation.impl.u.a.a(r100);
        boolean r103 = true;
        String r104 = null;
        if (r102 == null) goto L25;
        String r105 = r102.b();
        Uri r106 = r102.f190156a;
        if (r106 == null) goto L11;
        String r107 = r106.getPath();
    L13:
        if (r105 != null) goto L15;
    L17:
        if (r107 != null) goto L19;
    L21:
        if (r105 == null) goto L25;
        if (com.bytedance.rts.foundation.q.a(this.f267975a, r105) == false) goto L25;
    L24:
        boolean r108 = true;
    L26:
        if (r108 == true) goto L28;
        if (r102 == null) goto L48;
        String r109 = r102.b();
        Uri r110 = r102.f190156a;
        if (r110 == null) goto L34;
        String r111 = r110.getPath();
    L36:
        if (r109 != null) goto L38;
    L40:
        if (r111 != null) goto L42;
    L44:
        if (r109 == null) goto L48;
        if (com.bytedance.rts.foundation.q.a(this.f267976b, r109) == false) goto L48;
    L49:
        if (r103 == true) goto L51;
        Set r112 = com.bytedance.rts.foundation.q.b(new String[0]);
        r112.add("http");
        r112.add("https");
        if (r102 == null) goto L57;
        Uri r113 = r102.f190156a;
        if (r113 == null) goto L57;
        r104 = r113.getScheme();
    L57:
        if (r104 == null) goto L63;
        if (com.bytedance.rts.foundation.q.a(r112, r104) == false) goto L63;
        return AnnieXSLEngineType.f267858web;
    L63:
        return AnnieXSLEngineType.unknow;
    L51:
        return AnnieXSLEngineType.f267858web;
    L42:
        if (com.bytedance.rts.foundation.r.c(r111, "webview") == false) goto L44;
    L38:
        if (com.bytedance.rts.foundation.r.c(r109, "webview") == false) goto L40;
    L34:
        r111 = null;
    L48:
        r103 = false;
        goto L49
    L28:
        return AnnieXSLEngineType.lynx;
    L19:
        if (com.bytedance.rts.foundation.r.c(r107, ScreenshotMode.SCREEN_SHOT_MODE_LYNX_VIEW) == false) goto L21;
    L15:
        if (com.bytedance.rts.foundation.r.c(r105, ScreenshotMode.SCREEN_SHOT_MODE_LYNX_VIEW) == false) goto L17;
    L11:
        r107 = null;
    L25:
        r108 = false;
        goto L26
    L4:
        return AnnieXSLEngineType.unknow;
    }

    public static String b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r101, "key");
        int r102 = com.bytedance.anniex.bd.foundation.impl.u.f190155c;
        com.bytedance.anniex.bd.foundation.impl.u r103 = com.bytedance.anniex.bd.foundation.impl.u.a.a(r100);
        if (r103 == null) goto L6;
        String r104 = r103.c(r101);
        if (r104 == null) goto L6;
        return r104;
    L6:
        return "unknown";
    }
}
