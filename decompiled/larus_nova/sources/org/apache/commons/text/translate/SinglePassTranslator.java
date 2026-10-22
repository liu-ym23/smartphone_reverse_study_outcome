package org.apache.commons.text.translate;

import java.io.IOException;
import java.io.Writer;

/* JADX INFO: loaded from: classes42.dex */
abstract class SinglePassTranslator extends CharSequenceTranslator {
    public abstract void translateWhole(CharSequence r100, Writer r101) throws IOException;

    private String getClassName() {
        Class<?> r100 = getClass();
        if (r100.isAnonymousClass() == false) goto L6;
        return r100.getName();
    L6:
        return r100.getSimpleName();
    }

    public SinglePassTranslator() {
    }

    @Override // org.apache.commons.text.translate.CharSequenceTranslator
    public int translate(CharSequence r100, int r101, Writer r102) throws IOException {
        if (r101 != 0) goto L6;
        translateWhole(r100, r102);
        return Character.codePointCount(r100, r101, r100.length());
    L6:
        throw new IllegalArgumentException(getClassName() + ".translate(final CharSequence input, final int index, final Writer out) can not handle a non-zero index.");
    }
}
