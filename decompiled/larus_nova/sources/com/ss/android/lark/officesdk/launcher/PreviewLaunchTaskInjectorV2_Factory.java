package com.ss.android.lark.officesdk.launcher;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class PreviewLaunchTaskInjectorV2_Factory implements Factory<k> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final PreviewLaunchTaskInjectorV2_Factory f433427a = null;

        static {
            f433427a = new PreviewLaunchTaskInjectorV2_Factory();
        }
    }

    public PreviewLaunchTaskInjectorV2_Factory() {
    }

    public static k newInstance() {
        return new k();
    }

    @Override // javax.inject.Provider
    public k get() {
        return newInstance();
    }

    public static PreviewLaunchTaskInjectorV2_Factory create() {
        return a.f433427a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
