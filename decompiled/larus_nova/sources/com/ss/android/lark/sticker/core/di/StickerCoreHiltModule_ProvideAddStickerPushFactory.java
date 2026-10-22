package com.ss.android.lark.sticker.core.di;

import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class StickerCoreHiltModule_ProvideAddStickerPushFactory implements Factory<e6c.a> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    @Override // javax.inject.Provider
    public e6c.a get() {
        return provideAddStickerPush(this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public StickerCoreHiltModule_ProvideAddStickerPushFactory(Provider<j> r100, Provider<v> r101) {
        this.passportProvider = r100;
        this.accessorProvider = r101;
    }

    public static StickerCoreHiltModule_ProvideAddStickerPushFactory create(Provider<j> r100, Provider<v> r101) {
        return new StickerCoreHiltModule_ProvideAddStickerPushFactory(r100, r101);
    }

    public static e6c.a provideAddStickerPush(j r100, v r101) {
        int r102 = b.f440790a;
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        AddStickerPushProxy r103 = new AddStickerPushProxy(r100, r101);
        h.a(r103);
        return (e6c.a) Preconditions.checkNotNullFromProvides(r103);
    }
}
