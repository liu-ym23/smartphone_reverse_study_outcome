package com.bytedance.android.shopping.sku.inner.service;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import qh3.a;
import qh3.b;
import sc3.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SkuYataModule_ProvideFactory implements Factory<i> {
    private final b module;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public i m2893get() {
        return provideInstance(this.module);
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m2893get();
    }

    public SkuYataModule_ProvideFactory(b r1) {
        this.module = r1;
    }

    public static SkuYataModule_ProvideFactory create(b r1) {
        return new SkuYataModule_ProvideFactory(r1);
    }

    public static i provideInstance(b r0) {
        return proxyProvide(r0);
    }

    public static i proxyProvide(b r1) {
        r1.getClass();
        return (i) Preconditions.checkNotNull(new a(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
