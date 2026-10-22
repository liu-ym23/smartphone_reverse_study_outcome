package org.bouncycastle.jcajce.provider.symmetric.util;

import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.IvParameterSpec;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class IvAlgorithmParameters extends BaseAlgorithmParameters {

    /* JADX INFO: renamed from: iv, reason: collision with root package name */
    private byte[] f525383iv;

    public IvAlgorithmParameters() {
    }

    @Override // java.security.AlgorithmParametersSpi
    public byte[] engineGetEncoded() throws IOException {
        return engineGetEncoded("ASN.1");
    }

    @Override // java.security.AlgorithmParametersSpi
    public byte[] engineGetEncoded(String r100) throws IOException {
        if (isASN1FormatString(r100) == false) goto L7;
        return new DEROctetString(engineGetEncoded("RAW")).getEncoded();
    L7:
        if (r100.equals("RAW") == true) goto L9;
        return null;
    L9:
        return Arrays.clone(this.f525383iv);
    }

    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(AlgorithmParameterSpec r100) throws InvalidParameterSpecException {
        if ((r100 instanceof IvParameterSpec) == false) goto L7;
        this.f525383iv = ((IvParameterSpec) r100).getIV();
        return;
    L7:
        throw new InvalidParameterSpecException("IvParameterSpec required to initialise a IV parameters algorithm parameters object");
    }

    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(byte[] r100) throws IOException {
        if ((r100.length % 8) != 0) goto L5;
    L9:
        this.f525383iv = Arrays.clone(r100);
        return;
    L5:
        if (r100[0] != 4) goto L9;
        if (r100[1] != (r100.length - 2)) goto L9;
        r100 = ((ASN1OctetString) ASN1Primitive.fromByteArray(r100)).getOctets();
        goto L9
    }

    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(byte[] r100, String r101) throws IOException {
        if (isASN1FormatString(r101) == false) goto L10;
        engineInit(((ASN1OctetString) ASN1Primitive.fromByteArray(r100)).getOctets());     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        throw new IOException("Exception decoding: " + e);
    L10:
        if (r101.equals("RAW") == false) goto L14;
        engineInit(r100);
        return;
    L14:
        throw new IOException("Unknown parameters format in IV parameters object");
    }

    @Override // java.security.AlgorithmParametersSpi
    public String engineToString() {
        return "IV Parameters";
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameters
    public AlgorithmParameterSpec localEngineGetParameterSpec(Class r100) throws InvalidParameterSpecException {
        if (r100 == IvParameterSpec.class) goto L10;
        if (r100 == AlgorithmParameterSpec.class) goto L10;
        throw new InvalidParameterSpecException("unknown parameter spec passed to IV parameters object.");
    L10:
        return new IvParameterSpec(this.f525383iv);
    }
}
