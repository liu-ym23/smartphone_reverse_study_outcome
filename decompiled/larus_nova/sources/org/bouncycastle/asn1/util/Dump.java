package org.bouncycastle.asn1.util;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Primitive;

/* JADX INFO: loaded from: classes42.dex */
public class Dump {
    public Dump() {
    }

    public static void main(String[] r100) throws Exception {
        ASN1InputStream r101 = new ASN1InputStream(new PolarisFileInputStreamWrapper(r100[0]));
    L3:
        ASN1Primitive r102 = r101.readObject();
        if (r102 == null) goto L6;
        System.out.println(ASN1Dump.dumpAsString(r102));
        goto L3
    }
}
