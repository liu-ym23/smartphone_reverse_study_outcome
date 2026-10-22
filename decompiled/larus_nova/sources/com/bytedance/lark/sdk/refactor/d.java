package com.bytedance.lark.sdk.refactor;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class d implements j {
    public d() {
    }

    @Override // com.bytedance.lark.sdk.refactor.j
    public final void a(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
    }

    @Override // com.bytedance.lark.sdk.refactor.j
    public final void b(long r100, boolean r101, byte[] r102, boolean r103, boolean r104, String r105, se6.b r106) {
        Intrinsics.checkNotNullParameter(r102, "data");
        Intrinsics.checkNotNullParameter(r105, "userId");
    }
}
