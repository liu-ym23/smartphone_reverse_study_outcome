package com.larksuite.common_selection;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;

/* JADX INFO: loaded from: classes24.dex */
public final class a {
    public static void a(Context r100) {
        if (r100 != null) goto L16;
        return;
    L16:
        Vibrator r101 = (Vibrator) r100.getSystemService("vibrator");     // Catch: Exception -> L14
        if (r101 != null) goto L7;
    L15:
        return;
    L7:
        if (r101.hasVibrator() == false) goto L15;
        if (Build.VERSION.SDK_INT < 29) goto L12;
        r101.vibrate(VibrationEffect.createPredefined(0));     // Catch: Exception -> L14
        goto L15
    L12:
        r101.vibrate(70);     // Catch: Exception -> L14
    }
}
