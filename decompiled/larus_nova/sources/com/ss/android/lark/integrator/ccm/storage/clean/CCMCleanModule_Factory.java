package com.ss.android.lark.integrator.ccm.storage.clean;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes36.dex */
public final class CCMCleanModule_Factory implements Factory<CCMCleanModule> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final CCMCleanModule_Factory f427912a = null;

        static {
            f427912a = new CCMCleanModule_Factory();
        }
    }

    public CCMCleanModule_Factory() {
    }

    public static CCMCleanModule newInstance() {
        return new CCMCleanModule();
    }

    @Override // javax.inject.Provider
    public CCMCleanModule get() {
        return newInstance();
    }

    public static CCMCleanModule_Factory create() {
        return a.f427912a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
