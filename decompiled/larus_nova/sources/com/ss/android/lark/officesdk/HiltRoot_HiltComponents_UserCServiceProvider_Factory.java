package com.ss.android.lark.officesdk;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes37.dex */
public final class HiltRoot_HiltComponents_UserCServiceProvider_Factory implements Factory<d1> {
    private final Provider<Map<Class<?>, Provider<Object>>> servicesProvider;

    public static d1 newInstance() {
        return new d1();
    }

    @Override // javax.inject.Provider
    public d1 get() {
        d1 r100 = newInstance();
        r100.f433148a = DoubleCheck.lazy(this.servicesProvider);
        return r100;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public HiltRoot_HiltComponents_UserCServiceProvider_Factory(Provider<Map<Class<?>, Provider<Object>>> r100) {
        this.servicesProvider = r100;
    }

    public static HiltRoot_HiltComponents_UserCServiceProvider_Factory create(Provider<Map<Class<?>, Provider<Object>>> r100) {
        return new HiltRoot_HiltComponents_UserCServiceProvider_Factory(r100);
    }
}
