package com.bytedance.ee.bear.wikiv2.wikitreev2.create;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q implements View.OnClickListener {
    public final /* synthetic */ WikiCreateToFragment a;

    public q(WikiCreateToFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        com.suite.lark.component.navroute.forseti.g r3 = com.suite.lark.component.navroute.forseti.f.b(this.a);
        if (r3 == null) goto L6;
        r3.g(null);
        return;
    }
}
