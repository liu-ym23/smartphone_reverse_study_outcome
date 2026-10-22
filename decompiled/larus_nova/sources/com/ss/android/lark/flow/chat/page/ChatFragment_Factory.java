package com.ss.android.lark.flow.chat.page;

import com.ss.android.lark.chat.chatwindow.chat.preloaderv2.d;
import dagger.internal.Factory;
import javax.inject.Provider;
import jdb.g;

/* JADX INFO: loaded from: classes36.dex */
public final class ChatFragment_Factory implements Factory<ChatFragment> {
    private final Provider<oya.a> chatFragmentFactoryProvider;
    private final Provider<d> dataPreLoaderV2Provider;
    private final Provider<g> fgServiceProvider;

    public static ChatFragment newInstance() {
        return new ChatFragment();
    }

    @Override // javax.inject.Provider
    public ChatFragment get() {
        ChatFragment r100 = newInstance();
        r100.f422696g = this.chatFragmentFactoryProvider.get();
        r100.f422697h = this.fgServiceProvider.get();
        r100.f422698i = this.dataPreLoaderV2Provider.get();
        return r100;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ChatFragment_Factory(Provider<oya.a> r100, Provider<g> r101, Provider<d> r102) {
        this.chatFragmentFactoryProvider = r100;
        this.fgServiceProvider = r101;
        this.dataPreLoaderV2Provider = r102;
    }

    public static ChatFragment_Factory create(Provider<oya.a> r100, Provider<g> r101, Provider<d> r102) {
        return new ChatFragment_Factory(r100, r101, r102);
    }
}
