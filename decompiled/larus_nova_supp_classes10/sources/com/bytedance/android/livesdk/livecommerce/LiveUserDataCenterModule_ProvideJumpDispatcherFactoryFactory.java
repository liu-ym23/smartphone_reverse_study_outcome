package com.bytedance.android.livesdk.livecommerce;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import fi2.b;
import sg2.c0;
import sg2.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class LiveUserDataCenterModule_ProvideJumpDispatcherFactoryFactory implements Factory<b> {
    private final d0 module;

    public b get() {
        return provideInstance(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m541get() {
        return get();
    }

    public LiveUserDataCenterModule_ProvideJumpDispatcherFactoryFactory(d0 r1) {
        this.module = r1;
    }

    public static LiveUserDataCenterModule_ProvideJumpDispatcherFactoryFactory create(d0 r1) {
        return new LiveUserDataCenterModule_ProvideJumpDispatcherFactoryFactory(r1);
    }

    public static b provideInstance(d0 r0) {
        return proxyProvideJumpDispatcherFactory(r0);
    }

    public static b proxyProvideJumpDispatcherFactory(d0 r1) {
        r1.getClass();
        return (b) Preconditions.checkNotNull(new c0(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
