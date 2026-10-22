package com.bytedance.applog.compress;

import android.content.Context;
import com.bytedance.applog.log.i;
import com.bytedance.applog.log.n;
import com.bytedance.compression.zstd.ZstdCompress;
import com.bytedance.compression.zstd.ZstdDictCompress;
import java.util.Arrays;
import pw3.a;
import pw3.b;
import pw3.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class CompressManager {
    public static final int TYPE_EMPTY = -1;
    public static final int TYPE_GZIP = 0;
    public static final int TYPE_ZSTD = 1;
    public static final int TYPE_ZSTD_DICT = 2;
    private static byte[] mDictionary = null;
    private static int sZstdLevel = 15;
    private final Context mContext;
    private final i mLogger;

    public static void setReportStatsEnabled(boolean r0) {
    }

    private int getEncodeType(int r2) {
        if (r2 == 2) goto L5;
        return r2;
    L5:
        if (mDictionary != null) goto L9;
        return 1;
    L9:
        return r2;
    }

    public static void setZstdDict(byte[] r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r1.length <= 0) goto L8;
        mDictionary = Arrays.copyOf(r1, r1.length);
        return;
    }

    public static void setZstdLevel(int r0) {
        sZstdLevel = r0;
    }

    public CompressManager(Context r1, i r2) {
        this.mContext = r1;
        if (r2 != null) goto L6;
        r2 = n.w();
    L6:
        this.mLogger = r2;
    }

    public byte[] compressUsingGzip(byte[] r6, a r7) {
        if (r6 != null) goto L5;
        int r1 = 0;
    L6:
        r7.a = r1;
        r7.c = 0;
        long r2 = System.currentTimeMillis();
        byte[] r8 = b.a(r6);
        long r3 = System.currentTimeMillis();
        r7.e = 0;
        r7.d = r3 - r2;
        r7.b = r8.length;
        return r8;
    L5:
        r1 = r6.length;
        goto L6
    }

    public byte[] compress(byte[] r3, int r4, a r5) {
        int r0 = getEncodeType(r4);
        if (r0 != 0) goto L5;
        r3 = compressUsingGzip(r3, r5);
    L11:
        if (r3 == null) goto L15;
        if (r3.length == 0) goto L15;
        return r3;
    L15:
        return compressUsingGzip(r3, r5);
    L5:
        if (r0 != 1) goto L7;
    L9:
        r3 = compressUsingZstd(r3, r5, r4);
        goto L11
    L7:
        if (r0 == 2) goto L9;
        goto L9
    }

    public byte[] compressUsingZstd(byte[] r7, a r8, int r9) {
        r8.a = r7.length;
        r8.c = r9;
        byte[] r1 = null;
        long r2 = System.currentTimeMillis();     // Catch: Throwable -> L11
        if (r9 == 2) goto L6;
    L8:
        byte[] r10 = ZstdCompress.compress(r7, sZstdLevel);     // Catch: Throwable -> L11
    L9:
        r1 = r10;
        r8.d = System.currentTimeMillis() - r2;     // Catch: Throwable -> L11
        r8.b = r1.length;     // Catch: Throwable -> L11
        r8.e = 0;     // Catch: Throwable -> L11
        return r1;
    L6:
        if (mDictionary == null) goto L8;
        r10 = ZstdCompress.compress(r7, new ZstdDictCompress(mDictionary, sZstdLevel));     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        this.mLogger.o(14, "compress with zstd failed", th, new Object[0]);
        r8.e = 1;
        return r1;
    }

    public CompressManager(Context r1, String r2, c r3, i r4) {
        this(r1, r4);
    }
}
