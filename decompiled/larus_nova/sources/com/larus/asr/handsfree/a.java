package com.larus.asr.handsfree;

import android.app.Application;
import android.content.Intent;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f287297a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f287298b;

    static {
        f287297a = new a();
    }

    public a() {
    }

    public static void a() {
        if (f287298b == true) goto L5;
        return;
    L5:
        Application r100 = AppHost.f326268a.getApplication();
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L8
        int r102 = HandsfreeForegroundService.f287295b;     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);     // Catch: Throwable -> L8
        Object r103 = Result.m9449constructorimpl(Boolean.valueOf(r100.stopService(new Intent(r100, HandsfreeForegroundService.class))));     // Catch: Throwable -> L8
    L10:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L13;
        FLogger.f375446a.e("HandsfreeForegroundServiceManager", "[HF] foreground service stopService failed, " + r104.getMessage());
    L13:
        f287298b = false;
        FLogger.f375446a.i("HandsfreeForegroundServiceManager", "[HF] foreground service stop requested");
        return;
    L8:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }
}
