package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.ee.bear.more.protocol3.checker.BizChecker;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j1 extends com.bytedance.ee.bear.more.protocol3.g {
    public final /* synthetic */ WikiTreeMoreProvider c;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ WikiTreeMoreProvider a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ j1 c;

        public a(WikiTreeMoreProvider r1, boolean r2, j1 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            WikiDialogs.b r3 = this.a.r;
            if (r3 == null) goto L5;
            r3.c(!this.b);
        L5:
            this.c.getHost().a();
        }
    }

    @Override // com.bytedance.ee.bear.more.protocol3.g
    public final com.bytedance.ee.bear.more.protocol3.k a() {
        boolean r0 = this.c.m.is_star;
        com.bytedance.ee.bear.more.protocol3.f.g r2 = new com.bytedance.ee.bear.more.protocol3.f.g(r0);
        WikiTreeMoreProvider r1 = this.c;
        a r6 = new a(r1, r0, this);
        return com.bytedance.ee.bear.more.protocol3.g.i(this, r2, null, CollectionsKt.listOf(new BizChecker(TextUtils.equals(r1.m.space_id, r1.o.space_id))), CollectionsKt.listOf(new com.bytedance.ee.bear.more.protocol3.j[]{new com.bytedance.ee.bear.more.protocol3.checker.d(), new WikiTreeMoreProvider.b(this.c.n.can_star)}), r6, 2);
    }

    public j1(WikiTreeMoreProvider r1) {
        this.c = r1;
    }
}
