package com.ss.android.lark.chat.service.impl;

import com.ss.android.lark.chat.api.service.IChatService;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes35.dex */
public final class ChatSubscribeService_Factory implements Factory<i> {
    private final Provider<IChatService> legacyChatServiceProvider;

    @Override // javax.inject.Provider
    public i get() {
        return newInstance(this.legacyChatServiceProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ChatSubscribeService_Factory(Provider<IChatService> r100) {
        this.legacyChatServiceProvider = r100;
    }

    public static ChatSubscribeService_Factory create(Provider<IChatService> r100) {
        return new ChatSubscribeService_Factory(r100);
    }

    public static i newInstance(IChatService r100) {
        return new i(r100);
    }
}
