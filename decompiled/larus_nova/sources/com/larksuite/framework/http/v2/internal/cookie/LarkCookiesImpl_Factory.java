package com.larksuite.framework.http.v2.internal.cookie;

import android.content.Context;
import d28.b;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes24.dex */
public final class LarkCookiesImpl_Factory implements Factory<b> {
    private final Provider<Context> contextProvider;

    @Override // javax.inject.Provider
    public b get() {
        return newInstance(this.contextProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public LarkCookiesImpl_Factory(Provider<Context> r100) {
        this.contextProvider = r100;
    }

    public static LarkCookiesImpl_Factory create(Provider<Context> r100) {
        return new LarkCookiesImpl_Factory(r100);
    }

    public static b newInstance(Context r100) {
        return new b(r100);
    }
}
