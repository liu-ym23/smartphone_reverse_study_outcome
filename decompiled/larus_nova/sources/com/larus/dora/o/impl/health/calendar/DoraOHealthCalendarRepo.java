package com.larus.dora.o.impl.health.calendar;

import android.os.SystemClock;
import com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService;
import com.larus.network.http.y;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes27.dex */
public final class DoraOHealthCalendarRepo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DoraOHealthCalendarRepo f338686a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, a> f338687b = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f338688a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f338689b;

        public a(d r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, "data");
            this.f338688a = r100;
            this.f338689b = r101;
        }
    }

    public DoraOHealthCalendarRepo() {
    }

    static {
        f338686a = new DoraOHealthCalendarRepo();
        f338687b = new ConcurrentHashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object a(String r210, Continuation<? super d> r211) {
        final String r100 = r210;
        if ((r211 instanceof DoraOHealthCalendarRepo$fetchCalendar$1) == false) goto L7;
        DoraOHealthCalendarRepo$fetchCalendar$1 r101 = (DoraOHealthCalendarRepo$fetchCalendar$1) r211;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        DoraOHealthCalendarRepo$fetchCalendar$1 r110 = r101;
        Object r103 = r110.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r110.label;
        if (r105 == 0) goto L18;
        if (r105 != 1) goto L17;
        r100 = (String) r110.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Exception -> L14 CancellationException -> L55
        String r111 = "OHealthCalendar";
    L29:
        final com.larus.network.http.a r106 = (com.larus.network.http.a) r103;     // Catch: Exception -> L40 CancellationException -> L55
        if ((r106 instanceof y) == false) goto L32;
        y r107 = (y) r106;     // Catch: Exception -> L40 CancellationException -> L55
    L33:
        if (r107 == null) goto L35;
        d r108 = (d) r107.f360135b;     // Catch: Exception -> L40 CancellationException -> L55
    L36:
        if (r108 != null) goto L42;
        FLogger.f375446a.f(r111, new b(r100, r106));     // Catch: Exception -> L40 CancellationException -> L55
        return null;
    L40:
        Exception e100 = e;
    L41:
        Object r109 = null;
    L53:
        FLogger.f375446a.e(r111, "fetch month=" + r100 + " error: " + e100.getMessage());
        return r109;
    L42:
        r109 = null;
        List<e> r112 = r108.a();     // Catch: Exception -> L52 CancellationException -> L55
        if (r112 != null) goto L46;
        r112 = CollectionsKt.emptyList();     // Catch: Exception -> L52 CancellationException -> L55
    L46:
        String r113 = CollectionsKt.joinToString$default(CollectionsKt.filterNotNull(r112), " ", null, null, 0, null, new c(), 30, null);     // Catch: Exception -> L52 CancellationException -> L55
        FLogger r114 = FLogger.f375446a;     // Catch: Exception -> L52 CancellationException -> L55
        StringBuilder r115 = new StringBuilder("loaded month=");     // Catch: Exception -> L52 CancellationException -> L55
        r115.append(r100);     // Catch: Exception -> L52 CancellationException -> L55
        r115.append(" days=");     // Catch: Exception -> L52 CancellationException -> L55
        List<e> r116 = r108.a();     // Catch: Exception -> L52 CancellationException -> L55
        if (r116 == null) goto L49;
        int r117 = r116.size();     // Catch: Exception -> L52 CancellationException -> L55
    L50:
        r115.append(r117);     // Catch: Exception -> L52 CancellationException -> L55
        r115.append(" [");     // Catch: Exception -> L52 CancellationException -> L55
        r115.append(r113);     // Catch: Exception -> L52 CancellationException -> L55
        r115.append(']');     // Catch: Exception -> L52 CancellationException -> L55
        r114.i(r111, r115.toString());     // Catch: Exception -> L52 CancellationException -> L55
        f338687b.put(r100, new a(r108, SystemClock.elapsedRealtime()));     // Catch: Exception -> L52 CancellationException -> L55
        return r108;
    L49:
        r117 = 0;
    L52:
        e100 = e;
        goto L53
    L35:
        r108 = null;
        goto L36
    L32:
        r107 = null;
    L14:
        e100 = e;
        r111 = "OHealthCalendar";
        goto L41
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r103);
        a r118 = f338687b.get(r100);
        if (r118 != null) goto L21;
        r111 = "OHealthCalendar";
    L61:
        FLogger.f375446a.i(r111, "fetch month=" + r100);     // Catch: Exception -> L40 CancellationException -> L55
        com.larus.dora.api.network.a r119 = com.larus.dora.api.network.a.f331768a;     // Catch: Exception -> L40 CancellationException -> L55
        JSONObject r120 = new JSONObject();     // Catch: Exception -> L40 CancellationException -> L55
        r120.put(BdpGameHostBaseUIService.DATE_PICKER_TYPE_MONTH, r100);     // Catch: Exception -> L40 CancellationException -> L55
        Unit r121 = Unit.INSTANCE;     // Catch: Exception -> L40 CancellationException -> L55
        r110.L$0 = r100;     // Catch: Exception -> L40 CancellationException -> L55
        r110.label = 1;     // Catch: Exception -> L40 CancellationException -> L55
        r103 = com.larus.dora.api.network.a.c(r119, d.class, "/alice/wearable/health/calendar", r120, null, r110, 248);     // Catch: Exception -> L40 CancellationException -> L55
        if (r103 != r104) goto L29;
        return r104;
    L21:
        if ((SystemClock.elapsedRealtime() - r118.f338689b) >= 300000) goto L24;
        FLogger.f375446a.g("OHealthCalendar", new com.larus.dora.o.impl.health.calendar.a(r100));
        return r118.f338688a;
    L24:
        r111 = "OHealthCalendar";
    L55:
        e = move-exception;
        throw e;
    L7:
        r101 = new DoraOHealthCalendarRepo$fetchCalendar$1(this, r211);
        goto L8
    }
}
