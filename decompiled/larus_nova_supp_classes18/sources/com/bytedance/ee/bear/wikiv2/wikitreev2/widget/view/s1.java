package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import android.view.View;
import com.bytedance.ee.bear.more.protocol3.checker.BizChecker;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class s1 extends com.bytedance.ee.bear.more.protocol3.g {
    public final /* synthetic */ WikiTreeMoreProvider c;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ s1 a;
        public final /* synthetic */ WikiTreeMoreProvider b;

        public a(s1 r1, WikiTreeMoreProvider r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.getHost().a();
            WikiDialogs.b r2 = this.b.r;
            if (r2 == null) goto L6;
            r2.a();
            return;
        }
    }

    @Override // com.bytedance.ee.bear.more.protocol3.g
    public final com.bytedance.ee.bear.more.protocol3.k a() {
        com.bytedance.ee.bear.more.protocol3.f.b r1 = com.bytedance.ee.bear.more.protocol3.f.b.c;
        WikiTreeMoreProvider r0 = this.c;
        a r5 = new a(this, r0);
        List r4 = CollectionsKt.listOf(new BizChecker(!r0.m.getOriginIsDeleted()));
        WikiTreeMoreProvider r6 = this.c;
        return com.bytedance.ee.bear.more.protocol3.g.i(this, r1, null, r4, CollectionsKt.listOf(new com.bytedance.ee.bear.more.protocol3.j[]{new com.bytedance.ee.bear.more.protocol3.checker.d(), new WikiTreeMoreProvider.b(r6.n.getOriginCanShortcut(r6.m.isShortcut()))}), r5, 2);
    }

    public s1(WikiTreeMoreProvider r1) {
        this.c = r1;
    }
}
