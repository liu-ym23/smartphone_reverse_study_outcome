package org.bouncycastle.crypto.util;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.gm.GMObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.rosstandart.RosstandartObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.util.Integers;

/* JADX INFO: loaded from: classes42.dex */
public class PBKDF2Config extends PBKDFConfig {
    private static final Map PRFS_SALT = null;
    public static final AlgorithmIdentifier PRF_SHA1 = null;
    public static final AlgorithmIdentifier PRF_SHA256 = null;
    public static final AlgorithmIdentifier PRF_SHA3_256 = null;
    public static final AlgorithmIdentifier PRF_SHA3_512 = null;
    public static final AlgorithmIdentifier PRF_SHA512 = null;
    private final int iterationCount;
    private final AlgorithmIdentifier prf;
    private final int saltLength;

    /* JADX INFO: renamed from: org.bouncycastle.crypto.util.PBKDF2Config$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private int iterationCount;
        private AlgorithmIdentifier prf;
        private int saltLength;

        public Builder() {
            this.iterationCount = 1024;
            this.saltLength = -1;
            this.prf = PBKDF2Config.PRF_SHA1;
        }

        public static /* synthetic */ int access$100(Builder r100) {
            return r100.iterationCount;
        }

        public static /* synthetic */ AlgorithmIdentifier access$200(Builder r100) {
            return r100.prf;
        }

        public static /* synthetic */ int access$300(Builder r100) {
            return r100.saltLength;
        }

        public PBKDF2Config build() {
            return new PBKDF2Config(this, null);
        }

        public Builder withIterationCount(int r100) {
            this.iterationCount = r100;
            return this;
        }

        public Builder withPRF(AlgorithmIdentifier r100) {
            this.prf = r100;
            return this;
        }

        public Builder withSaltLength(int r100) {
            this.saltLength = r100;
            return this;
        }
    }

    static {
        ASN1ObjectIdentifier r100 = PKCSObjectIdentifiers.id_hmacWithSHA1;
        DERNull r101 = DERNull.INSTANCE;
        PRF_SHA1 = new AlgorithmIdentifier(r100, r101);
        ASN1ObjectIdentifier r102 = PKCSObjectIdentifiers.id_hmacWithSHA256;
        PRF_SHA256 = new AlgorithmIdentifier(r102, r101);
        ASN1ObjectIdentifier r103 = PKCSObjectIdentifiers.id_hmacWithSHA512;
        PRF_SHA512 = new AlgorithmIdentifier(r103, r101);
        ASN1ObjectIdentifier r104 = NISTObjectIdentifiers.id_hmacWithSHA3_256;
        PRF_SHA3_256 = new AlgorithmIdentifier(r104, r101);
        ASN1ObjectIdentifier r105 = NISTObjectIdentifiers.id_hmacWithSHA3_512;
        PRF_SHA3_512 = new AlgorithmIdentifier(r105, r101);
        HashMap r106 = new HashMap();
        PRFS_SALT = r106;
        r106.put(r100, Integers.valueOf(20));
        r106.put(r102, Integers.valueOf(32));
        r106.put(r103, Integers.valueOf(64));
        r106.put(PKCSObjectIdentifiers.id_hmacWithSHA224, Integers.valueOf(28));
        r106.put(PKCSObjectIdentifiers.id_hmacWithSHA384, Integers.valueOf(48));
        r106.put(NISTObjectIdentifiers.id_hmacWithSHA3_224, Integers.valueOf(28));
        r106.put(r104, Integers.valueOf(32));
        r106.put(NISTObjectIdentifiers.id_hmacWithSHA3_384, Integers.valueOf(48));
        r106.put(r105, Integers.valueOf(64));
        r106.put(CryptoProObjectIdentifiers.gostR3411Hmac, Integers.valueOf(32));
        r106.put(RosstandartObjectIdentifiers.id_tc26_hmac_gost_3411_12_256, Integers.valueOf(32));
        r106.put(RosstandartObjectIdentifiers.id_tc26_hmac_gost_3411_12_512, Integers.valueOf(64));
        r106.put(GMObjectIdentifiers.hmac_sm3, Integers.valueOf(32));
    }

    private PBKDF2Config(Builder r100) {
        super(PKCSObjectIdentifiers.id_PBKDF2);
        this.iterationCount = Builder.access$100(r100);
        AlgorithmIdentifier r101 = Builder.access$200(r100);
        this.prf = r101;
        if (Builder.access$300(r100) >= 0) goto L5;
        int r102 = getSaltSize(r101.getAlgorithm());
    L6:
        this.saltLength = r102;
        return;
    L5:
        r102 = Builder.access$300(r100);
        goto L6
    }

    public /* synthetic */ PBKDF2Config(Builder r100, AnonymousClass1 r101) {
        this(r100);
    }

    public static int getSaltSize(ASN1ObjectIdentifier r100) {
        Map r101 = PRFS_SALT;
        if (r101.containsKey(r100) == false) goto L7;
        return ((Integer) r101.get(r100)).intValue();
    L7:
        throw new IllegalStateException("no salt size for algorithm: " + r100);
    }

    public int getIterationCount() {
        return this.iterationCount;
    }

    public AlgorithmIdentifier getPRF() {
        return this.prf;
    }

    public int getSaltLength() {
        return this.saltLength;
    }
}
