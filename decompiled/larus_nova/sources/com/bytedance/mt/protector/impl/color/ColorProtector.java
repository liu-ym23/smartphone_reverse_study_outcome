package com.bytedance.mt.protector.impl.color;

import android.graphics.Color;
import com.bytedance.mt.protector.ProtectorType;
import com.bytedance.mt.protector.c;
import com.bytedance.mt.protector.impl.ProtectorMethod;
import t27.a;

/* JADX INFO: loaded from: classes3.dex */
public class ColorProtector extends a {
    public ColorProtector() {
    }

    @ProtectorMethod(exceptions = {IllegalArgumentException.class})
    public static int parseColor(String r100) {
        if (c.b() == false) goto L13;
        return Color.parseColor(r100);
    L6:
        th = move-exception;
        Integer r101 = (Integer) a.tryProtect(th, Integer.class);
        if (r101 != null) goto L10;
        throw th;
    L10:
        return r101.intValue();
    L13:
        return Color.parseColor(r100);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static int HSVToColor(int r100, float[] r101) {
        if (c.b() == false) goto L13;
        return Color.HSVToColor(r100, r101);
    L6:
        th = move-exception;
        Integer r102 = (Integer) a.tryProtect(th, Integer.class);
        if (r102 != null) goto L10;
        throw th;
    L10:
        return r102.intValue();
    L13:
        return Color.HSVToColor(r100, r101);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static void RGBToHSV(int r100, int r101, int r102, float[] r103) {
        if (c.b() == true) goto L13;
    L11:
        Color.RGBToHSV(r100, r101, r102, r103);
        return;
    L13:
        Color.RGBToHSV(r100, r101, r102, r103);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        if (c.a(ProtectorType.CAST_COLOR, th) == null) goto L10;
        return;
    L10:
        throw th;
    }
}
