package com.suite.lark.platform.component.widget.floatingpanel.impl;

import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes36.dex */
public final class FloatingPanelService_Factory implements Factory<FloatingPanelService> {
    private final Provider<m> passportProvider;

    @Override // javax.inject.Provider
    public FloatingPanelService get() {
        return newInstance(this.passportProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public FloatingPanelService_Factory(Provider<m> r100) {
        this.passportProvider = r100;
    }

    public static FloatingPanelService_Factory create(Provider<m> r100) {
        return new FloatingPanelService_Factory(r100);
    }

    public static FloatingPanelService newInstance(m r100) {
        return new FloatingPanelService(r100);
    }
}
