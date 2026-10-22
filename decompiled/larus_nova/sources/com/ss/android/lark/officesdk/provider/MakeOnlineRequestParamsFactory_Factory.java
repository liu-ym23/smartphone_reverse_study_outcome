package com.ss.android.lark.officesdk.provider;

import dagger.internal.Factory;
import nwb.d;

/* JADX INFO: loaded from: classes37.dex */
public final class MakeOnlineRequestParamsFactory_Factory implements Factory<d> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final MakeOnlineRequestParamsFactory_Factory f437147a = null;

        static {
            f437147a = new MakeOnlineRequestParamsFactory_Factory();
        }
    }

    public MakeOnlineRequestParamsFactory_Factory() {
    }

    public static d newInstance() {
        return new d();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static MakeOnlineRequestParamsFactory_Factory create() {
        return a.f437147a;
    }

    @Override // javax.inject.Provider
    public d get() {
        return newInstance();
    }
}
