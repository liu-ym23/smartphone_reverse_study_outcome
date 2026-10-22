package com.google.crypto.tink.internal;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes23.dex */
public final class a {
    public static byte[] a(BigInteger r100) {
        if (r100.signum() == (-1)) goto L7;
        return r100.toByteArray();
    L7:
        throw new IllegalArgumentException("n must not be negative");
    }
}
