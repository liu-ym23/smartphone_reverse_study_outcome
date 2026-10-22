package org.bouncycastle.asn1.bc;

import java.util.Iterator;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Iterable;

/* JADX INFO: loaded from: classes42.dex */
public class ObjectDataSequence extends ASN1Object implements Iterable<ASN1Encodable> {
    private final ASN1Encodable[] dataSequence;

    private ObjectDataSequence(ASN1Sequence r100) {
        this.dataSequence = new ASN1Encodable[r100.size()];
        int r101 = 0;
    L3:
        ASN1Encodable[] r102 = this.dataSequence;
        if (r101 == r102.length) goto L6;
        r102[r101] = ObjectData.getInstance(r100.getObjectAt(r101));
        r101 = r101 + 1;
        goto L3
    }

    public ObjectDataSequence(ObjectData[] r100) {
        ASN1Encodable[] r101 = new ASN1Encodable[r100.length];
        this.dataSequence = r101;
        System.arraycopy(r100, 0, r101, 0, r100.length);
    }

    public static ObjectDataSequence getInstance(Object r100) {
        if ((r100 instanceof ObjectDataSequence) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new ObjectDataSequence(ASN1Sequence.getInstance(r100));
    L5:
        return (ObjectDataSequence) r100;
    }

    @Override // org.bouncycastle.util.Iterable, java.lang.Iterable
    public Iterator<ASN1Encodable> iterator() {
        return new Arrays.Iterator(this.dataSequence);
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.dataSequence);
    }
}
