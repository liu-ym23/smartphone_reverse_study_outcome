package com.google.android.gms.internal.common;

import org.jspecify.nullness.NullMarked;

/* JADX INFO: loaded from: classes23.dex */
@NullMarked
public final class m {
    public static void a(int r100, int r101) {
        if (r100 < 0) goto L7;
        if (r100 >= r101) goto L7;
        return;
    L7:
        if (r100 < 0) goto L12;
        if (r101 < 0) goto L10;
        String r102 = n.a("%s (%s) must be less than size (%s)", new Object[]{"index", Integer.valueOf(r100), Integer.valueOf(r101)});
    L14:
        throw new IndexOutOfBoundsException(r102);
    L10:
        throw new IllegalArgumentException("negative size: " + r101);
    L12:
        r102 = n.a("%s (%s) must not be negative", new Object[]{"index", Integer.valueOf(r100)});
        goto L14
    }

    public static void b(int r100, int r101, int r102) {
        if (r100 < 0) goto L8;
        if (r101 < r100) goto L8;
        if (r101 > r102) goto L8;
        return;
    L8:
        if (r100 < 0) goto L15;
        if (r100 > r102) goto L15;
        if (r101 < 0) goto L14;
        if (r101 > r102) goto L14;
        String r103 = n.a("end index (%s) must not be less than start index (%s)", new Object[]{Integer.valueOf(r101), Integer.valueOf(r100)});
    L17:
        throw new IndexOutOfBoundsException(r103);
    L14:
        r103 = c(r101, r102, "end index");
    L15:
        r103 = c(r100, r102, "start index");
        goto L17
    }

    public static String c(int r100, int r101, String r102) {
        if (r100 < 0) goto L5;
        if (r101 < 0) goto L10;
        return n.a("%s (%s) must not be greater than size (%s)", new Object[]{r102, Integer.valueOf(r100), Integer.valueOf(r101)});
    L10:
        throw new IllegalArgumentException("negative size: " + r101);
    L5:
        return n.a("%s (%s) must not be negative", new Object[]{r102, Integer.valueOf(r100)});
    }
}
