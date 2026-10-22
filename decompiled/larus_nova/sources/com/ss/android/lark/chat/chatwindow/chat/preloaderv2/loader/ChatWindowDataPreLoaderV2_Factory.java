package com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader;

import com.ss.android.lark.im.sdk.service.p;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes35.dex */
public final class ChatWindowDataPreLoaderV2_Factory implements Factory<b> {
    private final Provider<p> messageServiceProvider;

    @Override // javax.inject.Provider
    public b get() {
        return newInstance(this.messageServiceProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ChatWindowDataPreLoaderV2_Factory(Provider<p> r100) {
        this.messageServiceProvider = r100;
    }

    public static ChatWindowDataPreLoaderV2_Factory create(Provider<p> r100) {
        return new ChatWindowDataPreLoaderV2_Factory(r100);
    }

    public static b newInstance(p r100) {
        return new b(r100);
    }
}
