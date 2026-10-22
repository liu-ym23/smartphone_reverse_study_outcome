package com.ss.android.lark.officesdk.integrator.im.impl;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class IMFileSecurityServiceImpl_Factory implements Factory<IMFileSecurityServiceImpl> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final IMFileSecurityServiceImpl_Factory f433284a = null;

        static {
            f433284a = new IMFileSecurityServiceImpl_Factory();
        }
    }

    public IMFileSecurityServiceImpl_Factory() {
    }

    public static IMFileSecurityServiceImpl newInstance() {
        return new IMFileSecurityServiceImpl();
    }

    @Override // javax.inject.Provider
    public IMFileSecurityServiceImpl get() {
        return newInstance();
    }

    public static IMFileSecurityServiceImpl_Factory create() {
        return a.f433284a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
