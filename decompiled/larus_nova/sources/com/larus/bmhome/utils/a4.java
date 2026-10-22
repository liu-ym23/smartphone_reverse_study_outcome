package com.larus.bmhome.utils;

import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.os.VibratorManager;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes4.dex */
public final class a4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a4 f314971a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f314972b;

    public a4() {
    }

    static {
        f314971a = new a4();
        f314972b = 50;
    }

    public static void a(long r100) {
        if (r100 >= 0) goto L33;
        FLogger.f375446a.e("VibrateUtil", "milliseconds error!!! millisecond cannot be less than 0");
        return;
    L33:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L26
        Unit r102 = null;
        if (Build.VERSION.SDK_INT <= 31) goto L18;
        Object r103 = AppHost.f326268a.getApplication().getSystemService("vibrator_manager");     // Catch: Throwable -> L26
        if ((r103 instanceof VibratorManager) == false) goto L11;
        VibratorManager r104 = (VibratorManager) r103;     // Catch: Throwable -> L26
    L12:
        if (r104 == null) goto L14;
        Vibrator r105 = r104.getDefaultVibrator();     // Catch: Throwable -> L26
    L15:
        VibrationEffect r106 = VibrationEffect.createOneShot(r100, -1);     // Catch: Throwable -> L26
        if (r105 == null) goto L24;
        r105.vibrate(r106);     // Catch: Throwable -> L26
        r102 = Unit.INSTANCE;     // Catch: Throwable -> L26
    L24:
        Object r107 = Result.m9449constructorimpl(r102);     // Catch: Throwable -> L26
    L28:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L35;
        FLogger.f375446a.e("VibrateUtil", "vibrate error", r108);
        return;
    L35:
        return;
    L14:
        r105 = null;
        goto L15
    L11:
        r104 = null;
        goto L12
    L18:
        Object r109 = AppHost.f326268a.getApplication().getSystemService("vibrator");     // Catch: Throwable -> L26
        if ((r109 instanceof Vibrator) == false) goto L21;
        Vibrator r110 = (Vibrator) r109;     // Catch: Throwable -> L26
    L22:
        if (r110 == null) goto L24;
        r110.vibrate(r100);     // Catch: Throwable -> L26
        r102 = Unit.INSTANCE;     // Catch: Throwable -> L26
        goto L24
    L21:
        r110 = null;
    L26:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L28
    }
}
