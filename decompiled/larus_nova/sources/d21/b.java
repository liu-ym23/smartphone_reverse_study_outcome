package d21;

/* JADX INFO: loaded from: classes47.dex */
public final class b {
    public b() {
    }

    public static String a(String r100) {
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        return r100;
    L9:
        if (r100.length() > 5) goto L12;
        return r100;
    L12:
        return r100.substring(0, 5) + "...";
    L5:
        r101 = false;
        goto L6
    }
}
