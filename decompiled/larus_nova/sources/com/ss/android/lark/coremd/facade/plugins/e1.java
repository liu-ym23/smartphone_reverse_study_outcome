package com.ss.android.lark.coremd.facade.plugins;

import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: classes35.dex */
public final class e1<T extends v7b.s> implements com.ss.android.lark.coremd.base.parse.t {
    public e1() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.t
    public final void a(com.ss.android.lark.coremd.impl.parse.k r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        if (com.ss.android.lark.coremd.base.parse.k.f419543b.c(r100.getTheme()).l() == false) goto L14;
        r100.f419905g.a();
        int r101 = r100.f419905g.length();
        v7b.s r102 = r100.f419902d;
        if (((v7b.q) r102).f553570f != null) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        r100.f419905g.d("\u200b");
    L12:
        com.ss.android.lark.coremd.base.parse.s.a.c(r100.f419905g, r101, 0, 6);
        r100.f419905g.a();
        return;
    L11:
        r100.f419904f.c(r102);
        goto L12
    L8:
        r103 = false;
        goto L9
    }
}
