package org.bouncycastle.asn1.cryptopro;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class Gost2814789EncryptedKey extends ASN1Object {
    private final byte[] encryptedKey;
    private final byte[] macKey;
    private final byte[] maskKey;

    private Gost2814789EncryptedKey(ASN1Sequence r100) {
        if (r100.size() != 2) goto L6;
        this.encryptedKey = Arrays.clone(ASN1OctetString.getInstance(r100.getObjectAt(0)).getOctets());
        this.macKey = Arrays.clone(ASN1OctetString.getInstance(r100.getObjectAt(1)).getOctets());
        this.maskKey = null;
        return;
    L6:
        if (r100.size() != 3) goto L10;
        this.encryptedKey = Arrays.clone(ASN1OctetString.getInstance(r100.getObjectAt(0)).getOctets());
        this.maskKey = Arrays.clone(ASN1OctetString.getInstance(ASN1TaggedObject.getInstance(r100.getObjectAt(1)), false).getOctets());
        this.macKey = Arrays.clone(ASN1OctetString.getInstance(r100.getObjectAt(2)).getOctets());
        return;
    L10:
        throw new IllegalArgumentException("unknown sequence length: " + r100.size());
    }

    public Gost2814789EncryptedKey(byte[] r100, byte[] r101) {
        this(r100, null, r101);
    }

    public Gost2814789EncryptedKey(byte[] r100, byte[] r101, byte[] r102) {
        this.encryptedKey = Arrays.clone(r100);
        this.maskKey = Arrays.clone(r101);
        this.macKey = Arrays.clone(r102);
    }

    public static Gost2814789EncryptedKey getInstance(Object r100) {
        if ((r100 instanceof Gost2814789EncryptedKey) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new Gost2814789EncryptedKey(ASN1Sequence.getInstance(r100));
    L5:
        return (Gost2814789EncryptedKey) r100;
    }

    public byte[] getEncryptedKey() {
        return Arrays.clone(this.encryptedKey);
    }

    public byte[] getMacKey() {
        return Arrays.clone(this.macKey);
    }

    public byte[] getMaskKey() {
        return Arrays.clone(this.maskKey);
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        r100.add(new DEROctetString(this.encryptedKey));
        if (this.maskKey == null) goto L5;
        r100.add(new DERTaggedObject(false, 0, new DEROctetString(this.encryptedKey)));
    L5:
        r100.add(new DEROctetString(this.macKey));
        return new DERSequence(r100);
    }
}
