package com.ss.android.lark.todo_api;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes38.dex */
public final class TodoApiMock_Factory implements Factory<TodoApiMock> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final TodoApiMock_Factory f444296a = null;

        static {
            f444296a = new TodoApiMock_Factory();
        }
    }

    public TodoApiMock_Factory() {
    }

    public static TodoApiMock newInstance() {
        return new TodoApiMock();
    }

    @Override // javax.inject.Provider
    public TodoApiMock get() {
        return newInstance();
    }

    public static TodoApiMock_Factory create() {
        return a.f444296a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
