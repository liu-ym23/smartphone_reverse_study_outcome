package com.ss.android.lark.passportc.ffi;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class KmpOfflineTask_Factory implements Factory<KmpOfflineTask> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final KmpOfflineTask_Factory f438148a = null;

        static {
            f438148a = new KmpOfflineTask_Factory();
        }
    }

    public KmpOfflineTask_Factory() {
    }

    public static KmpOfflineTask newInstance() {
        return new KmpOfflineTask();
    }

    @Override // javax.inject.Provider
    public KmpOfflineTask get() {
        return newInstance();
    }

    public static KmpOfflineTask_Factory create() {
        return a.f438148a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
