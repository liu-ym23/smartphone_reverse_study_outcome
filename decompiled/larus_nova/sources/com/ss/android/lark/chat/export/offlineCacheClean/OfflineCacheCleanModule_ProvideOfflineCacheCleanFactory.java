package com.ss.android.lark.chat.export.offlineCacheClean;

import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class OfflineCacheCleanModule_ProvideOfflineCacheCleanFactory implements Factory<a> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    @Override // javax.inject.Provider
    public a get() {
        return provideOfflineCacheClean(this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public OfflineCacheCleanModule_ProvideOfflineCacheCleanFactory(Provider<j> r100, Provider<v> r101) {
        this.passportProvider = r100;
        this.accessorProvider = r101;
    }

    public static OfflineCacheCleanModule_ProvideOfflineCacheCleanFactory create(Provider<j> r100, Provider<v> r101) {
        return new OfflineCacheCleanModule_ProvideOfflineCacheCleanFactory(r100, r101);
    }

    public static a provideOfflineCacheClean(j r100, v r101) {
        int r102 = d.f415416a;
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        e r103 = new e(r100, r101);
        h.a(r103);
        return (a) Preconditions.checkNotNullFromProvides(r103);
    }
}
