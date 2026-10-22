package com.suite.lark.platform.component.qrcode.di;

import dagger.internal.Factory;
import java.util.Set;
import javax.inject.Provider;
import soc.c;

/* JADX INFO: loaded from: classes36.dex */
public final class QRCodeHandlerProvider_Factory implements Factory<c> {
    private final Provider<Set<dxa.c>> interceptorsProvider;

    @Override // javax.inject.Provider
    public c get() {
        return newInstance(this.interceptorsProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public QRCodeHandlerProvider_Factory(Provider<Set<dxa.c>> r100) {
        this.interceptorsProvider = r100;
    }

    public static QRCodeHandlerProvider_Factory create(Provider<Set<dxa.c>> r100) {
        return new QRCodeHandlerProvider_Factory(r100);
    }

    public static c newInstance(Set<dxa.c> r100) {
        return new c(r100);
    }
}
