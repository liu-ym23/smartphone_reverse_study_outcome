package com.ss.android.lark.officesdk.qrcode.impl;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class OpenFeishuQRCodeHandlerImpl_Factory implements Factory<pwb.a> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OpenFeishuQRCodeHandlerImpl_Factory f437161a = null;

        static {
            f437161a = new OpenFeishuQRCodeHandlerImpl_Factory();
        }
    }

    public OpenFeishuQRCodeHandlerImpl_Factory() {
    }

    public static pwb.a newInstance() {
        return new pwb.a();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static OpenFeishuQRCodeHandlerImpl_Factory create() {
        return a.f437161a;
    }

    @Override // javax.inject.Provider
    public pwb.a get() {
        return newInstance();
    }
}
