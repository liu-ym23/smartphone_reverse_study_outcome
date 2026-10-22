package com.ss.android.lark.coremd.facade.plugins;

import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: classes35.dex */
public final class z0<T extends v7b.s> implements com.ss.android.lark.coremd.base.parse.t {
    public z0() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.t
    public final void a(com.ss.android.lark.coremd.impl.parse.k r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        if (com.ss.android.lark.coremd.base.parse.k.f419543b.g(r100.getTheme()).i() == false) goto L17;
        int r101 = r100.f419905g.length();
        v7b.s r102 = r100.f419902d;
        String r103 = ((v7b.n) r102).f553561j;
        String r104 = ((v7b.n) r102).f553562k;
        if (r104 != null) goto L8;
    L11:
        boolean r105 = true;
    L12:
        if (r105 == false) goto L14;
        com.ss.android.lark.coremd.base.parse.s r106 = r100.f419905g;
        Intrinsics.checkNotNull(r103);
        r106.d(r103);
    L15:
        com.ss.android.lark.coremd.base.parse.s.a.c(r100.f419905g, r101, 0, 6);
        com.ss.android.lark.coremd.base.parse.s.a.a(r100.f419905g, r101);
        com.ss.android.lark.coremd.base.parse.s.a.b(r100.f419905g, r101);
        return;
    L14:
        r100.f419905g.d(r104);
        goto L15
    L8:
        if (r104.length() == 0) goto L11;
        r105 = false;
        goto L12
    }
}
