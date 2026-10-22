package com.ss.android.lark.officesdk.integrator.mock;

import dagger.internal.Factory;
import ytb.r;

/* JADX INFO: loaded from: classes37.dex */
public final class SearchGlobalMocks_Factory implements Factory<r> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final SearchGlobalMocks_Factory f433320a = null;

        static {
            f433320a = new SearchGlobalMocks_Factory();
        }
    }

    public SearchGlobalMocks_Factory() {
    }

    public static r newInstance() {
        return new r();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static SearchGlobalMocks_Factory create() {
        return a.f433320a;
    }

    @Override // javax.inject.Provider
    public r get() {
        return newInstance();
    }
}
