package com.ss.android.lark.screenprotect.userscope;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class ScreenProtectGlobalModule_ProvideScreenProtectServiceFactory implements Factory<b> {
    private final Provider<a> screenProtectGlobalManagerProvider;

    @Override // javax.inject.Provider
    public b get() {
        return provideScreenProtectService(this.screenProtectGlobalManagerProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ScreenProtectGlobalModule_ProvideScreenProtectServiceFactory(Provider<a> r100) {
        this.screenProtectGlobalManagerProvider = r100;
    }

    public static ScreenProtectGlobalModule_ProvideScreenProtectServiceFactory create(Provider<a> r100) {
        return new ScreenProtectGlobalModule_ProvideScreenProtectServiceFactory(r100);
    }

    public static b provideScreenProtectService(a r100) {
        int r101 = f.f439848a;
        Intrinsics.checkNotNullParameter(r100, "screenProtectGlobalManager");
        return (b) Preconditions.checkNotNullFromProvides((b) r100);
    }
}
