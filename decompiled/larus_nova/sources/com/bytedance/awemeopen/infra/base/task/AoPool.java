package com.bytedance.awemeopen.infra.base.task;

import android.os.Looper;
import com.bytedance.awemeopen.servicesapi.thread.AoThreadService;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\u0006"}, d2 = {"Lcom/bytedance/awemeopen/infra/base/task/AoPool;", "", "", "isOnMain", "<init>", "()V", "ao_base_core_release"}, k = 1, mv = {1, 7, 1})
public final class AoPool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AoPool f198803a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f198804b = null;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f198805a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f198805a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(Function0<Unit> r100) {
            this.f198805a = r100;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f198806a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f198806a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(Function0<Unit> r100) {
            this.f198806a = r100;
        }
    }

    public AoPool() {
    }

    static {
        f198803a = new AoPool();
        f198804b = LazyKt.lazy(AoPool$service$2.INSTANCE);
    }

    public static AoThreadService c() {
        return (AoThreadService) f198804b.getValue();
    }

    @JvmStatic
    public static final boolean isOnMain() {
        return Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper());
    }

    @JvmStatic
    public static final void a(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        f198803a.getClass();
        c().executeIO(new a(r100));
    }

    @JvmStatic
    public static final void b(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        f198803a.getClass();
        c().executeLogic(new b(r100));
    }

    @JvmStatic
    public static final void f(final Function0 r100) {
        Intrinsics.checkNotNullParameter(r100, "r");
        Intrinsics.checkNotNullParameter(r100, "r");
        if (isOnMain() == false) goto L5;
        a(new AoPool$runOnAsyncIfMain$1(r100));
        return;
    L5:
        r100.invoke();
    }

    @JvmStatic
    public static final void g(final Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        f198803a.getClass();
        c().c(new com.bytedance.awemeopen.infra.base.task.a(r100));
    }

    @JvmStatic
    public static final void d(Runnable r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "task");
        f198803a.getClass();
        c().F(r100, r101);
    }

    @JvmStatic
    public static final void e(final Function0<Unit> r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "task");
        f198803a.getClass();
        c().F(new com.bytedance.awemeopen.infra.base.task.b(r100), r101);
    }
}
