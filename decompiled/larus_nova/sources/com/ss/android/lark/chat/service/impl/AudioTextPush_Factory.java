package com.ss.android.lark.chat.service.impl;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes35.dex */
public final class AudioTextPush_Factory implements Factory<f> {
    private final Provider<m6b.b> pushRepoProvider;

    @Override // javax.inject.Provider
    public f get() {
        return newInstance(this.pushRepoProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public AudioTextPush_Factory(Provider<m6b.b> r100) {
        this.pushRepoProvider = r100;
    }

    public static AudioTextPush_Factory create(Provider<m6b.b> r100) {
        return new AudioTextPush_Factory(r100);
    }

    public static f newInstance(m6b.b r100) {
        return new f(r100);
    }
}
