package com.ss.android.socialbase.appdownloader.util.parser.zip;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

/* JADX INFO: loaded from: classes38.dex */
class NioZipEncoding implements ZipEncoding {
    private final Charset charset;

    public NioZipEncoding(Charset r100) {
        this.charset = r100;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.ZipEncoding
    public boolean canEncode(String r100) {
        CharsetEncoder r101 = this.charset.newEncoder();
        r101.onMalformedInput(CodingErrorAction.REPORT);
        r101.onUnmappableCharacter(CodingErrorAction.REPORT);
        return r101.canEncode(r100);
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.ZipEncoding
    public String decode(byte[] r100) throws IOException {
        return this.charset.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).decode(ByteBuffer.wrap(r100)).toString();
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.ZipEncoding
    public ByteBuffer encode(String r100) {
        CharsetEncoder r101 = this.charset.newEncoder();
        r101.onMalformedInput(CodingErrorAction.REPORT);
        r101.onUnmappableCharacter(CodingErrorAction.REPORT);
        CharBuffer r102 = CharBuffer.wrap(r100);
        ByteBuffer r103 = ByteBuffer.allocate(r100.length() + ((r100.length() + 1) / 2));
    L4:
        if (r102.remaining() <= 0) goto L22;
        CoderResult r104 = r101.encode(r102, r103, true);
        int r105 = 0;
        if (r104.isUnmappable() == true) goto L17;
        if (r104.isMalformed() == true) goto L17;
        if (r104.isOverflow() == true) goto L12;
        if (r104.isUnderflow() == false) goto L4;
        r101.flush(r103);
        goto L22
    L12:
        r103 = ZipEncodingHelper.growBuffer(r103, 0);
    L17:
        if ((r104.length() * 6) <= r103.remaining()) goto L20;
        r103 = ZipEncodingHelper.growBuffer(r103, r103.position() + (r104.length() * 6));
    L20:
        if (r105 >= r104.length()) goto L4;
        ZipEncodingHelper.appendSurrogate(r103, r102.get());
        r105 = r105 + 1;
    L22:
        ZipEncodingHelper.prepareBufferForRead(r103);
        return r103;
    }
}
