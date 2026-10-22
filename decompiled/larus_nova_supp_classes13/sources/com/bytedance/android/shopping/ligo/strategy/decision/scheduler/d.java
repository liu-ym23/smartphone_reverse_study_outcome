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
public final class d implements com.bytedance.android.shopping.ligo.strategy.decision.scheduler.a {
    public volatile boolean a;
    public final Lazy b;
    public final int c;
    public final b d;

    public static final class a implements Runnable {
        public final /* synthetic */ d a;
        public final /* synthetic */ Function0 b;

        public a(d r1, Function0 r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            b r0 = this.a.d;     // Catch: Throwable -> L10
            if (r0 == null) goto L5;
            r0.b();     // Catch: Throwable -> L10
        L5:
            this.b.invoke();     // Catch: Throwable -> L10
            b r1 = this.a.d;     // Catch: Throwable -> L10
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
        ((Handler) this.b.getValue()).removeCallbacksAndMessages(null);
        this.a = false;
    }

    @Override // com.bytedance.android.shopping.ligo.strategy.decision.scheduler.a
    public final boolean isCompleted() {
        return this.a;
    }

    @Override // com.bytedance.android.shopping.ligo.strategy.decision.scheduler.a
    public final void schedule(Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "action");
        ((Handler) this.b.getValue()).postDelayed(new a(this, r5), this.c);
    }

    public d(int r1, QueryWithMsgCacheCardShowStrategy.c r2) {
        this.c = r1;
        this.d = r2;
        this.b = LazyKt.lazy(LigoDecisionSchedulerDelayRun$mainHandler$2.INSTANCE);
    }
}
