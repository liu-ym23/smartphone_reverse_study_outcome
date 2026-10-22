package org.bouncycastle.asn1.est;

/* JADX INFO: loaded from: classes42.dex */
class Utils {
    public Utils() {
    }

    public static AttrOrOID[] clone(AttrOrOID[] r100) {
        AttrOrOID[] r101 = new AttrOrOID[r100.length];
        System.arraycopy(r100, 0, r101, 0, r100.length);
        return r101;
    }
}
