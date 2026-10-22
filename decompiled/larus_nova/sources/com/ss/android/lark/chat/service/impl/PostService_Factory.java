package com.ss.android.lark.chat.service.impl;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes35.dex */
public final class PostService_Factory implements Factory<v1> {
    private final Provider<m6b.l> repoProvider;

    @Override // javax.inject.Provider
    public v1 get() {
        return newInstance(this.repoProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public PostService_Factory(Provider<m6b.l> r100) {
        this.repoProvider = r100;
    }

    public static PostService_Factory create(Provider<m6b.l> r100) {
        return new PostService_Factory(r100);
    }

    public static v1 newInstance(m6b.l r100) {
        return new v1(r100);
    }
}
