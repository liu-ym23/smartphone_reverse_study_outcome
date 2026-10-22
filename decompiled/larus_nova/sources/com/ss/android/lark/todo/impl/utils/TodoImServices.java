package com.ss.android.lark.todo.impl.utils;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes38.dex */
public final class TodoImServices {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f444271a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f444272b = null;

    static {
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.SYNCHRONIZED;
        f444271a = LazyKt.lazy(r100, TodoImServices$chatterService$2.INSTANCE);
        f444272b = LazyKt.lazy(r100, TodoImServices$messageService$2.INSTANCE);
    }

    public static com.ss.android.lark.im.sdk.service.h a() {
        return (com.ss.android.lark.im.sdk.service.h) f444271a.getValue();
    }
}
