package com.facebook.common.util;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes22.dex */
public class HashCodeUtil {
    private static final int X = 31;

    public HashCodeUtil() {
    }

    public static int hashCode(int r100) {
        return r100 + 31;
    }

    public static int hashCode(int r100, int r101) {
        return ((r100 + 31) * 31) + r101;
    }

    public static int hashCode(int r100, int r101, int r102) {
        return ((((r100 + 31) * 31) + r101) * 31) + r102;
    }

    public static int hashCode(int r100, int r101, int r102, int r103) {
        return ((((((r100 + 31) * 31) + r101) * 31) + r102) * 31) + r103;
    }

    public static int hashCode(int r100, int r101, int r102, int r103, int r104) {
        return ((((((((r100 + 31) * 31) + r101) * 31) + r102) * 31) + r103) * 31) + r104;
    }

    public static int hashCode(int r100, int r101, int r102, int r103, int r104, int r105) {
        return ((((((((((r100 + 31) * 31) + r101) * 31) + r102) * 31) + r103) * 31) + r104) * 31) + r105;
    }

    public static int hashCode(@Nullable Object r100) {
        if (r100 != null) goto L4;
        int r101 = 0;
    L6:
        return hashCode(r101);
    L4:
        r101 = r100.hashCode();
        goto L6
    }

    public static int hashCode(@Nullable Object r100, @Nullable Object r101) {
        int r102 = 0;
        if (r100 != null) goto L5;
        int r103 = 0;
    L6:
        if (r101 == null) goto L10;
        r102 = r101.hashCode();
    L10:
        return hashCode(r103, r102);
    L5:
        r103 = r100.hashCode();
        goto L6
    }

    public static int hashCode(@Nullable Object r100, @Nullable Object r101, @Nullable Object r102) {
        int r103 = 0;
        if (r100 != null) goto L5;
        int r104 = 0;
    L6:
        if (r101 != null) goto L8;
        int r105 = 0;
    L9:
        if (r102 == null) goto L13;
        r103 = r102.hashCode();
    L13:
        return hashCode(r104, r105, r103);
    L8:
        r105 = r101.hashCode();
        goto L9
    L5:
        r104 = r100.hashCode();
        goto L6
    }

    public static int hashCode(@Nullable Object r100, @Nullable Object r101, @Nullable Object r102, @Nullable Object r103) {
        int r104 = 0;
        if (r100 != null) goto L5;
        int r105 = 0;
    L6:
        if (r101 != null) goto L8;
        int r106 = 0;
    L9:
        if (r102 != null) goto L11;
        int r107 = 0;
    L12:
        if (r103 == null) goto L16;
        r104 = r103.hashCode();
    L16:
        return hashCode(r105, r106, r107, r104);
    L11:
        r107 = r102.hashCode();
        goto L12
    L8:
        r106 = r101.hashCode();
        goto L9
    L5:
        r105 = r100.hashCode();
        goto L6
    }

    public static int hashCode(@Nullable Object r100, @Nullable Object r101, @Nullable Object r102, @Nullable Object r103, @Nullable Object r104) {
        int r105 = 0;
        if (r100 != null) goto L5;
        int r106 = 0;
    L6:
        if (r101 != null) goto L8;
        int r107 = 0;
    L9:
        if (r102 != null) goto L11;
        int r108 = 0;
    L12:
        if (r103 != null) goto L14;
        int r109 = 0;
    L15:
        if (r104 == null) goto L19;
        r105 = r104.hashCode();
    L19:
        return hashCode(r106, r107, r108, r109, r105);
    L14:
        r109 = r103.hashCode();
        goto L15
    L11:
        r108 = r102.hashCode();
        goto L12
    L8:
        r107 = r101.hashCode();
        goto L9
    L5:
        r106 = r100.hashCode();
        goto L6
    }

    public static int hashCode(@Nullable Object r100, @Nullable Object r101, @Nullable Object r102, @Nullable Object r110, @Nullable Object r111, @Nullable Object r112) {
        if (r100 != null) goto L5;
        int r103 = 0;
    L6:
        if (r101 != null) goto L8;
        int r104 = 0;
    L9:
        if (r102 != null) goto L11;
        int r105 = 0;
    L12:
        if (r110 != null) goto L14;
        int r106 = 0;
    L15:
        if (r111 != null) goto L17;
        int r107 = 0;
    L18:
        if (r112 != null) goto L20;
        int r108 = 0;
    L22:
        return hashCode(r103, r104, r105, r106, r107, r108);
    L20:
        r108 = r112.hashCode();
        goto L22
    L17:
        r107 = r111.hashCode();
        goto L18
    L14:
        r106 = r110.hashCode();
        goto L15
    L11:
        r105 = r102.hashCode();
        goto L12
    L8:
        r104 = r101.hashCode();
        goto L9
    L5:
        r103 = r100.hashCode();
        goto L6
    }
}
