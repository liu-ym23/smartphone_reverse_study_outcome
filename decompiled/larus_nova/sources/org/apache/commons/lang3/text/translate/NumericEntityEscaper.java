package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;

/* JADX INFO: loaded from: classes42.dex */
public class NumericEntityEscaper extends CodePointTranslator {
    private final int above;
    private final int below;
    private final boolean between;

    public static NumericEntityEscaper between(int r100, int r101) {
        return new NumericEntityEscaper(r100, r101, true);
    }

    @Override // org.apache.commons.lang3.text.translate.CodePointTranslator
    public boolean translate(int r100, Writer r101) throws IOException {
        if (this.between == false) goto L10;
        if (r100 >= this.below) goto L7;
    L8:
        return false;
    L7:
        if (r100 > this.above) goto L8;
    L14:
        r101.write("&#");
        r101.write(Integer.toString(r100, 10));
        r101.write(59);
        return true;
    L10:
        if (r100 < this.below) goto L14;
        if (r100 > this.above) goto L14;
        return false;
    }

    private NumericEntityEscaper(int r100, int r101, boolean r102) {
        this.below = r100;
        this.above = r101;
        this.between = r102;
    }
}
