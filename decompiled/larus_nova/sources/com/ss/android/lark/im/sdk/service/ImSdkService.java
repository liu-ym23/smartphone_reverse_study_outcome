package com.ss.android.lark.im.sdk.service;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes36.dex */
public final class ImSdkService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f426050a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f426051b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f426052c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f426053d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f426054e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f426055f = null;

    static {
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.SYNCHRONIZED;
        f426050a = LazyKt.lazy(r100, ImSdkService$chatService$2.INSTANCE);
        f426051b = LazyKt.lazy(r100, ImSdkService$chatPush$2.INSTANCE);
        f426052c = LazyKt.lazy(r100, ImSdkService$chatterService$2.INSTANCE);
        f426053d = LazyKt.lazy(r100, ImSdkService$chatterPush$2.INSTANCE);
        f426054e = LazyKt.lazy(r100, ImSdkService$messageService$2.INSTANCE);
        f426055f = LazyKt.lazy(r100, ImSdkService$messagePush$2.INSTANCE);
    }

    public static m6b.s a() {
        return (m6b.s) f426051b.getValue();
    }

    public static ImSdkChatService b() {
        return (ImSdkChatService) f426050a.getValue();
    }

    public static m6b.t c() {
        return (m6b.t) f426053d.getValue();
    }

    public static h d() {
        return (h) f426052c.getValue();
    }

    public static m6b.u e() {
        return (m6b.u) f426055f.getValue();
    }

    public static p f() {
        return (p) f426054e.getValue();
    }
}
