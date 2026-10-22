package com.bytedance.ee.bear.middleground.permission.secret;

import android.os.Bundle;
import android.view.View;
import com.bytedance.ee.bear.route.RouteBean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class z implements View.OnClickListener {
    public final /* synthetic */ SecretLevelFragment a;
    public final /* synthetic */ String b;

    public z(SecretLevelFragment r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        Bundle r5 = new Bundle();
        r5.putBoolean("vc_intercept", false);
        RouteBean r0 = new RouteBean();
        r0.n = r5;
        r0.a(this.a);
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).m9(this.b, r0);
    }
}
