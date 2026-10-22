package com.bytedance.ee.bear.profile;

import com.bytedance.ee.bear.lark.dependency.c0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l implements com.ss.android.lark.api.ui.a {
    public final /* synthetic */ HalfProfileFragment a;
    public final /* synthetic */ tua.b b;

    public final void a() {
        HalfProfileFragment r0 = this.a;
        if (r0.l == true) goto L7;
        r0.l = true;
        c0.a r1 = r0.k;
        if (r1 == null) goto L7;
        r1.onCancel();
    L7:
        this.b.R(this.a, this);
    }

    public l(HalfProfileFragment r1, tua.b r2) {
        this.a = r1;
        this.b = r2;
    }
}
