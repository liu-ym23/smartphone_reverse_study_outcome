package tvc;

/* JADX INFO: loaded from: classes42.dex */
public final class d {
    public static boolean a(CharSequence r100, int r101) {
        if (r101 >= r100.length()) goto L12;
        char r102 = r100.charAt(r101);
        switch(r102) {
            case 33: goto L10;
            case 34: goto L10;
            case 35: goto L10;
            case 36: goto L10;
            case 37: goto L10;
            case 38: goto L10;
            case 39: goto L10;
            case 40: goto L10;
            case 41: goto L10;
            case 42: goto L10;
            case 43: goto L10;
            case 44: goto L10;
            case 45: goto L10;
            case 46: goto L10;
            case 47: goto L10;
            default: goto L6;
        };
    L6:
        switch(r102) {
            case 58: goto L14;
            case 59: goto L14;
            case 60: goto L14;
            case 61: goto L14;
            case 62: goto L14;
            case 63: goto L14;
            case 64: goto L14;
            default: goto L7;
        };
    L7:
        switch(r102) {
            case 91: goto L15;
            case 92: goto L15;
            case 93: goto L15;
            case 94: goto L15;
            case 95: goto L15;
            case 96: goto L15;
            default: goto L8;
        };
    L8:
        switch(r102) {
            case 123: goto L16;
            case 124: goto L16;
            case 125: goto L16;
            case 126: goto L16;
            default: goto L17;
        };
    L16:
        return true;
    L17:
        return false;
    L15:
        return true;
    L14:
        return true;
    L10:
        return true;
    L12:
        return false;
    }

    public static int c(CharSequence r100, int r101, int r102) {
    L2:
        if (r101 >= r102) goto L9;
        char r103 = r100.charAt(r101);
        if (r103 == '\t') goto L8;
        if (r103 == ' ') goto L8;
        return r101;
    L8:
        r101 = r101 + 1;
        goto L2
    L9:
        return r102;
    }

    public static int b(char r100, CharSequence r101, int r102, int r103) {
    L2:
        if (r102 >= r103) goto L7;
        if (r101.charAt(r102) != r100) goto L5;
        r102 = r102 + 1;
        goto L2
    L5:
        return r102;
    L7:
        return r103;
    }
}
