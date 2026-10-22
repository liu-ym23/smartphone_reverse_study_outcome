package com.lark.kmp.rustclient.internal;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public abstract class BaseRustClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.lark.kmp.rustclient.api.f f282485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.lark.kmp.rustclient.api.e f282486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<com.lark.kmp.rustclient.api.g> f282487c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f282488d;

    public abstract s c();

    /* JADX WARN: Multi-variable type inference failed */
    public BaseRustClient(com.lark.kmp.rustclient.api.f r100, com.lark.kmp.rustclient.api.e r101, List<? extends com.lark.kmp.rustclient.api.g> r102) {
        Intrinsics.checkNotNullParameter(r100, "rustSDK");
        Intrinsics.checkNotNullParameter(r101, "containerHolder");
        Intrinsics.checkNotNullParameter(r102, "inputInterceptors");
        this.f282485a = r100;
        this.f282486b = r101;
        this.f282487c = r102;
        this.f282488d = LazyKt.lazy(new BaseRustClient$interceptors$2(this));
    }
}
