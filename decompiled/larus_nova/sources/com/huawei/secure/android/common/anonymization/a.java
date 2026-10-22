package com.huawei.secure.android.common.anonymization;

/* JADX INFO: loaded from: classes23.dex */
public class a {
    public a() {
    }

    public static String[] a(String r100, int... r101) {
        if (r100 != null) goto L6;
        return new String[]{""};
    L6:
        if (r100.length() <= 1) goto L20;
        if (r101.length <= 0) goto L20;
        if (r101.length <= 1) goto L13;
        int r102 = r101[0];
        int r103 = r101.length - 1;
        int[] r104 = new int[r103];
        int r105 = 0;
    L15:
        if (r105 >= r103) goto L17;
        int r106 = r105 + 1;
        r104[r105] = r101[r106] - r102;
        r105 = r106;
        goto L15
    L17:
        String[] r107 = a(r100, r102);
        return b(a(r107, 0), a(a(r107, 1), r104));
    L13:
        return a(r100, r101[0]);
    L20:
        return new String[]{r100};
    }

    public static String[] b(String r100, char r101) {
        if (r100 != null) goto L7;
        return new String[0];
    L7:
        if (r100.length() <= 0) goto L9;
        int r102 = 0;
        int r103 = 1;
    L12:
        if (r102 >= r100.length()) goto L17;
        if (r100.charAt(r102) != r101) goto L16;
        r103 = r103 + 1;
    L16:
        r102 = r102 + 1;
        goto L12
    L17:
        if (r103 <= 1) goto L19;
        String[] r104 = new String[r103];
        StringBuilder r105 = new StringBuilder(r100.length());
        int r106 = 0;
        int r107 = 0;
    L22:
        if (r106 >= r100.length()) goto L29;
        if (r107 >= r103) goto L29;
        char r108 = r100.charAt(r106);
        if (r108 != r101) goto L27;
        r104[r107] = r105.toString();
        r105.setLength(0);
        r107 = r107 + 1;
    L28:
        r106 = r106 + 1;
        goto L22
    L27:
        r105.append(r108);
    L29:
        r104[r107] = r105.toString();
        return r104;
    L19:
        return new String[]{r100};
    L9:
        return new String[]{r100};
    }

    public static String[] a(String r100, int r101) {
        if (r100 != null) goto L7;
        return new String[]{"", ""};
    L7:
        if (r101 < 0) goto L14;
        if (r101 > r100.length()) goto L14;
        return new String[]{r100.substring(0, r101), r100.substring(r101)};
    L14:
        return new String[]{r100, ""};
    }

    public static String[] b(String r100, String[] r101) {
        return a(new String[]{r100}, r101);
    }

    public static String a(String r100, String... r101) {
        if (r101 != null) goto L4;
        return "";
    L4:
        if (r101.length <= 0) goto L20;
        StringBuilder r102 = new StringBuilder(r101[0]);
        int r103 = 1;
    L8:
        if (r103 >= r101.length) goto L14;
        if (r101[r103] == null) goto L12;
        r102.append(r100);
        r102.append(r101[r103]);
    L12:
        r103 = r103 + 1;
        goto L8
    L14:
        return r102.toString();
    L20:
        return "";
    }

    public static String a(String r100, char r101) {
        if (r100 != null) goto L4;
        return "";
    L4:
        if (r100.length() <= 0) goto L14;
        int r102 = r100.length();
        char[] r103 = new char[r102];
        int r104 = 0;
    L7:
        if (r104 >= r102) goto L10;
        r103[r104] = r101;
        r104 = r104 + 1;
        goto L7
    L10:
        return new String(r103);
    L14:
        return "";
    }

    public static String[] a(String[] r100, String[] r101) {
        if (r100.length > 0) goto L10;
        if (r101.length <= 0) goto L7;
        return r101;
    L7:
        return new String[0];
    L10:
        if (r101.length > 0) goto L12;
        return r100;
    L12:
        String[] r102 = new String[r100.length + r101.length];
        System.arraycopy(r100, 0, r102, 0, r100.length);
        System.arraycopy(r101, 0, r102, r100.length, r101.length);
        return r102;
    }

    public static String a(String[] r100, int r101) {
        if (r100 != null) goto L5;
    L13:
        return "";
    L5:
        if (r100.length <= 0) goto L13;
        if (r101 < 0) goto L13;
        if (r101 >= r100.length) goto L13;
        return r100[r101];
    }

    public static String[] a(String[] r100, String r101) {
        return a(r100, new String[]{r101});
    }

    public static String a(String r100, String r101, String r102) {
        if (r100 != null) goto L4;
    L24:
        return r100;
    L4:
        if (r100.length() <= 0) goto L24;
        if (r101.length() <= 0) goto L24;
        if (r102.length() <= 0) goto L24;
        char[] r103 = r100.toCharArray();
        char[] r104 = new char[r100.length()];
        char r105 = r102.charAt(r102.length() - 1);
        int r106 = 0;
    L12:
        if (r106 >= r103.length) goto L23;
        char r107 = r103[r106];
        int r108 = r101.lastIndexOf(r107);
        if (r108 >= 0) goto L17;
        r104[r106] = r107;
    L21:
        r106 = r106 + 1;
        goto L12
    L17:
        if (r108 < r102.length()) goto L19;
        char r109 = r105;
    L20:
        r104[r106] = r109;
        goto L21
    L19:
        r109 = r102.charAt(r108);
        goto L20
    L23:
        return new String(r104);
    }

    public static String[] a(String r100, int r101, int r102) {
        String[] r103 = a(r100, r101);
        return b(a(r103, 0), a(a(r103, 1), r102 - r101));
    }

    public static int a(String r100, char r101, int r102) {
        int r103 = r100.length() - 1;
    L3:
        if (r103 < 0) goto L10;
        if (r100.charAt(r103) != r101) goto L9;
        r102 = r102 - 1;
        if (r102 <= 0) goto L10;
    L9:
        r103 = r103 - 1;
    L10:
        return r103;
    }

    public static String[] a(String r100, int r101, int r102, int r103) {
        String[] r104 = a(r100, r101);
        return b(a(r104, 0), a(a(r104, 1), r102 - r101, r103 - r101));
    }
}
