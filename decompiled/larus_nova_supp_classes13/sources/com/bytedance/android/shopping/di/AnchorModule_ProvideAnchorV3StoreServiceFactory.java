package com.bytedance.android.shopping.di;

import com.bytedance.android.shopping.anchorv3.ECAnchorV3Helper;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import gd3.a;
import p83.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class AnchorModule_ProvideAnchorV3StoreServiceFactory implements Factory<e> {
    private final a module;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public e m844get() {
        return provideInstance(this.module);
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m844get();
    }

    public AnchorModule_ProvideAnchorV3StoreServiceFactory(a r1) {
        this.module = r1;
    }

    public static AnchorModule_ProvideAnchorV3StoreServiceFactory create(a r1) {
        return new AnchorModule_ProvideAnchorV3StoreServiceFactory(r1);
    }

    public static e provideInstance(a r0) {
        return proxyProvideAnchorV3StoreService(r0);
    }

    public static e proxyProvideAnchorV3StoreService(a r1) {
        r1.getClass();
        return (e) Preconditions.checkNotNull(ECAnchorV3Helper.a, "Cannot return null from a non-@Nullable @Provides method");
    }
}
