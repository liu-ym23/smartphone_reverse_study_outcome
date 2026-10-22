package com.ss.android.lark.officesdk.integrator.mock;

import dagger.internal.Factory;
import ytb.n;

/* JADX INFO: loaded from: classes37.dex */
public final class ImUserMocks_Factory implements Factory<n> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ImUserMocks_Factory f433317a = null;

        static {
            f433317a = new ImUserMocks_Factory();
        }
    }

    public ImUserMocks_Factory() {
    }

    public static n newInstance() {
        return new n();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static ImUserMocks_Factory create() {
        return a.f433317a;
    }

    @Override // javax.inject.Provider
    public n get() {
        return newInstance();
    }
}
