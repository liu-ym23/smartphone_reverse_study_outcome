package com.ss.android.lark.officesdk.launcher;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class MinutesLaunchTaskInjector_Factory implements Factory<d> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final MinutesLaunchTaskInjector_Factory f433417a = null;

        static {
            f433417a = new MinutesLaunchTaskInjector_Factory();
        }
    }

    public MinutesLaunchTaskInjector_Factory() {
    }

    public static d newInstance() {
        return new d();
    }

    @Override // javax.inject.Provider
    public d get() {
        return newInstance();
    }

    public static MinutesLaunchTaskInjector_Factory create() {
        return a.f433417a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
