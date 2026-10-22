package g2a;

/* JADX INFO: loaded from: classes4.dex */
public final class d {
    public static String a(CharSequence r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L14;
        if (r100 != null) goto L15;
        return null;
    L15:
        return r100.toString();
    L14:
        return e.f479755a.a(r100, true, false, 3);
    L5:
        if (((String) r100).length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public static final String b(CharSequence r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L14;
        if (r100 != null) goto L16;
        return null;
    L16:
        return r100.toString();
    L14:
        e r102 = e.f479755a;
        return f.a(r100, true, false);
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public static final String c(CharSequence r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L14;
        if (r100 != null) goto L16;
        return null;
    L16:
        return r100.toString();
    L14:
        e r102 = e.f479755a;
        return f.a(r100, false, true);
    L5:
        if (((String) r100).length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public static final String d(CharSequence r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L14;
        if (r100 != null) goto L16;
        return null;
    L16:
        return r100.toString();
    L14:
        e r102 = e.f479755a;
        return f.a(r100, false, false);
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }
}
