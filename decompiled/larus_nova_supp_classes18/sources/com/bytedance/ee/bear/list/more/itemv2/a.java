package com.bytedance.ee.bear.list.more.itemv2;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.more.protocol3.checker.BizChecker;
import com.bytedance.ee.bear.more.protocol3.f;
import com.bytedance.ee.bear.more.protocol3.g;
import com.bytedance.ee.bear.more.protocol3.j;
import com.bytedance.ee.bear.more.protocol3.k;
import com.bytedance.ee.bear.more.view3.MoreFragmentV3;
import java.util.Map;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends g {
    public final String c;
    public final String d;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.list.more.itemv2.a$a, reason: collision with other inner class name */
    public static final class C0022a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r19) {
            a r1 = this.a;
            r1.getClass();
            oj5.b r2 = (oj5.b) r1.d(oj5.b.class);
            if (r2 == null) goto L29;
            MoreFragmentV3 r3 = r1.getHost().getHostFragment();
            Context r4 = r3.getContext();
            if (r4 == null) goto L30;
            Map<String, String> r5 = r2.w;
            if (r5 == null) goto L11;
            String r6 = r5.get(f.a0.c.a);
        L12:
            if (r6 == null) goto L14;
            Toast.showFailureText(r4, r6, 0);
            tt5.a.h("FolderPermissionSettingItem", "block disabled folder permission operation.");
            return;
        L14:
            String r8 = r2.c;
            int r9 = r2.getType();
            String r11 = r2.h;
            String r7 = r1.c;
            if (r7 != null) goto L17;
            String r13 = "";
        L18:
            String r10 = r1.d;
            if (r10 != null) goto L21;
            String r14 = "";
        L22:
            String r12 = r2.L();
            if (r12 != null) goto L25;
            String r15 = "";
        L26:
            uj5.b r16 = new uj5.b(r8, r9, true, r11, r13, r14, r15, r2.l, r2.b, 5216);
            int r17 = uj5.a.a;
            uj5.a.C0316a.a(r4, r16, (h0) org.koin.java.a.c(h0.class, null, null, 6), r3, true);
            r1.getHost().a();
            return;
        L25:
            r15 = r12;
            goto L26
        L21:
            r14 = r10;
            goto L22
        L17:
            r13 = r7;
            goto L18
        L11:
            r6 = null;
            goto L12
        L30:
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.more.protocol3.g
    public final k a() {
        f.a0 r1 = f.a0.c;
        b r5 = new b(this);
        BizChecker[] r2 = new BizChecker[2];
        r2[0] = new BizChecker(com.bytedance.ee.bear.middleground.permission.b.m());
        oj5.b r6 = (oj5.b) d(oj5.b.class);
        if (r6 != null) goto L5;
    L7:
        boolean r7 = false;
    L8:
        r2[1] = new BizChecker(r7);
        return g.i(this, r1, null, CollectionsKt.listOf(r2), CollectionsKt.listOf(new j[]{new com.bytedance.ee.bear.more.protocol3.checker.c(r1.a), new com.bytedance.ee.bear.more.protocol3.checker.d()}), r5, 2);
    L5:
        if (r6.Q() != true) goto L7;
        r7 = true;
        goto L8
    }

    public a(String r1, String r2) {
        this.c = r1;
        this.d = r2;
    }
}
