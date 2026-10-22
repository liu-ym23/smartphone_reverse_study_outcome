package com.ss.android.lark.officesdk.launcher;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class MinutesFeedLaunchTaskInjector_Factory implements Factory<c> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final MinutesFeedLaunchTaskInjector_Factory f433416a = null;

        static {
            f433416a = new MinutesFeedLaunchTaskInjector_Factory();
        }
    }

    public MinutesFeedLaunchTaskInjector_Factory() {
    }

    public static c newInstance() {
        return new c();
    }

    @Override // javax.inject.Provider
    public c get() {
        return newInstance();
    }

    public static MinutesFeedLaunchTaskInjector_Factory create() {
        return a.f433416a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
