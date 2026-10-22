package com.bytedance.ee.bear.facade.common;

import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import sa5.i;
import sa5.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class CCMUserCookiesModule_ProvideUserCookiesAdapterFactory implements Factory<i> {
    private final Provider<m> passportProvider;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public i m381get() {
        return provideUserCookiesAdapter((m) this.passportProvider.get());
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m381get();
    }

    public CCMUserCookiesModule_ProvideUserCookiesAdapterFactory(Provider<m> r1) {
        this.passportProvider = r1;
    }

    public static CCMUserCookiesModule_ProvideUserCookiesAdapterFactory create(Provider<m> r1) {
        return new CCMUserCookiesModule_ProvideUserCookiesAdapterFactory(r1);
    }

    public static i provideUserCookiesAdapter(m r1) {
        int r0 = k.a;
        Intrinsics.checkNotNullParameter(r1, "passport");
        return (i) Preconditions.checkNotNullFromProvides(new i(r1));
    }
}
