package com.ss.android.lark.integrator.im.impl.page;

import com.ss.android.lark.biz.im.api.page.configurator.ConfiguratorType;
import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;
import l3c.c;
import zmb.a;

/* JADX INFO: loaded from: classes36.dex */
public final class ConfiguratorFactoryImpl_Factory implements Factory<a> {
    private final Provider<Map<ConfiguratorType, Provider<c>>> mapProvider;

    @Override // javax.inject.Provider
    public a get() {
        return newInstance(this.mapProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ConfiguratorFactoryImpl_Factory(Provider<Map<ConfiguratorType, Provider<c>>> r100) {
        this.mapProvider = r100;
    }

    public static ConfiguratorFactoryImpl_Factory create(Provider<Map<ConfiguratorType, Provider<c>>> r100) {
        return new ConfiguratorFactoryImpl_Factory(r100);
    }

    public static a newInstance(Map<ConfiguratorType, Provider<c>> r100) {
        return new a(r100);
    }
}
