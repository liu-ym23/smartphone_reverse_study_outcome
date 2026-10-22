package org.bouncycastle.jcajce.provider.asymmetric.dsa;

import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.DSAParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.x509.DSAParameter;

/* JADX INFO: loaded from: classes42.dex */
public class AlgorithmParametersSpi extends java.security.AlgorithmParametersSpi {
    DSAParameterSpec currentSpec;

    public AlgorithmParametersSpi() {
    }

    @Override // java.security.AlgorithmParametersSpi
    public byte[] engineGetEncoded() {
        return new DSAParameter(this.currentSpec.getP(), this.currentSpec.getQ(), this.currentSpec.getG()).getEncoded(ASN1Encoding.DER);
    L6:
        throw new RuntimeException("Error encoding DSAParameters");
    }

    @Override // java.security.AlgorithmParametersSpi
    public byte[] engineGetEncoded(String r100) {
        if (isASN1FormatString(r100) == true) goto L5;
        return null;
    L5:
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
        if ((r100 instanceof DSAParameterSpec) == false) goto L7;
        this.currentSpec = (DSAParameterSpec) r100;
        return;
    L7:
        throw new InvalidParameterSpecException("DSAParameterSpec required to initialise a DSA algorithm parameters object");
    }

    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(byte[] r100) throws IOException {
        DSAParameter r101 = DSAParameter.getInstance(ASN1Primitive.fromByteArray(r100));     // Catch: ArrayIndexOutOfBoundsException -> L5 ClassCastException -> L7
        this.currentSpec = new DSAParameterSpec(r101.getP(), r101.getQ(), r101.getG());     // Catch: ArrayIndexOutOfBoundsException -> L5 ClassCastException -> L7
        return;
    L6:
        throw new IOException("Not a valid DSA Parameter encoding.");
    L8:
        throw new IOException("Not a valid DSA Parameter encoding.");
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
        return "DSA Parameters";
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
        if (r100 == DSAParameterSpec.class) goto L10;
        if (r100 == AlgorithmParameterSpec.class) goto L10;
        throw new InvalidParameterSpecException("unknown parameter spec passed to DSA parameters object.");
    L10:
        return this.currentSpec;
    }
}
