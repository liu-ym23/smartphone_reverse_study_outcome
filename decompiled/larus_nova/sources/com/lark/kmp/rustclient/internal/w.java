package com.lark.kmp.rustclient.internal;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;

/* JADX INFO: loaded from: classes24.dex */
public final class w<Resp> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<com.lark.kmp.rustclient.api.g> f282564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.lark.kmp.rustclient.api.a<Resp> f282565b;

    public final FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 a() {
        com.lark.kmp.rustclient.api.h r100 = new com.lark.kmp.rustclient.api.h(this.f282564a, 0, this.f282565b);
        com.lark.kmp.rustclient.a.a(r100.f282460c.f282454a, "start to async invoke.");
        return new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(r100.b(this.f282565b), new RustCall$enqueue$1(r100, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public w(List<? extends com.lark.kmp.rustclient.api.g> r100, com.lark.kmp.rustclient.api.a<Resp> r101) {
        Intrinsics.checkNotNullParameter(r100, "interceptors");
        Intrinsics.checkNotNullParameter(r101, "input");
        this.f282564a = r100;
        this.f282565b = r101;
    }
}
