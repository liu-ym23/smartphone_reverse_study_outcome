package org.bouncycastle.jcajce.spec;

import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class KTSParameterSpec implements AlgorithmParameterSpec {
    private final AlgorithmIdentifier kdfAlgorithm;
    private final int keySizeInBits;
    private byte[] otherInfo;
    private final AlgorithmParameterSpec parameterSpec;
    private final String wrappingKeyAlgorithm;

    /* JADX INFO: renamed from: org.bouncycastle.jcajce.spec.KTSParameterSpec$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        private final String algorithmName;
        private AlgorithmIdentifier kdfAlgorithm;
        private final int keySizeInBits;
        private byte[] otherInfo;
        private AlgorithmParameterSpec parameterSpec;

        public Builder(String r100, int r101) {
            this(r100, r101, null);
        }

        public Builder(String r100, int r101, byte[] r102) {
            this.algorithmName = r100;
            this.keySizeInBits = r101;
            this.kdfAlgorithm = new AlgorithmIdentifier(X9ObjectIdentifiers.id_kdf_kdf3, new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha256));
            if (r102 != null) goto L5;
            byte[] r103 = new byte[0];
        L6:
            this.otherInfo = r103;
            return;
        L5:
            r103 = Arrays.clone(r102);
            goto L6
        }

        public KTSParameterSpec build() {
            return new KTSParameterSpec(this.algorithmName, this.keySizeInBits, this.parameterSpec, this.kdfAlgorithm, this.otherInfo, null);
        }

        public Builder withKdfAlgorithm(AlgorithmIdentifier r100) {
            this.kdfAlgorithm = r100;
            return this;
        }

        public Builder withParameterSpec(AlgorithmParameterSpec r100) {
            this.parameterSpec = r100;
            return this;
        }
    }

    private KTSParameterSpec(String r100, int r101, AlgorithmParameterSpec r102, AlgorithmIdentifier r103, byte[] r104) {
        this.wrappingKeyAlgorithm = r100;
        this.keySizeInBits = r101;
        this.parameterSpec = r102;
        this.kdfAlgorithm = r103;
        this.otherInfo = r104;
    }

    public /* synthetic */ KTSParameterSpec(String r100, int r101, AlgorithmParameterSpec r102, AlgorithmIdentifier r103, byte[] r104, AnonymousClass1 r105) {
        this(r100, r101, r102, r103, r104);
    }

    public AlgorithmIdentifier getKdfAlgorithm() {
        return this.kdfAlgorithm;
    }

    public String getKeyAlgorithmName() {
        return this.wrappingKeyAlgorithm;
    }

    public int getKeySize() {
        return this.keySizeInBits;
    }

    public byte[] getOtherInfo() {
        return Arrays.clone(this.otherInfo);
    }

    public AlgorithmParameterSpec getParameterSpec() {
        return this.parameterSpec;
    }
}
