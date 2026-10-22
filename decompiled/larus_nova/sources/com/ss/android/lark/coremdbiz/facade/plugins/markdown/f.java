package com.ss.android.lark.coremdbiz.facade.plugins.markdown;

import com.ss.android.lark.coremd.base.parse.t;
import com.ss.android.lark.coremd.impl.parse.k;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: classes35.dex */
public final class f<T extends s> implements t {
    public f() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.t
    public final void a(k r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        int r101 = r100.f419905g.length();
        r100.f419905g.d("￼");
        com.ss.android.lark.coremd.base.parse.s.a.c(r100.f419905g, r101, 0, 6);
        com.ss.android.lark.coremd.base.parse.s.a.b(r100.f419905g, r101);
    }
}
