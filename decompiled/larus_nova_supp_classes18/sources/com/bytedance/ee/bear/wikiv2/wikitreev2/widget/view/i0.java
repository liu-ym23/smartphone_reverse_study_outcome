package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i0 implements gp5.a.InterfaceC0236a {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ String b;
    public final /* synthetic */ c0 c;
    public final /* synthetic */ com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j d;

    @Override // gp5.a.InterfaceC0236a
    public final void a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "text");
        if (this.a == false) goto L5;
        r3 = r3 + com.bytedance.ee.util.io.a.b(this.b);
    L5:
        this.c.e.rename(this.d.b, r3);
    }

    public i0(boolean r1, String r2, c0 r3, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
