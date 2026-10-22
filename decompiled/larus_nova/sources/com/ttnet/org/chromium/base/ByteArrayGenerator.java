package com.ttnet.org.chromium.base;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import java.io.IOException;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes41.dex */
public class ByteArrayGenerator {
    public ByteArrayGenerator() {
    }

    public byte[] getBytes(int r100) throws IOException, GeneralSecurityException {
        PolarisFileInputStreamWrapper r101 = null;
        PolarisFileInputStreamWrapper r102 = new PolarisFileInputStreamWrapper("/dev/urandom");     // Catch: Throwable -> L12
        byte[] r103 = new byte[r100];     // Catch: Throwable -> L10
        if (r100 != r102.read(r103)) goto L9;
        r102.close();
        return r103;
    L9:
        throw new GeneralSecurityException("Not enough random data available");     // Catch: Throwable -> L10
    L10:
        th = th;
        r101 = r102;
    L13:
        if (r101 == null) goto L15;
        r101.close();
    L15:
        throw th;
    L12:
        th = th;
        goto L13
    }
}
