package com.ss.android.lark.search.doubao.assembly;

import dagger.internal.Factory;
import q3c.b;

/* JADX INFO: loaded from: classes38.dex */
public final class IOfficeSearchImpl_Factory implements Factory<b> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final IOfficeSearchImpl_Factory f440017a = null;

        static {
            f440017a = new IOfficeSearchImpl_Factory();
        }
    }

    public IOfficeSearchImpl_Factory() {
    }

    public static b newInstance() {
        return new b();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static IOfficeSearchImpl_Factory create() {
        return a.f440017a;
    }

    @Override // javax.inject.Provider
    public b get() {
        return newInstance();
    }
}
