package com.ss.android.lark.integrator.im.impl.page;

import com.ss.android.lark.biz.im.api.page.plugin.PluginType;
import com.ss.android.lark.scaffold.PagePlugin;
import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;
import zmb.b;

/* JADX INFO: loaded from: classes36.dex */
public final class PluginFactoryImpl_Factory implements Factory<b> {
    private final Provider<Map<PluginType, Provider<PagePlugin>>> mapProvider;

    @Override // javax.inject.Provider
    public b get() {
        return newInstance(this.mapProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public PluginFactoryImpl_Factory(Provider<Map<PluginType, Provider<PagePlugin>>> r100) {
        this.mapProvider = r100;
    }

    public static PluginFactoryImpl_Factory create(Provider<Map<PluginType, Provider<PagePlugin>>> r100) {
        return new PluginFactoryImpl_Factory(r100);
    }

    public static b newInstance(Map<PluginType, Provider<PagePlugin>> r100) {
        return new b(r100);
    }
}
