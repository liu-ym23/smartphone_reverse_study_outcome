package com.bytedance.kmp.ec.yata.common.perf;

import com.bytedance.kmp.ec.yata.common.biz.YataStoreWrapper;
import com.bytedance.kmp.ec.yata.common.init.PackYataSdkConfig;
import com.bytedance.kmp.ec.yata.common.log.YaTaLog;
import com.bytedance.kmp.ec.yata.common.platform.h;
import com.bytedance.kmp.ec.yata.common.utils.YataConcurrentHashMap;
import com.bytedance.kmp.ec.yata.common.utils.YataThreadExtKt;
import com.ss.android.lark.passport.signinsdk_api.base.log.UniContext;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public abstract class AbsPerfMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f251459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PerfTriggerSource f251460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f251461c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final YataConcurrentHashMap<String, com.bytedance.kmp.ec.yata.common.perf.a> f251462d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<String, ? extends Object> f251463e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f251464f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, Object> f251465g;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f251466a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<String, Object> f251467b;

        public /* synthetic */ a() {
            this(false, new LinkedHashMap());
        }

        public a(boolean r100, Map r101) {
            Intrinsics.checkNotNullParameter(r101, "eventData");
            this.f251466a = r100;
            this.f251467b = r101;
        }
    }

    public abstract String a();

    public abstract Map<String, Object> b();

    public final void e(final YataStoreWrapper r110) {
        Intrinsics.checkNotNullParameter(r110, "storeWrapper");
        if (this.f251464f == false) goto L5;
    L43:
        String r100 = YaTaLog.f251436a;
        YaTaLog.d(a(), new AbsPerfMonitor$checkAndTransformTrackMap$1(this));
        final a r101 = new a();
    L45:
        if (r101.f251466a == true) goto L48;
        String r111 = YaTaLog.f251436a;
        YaTaLog.d(a(), AbsPerfMonitor$report$1.INSTANCE);
        return;
    L48:
        YataThreadExtKt.a(new AbsPerfMonitor$report$2(r110, r101));
        return;
    L5:
        if (this.f251462d.isEmpty() == true) goto L43;
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put(UniContext.KEY_OF_BIZ_CODE, r110.f251340a);
        r102.put(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);
        int r103 = h.f251540a;
        r102.put("EVENT_PAGE_TECHNOLOGY", "YATA_Android");
        r102.put("scene", this.f251461c);
        r102.put("trigger_source", this.f251460b.getValue());
        r102.put("trigger_start_time", Long.valueOf(this.f251459a));
        Object r104 = r102.get("yata_version");
        PackYataSdkConfig r105 = com.bytedance.kmp.ec.yata.common.init.b.f251424a;
        TuplesKt.to(r104, "1.23.7");
        final Ref.LongRef r106 = new Ref.LongRef();
        r106.element = Long.MAX_VALUE;
        final Ref.LongRef r107 = new Ref.LongRef();
        YataConcurrentHashMap<String, com.bytedance.kmp.ec.yata.common.perf.a> r108 = this.f251462d;
        ReentrantReadWriteLock.ReadLock r109 = r108.getLock().getLock().readLock();
        r109.lock();
        Iterator<Map.Entry<String, com.bytedance.kmp.ec.yata.common.perf.a>> r112 = r108.getMap().entrySet().iterator();     // Catch: Throwable -> L40
    L10:
        if (r112.hasNext() == false) goto L28;
        final Map.Entry<String, com.bytedance.kmp.ec.yata.common.perf.a> r113 = r112.next();     // Catch: Throwable -> L40
        final Long r114 = r113.getValue().f251471c;     // Catch: Throwable -> L40
        final Long r115 = r113.getValue().f251472d;     // Catch: Throwable -> L40
        if (r115 == null) goto L26;
        if (r114 == null) goto L26;
        if (r114.longValue() > r115.longValue()) goto L17;
        if (r114.longValue() >= r106.element) goto L23;
        r106.element = r114.longValue();     // Catch: Throwable -> L40
    L23:
        if (r115.longValue() <= r107.element) goto L25;
        r107.element = r115.longValue();     // Catch: Throwable -> L40
    L25:
        r102.put(r113.getKey() + "_start", r114);     // Catch: Throwable -> L40
        r102.put(r113.getKey() + "_end", r115);     // Catch: Throwable -> L40
        r102.put(r113.getKey() + "_duration", Long.valueOf(r115.longValue() - r114.longValue()));     // Catch: Throwable -> L40
        goto L10
    L17:
        this.f251464f = true;     // Catch: Throwable -> L40
        String r116 = YaTaLog.f251436a;     // Catch: Throwable -> L40
        YaTaLog.d(a(), new AbsPerfMonitor$checkAndTransformTrackMap$2$2(r113, r114, r115));     // Catch: Throwable -> L40
        r101 = new a();     // Catch: Throwable -> L40
        r109.unlock();
    L26:
        this.f251464f = true;     // Catch: Throwable -> L40
        String r117 = YaTaLog.f251436a;     // Catch: Throwable -> L40
        YaTaLog.d(a(), new AbsPerfMonitor$checkAndTransformTrackMap$2$1(r113, r114, r115));     // Catch: Throwable -> L40
        r101 = new a();     // Catch: Throwable -> L40
        r109.unlock();
        goto L45
    L28:
        r109.unlock();
        long r118 = r107.element;
        long r119 = r106.element;
        long r120 = r118 - r119;
        if (r120 >= 0) goto L31;
    L39:
        String r121 = YaTaLog.f251436a;
        YaTaLog.d(a(), new AbsPerfMonitor$checkAndTransformTrackMap$3(r106, r107, this));
        r101 = new a();
        goto L45
    L31:
        if (r120 > 100000) goto L39;
        if (r119 < this.f251459a) goto L39;
        Map<String, ? extends Object> r122 = this.f251463e;
        if (r122 != null) goto L38;
        r122 = MapsKt.emptyMap();
    L38:
        r102.putAll(r122);
        r102.putAll(this.f251465g);
        r102.put("total_duration", Long.valueOf(r120));
        r102.put("trigger_total_duration", Long.valueOf(r107.element - this.f251459a));
        r102.putAll(b());
        r101 = new a(true, r102);
    L40:
        th = move-exception;
        r109.unlock();
        throw th;
    }

    public final void f(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        String r101 = this.f251461c;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
        String r103 = YaTaLog.f251436a;
        YaTaLog.d(a(), new AbsPerfMonitor$setScene$1(this, r100));
    L11:
        this.f251461c = r100;
        String r104 = YaTaLog.f251436a;
        YaTaLog.c(a(), new AbsPerfMonitor$setScene$2(r100));
        return;
    L5:
        if (StringsKt.isBlank(r101) == true) goto L8;
        r102 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AbsPerfMonitor(long r100, PerfTriggerSource r101) {
        Intrinsics.checkNotNullParameter(r101, "triggerSource");
        this.f251459a = r100;
        this.f251460b = r101;
        this.f251462d = new YataConcurrentHashMap(null, 1, 0 == true ? 1 : 0);
        this.f251465g = new LinkedHashMap();
    }

    public static void c(AbsPerfMonitor r100, c r101) {
        int r102 = h.f251540a;
        final long r103 = System.currentTimeMillis();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "node");
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L8
        final String r105 = r101.f251490a;     // Catch: Throwable -> L8
        final String r106 = r101.f251491b;     // Catch: Throwable -> L8
        final com.bytedance.kmp.ec.yata.common.perf.a r107 = r100.f251462d.get(r105);     // Catch: Throwable -> L8
        if (r107 != null) goto L6;
        String r108 = YaTaLog.f251436a;     // Catch: Throwable -> L8
        YaTaLog.d(r100.a(), new AbsPerfMonitor$recordEnd$1$1(r105, r106));     // Catch: Throwable -> L8
        r100.f251464f = true;     // Catch: Throwable -> L8
    L11:
        return;
    L6:
        r107.f251472d = Long.valueOf(r103);     // Catch: Throwable -> L8
        String r109 = YaTaLog.f251436a;     // Catch: Throwable -> L8
        YaTaLog.c(r100.a(), new AbsPerfMonitor$recordEnd$1$2(r106, r103, r107));     // Catch: Throwable -> L8
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public static void d(AbsPerfMonitor r100, c r101) {
        int r102 = h.f251540a;
        final long r103 = System.currentTimeMillis();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "node");
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L8
        final String r105 = r101.f251490a;     // Catch: Throwable -> L8
        final String r106 = r101.f251491b;     // Catch: Throwable -> L8
        if (r100.f251462d.containsKey(r105) == false) goto L6;
        String r107 = YaTaLog.f251436a;     // Catch: Throwable -> L8
        YaTaLog.d(r100.a(), new AbsPerfMonitor$recordStart$1$1(r105, r106));     // Catch: Throwable -> L8
        r100.f251464f = true;     // Catch: Throwable -> L8
    L6:
        r100.f251462d.set(r105, new com.bytedance.kmp.ec.yata.common.perf.a(r105, r106, Long.valueOf(r103)));     // Catch: Throwable -> L8
        String r108 = YaTaLog.f251436a;     // Catch: Throwable -> L8
        YaTaLog.c(r100.a(), new AbsPerfMonitor$recordStart$1$2(r106, r103));     // Catch: Throwable -> L8
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
