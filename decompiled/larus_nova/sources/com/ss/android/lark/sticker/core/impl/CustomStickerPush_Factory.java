package com.ss.android.lark.sticker.core.impl;

import com.bytedance.lark.rustclient.api.l;
import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes38.dex */
public final class CustomStickerPush_Factory implements Factory<c> {
    private final Provider<m> passportProvider;
    private final Provider<l> rustClientProvider;

    @Override // javax.inject.Provider
    public c get() {
        return newInstance(this.passportProvider.get(), this.rustClientProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public CustomStickerPush_Factory(Provider<m> r100, Provider<l> r101) {
        this.passportProvider = r100;
        this.rustClientProvider = r101;
    }

    public static CustomStickerPush_Factory create(Provider<m> r100, Provider<l> r101) {
        return new CustomStickerPush_Factory(r100, r101);
    }

    public static c newInstance(m r100, l r101) {
        return new c(r100, r101);
    }
}
