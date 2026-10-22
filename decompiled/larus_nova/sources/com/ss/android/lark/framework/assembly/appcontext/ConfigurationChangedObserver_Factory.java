package com.ss.android.lark.framework.assembly.appcontext;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes36.dex */
public final class ConfigurationChangedObserver_Factory implements Factory<com.ss.android.lark.framework.assembly.appcontext.a> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ConfigurationChangedObserver_Factory f425618a = null;

        static {
            f425618a = new ConfigurationChangedObserver_Factory();
        }
    }

    public ConfigurationChangedObserver_Factory() {
    }

    public static com.ss.android.lark.framework.assembly.appcontext.a newInstance() {
        return new com.ss.android.lark.framework.assembly.appcontext.a();
    }

    @Override // javax.inject.Provider
    public com.ss.android.lark.framework.assembly.appcontext.a get() {
        return newInstance();
    }

    public static ConfigurationChangedObserver_Factory create() {
        return a.f425618a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
