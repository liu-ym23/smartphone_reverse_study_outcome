package com.bytedance.ee.bear.profile;

import android.view.View;
import com.bytedance.ee.bear.lark.dependency.c0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k implements View.OnClickListener {
    public final /* synthetic */ HalfProfileFragment a;

    public k(HalfProfileFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        HalfProfileFragment r3 = this.a;
        if (r3.l == true) goto L7;
        r3.l = true;
        c0.a r4 = r3.k;
        if (r4 == null) goto L7;
        r4.onConfirm();
    L7:
        HalfProfileFragment r5 = this.a;
        r5.getClass();
        com.suite.lark.component.navroute.forseti.g r6 = com.suite.lark.component.navroute.forseti.f.b(r5);
        if (r6 == null) goto L11;
        r6.g(null);
        return;
    }
}
