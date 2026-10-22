package com.ss.android.lark.tab.service;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes38.dex */
public final class ChatTabExtraService_Factory implements Factory<ChatTabExtraService> {
    private final Provider<k> repoProvider;

    @Override // javax.inject.Provider
    public ChatTabExtraService get() {
        return newInstance(this.repoProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ChatTabExtraService_Factory(Provider<k> r100) {
        this.repoProvider = r100;
    }

    public static ChatTabExtraService_Factory create(Provider<k> r100) {
        return new ChatTabExtraService_Factory(r100);
    }

    public static ChatTabExtraService newInstance(k r100) {
        return new ChatTabExtraService(r100);
    }
}
