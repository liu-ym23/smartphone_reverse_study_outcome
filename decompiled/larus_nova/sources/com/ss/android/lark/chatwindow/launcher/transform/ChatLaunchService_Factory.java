package com.ss.android.lark.chatwindow.launcher.transform;

import com.ss.android.lark.im.sdk.service.ImSdkChatService;
import com.ss.android.lark.im.sdk.service.h;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes35.dex */
public final class ChatLaunchService_Factory implements Factory<ChatLaunchService> {
    private final Provider<ImSdkChatService> chatServiceProvider;
    private final Provider<h> chatterServiceProvider;

    @Override // javax.inject.Provider
    public ChatLaunchService get() {
        return newInstance(this.chatServiceProvider.get(), this.chatterServiceProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ChatLaunchService_Factory(Provider<ImSdkChatService> r100, Provider<h> r101) {
        this.chatServiceProvider = r100;
        this.chatterServiceProvider = r101;
    }

    public static ChatLaunchService_Factory create(Provider<ImSdkChatService> r100, Provider<h> r101) {
        return new ChatLaunchService_Factory(r100, r101);
    }

    public static ChatLaunchService newInstance(ImSdkChatService r100, h r101) {
        return new ChatLaunchService(r100, r101);
    }
}
