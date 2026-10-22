package org.apache.commons.lang3;

/* JADX INFO: loaded from: classes42.dex */
public class Validate {
    public static void isTrue(boolean r100) {
        if (r100 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException("The validated expression is false");
    }

    public static <T> T[] noNullElements(T[] r100) {
        return (T[]) noNullElements(r100, "The validated array contains null element at index: %d", new Object[0]);
    }

    public static <T> T[] notEmpty(T[] r100) {
        return (T[]) notEmpty(r100, "The validated array is empty", new Object[0]);
    }

    public static <T> T notNull(T r100) {
        return (T) notNull(r100, "The validated object is null", new Object[0]);
    }

    public static void isTrue(boolean r100, String r101, Object... r102) {
        if (r100 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(String.format(r101, r102));
    }

    public static <T> T[] noNullElements(T[] r100, String r101, Object... r102) {
        notNull(r100);
        int r103 = 0;
    L4:
        if (r103 >= r100.length) goto L10;
        if (r100[r103] == null) goto L9;
        r103 = r103 + 1;
        goto L4
    L9:
        throw new IllegalArgumentException(String.format(r101, ArrayUtils.add(r102, Integer.valueOf(r103))));
    L10:
        return r100;
    }

    public static <T> T[] notEmpty(T[] r100, String r101, Object... r102) {
        if (r100 == null) goto L9;
        if (r100.length == 0) goto L7;
        return r100;
    L7:
        throw new IllegalArgumentException(String.format(r101, r102));
    L9:
        throw new NullPointerException(String.format(r101, r102));
    }

    public static <T> T notNull(T r100, String r101, Object... r102) {
        if (r100 == null) goto L5;
        return r100;
    L5:
        throw new NullPointerException(String.format(r101, r102));
    }
}
