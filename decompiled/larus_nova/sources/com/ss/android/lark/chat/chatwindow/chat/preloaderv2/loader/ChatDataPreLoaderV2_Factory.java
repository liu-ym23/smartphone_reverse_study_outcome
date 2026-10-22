package com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader;

import com.ss.android.lark.im.sdk.service.ImSdkChatService;
import com.ss.android.lark.im.sdk.service.p;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes35.dex */
public final class ChatDataPreLoaderV2_Factory implements Factory<ChatDataPreLoaderV2> {
    private final Provider<ImSdkChatService> chatServiceProvider;
    private final Provider<p> messageServiceProvider;
    private final Provider<com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.prepare.b> prepareDataLoaderProvider;

    @Override // javax.inject.Provider
    public ChatDataPreLoaderV2 get() {
        return newInstance(this.chatServiceProvider.get(), this.messageServiceProvider.get(), this.prepareDataLoaderProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ChatDataPreLoaderV2_Factory(Provider<ImSdkChatService> r100, Provider<p> r101, Provider<com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.prepare.b> r102) {
        this.chatServiceProvider = r100;
        this.messageServiceProvider = r101;
        this.prepareDataLoaderProvider = r102;
    }

    public static ChatDataPreLoaderV2_Factory create(Provider<ImSdkChatService> r100, Provider<p> r101, Provider<com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.prepare.b> r102) {
        return new ChatDataPreLoaderV2_Factory(r100, r101, r102);
    }

    public static ChatDataPreLoaderV2 newInstance(ImSdkChatService r100, p r101, com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.prepare.b r102) {
        return new ChatDataPreLoaderV2(r100, r101, r102);
    }
}
