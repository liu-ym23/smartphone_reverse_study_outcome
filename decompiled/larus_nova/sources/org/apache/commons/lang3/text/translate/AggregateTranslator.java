package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;
import org.apache.commons.lang3.ArrayUtils;

/* JADX INFO: loaded from: classes42.dex */
public class AggregateTranslator extends CharSequenceTranslator {
    private final CharSequenceTranslator[] translators;

    public AggregateTranslator(CharSequenceTranslator... r100) {
        this.translators = (CharSequenceTranslator[]) ArrayUtils.clone(r100);
    }

    @Override // org.apache.commons.lang3.text.translate.CharSequenceTranslator
    public int translate(CharSequence r100, int r101, Writer r102) throws IOException {
        CharSequenceTranslator[] r103 = this.translators;
        int r104 = r103.length;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L8;
        int r106 = r103[r105].translate(r100, r101, r102);
        if (r106 != 0) goto L6;
        r105 = r105 + 1;
        goto L3
    L6:
        return r106;
    L8:
        return 0;
    }
}
