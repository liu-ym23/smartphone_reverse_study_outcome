package com.bytedance.ee.bear.list;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class r3 implements ae5.s.a {
    public final /* synthetic */ com.bytedance.ee.bear.contract.c0.e a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;
    public final /* synthetic */ com.bytedance.ee.bear.contract.d d;
    public final /* synthetic */ q3 e;

    @Override // ae5.s.a
    public final void onSuccess() {
        com.bytedance.ee.bear.contract.c0.e r0 = this.a;
        if (r0 == null) goto L5;
        r0.onSuccess();
    L5:
        this.e.q(this.b, this.c, false);
        q3.a(this.e, this.b, false);
        q3.b(this.e, this.d, "star", "succeed");
    }

    @Override // ae5.s.a
    public final void onFail(int r3, Throwable r4) {
        if (this.a == null) goto L9;
        if (r4 != null) goto L6;
    L8:
        this.a.onFail();
        goto L9
    L6:
        if (r4.getMessage() == null) goto L8;
        r4.getMessage();
    L9:
        q3.b(this.e, this.d, "star", "failed");
    }

    public r3(q3 r1, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.l.a r2, String r3, int r4, com.bytedance.ee.bear.contract.d r5) {
        this.e = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
