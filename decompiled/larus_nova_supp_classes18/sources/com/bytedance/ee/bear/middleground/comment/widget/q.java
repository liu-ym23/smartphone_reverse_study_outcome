package com.bytedance.ee.bear.middleground.comment.widget;

import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q<T extends v7b.s> implements com.ss.android.lark.coremd.base.parse.t {
    public final /* synthetic */ m a;

    public q(m r1) {
        this.a = r1;
    }

    public final void a(com.ss.android.lark.coremd.impl.parse.k r6) {
        Intrinsics.checkNotNullParameter(r6, "it");
        if (com.ss.android.lark.coremd.base.parse.k.b.c(r6.getTheme()).l() == false) goto L23;
        e0.a(r6.g, r6.d);
        int r0 = r6.g.length();
        v7b.s r1 = ((v7b.s) r6.d).e;
    L7:
        if (r1 == null) goto L18;
        this.a.getClass();
        if ((r1 instanceof v7b.u) == false) goto L11;
    L14:
        boolean r3 = true;
    L15:
        if (r3 == true) goto L18;
        v7b.s r2 = r1.h;
        r6.f.a(r1);
        r1 = r2;
        goto L7
    L11:
        if ((r1 instanceof v7b.c) == true) goto L14;
        r3 = false;
    L18:
        if (r6.g.length() != r0) goto L20;
        r6.g.d("\u200b");
    L20:
        com.ss.android.lark.coremd.base.parse.s.a.c(r6.g, r0, 0, 6);
        r6.g.a();
    L21:
        if (r1 == null) goto L27;
        v7b.s r4 = r1.h;
        r6.f.a(r1);
        r1 = r4;
        goto L21
    L27:
        return;
    }
}
