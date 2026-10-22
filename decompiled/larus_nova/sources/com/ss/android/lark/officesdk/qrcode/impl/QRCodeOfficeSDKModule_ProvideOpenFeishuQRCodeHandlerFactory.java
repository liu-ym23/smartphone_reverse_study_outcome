package com.ss.android.lark.officesdk.qrcode.impl;

import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import owb.b;
import pwb.c;

/* JADX INFO: loaded from: classes37.dex */
public final class QRCodeOfficeSDKModule_ProvideOpenFeishuQRCodeHandlerFactory implements Factory<b> {
    private final c module;

    @Override // javax.inject.Provider
    public b get() {
        return provideOpenFeishuQRCodeHandler(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public QRCodeOfficeSDKModule_ProvideOpenFeishuQRCodeHandlerFactory(c r100) {
        this.module = r100;
    }

    public static QRCodeOfficeSDKModule_ProvideOpenFeishuQRCodeHandlerFactory create(c r100) {
        return new QRCodeOfficeSDKModule_ProvideOpenFeishuQRCodeHandlerFactory(r100);
    }

    public static b provideOpenFeishuQRCodeHandler(c r100) {
        r100.getClass();
        Object r101 = (b) OfficeSDKManager.getHostGlobalService(b.class);
        if (r101 != null) goto L6;
        r101 = new pwb.b();
    L6:
        return (b) Preconditions.checkNotNullFromProvides(r101);
    }
}
