package org.bouncycastle.jcajce.provider.asymmetric.gost;

import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import org.bouncycastle.jce.spec.GOST3410ParameterSpec;
import org.bouncycastle.jce.spec.GOST3410PublicKeyParameterSetSpec;

/* JADX INFO: loaded from: classes42.dex */
public class AlgorithmParametersSpi extends java.security.AlgorithmParametersSpi {
    GOST3410ParameterSpec currentSpec;

    public AlgorithmParametersSpi() {
    }

    @Override // java.security.AlgorithmParametersSpi
    public byte[] engineGetEncoded() {
        return new GOST3410PublicKeyAlgParameters(new ASN1ObjectIdentifier(this.currentSpec.getPublicKeyParamSetOID()), new ASN1ObjectIdentifier(this.currentSpec.getDigestParamSetOID()), new ASN1ObjectIdentifier(this.currentSpec.getEncryptionParamSetOID())).getEncoded(ASN1Encoding.DER);
    L6:
        throw new RuntimeException("Error encoding GOST3410Parameters");
    }

    @Override // java.security.AlgorithmParametersSpi
    public byte[] engineGetEncoded(String r100) {
        if (isASN1FormatString(r100) == true) goto L10;
        if (r100.equalsIgnoreCase("X.509") == true) goto L10;
        return null;
    L10:
        return engineGetEncoded();
    }

    @Override // java.security.AlgorithmParametersSpi
    public AlgorithmParameterSpec engineGetParameterSpec(Class r100) throws InvalidParameterSpecException {
        if (r100 == null) goto L6;
        return localEngineGetParameterSpec(r100);
    L6:
        throw new NullPointerException("argument to getParameterSpec must not be null");
    }

    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(AlgorithmParameterSpec r100) throws InvalidParameterSpecException {
        if ((r100 instanceof GOST3410ParameterSpec) == false) goto L7;
        this.currentSpec = (GOST3410ParameterSpec) r100;
        return;
    L7:
        throw new InvalidParameterSpecException("GOST3410ParameterSpec required to initialise a GOST3410 algorithm parameters object");
    }

    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(byte[] r100) throws IOException {
        this.currentSpec = GOST3410ParameterSpec.fromPublicKeyAlg(GOST3410PublicKeyAlgParameters.getInstance((ASN1Sequence) ASN1Primitive.fromByteArray(r100)));     // Catch: ArrayIndexOutOfBoundsException -> L5 ClassCastException -> L7
        return;
    L6:
        throw new IOException("Not a valid GOST3410 Parameter encoding.");
    L8:
        throw new IOException("Not a valid GOST3410 Parameter encoding.");
    }

    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(byte[] r100, String r101) throws IOException {
        if (isASN1FormatString(r101) == false) goto L5;
    L9:
        engineInit(r100);
        return;
    L5:
        if (r101.equalsIgnoreCase("X.509") == true) goto L9;
        throw new IOException("Unknown parameter format ".concat(r101));
    }

    @Override // java.security.AlgorithmParametersSpi
    public String engineToString() {
        return "GOST3410 Parameters";
    }

    public boolean isASN1FormatString(String r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (r100.equals("ASN.1") == true) goto L7;
        return false;
    }

    public AlgorithmParameterSpec localEngineGetParameterSpec(Class r100) throws InvalidParameterSpecException {
        if (r100 == GOST3410PublicKeyParameterSetSpec.class) goto L10;
        if (r100 == AlgorithmParameterSpec.class) goto L10;
        throw new InvalidParameterSpecException("unknown parameter spec passed to GOST3410 parameters object.");
    L10:
        return this.currentSpec;
    }
}
