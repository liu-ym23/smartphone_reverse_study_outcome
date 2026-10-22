package yl3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b {
    public static String a(int r6) {
        StringBuilder r0 = new StringBuilder();
        if ((r6 & 119) != 119) goto L5;
        r0.append("FILL|");
    L41:
        if (r6 != 17) goto L43;
        r0.append("center|");
    L43:
        r0.deleteCharAt(r0.length() - 1);
        return r0.toString();
    L5:
        boolean r3 = false;
        if ((r6 & 112) != 112) goto L9;
        r0.append("fill_vertical|");
    L20:
        if ((r6 & 7) != 7) goto L23;
        r0.append("fill_horizontal|");
        goto L41
    L23:
        if ((r6 & 8388611) != 8388611) goto L27;
        r0.append("start|");
    L25:
        r3 = true;
    L30:
        if ((r6 & 8388613) != 8388613) goto L34;
        r0.append("end|");
    L32:
        r3 = true;
    L36:
        if (r3 == true) goto L41;
        if ((r6 & 1) != 1) goto L41;
        r0.append("center_horizontal|");
        goto L41
    L34:
        if ((r6 & 5) != 5) goto L36;
        r0.append("right|");
        goto L32
    L27:
        if ((r6 & 3) != 3) goto L30;
        r0.append("left|");
        goto L25
    L9:
        if ((r6 & 48) != 48) goto L11;
        r0.append("top|");
        boolean r1 = true;
    L13:
        if ((r6 & 80) != 80) goto L15;
        r0.append("bottom|");
        r1 = true;
    L15:
        if (r1 == true) goto L20;
        if ((r6 & 16) != 16) goto L20;
        r0.append("center_vertical|");
        goto L20
    L11:
        r1 = false;
        goto L13
    }
}
