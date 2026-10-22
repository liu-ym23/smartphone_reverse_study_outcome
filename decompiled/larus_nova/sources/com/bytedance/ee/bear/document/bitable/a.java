package com.bytedance.ee.bear.document.bitable;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;

/* JADX INFO: loaded from: classes16.dex */
public final class a extends com.bytedance.ee.bear.route.b {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.bitable.a$a, reason: collision with other inner class name */
    public static final class C3122a {
    }

    static {
    }

    public a() {
        super(new com.bytedance.ee.bear.route.d[0]);
    }

    @Override // com.bytedance.ee.bear.route.a
    public final String e(BearUrl r100, RouteBean r101) {
        return "/bitable/home/activity";
    }

    @Override // com.bytedance.ee.bear.route.d
    public final boolean b(Context r110, BearUrl r111, RouteBean r112) {
        String r113 = null;
        if (r111 == null) goto L5;
        String r114 = r111.f222560a;
    L7:
        if (TextUtils.equals(r114, "bitable_home") == true) goto L9;
        return false;
    L9:
        if (r111 == null) goto L11;
        r113 = r111.f222564e;
    L11:
        String r100 = "";
        if (TextUtils.isEmpty(r113) == false) goto L45;
        String r115 = "";
        String r101 = r115;
    L36:
        ((com.bytedance.ee.bear.route.h) k.a(LarkContext.getApplication(), com.bytedance.ee.bear.route.h.class)).w2("/bitable/home/activity").i("base_hp_from", r100).i("container_env", r101).i("home_page_version", r115).e();
        return true;
    L45:
        Uri r116 = UriProtector.parse(r113);     // Catch: Exception -> L31
        String r102 = UriProtector.getQueryParameter(r116, "base_hp_from");     // Catch: Exception -> L31
        if (r102 != null) goto L39;
        r102 = "";
    L39:
        r101 = UriProtector.getQueryParameter(r116, "container_env");     // Catch: Exception -> L29
        if (r101 != null) goto L41;
        r101 = "";
    L41:
        String r117 = UriProtector.getQueryParameter(r116, "home_page_version");     // Catch: Exception -> L27
        if (r117 != null) goto L43;
    L34:
        r115 = r100;
        r100 = r102;
        goto L36
    L43:
        tt5.a.h("BitableHomeRouteInterceptor", "homePageVersion: ".concat(r117));     // Catch: Exception -> L25
        r100 = r117;
    L25:
        Exception e100 = e;
        r100 = r117;
    L33:
        tt5.a.e("BitableHomeRouteInterceptor", "parse starturl err " + r113, e100, false);
    L27:
        e100 = e;
    L29:
        e100 = e;
        r101 = "";
    L31:
        e = move-exception;
        e100 = e;
        r102 = "";
        r101 = r102;
        goto L33
    L5:
        r114 = null;
        goto L7
    }
}
