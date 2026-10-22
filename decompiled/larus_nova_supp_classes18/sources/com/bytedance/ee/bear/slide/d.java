package com.bytedance.ee.bear.slide;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d extends com.bytedance.ee.bear.route.b {
    @Override // com.bytedance.ee.bear.route.a
    public final String e(BearUrl r1, RouteBean r2) {
        return "/slide/router";
    }

    public d(com.bytedance.ee.bear.route.d... r1) {
        super(r1);
    }

    @Override // com.bytedance.ee.bear.route.d
    public final boolean b(Context r5, BearUrl r6, RouteBean r7) {
        String r8 = r6.b;
        if (r8 != null) goto L6;
        return false;
    L6:
        if (r8.length() != 22) goto L8;
    L11:
        boolean r9 = true;
    L13:
        if (TextUtils.equals(r6.a, e.m.getType()) == false) goto L22;
        if (r9 == false) goto L22;
        if ((r7 instanceof OldSlideRouteBean) == true) goto L18;
    L20:
        tt5.a.h("SlideRouteInterceptor", "route...");
        d(r6, r7).i(ResourceData.KEY_TYPE, r6.a).i(ResourceData.KEY_URL, r6.e).i(ResourceData.KEY_OBJ_TOKEN, r6.b).g(0, 0).e();
        return true;
    L18:
        if (((OldSlideRouteBean) r7).v == false) goto L20;
        return false;
    L22:
        return false;
    L8:
        if (r6.b.startsWith("sld") == true) goto L11;
        r9 = false;
        goto L13
    }
}
