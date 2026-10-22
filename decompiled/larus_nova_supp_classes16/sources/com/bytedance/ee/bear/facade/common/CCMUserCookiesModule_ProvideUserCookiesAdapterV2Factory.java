package com.bytedance.ee.bear.facade.common;

import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import sa5.j;
import sa5.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class CCMUserCookiesModule_ProvideUserCookiesAdapterV2Factory implements Factory<j> {
    private final Provider<m> passportProvider;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public j m382get() {
        return provideUserCookiesAdapterV2((m) this.passportProvider.get());
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m382get();
    }

    public CCMUserCookiesModule_ProvideUserCookiesAdapterV2Factory(Provider<m> r1) {
        this.passportProvider = r1;
    }

    public static CCMUserCookiesModule_ProvideUserCookiesAdapterV2Factory create(Provider<m> r1) {
        return new CCMUserCookiesModule_ProvideUserCookiesAdapterV2Factory(r1);
    }

    public static j provideUserCookiesAdapterV2(m r1) {
        int r0 = k.a;
        Intrinsics.checkNotNullParameter(r1, "passport");
        return (j) Preconditions.checkNotNullFromProvides(new j(r1));
    }
}
