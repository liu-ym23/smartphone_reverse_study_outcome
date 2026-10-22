package com.ss.android.lark.librabridge.appsetting;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes36.dex */
public final class LibraAppConfigExternalSource_Factory implements Factory<LibraAppConfigExternalSource> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final LibraAppConfigExternalSource_Factory f431165a = null;

        static {
            f431165a = new LibraAppConfigExternalSource_Factory();
        }
    }

    public LibraAppConfigExternalSource_Factory() {
    }

    public static LibraAppConfigExternalSource newInstance() {
        return new LibraAppConfigExternalSource();
    }

    @Override // javax.inject.Provider
    public LibraAppConfigExternalSource get() {
        return newInstance();
    }

    public static LibraAppConfigExternalSource_Factory create() {
        return a.f431165a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
