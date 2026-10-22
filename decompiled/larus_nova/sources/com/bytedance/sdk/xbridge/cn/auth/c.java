package com.bytedance.sdk.xbridge.cn.auth;

import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f269833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f269834b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f269835c;

    public interface a {
        void onSuccess();
    }

    public static final class b implements a {
        public b() {
        }

        @Override // com.bytedance.sdk.xbridge.cn.auth.c.a
        public final void onSuccess() {
            c.f269835c = true;
        }
    }

    static {
        new CopyOnWriteArraySet();
        new CopyOnWriteArraySet();
        f269834b = new Object();
    }

    public static void a(g r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "permissionConfigProvider");
        Object r102 = f269834b;
        monitor-enter(r102);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (f269835c == false) goto L8;
        monitor-exit(r102);
        return;
    L8:
        List<Class<? extends nd7.a>> r103 = nd7.d.f518799f;     // Catch: Throwable -> L11
        nd7.d.a.a(false, r100, r101, new b()).b();     // Catch: Throwable -> L11
        monitor-exit(r102);
    }
}
