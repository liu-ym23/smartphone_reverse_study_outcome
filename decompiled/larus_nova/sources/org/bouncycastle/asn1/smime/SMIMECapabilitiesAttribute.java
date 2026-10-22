package org.bouncycastle.asn1.smime;

import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.cms.Attribute;

/* JADX INFO: loaded from: classes42.dex */
public class SMIMECapabilitiesAttribute extends Attribute {
    public SMIMECapabilitiesAttribute(SMIMECapabilityVector r100) {
        super(SMIMEAttributes.smimeCapabilities, new DERSet(new DERSequence(r100.toASN1EncodableVector())));
    }
}
