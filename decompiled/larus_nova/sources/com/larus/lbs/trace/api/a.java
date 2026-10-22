package com.larus.lbs.trace.api;

import android.os.SystemClock;
import ci9.b;
import com.larus.lbs.trace.api.model.LbsTraceLevel;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes30.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ci9.a f355711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f355712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f355713c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f355714d;

    public a(ci9.a r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "eventName");
        this.f355711a = r100;
        this.f355712b = r101;
        this.f355713c = SystemClock.elapsedRealtime();
        this.f355714d = new AtomicBoolean(false);
    }

    public final void a(Map<String, ? extends Object> r110, LbsTraceLevel r111) {
        Intrinsics.checkNotNullParameter(r110, "customParams");
        Intrinsics.checkNotNullParameter(r111, "level");
        ci9.a r100 = this.f355711a;
        if (r100 != null) goto L6;
        return;
    L6:
        if (this.f355714d.compareAndSet(false, true) == true) goto L22;
        return;
    L22:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L19
        ILbsTraceService.Companion r102 = ILbsTraceService.f355708a;     // Catch: Throwable -> L19
        String r103 = this.f355712b;     // Catch: Throwable -> L19
        long r104 = RangesKt.coerceAtLeast(SystemClock.elapsedRealtime() - this.f355713c, 0);     // Catch: Throwable -> L19
        LinkedHashMap r105 = new LinkedHashMap();     // Catch: Throwable -> L19
        Iterator<Map.Entry<String, ? extends Object>> r112 = r110.entrySet().iterator();     // Catch: Throwable -> L19
    L10:
        if (r112.hasNext() == false) goto L17;
        Map.Entry<String, ? extends Object> r106 = r112.next();     // Catch: Throwable -> L19
        if (r106.getValue() == null) goto L14;
        boolean r107 = true;
    L15:
        if (r107 == false) goto L10;
        r105.put(r106.getKey(), r106.getValue());     // Catch: Throwable -> L19
        goto L10
    L14:
        r107 = false;
        goto L15
    L17:
        r102.a(r100, new b(r103, r111, r104, r105));     // Catch: Throwable -> L19
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
