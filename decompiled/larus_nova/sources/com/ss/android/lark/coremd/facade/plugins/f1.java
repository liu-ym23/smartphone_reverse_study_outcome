package com.ss.android.lark.coremd.facade.plugins;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class f1 implements com.ss.android.lark.coremd.base.parse.g {
    public f1() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void a(com.ss.android.lark.coremd.impl.parse.l.a r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        r100.a(v7b.c.class, new c1(this));
        r100.a(v7b.u.class, new d1(this));
        r100.a(v7b.q.class, new e1());
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void b(com.ss.android.lark.coremd.impl.parse.g r100) {
        Intrinsics.checkNotNullParameter(r100, "registry");
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void c(com.ss.android.lark.coremd.impl.parse.j.a r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        r100.a(v7b.q.class, new b1(this));
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void d(com.ss.android.lark.coremd.impl.parse.c r100) {
        Intrinsics.checkNotNullParameter(r100, "registry");
    }

    public final int f(v7b.s r100) {
        v7b.s r101 = ((v7b.a) r100).f553568d;
    L3:
        v7b.a r102 = (v7b.a) r101;
        if ((r102 instanceof v7b.u) == true) goto L14;
        if ((r102 instanceof v7b.c) == true) goto L14;
        if ((r102 instanceof v7b.i) == true) goto L11;
        return -1;
    L11:
        return ((v7b.i) r102).f553557j;
    L14:
        r101 = ((v7b.p) r102).f553568d;
        goto L3
    }

    public static final void e(f1 r100, com.ss.android.lark.coremd.impl.parse.k r101) {
        r100.getClass();
        if (com.ss.android.lark.coremd.base.parse.k.f419543b.c(r101.getTheme()).l() == false) goto L7;
        r101.f419905g.a();
        int r102 = r101.f419905g.length();
        r101.f419904f.c(r101.f419902d);
        com.ss.android.lark.coremd.base.parse.s.a.c(r101.f419905g, r102, 0, 6);
        return;
    }
}
