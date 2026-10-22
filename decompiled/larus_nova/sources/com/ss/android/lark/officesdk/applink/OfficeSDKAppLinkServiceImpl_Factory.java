package com.ss.android.lark.officesdk.applink;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class OfficeSDKAppLinkServiceImpl_Factory implements Factory<OfficeSDKAppLinkServiceImpl> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OfficeSDKAppLinkServiceImpl_Factory f433097a = null;

        static {
            f433097a = new OfficeSDKAppLinkServiceImpl_Factory();
        }
    }

    public OfficeSDKAppLinkServiceImpl_Factory() {
    }

    public static OfficeSDKAppLinkServiceImpl newInstance() {
        return new OfficeSDKAppLinkServiceImpl();
    }

    @Override // javax.inject.Provider
    public OfficeSDKAppLinkServiceImpl get() {
        return newInstance();
    }

    public static OfficeSDKAppLinkServiceImpl_Factory create() {
        return a.f433097a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
