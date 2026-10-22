package com.ss.android.lark.officesdk.integrator.im.impl;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class ImBrowserServiceImpl_Factory implements Factory<j> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ImBrowserServiceImpl_Factory f433286a = null;

        static {
            f433286a = new ImBrowserServiceImpl_Factory();
        }
    }

    public ImBrowserServiceImpl_Factory() {
    }

    public static j newInstance() {
        return new j();
    }

    @Override // javax.inject.Provider
    public j get() {
        return newInstance();
    }

    public static ImBrowserServiceImpl_Factory create() {
        return a.f433286a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
