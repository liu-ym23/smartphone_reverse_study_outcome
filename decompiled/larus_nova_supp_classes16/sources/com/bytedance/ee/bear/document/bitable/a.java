package com.bytedance.ee.bear.document.bitable;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends com.bytedance.ee.bear.route.b {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.bitable.a$a, reason: collision with other inner class name */
    public static final class C0066a {
    }

    static {
    }

    public a() {
        super(new com.bytedance.ee.bear.route.d[0]);
    }

    public final String e(BearUrl r1, RouteBean r2) {
        return "/bitable/home/activity";
    }

    public final boolean b(Context r10, BearUrl r11, RouteBean r12) {
        String r13 = null;
        if (r11 == null) goto L5;
        String r14 = r11.a;
    L7:
        if (TextUtils.equals(r14, "bitable_home") == true) goto L9;
        return false;
    L9:
        if (r11 == null) goto L11;
        r13 = r11.e;
    L11:
        String r5 = "";
        if (TextUtils.isEmpty(r13) == false) goto L45;
        String r16 = "";
        String r7 = r16;
    L36:
        ((com.bytedance.ee.bear.route.h) k.a(LarkContext.getApplication(), com.bytedance.ee.bear.route.h.class)).w2("/bitable/home/activity").i("base_hp_from", r5).i("container_env", r7).i("home_page_version", r16).e();
        return true;
    L45:
        Uri r17 = UriProtector.parse(r13);     // Catch: Exception -> L31
        String r6 = UriProtector.getQueryParameter(r17, "base_hp_from");     // Catch: Exception -> L31
        if (r6 != null) goto L39;
        r6 = "";
    L39:
        r7 = UriProtector.getQueryParameter(r17, "container_env");     // Catch: Exception -> L29
        if (r7 != null) goto L41;
        r7 = "";
    L41:
        String r18 = UriProtector.getQueryParameter(r17, "home_page_version");     // Catch: Exception -> L27
        if (r18 != null) goto L43;
    L34:
        r16 = r5;
        r5 = r6;
        goto L36
    L43:
        tt5.a.h("BitableHomeRouteInterceptor", "homePageVersion: ".concat(r18));     // Catch: Exception -> L25
        r5 = r18;
    L25:
        Exception e = e;
        r5 = r18;
    L33:
        tt5.a.e("BitableHomeRouteInterceptor", "parse starturl err " + r13, e, false);
    L27:
        e = e;
    L29:
        e = e;
        r7 = "";
    L31:
        e = move-exception;
        e = e;
        r6 = "";
        r7 = r6;
        goto L33
    L5:
        r14 = null;
        goto L7
    }
}
