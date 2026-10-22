package com.bytedance.android.shopping.di;

import dagger.internal.Factory;
import gd3.l;
import sc3.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class OrderListModuleFallback_ProvideFactory implements Factory<h> {
    private final l module;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public h m854get() {
        return provideInstance(null);
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m854get();
    }

    public OrderListModuleFallback_ProvideFactory(l r1) {
    }

    public static OrderListModuleFallback_ProvideFactory create(l r1) {
        return new OrderListModuleFallback_ProvideFactory(r1);
    }

    public static h provideInstance(l r0) {
        return proxyProvide(r0);
    }

    public static h proxyProvide(l r0) {
        throw null;
    }
}
