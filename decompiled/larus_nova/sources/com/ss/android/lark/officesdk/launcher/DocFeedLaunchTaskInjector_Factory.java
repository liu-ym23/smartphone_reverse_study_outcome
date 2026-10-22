package com.ss.android.lark.officesdk.launcher;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class DocFeedLaunchTaskInjector_Factory implements Factory<com.ss.android.lark.officesdk.launcher.a> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DocFeedLaunchTaskInjector_Factory f433401a = null;

        static {
            f433401a = new DocFeedLaunchTaskInjector_Factory();
        }
    }

    public DocFeedLaunchTaskInjector_Factory() {
    }

    public static com.ss.android.lark.officesdk.launcher.a newInstance() {
        return new com.ss.android.lark.officesdk.launcher.a();
    }

    @Override // javax.inject.Provider
    public com.ss.android.lark.officesdk.launcher.a get() {
        return newInstance();
    }

    public static DocFeedLaunchTaskInjector_Factory create() {
        return a.f433401a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
