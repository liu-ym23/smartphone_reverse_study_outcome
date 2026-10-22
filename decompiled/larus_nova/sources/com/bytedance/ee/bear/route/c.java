package com.bytedance.ee.bear.route;

import android.content.Context;
import com.bytedance.ee.bear.domain.BearUrl;
import com.larus.nova.R;
import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.android.lark.maintab.export.TabAppType;
import kotlin.jvm.JvmStatic;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f236659a = 0;

    static {
    }

    public static String a(String r100) {
        tt5.a.h("CustomTabInfoUtils", "getCacheIconContent: ");
        com.ss.android.lark.maintab.export.a r101 = ((h) org.koin.java.a.c(h.class, null, null, 6)).Pd(r100);
        if (r101 == null) goto L7;
        String r102 = r101.f431614f;
        if (r102 == null) goto L7;
        return r102;
    L7:
        return d(r100);
    }

    @JvmStatic
    public static final String b(String r100) {
        tt5.a.h("CustomTabInfoUtils", "getCacheTitle: ");
        com.ss.android.lark.maintab.export.a r101 = ((h) org.koin.java.a.c(h.class, null, null, 6)).Pd(r100);
        if (r101 == null) goto L6;
        String r102 = r101.f431612d;
        if (r102 == null) goto L6;
        return r102;
    L6:
        return "";
    }

    public static String d(String r100) {
        tt5.a.h("CustomTabInfoUtils", "getDefaultIconContent: ");
        JSONObject r101 = new JSONObject();
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        r101.put("token", r100);
        r101.put("type", 22);
        return r101.toString();
    }

    @JvmStatic
    public static final String e(Context r100) {
        tt5.a.k("CustomTabInfoUtils", "getDefaultTitle() called");
        if (r100 == null) goto L6;
        String r101 = r100.getResources().getString(R.string.LarkCCM_Wiki_MoveToSpace_Title_Document);
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @JvmStatic
    public static final String f(BearUrl r100) {
        if (r100 == null) goto L15;
        String r101 = r100.f222561b;
        if (r101 != null) goto L7;
        r101 = "";
    L7:
        String r102 = r100.f222573n;
        if (r102 != null) goto L10;
        r102 = "";
    L10:
        String r103 = r101.concat(r102);
        if (r103 != null) goto L14;
        return "";
    L14:
        return r103;
    L15:
        return "";
    }

    public static com.ss.android.lark.maintab.export.a c(String r110, String r111, String r112, String r113) {
        if (r110 != null) goto L5;
        String r100 = "";
    L6:
        TabAppInfo.BizType r101 = TabAppInfo.BizType.CCM;
        TabAppType r102 = TabAppType.APP_TYPE_URL;
        if (r112 != null) goto L9;
        String r103 = "";
    L10:
        TabAppInfo.CustomNavigationAppLogoType r104 = TabAppInfo.CustomNavigationAppLogoType.APP_LOGO_TYPE_CCM_ICON;
        if (r113 != null) goto L15;
        if (r110 != null) goto L14;
        r110 = "";
    L14:
        r113 = d(r110);
    L15:
        String r105 = r113;
        if (r111 != null) goto L18;
        String r106 = "";
    L20:
        return new com.ss.android.lark.maintab.export.a(r100, r101, r102, r103, r104, r105, r106, null);
    L18:
        r106 = r111;
        goto L20
    L9:
        r103 = r112;
        goto L10
    L5:
        r100 = r110;
        goto L6
    }
}
