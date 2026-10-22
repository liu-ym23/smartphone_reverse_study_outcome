package org.bouncycastle.pqc.crypto.qtesla;

import org.bouncycastle.crypto.digests.CSHAKEDigest;
import org.bouncycastle.crypto.digests.SHAKEDigest;

/* JADX INFO: loaded from: classes42.dex */
class HashUtils {
    static final int SECURE_HASH_ALGORITHM_KECCAK_128_RATE = 168;
    static final int SECURE_HASH_ALGORITHM_KECCAK_256_RATE = 136;

    public HashUtils() {
    }

    public static void customizableSecureHashAlgorithmKECCAK128Simple(byte[] r100, int r101, int r102, short r103, byte[] r104, int r105, int r110) {
        CSHAKEDigest r106 = new CSHAKEDigest(128, null, new byte[]{(byte) r103, (byte) (r103 >> 8)});
        r106.update(r104, r105, r110);
        r106.doFinal(r100, r101, r102);
    }

    public static void customizableSecureHashAlgorithmKECCAK256Simple(byte[] r100, int r101, int r102, short r103, byte[] r104, int r105, int r110) {
        CSHAKEDigest r106 = new CSHAKEDigest(256, null, new byte[]{(byte) r103, (byte) (r103 >> 8)});
        r106.update(r104, r105, r110);
        r106.doFinal(r100, r101, r102);
    }

    public static void secureHashAlgorithmKECCAK128(byte[] r100, int r101, int r102, byte[] r103, int r104, int r105) {
        SHAKEDigest r106 = new SHAKEDigest(128);
        r106.update(r103, r104, r105);
        r106.doFinal(r100, r101, r102);
    }

    public static void secureHashAlgorithmKECCAK256(byte[] r100, int r101, int r102, byte[] r103, int r104, int r105) {
        SHAKEDigest r106 = new SHAKEDigest(256);
        r106.update(r103, r104, r105);
        r106.doFinal(r100, r101, r102);
    }
}
