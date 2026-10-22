package com.ss.android.lark.officesdk.miaoda.impl;

import com.bytedance.lark.rustclient.api.l;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes37.dex */
public final class MiaodaPrewarmCapacityImpl_Factory implements Factory<a> {
    private final Provider<l> rustClientProvider;

    @Override // javax.inject.Provider
    public a get() {
        return newInstance(this.rustClientProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public MiaodaPrewarmCapacityImpl_Factory(Provider<l> r100) {
        this.rustClientProvider = r100;
    }

    public static MiaodaPrewarmCapacityImpl_Factory create(Provider<l> r100) {
        return new MiaodaPrewarmCapacityImpl_Factory(r100);
    }

    public static a newInstance(l r100) {
        return new a(r100);
    }
}
