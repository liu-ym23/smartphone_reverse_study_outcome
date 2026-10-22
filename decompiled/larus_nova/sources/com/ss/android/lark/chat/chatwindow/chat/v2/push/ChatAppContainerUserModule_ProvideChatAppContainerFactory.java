package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class ChatAppContainerUserModule_ProvideChatAppContainerFactory implements Factory<v> {
    private final Provider<ChatAppContainerV2> chatAppContainerV2Provider;
    private final b module;

    @Override // javax.inject.Provider
    public v get() {
        return provideChatAppContainer(this.module, this.chatAppContainerV2Provider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ChatAppContainerUserModule_ProvideChatAppContainerFactory(b r100, Provider<ChatAppContainerV2> r101) {
        this.module = r100;
        this.chatAppContainerV2Provider = r101;
    }

    public static ChatAppContainerUserModule_ProvideChatAppContainerFactory create(b r100, Provider<ChatAppContainerV2> r101) {
        return new ChatAppContainerUserModule_ProvideChatAppContainerFactory(r100, r101);
    }

    public static v provideChatAppContainer(b r100, ChatAppContainerV2 r101) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "chatAppContainerV2");
        return (v) Preconditions.checkNotNullFromProvides(r101);
    }
}
