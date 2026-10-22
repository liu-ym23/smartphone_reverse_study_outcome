package com.bytedance.locallife.pdp.container.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class o implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ww6.l f261201a;

    public o(ww6.l r100) {
        Intrinsics.checkNotNullParameter(r100, "preBizApiRequestProvider");
        this.f261201a = r100;
    }

    @Override // com.bytedance.locallife.pdp.container.impl.k
    public final boolean a(String r100) {
        return this.f261201a.a(r100);
    }
}
