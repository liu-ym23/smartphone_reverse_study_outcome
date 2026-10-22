package com.ss.android.lark.officesdk.chameleon.assembly.doubao.common.deps;

import android.os.Handler;
import android.os.Looper;
import com.larus.init.task.f0;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class ThreadDependency implements ntb.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f433126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f433127b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f433128c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f433129d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f433130e;

    @Override // ntb.w
    public final ExecutorService S() {
        return (ExecutorService) this.f433127b.getValue();
    }

    @Override // ntb.w
    public final ExecutorService a0() {
        return (ExecutorService) this.f433126a.getValue();
    }

    @Override // ntb.w
    public final ExecutorService w() {
        return (ExecutorService) this.f433128c.getValue();
    }

    public ThreadDependency() {
        this.f433126a = LazyKt.lazy(ThreadDependency$_fixedThreadPool$2.INSTANCE);
        this.f433127b = LazyKt.lazy(ThreadDependency$_cachedThreadPool$2.INSTANCE);
        this.f433128c = LazyKt.lazy(ThreadDependency$_ioThreadPool$2.INSTANCE);
        this.f433129d = LazyKt.lazy(ThreadDependency$_cpuThreadPool$2.INSTANCE);
        this.f433130e = LazyKt.lazy(ThreadDependency$_mainHandler$2.INSTANCE);
    }

    @Override // ntb.w
    public final boolean I() {
        return Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper());
    }

    @Override // ntb.w
    public final void E(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        ((ExecutorService) this.f433127b.getValue()).execute(r100);
    }

    @Override // ntb.w
    public final void c(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        if (I() == false) goto L5;
        r100.run();
        return;
    L5:
        ((Handler) this.f433130e.getValue()).post(r100);
    }

    @Override // ntb.w
    public final void u(f0 r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        ((Handler) this.f433130e.getValue()).postDelayed(r100, r101);
    }
}
