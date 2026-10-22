package org.bouncycastle.asn1;

/* JADX INFO: loaded from: classes42.dex */
public class OIDTokenizer {
    private int index;
    private String oid;

    public OIDTokenizer(String r100) {
        this.oid = r100;
        this.index = 0;
    }

    public boolean hasMoreTokens() {
        if (this.index == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public String nextToken() {
        int r100 = this.index;
        if (r100 != (-1)) goto L6;
        return null;
    L6:
        int r101 = this.oid.indexOf(46, r100);
        if (r101 != (-1)) goto L10;
        String r102 = this.oid.substring(this.index);
        this.index = -1;
        return r102;
    L10:
        String r103 = this.oid.substring(this.index, r101);
        this.index = r101 + 1;
        return r103;
    }
}
