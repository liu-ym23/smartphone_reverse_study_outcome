package org.apache.commons.text.translate;

import java.io.IOException;
import java.io.Writer;

/* JADX INFO: loaded from: classes42.dex */
public class UnicodeEscaper extends CodePointTranslator {
    private final int above;
    private final int below;
    private final boolean between;

    public String toUtf16Escape(int r100) {
        throw null;
    }

    @Override // org.apache.commons.text.translate.CodePointTranslator
    public boolean translate(int r100, Writer r101) throws IOException {
        if (this.between == false) goto L10;
        if (r100 >= this.below) goto L7;
    L8:
        return false;
    L7:
        if (r100 > this.above) goto L8;
    L15:
        if (r100 <= 65535) goto L17;
        r101.write(toUtf16Escape(r100));
        return true;
    L17:
        r101.write("\\u");
        char[] r102 = CharSequenceTranslator.HEX_DIGITS;
        r101.write(r102[(r100 >> 12) & 15]);
        r101.write(r102[(r100 >> 8) & 15]);
        r101.write(r102[(r100 >> 4) & 15]);
        r101.write(r102[r100 & 15]);
        return true;
    L10:
        if (r100 < this.below) goto L15;
        if (r100 > this.above) goto L15;
        return false;
    }

    public UnicodeEscaper(int r100, int r101, boolean r102) {
        this.below = r100;
        this.above = r101;
        this.between = r102;
    }
}
