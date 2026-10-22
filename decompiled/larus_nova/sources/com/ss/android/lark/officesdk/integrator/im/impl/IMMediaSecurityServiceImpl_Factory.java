package com.ss.android.lark.officesdk.integrator.im.impl;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class IMMediaSecurityServiceImpl_Factory implements Factory<i> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final IMMediaSecurityServiceImpl_Factory f433285a = null;

        static {
            f433285a = new IMMediaSecurityServiceImpl_Factory();
        }
    }

    public IMMediaSecurityServiceImpl_Factory() {
    }

    public static i newInstance() {
        return new i();
    }

    @Override // javax.inject.Provider
    public i get() {
        return newInstance();
    }

    public static IMMediaSecurityServiceImpl_Factory create() {
        return a.f433285a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
