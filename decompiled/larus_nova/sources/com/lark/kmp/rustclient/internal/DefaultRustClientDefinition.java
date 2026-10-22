package com.lark.kmp.rustclient.internal;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes24.dex */
public final class DefaultRustClientDefinition implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f282506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f282507b;

    @Override // com.lark.kmp.rustclient.internal.r
    public final void b() {
    }

    @Override // com.lark.kmp.rustclient.internal.r
    public final CoroutineDispatcher a() {
        return (CoroutineDispatcher) this.f282507b.getValue();
    }

    @Override // com.lark.kmp.rustclient.internal.r
    public final CoroutineDispatcher c() {
        return (CoroutineDispatcher) this.f282506a.getValue();
    }

    public DefaultRustClientDefinition() {
        this.f282506a = LazyKt.lazy(DefaultRustClientDefinition$pushDispatcher$2.INSTANCE);
        this.f282507b = LazyKt.lazy(DefaultRustClientDefinition$asyncDispatcher$2.INSTANCE);
    }
}
