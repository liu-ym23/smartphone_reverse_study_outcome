package com.ss.android.lark.tab.service;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes38.dex */
public final class ChatTabExtraPush_Factory implements Factory<ChatTabExtraPush> {
    private final Provider<j> pushRepoProvider;

    @Override // javax.inject.Provider
    public ChatTabExtraPush get() {
        return newInstance(this.pushRepoProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ChatTabExtraPush_Factory(Provider<j> r100) {
        this.pushRepoProvider = r100;
    }

    public static ChatTabExtraPush_Factory create(Provider<j> r100) {
        return new ChatTabExtraPush_Factory(r100);
    }

    public static ChatTabExtraPush newInstance(j r100) {
        return new ChatTabExtraPush(r100);
    }
}
