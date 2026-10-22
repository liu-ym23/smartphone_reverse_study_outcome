package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class UnreadAIDataCacheModule_ProvideUnreadAIDataCacheFactory implements Factory<z> {
    private final Provider<com.ss.android.lark.passportc.internal.v> accessorProvider;
    private final Provider<com.ss.android.lark.passportc.api.j> passportProvider;

    @Override // javax.inject.Provider
    public z get() {
        return provideUnreadAIDataCache(this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public UnreadAIDataCacheModule_ProvideUnreadAIDataCacheFactory(Provider<com.ss.android.lark.passportc.api.j> r100, Provider<com.ss.android.lark.passportc.internal.v> r101) {
        this.passportProvider = r100;
        this.accessorProvider = r101;
    }

    public static UnreadAIDataCacheModule_ProvideUnreadAIDataCacheFactory create(Provider<com.ss.android.lark.passportc.api.j> r100, Provider<com.ss.android.lark.passportc.internal.v> r101) {
        return new UnreadAIDataCacheModule_ProvideUnreadAIDataCacheFactory(r100, r101);
    }

    public static z provideUnreadAIDataCache(com.ss.android.lark.passportc.api.j r100, com.ss.android.lark.passportc.internal.v r101) {
        int r102 = o0.f414646a;
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        p0 r103 = new p0(r100, r101);
        com.ss.android.lark.passportc.api.h.a(r103);
        return (z) Preconditions.checkNotNullFromProvides(r103);
    }
}
