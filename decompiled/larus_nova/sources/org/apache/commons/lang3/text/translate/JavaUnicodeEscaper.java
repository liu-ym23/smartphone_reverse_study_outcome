package org.apache.commons.lang3.text.translate;

/* JADX INFO: loaded from: classes42.dex */
public class JavaUnicodeEscaper extends UnicodeEscaper {
    @Override // org.apache.commons.lang3.text.translate.UnicodeEscaper
    public String toUtf16Escape(int r100) {
        char[] r101 = Character.toChars(r100);
        return "\\u" + CharSequenceTranslator.hex(r101[0]) + "\\u" + CharSequenceTranslator.hex(r101[1]);
    }

    public static JavaUnicodeEscaper outsideOf(int r100, int r101) {
        return new JavaUnicodeEscaper(r100, r101, false);
    }

    public JavaUnicodeEscaper(int r100, int r101, boolean r102) {
        super(r100, r101, r102);
    }
}
