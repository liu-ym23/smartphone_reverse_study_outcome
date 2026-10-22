package org.bouncycastle.asn1.util;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Primitive;

/* JADX INFO: loaded from: classes42.dex */
public class DERDump extends ASN1Dump {
    public DERDump() {
    }

    public static String dumpAsString(ASN1Encodable r100) {
        StringBuffer r101 = new StringBuffer();
        ASN1Dump._dumpAsString("", false, r100.toASN1Primitive(), r101);
        return r101.toString();
    }

    public static String dumpAsString(ASN1Primitive r100) {
        StringBuffer r101 = new StringBuffer();
        ASN1Dump._dumpAsString("", false, r100, r101);
        return r101.toString();
    }
}
