package com.ss.android.lark.officesdk.integrator.mock;

import dagger.internal.Factory;
import ytb.u;

/* JADX INFO: loaded from: classes37.dex */
public final class SearchUserMocks_Factory implements Factory<u> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final SearchUserMocks_Factory f433321a = null;

        static {
            f433321a = new SearchUserMocks_Factory();
        }
    }

    public SearchUserMocks_Factory() {
    }

    public static u newInstance() {
        return new u();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static SearchUserMocks_Factory create() {
        return a.f433321a;
    }

    @Override // javax.inject.Provider
    public u get() {
        return newInstance();
    }
}
