package com.ss.android.lark.todo.impl.features.common.helper;

import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f442455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f442456b = null;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f442457a = 0;

        static {
        }

        @Override // java.lang.Runnable
        public final void run() {
            a9c.b.b(a9c.b.f2313a, "todo_task_center_feelgood_view", null, 6);     // Catch: Throwable -> L4
            boolean r100 = h.f442455a;     // Catch: Throwable -> L4
            h.f442455a = false;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f442458a = null;

        static {
            f442458a = new b();
        }

        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            int r100 = a9c.a.f2310a;     // Catch: Throwable -> L4
            a9c.a.c("todo_new_task_center_feelgood_view", new JSONObject());     // Catch: Throwable -> L4
            boolean r101 = h.f442455a;     // Catch: Throwable -> L4
            h.f442455a = false;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        int r100 = a.f442457a;
        f442456b = b.f442458a;
    }
}
