package org.bouncycastle.pqc.asn1;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes42.dex */
public class XMSSMTPrivateKey extends ASN1Object {
    private final byte[] bdsState;
    private final long index;
    private final long maxIndex;
    private final byte[] publicSeed;
    private final byte[] root;
    private final byte[] secretKeyPRF;
    private final byte[] secretKeySeed;
    private final int version;

    public XMSSMTPrivateKey(long r100, byte[] r101, byte[] r102, byte[] r103, byte[] r104, byte[] r105) {
        this.version = 0;
        this.index = r100;
        this.secretKeySeed = Arrays.clone(r101);
        this.secretKeyPRF = Arrays.clone(r102);
        this.publicSeed = Arrays.clone(r103);
        this.root = Arrays.clone(r104);
        this.bdsState = Arrays.clone(r105);
        this.maxIndex = -1;
    }

    public XMSSMTPrivateKey(long r100, byte[] r101, byte[] r102, byte[] r103, byte[] r104, byte[] r105, long r106) {
        this.version = 1;
        this.index = r100;
        this.secretKeySeed = Arrays.clone(r101);
        this.secretKeyPRF = Arrays.clone(r102);
        this.publicSeed = Arrays.clone(r103);
        this.root = Arrays.clone(r104);
        this.bdsState = Arrays.clone(r105);
        this.maxIndex = r106;
    }

    private XMSSMTPrivateKey(ASN1Sequence r100) {
        ASN1Integer r101 = ASN1Integer.getInstance(r100.getObjectAt(0));
        if (r101.hasValue(BigIntegers.ZERO) == false) goto L5;
    L9:
        this.version = r101.intValueExact();
        if (r100.size() != 2) goto L12;
    L16:
        ASN1Sequence r102 = ASN1Sequence.getInstance(r100.getObjectAt(1));
        this.index = ASN1Integer.getInstance(r102.getObjectAt(0)).longValueExact();
        this.secretKeySeed = Arrays.clone(ASN1OctetString.getInstance(r102.getObjectAt(1)).getOctets());
        this.secretKeyPRF = Arrays.clone(ASN1OctetString.getInstance(r102.getObjectAt(2)).getOctets());
        this.publicSeed = Arrays.clone(ASN1OctetString.getInstance(r102.getObjectAt(3)).getOctets());
        this.root = Arrays.clone(ASN1OctetString.getInstance(r102.getObjectAt(4)).getOctets());
        if (r102.size() != 6) goto L24;
        ASN1TaggedObject r103 = ASN1TaggedObject.getInstance(r102.getObjectAt(5));
        if (r103.getTagNo() != 0) goto L22;
        long r104 = ASN1Integer.getInstance(r103, false).longValueExact();
    L26:
        this.maxIndex = r104;
        if (r100.size() != 3) goto L29;
        this.bdsState = Arrays.clone(ASN1OctetString.getInstance(ASN1TaggedObject.getInstance(r100.getObjectAt(2)), true).getOctets());
        return;
    L29:
        this.bdsState = null;
        return;
    L22:
        throw new IllegalArgumentException("unknown tag in XMSSPrivateKey");
    L24:
        if (r102.size() != 5) goto L32;
        r104 = -1;
        goto L26
    L32:
        throw new IllegalArgumentException("keySeq should be 5 or 6 in length");
    L12:
        if (r100.size() == 3) goto L16;
        throw new IllegalArgumentException("key sequence wrong size");
    L5:
        if (r101.hasValue(BigIntegers.ONE) == true) goto L9;
        throw new IllegalArgumentException("unknown version of sequence");
    }

    public static XMSSMTPrivateKey getInstance(Object r100) {
        if ((r100 instanceof XMSSMTPrivateKey) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new XMSSMTPrivateKey(ASN1Sequence.getInstance(r100));
    L5:
        return (XMSSMTPrivateKey) r100;
    }

    public byte[] getBdsState() {
        return Arrays.clone(this.bdsState);
    }

    public long getIndex() {
        return this.index;
    }

    public long getMaxIndex() {
        return this.maxIndex;
    }

    public byte[] getPublicSeed() {
        return Arrays.clone(this.publicSeed);
    }

    public byte[] getRoot() {
        return Arrays.clone(this.root);
    }

    public byte[] getSecretKeyPRF() {
        return Arrays.clone(this.secretKeyPRF);
    }

    public byte[] getSecretKeySeed() {
        return Arrays.clone(this.secretKeySeed);
    }

    public int getVersion() {
        return this.version;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector();
        if (this.maxIndex < 0) goto L5;
        ASN1Integer r101 = new ASN1Integer(1);
    L6:
        r100.add(r101);
        ASN1EncodableVector r102 = new ASN1EncodableVector();
        r102.add(new ASN1Integer(this.index));
        r102.add(new DEROctetString(this.secretKeySeed));
        r102.add(new DEROctetString(this.secretKeyPRF));
        r102.add(new DEROctetString(this.publicSeed));
        r102.add(new DEROctetString(this.root));
        long r103 = this.maxIndex;
        if (r103 < 0) goto L9;
        r102.add(new DERTaggedObject(false, 0, new ASN1Integer(r103)));
    L9:
        r100.add(new DERSequence(r102));
        r100.add(new DERTaggedObject(true, 0, new DEROctetString(this.bdsState)));
        return new DERSequence(r100);
    L5:
        r101 = new ASN1Integer(0);
        goto L6
    }
}
