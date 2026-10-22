package com.bytedance.ies.bullet.service.preload;

import bolts.Task;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f248093a = null;

    public static final class a<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f248094a;

        public a(Runnable r100) {
            this.f248094a = r100;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            call();
            return Unit.INSTANCE;
        }

        @Override // java.util.concurrent.Callable
        public final void call() {
            this.f248094a.run();
        }
    }

    static {
        f248093a = new b();
    }

    public b() {
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        Task.call(new a(r100), Task.BACKGROUND_EXECUTOR);
    }
}
