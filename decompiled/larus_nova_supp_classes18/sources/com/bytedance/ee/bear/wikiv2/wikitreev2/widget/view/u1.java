package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import android.view.View;
import com.bytedance.ee.bear.more.protocol3.checker.BizChecker;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class u1 extends com.bytedance.ee.bear.more.protocol3.g {
    public final /* synthetic */ WikiTreeMoreProvider c;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ WikiTreeMoreProvider a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ u1 c;

        public a(WikiTreeMoreProvider r1, boolean r2, u1 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            WikiDialogs.b r3 = this.a.r;
            if (r3 == null) goto L5;
            r3.h(!this.b);
        L5:
            this.c.getHost().a();
        }
    }

    @Override // com.bytedance.ee.bear.more.protocol3.g
    public final com.bytedance.ee.bear.more.protocol3.k a() {
        boolean r0 = this.c.m.is_explorer_star;
        com.bytedance.ee.bear.more.protocol3.f.h0 r2 = new com.bytedance.ee.bear.more.protocol3.f.h0(r0);
        WikiTreeMoreProvider r1 = this.c;
        a r6 = new a(r1, r0, this);
        List r4 = CollectionsKt.listOf(new BizChecker(!r1.m.getOriginIsDeleted()));
        WikiTreeMoreProvider r5 = this.c;
        return com.bytedance.ee.bear.more.protocol3.g.i(this, r2, null, r4, CollectionsKt.listOf(new com.bytedance.ee.bear.more.protocol3.j[]{new com.bytedance.ee.bear.more.protocol3.checker.d(), new WikiTreeMoreProvider.b(r5.n.getOriginCanExploreStar(r5.m.isShortcut()))}), r6, 2);
    }

    public u1(WikiTreeMoreProvider r1) {
        this.c = r1;
    }
}
