package com.ss.android.lark.search.doubao.env;

import b4c.d;
import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class SearchCommonServiceModule_ProvideASLRustClientFactory implements Factory<d> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    @Override // javax.inject.Provider
    public d get() {
        return provideASLRustClient(this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public SearchCommonServiceModule_ProvideASLRustClientFactory(Provider<j> r100, Provider<v> r101) {
        this.passportProvider = r100;
        this.accessorProvider = r101;
    }

    public static SearchCommonServiceModule_ProvideASLRustClientFactory create(Provider<j> r100, Provider<v> r101) {
        return new SearchCommonServiceModule_ProvideASLRustClientFactory(r100, r101);
    }

    public static d provideASLRustClient(j r100, v r101) {
        int r102 = c.f440110a;
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        a r103 = new a(r100, r101);
        h.a(r103);
        return (d) Preconditions.checkNotNullFromProvides(r103);
    }
}
