package com.ss.android.lark.biz.core.api;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes34.dex */
public final class EmptyQRCodeInterceptorHandler_Factory implements Factory<dxa.a> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final EmptyQRCodeInterceptorHandler_Factory f409792a = null;

        static {
            f409792a = new EmptyQRCodeInterceptorHandler_Factory();
        }
    }

    public EmptyQRCodeInterceptorHandler_Factory() {
    }

    public static dxa.a newInstance() {
        return new dxa.a();
    }

    @Override // javax.inject.Provider
    public dxa.a get() {
        return newInstance();
    }

    public static EmptyQRCodeInterceptorHandler_Factory create() {
        return a.f409792a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
