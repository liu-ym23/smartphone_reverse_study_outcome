package com.bytedance.android.shopping.di;

import dagger.internal.Factory;
import gd3.f;
import sc3.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CardListKitModuleFallback_ProvideFactory implements Factory<d> {
    private final f module;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public d m849get() {
        return provideInstance(null);
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m849get();
    }

    public CardListKitModuleFallback_ProvideFactory(f r1) {
    }

    public static CardListKitModuleFallback_ProvideFactory create(f r1) {
        return new CardListKitModuleFallback_ProvideFactory(r1);
    }

    public static d provideInstance(f r0) {
        return proxyProvide(r0);
    }

    public static d proxyProvide(f r0) {
        throw null;
    }
}
