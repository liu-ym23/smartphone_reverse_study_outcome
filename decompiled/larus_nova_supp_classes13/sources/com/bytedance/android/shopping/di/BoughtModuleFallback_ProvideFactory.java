package com.bytedance.android.shopping.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import gd3.c;
import gd3.d;
import n83.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class BoughtModuleFallback_ProvideFactory implements Factory<g> {
    private final d module;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public g m847get() {
        return provideInstance(this.module);
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m847get();
    }

    public BoughtModuleFallback_ProvideFactory(d r1) {
        this.module = r1;
    }

    public static BoughtModuleFallback_ProvideFactory create(d r1) {
        return new BoughtModuleFallback_ProvideFactory(r1);
    }

    public static g provideInstance(d r0) {
        return proxyProvide(r0);
    }

    public static g proxyProvide(d r1) {
        r1.getClass();
        return (g) Preconditions.checkNotNull(new c(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
