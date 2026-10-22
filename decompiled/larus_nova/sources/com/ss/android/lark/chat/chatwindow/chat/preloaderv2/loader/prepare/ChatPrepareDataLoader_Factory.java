package com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.prepare;

import com.ss.android.lark.im.sdk.service.ImSdkChatService;
import com.ss.android.lark.im.sdk.service.h;
import com.ss.android.lark.im.sdk.service.x;
import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;
import m6b.t;

/* JADX INFO: loaded from: classes35.dex */
public final class ChatPrepareDataLoader_Factory implements Factory<a> {
    private final Provider<ImSdkChatService> chatServiceProvider;
    private final Provider<t> chatterPushProvider;
    private final Provider<h> chatterServiceProvider;
    private final Provider<m> passportProvider;
    private final Provider<x> threadServiceProvider;
    private final Provider<String> userIdProvider;

    @Override // javax.inject.Provider
    public a get() {
        return newInstance(this.passportProvider.get(), this.userIdProvider.get(), this.chatServiceProvider.get(), this.chatterServiceProvider.get(), this.threadServiceProvider.get(), this.chatterPushProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ChatPrepareDataLoader_Factory(Provider<m> r100, Provider<String> r101, Provider<ImSdkChatService> r102, Provider<h> r103, Provider<x> r104, Provider<t> r105) {
        this.passportProvider = r100;
        this.userIdProvider = r101;
        this.chatServiceProvider = r102;
        this.chatterServiceProvider = r103;
        this.threadServiceProvider = r104;
        this.chatterPushProvider = r105;
    }

    public static ChatPrepareDataLoader_Factory create(Provider<m> r100, Provider<String> r101, Provider<ImSdkChatService> r110, Provider<h> r111, Provider<x> r112, Provider<t> r113) {
        return new ChatPrepareDataLoader_Factory(r100, r101, r110, r111, r112, r113);
    }

    public static a newInstance(m r100, String r101, ImSdkChatService r110, h r111, x r112, t r113) {
        return new a(r100, r101, r110, r111, r112, r113);
    }
}
