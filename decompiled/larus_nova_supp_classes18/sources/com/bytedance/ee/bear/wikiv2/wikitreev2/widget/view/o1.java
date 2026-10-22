package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import android.view.View;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class o1 extends com.bytedance.ee.bear.more.protocol3.g {
    public final /* synthetic */ WikiTreeMoreProvider c;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ o1 a;
        public final /* synthetic */ WikiTreeMoreProvider b;

        public a(o1 r1, WikiTreeMoreProvider r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.getHost().a();
            WikiDialogs.b r2 = this.b.r;
            if (r2 == null) goto L6;
            r2.f();
            return;
        }
    }

    @Override // com.bytedance.ee.bear.more.protocol3.g
    public final com.bytedance.ee.bear.more.protocol3.k a() {
        com.bytedance.ee.bear.more.protocol3.f.v r1 = com.bytedance.ee.bear.more.protocol3.f.v.c;
        a r5 = new a(this, this.c);
        return com.bytedance.ee.bear.more.protocol3.g.i(this, r1, null, CollectionsKt.listOf(new com.bytedance.ee.bear.more.protocol3.checker.a(r1.a)), CollectionsKt.listOf(new com.bytedance.ee.bear.more.protocol3.j[]{new com.bytedance.ee.bear.more.protocol3.checker.d(), new WikiTreeMoreProvider.b(this.c.n.show_move)}), r5, 2);
    }

    public o1(WikiTreeMoreProvider r1) {
        this.c = r1;
    }
}
