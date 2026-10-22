package com.ss.android.lark.coremd.facade.plugins;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class p implements com.ss.android.lark.coremd.base.parse.g {
    public p() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void a(com.ss.android.lark.coremd.impl.parse.l.a r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        r100.a(v7b.b.class, new o(this));
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void b(com.ss.android.lark.coremd.impl.parse.g r100) {
        Intrinsics.checkNotNullParameter(r100, "registry");
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void c(com.ss.android.lark.coremd.impl.parse.j.a r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        r100.a(v7b.b.class, new n());
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void d(com.ss.android.lark.coremd.impl.parse.c r100) {
        Intrinsics.checkNotNullParameter(r100, "registry");
        r100.f419875b.add(new m());
    }
}
