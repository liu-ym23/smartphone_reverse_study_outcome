package com.ss.android.lark.framework.assembly.sp;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes36.dex */
public final class InitUniStoreTask_Factory implements Factory<InitUniStoreTask> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final InitUniStoreTask_Factory f425729a = null;

        static {
            f425729a = new InitUniStoreTask_Factory();
        }
    }

    public InitUniStoreTask_Factory() {
    }

    public static InitUniStoreTask newInstance() {
        return new InitUniStoreTask();
    }

    @Override // javax.inject.Provider
    public InitUniStoreTask get() {
        return newInstance();
    }

    public static InitUniStoreTask_Factory create() {
        return a.f425729a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
