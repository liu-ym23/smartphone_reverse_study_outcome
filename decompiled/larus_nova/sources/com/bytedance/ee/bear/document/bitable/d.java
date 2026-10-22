package com.bytedance.ee.bear.document.bitable;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.route.RouteBean;

/* JADX INFO: loaded from: classes16.dex */
public final class d extends com.bytedance.ee.bear.route.b {
    @Override // com.bytedance.ee.bear.route.a
    public final String e(BearUrl r100, RouteBean r101) {
        return "/bitable/detail/activity";
    }

    public d(com.bytedance.ee.bear.route.d... r100) {
        super(r100);
    }

    @Override // com.bytedance.ee.bear.route.d
    public final boolean b(Context r100, BearUrl r101, RouteBean r102) {
        if (TextUtils.equals(r101.f222560a, sbb.e.f541298i.getType()) == false) goto L9;
        tt5.a.h("BitableInterceptor", "dispatchUrl()..." + r101.f222560a);
        if (g(r100, r101, r102) == true) goto L11;
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class)).w2("/bitable/detail/activity").e();
        return true;
    L11:
        return true;
    L9:
        return false;
    }
}
