package com.ss.android.lark.coremd.facade.plugins;

import com.ss.android.lark.coremd.base.theme.InlineCodeThemeData;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: classes35.dex */
public final class e0<T extends v7b.s> implements com.ss.android.lark.coremd.base.parse.t {
    public e0() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.t
    public final void a(com.ss.android.lark.coremd.impl.parse.k r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        InlineCodeThemeData r101 = com.ss.android.lark.coremd.base.parse.k.f419543b.f(r100.getTheme());
        if (((Boolean) r101.f419570d.getValue(r101, InlineCodeThemeData.f419569h[0])).booleanValue() == false) goto L14;
        int r102 = r100.f419905g.length();
        r100.f419905g.g(" ");
        v7b.s r103 = r100.f419902d;
        if (((v7b.d) r103).f553569e != null) goto L11;
        com.ss.android.lark.coremd.base.parse.s r104 = r100.f419905g;
        String r105 = ((v7b.d) r103).f553550j;
        if (r105 != null) goto L10;
        r105 = "";
    L10:
        r104.d(r105);
    L12:
        r100.f419905g.g(" ");
        com.ss.android.lark.coremd.base.parse.s.a.c(r100.f419905g, r102, 0, 6);
        return;
    L11:
        r100.f419904f.c(r103);
        goto L12
    }
}
