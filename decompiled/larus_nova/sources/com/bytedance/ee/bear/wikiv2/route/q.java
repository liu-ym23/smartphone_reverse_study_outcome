package com.bytedance.ee.bear.wikiv2.route;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.route.RouteBean;

/* JADX INFO: loaded from: classes18.dex */
public final class q extends com.bytedance.ee.bear.route.b {
    public q() {
        super(new com.bytedance.ee.bear.route.d[0]);
    }

    @Override // com.bytedance.ee.bear.route.a
    public final String e(BearUrl r100, RouteBean r101) {
        return "/wikiv2/trash/activity";
    }

    @Override // com.bytedance.ee.bear.route.d
    public final boolean b(Context r100, BearUrl r101, RouteBean r102) {
        if (r101 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == true) goto L10;
        return false;
    L10:
        if (g(r100, r101, r102) == true) goto L12;
        tt5.a.h("WikiTrashRouteInterceptorV2", "route. ");
        d(r101, r102).i(DocViewModel.EXTRA_SPACE_ID, r101.f222570k).e();
    L12:
        return true;
    L5:
        if (TextUtils.equals(r101.f222560a, "wiki_trash") == false) goto L7;
        r103 = true;
        goto L8
    }
}
