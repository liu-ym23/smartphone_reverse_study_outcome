package com.bytedance.android.livesdk.livecommerce;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import sg2.b0;
import sg2.d0;
import sg2.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class LiveUserDataCenterModule_ProvideFactory implements Factory<y> {
    private final d0 module;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public y m540get() {
        return provideInstance(this.module);
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m540get();
    }

    public LiveUserDataCenterModule_ProvideFactory(d0 r1) {
        this.module = r1;
    }

    public static LiveUserDataCenterModule_ProvideFactory create(d0 r1) {
        return new LiveUserDataCenterModule_ProvideFactory(r1);
    }

    public static y provideInstance(d0 r0) {
        return proxyProvide(r0);
    }

    public static y proxyProvide(d0 r1) {
        r1.getClass();
        return (y) Preconditions.checkNotNull(new b0(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
