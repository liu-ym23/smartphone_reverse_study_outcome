package org.bouncycastle.pqc.crypto.newhope;

import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.crypto.Xof;
import org.bouncycastle.crypto.digests.SHAKEDigest;
import org.bouncycastle.pqc.crypto.ExchangePair;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class NHSecretKeyProcessor {
    private final Xof xof;

    /* JADX INFO: renamed from: org.bouncycastle.pqc.crypto.newhope.NHSecretKeyProcessor$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class PartyUBuilder {
        private final AsymmetricCipherKeyPair aKp;
        private final NHAgreement agreement;
        private byte[] sharedInfo;
        private boolean used;

        public PartyUBuilder(SecureRandom r100) {
            NHAgreement r101 = new NHAgreement();
            this.agreement = r101;
            this.sharedInfo = null;
            this.used = false;
            NHKeyPairGenerator r102 = new NHKeyPairGenerator();
            r102.init(new KeyGenerationParameters(r100, 2048));
            AsymmetricCipherKeyPair r103 = r102.generateKeyPair();
            this.aKp = r103;
            r101.init(r103.getPrivate());
        }

        public NHSecretKeyProcessor build(byte[] r100) {
            if (this.used == true) goto L7;
            this.used = true;
            return new NHSecretKeyProcessor(this.agreement.calculateAgreement(new NHPublicKeyParameters(r100)), this.sharedInfo, null);
        L7:
            throw new IllegalStateException("builder already used");
        }

        public byte[] getPartA() {
            return ((NHPublicKeyParameters) this.aKp.getPublic()).getPubData();
        }

        public PartyUBuilder withSharedInfo(byte[] r100) {
            this.sharedInfo = Arrays.clone(r100);
            return this;
        }
    }

    public static class PartyVBuilder {
        protected final SecureRandom random;
        private byte[] sharedInfo;
        private byte[] sharedSecret;
        private boolean used;

        public PartyVBuilder(SecureRandom r100) {
            this.sharedInfo = null;
            this.sharedSecret = null;
            this.used = false;
            this.random = r100;
        }

        public NHSecretKeyProcessor build() {
            if (this.used == true) goto L7;
            this.used = true;
            return new NHSecretKeyProcessor(this.sharedSecret, this.sharedInfo, null);
        L7:
            throw new IllegalStateException("builder already used");
        }

        public byte[] getPartB(byte[] r100) {
            ExchangePair r101 = new NHExchangePairGenerator(this.random).generateExchange(new NHPublicKeyParameters(r100));
            this.sharedSecret = r101.getSharedValue();
            return ((NHPublicKeyParameters) r101.getPublicKey()).getPubData();
        }

        public PartyVBuilder withSharedInfo(byte[] r100) {
            this.sharedInfo = Arrays.clone(r100);
            return this;
        }
    }

    private NHSecretKeyProcessor(byte[] r100, byte[] r101) {
        SHAKEDigest r102 = new SHAKEDigest(256);
        this.xof = r102;
        r102.update(r100, 0, r100.length);
        if (r101 == null) goto L5;
        r102.update(r101, 0, r101.length);
    L5:
        Arrays.fill(r100, (byte) 0);
    }

    public /* synthetic */ NHSecretKeyProcessor(byte[] r100, byte[] r101, AnonymousClass1 r102) {
        this(r100, r101);
    }

    private static void xor(byte[] r100, byte[] r101) {
        int r102 = 0;
    L4:
        if (r102 == r100.length) goto L6;
        r100[r102] = (byte) (r100[r102] ^ r101[r102]);
        r102 = r102 + 1;
        goto L4
    }

    public byte[] processKey(byte[] r100) {
        int r101 = r100.length;
        byte[] r102 = new byte[r101];
        this.xof.doFinal(r102, 0, r101);
        xor(r100, r102);
        Arrays.fill(r102, (byte) 0);
        return r100;
    }
}
