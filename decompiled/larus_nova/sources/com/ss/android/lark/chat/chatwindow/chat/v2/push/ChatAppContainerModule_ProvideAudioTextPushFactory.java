package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import com.ss.android.lark.chat.service.impl.AudioTextPushProxy;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class ChatAppContainerModule_ProvideAudioTextPushFactory implements Factory<m6b.a> {
    private final Provider<com.ss.android.lark.passportc.internal.v> accessorProvider;
    private final a module;
    private final Provider<com.ss.android.lark.passportc.api.j> passportProvider;

    @Override // javax.inject.Provider
    public m6b.a get() {
        return provideAudioTextPush(this.module, this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ChatAppContainerModule_ProvideAudioTextPushFactory(a r100, Provider<com.ss.android.lark.passportc.api.j> r101, Provider<com.ss.android.lark.passportc.internal.v> r102) {
        this.module = r100;
        this.passportProvider = r101;
        this.accessorProvider = r102;
    }

    public static ChatAppContainerModule_ProvideAudioTextPushFactory create(a r100, Provider<com.ss.android.lark.passportc.api.j> r101, Provider<com.ss.android.lark.passportc.internal.v> r102) {
        return new ChatAppContainerModule_ProvideAudioTextPushFactory(r100, r101, r102);
    }

    public static m6b.a provideAudioTextPush(a r100, com.ss.android.lark.passportc.api.j r101, com.ss.android.lark.passportc.internal.v r102) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "passport");
        Intrinsics.checkNotNullParameter(r102, "accessor");
        AudioTextPushProxy r103 = new AudioTextPushProxy(r101, r102);
        com.ss.android.lark.passportc.api.h.a(r103);
        return (m6b.a) Preconditions.checkNotNullFromProvides(r103);
    }
}
