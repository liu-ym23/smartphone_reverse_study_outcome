package com.bytedance.android.shopping.di;

import com.bytedance.android.shopping.mall.impl.a;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import gd3.j;
import n83.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class MallModule_ProvideFactory implements Factory<h> {
    private final j module;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public h m853get() {
        return provideInstance(this.module);
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m853get();
    }

    public MallModule_ProvideFactory(j r1) {
        this.module = r1;
    }

    public static MallModule_ProvideFactory create(j r1) {
        return new MallModule_ProvideFactory(r1);
    }

    public static h provideInstance(j r0) {
        return proxyProvide(r0);
    }

    public static h proxyProvide(j r1) {
        r1.getClass();
        return (h) Preconditions.checkNotNull(new a(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
