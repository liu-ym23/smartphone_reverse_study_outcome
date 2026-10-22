package com.ss.android.lark.passportc.ffi;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class KmpOnlineTask_Factory implements Factory<KmpOnlineTask> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final KmpOnlineTask_Factory f438156a = null;

        static {
            f438156a = new KmpOnlineTask_Factory();
        }
    }

    public KmpOnlineTask_Factory() {
    }

    public static KmpOnlineTask newInstance() {
        return new KmpOnlineTask();
    }

    @Override // javax.inject.Provider
    public KmpOnlineTask get() {
        return newInstance();
    }

    public static KmpOnlineTask_Factory create() {
        return a.f438156a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
