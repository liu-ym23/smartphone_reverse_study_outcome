package org.apache.commons.text.translate;

import java.io.IOException;
import java.io.Writer;

/* JADX INFO: loaded from: classes42.dex */
public abstract class CodePointTranslator extends CharSequenceTranslator {
    public abstract boolean translate(int r100, Writer r101) throws IOException;

    public CodePointTranslator() {
    }

    @Override // org.apache.commons.text.translate.CharSequenceTranslator
    public final int translate(CharSequence r100, int r101, Writer r102) throws IOException {
        return translate(Character.codePointAt(r100, r101), r102) ? 1 : 0;
    }
}
