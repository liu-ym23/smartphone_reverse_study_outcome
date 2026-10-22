package com.ss.android.lark.chat.utils;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes35.dex */
public final class PushChatRelationListenerManager_Factory implements Factory<x0> {
    private final Provider<m6b.d> chatSubscribeServiceProvider;

    @Override // javax.inject.Provider
    public x0 get() {
        return newInstance(this.chatSubscribeServiceProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public PushChatRelationListenerManager_Factory(Provider<m6b.d> r100) {
        this.chatSubscribeServiceProvider = r100;
    }

    public static PushChatRelationListenerManager_Factory create(Provider<m6b.d> r100) {
        return new PushChatRelationListenerManager_Factory(r100);
    }

    public static x0 newInstance(m6b.d r100) {
        return new x0(r100);
    }
}
