package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import android.view.View;
import com.bytedance.ee.bear.more.protocol3.checker.BizChecker;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l1 extends com.bytedance.ee.bear.more.protocol3.g {
    public final /* synthetic */ WikiTreeMoreProvider c;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ WikiTreeMoreProvider a;
        public final /* synthetic */ l1 b;

        public a(WikiTreeMoreProvider r1, l1 r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            WikiTreeMoreProvider r3 = this.a;
            WikiDialogs.b r0 = r3.r;
            if (r0 == null) goto L5;
            r0.d(r3.o);
        L5:
            this.b.getHost().a();
        }
    }

    @Override // com.bytedance.ee.bear.more.protocol3.g
    public final com.bytedance.ee.bear.more.protocol3.k a() {
        if (this.c.m.isShortcut() == false) goto L5;
        com.bytedance.ee.bear.more.protocol3.f r0 = com.bytedance.ee.bear.more.protocol3.f.k.c;
    L6:
        com.bytedance.ee.bear.more.protocol3.f r2 = r0;
        WikiTreeMoreProvider r1 = this.c;
        a r6 = new a(r1, this);
        com.bytedance.ee.bear.more.protocol3.j[] r3 = new com.bytedance.ee.bear.more.protocol3.j[2];
        r3[0] = new BizChecker(r1.n.show_delete);
        if (this.c.m.isShortcut() == false) goto L9;
        com.bytedance.ee.bear.more.protocol3.f r4 = com.bytedance.ee.bear.more.protocol3.f.k.c;
    L10:
        r3[1] = new com.bytedance.ee.bear.more.protocol3.checker.a(r4.a);
        List r5 = CollectionsKt.listOf(r3);
        ArrayList r7 = new ArrayList();
        r7.add(new com.bytedance.ee.bear.more.protocol3.checker.d());
        return com.bytedance.ee.bear.more.protocol3.g.i(this, r2, null, r5, r7, r6, 2);
    L9:
        r4 = com.bytedance.ee.bear.more.protocol3.f.j.c;
        goto L10
    L5:
        r0 = com.bytedance.ee.bear.more.protocol3.f.j.c;
        goto L6
    }

    public l1(WikiTreeMoreProvider r1) {
        this.c = r1;
    }
}
