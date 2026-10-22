package com.ss.android.lark.biz.im.api.message.audit;

import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class AuthResourceUserScopeManagerModule_ProvideAuthResourceUserScopeManagerFactory implements Factory<f> {
    private final Provider<v> accessorProvider;
    private final c module;
    private final Provider<j> passportProvider;

    @Override // javax.inject.Provider
    public f get() {
        return provideAuthResourceUserScopeManager(this.module, this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public AuthResourceUserScopeManagerModule_ProvideAuthResourceUserScopeManagerFactory(c r100, Provider<j> r101, Provider<v> r102) {
        this.module = r100;
        this.passportProvider = r101;
        this.accessorProvider = r102;
    }

    public static AuthResourceUserScopeManagerModule_ProvideAuthResourceUserScopeManagerFactory create(c r100, Provider<j> r101, Provider<v> r102) {
        return new AuthResourceUserScopeManagerModule_ProvideAuthResourceUserScopeManagerFactory(r100, r101, r102);
    }

    public static f provideAuthResourceUserScopeManager(c r100, j r101, v r102) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "passport");
        Intrinsics.checkNotNullParameter(r102, "accessor");
        d r103 = new d(r101, r102);
        h.a(r103);
        return (f) Preconditions.checkNotNullFromProvides(r103);
    }
}
