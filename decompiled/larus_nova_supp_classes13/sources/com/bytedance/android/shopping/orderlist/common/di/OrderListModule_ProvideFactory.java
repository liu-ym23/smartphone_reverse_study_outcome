package com.bytedance.android.shopping.orderlist.common.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import fg3.a;
import sc3.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class OrderListModule_ProvideFactory implements Factory<h> {
    private final a module;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public h m1858get() {
        return provideInstance(this.module);
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m1858get();
    }

    public OrderListModule_ProvideFactory(a r1) {
        this.module = r1;
    }

    public static OrderListModule_ProvideFactory create(a r1) {
        return new OrderListModule_ProvideFactory(r1);
    }

    public static h provideInstance(a r0) {
        return proxyProvide(r0);
    }

    public static h proxyProvide(a r1) {
        r1.getClass();
        return (h) Preconditions.checkNotNull(new com.bytedance.android.shopping.orderlist.common.service.a(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
