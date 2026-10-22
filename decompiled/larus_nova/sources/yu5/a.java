package yu5;

/* JADX INFO: loaded from: classes19.dex */
public final class a {
    public static boolean b(char r100) {
        if (r100 == 8205) goto L25;
        if (r100 != 0) goto L6;
    L24:
        return false;
    L6:
        if (r100 == '\t') goto L24;
        if (r100 == '\n') goto L24;
        if (r100 == '\r') goto L24;
        if (r100 < ' ') goto L16;
        if (r100 <= 55295) goto L24;
    L16:
        if (r100 < 57344) goto L20;
        if (r100 <= 65533) goto L24;
    L20:
        if (r100 < 0) goto L25;
        if (r100 <= 65535) goto L24;
    L25:
        return true;
    }

    public static boolean a(char r100) {
        Character.UnicodeBlock r101 = Character.UnicodeBlock.of(r100);
        if (r101 != Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) goto L5;
        return true;
    L5:
        if (r101 != Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) goto L7;
        return true;
    L7:
        if (r101 != Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) goto L9;
        return true;
    L9:
        if (r101 != Character.UnicodeBlock.GENERAL_PUNCTUATION) goto L11;
        return true;
    L11:
        if (r101 != Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) goto L13;
        return true;
    L13:
        if (r101 == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) goto L23;
        return false;
    L23:
        return true;
    }
}
