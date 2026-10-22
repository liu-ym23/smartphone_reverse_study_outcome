package com.ss.android.lark.sticker.core.di;

import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class StickerCoreHiltModule_ProvideCustomStickerServiceFactory implements Factory<e6c.c> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    @Override // javax.inject.Provider
    public e6c.c get() {
        return provideCustomStickerService(this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public StickerCoreHiltModule_ProvideCustomStickerServiceFactory(Provider<j> r100, Provider<v> r101) {
        this.passportProvider = r100;
        this.accessorProvider = r101;
    }

    public static StickerCoreHiltModule_ProvideCustomStickerServiceFactory create(Provider<j> r100, Provider<v> r101) {
        return new StickerCoreHiltModule_ProvideCustomStickerServiceFactory(r100, r101);
    }

    public static e6c.c provideCustomStickerService(j r100, v r101) {
        int r102 = b.f440790a;
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        a r103 = new a(r100, r101);
        h.a(r103);
        return (e6c.c) Preconditions.checkNotNullFromProvides(r103);
    }
}
