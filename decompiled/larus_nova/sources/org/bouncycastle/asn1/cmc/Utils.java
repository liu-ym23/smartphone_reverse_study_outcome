package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.x509.Extension;

/* JADX INFO: loaded from: classes42.dex */
class Utils {
    public Utils() {
    }

    public static BodyPartID[] clone(BodyPartID[] r100) {
        BodyPartID[] r101 = new BodyPartID[r100.length];
        System.arraycopy(r100, 0, r101, 0, r100.length);
        return r101;
    }

    public static Extension[] clone(Extension[] r100) {
        Extension[] r101 = new Extension[r100.length];
        System.arraycopy(r100, 0, r101, 0, r100.length);
        return r101;
    }

    public static BodyPartID[] toBodyPartIDArray(ASN1Sequence r100) {
        BodyPartID[] r101 = new BodyPartID[r100.size()];
        int r102 = 0;
    L4:
        if (r102 == r100.size()) goto L6;
        r101[r102] = BodyPartID.getInstance(r100.getObjectAt(r102));
        r102 = r102 + 1;
        goto L4
    L6:
        return r101;
    }
}
