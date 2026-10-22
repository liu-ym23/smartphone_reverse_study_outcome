package com.ss.android.lark.officesdk.integrator.im.impl;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class CCMDependencyImpl_Factory implements Factory<b> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final CCMDependencyImpl_Factory f433278a = null;

        static {
            f433278a = new CCMDependencyImpl_Factory();
        }
    }

    public CCMDependencyImpl_Factory() {
    }

    public static b newInstance() {
        return new b();
    }

    @Override // javax.inject.Provider
    public b get() {
        return newInstance();
    }

    public static CCMDependencyImpl_Factory create() {
        return a.f433278a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
