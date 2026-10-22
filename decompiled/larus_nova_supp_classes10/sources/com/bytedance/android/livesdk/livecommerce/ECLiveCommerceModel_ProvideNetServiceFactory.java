package com.bytedance.android.livesdk.livecommerce;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import el2.l;
import sg2.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ECLiveCommerceModel_ProvideNetServiceFactory implements Factory<l> {
    private final i module;

    public l get() {
        return provideInstance(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m538get() {
        return get();
    }

    public ECLiveCommerceModel_ProvideNetServiceFactory(i r1) {
        this.module = r1;
    }

    public static ECLiveCommerceModel_ProvideNetServiceFactory create(i r1) {
        return new ECLiveCommerceModel_ProvideNetServiceFactory(r1);
    }

    public static l provideInstance(i r0) {
        return proxyProvideNetService(r0);
    }

    public static l proxyProvideNetService(i r1) {
        r1.getClass();
        return (l) Preconditions.checkNotNull(i.a, "Cannot return null from a non-@Nullable @Provides method");
    }
}
