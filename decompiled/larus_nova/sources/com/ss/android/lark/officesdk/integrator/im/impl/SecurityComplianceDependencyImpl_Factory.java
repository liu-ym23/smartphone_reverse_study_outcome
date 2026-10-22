package com.ss.android.lark.officesdk.integrator.im.impl;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class SecurityComplianceDependencyImpl_Factory implements Factory<p> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final SecurityComplianceDependencyImpl_Factory f433291a = null;

        static {
            f433291a = new SecurityComplianceDependencyImpl_Factory();
        }
    }

    public SecurityComplianceDependencyImpl_Factory() {
    }

    public static p newInstance() {
        return new p();
    }

    @Override // javax.inject.Provider
    public p get() {
        return newInstance();
    }

    public static SecurityComplianceDependencyImpl_Factory create() {
        return a.f433291a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
