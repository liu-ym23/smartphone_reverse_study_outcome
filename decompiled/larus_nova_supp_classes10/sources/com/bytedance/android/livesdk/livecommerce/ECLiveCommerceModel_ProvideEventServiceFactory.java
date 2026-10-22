package com.bytedance.android.livesdk.livecommerce;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import el2.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ECLiveCommerceModel_ProvideEventServiceFactory implements Factory<i> {
    private final sg2.i module;

    public i get() {
        return provideInstance(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m536get() {
        return get();
    }

    public ECLiveCommerceModel_ProvideEventServiceFactory(sg2.i r1) {
        this.module = r1;
    }

    public static ECLiveCommerceModel_ProvideEventServiceFactory create(sg2.i r1) {
        return new ECLiveCommerceModel_ProvideEventServiceFactory(r1);
    }

    public static i provideInstance(sg2.i r0) {
        return proxyProvideEventService(r0);
    }

    public static i proxyProvideEventService(sg2.i r1) {
        r1.getClass();
        return (i) Preconditions.checkNotNull(sg2.i.c, "Cannot return null from a non-@Nullable @Provides method");
    }
}
