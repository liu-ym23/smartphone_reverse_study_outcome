package com.bytedance.android.livesdk.livecommerce.di;

import dagger.internal.Factory;
import hh2.d;
import sg2.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class IronListMissionFallbackModule_ProvideFactory implements Factory<w> {
    private final d module;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public w m672get() {
        return provideInstance(this.module);
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m672get();
    }

    public IronListMissionFallbackModule_ProvideFactory(d r1) {
        this.module = r1;
    }

    public static IronListMissionFallbackModule_ProvideFactory create(d r1) {
        return new IronListMissionFallbackModule_ProvideFactory(r1);
    }

    public static w provideInstance(d r0) {
        return proxyProvide(r0);
    }

    public static w proxyProvide(d r0) {
        r0.getClass();
        return null;
    }
}
