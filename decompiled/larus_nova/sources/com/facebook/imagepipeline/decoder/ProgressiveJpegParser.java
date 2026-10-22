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
public class ProgressiveJpegParser {
    private static final int BUFFER_SIZE = 16384;
    private static final int NOT_A_JPEG = 6;
    private static final int READ_FIRST_JPEG_BYTE = 0;
    private static final int READ_MARKER_FIRST_BYTE_OR_ENTROPY_DATA = 2;
    private static final int READ_MARKER_SECOND_BYTE = 3;
    private static final int READ_SECOND_JPEG_BYTE = 1;
    private static final int READ_SIZE_FIRST_BYTE = 4;
    private static final int READ_SIZE_SECOND_BYTE = 5;
    private int mBestScanEndOffset;
    private int mBestScanNumber;
    private final ByteArrayPool mByteArrayPool;
    private int mBytesParsed;
    private boolean mEndMarkerRead;
    private int mLastByteRead;
    private int mNextFullScanNumber;
    private int mParserState;

    private static boolean doesMarkerStartSegment(int r100) {
        if (r100 != 1) goto L6;
        return false;
    L6:
        if (r100 < 208) goto L11;
        if (r100 > 215) goto L11;
        return false;
    L11:
        if (r100 != 217) goto L13;
        return false;
    L13:
        if (r100 == 216) goto L17;
        return true;
    L17:
        return false;
    }

    public boolean isJpeg() {
        if (this.mBytesParsed > 1) goto L5;
    L7:
        return false;
    L5:
        if (this.mParserState == 6) goto L7;
        return true;
    }

    public int getBestScanEndOffset() {
        return this.mBestScanEndOffset;
    }

    public int getBestScanNumber() {
        return this.mBestScanNumber;
    }

    public boolean isEndMarkerRead() {
        return this.mEndMarkerRead;
    }

    public ProgressiveJpegParser(ByteArrayPool r100) {
        this.mByteArrayPool = (ByteArrayPool) Preconditions.checkNotNull(r100);
        this.mBytesParsed = 0;
        this.mLastByteRead = 0;
        this.mNextFullScanNumber = 0;
        this.mBestScanEndOffset = 0;
        this.mBestScanNumber = 0;
        this.mParserState = 0;
    }

    private boolean doParseMoreData(InputStream r110) {
        int r100 = this.mBestScanNumber;
    L59:
    L51:
        e = move-exception;
        Throwables.propagate(e);
    L54:
        if (this.mParserState != 6) goto L56;
        return false;
    L56:
        if (this.mBestScanNumber == r100) goto L79;
        return true;
    L79:
        return false;
    L5:
        if (this.mParserState == 6) goto L54;
        int r101 = r110.read();     // Catch: IOException -> L51
        if (r101 == (-1)) goto L54;
        int r102 = this.mBytesParsed + 1;     // Catch: IOException -> L51
        this.mBytesParsed = r102;     // Catch: IOException -> L51
        if (this.mEndMarkerRead == true) goto L10;
        int r103 = this.mParserState;     // Catch: IOException -> L51
        if (r103 != 0) goto L15;
        if (r101 != 255) goto L48;
        this.mParserState = 1;     // Catch: IOException -> L51
    L49:
        this.mLastByteRead = r101;     // Catch: IOException -> L51
        goto L59
    L48:
        this.mParserState = 6;     // Catch: IOException -> L51
        goto L49
    L15:
        if (r103 == 1) goto L43;
        if (r103 != 2) goto L19;
        if (r101 != 255) goto L49;
        this.mParserState = 3;     // Catch: IOException -> L51
        goto L49
    L19:
        if (r103 != 3) goto L21;
        if (r101 != 255) goto L28;
        this.mParserState = 3;     // Catch: IOException -> L51
        goto L49
    L28:
        if (r101 != 0) goto L31;
        this.mParserState = 2;     // Catch: IOException -> L51
        goto L49
    L31:
        if (r101 != 217) goto L34;
        this.mEndMarkerRead = true;     // Catch: IOException -> L51
        newScanOrImageEndFound(r102 - 2);     // Catch: IOException -> L51
        this.mParserState = 2;     // Catch: IOException -> L51
        goto L49
    L34:
        if (r101 != 218) goto L37;
        newScanOrImageEndFound(r102 - 2);     // Catch: IOException -> L51
    L37:
        if (doesMarkerStartSegment(r101) == false) goto L39;
        this.mParserState = 4;     // Catch: IOException -> L51
        goto L49
    L39:
        this.mParserState = 2;     // Catch: IOException -> L51
        goto L49
    L21:
        if (r103 == 4) goto L25;
        if (r103 == 5) goto L24;
        Preconditions.checkState(false);     // Catch: IOException -> L51
        goto L49
    L24:
        int r104 = ((this.mLastByteRead << 8) + r101) - 2;     // Catch: IOException -> L51
        StreamUtil.skip(r110, r104);     // Catch: IOException -> L51
        this.mBytesParsed += r104;     // Catch: IOException -> L51
        this.mParserState = 2;     // Catch: IOException -> L51
        goto L49
    L25:
        this.mParserState = 5;     // Catch: IOException -> L51
        goto L49
    L43:
        if (r101 != 216) goto L45;
        this.mParserState = 2;     // Catch: IOException -> L51
        goto L49
    L45:
        this.mParserState = 6;     // Catch: IOException -> L51
        goto L49
    L10:
        this.mParserState = 6;     // Catch: IOException -> L51
        this.mEndMarkerRead = false;     // Catch: IOException -> L51
        return false;
    }

    private void newScanOrImageEndFound(int r100) {
        int r101 = this.mNextFullScanNumber;
        if (r101 <= 0) goto L5;
        this.mBestScanEndOffset = r100;
    L5:
        this.mNextFullScanNumber = r101 + 1;
        this.mBestScanNumber = r101;
    }

    public boolean parseMoreData(EncodedImage r100) {
        if (this.mParserState != 6) goto L6;
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
