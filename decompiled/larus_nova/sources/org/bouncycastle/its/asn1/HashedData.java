package org.bouncycastle.its.asn1;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DEROctetString;

/* JADX INFO: loaded from: classes42.dex */
public class HashedData extends ASN1Object implements ASN1Choice {
    private ASN1OctetString hashData;

    private HashedData(ASN1OctetString r100) {
        this.hashData = r100;
    }

    public HashedData(byte[] r100) {
        this.hashData = new DEROctetString(r100);
    }

    public ASN1OctetString getHashData() {
        return this.hashData;
    }

    public void setHashData(ASN1OctetString r100) {
        this.hashData = r100;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.hashData;
    }
}
