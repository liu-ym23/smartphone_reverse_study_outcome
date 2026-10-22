package com.bytedance.ee.bear.wikiv2.route;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.route.RouteBean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q extends com.bytedance.ee.bear.route.b {
    public q() {
        super(new com.bytedance.ee.bear.route.d[0]);
    }

    @Override // com.bytedance.ee.bear.route.a
    public final String e(BearUrl r1, RouteBean r2) {
        return "/wikiv2/trash/activity";
    }

    @Override // com.bytedance.ee.bear.route.d
    public final boolean b(Context r5, BearUrl r6, RouteBean r7) {
        if (r6 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L10;
        return false;
    L10:
        if (g(r5, r6, r7) == true) goto L12;
        tt5.a.h("WikiTrashRouteInterceptorV2", "route. ");
        d(r6, r7).i("space_id", r6.k).e();
    L12:
        return true;
    L5:
        if (TextUtils.equals(r6.a, "wiki_trash") == false) goto L7;
        r2 = true;
        goto L8
    }
}
