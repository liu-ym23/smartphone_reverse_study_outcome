package com.obric.audio.enroll.sidauth;

import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f395550a = null;

    static {
        f395550a = new b();
    }

    public b() {
    }

    public static long a() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L5
        pia.b r101 = pia.b.f529407a;     // Catch: Throwable -> L5
        Intrinsics.checkNotNullParameter("obric.sid_auth.batch.last_attempt_ts_ms", "key");     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(Long.valueOf(pia.b.a().getLong("obric.sid_auth.batch.last_attempt_ts_ms", 0)));     // Catch: Throwable -> L5
    L7:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L11;
        FLogger.f375446a.e("SidAuthBatchStateStore", "getLastAttemptTsMs fail: " + r103.getMessage());
    L11:
        if (Result.m9455isFailureimpl(r102) == false) goto L14;
        r102 = 0L;
    L14:
        return ((Number) r102).longValue();
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static void b(long r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L4
        pia.b r102 = pia.b.f529407a;     // Catch: Throwable -> L4
        Intrinsics.checkNotNullParameter("obric.sid_auth.batch.last_attempt_ts_ms", "key");     // Catch: Throwable -> L4
        pia.b.a().storeLong("obric.sid_auth.batch.last_attempt_ts_ms", r100);     // Catch: Throwable -> L4
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L10;
        FLogger.f375446a.e("SidAuthBatchStateStore", "updateLastAttemptTsMs fail: " + r104.getMessage());
    L10:
        if (Result.m9456isSuccessimpl(r103) == false) goto L15;
        Unit r105 = (Unit) r103;
        FLogger.f375446a.i("SidAuthBatchStateStore", "updateLastAttemptTsMs tsMs=" + r100);
        return;
    L15:
        return;
    L4:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }
}
