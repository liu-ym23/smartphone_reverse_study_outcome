package com.bytedance.ee.bear.diskmanager.container;

import by4.a;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes16.dex */
public final class CCMUserFileStorage_Factory implements Factory<a> {
    private final Provider<String> uidProvider;

    @Override // javax.inject.Provider
    public a get() {
        return newInstance(this.uidProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public CCMUserFileStorage_Factory(Provider<String> r100) {
        this.uidProvider = r100;
    }

    public static CCMUserFileStorage_Factory create(Provider<String> r100) {
        return new CCMUserFileStorage_Factory(r100);
    }

    public static a newInstance(String r100) {
        return new a(r100);
    }
}
