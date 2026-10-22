package com.ss.android.lark.auditsdk.screen;

import android.app.Activity;
import android.os.SystemClock;
import com.ss.android.lark.log.Log;
import java.lang.ref.WeakReference;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes34.dex */
public final class j implements Activity.ScreenCaptureCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WeakReference<Activity> f409592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f409593b;

    public j(WeakReference<Activity> r100, h r101) {
        this.f409592a = r100;
        this.f409593b = r101;
    }

    @Override // android.app.Activity.ScreenCaptureCallback
    public final void onScreenCaptured() {
        Activity r100 = this.f409592a.get();
        if (r100 == null) goto L38;
        h r101 = this.f409593b;
        r101.getClass();
        Log.i("ScreenAuditCore", "[" + r101.f409584a + "] screenshot callback triggered, activity=" + r100.getClass().getName());
        long r102 = SystemClock.uptimeMillis();
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L7
        Object r104 = Result.m9449constructorimpl(Long.valueOf(r101.f409585b.invoke().longValue()));     // Catch: Throwable -> L7
    L9:
        long r105 = 1500;
        if (Result.m9455isFailureimpl(r104) == false) goto L13;
        r104 = 1500L;
    L13:
        if (((Number) r104).longValue() <= 0) goto L15;
        boolean r106 = true;
    L16:
        if (r106 == true) goto L19;
        r104 = null;
    L19:
        Long r107 = (Long) r104;
        if (r107 == null) goto L22;
        r105 = r107.longValue();
    L22:
        long r108 = r102 - r101.f409590g;
        if (r108 >= r105) goto L25;
        Log.i("ScreenAuditCore", "[" + r101.f409584a + "] screenshot dedup, elapsed=" + r108 + " window=" + r105);
        return;
    L25:
        r101.f409590g = r102;
        Log.i("ScreenAuditCore", "[" + r101.f409584a + "] screenshot accepted, elapsed=" + r108 + " window=" + r105);
        r101.f409586c.invoke(r100);     // Catch: Throwable -> L28
        Object r109 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L28
    L30:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r109);
        if (r110 == null) goto L40;
        Log.e("ScreenAuditCore", "[" + r101.f409584a + "] onScreenCaptured failed", r110);
        return;
    L40:
        return;
    L28:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L30
    L15:
        r106 = false;
    L7:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    }
}
