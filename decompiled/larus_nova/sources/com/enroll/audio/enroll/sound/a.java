package com.enroll.audio.enroll.sound;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f273810a = 0;

    static {
    }

    public static void a(Context r100, int r101, long r102) {
        Object r103 = r100.getSystemService("vibrator");
        Vibrator r104 = null;
        if ((r103 instanceof Vibrator) == false) goto L5;
        Vibrator r105 = (Vibrator) r103;
    L6:
        if (r105 != null) goto L8;
        return;
    L8:
        if (r105.hasVibrator() == false) goto L10;
        r104 = r105;
    L10:
        if (r104 == null) goto L23;
        int r106 = Build.VERSION.SDK_INT;
        if (r106 < 29) goto L16;
        r104.vibrate(VibrationEffect.createPredefined(r101));
        return;
    L16:
        if (r106 < 26) goto L18;
        r104.vibrate(VibrationEffect.createOneShot(r102, -1));
        return;
    L18:
        r104.vibrate(r102);
        return;
    L23:
        return;
    L5:
        r105 = null;
        goto L6
    }
}
