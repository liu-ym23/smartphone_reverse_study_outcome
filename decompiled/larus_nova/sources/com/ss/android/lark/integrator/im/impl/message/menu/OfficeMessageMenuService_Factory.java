package com.ss.android.lark.integrator.im.impl.message.menu;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes36.dex */
public final class OfficeMessageMenuService_Factory implements Factory<xmb.a> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OfficeMessageMenuService_Factory f427980a = null;

        static {
            f427980a = new OfficeMessageMenuService_Factory();
        }
    }

    public OfficeMessageMenuService_Factory() {
    }

    public static xmb.a newInstance() {
        return new xmb.a();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static OfficeMessageMenuService_Factory create() {
        return a.f427980a;
    }

    @Override // javax.inject.Provider
    public xmb.a get() {
        return newInstance();
    }
}
