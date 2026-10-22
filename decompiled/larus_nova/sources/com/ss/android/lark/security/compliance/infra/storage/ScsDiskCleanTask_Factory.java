package com.ss.android.lark.security.compliance.infra.storage;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes38.dex */
public final class ScsDiskCleanTask_Factory implements Factory<b> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ScsDiskCleanTask_Factory f440471a = null;

        static {
            f440471a = new ScsDiskCleanTask_Factory();
        }
    }

    public ScsDiskCleanTask_Factory() {
    }

    public static b newInstance() {
        return new b();
    }

    @Override // javax.inject.Provider
    public b get() {
        return newInstance();
    }

    public static ScsDiskCleanTask_Factory create() {
        return a.f440471a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
