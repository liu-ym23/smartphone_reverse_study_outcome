package com.ss.android.lark.appcontext.applifecycle;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes34.dex */
public final class DefaultRunningProcessChecker_Factory implements Factory<r> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DefaultRunningProcessChecker_Factory f408806a = null;

        static {
            f408806a = new DefaultRunningProcessChecker_Factory();
        }
    }

    public DefaultRunningProcessChecker_Factory() {
    }

    public static r newInstance() {
        return new r();
    }

    @Override // javax.inject.Provider
    public r get() {
        return newInstance();
    }

    public static DefaultRunningProcessChecker_Factory create() {
        return a.f408806a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
