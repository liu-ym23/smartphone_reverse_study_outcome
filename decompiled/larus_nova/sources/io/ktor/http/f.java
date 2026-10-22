package io.ktor.http;

/* JADX INFO: loaded from: classes41.dex */
public final class f {
    public static final boolean a(char r100) {
        if (r100 != '\t') goto L5;
        return true;
    L5:
        if (' ' <= r100) goto L7;
    L9:
        boolean r101 = false;
    L10:
        if (r101 == false) goto L12;
        return true;
    L12:
        if (';' <= r100) goto L14;
    L16:
        boolean r102 = false;
    L17:
        if (r102 == false) goto L19;
        return true;
    L19:
        if ('[' <= r100) goto L21;
    L23:
        boolean r103 = false;
    L24:
        if (r103 == false) goto L26;
        return true;
    L26:
        if ('{' <= r100) goto L28;
    L30:
        boolean r104 = false;
    L31:
        if (r104 == true) goto L39;
        return false;
    L39:
        return true;
    L28:
        if (r100 >= 127) goto L30;
        r104 = true;
        goto L31
    L21:
        if (r100 >= 'a') goto L23;
        r103 = true;
        goto L24
    L14:
        if (r100 >= 'A') goto L16;
        r102 = true;
        goto L17
    L7:
        if (r100 >= '0') goto L9;
        r101 = true;
        goto L10
    }

    public static final boolean b(char r100) {
        if ('0' <= r100) goto L5;
        return false;
    L5:
        if (r100 >= ':') goto L9;
        return true;
    L9:
        return false;
    }

    public static final boolean c(char r100) {
        if (r100 >= 0) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L10;
        return true;
    L10:
        if ('\n' <= r100) goto L12;
    L14:
        boolean r102 = false;
    L15:
        if (r102 == false) goto L17;
        return true;
    L17:
        if ('0' > r100) goto L20;
        if (r100 >= ':') goto L20;
        boolean r103 = true;
    L21:
        if (r103 == true) goto L49;
        if (r100 != ':') goto L24;
        return true;
    L24:
        if ('a' <= r100) goto L26;
    L28:
        boolean r104 = false;
    L29:
        if (r104 == false) goto L31;
        return true;
    L31:
        if ('A' <= r100) goto L33;
    L35:
        boolean r105 = false;
    L36:
        if (r105 == false) goto L38;
        return true;
    L38:
        if (127 <= r100) goto L40;
    L42:
        boolean r106 = false;
    L43:
        if (r106 == true) goto L53;
        return false;
    L53:
        return true;
    L40:
        if (r100 >= 256) goto L42;
        r106 = true;
        goto L43
    L33:
        if (r100 >= '[') goto L35;
        r105 = true;
        goto L36
    L26:
        if (r100 >= '{') goto L28;
        r104 = true;
        goto L29
    L49:
        return true;
    L20:
        r103 = false;
        goto L21
    L12:
        if (r100 >= ' ') goto L14;
        r102 = true;
        goto L15
    L5:
        if (r100 >= '\t') goto L7;
        r101 = true;
        goto L8
    }

    public static final boolean d(char r100) {
        if (r100 >= 0) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L10;
        return true;
    L10:
        if ('J' <= r100) goto L12;
    L14:
        boolean r102 = false;
    L15:
        if (r102 == true) goto L20;
        return false;
    L20:
        return true;
    L12:
        if (r100 >= 256) goto L14;
        r102 = true;
        goto L15
    L5:
        if (r100 >= '0') goto L7;
        r101 = true;
        goto L8
    }
}
