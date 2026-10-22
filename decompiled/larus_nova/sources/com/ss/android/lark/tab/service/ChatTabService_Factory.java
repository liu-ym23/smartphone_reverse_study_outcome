package com.ss.android.lark.tab.service;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes38.dex */
public final class ChatTabService_Factory implements Factory<g> {
    private final Provider<o> chatTabRepoProvider;

    @Override // javax.inject.Provider
    public g get() {
        return newInstance(this.chatTabRepoProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ChatTabService_Factory(Provider<o> r100) {
        this.chatTabRepoProvider = r100;
    }

    public static ChatTabService_Factory create(Provider<o> r100) {
        return new ChatTabService_Factory(r100);
    }

    public static g newInstance(o r100) {
        return new g(r100);
    }
}
