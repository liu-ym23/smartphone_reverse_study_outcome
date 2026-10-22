package com.ss.android.lark.tab.service;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes38.dex */
public final class ChatTabPush_Factory implements Factory<ChatTabPush> {
    private final Provider<n> pushRepoProvider;

    @Override // javax.inject.Provider
    public ChatTabPush get() {
        return newInstance(this.pushRepoProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ChatTabPush_Factory(Provider<n> r100) {
        this.pushRepoProvider = r100;
    }

    public static ChatTabPush_Factory create(Provider<n> r100) {
        return new ChatTabPush_Factory(r100);
    }

    public static ChatTabPush newInstance(n r100) {
        return new ChatTabPush(r100);
    }
}
