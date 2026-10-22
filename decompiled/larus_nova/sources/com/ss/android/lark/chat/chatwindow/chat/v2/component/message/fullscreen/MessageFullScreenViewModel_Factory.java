package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes35.dex */
public final class MessageFullScreenViewModel_Factory implements Factory<MessageFullScreenViewModel> {
    private final Provider<jdb.g> fgServiceProvider;
    private final Provider<com.ss.android.lark.im.sdk.service.p> messageServiceProvider;

    @Override // javax.inject.Provider
    public MessageFullScreenViewModel get() {
        return newInstance(this.messageServiceProvider.get(), this.fgServiceProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public MessageFullScreenViewModel_Factory(Provider<com.ss.android.lark.im.sdk.service.p> r100, Provider<jdb.g> r101) {
        this.messageServiceProvider = r100;
        this.fgServiceProvider = r101;
    }

    public static MessageFullScreenViewModel_Factory create(Provider<com.ss.android.lark.im.sdk.service.p> r100, Provider<jdb.g> r101) {
        return new MessageFullScreenViewModel_Factory(r100, r101);
    }

    public static MessageFullScreenViewModel newInstance(com.ss.android.lark.im.sdk.service.p r100, jdb.g r101) {
        return new MessageFullScreenViewModel(r100, r101);
    }
}
