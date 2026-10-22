package com.bytedance.ee.bear.init;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes16.dex */
public final class OfficeCCMGlobalInitImpl_Factory implements Factory<c> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OfficeCCMGlobalInitImpl_Factory f227069a = null;

        static {
            f227069a = new OfficeCCMGlobalInitImpl_Factory();
        }
    }

    public OfficeCCMGlobalInitImpl_Factory() {
    }

    public static c newInstance() {
        return new c();
    }

    @Override // javax.inject.Provider
    public c get() {
        return newInstance();
    }

    public static OfficeCCMGlobalInitImpl_Factory create() {
        return a.f227069a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
