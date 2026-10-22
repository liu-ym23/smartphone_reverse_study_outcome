package com.bytedance.upc.common.thread;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public final class ThreadPlus {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f272474a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f272475b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f272476c = null;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f272477a;

        public a(Function0 r100) {
            this.f272477a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f272477a.invoke();     // Catch: Throwable -> L4
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
        f272474a = LazyKt.lazy(ThreadPlus$mExecutorService$2.INSTANCE);
        f272475b = LazyKt.lazy(ThreadPlus$mScheduledThreadPool$2.INSTANCE);
        f272476c = LazyKt.lazy(ThreadPlus$mSingleExecutorService$2.INSTANCE);
    }

    public static void a(Function0 r100) {
        ((ExecutorService) f272474a.getValue()).submit(new a(r100));
    }
}
