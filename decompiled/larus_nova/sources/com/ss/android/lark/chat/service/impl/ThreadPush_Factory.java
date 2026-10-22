package com.ss.android.lark.chat.service.impl;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes35.dex */
public final class ThreadPush_Factory implements Factory<k2> {
    private final Provider<m6b.r> repositoryProvider;

    @Override // javax.inject.Provider
    public k2 get() {
        return newInstance(this.repositoryProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ThreadPush_Factory(Provider<m6b.r> r100) {
        this.repositoryProvider = r100;
    }

    public static ThreadPush_Factory create(Provider<m6b.r> r100) {
        return new ThreadPush_Factory(r100);
    }

    public static k2 newInstance(m6b.r r100) {
        return new k2(r100);
    }
}
