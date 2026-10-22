package com.suite.lark.platform.component.widget.floatingpanel.impl.integration;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
import yoc.h;
import zoc.b;

/* JADX INFO: loaded from: classes36.dex */
public final class FloatingPanelInitTask_Factory implements Factory<b> {
    private final Provider<h> repositoryProvider;

    public static b newInstance() {
        return new b();
    }

    @Override // javax.inject.Provider
    public b get() {
        b r100 = newInstance();
        r100.f573171a = DoubleCheck.lazy(this.repositoryProvider);
        return r100;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public FloatingPanelInitTask_Factory(Provider<h> r100) {
        this.repositoryProvider = r100;
    }

    public static FloatingPanelInitTask_Factory create(Provider<h> r100) {
        return new FloatingPanelInitTask_Factory(r100);
    }
}
