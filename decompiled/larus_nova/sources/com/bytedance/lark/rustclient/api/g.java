package com.bytedance.lark.rustclient.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class g implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f253914a;

    public g(l r100) {
        Intrinsics.checkNotNullParameter(r100, "client");
        this.f253914a = r100;
    }

    @Override // com.bytedance.lark.rustclient.api.i
    public final <Resp, Req> k<Resp> d(f<Resp, Req> r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        return this.f253914a.h(r100.b());
    }
}
