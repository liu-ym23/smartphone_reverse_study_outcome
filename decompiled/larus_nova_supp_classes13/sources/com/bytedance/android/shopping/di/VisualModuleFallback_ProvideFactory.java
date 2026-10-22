package com.bytedance.android.shopping.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import gd3.o;
import gd3.p;
import n83.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class VisualModuleFallback_ProvideFactory implements Factory<i> {
    private final p module;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public i m856get() {
        return provideInstance(this.module);
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m856get();
    }

    public VisualModuleFallback_ProvideFactory(p r1) {
        this.module = r1;
    }

    public static VisualModuleFallback_ProvideFactory create(p r1) {
        return new VisualModuleFallback_ProvideFactory(r1);
    }

    public static i provideInstance(p r0) {
        return proxyProvide(r0);
    }

    public static i proxyProvide(p r1) {
        r1.getClass();
        return (i) Preconditions.checkNotNull(new o(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
