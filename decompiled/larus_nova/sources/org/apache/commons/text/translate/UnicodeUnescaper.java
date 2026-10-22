package org.apache.commons.text.translate;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.io.IOException;
import java.io.Writer;

/* JADX INFO: loaded from: classes42.dex */
public class UnicodeUnescaper extends CharSequenceTranslator {
    public UnicodeUnescaper() {
    }

    @Override // org.apache.commons.text.translate.CharSequenceTranslator
    public int translate(CharSequence r100, int r101, Writer r102) throws IOException {
        if (r100.charAt(r101) != '\\') goto L30;
        int r103 = r101 + 1;
        if (r103 < r100.length()) goto L7;
        return 0;
    L7:
        if (r100.charAt(r103) != 'u') goto L37;
        int r104 = 2;
    L9:
        int r105 = r101 + r104;
        if (r105 >= r100.length()) goto L15;
        if (r100.charAt(r105) != 'u') goto L15;
        r104 = r104 + 1;
    L15:
        if (r105 < r100.length()) goto L17;
    L19:
        int r106 = r101 + r104;
        int r107 = r106 + 4;
        if (r107 > r100.length()) goto L29;
        CharSequence r108 = r100.subSequence(r106, r107);
        r102.write((char) CastIntegerProtector.parseInt(r108.toString(), 16));     // Catch: NumberFormatException -> L25
        return r104 + 4;
    L25:
        e = move-exception;
        throw new IllegalArgumentException("Unable to parse unicode value: " + r108, e);
    L29:
        throw new IllegalArgumentException("Less than 4 hex digits in unicode value: '" + r100.subSequence(r101, r100.length()) + "' due to end of CharSequence");
    L17:
        if (r100.charAt(r105) != '+') goto L19;
        r104 = r104 + 1;
        goto L19
    L37:
        return 0;
    L30:
        return 0;
    }
}
