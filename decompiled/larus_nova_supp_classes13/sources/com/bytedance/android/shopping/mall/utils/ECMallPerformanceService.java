package com.bytedance.android.shopping.mall.utils;

import android.os.Build;
import android.os.Looper;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.log.mall.k;
import com.bytedance.android.shopping.api.mall.ECMallMemoryReportConfig;
import com.bytedance.android.shopping.api.mall.IECMallPerformanceService;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.thread.ThreadPoolHelper;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kk.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/mall/utils/ECMallPerformanceService;", "Lcom/bytedance/android/shopping/api/mall/IECMallPerformanceService;", "<init>", "()V", "a", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECMallPerformanceService implements IECMallPerformanceService {
    public static final Lazy a = null;
    public static volatile Boolean b;
    public static final Lazy c = null;

    public static final class a {
        public static final ECMallMemoryReportConfig a() {
            Lazy r0 = ECMallPerformanceService.a;
            return (ECMallMemoryReportConfig) ECMallPerformanceService.a.getValue();
        }

        public a() {
        }
    }

    public final class b implements Runnable {
        public final /* synthetic */ Function0 a;

        public b(Function0 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public ECMallPerformanceService() {
    }

    static {
        new a();
        a = LazyKt.lazy(ECMallPerformanceService$Companion$memoryReportConfig$2.INSTANCE);
        c = LazyKt.lazy(ECMallPerformanceService$Companion$lastMemoryReportTimestamps$2.INSTANCE);
    }

    @Override // com.bytedance.android.shopping.api.mall.IECMallPerformanceService
    public final void a(final IECMallPerformanceService.SceneContext r13, final String r14, Boolean r15) {
        Intrinsics.checkNotNullParameter(r13, "sceneContext");
        Intrinsics.checkNotNullParameter(r14, "timing");
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return;
    L5:
        boolean r1 = false;
        if (b != null) goto L24;
        monitor-enter(ECMallPerformanceService.class);
        double r3 = Math.random();     // Catch: Throwable -> L20
        Float r5 = a.a().getSampleRatio();     // Catch: Throwable -> L20
        if (r5 == null) goto L12;
        float r6 = r5.floatValue();     // Catch: Throwable -> L20
    L14:
        if (r3 >= r6) goto L16;
        boolean r4 = true;
    L17:
        b = Boolean.valueOf(r4);     // Catch: Throwable -> L20
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(ECMallPerformanceService.class);
        goto L24
    L16:
        r4 = false;
        goto L17
    L12:
        r6 = 0.0f;
    L20:
        th = move-exception;
        throw th;
    L24:
        if ((!Intrinsics.areEqual(b, Boolean.TRUE)) == false) goto L28;
        Lazy r16 = ECMallLogUtil.a;
        ECMallLogUtil.c(k.a.b, "ECMallPerformanceMonitor#reportMemoryStatus, report disabled by sample ratio");
        return;
    L28:
        if (a.a().isEnabled(r13.c) == true) goto L31;
        Lazy r17 = ECMallLogUtil.a;
        ECMallLogUtil.c(k.a.b, "ECMallPerformanceMonitor#reportMemoryStatus, report disabled by scene list");
        return;
    L31:
        List<String> r0 = a.a().blockTimingListOf(r13.c);
        if ((!r0.isEmpty()) == true) goto L34;
    L37:
        int r2 = a.a().reportIntervalOf(r13.c);
        if (r2 <= 0) goto L47;
        int r8 = r13.hashCode();
        Lazy r9 = c;
        Long r10 = (Long) ((ConcurrentHashMap) r9.getValue()).get(Integer.valueOf(r8));
        if (r10 != null) goto L42;
        r10 = 0L;
    L42:
        long r11 = r10.longValue();
        long r12 = System.currentTimeMillis();
        if ((r12 - r11) > r2) goto L46;
        Lazy r18 = ECMallLogUtil.a;
        ECMallLogUtil.c(k.a.b, "ECMallPerformanceMonitor#reportMemoryStatus, report disabled by report interval");
        return;
    L46:
        ((ConcurrentHashMap) r9.getValue()).put(Integer.valueOf(r8), Long.valueOf(r12));
    L47:
        final long r19 = System.currentTimeMillis();
        r13.a(ECMallPerformanceService$reportMemoryStatus$2.INSTANCE);
        int r20 = a.a().reportStrategyOf(r13.c);
        if (r20 != 1) goto L50;
        Map<String, Object> r21 = r13.b(r14);
    L51:
        final Map<String, Object> r22 = r21;
        if (r15 == null) goto L55;
        r1 = r15.booleanValue();
    L57:
        if (r1 == false) goto L59;
        ThreadPoolHelper.d().submit(new ECMallPerformanceService$reportMemoryStatus$3(this, r13, r14, r22, r19));
        return;
    L59:
        b(r13, r14, r22, ECMallPerformanceService$reportMemoryStatus$4.INSTANCE);
        return;
    L55:
        if (r20 == 3) goto L57;
        r1 = true;
        goto L57
    L50:
        r21 = null;
        goto L51
    L34:
        if (r0.contains(r14) == false) goto L37;
        Lazy r110 = ECMallLogUtil.a;
        ECMallLogUtil.c(k.a.b, "ECMallPerformanceMonitor#reportMemoryStatus, report disabled by block timing list");
    }

    public static void b(IECMallPerformanceService.SceneContext r8, final String r9, Map r10, Function1 r11) {
        long r0 = System.nanoTime();
        final LinkedHashMap r2 = new LinkedHashMap();
        if (r10 != null) goto L5;
        r10 = r8.b(r9);
    L5:
        r2.putAll(r10);
        if (Build.VERSION.SDK_INT >= 23) goto L8;
        final LinkedHashMap r12 = new LinkedHashMap();
    L9:
        LinkedHashMap r3 = new LinkedHashMap(MapsKt.mapCapacity(r12.size()));
        Iterator r4 = r12.entrySet().iterator();
    L11:
        if (r4.hasNext() == false) goto L13;
        Map.Entry r5 = (Map.Entry) r4.next();
        r3.put(((String) r5.getKey()) + '_' + r9, r5.getValue());
        goto L11
    L13:
        r8.getClass();
        Intrinsics.checkNotNullParameter(r3, "params");
        r8.b.putAll(r3);
        Unit r13 = Unit.INSTANCE;
        r2.putAll(r12);
        final float r14 = (System.nanoTime() - r0) / 1000000.0f;
        r2.put("report_cost_duration", Float.valueOf(r14));
        if (r11 == null) goto L16;
        Unit r15 = (Unit) r11.invoke(r2);
    L16:
        Function0<Unit> r16 = new ECMallPerformanceService$reportMemoryStatus$reportAction$1(r14, r9, r2);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L19;
        ThreadPoolHelper.d().submit(new b(r16));
        return;
    L19:
        r16.invoke();
        return;
    L8:
        r12 = new LinkedHashMap();
        d.c(new ECMallPerformanceService$collectMemoryParams$1(r12));
        r12.put("report_timestamp", Long.valueOf(System.currentTimeMillis()));
        goto L9
    }
}
