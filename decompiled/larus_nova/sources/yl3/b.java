package yl3;

import androidx.core.view.GravityCompat;

/* JADX INFO: loaded from: classes14.dex */
public final class b {
    public static String a(int r100) {
        StringBuilder r101 = new StringBuilder();
        if ((r100 & 119) != 119) goto L5;
        r101.append("FILL|");
    L41:
        if (r100 != 17) goto L43;
        r101.append("center|");
    L43:
        r101.deleteCharAt(r101.length() - 1);
        return r101.toString();
    L5:
        boolean r102 = false;
        if ((r100 & 112) != 112) goto L9;
        r101.append("fill_vertical|");
    L20:
        if ((r100 & 7) != 7) goto L23;
        r101.append("fill_horizontal|");
        goto L41
    L23:
        if ((r100 & GravityCompat.START) != 8388611) goto L27;
        r101.append("start|");
    L25:
        r102 = true;
    L30:
        if ((r100 & GravityCompat.END) != 8388613) goto L34;
        r101.append("end|");
    L32:
        r102 = true;
    L36:
        if (r102 == true) goto L41;
        if ((r100 & 1) != 1) goto L41;
        r101.append("center_horizontal|");
        goto L41
    L34:
        if ((r100 & 5) != 5) goto L36;
        r101.append("right|");
        goto L32
    L27:
        if ((r100 & 3) != 3) goto L30;
        r101.append("left|");
        goto L25
    L9:
        if ((r100 & 48) != 48) goto L11;
        r101.append("top|");
        boolean r103 = true;
    L13:
        if ((r100 & 80) != 80) goto L15;
        r101.append("bottom|");
        r103 = true;
    L15:
        if (r103 == true) goto L20;
        if ((r100 & 16) != 16) goto L20;
        r101.append("center_vertical|");
        goto L20
    L11:
        r103 = false;
        goto L13
    }
}
