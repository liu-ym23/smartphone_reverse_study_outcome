package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.more.protocol3.checker.BizChecker;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceInfo;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpacePerm;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class t0 extends com.bytedance.ee.bear.more.protocol3.g {
    public final /* synthetic */ WikiSpaceMoreProvider c;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ WikiSpaceMoreProvider a;

        public a(WikiSpaceMoreProvider r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            WikiSpaceMoreProvider r4 = this.a;
            com.bytedance.ee.bear.wikiv2.wikitreev2.ai.c r0 = r4.r;
            Context r5 = r4.getContext();
            SpaceInfo r1 = this.a.s;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r5, "context");
            r0.a.b();
            this.a.c();
        }
    }

    @Override // com.bytedance.ee.bear.more.protocol3.g
    public final com.bytedance.ee.bear.more.protocol3.k a() {
        com.bytedance.ee.bear.more.protocol3.f.k0 r1 = com.bytedance.ee.bear.more.protocol3.f.k0.c;
        WikiSpaceMoreProvider r0 = this.c;
        a r5 = new a(r0);
        BizChecker[] r2 = new BizChecker[2];
        SpaceInfo r3 = r0.s;
        if (r3 != null) goto L5;
    L10:
        boolean r4 = false;
    L11:
        r2[0] = new BizChecker(r4);
        SpacePerm r6 = this.c.t;
        if (r6 != null) goto L14;
    L16:
        boolean r7 = false;
    L17:
        if (r7 == true) goto L26;
        if (r6 != null) goto L20;
    L22:
        boolean r8 = false;
    L23:
        if (r8 == true) goto L26;
        boolean r9 = false;
    L27:
        r2[1] = new BizChecker(r9);
        List r10 = CollectionsKt.listOf(r2);
        this.c.r.a.b();
        return com.bytedance.ee.bear.more.protocol3.g.i(this, r1, null, r10, CollectionsKt.listOf(new BizChecker(false)), r5, 2);
    L20:
        if (r6.isWikiMember != true) goto L22;
        r8 = true;
    L26:
        r9 = true;
        goto L27
    L14:
        if (r6.canManageSpace != true) goto L16;
        r7 = true;
        goto L17
    L5:
        if (r3.isDocsLib() != true) goto L7;
        boolean r11 = true;
    L8:
        if (r11 == true) goto L10;
        r4 = true;
        goto L11
    L7:
        r11 = false;
        goto L8
    }

    public t0(WikiSpaceMoreProvider r1) {
        this.c = r1;
    }
}
