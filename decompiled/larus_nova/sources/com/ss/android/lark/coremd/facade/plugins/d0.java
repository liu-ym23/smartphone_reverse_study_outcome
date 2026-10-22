package com.ss.android.lark.coremd.facade.plugins;

import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: classes35.dex */
public final class d0<T extends v7b.s> implements com.ss.android.lark.coremd.base.parse.t {
    public d0() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.t
    public final void a(com.ss.android.lark.coremd.impl.parse.k r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        if (com.ss.android.lark.coremd.base.parse.k.f419543b.d(r100.getTheme()).h() == false) goto L7;
        r100.f419905g.a();
        int r101 = r100.f419905g.length();
        r100.f419905g.g(" \n");
        r100.f419905g.d(((v7b.g) r100.f419902d).f553556n);
        r100.f419905g.a().g(" ");
        com.ss.android.lark.coremd.base.parse.s.a.c(r100.f419905g, r101, 0, 6);
        com.ss.android.lark.coremd.base.parse.s.a.b(r100.f419905g, r101);
        return;
    }
}
