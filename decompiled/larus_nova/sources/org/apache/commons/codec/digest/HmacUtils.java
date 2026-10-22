package org.apache.commons.codec.digest;

import java.security.InvalidKeyException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes5.dex */
public final class HmacUtils {

    /* JADX INFO: renamed from: mac, reason: collision with root package name */
    private final Mac f525006mac;

    private HmacUtils(Mac r100) {
        this.f525006mac = r100;
    }

    public byte[] hmac(byte[] r100) {
        return this.f525006mac.doFinal(r100);
    }

    public HmacUtils(String r100, byte[] r101) {
        this(getInitializedMac(r100, r101));
    }

    public static Mac getInitializedMac(String r100, byte[] r101) {
        if (r101 == null) goto L11;
        SecretKeySpec r102 = new SecretKeySpec(r101, r100);     // Catch: InvalidKeyException -> L5 Throwable -> L7
        Mac r103 = Mac.getInstance(r100);     // Catch: InvalidKeyException -> L5 Throwable -> L7
        r103.init(r102);     // Catch: InvalidKeyException -> L5 Throwable -> L7
        return r103;
    L7:
        e = move-exception;
        throw new IllegalArgumentException(e);
    L11:
        throw new IllegalArgumentException("Null key");
    }

    public HmacUtils(HmacAlgorithms r100, byte[] r101) {
        this(r100.getName(), r101);
    }
}
