package com.ss.android.lark.todo.impl.utils;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes38.dex */
public final class TodoStorageUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.ss.android.lark.storage.a f444273a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f444274b = null;

    static {
        f444273a = new com.ss.android.lark.storage.a("TASK");
        f444274b = LazyKt.lazy(TodoStorageUtil$kvStoreOfUser$2.INSTANCE);
    }

    public static n a() {
        return (n) f444274b.getValue();
    }
}
