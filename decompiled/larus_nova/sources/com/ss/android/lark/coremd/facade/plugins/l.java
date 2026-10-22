package com.ss.android.lark.coremd.facade.plugins;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class l implements com.ss.android.lark.coremd.base.parse.g {
    public l() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void a(com.ss.android.lark.coremd.impl.parse.l.a r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        r100.a(v7b.b0.class, new f());
        r100.a(v7b.v.class, new g());
        r100.a(v7b.a0.class, new h(this));
        r100.a(v7b.f.class, new i(this));
        r100.a(v7b.e0.class, new j(this));
        r100.a(v7b.z.class, new k(this));
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void b(com.ss.android.lark.coremd.impl.parse.g r100) {
        Intrinsics.checkNotNullParameter(r100, "registry");
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void c(com.ss.android.lark.coremd.impl.parse.j.a r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        r100.a(v7b.a0.class, new b(this));
        r100.a(v7b.f.class, new c(this));
        r100.a(v7b.e0.class, new d(this));
        r100.a(v7b.z.class, new e(this));
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void d(com.ss.android.lark.coremd.impl.parse.c r100) {
        Intrinsics.checkNotNullParameter(r100, "registry");
    }

    public static final x9b.h e(l r100, v7b.s r101) {
        r100.getClass();
        x9b.h r102 = new x9b.h();
        if ((r101 instanceof v7b.a0) == false) goto L6;
        r102.f563010a = true;
        return r102;
    L6:
        if ((r101 instanceof v7b.f) == false) goto L9;
        r102.f563011b = true;
        return r102;
    L9:
        if ((r101 instanceof v7b.e0) == false) goto L12;
        r102.f563012c = true;
        return r102;
    L12:
        if ((r101 instanceof v7b.z) == false) goto L14;
        r102.f563013d = true;
        return r102;
    L14:
        return null;
    }

    public static final void f(l r100, com.ss.android.lark.coremd.impl.parse.k r101) {
        r100.getClass();
        int r102 = r101.f419905g.length();
        r101.f419904f.c(r101.f419902d);
        if (com.ss.android.lark.coremd.base.parse.k.f419543b.h(r101.getTheme()) == false) goto L6;
        com.ss.android.lark.coremd.base.parse.s.a.c(r101.f419905g, r102, 0, 6);
        return;
    }
}
