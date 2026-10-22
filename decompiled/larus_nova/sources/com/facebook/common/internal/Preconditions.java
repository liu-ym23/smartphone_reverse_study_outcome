package com.facebook.common.internal;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class Preconditions {
    private Preconditions() {
    }

    public static void checkArgument(boolean r100) {
        if (r100 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException();
    }

    public static <T> T checkNotNull(T r100) {
        if (r100 == null) goto L5;
        return r100;
    L5:
        throw null;
    }

    public static void checkState(boolean r100) {
        if (r100 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException();
    }

    public static void checkArgument(boolean r100, @Nullable Object r101) {
        if (r100 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(String.valueOf(r101));
    }

    public static int checkElementIndex(int r100, int r101) {
        return checkElementIndex(r100, r101, "index");
    }

    public static <T> T checkNotNull(T r100, @Nullable Object r101) {
        if (r100 == null) goto L5;
        return r100;
    L5:
        throw new NullPointerException(String.valueOf(r101));
    }

    public static int checkPositionIndex(int r100, int r101) {
        return checkPositionIndex(r100, r101, "index");
    }

    public static void checkState(boolean r100, @Nullable Object r101) {
        if (r100 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(String.valueOf(r101));
    }

    public static String format(@Nullable String r100, @Nullable Object... r101) {
        String r102 = String.valueOf(r100);
        StringBuilder r103 = new StringBuilder(r102.length() + (r101.length * 16));
        int r104 = 0;
        int r105 = 0;
    L4:
        if (r104 >= r101.length) goto L9;
        int r106 = r102.indexOf("%s", r105);
        if (r106 == (-1)) goto L9;
        r103.append(r102.substring(r105, r106));
        int r107 = r104 + 1;
        r103.append(r101[r104]);
        r105 = r106 + 2;
        r104 = r107;
    L9:
        r103.append(r102.substring(r105));
        if (r104 >= r101.length) goto L17;
        r103.append(" [");
        int r108 = r104 + 1;
        r103.append(r101[r104]);
    L13:
        if (r108 >= r101.length) goto L15;
        r103.append(", ");
        int r109 = r108 + 1;
        r103.append(r101[r108]);
        r108 = r109;
        goto L13
    L15:
        r103.append(']');
    L17:
        return r103.toString();
    }

    private static String badElementIndex(int r100, int r101, @Nullable String r102) {
        if (r100 < 0) goto L5;
        if (r101 < 0) goto L10;
        return format("%s (%s) must be less than size (%s)", new Object[]{r102, Integer.valueOf(r100), Integer.valueOf(r101)});
    L10:
        throw new IllegalArgumentException("negative size: " + r101);
    L5:
        return format("%s (%s) must not be negative", new Object[]{r102, Integer.valueOf(r100)});
    }

    private static String badPositionIndex(int r100, int r101, @Nullable String r102) {
        if (r100 < 0) goto L5;
        if (r101 < 0) goto L10;
        return format("%s (%s) must not be greater than size (%s)", new Object[]{r102, Integer.valueOf(r100), Integer.valueOf(r101)});
    L10:
        throw new IllegalArgumentException("negative size: " + r101);
    L5:
        return format("%s (%s) must not be negative", new Object[]{r102, Integer.valueOf(r100)});
    }

    private static String badPositionIndexes(int r100, int r101, int r102) {
        if (r100 < 0) goto L13;
        if (r100 > r102) goto L13;
        if (r101 < 0) goto L11;
        if (r101 > r102) goto L11;
        return format("end index (%s) must not be less than start index (%s)", new Object[]{Integer.valueOf(r101), Integer.valueOf(r100)});
    L11:
        return badPositionIndex(r101, r102, "end index");
    L13:
        return badPositionIndex(r100, r102, "start index");
    }

    public static void checkArgument(boolean r100, @Nullable String r101, @Nullable Object... r102) {
        if (r100 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(format(r101, r102));
    }

    public static int checkElementIndex(int r100, int r101, @Nullable String r102) {
        if (r100 < 0) goto L6;
        if (r100 >= r101) goto L6;
        return r100;
    L6:
        throw new IndexOutOfBoundsException(badElementIndex(r100, r101, r102));
    }

    public static <T> T checkNotNull(T r100, @Nullable String r101, @Nullable Object... r102) {
        if (r100 == null) goto L5;
        return r100;
    L5:
        throw new NullPointerException(format(r101, r102));
    }

    public static int checkPositionIndex(int r100, int r101, @Nullable String r102) {
        if (r100 < 0) goto L6;
        if (r100 > r101) goto L6;
        return r100;
    L6:
        throw new IndexOutOfBoundsException(badPositionIndex(r100, r101, r102));
    }

    public static void checkPositionIndexes(int r100, int r101, int r102) {
        if (r100 < 0) goto L7;
        if (r101 < r100) goto L7;
        if (r101 > r102) goto L7;
        return;
    L7:
        throw new IndexOutOfBoundsException(badPositionIndexes(r100, r101, r102));
    }

    public static void checkState(boolean r100, @Nullable String r101, @Nullable Object... r102) {
        if (r100 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(format(r101, r102));
    }
}
