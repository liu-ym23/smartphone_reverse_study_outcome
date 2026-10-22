package com.bytedance.lark.rustclient.internal;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class j extends d {
    @Override // com.bytedance.lark.sdk.refactor.h
    public final void v(com.bytedance.lark.sdk.refactor.q r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        a(r100);
    }

    @Override // com.bytedance.lark.sdk.refactor.h
    public final void y(com.bytedance.lark.sdk.refactor.b r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        b(r100);
    }

    public j(List<? extends com.bytedance.lark.rustclient.api.j> r100, k r101) {
        Intrinsics.checkNotNullParameter(r100, "interceptors");
        Intrinsics.checkNotNullParameter(r101, "definition");
        super(r100, r101);
    }
}
