package com.suite.lark.platform.component.qrcode.di;

import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import soc.a;
import soc.b;
import soc.d;

/* JADX INFO: loaded from: classes36.dex */
public final class QRCodeDwarfModule_ProvideHandlerProviderFactory implements Factory<a> {
    private final Provider<v> accessorProvider;
    private final b module;
    private final Provider<j> passportProvider;

    @Override // javax.inject.Provider
    public a get() {
        return provideHandlerProvider(this.module, this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public QRCodeDwarfModule_ProvideHandlerProviderFactory(b r100, Provider<j> r101, Provider<v> r102) {
        this.module = r100;
        this.passportProvider = r101;
        this.accessorProvider = r102;
    }

    public static QRCodeDwarfModule_ProvideHandlerProviderFactory create(b r100, Provider<j> r101, Provider<v> r102) {
        return new QRCodeDwarfModule_ProvideHandlerProviderFactory(r100, r101, r102);
    }

    public static a provideHandlerProvider(b r100, j r101, v r102) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "passport");
        Intrinsics.checkNotNullParameter(r102, "accessor");
        d r103 = new d(r101, r102);
        h.a(r103);
        return (a) Preconditions.checkNotNullFromProvides(r103);
    }
}
