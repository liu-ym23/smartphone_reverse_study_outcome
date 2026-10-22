package k6a;

import android.graphics.Path;

/* JADX INFO: loaded from: classes32.dex */
public final class a {
    public static Path a(float[] r100, boolean r101) {
        Path r102 = new Path();
        if (r100 == null) goto L13;
        int r103 = 2;
        if (r100.length < 2) goto L13;
        r102.moveTo(r100[0], r100[1]);
    L9:
        if (r103 >= r100.length) goto L11;
        r102.lineTo(r100[r103], r100[r103 + 1]);
        r103 = r103 + 2;
        goto L9
    L11:
        if (r101 == false) goto L13;
        r102.close();
    L13:
        return r102;
    }
}
