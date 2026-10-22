package com.ss.android.lark.chat.api.service.impl;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes35.dex */
public final class ThreadService_Factory implements Factory<q1> {
    private final Provider<a2b.m> threadRepoProvider;

    @Override // javax.inject.Provider
    public q1 get() {
        return newInstance(this.threadRepoProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ThreadService_Factory(Provider<a2b.m> r100) {
        this.threadRepoProvider = r100;
    }

    public static ThreadService_Factory create(Provider<a2b.m> r100) {
        return new ThreadService_Factory(r100);
    }

    public static q1 newInstance(a2b.m r100) {
        return new q1(r100);
    }
}
