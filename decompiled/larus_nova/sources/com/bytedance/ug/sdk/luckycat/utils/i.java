package com.bytedance.ug.sdk.luckycat.utils;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.ug.sdk.luckycat.impl.manager.m;
import com.lynx.devtoolwrapper.ScreenshotMode;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public final class i {
    public static void a(WebView r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        String r101 = r100.getSettings().getUserAgentString();
        if (TextUtils.isEmpty(r101) == false) goto L7;
        r101 = "";
    L7:
        m r102 = m.a.f271349a;
        if (r102.f271342j == null) goto L10;
        StringBuilder r103 = new StringBuilder();
        r103.append(r101);
        r102.f271342j.getClass();
        r103.append("");
        r101 = r103.toString();
    L10:
        r100.getSettings().setUserAgentString((r101 + " LuckyCatVersionName/1.0") + " LuckyCatVersionCode/1");
    }

    public static String c(String r100) {
        if (h(r100) == false) goto L10;
        if (m.a.f271349a.c(r100) == false) goto L7;
        return "new_popup";
    L7:
        return "old_popup";
    L10:
        if (i(r100) == false) goto L17;
        if (m.a.f271349a.c(r100) == false) goto L14;
        return "new_lynx";
    L14:
        return "old_lynx";
    L17:
        if (e(r100) == false) goto L21;
        return "new_h5";
    L21:
        if (g(r100) == false) goto L24;
        return "old_h5";
    L24:
        return "unKnown";
    }

    public static String d(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return null;
    L6:
        Uri r101 = UriProtector.parse(r100);
        String r102 = UriProtector.getQueryParameter(r101, "url");
        if (TextUtils.isEmpty(r102) == true) goto L10;
        return r102;
    L10:
        return UriProtector.getQueryParameter(r101, "surl");
    }

    public static boolean e(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        Uri r101 = UriProtector.parse(r100);
        String r102 = r101.getScheme();
        String r103 = r101.getHost();
        String r104 = r101.getPath();
        if (k(r102) == true) goto L8;
    L19:
        return false;
    L8:
        if (TextUtils.equals(r103, "polaris") == false) goto L19;
        if (TextUtils.equals("/webview", r104) == false) goto L12;
        return true;
    L12:
        if (TextUtils.equals("/webview_popup", r104) == false) goto L14;
        return true;
    L14:
        if (TextUtils.equals("/webview/", r104) == false) goto L16;
        return true;
    L16:
        if (TextUtils.equals("/webview_popup/", r104) == false) goto L19;
        return true;
    }

    public static boolean f(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return false;
    L6:
        if (r100.startsWith("http://") == false) goto L8;
    L9:
        return true;
    L8:
        if (r100.startsWith("https://") == true) goto L9;
        return false;
    }

    public static boolean g(String r100) {
    L16:
        th = move-exception;
        th.printStackTrace();
        return false;
    L4:
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return false;
    L6:
        Uri r101 = UriProtector.parse(r100);     // Catch: Throwable -> L16
        boolean r102 = k(r101.getScheme());     // Catch: Throwable -> L16
        String r103 = r101.getHost();     // Catch: Throwable -> L16
        List<String> r104 = r101.getPathSegments();     // Catch: Throwable -> L16
        String r105 = "";
        if (r104.size() <= 0) goto L9;
        r105 = (String) ListProtector.get(r104, 0);     // Catch: Throwable -> L16
    L9:
        if (r102 == true) goto L11;
        return false;
    L11:
        if ("polaris".equals(r103) == false) goto L22;
        if (TextUtils.isEmpty(r105) == false) goto L23;
        return true;
    L23:
        return false;
    L22:
        return false;
    }

    public static boolean h(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        Uri r101 = UriProtector.parse(r100);
        boolean r102 = k(r101.getScheme());
        String r103 = r101.getHost();
        List<String> r104 = r101.getPathSegments();
        if (r104.size() <= 0) goto L8;
        String r105 = (String) ListProtector.get(r104, 0);
    L9:
        if (r102 == true) goto L11;
        return false;
    L11:
        if ("polaris".equals(r103) == true) goto L13;
        return false;
    L13:
        if ("lynx_popup".equals(r105) == false) goto L15;
    L16:
        return true;
    L15:
        if ("lynxview_popup".equals(r105) == true) goto L16;
        return false;
    L8:
        r105 = "";
        goto L9
    }

    public static boolean i(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return false;
    L6:
        Uri r101 = UriProtector.parse(r100);     // Catch: Throwable -> L20
        boolean r102 = k(r101.getScheme());     // Catch: Throwable -> L20
        String r103 = r101.getHost();     // Catch: Throwable -> L20
        List<String> r104 = r101.getPathSegments();     // Catch: Throwable -> L20
        String r105 = "";
        if (r104.size() <= 0) goto L9;
        r105 = (String) ListProtector.get(r104, 0);     // Catch: Throwable -> L20
    L9:
        if (r102 == true) goto L11;
        return false;
    L11:
        if ("polaris".equals(r103) == true) goto L13;
        return false;
    L13:
        if ("lynx".equals(r105) == false) goto L15;
    L18:
        return true;
    L15:
        if (ScreenshotMode.SCREEN_SHOT_MODE_LYNX_VIEW.equals(r105) == true) goto L18;
        if ("lynx_page".equals(r105) == true) goto L18;
        return false;
    L26:
        return false;
    }

    public static boolean j(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return false;
    L6:
        Uri r101 = UriProtector.parse(r100);     // Catch: Throwable -> L12
        boolean r102 = k(r101.getScheme());     // Catch: Throwable -> L12
        String r103 = r101.getHost();     // Catch: Throwable -> L12
        if (r102 == false) goto L15;
        if ("polaris".equals(r103) == false) goto L16;
        return true;
    L16:
        return false;
    L15:
        return false;
    L17:
        return false;
    }

    public static boolean k(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return false;
    L6:
        if (AppConstants.SCHEME_SS_LOCAL.equals(r100) == false) goto L8;
        return true;
    L8:
        StringBuilder r101 = new StringBuilder(AppConstants.SCHEME_SNSSDK);
        m r102 = m.a.f271349a;
        r101.append(r102.g());
        if (r100.equals(r101.toString()) == false) goto L12;
        return true;
    L12:
        if (r100.equals("polaris" + r102.g()) == false) goto L14;
        return true;
    L14:
        r102.h();
        return false;
    }

    public static String b(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r100;
    L5:
        if (TextUtils.isEmpty(r101) == false) goto L8;
        return r100;
    L8:
        if (r100.contains("?") == false) goto L10;
        String r102 = r100.concat("&");
    L12:
        return r102 + r101;
    L10:
        r102 = r100.concat("?");
        goto L12
    }
}
