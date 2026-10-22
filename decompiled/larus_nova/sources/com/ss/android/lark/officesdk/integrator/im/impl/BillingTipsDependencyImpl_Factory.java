package com.ss.android.lark.officesdk.integrator.im.impl;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class BillingTipsDependencyImpl_Factory implements Factory<com.ss.android.lark.officesdk.integrator.im.impl.a> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final BillingTipsDependencyImpl_Factory f433277a = null;

        static {
            f433277a = new BillingTipsDependencyImpl_Factory();
        }
    }

    public BillingTipsDependencyImpl_Factory() {
    }

    public static com.ss.android.lark.officesdk.integrator.im.impl.a newInstance() {
        return new com.ss.android.lark.officesdk.integrator.im.impl.a();
    }

    @Override // javax.inject.Provider
    public com.ss.android.lark.officesdk.integrator.im.impl.a get() {
        return newInstance();
    }

    public static BillingTipsDependencyImpl_Factory create() {
        return a.f433277a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
