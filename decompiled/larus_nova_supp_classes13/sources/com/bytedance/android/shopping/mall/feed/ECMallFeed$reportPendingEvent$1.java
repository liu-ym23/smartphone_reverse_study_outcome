package com.bytedance.android.shopping.mall.feed;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class ECMallFeed$reportPendingEvent$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ boolean $isDelayAndDisperse;
    final /* synthetic */ ECMallFeed this$0;

    public static final class a implements Runnable {
        public final /* synthetic */ ECMallFeed$reportPendingEvent$1 a;
        public final /* synthetic */ long b;
        public final /* synthetic */ List c;
        public final /* synthetic */ Map d;

        /* JADX INFO: renamed from: com.bytedance.android.shopping.mall.feed.ECMallFeed$reportPendingEvent$1$a$a, reason: collision with other inner class name */
        public static final class C0077a implements ttc.b {
            public final /* synthetic */ a a;
            public final /* synthetic */ Ref.IntRef b;

            public C0077a(a r1, Ref.IntRef r2) {
                this.a = r1;
                this.b = r2;
            }

            public final boolean getAsBoolean() {
                if (this.b.element < this.a.c.size()) goto L5;
                return true;
            L5:
                return false;
            }
        }

        public static final class b<T> implements Consumer {
            public final /* synthetic */ a a;
            public final /* synthetic */ Ref.IntRef b;

            public b(a r1, Ref.IntRef r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void accept(Object r4) {
                Long r5 = (Long) r4;
                int r6 = this.a.c.size();
                int r0 = this.b.element;
                if (r0 < 0) goto L7;
                if (r6 <= r0) goto L7;
                a r7 = this.a;
                r7.a.this$0.j0.h((Map) ListProtector.get(r7.c, r0), this.a.d, false);
            L7:
                this.b.element++;
            }
        }

        public a(ECMallFeed$reportPendingEvent$1 r1, long r2, List r4, Map r5) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r5;
        }

        public final void a() {
            Ref.IntRef r0 = new Ref.IntRef();
            r0.element = 0;
            Disposable r1 = Observable.timer(this.b, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread()).repeatUntil(new C0077a(this, r0)).subscribe(new b(this, r0));
            this.a.this$0.W0.add(r1);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public ECMallFeed$reportPendingEvent$1(ECMallFeed r1, boolean r2) {
        this.this$0 = r1;
        this.$isDelayAndDisperse = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1037invoke() {
        if (((Boolean) this.this$0.l.getValue()).booleanValue() == false) goto L5;
        Map<String, Object> r0 = this.this$0.j0.c();
    L6:
        Map<String, Object> r6 = r0;
        if (this.$isDelayAndDisperse == false) goto L25;
        int r1 = s93.c.a;
        Object r2 = 20L;
        IHybridHostService r3 = com.bytedance.android.ec.hybrid.a.h();
        if (r3 == null) goto L16;
        yj.g r4 = r3.getHostAB();
        if (r4 == null) goto L16;
        Object r5 = r4.a("mall_tab_opt_interval_time", r2);
        if (r5 == null) goto L16;
        r2 = r5;
    L16:
        Lazy r7 = ECMallLogUtil.a;
        com.bytedance.android.ec.hybrid.log.mall.c.a r8 = com.bytedance.android.ec.hybrid.log.mall.c.a.b;
        ECMallLogUtil.c(r8, "Key : mall_tab_opt_interval_time, Value: " + r2);
        long r9 = ((Number) r2).longValue();
        Object r10 = 1000L;
        IHybridHostService r11 = com.bytedance.android.ec.hybrid.a.h();
        if (r11 == null) goto L24;
        yj.g r12 = r11.getHostAB();
        if (r12 == null) goto L24;
        Object r13 = r12.a("mall_tab_opt_delay_time", r10);
        if (r13 == null) goto L24;
        r10 = r13;
    L24:
        ECMallLogUtil.c(r8, "Key : mall_tab_opt_delay_time, Value: " + r10);
        new Handler(Looper.getMainLooper()).postDelayed(new a(this, r9, CollectionsKt.toList(this.this$0.f0), r6), ((Number) r10).longValue());
    L29:
        ((CopyOnWriteArrayList) this.this$0.f0).clear();
        return;
    L25:
        Iterator r14 = ((CopyOnWriteArrayList) this.this$0.f0).iterator();
    L27:
        if (r14.hasNext() == false) goto L29;
        this.this$0.j0.h((Map) r14.next(), r6, false);
        goto L27
    L5:
        r0 = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1037invoke();
        return Unit.INSTANCE;
    }
}
