package org.bouncycastle.asn1.smime;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class SMIMECapabilityVector {
    private ASN1EncodableVector capabilities;

    public SMIMECapabilityVector() {
        this.capabilities = new ASN1EncodableVector();
    }

    public void addCapability(ASN1ObjectIdentifier r100) {
        this.capabilities.add(new DERSequence(r100));
    }

    public void addCapability(ASN1ObjectIdentifier r100, int r101) {
        ASN1EncodableVector r102 = new ASN1EncodableVector(2);
        r102.add(r100);
        r102.add(new ASN1Integer(r101));
        this.capabilities.add(new DERSequence(r102));
    }

    public void addCapability(ASN1ObjectIdentifier r100, ASN1Encodable r101) {
        ASN1EncodableVector r102 = new ASN1EncodableVector(2);
        r102.add(r100);
        r102.add(r101);
        this.capabilities.add(new DERSequence(r102));
    }

    public ASN1EncodableVector toASN1EncodableVector() {
        return this.capabilities;
    }
}
