package com.ss.android.lark.officesdk.api;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class NoopOnlineOfflineService_Factory implements Factory<NoopOnlineOfflineService> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NoopOnlineOfflineService_Factory f433095a = null;

        static {
            f433095a = new NoopOnlineOfflineService_Factory();
        }
    }

    public NoopOnlineOfflineService_Factory() {
    }

    public static NoopOnlineOfflineService newInstance() {
        return new NoopOnlineOfflineService();
    }

    @Override // javax.inject.Provider
    public NoopOnlineOfflineService get() {
        return newInstance();
    }

    public static NoopOnlineOfflineService_Factory create() {
        return a.f433095a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
