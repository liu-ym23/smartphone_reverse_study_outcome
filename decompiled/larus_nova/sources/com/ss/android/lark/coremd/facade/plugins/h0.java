package com.ss.android.lark.coremd.facade.plugins;

import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: classes35.dex */
public final class h0<T extends v7b.s> implements com.ss.android.lark.coremd.base.parse.t {
    public h0() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.t
    public final void a(com.ss.android.lark.coremd.impl.parse.k r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        int r101 = r100.f419905g.length();
        r100.f419905g.a();
        int r102 = r100.f419905g.length();
        if (r101 != r102) goto L5;
        r101 = Math.max(r101 - 1, 0);
    L5:
        com.ss.android.lark.coremd.base.parse.s.a.c(r100.f419905g, r101, r102, 4);
        com.ss.android.lark.coremd.base.parse.s.a.b(r100.f419905g, r101);
    }
}
