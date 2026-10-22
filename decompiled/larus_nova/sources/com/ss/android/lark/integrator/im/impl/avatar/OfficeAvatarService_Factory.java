package com.ss.android.lark.integrator.im.impl.avatar;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes36.dex */
public final class OfficeAvatarService_Factory implements Factory<rmb.a> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OfficeAvatarService_Factory f427971a = null;

        static {
            f427971a = new OfficeAvatarService_Factory();
        }
    }

    public OfficeAvatarService_Factory() {
    }

    public static rmb.a newInstance() {
        return new rmb.a();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static OfficeAvatarService_Factory create() {
        return a.f427971a;
    }

    @Override // javax.inject.Provider
    public rmb.a get() {
        return newInstance();
    }
}
