package com.ss.android.lark.keyboard.edittext2.mdeditor.plugins;

import com.ss.android.lark.coremd.impl.parse.j;
import com.ss.android.lark.coremdbiz.facade.plugins.r;
import kotlin.jvm.internal.Intrinsics;
import v7b.l;

/* JADX INFO: loaded from: classes36.dex */
public final class f extends r {
    public f() {
    }

    @Override // com.ss.android.lark.coremdbiz.facade.plugins.r, com.ss.android.lark.coremd.base.parse.g
    public final void c(j.a r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        r100.a(l.class, new e(this));
    }
}
