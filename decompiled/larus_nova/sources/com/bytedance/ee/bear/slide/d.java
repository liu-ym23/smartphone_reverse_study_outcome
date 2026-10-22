package com.bytedance.ee.bear.slide;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.route.RouteBean;
import sbb.e;

/* JADX INFO: loaded from: classes18.dex */
public final class d extends com.bytedance.ee.bear.route.b {
    @Override // com.bytedance.ee.bear.route.a
    public final String e(BearUrl r100, RouteBean r101) {
        return "/slide/router";
    }

    public d(com.bytedance.ee.bear.route.d... r100) {
        super(r100);
    }

    @Override // com.bytedance.ee.bear.route.d
    public final boolean b(Context r100, BearUrl r101, RouteBean r102) {
        String r103 = r101.f222561b;
        if (r103 != null) goto L6;
        return false;
    L6:
        if (r103.length() != 22) goto L8;
    L11:
        boolean r104 = true;
    L13:
        if (TextUtils.equals(r101.f222560a, e.f541302m.getType()) == false) goto L22;
        if (r104 == false) goto L22;
        if ((r102 instanceof OldSlideRouteBean) == true) goto L18;
    L20:
        tt5.a.h("SlideRouteInterceptor", "route...");
        d(r101, r102).i("type", r101.f222560a).i("url", r101.f222564e).i("obj_token", r101.f222561b).g(0, 0).e();
        return true;
    L18:
        if (((OldSlideRouteBean) r102).f238570v == false) goto L20;
        return false;
    L22:
        return false;
    L8:
        if (r101.f222561b.startsWith("sld") == true) goto L11;
        r104 = false;
        goto L13
    }
}
