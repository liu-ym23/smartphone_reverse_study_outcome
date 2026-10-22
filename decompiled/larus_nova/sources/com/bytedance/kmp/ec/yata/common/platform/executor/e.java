package com.bytedance.kmp.ec.yata.common.platform.executor;

import android.os.Handler;
import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class e implements com.bytedance.kmp.ec.yata.common.platform.executor.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f251517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f251518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentLinkedDeque<f> f251519c;

    public static final class a extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f251520c;

        @Override // com.bytedance.kmp.ec.yata.common.platform.executor.f
        public final void a() {
            this.f251520c.invoke();
        }

        public a(String r100, Function0<Unit> r101) {
            this.f251520c = r101;
            super(r100);
        }
    }

    public static final class b extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f251521c;

        @Override // com.bytedance.kmp.ec.yata.common.platform.executor.f
        public final void a() {
            this.f251521c.invoke();
        }

        public b(String r100, Function0<Unit> r101) {
            this.f251521c = r101;
            super(r100);
        }
    }

    public e() {
        Intrinsics.checkNotNullParameter("main-queue", "name");
        this.f251518b = LazyKt.lazy(MainQueue$mainDispatcher$2.INSTANCE);
        this.f251519c = new ConcurrentLinkedDeque();
    }

    @Override // com.bytedance.kmp.ec.yata.common.platform.executor.a
    public final void a() {
        if (this.f251519c.isEmpty() == false) goto L5;
        return;
    L5:
        Runnable r100 = new d(this);
        if (ThreadMethodProxy.currentThread() != ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) goto L8;
        r100.run();
        return;
    L8:
        ((Handler) this.f251518b.getValue()).post(r100);
    }

    @Override // com.bytedance.kmp.ec.yata.common.platform.executor.a
    public final void shutdown() {
        ConcurrentLinkedDeque<f> r100 = this.f251519c;
        monitor-enter(r100);
        this.f251517a = true;     // Catch: Throwable -> L9
        this.f251519c.clear();     // Catch: Throwable -> L9
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(r100);
        ((Handler) this.f251518b.getValue()).removeCallbacksAndMessages(null);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.kmp.ec.yata.common.platform.executor.a
    public final void b(String r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "block");
        if (this.f251517a == false) goto L5;
        return;
    L5:
        this.f251519c.addFirst(new b(r100, r101));
    }

    @Override // com.bytedance.kmp.ec.yata.common.platform.executor.a
    public final void c(String r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "block");
        if (this.f251517a == false) goto L5;
        return;
    L5:
        this.f251519c.add(new a(r100, r101));
    }
}
