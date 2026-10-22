package com.obric.oui.color;

import android.graphics.Color;

/* JADX INFO: loaded from: classes33.dex */
public final class h0 {
    public static boolean a(int r100) {
        int r101 = Color.red(r100);
        int r102 = Color.green(r100);
        int r103 = Color.blue(r100);
        if (r101 != r102) goto L7;
        if (r101 != r103) goto L7;
        return false;
    L7:
        return true;
    }

    public static boolean b(int r100) {
        double r101 = ((double) ((r100 >> 16) & 255)) / 255.0d;
        double r102 = ((double) ((r100 >> 8) & 255)) / 255.0d;
        double r103 = c(r101);
        double r104 = c(r102);
        if ((((r103 * 0.2126d) + (r104 * 0.7152d)) + (c(((double) (r100 & 255)) / 255.0d) * 0.0722d)) >= 0.5d) goto L5;
        return true;
    L5:
        return false;
    }

    public static double c(double r100) {
        if (r100 > 0.04045d) goto L7;
        return r100 / 12.92d;
    L7:
        return Math.pow((r100 + 0.055d) / 1.055d, 2.4d);
    }
}
