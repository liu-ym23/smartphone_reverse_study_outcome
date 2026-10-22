package com.bytedance.android.livesdk.livecommerce.di;

import dagger.internal.Factory;
import el2.n;
import hh2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class SaasCouponFallbackModule_ProvideFactory implements Factory<n> {
    private final h module;

    public n get() {
        return provideInstance(null);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m673get() {
        return get();
    }

    public SaasCouponFallbackModule_ProvideFactory(h r1) {
    }

    public static SaasCouponFallbackModule_ProvideFactory create(h r1) {
        return new SaasCouponFallbackModule_ProvideFactory(r1);
    }

    public static n provideInstance(h r0) {
        return proxyProvide(r0);
    }

    public static n proxyProvide(h r0) {
        throw null;
    }
}
