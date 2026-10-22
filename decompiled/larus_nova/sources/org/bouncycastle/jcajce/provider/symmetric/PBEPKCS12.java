package org.bouncycastle.jcajce.provider.symmetric;

import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.PBEParameterSpec;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.pkcs.PKCS12PBEParams;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameters;
import org.bouncycastle.jcajce.provider.util.AlgorithmProvider;

/* JADX INFO: loaded from: classes42.dex */
public class PBEPKCS12 {

    public static class AlgParams extends BaseAlgorithmParameters {
        PKCS12PBEParams params;

        public AlgParams() {
        }

        @Override // java.security.AlgorithmParametersSpi
        public byte[] engineGetEncoded() {
            return this.params.getEncoded(ASN1Encoding.DER);
        L4:
            e = move-exception;
            throw new RuntimeException("Oooops! " + e.toString());
        }

        @Override // java.security.AlgorithmParametersSpi
        public byte[] engineGetEncoded(String r100) {
            if (isASN1FormatString(r100) == true) goto L5;
            return null;
        L5:
            return engineGetEncoded();
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(AlgorithmParameterSpec r100) throws InvalidParameterSpecException {
            if ((r100 instanceof PBEParameterSpec) == false) goto L7;
            PBEParameterSpec r101 = (PBEParameterSpec) r100;
            this.params = new PKCS12PBEParams(r101.getSalt(), r101.getIterationCount());
            return;
        L7:
            throw new InvalidParameterSpecException("PBEParameterSpec required to initialise a PKCS12 PBE parameters algorithm parameters object");
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(byte[] r100) throws IOException {
            this.params = PKCS12PBEParams.getInstance(ASN1Primitive.fromByteArray(r100));
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(byte[] r100, String r101) throws IOException {
            if (isASN1FormatString(r101) == false) goto L7;
            engineInit(r100);
            return;
        L7:
            throw new IOException("Unknown parameters format in PKCS12 PBE parameters object");
        }

        @Override // java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "PKCS12 PBE Parameters";
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameters
        public AlgorithmParameterSpec localEngineGetParameterSpec(Class r100) throws InvalidParameterSpecException {
            if (r100 == PBEParameterSpec.class) goto L10;
            if (r100 == AlgorithmParameterSpec.class) goto L10;
            throw new InvalidParameterSpecException("unknown parameter spec passed to PKCS12 PBE parameters object.");
        L10:
            return new PBEParameterSpec(this.params.getIV(), this.params.getIterations().intValue());
        }
    }

    public static class Mappings extends AlgorithmProvider {
        private static final String PREFIX = null;

        static {
            PREFIX = PBEPKCS12.class.getName();
        }

        public Mappings() {
        }

        @Override // org.bouncycastle.jcajce.provider.util.AlgorithmProvider
        public void configure(ConfigurableProvider r100) {
            r100.addAlgorithm("AlgorithmParameters.PKCS12PBE", PREFIX + "$AlgParams");
        }
    }

    private PBEPKCS12() {
    }
}
