package com.ss.lark.android.encryption.userscope;

import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import jkc.c;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class SCCipherManagerGlobalModule_ProvideSCCipherManagerFactory implements Factory<c> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    @Override // javax.inject.Provider
    public c get() {
        return provideSCCipherManager(this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public SCCipherManagerGlobalModule_ProvideSCCipherManagerFactory(Provider<j> r100, Provider<v> r101) {
        this.passportProvider = r100;
        this.accessorProvider = r101;
    }

    public static SCCipherManagerGlobalModule_ProvideSCCipherManagerFactory create(Provider<j> r100, Provider<v> r101) {
        return new SCCipherManagerGlobalModule_ProvideSCCipherManagerFactory(r100, r101);
    }

    public static c provideSCCipherManager(j r100, v r101) {
        int r102 = a.f456813a;
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        b r103 = new b(r100, r101);
        h.a(r103);
        return (c) Preconditions.checkNotNullFromProvides(r103);
    }
}
