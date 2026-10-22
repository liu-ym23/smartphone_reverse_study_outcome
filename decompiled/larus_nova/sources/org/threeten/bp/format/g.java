package org.threeten.bp.format;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes41.dex */
public final class g {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final g f526429e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final char f526430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final char f526431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final char f526432c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final char f526433d;

    static {
        f526429e = new g();
        new ConcurrentHashMap(16, 0.75f, 2);
    }

    public final int hashCode() {
        return ((this.f526430a + this.f526431b) + this.f526432c) + this.f526433d;
    }

    public final String toString() {
        return "DecimalStyle[" + this.f526430a + this.f526431b + this.f526432c + this.f526433d + "]";
    }

    public g() {
        this.f526430a = '0';
        this.f526431b = '+';
        this.f526432c = '-';
        this.f526433d = '.';
    }

    public final String a(String r100) {
        char r101 = this.f526430a;
        if (r101 != '0') goto L5;
        return r100;
    L5:
        int r102 = r101 - '0';
        char[] r103 = r100.toCharArray();
        int r104 = 0;
    L7:
        if (r104 >= r103.length) goto L10;
        r103[r104] = (char) (r103[r104] + r102);
        r104 = r104 + 1;
        goto L7
    L10:
        return new String(r103);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == false) goto L18;
        g r101 = (g) r100;
        if (this.f526430a == r101.f526430a) goto L10;
    L16:
        return false;
    L10:
        if (this.f526431b != r101.f526431b) goto L16;
        if (this.f526432c != r101.f526432c) goto L16;
        if (this.f526433d != r101.f526433d) goto L16;
        return true;
    L18:
        return false;
    }
}
