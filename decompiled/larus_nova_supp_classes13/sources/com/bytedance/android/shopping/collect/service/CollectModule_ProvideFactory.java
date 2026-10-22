package com.bytedance.android.shopping.collect.service;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import rb3.a;
import rb3.b;
import sc3.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CollectModule_ProvideFactory implements Factory<g> {
    private final a module;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public g m691get() {
        return provideInstance(this.module);
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m691get();
    }

    public CollectModule_ProvideFactory(a r1) {
        this.module = r1;
    }

    public static CollectModule_ProvideFactory create(a r1) {
        return new CollectModule_ProvideFactory(r1);
    }

    public static g provideInstance(a r0) {
        return proxyProvide(r0);
    }

    public static g proxyProvide(a r1) {
        r1.getClass();
        return (g) Preconditions.checkNotNull(new b(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
