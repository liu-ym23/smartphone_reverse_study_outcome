package com.ss.android.lark.officesdk.launcher;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class OfficeSdkLaunchPerfDispatcher_Factory implements Factory<h> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OfficeSdkLaunchPerfDispatcher_Factory f433425a = null;

        static {
            f433425a = new OfficeSdkLaunchPerfDispatcher_Factory();
        }
    }

    public OfficeSdkLaunchPerfDispatcher_Factory() {
    }

    public static h newInstance() {
        return new h();
    }

    @Override // javax.inject.Provider
    public h get() {
        return newInstance();
    }

    public static OfficeSdkLaunchPerfDispatcher_Factory create() {
        return a.f433425a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
