package com.ss.android.lark.officesdk.internal;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class OfficeSDKGlobalApiImpl_Factory implements Factory<e> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OfficeSDKGlobalApiImpl_Factory f433323a = null;

        static {
            f433323a = new OfficeSDKGlobalApiImpl_Factory();
        }
    }

    public OfficeSDKGlobalApiImpl_Factory() {
    }

    public static e newInstance() {
        return new e();
    }

    @Override // javax.inject.Provider
    public e get() {
        return newInstance();
    }

    public static OfficeSDKGlobalApiImpl_Factory create() {
        return a.f433323a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
