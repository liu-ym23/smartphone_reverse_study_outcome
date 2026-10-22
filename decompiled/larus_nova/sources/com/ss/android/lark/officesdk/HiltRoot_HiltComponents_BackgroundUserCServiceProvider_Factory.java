package com.ss.android.lark.officesdk;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes37.dex */
public final class HiltRoot_HiltComponents_BackgroundUserCServiceProvider_Factory implements Factory<h0> {
    private final Provider<Map<Class<?>, Provider<Object>>> servicesProvider;

    public static h0 newInstance() {
        return new h0();
    }

    @Override // javax.inject.Provider
    public h0 get() {
        h0 r100 = newInstance();
        r100.f433252a = DoubleCheck.lazy(this.servicesProvider);
        return r100;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public HiltRoot_HiltComponents_BackgroundUserCServiceProvider_Factory(Provider<Map<Class<?>, Provider<Object>>> r100) {
        this.servicesProvider = r100;
    }

    public static HiltRoot_HiltComponents_BackgroundUserCServiceProvider_Factory create(Provider<Map<Class<?>, Provider<Object>>> r100) {
        return new HiltRoot_HiltComponents_BackgroundUserCServiceProvider_Factory(r100);
    }
}
