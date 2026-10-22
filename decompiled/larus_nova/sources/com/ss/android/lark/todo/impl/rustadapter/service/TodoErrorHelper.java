package com.ss.android.lark.todo.impl.rustadapter.service;

import com.bytedance.lark.pb.basic.v1.ErrorCode;
import com.larus.nova.R;
import com.ss.android.lark.todo.impl.framework.config.TodoConfig;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes38.dex */
public final class TodoErrorHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f444245a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f444246b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f444247c = null;

    static {
        f444245a = ErrorCode.TodoAssigneeNumberExceedsLimit.getValue();
        f444246b = ErrorCode.TodoFollowerNumberExceedsLimit.getValue();
        f444247c = LazyKt.lazy(TodoErrorHelper$todoConfig$2.INSTANCE);
    }

    public static String a() {
        com.ss.android.lark.todo.impl.utils.i r100 = com.ss.android.lark.todo.impl.utils.i.f444291a;
        return com.ss.android.lark.todo.impl.utils.i.d(R.string.Todo_Task_FollowerLimitToast, "num", String.valueOf(((TodoConfig) f444247c.getValue()).d()));
    }
}
