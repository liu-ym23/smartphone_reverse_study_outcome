package com.bytedance.ee.bear.facade.common;

import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import sa5.i;
import sa5.k;

/* JADX INFO: loaded from: classes16.dex */
public final class CCMUserCookiesModule_ProvideUserCookiesAdapterFactory implements Factory<i> {
    private final Provider<m> passportProvider;

    @Override // javax.inject.Provider
    public i get() {
        return provideUserCookiesAdapter(this.passportProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public CCMUserCookiesModule_ProvideUserCookiesAdapterFactory(Provider<m> r100) {
        this.passportProvider = r100;
    }

    public static CCMUserCookiesModule_ProvideUserCookiesAdapterFactory create(Provider<m> r100) {
        return new CCMUserCookiesModule_ProvideUserCookiesAdapterFactory(r100);
    }

    public static i provideUserCookiesAdapter(m r100) {
        int r101 = k.f541172a;
        Intrinsics.checkNotNullParameter(r100, "passport");
        return (i) Preconditions.checkNotNullFromProvides(new i(r100));
    }
}
