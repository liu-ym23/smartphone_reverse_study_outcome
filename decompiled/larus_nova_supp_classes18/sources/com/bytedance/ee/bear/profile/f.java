package com.bytedance.ee.bear.profile;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f implements r1c.a.a {
    public final /* synthetic */ HalfProfileActivity a;

    public final void onClick() {
        HalfProfileActivity r0 = this.a;
        if (r0.o == false) goto L5;
        r0.finish();
        return;
    L5:
        r0.D1(false, true);
    }

    public f(HalfProfileActivity r1) {
        this.a = r1;
    }
}
