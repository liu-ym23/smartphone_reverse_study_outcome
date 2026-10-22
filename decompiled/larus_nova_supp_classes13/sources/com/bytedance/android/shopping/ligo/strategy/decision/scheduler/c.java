package com.bytedance.android.shopping.ligo.strategy.decision.scheduler;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.QueryWithMsgCacheCardShowStrategy;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements com.bytedance.android.shopping.ligo.strategy.decision.scheduler.a {
    public volatile boolean a;
    public final Lazy b;
    public final b c;

    public static final class a implements Runnable {
        public final /* synthetic */ c a;
        public final /* synthetic */ Function0 b;

        public a(c r1, Function0 r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            b r0 = this.a.c;     // Catch: Throwable -> L10
            if (r0 == null) goto L5;
            r0.b();     // Catch: Throwable -> L10
        L5:
            this.b.invoke();     // Catch: Throwable -> L10
            b r1 = this.a.c;     // Catch: Throwable -> L10
            if (r1 == null) goto L8;
            r1.a();     // Catch: Throwable -> L10
        L8:
            this.a.a = true;     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L14;
            return;
        L14:
            throw th;
        }
    }

    @Override // com.bytedance.android.shopping.ligo.strategy.decision.scheduler.a
    public final void cancel() {
    }

    @Override // com.bytedance.android.shopping.ligo.strategy.decision.scheduler.a
    public final boolean isCompleted() {
        return this.a;
    }

    public c(QueryWithMsgCacheCardShowStrategy.c r1) {
        this.c = r1;
        this.b = LazyKt.lazy(LigoDecisionSchedulerDefault$mainHandler$2.INSTANCE);
    }

    @Override // com.bytedance.android.shopping.ligo.strategy.decision.scheduler.a
    public final void schedule(Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "action");
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L14;
        b r1 = this.c;
        if (r1 == null) goto L10;
        r1.b();
    L10:
        r4.invoke();
        b r5 = this.c;
        if (r5 == null) goto L13;
        r5.a();
    L13:
        this.a = true;
        return;
    L14:
        ((Handler) this.b.getValue()).post(new a(this, r4));
        return;
    L5:
        r0 = false;
        goto L6
    }
}
