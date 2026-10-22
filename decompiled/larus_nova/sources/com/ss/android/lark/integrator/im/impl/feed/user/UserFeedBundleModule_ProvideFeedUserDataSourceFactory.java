package com.ss.android.lark.integrator.im.impl.feed.user;

import chb.a;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import vmb.c;
import vmb.d;

/* JADX INFO: loaded from: classes36.dex */
public final class UserFeedBundleModule_ProvideFeedUserDataSourceFactory implements Factory<a> {
    private final d module;
    private final Provider<c> proxyProvider;

    @Override // javax.inject.Provider
    public a get() {
        return provideFeedUserDataSource(this.module, this.proxyProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public UserFeedBundleModule_ProvideFeedUserDataSourceFactory(d r100, Provider<c> r101) {
        this.module = r100;
        this.proxyProvider = r101;
    }

    public static UserFeedBundleModule_ProvideFeedUserDataSourceFactory create(d r100, Provider<c> r101) {
        return new UserFeedBundleModule_ProvideFeedUserDataSourceFactory(r100, r101);
    }

    public static a provideFeedUserDataSource(d r100, c r101) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "proxy");
        return (a) Preconditions.checkNotNullFromProvides(r101);
    }
}
