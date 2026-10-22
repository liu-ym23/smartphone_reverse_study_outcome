package com.ss.android.lark.passportc.task;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class DefaultExecuteTaskOrder_Factory implements Factory<com.ss.android.lark.passportc.task.a> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DefaultExecuteTaskOrder_Factory f438497a = null;

        static {
            f438497a = new DefaultExecuteTaskOrder_Factory();
        }
    }

    public DefaultExecuteTaskOrder_Factory() {
    }

    public static com.ss.android.lark.passportc.task.a newInstance() {
        return new com.ss.android.lark.passportc.task.a();
    }

    @Override // javax.inject.Provider
    public com.ss.android.lark.passportc.task.a get() {
        return newInstance();
    }

    public static DefaultExecuteTaskOrder_Factory create() {
        return a.f438497a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
