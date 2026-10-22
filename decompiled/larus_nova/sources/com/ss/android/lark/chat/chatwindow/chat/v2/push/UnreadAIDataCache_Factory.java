package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes35.dex */
public final class UnreadAIDataCache_Factory implements Factory<n0> {
    private final Provider<com.ss.android.lark.passportc.api.m> passportProvider;

    @Override // javax.inject.Provider
    public n0 get() {
        return newInstance(this.passportProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public UnreadAIDataCache_Factory(Provider<com.ss.android.lark.passportc.api.m> r100) {
        this.passportProvider = r100;
    }

    public static UnreadAIDataCache_Factory create(Provider<com.ss.android.lark.passportc.api.m> r100) {
        return new UnreadAIDataCache_Factory(r100);
    }

    public static n0 newInstance(com.ss.android.lark.passportc.api.m r100) {
        return new n0(r100);
    }
}
