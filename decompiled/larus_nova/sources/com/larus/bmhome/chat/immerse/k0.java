package com.larus.bmhome.chat.immerse;

import androidx.core.graphics.ColorUtils;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes25.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f303286a;

    static {
    }

    public static int a(int r100, float r101, float r102) {
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L5
        float[] r104 = {0.0f, 0.0f, 0.0f};     // Catch: Throwable -> L5
        ColorUtils.colorToHSL(r100, r104);     // Catch: Throwable -> L5
        r104[1] = r101;     // Catch: Throwable -> L5
        r104[2] = r102;     // Catch: Throwable -> L5
        return ColorUtils.HSLToColor(r104);
    L5:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return 0;
    }
}
