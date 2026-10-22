package com.facebook.common.memory;

import android.text.TextUtils;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import kotlin.UByte;

/* JADX INFO: loaded from: classes3.dex */
public class PooledByteStreams {
    private static final int DEFAULT_TEMP_BUF_SIZE = 16384;
    private final ByteArrayPool mByteArrayPool;
    private final int mTempBufSize;

    public PooledByteStreams(ByteArrayPool r100) {
        this(r100, 16384);
    }

    public static String bytesToHexString(byte[] r100) {
        StringBuilder r101 = new StringBuilder();
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        int r104 = r100[r103] & UByte.MAX_VALUE;
        if (r104 >= 16) goto L7;
        r101.append(0);
    L7:
        r101.append(Integer.toHexString(r104));
        r103 = r103 + 1;
        goto L3
    L9:
        return r101.toString();
    }

    public PooledByteStreams(ByteArrayPool r100, int r101) {
        if (r101 <= 0) goto L5;
        boolean r102 = true;
    L6:
        Preconditions.checkArgument(r102);
        this.mTempBufSize = r101;
        this.mByteArrayPool = r100;
        return;
    L5:
        r102 = false;
        goto L6
    }

    public long copy(InputStream r100, OutputStream r101) throws IOException {
        byte[] r102 = this.mByteArrayPool.get(this.mTempBufSize);
        long r103 = 0;
    L13:
        int r104 = r100.read(r102, 0, this.mTempBufSize);     // Catch: Throwable -> L10
        if (r104 == (-1)) goto L6;
        r101.write(r102, 0, r104);     // Catch: Throwable -> L10
        r103 = r103 + ((long) r104);
        goto L13
    L6:
        this.mByteArrayPool.release(r102);
        return r103;
    L10:
        th = move-exception;
        this.mByteArrayPool.release(r102);
        throw th;
    }

    public long copy(InputStream r110, OutputStream r111, String r112) throws IOException {
        byte[] r100 = this.mByteArrayPool.get(this.mTempBufSize);
        long r101 = 0;
        String r102 = null;
        MessageDigest r103 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L5
    L30:
        int r104 = r110.read(r100, 0, this.mTempBufSize);     // Catch: Throwable -> L27
        if (r104 == (-1)) goto L8;
        r111.write(r100, 0, r104);     // Catch: Throwable -> L27
        r101 = r101 + ((long) r104);     // Catch: Throwable -> L27
        if (r103 == null) goto L30;
        if (r104 <= 0) goto L30;
        r103.update(r100, 0, r104);     // Catch: Throwable -> L27
        goto L30
    L8:
        if (r103 == null) goto L11;
        r102 = bytesToHexString(r103.digest());     // Catch: Throwable -> L27
    L11:
        if (TextUtils.isEmpty(r102) == false) goto L15;
        FLog.w(getClass(), "the image md5 should not be null, you should check the image is valid or not");     // Catch: Throwable -> L27
    L13:
        this.mByteArrayPool.release(r100);
        return r101;
    L15:
        if (r112 != null) goto L18;
        FLog.w(getClass(), "the target md5 should not be null, you should check the md5 file has been remove or not");     // Catch: Throwable -> L27
        goto L13
    L18:
        if (r112.equals(r102) == true) goto L13;
        this.mByteArrayPool.release(r100);
        return -1;
    L27:
        th = move-exception;
        this.mByteArrayPool.release(r100);
        throw th;
    L5:
        r103 = null;
        goto L30
    }

    public long copy(InputStream r100, OutputStream r110, long r111) throws IOException {
        long r101 = 0;
        if (r111 <= 0) goto L5;
        boolean r102 = true;
    L6:
        Preconditions.checkState(r102);
        byte[] r103 = this.mByteArrayPool.get(this.mTempBufSize);
    L8:
        if (r101 >= r111) goto L12;
        int r104 = r100.read(r103, 0, (int) Math.min(this.mTempBufSize, r111 - r101));     // Catch: Throwable -> L16
        if (r104 == (-1)) goto L12;
        r110.write(r103, 0, r104);     // Catch: Throwable -> L16
        r101 = r101 + ((long) r104);
    L16:
        th = move-exception;
        this.mByteArrayPool.release(r103);
        throw th;
    L12:
        this.mByteArrayPool.release(r103);
        return r101;
    L5:
        r102 = false;
        goto L6
    }
}
