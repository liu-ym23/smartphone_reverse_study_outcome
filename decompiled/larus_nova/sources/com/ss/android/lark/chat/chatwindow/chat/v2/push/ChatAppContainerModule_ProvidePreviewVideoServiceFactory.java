package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import com.ss.android.lark.chat.service.impl.x1;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class ChatAppContainerModule_ProvidePreviewVideoServiceFactory implements Factory<m6b.n> {
    private final Provider<com.ss.android.lark.passportc.internal.v> accessorProvider;
    private final a module;
    private final Provider<com.ss.android.lark.passportc.api.j> passportProvider;

    @Override // javax.inject.Provider
    public m6b.n get() {
        return providePreviewVideoService(this.module, this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ChatAppContainerModule_ProvidePreviewVideoServiceFactory(a r100, Provider<com.ss.android.lark.passportc.api.j> r101, Provider<com.ss.android.lark.passportc.internal.v> r102) {
        this.module = r100;
        this.passportProvider = r101;
        this.accessorProvider = r102;
    }

    public static ChatAppContainerModule_ProvidePreviewVideoServiceFactory create(a r100, Provider<com.ss.android.lark.passportc.api.j> r101, Provider<com.ss.android.lark.passportc.internal.v> r102) {
        return new ChatAppContainerModule_ProvidePreviewVideoServiceFactory(r100, r101, r102);
    }

    public static m6b.n providePreviewVideoService(a r100, com.ss.android.lark.passportc.api.j r101, com.ss.android.lark.passportc.internal.v r102) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "passport");
        Intrinsics.checkNotNullParameter(r102, "accessor");
        x1 r103 = new x1(r101, r102);
        com.ss.android.lark.passportc.api.h.a(r103);
        return (m6b.n) Preconditions.checkNotNullFromProvides(r103);
    }
}
