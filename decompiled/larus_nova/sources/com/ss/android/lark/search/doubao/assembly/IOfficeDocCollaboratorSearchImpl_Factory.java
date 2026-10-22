package com.ss.android.lark.search.doubao.assembly;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes38.dex */
public final class IOfficeDocCollaboratorSearchImpl_Factory implements Factory<q3c.a> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final IOfficeDocCollaboratorSearchImpl_Factory f440016a = null;

        static {
            f440016a = new IOfficeDocCollaboratorSearchImpl_Factory();
        }
    }

    public IOfficeDocCollaboratorSearchImpl_Factory() {
    }

    public static q3c.a newInstance() {
        return new q3c.a();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static IOfficeDocCollaboratorSearchImpl_Factory create() {
        return a.f440016a;
    }

    @Override // javax.inject.Provider
    public q3c.a get() {
        return newInstance();
    }
}
