package com.bytedance.ee.bear.profile;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g implements r1c.a.b {
    public final /* synthetic */ HalfProfileActivity a;

    public g(HalfProfileActivity r1) {
        this.a = r1;
    }

    public final void onScroll(int r2) {
        HalfProfileActivity r0 = this.a;
        if (r2 != 0) goto L5;
        boolean r3 = true;
    L6:
        r0.l = r3;
        return;
    L5:
        r3 = false;
        goto L6
    }
}
