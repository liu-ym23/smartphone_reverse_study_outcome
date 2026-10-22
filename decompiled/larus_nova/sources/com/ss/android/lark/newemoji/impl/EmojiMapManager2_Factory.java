package com.ss.android.lark.newemoji.impl;

import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes36.dex */
public final class EmojiMapManager2_Factory implements Factory<EmojiMapManager2> {
    private final Provider<m> passportProvider;

    @Override // javax.inject.Provider
    public EmojiMapManager2 get() {
        return newInstance(this.passportProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public EmojiMapManager2_Factory(Provider<m> r100) {
        this.passportProvider = r100;
    }

    public static EmojiMapManager2_Factory create(Provider<m> r100) {
        return new EmojiMapManager2_Factory(r100);
    }

    public static EmojiMapManager2 newInstance(m r100) {
        return new EmojiMapManager2(r100);
    }
}
