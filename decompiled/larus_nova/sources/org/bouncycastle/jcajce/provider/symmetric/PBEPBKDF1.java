package org.bouncycastle.jcajce.provider.symmetric;

import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.PBEParameterSpec;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.pkcs.PBEParameter;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameters;
import org.bouncycastle.jcajce.provider.util.AlgorithmProvider;

/* JADX INFO: loaded from: classes42.dex */
public class PBEPBKDF1 {

    public static class AlgParams extends BaseAlgorithmParameters {
        PBEParameter params;

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
            this.params = new PBEParameter(r101.getSalt(), r101.getIterationCount());
            return;
        L7:
            throw new InvalidParameterSpecException("PBEParameterSpec required to initialise a PBKDF1 PBE parameters algorithm parameters object");
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(byte[] r100) throws IOException {
            this.params = PBEParameter.getInstance(r100);
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(byte[] r100, String r101) throws IOException {
            if (isASN1FormatString(r101) == false) goto L7;
            engineInit(r100);
            return;
        L7:
            throw new IOException("Unknown parameters format in PBKDF2 parameters object");
        }

        @Override // java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "PBKDF1 Parameters";
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameters
        public AlgorithmParameterSpec localEngineGetParameterSpec(Class r100) throws InvalidParameterSpecException {
            if (r100 == PBEParameterSpec.class) goto L10;
            if (r100 == AlgorithmParameterSpec.class) goto L10;
            throw new InvalidParameterSpecException("unknown parameter spec passed to PBKDF1 PBE parameters object.");
        L10:
            return new PBEParameterSpec(this.params.getSalt(), this.params.getIterationCount().intValue());
        }
    }

    public static class Mappings extends AlgorithmProvider {
        private static final String PREFIX = null;

        static {
            PREFIX = PBEPBKDF1.class.getName();
        }

        public Mappings() {
        }

        @Override // org.bouncycastle.jcajce.provider.util.AlgorithmProvider
        public void configure(ConfigurableProvider r100) {
            r100.addAlgorithm("AlgorithmParameters.PBKDF1", PREFIX + "$AlgParams");
            StringBuilder r101 = new StringBuilder("Alg.Alias.AlgorithmParameters.");
            r101.append(PKCSObjectIdentifiers.pbeWithMD2AndDES_CBC);
            r100.addAlgorithm(r101.toString(), "PBKDF1");
            r100.addAlgorithm("Alg.Alias.AlgorithmParameters." + PKCSObjectIdentifiers.pbeWithMD5AndDES_CBC, "PBKDF1");
            r100.addAlgorithm("Alg.Alias.AlgorithmParameters." + PKCSObjectIdentifiers.pbeWithMD5AndRC2_CBC, "PBKDF1");
            r100.addAlgorithm("Alg.Alias.AlgorithmParameters." + PKCSObjectIdentifiers.pbeWithSHA1AndDES_CBC, "PBKDF1");
            r100.addAlgorithm("Alg.Alias.AlgorithmParameters." + PKCSObjectIdentifiers.pbeWithSHA1AndRC2_CBC, "PBKDF1");
        }
    }

    private PBEPBKDF1() {
    }
}
