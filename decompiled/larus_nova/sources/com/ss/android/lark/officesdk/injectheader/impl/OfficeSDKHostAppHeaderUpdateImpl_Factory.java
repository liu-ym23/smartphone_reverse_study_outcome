package com.ss.android.lark.officesdk.injectheader.impl;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class OfficeSDKHostAppHeaderUpdateImpl_Factory implements Factory<OfficeSDKHostAppHeaderUpdateImpl> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OfficeSDKHostAppHeaderUpdateImpl_Factory f433259a = null;

        static {
            f433259a = new OfficeSDKHostAppHeaderUpdateImpl_Factory();
        }
    }

    public OfficeSDKHostAppHeaderUpdateImpl_Factory() {
    }

    public static OfficeSDKHostAppHeaderUpdateImpl newInstance() {
        return new OfficeSDKHostAppHeaderUpdateImpl();
    }

    @Override // javax.inject.Provider
    public OfficeSDKHostAppHeaderUpdateImpl get() {
        return newInstance();
    }

    public static OfficeSDKHostAppHeaderUpdateImpl_Factory create() {
        return a.f433259a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
