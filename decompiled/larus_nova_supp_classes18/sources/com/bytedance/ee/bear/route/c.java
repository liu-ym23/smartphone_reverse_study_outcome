package com.bytedance.ee.bear.route;

import android.content.Context;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.android.lark.maintab.export.TabAppType;
import kotlin.jvm.JvmStatic;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(String r3) {
        tt5.a.h("CustomTabInfoUtils", "getCacheIconContent: ");
        com.ss.android.lark.maintab.export.a r0 = ((h) org.koin.java.a.c(h.class, null, null, 6)).Pd(r3);
        if (r0 == null) goto L7;
        String r1 = r0.f;
        if (r1 == null) goto L7;
        return r1;
    L7:
        return d(r3);
    }

    @JvmStatic
    public static final String b(String r3) {
        tt5.a.h("CustomTabInfoUtils", "getCacheTitle: ");
        com.ss.android.lark.maintab.export.a r4 = ((h) org.koin.java.a.c(h.class, null, null, 6)).Pd(r3);
        if (r4 == null) goto L6;
        String r5 = r4.d;
        if (r5 == null) goto L6;
        return r5;
    L6:
        return "";
    }

    public static String d(String r2) {
        tt5.a.h("CustomTabInfoUtils", "getDefaultIconContent: ");
        JSONObject r0 = new JSONObject();
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        r0.put(ResourceData.KEY_TOKEN, r2);
        r0.put(ResourceData.KEY_TYPE, 22);
        return r0.toString();
    }

    @JvmStatic
    public static final String e(Context r2) {
        tt5.a.k("CustomTabInfoUtils", "getDefaultTitle() called");
        if (r2 == null) goto L6;
        String r3 = r2.getResources().getString(2131889811);
        if (r3 == null) goto L6;
        return r3;
    L6:
        return "";
    }

    @JvmStatic
    public static final String f(BearUrl r2) {
        if (r2 == null) goto L15;
        String r1 = r2.b;
        if (r1 != null) goto L7;
        r1 = "";
    L7:
        String r3 = r2.n;
        if (r3 != null) goto L10;
        r3 = "";
    L10:
        String r4 = r1.concat(r3);
        if (r4 != null) goto L14;
        return "";
    L14:
        return r4;
    L15:
        return "";
    }

    public static com.ss.android.lark.maintab.export.a c(String r10, String r11, String r12, String r13) {
        if (r10 != null) goto L5;
        String r1 = "";
    L6:
        TabAppInfo.BizType r2 = TabAppInfo.BizType.CCM;
        TabAppType r3 = TabAppType.APP_TYPE_URL;
        if (r12 != null) goto L9;
        String r4 = "";
    L10:
        TabAppInfo.CustomNavigationAppLogoType r5 = TabAppInfo.CustomNavigationAppLogoType.APP_LOGO_TYPE_CCM_ICON;
        if (r13 != null) goto L15;
        if (r10 != null) goto L14;
        r10 = "";
    L14:
        r13 = d(r10);
    L15:
        String r6 = r13;
        if (r11 != null) goto L18;
        String r7 = "";
    L20:
        return new com.ss.android.lark.maintab.export.a(r1, r2, r3, r4, r5, r6, r7, null);
    L18:
        r7 = r11;
        goto L20
    L9:
        r4 = r12;
        goto L10
    L5:
        r1 = r10;
        goto L6
    }
}
