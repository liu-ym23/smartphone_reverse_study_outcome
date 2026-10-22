package org.apache.commons.text.translate;

import java.io.IOException;
import java.io.Writer;
import org.apache.commons.lang3.Range;

/* JADX INFO: loaded from: classes42.dex */
public class NumericEntityEscaper extends CodePointTranslator {
    private final boolean between;
    private final Range<Integer> range;

    public static NumericEntityEscaper between(int r100, int r101) {
        return new NumericEntityEscaper(r100, r101, true);
    }

    @Override // org.apache.commons.text.translate.CodePointTranslator
    public boolean translate(int r100, Writer r101) throws IOException {
        if (this.between == this.range.contains(Integer.valueOf(r100))) goto L6;
        return false;
    L6:
        r101.write("&#");
        r101.write(Integer.toString(r100, 10));
        r101.write(59);
        return true;
    }

    private NumericEntityEscaper(int r100, int r101, boolean r102) {
        this.range = Range.between(Integer.valueOf(r100), Integer.valueOf(r101));
        this.between = r102;
    }
}
