package com.bytedance.ee.bear.facade.common;

import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import sa5.j;
import sa5.k;

/* JADX INFO: loaded from: classes16.dex */
public final class CCMUserCookiesModule_ProvideUserCookiesAdapterV2Factory implements Factory<j> {
    private final Provider<m> passportProvider;

    @Override // javax.inject.Provider
    public j get() {
        return provideUserCookiesAdapterV2(this.passportProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public CCMUserCookiesModule_ProvideUserCookiesAdapterV2Factory(Provider<m> r100) {
        this.passportProvider = r100;
    }

    public static CCMUserCookiesModule_ProvideUserCookiesAdapterV2Factory create(Provider<m> r100) {
        return new CCMUserCookiesModule_ProvideUserCookiesAdapterV2Factory(r100);
    }

    public static j provideUserCookiesAdapterV2(m r100) {
        int r101 = k.f541172a;
        Intrinsics.checkNotNullParameter(r100, "passport");
        return (j) Preconditions.checkNotNullFromProvides(new j(r100));
    }
}
