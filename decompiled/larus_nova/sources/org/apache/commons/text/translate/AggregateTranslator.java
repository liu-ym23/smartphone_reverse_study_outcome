package org.apache.commons.text.translate;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes42.dex */
public class AggregateTranslator extends CharSequenceTranslator {
    private final List<CharSequenceTranslator> translators;

    public AggregateTranslator(CharSequenceTranslator... r100) {
        this.translators = new ArrayList();
        if (r100 == null) goto L10;
        int r101 = r100.length;
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L14;
        CharSequenceTranslator r103 = r100[r102];
        if (r103 == null) goto L9;
        this.translators.add(r103);
    L9:
        r102 = r102 + 1;
        goto L5
    L14:
        return;
    }

    @Override // org.apache.commons.text.translate.CharSequenceTranslator
    public int translate(CharSequence r100, int r101, Writer r102) throws IOException {
        Iterator<CharSequenceTranslator> r103 = this.translators.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        int r104 = r103.next().translate(r100, r101, r102);
        if (r104 == 0) goto L4;
        return r104;
    L8:
        return 0;
    }
}
