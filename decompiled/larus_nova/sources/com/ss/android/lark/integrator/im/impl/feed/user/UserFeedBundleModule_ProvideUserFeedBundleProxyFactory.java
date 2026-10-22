package com.ss.android.lark.integrator.im.impl.feed.user;

import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import vmb.c;
import vmb.d;

/* JADX INFO: loaded from: classes36.dex */
public final class UserFeedBundleModule_ProvideUserFeedBundleProxyFactory implements Factory<c> {
    private final d module;
    private final Provider<j> passportProvider;

    @Override // javax.inject.Provider
    public c get() {
        return provideUserFeedBundleProxy(this.module, this.passportProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public UserFeedBundleModule_ProvideUserFeedBundleProxyFactory(d r100, Provider<j> r101) {
        this.module = r100;
        this.passportProvider = r101;
    }

    public static UserFeedBundleModule_ProvideUserFeedBundleProxyFactory create(d r100, Provider<j> r101) {
        return new UserFeedBundleModule_ProvideUserFeedBundleProxyFactory(r100, r101);
    }

    public static c provideUserFeedBundleProxy(d r100, j r101) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "passport");
        c r102 = new c(r101);
        h.a(r102);
        return (c) Preconditions.checkNotNullFromProvides(r102);
    }
}
