package com.ss.android.lark.framework.assembly.rust;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes36.dex */
public final class RustInitObserver_Factory implements Factory<v> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final RustInitObserver_Factory f425685a = null;

        static {
            f425685a = new RustInitObserver_Factory();
        }
    }

    public RustInitObserver_Factory() {
    }

    public static v newInstance() {
        return new v();
    }

    @Override // javax.inject.Provider
    public v get() {
        return newInstance();
    }

    public static RustInitObserver_Factory create() {
        return a.f425685a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
