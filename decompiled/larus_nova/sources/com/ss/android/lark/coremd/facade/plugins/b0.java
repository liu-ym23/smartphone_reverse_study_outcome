package com.ss.android.lark.coremd.facade.plugins;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: classes35.dex */
public final class b0<T extends v7b.s> implements com.ss.android.lark.coremd.base.parse.q {
    public b0() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.q
    public final Object a(com.ss.android.lark.coremd.impl.parse.i r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        Context r101 = r100.getContext();
        String r102 = ((v7b.g) r100.f419898d).f553555m;
        if (r102 != null) goto L6;
        r102 = "";
    L6:
        return new x9b.b(r101, r102, r100.getTheme());
    }
}
