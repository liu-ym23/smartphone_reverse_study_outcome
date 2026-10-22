package com.bytedance.crypto.envelope;

import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes15.dex */
public class EnvelopeCrypto {
    private static final String TAG = "EnvelopeCrypto";
    private static volatile EnvelopeCrypto instance;

    private EnvelopeCrypto() {
    }

    public static EnvelopeCrypto getInstance() {
        if (instance != null) goto L15;
        monitor-enter(EnvelopeCrypto.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new EnvelopeCrypto();     // Catch: Throwable -> L11
    L9:
        monitor-exit(EnvelopeCrypto.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    public int decrypt(byte[] r100, InputStream r101, OutputStream r102) {
        return EnvelopeCryptoImpl.getInstance().decrypt(r100, r101, r102);
    }

    public int encrypt(byte[] r100, byte[] r101, long r110, InputStream r111, OutputStream r112) {
        return EnvelopeCryptoImpl.getInstance().encrypt(r100, r101, r110, r111, r112);
    }

    public byte[] extractDEKCipher(InputStream r100) {
        return EnvelopeCryptoImpl.getInstance().extractDEKCipher(r100);
    }
}
