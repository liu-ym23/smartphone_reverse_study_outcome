package com.bytedance.ee.bear.document.bitable;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.route.RouteBean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d extends com.bytedance.ee.bear.route.b {
    public final String e(BearUrl r1, RouteBean r2) {
        return "/bitable/detail/activity";
    }

    public d(com.bytedance.ee.bear.route.d... r1) {
        super(r1);
    }

    public final boolean b(Context r3, BearUrl r4, RouteBean r5) {
        if (TextUtils.equals(r4.a, sbb.e.i.getType()) == false) goto L9;
        tt5.a.h("BitableInterceptor", "dispatchUrl()..." + r4.a);
        if (g(r3, r4, r5) == true) goto L11;
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class)).w2("/bitable/detail/activity").e();
        return true;
    L11:
        return true;
    L9:
        return false;
    }
}
