package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Locale;

/* JADX INFO: loaded from: classes42.dex */
public abstract class CharSequenceTranslator {
    static final char[] HEX_DIGITS = null;

    public CharSequenceTranslator() {
    }

    public abstract int translate(CharSequence r100, int r101, Writer r102) throws IOException;

    static {
        HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public static String hex(int r100) {
        return Integer.toHexString(r100).toUpperCase(Locale.ENGLISH);
    }

    public final String translate(CharSequence r100) {
        if (r100 != null) goto L10;
        return null;
    L10:
        StringWriter r101 = new StringWriter(r100.length() * 2);     // Catch: IOException -> L7
        translate(r100, r101);     // Catch: IOException -> L7
        return r101.toString();
    L7:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public final CharSequenceTranslator with(CharSequenceTranslator... r100) {
        CharSequenceTranslator[] r101 = new CharSequenceTranslator[r100.length + 1];
        r101[0] = this;
        System.arraycopy(r100, 0, r101, 1, r100.length);
        return new AggregateTranslator(r101);
    }

    public final void translate(CharSequence r100, Writer r101) throws IOException {
        if (r101 == null) goto L20;
        if (r100 != null) goto L5;
        return;
    L5:
        int r102 = r100.length();
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L18;
        int r104 = translate(r100, r103, r101);
        if (r104 == 0) goto L9;
        int r105 = 0;
    L16:
        if (r105 >= r104) goto L6;
        r103 = r103 + Character.charCount(Character.codePointAt(r100, r103));
        r105 = r105 + 1;
        goto L16
    L9:
        char r106 = r100.charAt(r103);
        r101.write(r106);
        r103 = r103 + 1;
        if (Character.isHighSurrogate(r106) == false) goto L6;
        if (r103 >= r102) goto L6;
        char r107 = r100.charAt(r103);
        if (Character.isLowSurrogate(r107) == false) goto L6;
        r101.write(r107);
        r103 = r103 + 1;
        goto L6
    L18:
        return;
    L20:
        throw new IllegalArgumentException("The Writer must not be null");
    }
}
