package com.google.gson.internal;

/* JADX INFO: loaded from: classes6.dex */
public final class JavaVersion {
    private static final int majorJavaVersion = 0;

    private JavaVersion() {
    }

    private static int determineMajorJavaVersion() {
        return getMajorJavaVersion(System.getProperty("java.version"));
    }

    public static boolean isJava9OrLater() {
        if (majorJavaVersion < 9) goto L5;
        return true;
    L5:
        return false;
    }

    static {
        majorJavaVersion = determineMajorJavaVersion();
    }

    public static int getMajorJavaVersion() {
        return majorJavaVersion;
    }

    private static int extractBeginningInt(String r100) {
        StringBuilder r101 = new StringBuilder();     // Catch: NumberFormatException -> L10
        int r102 = 0;
    L4:
        if (r102 >= r100.length()) goto L8;
        char r103 = r100.charAt(r102);     // Catch: NumberFormatException -> L10
        if (Character.isDigit(r103) == false) goto L8;
        r101.append(r103);     // Catch: NumberFormatException -> L10
        r102 = r102 + 1;     // Catch: NumberFormatException -> L10
    L8:
        return Integer.parseInt(r101.toString());
    L10:
        return -1;
    }

    public static int getMajorJavaVersion(String r100) {
        int r101 = parseDotted(r100);
        if (r101 != (-1)) goto L5;
        r101 = extractBeginningInt(r100);
    L5:
        if (r101 != (-1)) goto L8;
        return 6;
    L8:
        return r101;
    }

    private static int parseDotted(String r100) {
        String[] r101 = r100.split("[._]");     // Catch: NumberFormatException -> L9
        int r102 = Integer.parseInt(r101[0]);     // Catch: NumberFormatException -> L9
        if (r102 == 1) goto L5;
    L8:
        return r102;
    L5:
        if (r101.length <= 1) goto L8;
        return Integer.parseInt(r101[1]);
    L9:
        return -1;
    }
}
