package com.ss.android.lark.coremd.facade.plugins;

import com.ss.android.lark.coremd.base.theme.HeadingThemeData;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: classes35.dex */
public final class k0<T extends v7b.s> implements com.ss.android.lark.coremd.base.parse.t {
    public k0() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.t
    public final void a(com.ss.android.lark.coremd.impl.parse.k r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        HeadingThemeData r101 = com.ss.android.lark.coremd.base.parse.k.f419543b.e(r100.getTheme());
        if (((Boolean) r101.f419563d.getValue(r101, HeadingThemeData.f419561g[0])).booleanValue() == false) goto L7;
        r100.f419905g.a();
        int r102 = r100.f419905g.length();
        r100.f419904f.c(r100.f419902d);
        com.ss.android.lark.coremd.base.parse.s.a.c(r100.f419905g, r102, 0, 6);
        r100.f419905g.a();
        return;
    }
}
