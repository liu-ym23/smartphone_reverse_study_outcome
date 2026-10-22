package org.bouncycastle.pqc.crypto.newhope;

import java.security.SecureRandom;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.crypto.util.DEROtherInfo;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import org.bouncycastle.pqc.crypto.ExchangePair;

/* JADX INFO: loaded from: classes42.dex */
public class NHOtherInfoGenerator {
    protected final DEROtherInfo.Builder otherInfoBuilder;
    protected final SecureRandom random;
    protected boolean used;

    public static class PartyU extends NHOtherInfoGenerator {
        private AsymmetricCipherKeyPair aKp;
        private NHAgreement agreement;

        public PartyU(AlgorithmIdentifier r100, byte[] r101, byte[] r102, SecureRandom r103) {
            super(r100, r101, r102, r103);
            this.agreement = new NHAgreement();
            NHKeyPairGenerator r104 = new NHKeyPairGenerator();
            r104.init(new KeyGenerationParameters(r103, 2048));
            AsymmetricCipherKeyPair r105 = r104.generateKeyPair();
            this.aKp = r105;
            this.agreement.init(r105.getPrivate());
        }

        public DEROtherInfo generate(byte[] r100) {
            if (this.used == true) goto L7;
            this.used = true;
            this.otherInfoBuilder.withSuppPrivInfo(this.agreement.calculateAgreement(NHOtherInfoGenerator.access$100(r100)));
            return this.otherInfoBuilder.build();
        L7:
            throw new IllegalStateException("builder already used");
        }

        public byte[] getSuppPrivInfoPartA() {
            return NHOtherInfoGenerator.access$000((NHPublicKeyParameters) this.aKp.getPublic());
        }

        public NHOtherInfoGenerator withSuppPubInfo(byte[] r100) {
            this.otherInfoBuilder.withSuppPubInfo(r100);
            return this;
        }
    }

    public static class PartyV extends NHOtherInfoGenerator {
        public PartyV(AlgorithmIdentifier r100, byte[] r101, byte[] r102, SecureRandom r103) {
            super(r100, r101, r102, r103);
        }

        public DEROtherInfo generate() {
            if (this.used == true) goto L7;
            this.used = true;
            return this.otherInfoBuilder.build();
        L7:
            throw new IllegalStateException("builder already used");
        }

        public byte[] getSuppPrivInfoPartB(byte[] r100) {
            ExchangePair r101 = new NHExchangePairGenerator(this.random).generateExchange(NHOtherInfoGenerator.access$100(r100));
            this.otherInfoBuilder.withSuppPrivInfo(r101.getSharedValue());
            return NHOtherInfoGenerator.access$000((NHPublicKeyParameters) r101.getPublicKey());
        }

        public NHOtherInfoGenerator withSuppPubInfo(byte[] r100) {
            this.otherInfoBuilder.withSuppPubInfo(r100);
            return this;
        }
    }

    public NHOtherInfoGenerator(AlgorithmIdentifier r100, byte[] r101, byte[] r102, SecureRandom r103) {
        this.used = false;
        this.otherInfoBuilder = new DEROtherInfo.Builder(r100, r101, r102);
        this.random = r103;
    }

    public static /* synthetic */ byte[] access$000(NHPublicKeyParameters r100) {
        return getEncoded(r100);
    }

    public static /* synthetic */ NHPublicKeyParameters access$100(byte[] r100) {
        return getPublicKey(r100);
    }

    private static byte[] getEncoded(NHPublicKeyParameters r100) {
        return new SubjectPublicKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.newHope), r100.getPubData()).getEncoded();
    L4:
        return null;
    }

    private static NHPublicKeyParameters getPublicKey(byte[] r100) {
        return new NHPublicKeyParameters(SubjectPublicKeyInfo.getInstance(r100).getPublicKeyData().getOctets());
    }
}
