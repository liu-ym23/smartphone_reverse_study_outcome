package com.ss.android.lark.passport.auth;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class EmptyPassportSessionRotatedObserver_Factory implements Factory<d> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final EmptyPassportSessionRotatedObserver_Factory f437708a = null;

        static {
            f437708a = new EmptyPassportSessionRotatedObserver_Factory();
        }
    }

    public EmptyPassportSessionRotatedObserver_Factory() {
    }

    public static d newInstance() {
        return new d();
    }

    @Override // javax.inject.Provider
    public d get() {
        return newInstance();
    }

    public static EmptyPassportSessionRotatedObserver_Factory create() {
        return a.f437708a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
