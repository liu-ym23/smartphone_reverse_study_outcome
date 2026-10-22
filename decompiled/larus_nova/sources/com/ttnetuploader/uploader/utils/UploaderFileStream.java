package com.ttnetuploader.uploader.utils;

import android.content.Context;
import com.ttnetuploader.uploader.api.Parameters;
import com.ttnetuploader.uploader.slice_task.ISliceOnProgress;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes41.dex */
public class UploaderFileStream extends InputStream {
    private boolean isReportProgress;
    private long mCurrOffset;
    private long mCurrTimeStamp;
    private final long mEnd;
    private InputStream mInputStream;
    private long mLastReportOffset;
    private Parameters mParam;
    private ISliceOnProgress mSliceOnProgress;
    private final long mStart;

    @Override // java.io.InputStream
    public int read() throws IOException {
        return 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        InputStream r100 = this.mInputStream;
        if (r100 == null) goto L9;
        r100.close();     // Catch: Exception -> L6
        this.mInputStream = null;     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    @Override // java.io.InputStream
    public int read(byte[] r110) throws IOException {
        long r100 = this.mCurrOffset;
        long r101 = this.mEnd;
        if (r100 <= r101) goto L9;
        if (this.isReportProgress == true) goto L7;
        long r102 = (r101 - this.mStart) + 1;
        this.mSliceOnProgress.onProgress(r102, r102, r100, r100 - this.mLastReportOffset);
    L7:
        return -1;
    L9:
        if ((((long) r110.length) + r100) <= r101) goto L11;
        int r111 = this.mInputStream.read(r110, 0, (int) ((r101 - r100) + 1));
    L12:
        if (r111 != (-1)) goto L16;
        return r111;
    L16:
        if (this.mParam.getCallback() == null) goto L20;
        long r103 = System.currentTimeMillis();
        if ((r103 - this.mCurrTimeStamp) < 1000) goto L20;
        this.isReportProgress = true;
        this.mCurrTimeStamp = r103;
        ISliceOnProgress r104 = this.mSliceOnProgress;
        long r112 = this.mCurrOffset;
        long r105 = this.mStart;
        r104.onProgress(r112 - r105, (this.mEnd - r105) + 1, r112, r112 - this.mLastReportOffset);
        this.mLastReportOffset = this.mCurrOffset;
    L20:
        this.mCurrOffset += (long) r111;
        return r111;
    L11:
        r111 = this.mInputStream.read(r110);
        goto L12
    }

    public UploaderFileStream(String r100, long r101, long r102, ISliceOnProgress r110, Parameters r111, Context r112) throws Exception {
        this.mCurrOffset = 0;
        this.mLastReportOffset = 0;
        this.mParam = null;
        this.mSliceOnProgress = null;
        this.isReportProgress = false;
        this.mCurrTimeStamp = System.currentTimeMillis();
        this.mStart = r101;
        this.mSliceOnProgress = r110;
        this.mEnd = r102;
        this.mCurrOffset = r101;
        this.mLastReportOffset = r101;
        this.mParam = r111;
        this.mInputStream = UploadFileUtils.getFileInputStream(r100, r112);
        if (r101 <= 0) goto L12;
    L5:
        if (r101 <= 0) goto L12;
        long r103 = this.mInputStream.skip(r101);
        if (r103 == (-1)) goto L10;
        r101 = r101 - r103;
        goto L5
    L10:
        throw new RuntimeException(r100 + ": unexpected EOF");
    }
}
