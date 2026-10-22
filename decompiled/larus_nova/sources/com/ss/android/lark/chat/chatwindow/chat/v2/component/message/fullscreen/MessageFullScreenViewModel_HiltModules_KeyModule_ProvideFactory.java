package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes35.dex */
public final class MessageFullScreenViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final MessageFullScreenViewModel_HiltModules_KeyModule_ProvideFactory f413961a = null;

        static {
            f413961a = new MessageFullScreenViewModel_HiltModules_KeyModule_ProvideFactory();
        }
    }

    public MessageFullScreenViewModel_HiltModules_KeyModule_ProvideFactory() {
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides("com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.MessageFullScreenViewModel");
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static MessageFullScreenViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return a.f413961a;
    }

    @Override // javax.inject.Provider
    public String get() {
        return provide();
    }
}
