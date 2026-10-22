package com.bytedance.lark.rustclient.internal;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public abstract class BaseRustClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.lark.sdk.refactor.l f253943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.lark.sdk.refactor.state.c f253944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<com.bytedance.lark.rustclient.api.m> f253945c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f253946d;

    public abstract l m();

    public abstract Long n();

    public abstract String o();

    public final r l(com.bytedance.lark.rustclient.api.d r100, com.bytedance.lark.rustclient.api.w r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "scopePayload");
        return new r((List) this.f253946d.getValue(), new com.bytedance.lark.rustclient.api.b(r100, r101, o(), n()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BaseRustClient(com.bytedance.lark.sdk.refactor.l r100, com.bytedance.lark.sdk.refactor.state.c r101, List<? extends com.bytedance.lark.rustclient.api.m> r102) {
        Intrinsics.checkNotNullParameter(r100, "rustSDK");
        Intrinsics.checkNotNullParameter(r101, "rustContext");
        Intrinsics.checkNotNullParameter(r102, "inputInterceptors");
        this.f253943a = r100;
        this.f253944b = r101;
        this.f253945c = r102;
        this.f253946d = LazyKt.lazy(new BaseRustClient$interceptors$2(this));
    }
}
