package com.bytedance.android.livesdk.livecommerce.di;

import dagger.internal.Factory;
import el2.h;
import hh2.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ECDrawerLiveModule_ProvideFactory implements Factory<h> {
    private final b module;

    public h get() {
        return provideInstance(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m670get() {
        return get();
    }

    public ECDrawerLiveModule_ProvideFactory(b r1) {
        this.module = r1;
    }

    public static ECDrawerLiveModule_ProvideFactory create(b r1) {
        return new ECDrawerLiveModule_ProvideFactory(r1);
    }

    public static h provideInstance(b r0) {
        return proxyProvide(r0);
    }

    public static h proxyProvide(b r0) {
        r0.getClass();
        return null;
    }
}
