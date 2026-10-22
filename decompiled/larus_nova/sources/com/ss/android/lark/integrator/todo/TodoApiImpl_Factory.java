package com.ss.android.lark.integrator.todo;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes36.dex */
public final class TodoApiImpl_Factory implements Factory<TodoApiImpl> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final TodoApiImpl_Factory f428134a = null;

        static {
            f428134a = new TodoApiImpl_Factory();
        }
    }

    public TodoApiImpl_Factory() {
    }

    public static TodoApiImpl newInstance() {
        return new TodoApiImpl();
    }

    @Override // javax.inject.Provider
    public TodoApiImpl get() {
        return newInstance();
    }

    public static TodoApiImpl_Factory create() {
        return a.f428134a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
