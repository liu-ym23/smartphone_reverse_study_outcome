package com.ss.android.lark.coremdbiz.facade.plugins;

import com.ss.android.lark.coremdbiz.facade.bizext.LarkThemeExtend;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: classes35.dex */
public final class c<T extends v7b.s> implements com.ss.android.lark.coremd.base.parse.t {
    public c() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.t
    public final void a(final com.ss.android.lark.coremd.impl.parse.k r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        int r101 = r100.f419905g.length();
        r100.f419905g.d("@" + ((eab.a) r100.f419902d).f471733j);
        if (((Boolean) LarkThemeExtend.f419998m.b(new AtPlugin$configureVisitor$1$1(r100))).booleanValue() == false) goto L7;
        com.ss.android.lark.coremd.base.parse.s.a.c(r100.f419905g, r101, 0, 6);
        com.ss.android.lark.coremd.base.parse.s.a.a(r100.f419905g, r101);
        com.ss.android.lark.coremd.base.parse.s.a.b(r100.f419905g, r101);
        return;
    }
}
