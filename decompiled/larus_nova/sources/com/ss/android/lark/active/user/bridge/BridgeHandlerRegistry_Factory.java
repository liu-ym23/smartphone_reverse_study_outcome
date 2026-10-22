package com.ss.android.lark.active.user.bridge;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes34.dex */
public final class BridgeHandlerRegistry_Factory implements Factory<d> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final BridgeHandlerRegistry_Factory f408556a = null;

        static {
            f408556a = new BridgeHandlerRegistry_Factory();
        }
    }

    public BridgeHandlerRegistry_Factory() {
    }

    public static d newInstance() {
        return new d();
    }

    @Override // javax.inject.Provider
    public d get() {
        return newInstance();
    }

    public static BridgeHandlerRegistry_Factory create() {
        return a.f408556a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
