package com.ss.android.lark.officesdk.launcher;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class ImLaunchTaskInjectorV2_Factory implements Factory<ImLaunchTaskInjectorV2> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ImLaunchTaskInjectorV2_Factory f433415a = null;

        static {
            f433415a = new ImLaunchTaskInjectorV2_Factory();
        }
    }

    public ImLaunchTaskInjectorV2_Factory() {
    }

    public static ImLaunchTaskInjectorV2 newInstance() {
        return new ImLaunchTaskInjectorV2();
    }

    @Override // javax.inject.Provider
    public ImLaunchTaskInjectorV2 get() {
        return newInstance();
    }

    public static ImLaunchTaskInjectorV2_Factory create() {
        return a.f433415a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
