package org.bouncycastle.asn1.bc;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class ObjectStore extends ASN1Object {
    private final ObjectStoreIntegrityCheck integrityCheck;
    private final ASN1Encodable storeData;

    private ObjectStore(ASN1Sequence r100) {
        if (r100.size() != 2) goto L17;
        ASN1Encodable r101 = r100.getObjectAt(0);
        if ((r101 instanceof EncryptedObjectStoreData) == false) goto L8;
    L6:
        this.storeData = r101;
        this.integrityCheck = ObjectStoreIntegrityCheck.getInstance(r100.getObjectAt(1));
        return;
    L8:
        if ((r101 instanceof ObjectStoreData) == true) goto L6;
        ASN1Sequence r102 = ASN1Sequence.getInstance(r101);
        if (r102.size() != 2) goto L13;
        r101 = EncryptedObjectStoreData.getInstance(r102);
        goto L6
    L13:
        r101 = ObjectStoreData.getInstance(r102);
        goto L6
    L17:
        throw new IllegalArgumentException("malformed sequence");
    }

    public ObjectStore(EncryptedObjectStoreData r100, ObjectStoreIntegrityCheck r101) {
        this.storeData = r100;
        this.integrityCheck = r101;
    }

    public ObjectStore(ObjectStoreData r100, ObjectStoreIntegrityCheck r101) {
        this.storeData = r100;
        this.integrityCheck = r101;
    }

    public static ObjectStore getInstance(Object r100) {
        if ((r100 instanceof ObjectStore) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new ObjectStore(ASN1Sequence.getInstance(r100));
    L5:
        return (ObjectStore) r100;
    }

    public ObjectStoreIntegrityCheck getIntegrityCheck() {
        return this.integrityCheck;
    }

    public ASN1Encodable getStoreData() {
        return this.storeData;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.storeData);
        r100.add(this.integrityCheck);
        return new DERSequence(r100);
    }
}
