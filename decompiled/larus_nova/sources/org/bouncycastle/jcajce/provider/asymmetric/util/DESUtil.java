package org.bouncycastle.jcajce.provider.asymmetric.util;

import java.util.HashSet;
import java.util.Set;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes42.dex */
public class DESUtil {
    private static final Set<String> des = null;

    static {
        HashSet r100 = new HashSet();
        des = r100;
        r100.add("DES");
        r100.add("DESEDE");
        r100.add(OIWObjectIdentifiers.desCBC.getId());
        ASN1ObjectIdentifier r101 = PKCSObjectIdentifiers.des_EDE3_CBC;
        r100.add(r101.getId());
        r100.add(r101.getId());
        r100.add(PKCSObjectIdentifiers.id_alg_CMS3DESwrap.getId());
    }

    public DESUtil() {
    }

    public static boolean isDES(String r100) {
        String r101 = Strings.toUpperCase(r100);
        return des.contains(r101);
    }

    public static void setOddParity(byte[] r100) {
        int r101 = 0;
    L4:
        if (r101 >= r100.length) goto L6;
        byte r102 = r100[r101];
        int r103 = r102 & 254;
        int r104 = (((((r102 >> 1) ^ (r102 >> 2)) ^ (r102 >> 3)) ^ (r102 >> 4)) ^ (r102 >> 5)) ^ (r102 >> 6);
        r100[r101] = (byte) (((((r102 >> 7) ^ r104) ^ 1) & 1) | r103);
        r101 = r101 + 1;
        goto L4
    }
}
