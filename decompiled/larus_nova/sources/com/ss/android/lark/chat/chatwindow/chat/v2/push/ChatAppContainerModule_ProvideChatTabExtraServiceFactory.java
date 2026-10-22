package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class ChatAppContainerModule_ProvideChatTabExtraServiceFactory implements Factory<com.ss.android.lark.tab.service.l> {
    private final Provider<com.ss.android.lark.passportc.internal.v> accessorProvider;
    private final a module;
    private final Provider<com.ss.android.lark.passportc.api.j> passportProvider;

    @Override // javax.inject.Provider
    public com.ss.android.lark.tab.service.l get() {
        return provideChatTabExtraService(this.module, this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ChatAppContainerModule_ProvideChatTabExtraServiceFactory(a r100, Provider<com.ss.android.lark.passportc.api.j> r101, Provider<com.ss.android.lark.passportc.internal.v> r102) {
        this.module = r100;
        this.passportProvider = r101;
        this.accessorProvider = r102;
    }

    public static ChatAppContainerModule_ProvideChatTabExtraServiceFactory create(a r100, Provider<com.ss.android.lark.passportc.api.j> r101, Provider<com.ss.android.lark.passportc.internal.v> r102) {
        return new ChatAppContainerModule_ProvideChatTabExtraServiceFactory(r100, r101, r102);
    }

    public static com.ss.android.lark.tab.service.l provideChatTabExtraService(a r100, com.ss.android.lark.passportc.api.j r101, com.ss.android.lark.passportc.internal.v r102) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "passport");
        Intrinsics.checkNotNullParameter(r102, "accessor");
        com.ss.android.lark.tab.service.c r103 = new com.ss.android.lark.tab.service.c(r101, r102);
        com.ss.android.lark.passportc.api.h.a(r103);
        return (com.ss.android.lark.tab.service.l) Preconditions.checkNotNullFromProvides(r103);
    }
}
