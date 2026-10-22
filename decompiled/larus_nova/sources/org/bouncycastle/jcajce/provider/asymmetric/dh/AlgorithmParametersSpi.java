package org.bouncycastle.jcajce.provider.asymmetric.dh;

import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.DHParameterSpec;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.pkcs.DHParameter;

/* JADX INFO: loaded from: classes42.dex */
public class AlgorithmParametersSpi extends java.security.AlgorithmParametersSpi {
    DHParameterSpec currentSpec;

    public AlgorithmParametersSpi() {
    }

    @Override // java.security.AlgorithmParametersSpi
    public byte[] engineGetEncoded() {
        return new DHParameter(this.currentSpec.getP(), this.currentSpec.getG(), this.currentSpec.getL()).getEncoded(ASN1Encoding.DER);
    L6:
        throw new RuntimeException("Error encoding DHParameters");
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
        if ((r100 instanceof DHParameterSpec) == false) goto L7;
        this.currentSpec = (DHParameterSpec) r100;
        return;
    L7:
        throw new InvalidParameterSpecException("DHParameterSpec required to initialise a Diffie-Hellman algorithm parameters object");
    }

    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(byte[] r100) throws IOException {
        DHParameter r101 = DHParameter.getInstance(r100);     // Catch: ArrayIndexOutOfBoundsException -> L10 ClassCastException -> L12
        if (r101.getL() == null) goto L7;
        DHParameterSpec r102 = new DHParameterSpec(r101.getP(), r101.getG(), r101.getL().intValue());     // Catch: ArrayIndexOutOfBoundsException -> L10 ClassCastException -> L12
    L6:
        this.currentSpec = r102;     // Catch: ArrayIndexOutOfBoundsException -> L10 ClassCastException -> L12
        return;
    L7:
        r102 = new DHParameterSpec(r101.getP(), r101.getG());     // Catch: ArrayIndexOutOfBoundsException -> L10 ClassCastException -> L12
    L11:
        throw new IOException("Not a valid DH Parameter encoding.");
    L13:
        throw new IOException("Not a valid DH Parameter encoding.");
    }

    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(byte[] r100, String r101) throws IOException {
        if (isASN1FormatString(r101) == false) goto L7;
        engineInit(r100);
        return;
    L7:
        throw new IOException("Unknown parameter format " + r101);
    }

    @Override // java.security.AlgorithmParametersSpi
    public String engineToString() {
        return "Diffie-Hellman Parameters";
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
        if (r100 == DHParameterSpec.class) goto L10;
        if (r100 == AlgorithmParameterSpec.class) goto L10;
        throw new InvalidParameterSpecException("unknown parameter spec passed to DH parameters object.");
    L10:
        return this.currentSpec;
    }
}
