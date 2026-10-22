package org.bouncycastle.crypto.agreement.kdf;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.crypto.DerivationParameters;

/* JADX INFO: loaded from: classes42.dex */
public class DHKDFParameters implements DerivationParameters {
    private ASN1ObjectIdentifier algorithm;
    private byte[] extraInfo;
    private int keySize;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private byte[] f525118z;

    public DHKDFParameters(ASN1ObjectIdentifier r100, int r101, byte[] r102) {
        this(r100, r101, r102, null);
    }

    public DHKDFParameters(ASN1ObjectIdentifier r100, int r101, byte[] r102, byte[] r103) {
        this.algorithm = r100;
        this.keySize = r101;
        this.f525118z = r102;
        this.extraInfo = r103;
    }

    public ASN1ObjectIdentifier getAlgorithm() {
        return this.algorithm;
    }

    public byte[] getExtraInfo() {
        return this.extraInfo;
    }

    public int getKeySize() {
        return this.keySize;
    }

    public byte[] getZ() {
        return this.f525118z;
    }
}
