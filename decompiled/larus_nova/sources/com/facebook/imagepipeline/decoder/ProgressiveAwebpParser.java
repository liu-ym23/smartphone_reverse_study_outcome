package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.PooledByteArrayBufferedInputStream;
import com.facebook.common.util.StreamUtil;
import com.facebook.imagepipeline.image.EncodedImage;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes23.dex */
public class ProgressiveAwebpParser {
    private static final int BUFFER_SIZE = 16384;
    private static final int NOT_AWEBP = -1;
    private static final int READ_ANIM_I_BYTE = 3;
    private static final int READ_ANIM_M_BYTE = 4;
    private static final int READ_ANMF_F_BYTE = 6;
    private static final int READ_ANMF_M_BYTE = 5;
    private static final int READ_A_BYTE = 1;
    private static final int READ_FIRST_WEBP_BYTE = 0;
    private static final int READ_N_BYTE = 2;
    private int mBestScanEndOffset;
    private int mBestScanNumber;
    private final ByteArrayPool mByteArrayPool;
    private int mBytesParsed;
    private boolean mEndMarkerRead;
    private int mParserState;

    public int getBestScanEndOffset() {
        return this.mBestScanEndOffset;
    }

    public int getBestScanNumber() {
        return this.mBestScanNumber;
    }

    public ProgressiveAwebpParser(ByteArrayPool r100) {
        this.mByteArrayPool = (ByteArrayPool) Preconditions.checkNotNull(r100);
        this.mParserState = 0;
        this.mBestScanNumber = -1;
    }

    private boolean doParseMoreData(InputStream r110) {
        int r100 = this.mBestScanNumber;
    L71:
    L61:
        e = move-exception;
        Throwables.propagate(e);
    L64:
        if (this.mParserState == (-1)) goto L69;
        int r111 = this.mBestScanNumber;
        if (r111 == r100) goto L69;
        if (r111 <= 0) goto L69;
        return true;
    L69:
        return false;
    L5:
        if (this.mParserState == (-1)) goto L64;
        int r101 = r110.read();     // Catch: IOException -> L61
        if (r101 == (-1)) goto L64;
        int r102 = this.mBytesParsed + 1;     // Catch: IOException -> L61
        this.mBytesParsed = r102;     // Catch: IOException -> L61
        if (this.mEndMarkerRead == true) goto L10;
        switch(this.mParserState) {
            case 0: goto L33;
            case 1: goto L29;
            case 2: goto L23;
            case 3: goto L19;
            case 4: goto L33;
            case 5: goto L16;
            case 6: goto L33;
            default: goto L71;
        };     // Catch: IOException -> L61
    L16:
        if (r101 == 70) goto L17;
        this.mParserState = 0;     // Catch: IOException -> L61
        goto L71
    L17:
        this.mParserState = 6;     // Catch: IOException -> L61
        this.mBestScanEndOffset = r102;     // Catch: IOException -> L61
        this.mBestScanNumber++;     // Catch: IOException -> L61
        goto L71
    L19:
        if (r101 == 77) goto L20;
        this.mParserState = 0;     // Catch: IOException -> L61
        goto L71
    L20:
        this.mParserState = 4;     // Catch: IOException -> L61
        goto L71
    L23:
        if (r101 == 73) goto L24;
        if (r101 == 77) goto L26;
        this.mParserState = 0;     // Catch: IOException -> L61
        goto L71
    L26:
        this.mParserState = 5;     // Catch: IOException -> L61
        goto L71
    L24:
        this.mParserState = 3;     // Catch: IOException -> L61
        goto L71
    L29:
        if (r101 == 78) goto L30;
        this.mParserState = 0;     // Catch: IOException -> L61
        goto L71
    L30:
        this.mParserState = 2;     // Catch: IOException -> L61
        goto L71
    L33:
        if (r102 != 13) goto L38;
        if (r101 == 86) goto L38;
        this.mParserState = -1;     // Catch: IOException -> L61
    L38:
        if (r102 != 14) goto L43;
        if (r101 == 80) goto L43;
        this.mParserState = -1;     // Catch: IOException -> L61
    L43:
        if (r102 != 15) goto L48;
        if (r101 == 56) goto L48;
        this.mParserState = -1;     // Catch: IOException -> L61
    L48:
        if (r102 != 16) goto L53;
        if (r101 == 88) goto L53;
        this.mParserState = -1;     // Catch: IOException -> L61
    L53:
        if (r102 != 21) goto L58;
        if ((r101 & 2) == 2) goto L58;
        this.mParserState = -1;     // Catch: IOException -> L61
    L58:
        if (r101 != 65) goto L71;
        this.mParserState = 1;     // Catch: IOException -> L61
        goto L71
    L10:
        this.mParserState = -1;     // Catch: IOException -> L61
        this.mEndMarkerRead = false;     // Catch: IOException -> L61
        return false;
    }

    public boolean parseMoreData(EncodedImage r100) {
        if (this.mParserState != (-1)) goto L6;
        return false;
    L6:
        if (r100.getSize() > this.mBytesParsed) goto L8;
        return false;
    L8:
        PooledByteArrayBufferedInputStream r101 = new PooledByteArrayBufferedInputStream(r100.getInputStream(), this.mByteArrayPool.get(16384), this.mByteArrayPool);
        StreamUtil.skip(r101, this.mBytesParsed);     // Catch: Throwable -> L12 IOException -> L14
        boolean r102 = doParseMoreData(r101);     // Catch: Throwable -> L12 IOException -> L14
        Closeables.closeQuietly(r101);
        return r102;
    L12:
        th = move-exception;
        Closeables.closeQuietly(r101);
        throw th;
    L14:
        e = move-exception;
        Throwables.propagate(e);     // Catch: Throwable -> L12
        Closeables.closeQuietly(r101);
        return false;
    }
}
