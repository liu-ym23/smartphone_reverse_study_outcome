package com.ss.android.lark.passport.assemble;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class OfficeSDKDPoPService_Factory implements Factory<e> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OfficeSDKDPoPService_Factory f437685a = null;

        static {
            f437685a = new OfficeSDKDPoPService_Factory();
        }
    }

    public OfficeSDKDPoPService_Factory() {
    }

    public static e newInstance() {
        return new e();
    }

    @Override // javax.inject.Provider
    public e get() {
        return newInstance();
    }

    public static OfficeSDKDPoPService_Factory create() {
        return a.f437685a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
