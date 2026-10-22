package com.bytedance.android.shopping.buynow.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import oa3.a;
import sc3.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class BuyNowModule_ProvideFactory implements Factory<c> {
    private final a module;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public c m263get() {
        return provideInstance(this.module);
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m263get();
    }

    public BuyNowModule_ProvideFactory(a r1) {
        this.module = r1;
    }

    public static BuyNowModule_ProvideFactory create(a r1) {
        return new BuyNowModule_ProvideFactory(r1);
    }

    public static c provideInstance(a r0) {
        return proxyProvide(r0);
    }

    public static c proxyProvide(a r1) {
        r1.getClass();
        return (c) Preconditions.checkNotNull(new ta3.a(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
