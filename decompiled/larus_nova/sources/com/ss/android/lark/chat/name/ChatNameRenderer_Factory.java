package com.ss.android.lark.chat.name;

import com.ss.android.lark.chat.api.service.IChatService;
import com.ss.android.lark.chat.api.service.ITranslateService;
import dagger.internal.Factory;
import javax.inject.Provider;
import jdb.g;

/* JADX INFO: loaded from: classes35.dex */
public final class ChatNameRenderer_Factory implements Factory<a> {
    private final Provider<IChatService> chatServiceProvider;
    private final Provider<g> fgServiceProvider;
    private final Provider<ITranslateService> translateServiceProvider;

    @Override // javax.inject.Provider
    public a get() {
        return newInstance(this.chatServiceProvider.get(), this.translateServiceProvider.get(), this.fgServiceProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ChatNameRenderer_Factory(Provider<IChatService> r100, Provider<ITranslateService> r101, Provider<g> r102) {
        this.chatServiceProvider = r100;
        this.translateServiceProvider = r101;
        this.fgServiceProvider = r102;
    }

    public static ChatNameRenderer_Factory create(Provider<IChatService> r100, Provider<ITranslateService> r101, Provider<g> r102) {
        return new ChatNameRenderer_Factory(r100, r101, r102);
    }

    public static a newInstance(IChatService r100, ITranslateService r101, g r102) {
        return new a(r100, r101, r102);
    }
}
