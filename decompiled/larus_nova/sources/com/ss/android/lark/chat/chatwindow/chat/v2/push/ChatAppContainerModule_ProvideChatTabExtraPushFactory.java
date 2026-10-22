package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import com.ss.android.lark.tab.service.ChatTabExtraPushProxy;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class ChatAppContainerModule_ProvideChatTabExtraPushFactory implements Factory<com.ss.android.lark.tab.service.i> {
    private final Provider<com.ss.android.lark.passportc.internal.v> accessorProvider;
    private final a module;
    private final Provider<com.ss.android.lark.passportc.api.j> passportProvider;

    @Override // javax.inject.Provider
    public com.ss.android.lark.tab.service.i get() {
        return provideChatTabExtraPush(this.module, this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ChatAppContainerModule_ProvideChatTabExtraPushFactory(a r100, Provider<com.ss.android.lark.passportc.api.j> r101, Provider<com.ss.android.lark.passportc.internal.v> r102) {
        this.module = r100;
        this.passportProvider = r101;
        this.accessorProvider = r102;
    }

    public static ChatAppContainerModule_ProvideChatTabExtraPushFactory create(a r100, Provider<com.ss.android.lark.passportc.api.j> r101, Provider<com.ss.android.lark.passportc.internal.v> r102) {
        return new ChatAppContainerModule_ProvideChatTabExtraPushFactory(r100, r101, r102);
    }

    public static com.ss.android.lark.tab.service.i provideChatTabExtraPush(a r100, com.ss.android.lark.passportc.api.j r101, com.ss.android.lark.passportc.internal.v r102) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "passport");
        Intrinsics.checkNotNullParameter(r102, "accessor");
        ChatTabExtraPushProxy r103 = new ChatTabExtraPushProxy(r101, r102);
        com.ss.android.lark.passportc.api.h.a(r103);
        return (com.ss.android.lark.tab.service.i) Preconditions.checkNotNullFromProvides(r103);
    }
}
