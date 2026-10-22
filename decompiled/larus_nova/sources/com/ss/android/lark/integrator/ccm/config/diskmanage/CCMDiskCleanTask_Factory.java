package com.ss.android.lark.integrator.ccm.config.diskmanage;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes36.dex */
public final class CCMDiskCleanTask_Factory implements Factory<emb.a> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final CCMDiskCleanTask_Factory f427787a = null;

        static {
            f427787a = new CCMDiskCleanTask_Factory();
        }
    }

    public CCMDiskCleanTask_Factory() {
    }

    public static emb.a newInstance() {
        return new emb.a();
    }

    @Override // javax.inject.Provider
    public emb.a get() {
        return newInstance();
    }

    public static CCMDiskCleanTask_Factory create() {
        return a.f427787a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
