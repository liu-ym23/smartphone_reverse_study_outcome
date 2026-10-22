package org.bouncycastle.crypto.prng;

import java.security.SecureRandom;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.engines.DESedeEngine;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.prng.drbg.CTRSP800DRBG;
import org.bouncycastle.crypto.prng.drbg.HMacSP800DRBG;
import org.bouncycastle.crypto.prng.drbg.HashSP800DRBG;
import org.bouncycastle.crypto.prng.drbg.SP80090DRBG;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class SP800SecureRandomBuilder {
    private int entropyBitsRequired;
    private final EntropySourceProvider entropySourceProvider;
    private byte[] personalizationString;
    private final SecureRandom random;
    private int securityStrength;

    public static class CTRDRBGProvider implements DRBGProvider {
        private final BlockCipher blockCipher;
        private final int keySizeInBits;
        private final byte[] nonce;
        private final byte[] personalizationString;
        private final int securityStrength;

        public CTRDRBGProvider(BlockCipher r100, int r101, byte[] r102, byte[] r103, int r104) {
            this.blockCipher = r100;
            this.keySizeInBits = r101;
            this.nonce = r102;
            this.personalizationString = r103;
            this.securityStrength = r104;
        }

        @Override // org.bouncycastle.crypto.prng.DRBGProvider
        public SP80090DRBG get(EntropySource r100) {
            return new CTRSP800DRBG(this.blockCipher, this.keySizeInBits, this.securityStrength, r100, this.personalizationString, this.nonce);
        }

        @Override // org.bouncycastle.crypto.prng.DRBGProvider
        public String getAlgorithm() {
            if ((this.blockCipher instanceof DESedeEngine) == false) goto L7;
            return "CTR-DRBG-3KEY-TDES";
        L7:
            return "CTR-DRBG-" + this.blockCipher.getAlgorithmName() + this.keySizeInBits;
        }
    }

    public static class HMacDRBGProvider implements DRBGProvider {
        private final Mac hMac;
        private final byte[] nonce;
        private final byte[] personalizationString;
        private final int securityStrength;

        public HMacDRBGProvider(Mac r100, byte[] r101, byte[] r102, int r103) {
            this.hMac = r100;
            this.nonce = r101;
            this.personalizationString = r102;
            this.securityStrength = r103;
        }

        @Override // org.bouncycastle.crypto.prng.DRBGProvider
        public SP80090DRBG get(EntropySource r100) {
            return new HMacSP800DRBG(this.hMac, this.securityStrength, r100, this.personalizationString, this.nonce);
        }

        @Override // org.bouncycastle.crypto.prng.DRBGProvider
        public String getAlgorithm() {
            if ((this.hMac instanceof HMac) == false) goto L7;
            StringBuilder r100 = new StringBuilder("HMAC-DRBG-");
            String r101 = SP800SecureRandomBuilder.access$000(((HMac) this.hMac).getUnderlyingDigest());
        L5:
            r100.append(r101);
            return r100.toString();
        L7:
            r100 = new StringBuilder("HMAC-DRBG-");
            r101 = this.hMac.getAlgorithmName();
            goto L5
        }
    }

    public static class HashDRBGProvider implements DRBGProvider {
        private final Digest digest;
        private final byte[] nonce;
        private final byte[] personalizationString;
        private final int securityStrength;

        public HashDRBGProvider(Digest r100, byte[] r101, byte[] r102, int r103) {
            this.digest = r100;
            this.nonce = r101;
            this.personalizationString = r102;
            this.securityStrength = r103;
        }

        @Override // org.bouncycastle.crypto.prng.DRBGProvider
        public SP80090DRBG get(EntropySource r100) {
            return new HashSP800DRBG(this.digest, this.securityStrength, r100, this.personalizationString, this.nonce);
        }

        @Override // org.bouncycastle.crypto.prng.DRBGProvider
        public String getAlgorithm() {
            return "HASH-DRBG-" + SP800SecureRandomBuilder.access$000(this.digest);
        }
    }

    public SP800SecureRandomBuilder() {
        this(CryptoServicesRegistrar.getSecureRandom(), false);
    }

    public SP800SecureRandomBuilder(SecureRandom r100, boolean r101) {
        this.securityStrength = 256;
        this.entropyBitsRequired = 256;
        this.random = r100;
        this.entropySourceProvider = new BasicEntropySourceProvider(r100, r101);
    }

    public SP800SecureRandomBuilder(EntropySourceProvider r100) {
        this.securityStrength = 256;
        this.entropyBitsRequired = 256;
        this.random = null;
        this.entropySourceProvider = r100;
    }

    public static /* synthetic */ String access$000(Digest r100) {
        return getSimplifiedName(r100);
    }

    private static String getSimplifiedName(Digest r100) {
        String r101 = r100.getAlgorithmName();
        int r102 = r101.indexOf(45);
        if (r102 > 0) goto L5;
        return r101;
    L5:
        if (r101.startsWith("SHA3") == false) goto L7;
        return r101;
    L7:
        return r101.substring(0, r102) + r101.substring(r102 + 1);
    }

    public SP800SecureRandom buildCTR(BlockCipher r110, int r111, byte[] r112, boolean r113) {
        return new SP800SecureRandom(this.random, this.entropySourceProvider.get(this.entropyBitsRequired), new CTRDRBGProvider(r110, r111, r112, this.personalizationString, this.securityStrength), r113);
    }

    public SP800SecureRandom buildHMAC(Mac r100, byte[] r101, boolean r102) {
        return new SP800SecureRandom(this.random, this.entropySourceProvider.get(this.entropyBitsRequired), new HMacDRBGProvider(r100, r101, this.personalizationString, this.securityStrength), r102);
    }

    public SP800SecureRandom buildHash(Digest r100, byte[] r101, boolean r102) {
        return new SP800SecureRandom(this.random, this.entropySourceProvider.get(this.entropyBitsRequired), new HashDRBGProvider(r100, r101, this.personalizationString, this.securityStrength), r102);
    }

    public SP800SecureRandomBuilder setEntropyBitsRequired(int r100) {
        this.entropyBitsRequired = r100;
        return this;
    }

    public SP800SecureRandomBuilder setPersonalizationString(byte[] r100) {
        this.personalizationString = Arrays.clone(r100);
        return this;
    }

    public SP800SecureRandomBuilder setSecurityStrength(int r100) {
        this.securityStrength = r100;
        return this;
    }
}
