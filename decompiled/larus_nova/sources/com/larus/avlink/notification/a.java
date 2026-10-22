package com.larus.avlink.notification;

import com.bytedance.keva.Keva;
import com.larus.avlink.n1;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes25.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f293461a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f293462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f293463c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f293464d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f293465e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Long f293466f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Boolean f293467g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f293468h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static long f293469i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Long> f293470j = null;

    public a() {
    }

    static {
        f293461a = new a();
        f293470j = new ConcurrentHashMap();
    }

    public static Keva a() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Object r101 = Result.m9449constructorimpl(Keva.getRepo("proactive_summary_cache", 1));     // Catch: Throwable -> L4
    L7:
        if (Result.m9452exceptionOrNullimpl(r101) == null) goto L11;
        n1.e("ProactiveSummaryRecords", "[NotificationTracer] skip proactive summary cache because keva is not ready");
        r101 = null;
    L11:
        return (Keva) r101;
    L4:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static boolean b(Long r100) {
        if (f293469i > 0) goto L9;
        Keva r101 = a();
        if (r101 == null) goto L7;
        long r102 = r101.getLong("last_unlock_timestamp_ms", 0);
    L8:
        f293469i = r102;
        goto L9
    L7:
        r102 = 0;
    L9:
        long r103 = f293469i;
        boolean r104 = false;
        if (r100 != null) goto L14;
        n1.d("ProactiveSummaryRecords", "[NotificationTracer] skip unlock drop check because earliestClientReceiveTimestampMs is null. lastUnlockTimestampMs=" + r103);
        return false;
    L14:
        if (r103 > 0) goto L16;
    L18:
        n1.d("ProactiveSummaryRecords", "[NotificationTracer] check unlock drop. earliestClientReceiveTimestampMs=" + r100 + ", lastUnlockTimestampMs=" + r103 + ", shouldDrop=" + r104);
        return r104;
    L16:
        if (r100.longValue() > r103) goto L18;
        r104 = true;
        goto L18
    }
}
