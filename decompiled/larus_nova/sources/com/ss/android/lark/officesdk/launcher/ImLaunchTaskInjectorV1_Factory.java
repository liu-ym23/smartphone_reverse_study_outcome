package com.ss.android.lark.officesdk.launcher;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class ImLaunchTaskInjectorV1_Factory implements Factory<ImLaunchTaskInjectorV1> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ImLaunchTaskInjectorV1_Factory f433412a = null;

        static {
            f433412a = new ImLaunchTaskInjectorV1_Factory();
        }
    }

    public ImLaunchTaskInjectorV1_Factory() {
    }

    public static ImLaunchTaskInjectorV1 newInstance() {
        return new ImLaunchTaskInjectorV1();
    }

    @Override // javax.inject.Provider
    public ImLaunchTaskInjectorV1 get() {
        return newInstance();
    }

    public static ImLaunchTaskInjectorV1_Factory create() {
        return a.f433412a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
