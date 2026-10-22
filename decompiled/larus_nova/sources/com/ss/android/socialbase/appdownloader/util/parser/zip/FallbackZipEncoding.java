package com.ss.android.socialbase.appdownloader.util.parser.zip;

import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes38.dex */
class FallbackZipEncoding implements ZipEncoding {
    private final String charset;

    @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.ZipEncoding
    public boolean canEncode(String r100) {
        return true;
    }

    public FallbackZipEncoding() {
        this.charset = null;
    }

    public FallbackZipEncoding(String r100) {
        this.charset = r100;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.ZipEncoding
    public String decode(byte[] r100) throws IOException {
        String r101 = this.charset;
        if (r101 != null) goto L7;
        return new String(r100);
    L7:
        return new String(r100, r101);
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.ZipEncoding
    public ByteBuffer encode(String r100) throws IOException {
        String r101 = this.charset;
        if (r101 != null) goto L7;
        return ByteBuffer.wrap(r100.getBytes());
    L7:
        return ByteBuffer.wrap(r100.getBytes(r101));
    }
}
