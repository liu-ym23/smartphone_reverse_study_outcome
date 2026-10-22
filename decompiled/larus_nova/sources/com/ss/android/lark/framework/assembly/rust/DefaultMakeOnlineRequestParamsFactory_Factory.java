package com.ss.android.lark.framework.assembly.rust;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes36.dex */
public final class DefaultMakeOnlineRequestParamsFactory_Factory implements Factory<com.ss.android.lark.framework.assembly.rust.a> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DefaultMakeOnlineRequestParamsFactory_Factory f425668a = null;

        static {
            f425668a = new DefaultMakeOnlineRequestParamsFactory_Factory();
        }
    }

    public DefaultMakeOnlineRequestParamsFactory_Factory() {
    }

    public static com.ss.android.lark.framework.assembly.rust.a newInstance() {
        return new com.ss.android.lark.framework.assembly.rust.a();
    }

    @Override // javax.inject.Provider
    public com.ss.android.lark.framework.assembly.rust.a get() {
        return newInstance();
    }

    public static DefaultMakeOnlineRequestParamsFactory_Factory create() {
        return a.f425668a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
