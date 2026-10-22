package com.ss.android.lark.officesdk.launcher;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class DocsLaunchTaskInjector_Factory implements Factory<DocsLaunchTaskInjector> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DocsLaunchTaskInjector_Factory f433407a = null;

        static {
            f433407a = new DocsLaunchTaskInjector_Factory();
        }
    }

    public DocsLaunchTaskInjector_Factory() {
    }

    public static DocsLaunchTaskInjector newInstance() {
        return new DocsLaunchTaskInjector();
    }

    @Override // javax.inject.Provider
    public DocsLaunchTaskInjector get() {
        return newInstance();
    }

    public static DocsLaunchTaskInjector_Factory create() {
        return a.f433407a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
