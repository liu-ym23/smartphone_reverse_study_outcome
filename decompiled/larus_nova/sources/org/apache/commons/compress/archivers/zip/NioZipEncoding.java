package org.apache.commons.compress.archivers.zip;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;

/* JADX INFO: loaded from: classes42.dex */
class NioZipEncoding implements ZipEncoding {
    private static final char[] HEX_CHARS = null;
    private static final byte[] REPLACEMENT_BYTES = null;
    private static final String REPLACEMENT_STRING = null;
    private final Charset charset;
    private final boolean useReplacement;

    static {
        REPLACEMENT_BYTES = new byte[]{63};
        REPLACEMENT_STRING = String.valueOf('?');
        HEX_CHARS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    private CharsetDecoder newDecoder() {
        if (this.useReplacement == true) goto L7;
        return this.charset.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT);
    L7:
        return this.charset.newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE).replaceWith(REPLACEMENT_STRING);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipEncoding
    public String decode(byte[] r100) throws IOException {
        return newDecoder().decode(ByteBuffer.wrap(r100)).toString();
    }

    public NioZipEncoding(Charset r100, boolean r101) {
        this.charset = r100;
        this.useReplacement = r101;
    }
}
