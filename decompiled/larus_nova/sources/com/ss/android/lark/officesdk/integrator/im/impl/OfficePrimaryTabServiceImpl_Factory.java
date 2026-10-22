package com.ss.android.lark.officesdk.integrator.im.impl;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class OfficePrimaryTabServiceImpl_Factory implements Factory<l> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OfficePrimaryTabServiceImpl_Factory f433288a = null;

        static {
            f433288a = new OfficePrimaryTabServiceImpl_Factory();
        }
    }

    public OfficePrimaryTabServiceImpl_Factory() {
    }

    public static l newInstance() {
        return new l();
    }

    @Override // javax.inject.Provider
    public l get() {
        return newInstance();
    }

    public static OfficePrimaryTabServiceImpl_Factory create() {
        return a.f433288a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
