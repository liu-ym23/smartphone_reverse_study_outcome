package com.ss.android.lark.integrator.im.impl.feed.user;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import vmb.a;
import vmb.c;
import vmb.d;

/* JADX INFO: loaded from: classes36.dex */
public final class UserFeedBundleModule_ProvideUserFeedBundleFactory implements Factory<a> {
    private final d module;
    private final Provider<c> proxyProvider;

    @Override // javax.inject.Provider
    public a get() {
        return provideUserFeedBundle(this.module, this.proxyProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public UserFeedBundleModule_ProvideUserFeedBundleFactory(d r100, Provider<c> r101) {
        this.module = r100;
        this.proxyProvider = r101;
    }

    public static UserFeedBundleModule_ProvideUserFeedBundleFactory create(d r100, Provider<c> r101) {
        return new UserFeedBundleModule_ProvideUserFeedBundleFactory(r100, r101);
    }

    public static a provideUserFeedBundle(d r100, c r101) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "proxy");
        return (a) Preconditions.checkNotNullFromProvides(r101);
    }
}
