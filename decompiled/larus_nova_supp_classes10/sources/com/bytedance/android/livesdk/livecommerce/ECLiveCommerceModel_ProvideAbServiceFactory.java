package com.bytedance.android.livesdk.livecommerce;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import el2.g;
import sg2.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ECLiveCommerceModel_ProvideAbServiceFactory implements Factory<g> {
    private final i module;

    public g get() {
        return provideInstance(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m535get() {
        return get();
    }

    public ECLiveCommerceModel_ProvideAbServiceFactory(i r1) {
        this.module = r1;
    }

    public static ECLiveCommerceModel_ProvideAbServiceFactory create(i r1) {
        return new ECLiveCommerceModel_ProvideAbServiceFactory(r1);
    }

    public static g provideInstance(i r0) {
        return proxyProvideAbService(r0);
    }

    public static g proxyProvideAbService(i r1) {
        r1.getClass();
        return (g) Preconditions.checkNotNull(i.b, "Cannot return null from a non-@Nullable @Provides method");
    }
}
