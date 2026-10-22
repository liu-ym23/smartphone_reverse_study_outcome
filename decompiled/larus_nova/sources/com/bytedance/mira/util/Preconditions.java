package com.bytedance.mira.util;

/* JADX INFO: loaded from: classes.dex */
public final class Preconditions {
    private Preconditions() {
    }

    public static void checkArgument(boolean r100, String r101) {
        if (r100 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(r101);
    }

    public static <T> T checkNotNull(T r100, String r101) {
        if (r100 == null) goto L5;
        return r100;
    L5:
        throw new IllegalArgumentException(r101);
    }

    public static void checkTrue(boolean r100, String r101) {
        if (r100 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(r101);
    }

    public static void checkArgument(boolean r100, String r101, Object... r102) {
        if (r100 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(String.format(r101, r102));
    }

    public static int checkElementIndex(int r100, int r101, String r102) {
        if (r100 < 0) goto L6;
        if (r100 >= r101) goto L6;
        return r100;
    L6:
        throw new IndexOutOfBoundsException(r102);
    }

    public static <T> T checkNotNull(T r100, String r101, Object... r102) {
        if (r100 == null) goto L5;
        return r100;
    L5:
        throw new IllegalArgumentException(String.format(r101, r102));
    }

    public static void checkTrue(boolean r100, String r101, Object... r102) {
        if (r100 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(String.format(r101, r102));
    }

    public static int checkElementIndex(int r100, int r101, String r102, Object... r103) {
        if (r100 < 0) goto L6;
        if (r100 >= r101) goto L6;
        return r100;
    L6:
        throw new IndexOutOfBoundsException(String.format(r102, r103));
    }
}
