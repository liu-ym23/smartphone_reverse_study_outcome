package com.bytedance.lynx.service.reporter.performance;

import com.lynx.tasm.eventreport.LynxEventReporter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes21.dex */
public final class LynxMemoryReportTimer {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy<Long> f264903f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function3<Long, Integer, Long, Unit> f264904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f264905b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f264906c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f264907d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f264908e;

    public static final class a {
        public static LynxMemoryReportTimer a(int r100, Function3 r101) {
            Intrinsics.checkNotNullParameter(r101, "reportBlock");
            LynxMemoryReportTimer r102 = new LynxMemoryReportTimer(r101);
            if (r102.f264908e == true) goto L6;
            r102.f264908e = true;
            r102.f264905b = 0;
            r102.f264906c = 0;
            r102.a();
        L6:
            return r102;
        }
    }

    static {
        f264903f = LazyKt.lazy(LynxMemoryReportTimer$Companion$reportIntervalSec$2.INSTANCE);
    }

    public final void a() {
        if (this.f264908e == true) goto L5;
        return;
    L5:
        final Ref.LongRef r100 = new Ref.LongRef();
        long r101 = ((long) (this.f264905b + 1)) * f264903f.getValue().longValue();
        r100.element = r101;
        long r102 = this.f264907d;
        if (r101 <= r102) goto L8;
        r100.element = r102;
    L8:
        LynxEventReporter.delayRunOnReportThread(new c(this, r100), r100.element * ((long) 1000));
    }

    public LynxMemoryReportTimer(Function3 r100) {
        Intrinsics.checkNotNullParameter(r100, "reportBlock");
        this.f264904a = r100;
        this.f264907d = 7200;
    }
}
