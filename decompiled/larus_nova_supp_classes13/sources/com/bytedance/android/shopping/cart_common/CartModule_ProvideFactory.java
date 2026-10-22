package com.bytedance.android.shopping.cart_common;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import sc3.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CartModule_ProvideFactory implements Factory<e> {
    private final a module;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public e m624get() {
        return provideInstance(this.module);
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m624get();
    }

    public CartModule_ProvideFactory(a r1) {
        this.module = r1;
    }

    public static CartModule_ProvideFactory create(a r1) {
        return new CartModule_ProvideFactory(r1);
    }

    public static e provideInstance(a r0) {
        return proxyProvide(r0);
    }

    public static e proxyProvide(a r1) {
        r1.getClass();
        return (e) Preconditions.checkNotNull(new b(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
