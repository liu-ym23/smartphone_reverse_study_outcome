package com.lark.kmp.rustclient.internal;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class p extends BaseRustDispatcher {
    @Override // rpc.b
    public final void h(rpc.a r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        k(r100);
    }

    @Override // rpc.b
    public final void i(rpc.c r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        j(r100);
    }

    public p(List<? extends com.lark.kmp.rustclient.api.c> r100, r r101) {
        Intrinsics.checkNotNullParameter(r100, "interceptors");
        Intrinsics.checkNotNullParameter(r101, "definition");
        super(r100, r101.c(), r101.a());
    }
}
