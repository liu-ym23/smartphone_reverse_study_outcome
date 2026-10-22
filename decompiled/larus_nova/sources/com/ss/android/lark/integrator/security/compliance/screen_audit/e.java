package com.ss.android.lark.integrator.security.compliance.screen_audit;

import android.app.Activity;
import android.os.SystemClock;
import com.ss.android.lark.log.Log;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes36.dex */
public final class e implements Activity.ScreenCaptureCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f428131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Activity f428132b;

    public e(d r100, Activity r101) {
        this.f428131a = r100;
        this.f428132b = r101;
    }

    @Override // android.app.Activity.ScreenCaptureCallback
    public final void onScreenCaptured() {
        d r100 = this.f428131a;
        Activity r101 = this.f428132b;
        r100.getClass();
        long r102 = SystemClock.uptimeMillis();
        long r103 = r102 - r100.f428130c;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L5
        Object r105 = Result.m9449constructorimpl(Long.valueOf(w4c.c.a().o0()));     // Catch: Throwable -> L5
    L7:
        long r106 = 1500;
        if (Result.m9455isFailureimpl(r105) == false) goto L10;
        r105 = 1500L;
    L10:
        long r107 = ((Number) r105).longValue();
        if (r107 <= 0) goto L14;
        r106 = r107;
    L14:
        if (r103 >= r106) goto L16;
        Log.i("OfficeSDKScreenAudit", "screen captured on " + r101.getClass().getSimpleName() + ", dedup'd (" + r103 + "ms < " + r106 + "ms window)");
        return;
    L16:
        r100.f428130c = r102;
        Log.i("OfficeSDKScreenAudit", "screen captured on ".concat(r101.getClass().getSimpleName()));
        r100.f428128a.b();
        return;
    L5:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
