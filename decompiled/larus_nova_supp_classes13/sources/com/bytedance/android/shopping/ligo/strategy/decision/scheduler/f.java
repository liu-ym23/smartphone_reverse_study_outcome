package com.bytedance.android.shopping.ligo.strategy.decision.scheduler;

import android.os.Handler;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.QueryWithMsgCacheCardShowStrategy;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f implements com.bytedance.android.shopping.ligo.strategy.decision.scheduler.a {
    public final Lazy a;
    public int b;
    public volatile boolean c;
    public final int d;
    public final int e;
    public final int f;
    public boolean g;
    public final com.bytedance.android.shopping.ligo.strategy.decision.scheduler.b h;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ f a;
        public final /* synthetic */ Function0 b;

        public b(f r1, Function0 r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            f.a(this.a, this.b);     // Catch: Throwable -> L4
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
    }

    @Override // com.bytedance.android.shopping.ligo.strategy.decision.scheduler.a
    public final void cancel() {
        dm.a.a("LigoScheduler").a("scheduler [" + hashCode() + "] is canceled");
        ((Handler) this.a.getValue()).removeCallbacksAndMessages(null);
        this.b = 0;
        this.c = false;
    }

    @Override // com.bytedance.android.shopping.ligo.strategy.decision.scheduler.a
    public final boolean isCompleted() {
        return this.c;
    }

    @Override // com.bytedance.android.shopping.ligo.strategy.decision.scheduler.a
    public final void schedule(Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "action");
        ((Handler) this.a.getValue()).postDelayed(new b(this, r5), this.d);
    }

    public static final void a(f r4, Function0 r5) {
        if (r4.g == true) goto L10;
        com.bytedance.android.shopping.ligo.strategy.decision.scheduler.b r0 = r4.h;
        if (r0 == null) goto L7;
        r0.b();
    L7:
        r5.invoke();
        dm.a.a("LigoScheduler").a("scheduler [" + r4.hashCode() + "] run " + r4.b + " times.");
        r4.b = r4.b + 1;
        com.bytedance.android.shopping.ligo.strategy.decision.scheduler.b r1 = r4.h;
        if (r1 == null) goto L10;
        r1.a();
    L10:
        r4.g = false;
        int r2 = r4.f;
        if (r2 == 0) goto L17;
        if (r2 > 0) goto L14;
    L16:
        r4.c = true;
        return;
    L14:
        if (r4.b >= r2) goto L16;
    L17:
        ((Handler) r4.a.getValue()).postDelayed(new g(r4, r5), r4.e);
    }

    public f(int r1, int r2, int r3, boolean r4, QueryWithMsgCacheCardShowStrategy.c r5) {
        this.d = r1;
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r5;
        this.a = LazyKt.lazy(LigoDecisionSchedulerInterval$mainHandler$2.INSTANCE);
    }
}
