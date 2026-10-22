package org.bouncycastle.jcajce.provider.asymmetric.ies;

import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.jce.spec.IESParameterSpec;

/* JADX INFO: loaded from: classes42.dex */
public class AlgorithmParametersSpi extends java.security.AlgorithmParametersSpi {
    IESParameterSpec currentSpec;

    public AlgorithmParametersSpi() {
    }

    @Override // java.security.AlgorithmParametersSpi
    public byte[] engineGetEncoded() {
        ASN1EncodableVector r100 = new ASN1EncodableVector();     // Catch: IOException -> L13
        if (this.currentSpec.getDerivationV() == null) goto L6;
        r100.add(new DERTaggedObject(false, 0, new DEROctetString(this.currentSpec.getDerivationV())));     // Catch: IOException -> L13
    L6:
        if (this.currentSpec.getEncodingV() == null) goto L8;
        r100.add(new DERTaggedObject(false, 1, new DEROctetString(this.currentSpec.getEncodingV())));     // Catch: IOException -> L13
    L8:
        r100.add(new ASN1Integer(this.currentSpec.getMacKeySize()));     // Catch: IOException -> L13
        if (this.currentSpec.getNonce() == null) goto L11;
        ASN1EncodableVector r101 = new ASN1EncodableVector();     // Catch: IOException -> L13
        r101.add(new ASN1Integer(this.currentSpec.getCipherKeySize()));     // Catch: IOException -> L13
        r101.add(new ASN1Integer(this.currentSpec.getNonce()));     // Catch: IOException -> L13
        r100.add(new DERSequence(r101));     // Catch: IOException -> L13
    L11:
        return new DERSequence(r100).getEncoded(ASN1Encoding.DER);
    L14:
        throw new RuntimeException("Error encoding IESParameters");
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
        if ((r100 instanceof IESParameterSpec) == false) goto L7;
        this.currentSpec = (IESParameterSpec) r100;
        return;
    L7:
        throw new InvalidParameterSpecException("IESParameterSpec required to initialise a IES algorithm parameters object");
    }

    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(byte[] r110) throws IOException {
        ASN1Sequence r111 = (ASN1Sequence) ASN1Primitive.fromByteArray(r110);     // Catch: ArrayIndexOutOfBoundsException -> L20 ClassCastException -> L22
        if (r111.size() != 1) goto L7;
        this.currentSpec = new IESParameterSpec(null, null, ASN1Integer.getInstance(r111.getObjectAt(0)).intValueExact());     // Catch: ArrayIndexOutOfBoundsException -> L20 ClassCastException -> L22
        return;
    L7:
        if (r111.size() != 2) goto L14;
        ASN1TaggedObject r100 = ASN1TaggedObject.getInstance(r111.getObjectAt(0));     // Catch: ArrayIndexOutOfBoundsException -> L20 ClassCastException -> L22
        if (r100.getTagNo() != 0) goto L12;
        IESParameterSpec r101 = new IESParameterSpec(ASN1OctetString.getInstance(r100, false).getOctets(), null, ASN1Integer.getInstance(r111.getObjectAt(1)).intValueExact());     // Catch: ArrayIndexOutOfBoundsException -> L20 ClassCastException -> L22
    L11:
        this.currentSpec = r101;     // Catch: ArrayIndexOutOfBoundsException -> L20 ClassCastException -> L22
        return;
    L12:
        r101 = new IESParameterSpec(null, ASN1OctetString.getInstance(r100, false).getOctets(), ASN1Integer.getInstance(r111.getObjectAt(1)).intValueExact());     // Catch: ArrayIndexOutOfBoundsException -> L20 ClassCastException -> L22
        goto L11
    L14:
        if (r111.size() != 3) goto L17;
        ASN1TaggedObject r102 = ASN1TaggedObject.getInstance(r111.getObjectAt(0));     // Catch: ArrayIndexOutOfBoundsException -> L20 ClassCastException -> L22
        ASN1TaggedObject r103 = ASN1TaggedObject.getInstance(r111.getObjectAt(1));     // Catch: ArrayIndexOutOfBoundsException -> L20 ClassCastException -> L22
        this.currentSpec = new IESParameterSpec(ASN1OctetString.getInstance(r102, false).getOctets(), ASN1OctetString.getInstance(r103, false).getOctets(), ASN1Integer.getInstance(r111.getObjectAt(2)).intValueExact());     // Catch: ArrayIndexOutOfBoundsException -> L20 ClassCastException -> L22
        return;
    L17:
        if (r111.size() != 4) goto L28;
        ASN1TaggedObject r104 = ASN1TaggedObject.getInstance(r111.getObjectAt(0));     // Catch: ArrayIndexOutOfBoundsException -> L20 ClassCastException -> L22
        ASN1TaggedObject r105 = ASN1TaggedObject.getInstance(r111.getObjectAt(1));     // Catch: ArrayIndexOutOfBoundsException -> L20 ClassCastException -> L22
        ASN1Sequence r106 = ASN1Sequence.getInstance(r111.getObjectAt(3));     // Catch: ArrayIndexOutOfBoundsException -> L20 ClassCastException -> L22
        this.currentSpec = new IESParameterSpec(ASN1OctetString.getInstance(r104, false).getOctets(), ASN1OctetString.getInstance(r105, false).getOctets(), ASN1Integer.getInstance(r111.getObjectAt(2)).intValueExact(), ASN1Integer.getInstance(r106.getObjectAt(0)).intValueExact(), ASN1OctetString.getInstance(r106.getObjectAt(1)).getOctets());     // Catch: ArrayIndexOutOfBoundsException -> L20 ClassCastException -> L22
        return;
    L28:
        return;
    L21:
        throw new IOException("Not a valid IES Parameter encoding.");
    L23:
        throw new IOException("Not a valid IES Parameter encoding.");
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
        return "IES Parameters";
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
        if (r100 == IESParameterSpec.class) goto L10;
        if (r100 == AlgorithmParameterSpec.class) goto L10;
        throw new InvalidParameterSpecException("unknown parameter spec passed to ElGamal parameters object.");
    L10:
        return this.currentSpec;
    }
}
