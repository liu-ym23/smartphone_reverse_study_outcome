package com.ss.android.lark.officesdk.launcher;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class PreviewLaunchTaskInjectorV1_Factory implements Factory<j> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final PreviewLaunchTaskInjectorV1_Factory f433426a = null;

        static {
            f433426a = new PreviewLaunchTaskInjectorV1_Factory();
        }
    }

    public PreviewLaunchTaskInjectorV1_Factory() {
    }

    public static j newInstance() {
        return new j();
    }

    @Override // javax.inject.Provider
    public j get() {
        return newInstance();
    }

    public static PreviewLaunchTaskInjectorV1_Factory create() {
        return a.f433426a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
