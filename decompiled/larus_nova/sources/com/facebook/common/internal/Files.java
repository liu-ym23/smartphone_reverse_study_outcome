package com.facebook.common.internal;

import androidx.collection.SieveCacheKt;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes22.dex */
public class Files {
    private Files() {
    }

    public static byte[] toByteArray(File r100) throws IOException {
        PolarisFileInputStreamWrapper r101 = null;
        PolarisFileInputStreamWrapper r102 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L9
        byte[] r103 = readFile(r102, r102.getChannel().size());     // Catch: Throwable -> L7
        r102.close();
        return r103;
    L7:
        th = th;
        r101 = r102;
    L10:
        if (r101 == null) goto L12;
        r101.close();
    L12:
        throw th;
    L9:
        th = th;
        goto L10
    }

    public static byte[] readFile(InputStream r100, long r101) throws IOException {
        if (r101 > SieveCacheKt.NodeLinkMask) goto L10;
        if (r101 != 0) goto L8;
        return ByteStreams.toByteArray(r100);
    L8:
        return ByteStreams.toByteArray(r100, (int) r101);
    L10:
        throw new OutOfMemoryError("file is too large to fit in a byte array: " + r101 + " bytes");
    }
}
