package com.ss.android.lark.im.sdk;

import com.ss.android.lark.im.sdk.service.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class ImSdkServiceModule_ProvideChatterServiceFactory implements Factory<h> {
    private final Provider<v> accessorProvider;
    private final b module;
    private final Provider<j> passportProvider;

    @Override // javax.inject.Provider
    public h get() {
        return provideChatterService(this.module, this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ImSdkServiceModule_ProvideChatterServiceFactory(b r100, Provider<j> r101, Provider<v> r102) {
        this.module = r100;
        this.passportProvider = r101;
        this.accessorProvider = r102;
    }

    public static ImSdkServiceModule_ProvideChatterServiceFactory create(b r100, Provider<j> r101, Provider<v> r102) {
        return new ImSdkServiceModule_ProvideChatterServiceFactory(r100, r101, r102);
    }

    public static h provideChatterService(b r100, j r101, v r102) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "passport");
        Intrinsics.checkNotNullParameter(r102, "accessor");
        com.ss.android.lark.im.sdk.usercontainer.b r103 = new com.ss.android.lark.im.sdk.usercontainer.b(r101, r102);
        com.ss.android.lark.passportc.api.h.a(r103);
        return (h) Preconditions.checkNotNullFromProvides(r103);
    }
}
