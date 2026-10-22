package com.ss.android.lark.newemoji.impl;

import com.bytedance.lark.rustclient.api.l;
import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes36.dex */
public final class EmojiService2_Factory implements Factory<EmojiService2> {
    private final Provider<rsb.a> emojiMapManagerProvider;
    private final Provider<m> passportProvider;
    private final Provider<l> rustClientProvider;

    @Override // javax.inject.Provider
    public EmojiService2 get() {
        return newInstance(this.passportProvider.get(), this.rustClientProvider.get(), this.emojiMapManagerProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public EmojiService2_Factory(Provider<m> r100, Provider<l> r101, Provider<rsb.a> r102) {
        this.passportProvider = r100;
        this.rustClientProvider = r101;
        this.emojiMapManagerProvider = r102;
    }

    public static EmojiService2_Factory create(Provider<m> r100, Provider<l> r101, Provider<rsb.a> r102) {
        return new EmojiService2_Factory(r100, r101, r102);
    }

    public static EmojiService2 newInstance(m r100, l r101, rsb.a r102) {
        return new EmojiService2(r100, r101, r102);
    }
}
