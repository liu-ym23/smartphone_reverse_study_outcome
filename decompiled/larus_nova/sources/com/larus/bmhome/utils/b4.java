package com.larus.bmhome.utils;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;

/* JADX INFO: loaded from: classes26.dex */
public final class b4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f314978a = 0;

    static {
    }

    public static void a(Context r100) {
        if (r100 == null) goto L4;
        Object r101 = r100.getSystemService("vibrator");
    L5:
        Vibrator r102 = (Vibrator) r101;
        if (r102 != null) goto L8;
        return;
    L8:
        if (Build.VERSION.SDK_INT < 26) goto L10;
        r102.vibrate(VibrationEffect.createOneShot(100, -1));
        return;
    L10:
        r102.vibrate(100);
        return;
    L4:
        r101 = null;
        goto L5
    }
}
