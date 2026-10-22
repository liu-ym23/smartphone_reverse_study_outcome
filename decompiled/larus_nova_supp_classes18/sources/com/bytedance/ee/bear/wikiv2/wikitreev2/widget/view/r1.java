package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import android.view.View;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class r1 extends com.bytedance.ee.bear.more.protocol3.g {
    public final /* synthetic */ WikiTreeMoreProvider c;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ WikiTreeMoreProvider a;

        public a(WikiTreeMoreProvider r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            WikiDialogs.b r2 = this.a.r;
            if (r2 == null) goto L5;
            r2.e();
        L5:
            this.a.c();
        }
    }

    @Override // com.bytedance.ee.bear.more.protocol3.g
    public final com.bytedance.ee.bear.more.protocol3.k a() {
        com.bytedance.ee.bear.more.protocol3.f.d0 r1 = com.bytedance.ee.bear.more.protocol3.f.d0.c;
        a r5 = new a(this.c);
        com.bytedance.ee.bear.more.protocol3.j[] r2 = new com.bytedance.ee.bear.more.protocol3.j[2];
        r2[0] = new com.bytedance.ee.bear.more.protocol3.checker.a(r1.a);
        if (yp5.c.g() == false) goto L5;
        com.bytedance.ee.bear.more.protocol3.checker.b r3 = new com.bytedance.ee.bear.more.protocol3.checker.b(new sbb.e[]{sbb.e.g, sbb.e.o, sbb.e.h, sbb.e.i, sbb.e.k, sbb.e.l, sbb.e.m});
    L6:
        r2[1] = r3;
        return com.bytedance.ee.bear.more.protocol3.g.i(this, r1, null, CollectionsKt.listOf(r2), CollectionsKt.listOf(new com.bytedance.ee.bear.more.protocol3.j[]{new com.bytedance.ee.bear.more.protocol3.checker.d(), new WikiTreeMoreProvider.b(this.c.n.can_rename)}), r5, 2);
    L5:
        r3 = new com.bytedance.ee.bear.more.protocol3.checker.b(new sbb.e[]{sbb.e.g, sbb.e.o, sbb.e.h, sbb.e.i, sbb.e.k, sbb.e.l});
        goto L6
    }

    public r1(WikiTreeMoreProvider r1) {
        this.c = r1;
    }
}
