package com.ss.android.lark.officesdk.launcher;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class ImFeedLaunchTaskInjector_Factory implements Factory<ImFeedLaunchTaskInjector> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ImFeedLaunchTaskInjector_Factory f433409a = null;

        static {
            f433409a = new ImFeedLaunchTaskInjector_Factory();
        }
    }

    public ImFeedLaunchTaskInjector_Factory() {
    }

    public static ImFeedLaunchTaskInjector newInstance() {
        return new ImFeedLaunchTaskInjector();
    }

    @Override // javax.inject.Provider
    public ImFeedLaunchTaskInjector get() {
        return newInstance();
    }

    public static ImFeedLaunchTaskInjector_Factory create() {
        return a.f433409a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
