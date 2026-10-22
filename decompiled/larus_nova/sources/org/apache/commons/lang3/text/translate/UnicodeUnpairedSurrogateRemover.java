package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;

/* JADX INFO: loaded from: classes42.dex */
public class UnicodeUnpairedSurrogateRemover extends CodePointTranslator {
    @Override // org.apache.commons.lang3.text.translate.CodePointTranslator
    public boolean translate(int r100, Writer r101) throws IOException {
        if (r100 >= 55296) goto L5;
        return false;
    L5:
        if (r100 > 57343) goto L10;
        return true;
    L10:
        return false;
    }

    public UnicodeUnpairedSurrogateRemover() {
    }
}
