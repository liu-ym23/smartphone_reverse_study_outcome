package com.bytedance.android.shopping.di;

import dagger.internal.Factory;
import gd3.n;
import sc3.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SkuModuleFallback_ProvideFactory implements Factory<i> {
    private final n module;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public i m855get() {
        return provideInstance(null);
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m855get();
    }

    public SkuModuleFallback_ProvideFactory(n r1) {
    }

    public static SkuModuleFallback_ProvideFactory create(n r1) {
        return new SkuModuleFallback_ProvideFactory(r1);
    }

    public static i provideInstance(n r0) {
        return proxyProvide(r0);
    }

    public static i proxyProvide(n r0) {
        throw null;
    }
}
