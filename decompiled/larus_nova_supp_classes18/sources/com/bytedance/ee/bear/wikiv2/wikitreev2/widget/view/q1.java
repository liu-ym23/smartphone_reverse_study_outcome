package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.route.parcelable.WikNodePerm;
import com.bytedance.ee.bear.more.protocol3.checker.BizChecker;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q1 extends com.bytedance.ee.bear.more.protocol3.g {
    public final /* synthetic */ WikiTreeMoreProvider c;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ WikiTreeMoreProvider a;
        public final /* synthetic */ q1 b;

        public a(WikiTreeMoreProvider r1, q1 r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            WikiDialogs.b r2 = this.a.r;
            if (r2 == null) goto L5;
            r2.i();
        L5:
            this.b.getHost().a();
        }
    }

    @Override // com.bytedance.ee.bear.more.protocol3.g
    public final com.bytedance.ee.bear.more.protocol3.k a() {
        com.bytedance.ee.bear.more.protocol3.f.c0 r1 = com.bytedance.ee.bear.more.protocol3.f.c0.c;
        WikiTreeMoreProvider r0 = this.c;
        a r5 = new a(r0, this);
        com.bytedance.ee.bear.more.protocol3.j[] r2 = new com.bytedance.ee.bear.more.protocol3.j[5];
        boolean r6 = false;
        if (r0.s == true) goto L5;
        boolean r3 = r0.o.isMyLib();
    L9:
        r2[0] = new BizChecker(!r3);
        r2[1] = new BizChecker(!this.c.m.isShortcut());
        String r4 = this.c.o.tenant_id;
        String r8 = null;
        AccountService.Account r7 = ((com.bytedance.ee.bear.contract.h0) org.koin.java.a.c(com.bytedance.ee.bear.contract.h0.class, null, null, 6)).G2();
        if (r7 == null) goto L12;
        r8 = r7.tenantId;
    L12:
        r2[2] = new BizChecker(TextUtils.equals(r4, r8));
        qc5.a.j();
        r2[3] = new BizChecker(true);
        r2[4] = new com.bytedance.ee.bear.more.protocol3.checker.a(r1.a);
        List r9 = CollectionsKt.listOf(r2);
        com.bytedance.ee.bear.more.protocol3.j[] r10 = new com.bytedance.ee.bear.more.protocol3.j[2];
        r10[0] = new com.bytedance.ee.bear.more.protocol3.checker.d();
        WikNodePerm r11 = this.c.n;
        if (r11.can_move == false) goto L15;
    L16:
        r6 = true;
    L17:
        r10[1] = new WikiTreeMoreProvider.b(r6);
        return com.bytedance.ee.bear.more.protocol3.g.i(this, r1, null, r9, CollectionsKt.listOf(r10), r5, 2);
    L15:
        if (r11.show_move == false) goto L17;
    L5:
        ce5.a r12 = r0.q;
        if (r12 == null) goto L8;
        r3 = dq5.j.c(r0.m.space_id, r12);
        goto L9
    L8:
        r3 = false;
        goto L9
    }

    public q1(WikiTreeMoreProvider r1) {
        this.c = r1;
    }
}
