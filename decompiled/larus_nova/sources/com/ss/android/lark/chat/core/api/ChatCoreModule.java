package com.ss.android.lark.chat.core.api;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes35.dex */
public final class ChatCoreModule {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f414742a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f414743b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f414744c = null;

    static {
        f414742a = LazyKt.lazy(ChatCoreModule$chatNameRenderer$2.INSTANCE);
        f414743b = LazyKt.lazy(ChatCoreModule$chatParser$2.INSTANCE);
        f414744c = LazyKt.lazy(ChatCoreModule$chatCoreDependency$2.INSTANCE);
    }

    @JvmStatic
    public static final w4b.c a() {
        return (w4b.c) f414744c.getValue();
    }
}
