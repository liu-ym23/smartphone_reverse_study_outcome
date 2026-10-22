package udc;

import android.graphics.Color;

/* JADX INFO: loaded from: classes38.dex */
public final class b {
    public static final int a(float r100, int r101) {
        float r102 = 0;
        return (((((int) (((Color.alpha(r101) - r102) * r100) + r102)) << 24) + (Color.red(r101) << 16)) + (Color.green(r101) << 8)) + Color.blue(r101);
    }
}
