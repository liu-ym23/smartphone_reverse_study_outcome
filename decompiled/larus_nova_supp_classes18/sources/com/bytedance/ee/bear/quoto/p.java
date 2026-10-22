package com.bytedance.ee.bear.quoto;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final /* synthetic */ class p implements ov4.b.a {
    public final /* synthetic */ s a;
    public final /* synthetic */ boolean b;

    public /* synthetic */ p(s r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a(String r12) {
        s r0 = this.a;
        boolean r1 = this.b;
        r0.getClass();
        ((com.bytedance.ee.bear.docshost.k) org.koin.java.a.a(com.bytedance.ee.bear.docshost.k.class)).e(r12, "");
        boolean r4 = r0.m;
        com.bytedance.ee.bear.contract.d r5 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
        boolean r6 = r0.f;
        boolean r7 = r0.g;
        boolean r8 = r0.e;
        if (r1 == false) goto L5;
        String r13 = "admin";
    L6:
        c.a(r4, r5, r6, r7, r8, r13, "im_chat_main_view");
        return;
    L5:
        r13 = "owner";
        goto L6
    }
}
