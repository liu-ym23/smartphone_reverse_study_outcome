package kotlinx.serialization.json.internal;

/* JADX INFO: loaded from: classes5.dex */
public final class b {
    public static final String b(byte r100) {
        if (r100 != 1) goto L6;
        return "quotation mark '\"'";
    L6:
        if (r100 != 2) goto L9;
        return "string escape sequence '\\'";
    L9:
        if (r100 != 4) goto L12;
        return "comma ','";
    L12:
        if (r100 != 5) goto L15;
        return "colon ':'";
    L15:
        if (r100 != 6) goto L18;
        return "start of the object '{'";
    L18:
        if (r100 != 7) goto L21;
        return "end of the object '}'";
    L21:
        if (r100 != 8) goto L24;
        return "start of the array '['";
    L24:
        if (r100 != 9) goto L27;
        return "end of the array ']'";
    L27:
        if (r100 != 10) goto L30;
        return "end of the input";
    L30:
        if (r100 != 127) goto L32;
        return "invalid token";
    L32:
        return "valid token";
    }

    public static final byte a(char r100) {
        if (r100 < '~') goto L7;
        return 0;
    L7:
        return k.f505432b[r100];
    }
}
