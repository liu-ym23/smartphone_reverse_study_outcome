package org.apache.commons.lang3.text.translate;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.io.IOException;
import java.io.Writer;

/* JADX INFO: loaded from: classes42.dex */
public class OctalUnescaper extends CharSequenceTranslator {
    private boolean isOctalDigit(char r100) {
        if (r100 >= '0') goto L5;
    L7:
        return false;
    L5:
        if (r100 > '7') goto L7;
        return true;
    }

    private boolean isZeroToThree(char r100) {
        if (r100 >= '0') goto L5;
    L7:
        return false;
    L5:
        if (r100 > '3') goto L7;
        return true;
    }

    public OctalUnescaper() {
    }

    @Override // org.apache.commons.lang3.text.translate.CharSequenceTranslator
    public int translate(CharSequence r100, int r101, Writer r102) throws IOException {
        int r103 = (r100.length() - r101) - 1;
        StringBuilder r104 = new StringBuilder();
        if (r100.charAt(r101) != '\\') goto L20;
        if (r103 <= 0) goto L22;
        int r105 = r101 + 1;
        if (isOctalDigit(r100.charAt(r105)) == false) goto L23;
        int r106 = r101 + 2;
        int r107 = r101 + 3;
        r104.append(r100.charAt(r105));
        if (r103 > 1) goto L10;
    L18:
        r102.write(CastIntegerProtector.parseInt(r104.toString(), 8));
        return r104.length() + 1;
    L10:
        if (isOctalDigit(r100.charAt(r106)) == false) goto L18;
        r104.append(r100.charAt(r106));
        if (r103 <= 2) goto L18;
        if (isZeroToThree(r100.charAt(r105)) == false) goto L18;
        if (isOctalDigit(r100.charAt(r107)) == false) goto L18;
        r104.append(r100.charAt(r107));
        goto L18
    L23:
        return 0;
    L22:
        return 0;
    L20:
        return 0;
    }
}
