package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import com.ss.android.lark.chat.service.impl.NewAudio2TextPushProxy;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class ChatAppContainerModule_ProvideNewAudio2TextPushFactory implements Factory<com.ss.android.lark.audio.voiceinput.service.l> {
    private final Provider<com.ss.android.lark.passportc.internal.v> accessorProvider;
    private final a module;
    private final Provider<com.ss.android.lark.passportc.api.j> passportProvider;

    @Override // javax.inject.Provider
    public com.ss.android.lark.audio.voiceinput.service.l get() {
        return provideNewAudio2TextPush(this.module, this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ChatAppContainerModule_ProvideNewAudio2TextPushFactory(a r100, Provider<com.ss.android.lark.passportc.api.j> r101, Provider<com.ss.android.lark.passportc.internal.v> r102) {
        this.module = r100;
        this.passportProvider = r101;
        this.accessorProvider = r102;
    }

    public static ChatAppContainerModule_ProvideNewAudio2TextPushFactory create(a r100, Provider<com.ss.android.lark.passportc.api.j> r101, Provider<com.ss.android.lark.passportc.internal.v> r102) {
        return new ChatAppContainerModule_ProvideNewAudio2TextPushFactory(r100, r101, r102);
    }

    public static com.ss.android.lark.audio.voiceinput.service.l provideNewAudio2TextPush(a r100, com.ss.android.lark.passportc.api.j r101, com.ss.android.lark.passportc.internal.v r102) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "passport");
        Intrinsics.checkNotNullParameter(r102, "accessor");
        NewAudio2TextPushProxy r103 = new NewAudio2TextPushProxy(r101, r102);
        com.ss.android.lark.passportc.api.h.a(r103);
        return (com.ss.android.lark.audio.voiceinput.service.l) Preconditions.checkNotNullFromProvides(r103);
    }
}
