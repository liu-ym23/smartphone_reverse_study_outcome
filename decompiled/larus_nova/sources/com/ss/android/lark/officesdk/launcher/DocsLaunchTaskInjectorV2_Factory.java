package com.ss.android.lark.officesdk.launcher;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class DocsLaunchTaskInjectorV2_Factory implements Factory<DocsLaunchTaskInjectorV2> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DocsLaunchTaskInjectorV2_Factory f433406a = null;

        static {
            f433406a = new DocsLaunchTaskInjectorV2_Factory();
        }
    }

    public DocsLaunchTaskInjectorV2_Factory() {
    }

    public static DocsLaunchTaskInjectorV2 newInstance() {
        return new DocsLaunchTaskInjectorV2();
    }

    @Override // javax.inject.Provider
    public DocsLaunchTaskInjectorV2 get() {
        return newInstance();
    }

    public static DocsLaunchTaskInjectorV2_Factory create() {
        return a.f433406a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
