package com.bytedance.android.shopping.anchorv4.voavhs.head.base;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public class c implements i {
    public final d a;
    public final Integer b;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.i
    public final void a(String r2) {
        d r0 = this.a;
        if (r0 == null) goto L8;
        c63.d r1 = r0.t();
        if (r1 == null) goto L9;
        r1.p(com.bytedance.android.shopping.extensions.k.j(r2));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.i
    public void b(int r3) {
        d r0 = this.a;
        if (r0 == null) goto L6;
        r0.s(this.b, r3);
        return;
    }

    public c(d r1, Integer r2) {
        this.a = r1;
        this.b = r2;
    }
}
