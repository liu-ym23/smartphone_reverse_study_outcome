package com.ss.android.lark.auditsdk.v2.receivecheck.cache;

import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.api.s;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class AuthorityUserScopeModule_ProvideImFileAuthorityRecordCacheFactory implements Factory<a> {
    private final Provider<m> passportServiceProvider;

    @Override // javax.inject.Provider
    public a get() {
        return provideImFileAuthorityRecordCache(this.passportServiceProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public AuthorityUserScopeModule_ProvideImFileAuthorityRecordCacheFactory(Provider<m> r100) {
        this.passportServiceProvider = r100;
    }

    public static AuthorityUserScopeModule_ProvideImFileAuthorityRecordCacheFactory create(Provider<m> r100) {
        return new AuthorityUserScopeModule_ProvideImFileAuthorityRecordCacheFactory(r100);
    }

    public static a provideImFileAuthorityRecordCache(m r100) {
        int r101 = twa.b.f547804a;
        Intrinsics.checkNotNullParameter(r100, "passportService");
        ImFileAsyncRecordCache r102 = new ImFileAsyncRecordCache(r100);
        s.a(r102);
        return (a) Preconditions.checkNotNullFromProvides(r102);
    }
}
