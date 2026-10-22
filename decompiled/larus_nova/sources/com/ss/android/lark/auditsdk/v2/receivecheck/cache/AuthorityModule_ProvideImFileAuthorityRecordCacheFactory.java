package com.ss.android.lark.auditsdk.v2.receivecheck.cache;

import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class AuthorityModule_ProvideImFileAuthorityRecordCacheFactory implements Factory<a> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    @Override // javax.inject.Provider
    public a get() {
        return provideImFileAuthorityRecordCache(this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public AuthorityModule_ProvideImFileAuthorityRecordCacheFactory(Provider<j> r100, Provider<v> r101) {
        this.passportProvider = r100;
        this.accessorProvider = r101;
    }

    public static AuthorityModule_ProvideImFileAuthorityRecordCacheFactory create(Provider<j> r100, Provider<v> r101) {
        return new AuthorityModule_ProvideImFileAuthorityRecordCacheFactory(r100, r101);
    }

    public static a provideImFileAuthorityRecordCache(j r100, v r101) {
        int r102 = twa.a.f547803a;
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        b r103 = new b(r100, r101);
        h.a(r103);
        return (a) Preconditions.checkNotNullFromProvides(r103);
    }
}
