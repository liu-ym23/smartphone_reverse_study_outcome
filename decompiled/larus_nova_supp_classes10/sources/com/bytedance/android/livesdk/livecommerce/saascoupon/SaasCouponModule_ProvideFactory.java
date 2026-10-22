package com.bytedance.android.livesdk.livecommerce.saascoupon;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import el2.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class SaasCouponModule_ProvideFactory implements Factory<n> {
    private final a module;

    public n get() {
        return provideInstance(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1239get() {
        return get();
    }

    public SaasCouponModule_ProvideFactory(a r1) {
        this.module = r1;
    }

    public static SaasCouponModule_ProvideFactory create(a r1) {
        return new SaasCouponModule_ProvideFactory(r1);
    }

    public static n provideInstance(a r0) {
        return proxyProvide(r0);
    }

    public static n proxyProvide(a r1) {
        r1.getClass();
        return (n) Preconditions.checkNotNull(new SaasCouponService(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
