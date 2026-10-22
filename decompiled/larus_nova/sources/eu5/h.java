package eu5;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;

/* JADX INFO: loaded from: classes19.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Vibrator f474084a;

    public static void a(Context r100, int r101, int r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        Context r103 = r100.getApplicationContext();
        boolean r104 = true;
        if (r102 >= 1) goto L10;
        if (r102 == (-1)) goto L10;
        r102 = 1;
    L10:
        if (r102 <= 255) goto L13;
        r102 = 255;
    L13:
        if (r101 > 0) goto L17;
        tt5.a.k("VibratorUtil", "vibrator: milliseconds must be positive");
        return;
    L17:
        if (f474084a != null) goto L20;
        if (r103 == null) goto L20;
        f474084a = (Vibrator) r103.getSystemService("vibrator");
    L20:
        Vibrator r105 = f474084a;
        if (r105 != null) goto L23;
    L33:
        tt5.a.d("VibratorUtil", "vibrator is unavailable");
        return;
    L23:
        if (r105.hasVibrator() == false) goto L33;
        f474084a.cancel();
        if (Build.VERSION.SDK_INT >= 26) goto L29;
        r104 = false;
    L29:
        if (r104 == false) goto L31;
        f474084a.vibrate(VibrationEffect.createOneShot(r101, r102));
        return;
    L31:
        f474084a.vibrate(r101);
    }
}
