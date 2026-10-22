package com.bytedance.bdlocation.utils;

import java.util.Random;

/* JADX INFO: loaded from: classes10.dex */
public class RandomStringUtil {
    private static final Random RANDOM = null;

    static {
        RANDOM = new Random();
    }

    private RandomStringUtil() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static String random(int r100) {
        return random(r100, false, false);
    }

    public static String randomAlphabetic(int r100) {
        return random(r100, true, false);
    }

    public static String randomAlphanumeric(int r100) {
        return random(r100, true, true);
    }

    public static String randomAscii(int r100) {
        return random(r100, 32, 127, false, false);
    }

    public static String randomGraph(int r100) {
        return random(r100, 33, 126, false, false);
    }

    public static String randomNumeric(int r100) {
        return random(r100, false, true);
    }

    public static String randomPrint(int r100) {
        return random(r100, 32, 126, false, false);
    }

    public static int nextInt(int r100, int r101) {
        if (r101 < r100) goto L11;
        if (r100 < 0) goto L9;
        if (r100 != r101) goto L7;
        return r100;
    L7:
        return r100 + RANDOM.nextInt(r101 - r100);
    L9:
        throw new IllegalArgumentException("Both range values must be non-negative.");
    L11:
        throw new IllegalArgumentException("Start value must be smaller or equal to end value.");
    }

    public static String random(int r100, char... r101) {
        if (r101 != null) goto L6;
        return random(r100, 0, 0, false, false, null, RANDOM);
    L6:
        return random(r100, 0, r101.length, false, false, r101, RANDOM);
    }

    public static String randomAlphabetic(int r100, int r101) {
        return randomAlphabetic(nextInt(r100, r101));
    }

    public static String randomAlphanumeric(int r100, int r101) {
        return randomAlphanumeric(nextInt(r100, r101));
    }

    public static String randomAscii(int r100, int r101) {
        return randomAscii(nextInt(r100, r101));
    }

    public static String randomGraph(int r100, int r101) {
        return randomGraph(nextInt(r100, r101));
    }

    public static String randomNumeric(int r100, int r101) {
        return randomNumeric(nextInt(r100, r101));
    }

    public static String randomPrint(int r100, int r101) {
        return randomPrint(nextInt(r100, r101));
    }

    public static String random(int r100, String r101) {
        if (r101 != null) goto L6;
        return random(r100, 0, 0, false, false, null, RANDOM);
    L6:
        return random(r100, r101.toCharArray());
    }

    public static String random(int r100, boolean r101, boolean r102) {
        return random(r100, 0, 0, r101, r102);
    }

    public static String random(int r100, int r101, int r102, boolean r110, boolean r111) {
        return random(r100, r101, r102, r110, r111, null, RANDOM);
    }

    public static String random(int r100, int r101, int r102, boolean r110, boolean r111, char... r112) {
        return random(r100, r101, r102, r110, r111, r112, RANDOM);
    }

    public static String random(int r100, int r101, int r102, boolean r103, boolean r104, char[] r105, Random r110) {
        if (r100 != 0) goto L5;
        return "";
    L5:
        if (r100 < 0) goto L68;
        if (r105 == null) goto L13;
        if (r105.length != 0) goto L13;
        throw new IllegalArgumentException("The chars array must not be empty");
    L13:
        if (r101 != 0) goto L21;
        if (r102 != 0) goto L21;
        if (r105 == null) goto L17;
        r102 = r105.length;
    L22:
        if (r105 != null) goto L32;
        if (r104 == true) goto L25;
    L26:
        if (r103 == false) goto L32;
        if (r102 > 65) goto L32;
    L31:
        throw new IllegalArgumentException("Parameter end (" + r102 + ") must be greater then (48) for generating digits or greater then (65) for generating letters.");
    L25:
        if (r102 <= 48) goto L31;
    L32:
        StringBuilder r106 = new StringBuilder(r100);
        int r107 = r102 - r101;
    L33:
        int r108 = r100 - 1;
        if (r100 == 0) goto L64;
        if (r105 != null) goto L44;
        int r109 = r110.nextInt(r107) + r101;
        int r111 = Character.getType(r109);
        if (r111 == 0) goto L43;
        if (r111 == 18) goto L43;
        int r112 = r109;
        if (r111 == 19) goto L43;
    L45:
        int r113 = Character.charCount(r112);
        if (r108 != 0) goto L50;
        if (r113 > 1) goto L43;
    L50:
        if (r103 == true) goto L52;
    L53:
        if (r104 == true) goto L55;
    L56:
        if (r103 == true) goto L62;
        if (r104 == true) goto L62;
    L58:
        r106.appendCodePoint(r112);
        if (r113 != 2) goto L61;
        r108 = r108 - 1;
    L61:
        r100 = r108;
    L62:
        r108 = r108 + 1;
        goto L61
    L55:
        if (Character.isDigit(r112) == true) goto L58;
    L52:
        if (Character.isLetter(r112) == true) goto L58;
    L43:
        r100 = r108 + 1;
        goto L33
    L44:
        r112 = r105[r110.nextInt(r107) + r101];
        goto L45
    L64:
        return r106.toString();
    L17:
        if (r103 == true) goto L20;
        if (r104 == true) goto L20;
        r102 = 1114111;
    L20:
        r102 = 123;
        r101 = 32;
    L21:
        if (r102 > r101) goto L22;
        throw new IllegalArgumentException("Parameter end (" + r102 + ") must be greater than start (" + r101 + ")");
    L68:
        throw new IllegalArgumentException("Requested random string length " + r100 + " is less than 0.");
    }
}
