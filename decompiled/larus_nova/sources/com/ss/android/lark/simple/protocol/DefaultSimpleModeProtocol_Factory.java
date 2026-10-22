package com.ss.android.lark.simple.protocol;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes38.dex */
public final class DefaultSimpleModeProtocol_Factory implements Factory<e5c.a> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DefaultSimpleModeProtocol_Factory f440568a = null;

        static {
            f440568a = new DefaultSimpleModeProtocol_Factory();
        }
    }

    public DefaultSimpleModeProtocol_Factory() {
    }

    public static e5c.a newInstance() {
        return new e5c.a();
    }

    @Override // javax.inject.Provider
    public e5c.a get() {
        return newInstance();
    }

    public static DefaultSimpleModeProtocol_Factory create() {
        return a.f440568a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
