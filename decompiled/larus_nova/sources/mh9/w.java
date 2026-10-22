package mh9;

/* JADX INFO: loaded from: classes30.dex */
public final class w {
    public static final String a(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        if ((true ^ r101) == true) goto L13;
        r100 = null;
    L13:
        if (r100 != null) goto L16;
        return "unknown";
    L16:
        return r100;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L10
    }
}
