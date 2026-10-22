package com.ss.android.lark.inline.ai.utils;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f427704a = 0;

    static {
    }

    public static void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Object r101 = r100.getSystemService("vibrator");
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.os.Vibrator");
        Vibrator r102 = (Vibrator) r101;
        if (Build.VERSION.SDK_INT < 26) goto L5;
        r102.vibrate(VibrationEffect.createOneShot(30, -1));
        return;
    L5:
        r102.vibrate(30);
    }
}
