package org.bouncycastle.jcajce.provider.asymmetric.elgamal;

import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.DHParameterSpec;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.oiw.ElGamalParameter;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameters;
import org.bouncycastle.jce.spec.ElGamalParameterSpec;

/* JADX INFO: loaded from: classes42.dex */
public class AlgorithmParametersSpi extends BaseAlgorithmParameters {
    ElGamalParameterSpec currentSpec;

    public AlgorithmParametersSpi() {
    }

    @Override // java.security.AlgorithmParametersSpi
    public byte[] engineGetEncoded() {
        return new ElGamalParameter(this.currentSpec.getP(), this.currentSpec.getG()).getEncoded(ASN1Encoding.DER);
    L6:
        throw new RuntimeException("Error encoding ElGamalParameters");
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
    public void engineInit(AlgorithmParameterSpec r100) throws InvalidParameterSpecException {
        boolean r101 = r100 instanceof ElGamalParameterSpec;
        if (r101 == false) goto L5;
    L9:
        if (r101 == false) goto L11;
        this.currentSpec = (ElGamalParameterSpec) r100;
        return;
    L11:
        DHParameterSpec r102 = (DHParameterSpec) r100;
        this.currentSpec = new ElGamalParameterSpec(r102.getP(), r102.getG());
        return;
    L5:
        if ((r100 instanceof DHParameterSpec) == true) goto L9;
        throw new InvalidParameterSpecException("DHParameterSpec required to initialise a ElGamal algorithm parameters object");
    }

    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(byte[] r100) throws IOException {
        ElGamalParameter r101 = ElGamalParameter.getInstance(ASN1Primitive.fromByteArray(r100));     // Catch: ArrayIndexOutOfBoundsException -> L5 ClassCastException -> L7
        this.currentSpec = new ElGamalParameterSpec(r101.getP(), r101.getG());     // Catch: ArrayIndexOutOfBoundsException -> L5 ClassCastException -> L7
        return;
    L6:
        throw new IOException("Not a valid ElGamal Parameter encoding.");
    L8:
        throw new IOException("Not a valid ElGamal Parameter encoding.");
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
        return "ElGamal Parameters";
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameters
    public AlgorithmParameterSpec localEngineGetParameterSpec(Class r100) throws InvalidParameterSpecException {
        if (r100 == ElGamalParameterSpec.class) goto L14;
        if (r100 == AlgorithmParameterSpec.class) goto L14;
        if (r100 != DHParameterSpec.class) goto L12;
        return new DHParameterSpec(this.currentSpec.getP(), this.currentSpec.getG());
    L12:
        throw new InvalidParameterSpecException("unknown parameter spec passed to ElGamal parameters object.");
    L14:
        return this.currentSpec;
    }
}
