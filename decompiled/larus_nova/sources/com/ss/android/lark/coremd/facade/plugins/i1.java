package com.ss.android.lark.coremd.facade.plugins;

import com.ss.android.lark.coremd.base.theme.ThematicBreakThemeData;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: classes35.dex */
public final class i1<T extends v7b.s> implements com.ss.android.lark.coremd.base.parse.t {
    public i1() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.t
    public final void a(com.ss.android.lark.coremd.impl.parse.k r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        ThematicBreakThemeData r101 = com.ss.android.lark.coremd.base.parse.k.f419543b.i(r100.getTheme());
        if (((Boolean) r101.f419584d.getValue(r101, ThematicBreakThemeData.f419583g[0])).booleanValue() == false) goto L7;
        r100.f419905g.a();
        int r102 = r100.f419905g.length();
        r100.f419905g.d("\u200b");
        com.ss.android.lark.coremd.base.parse.s.a.c(r100.f419905g, r102, 0, 6);
        r100.f419905g.a();
        com.ss.android.lark.coremd.base.parse.s.a.b(r100.f419905g, r102);
        return;
    }
}
