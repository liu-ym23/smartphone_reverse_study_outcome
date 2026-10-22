package org.bouncycastle.asn1.x509;

/* JADX INFO: loaded from: classes42.dex */
public class X509NameTokenizer {
    private StringBuffer buf;
    private int index;
    private char separator;
    private String value;

    public X509NameTokenizer(String r100) {
        this(r100, ',');
    }

    public X509NameTokenizer(String r100, char r101) {
        this.buf = new StringBuffer();
        this.value = r100;
        this.index = -1;
        this.separator = r101;
    }

    public boolean hasMoreTokens() {
        if (this.index == this.value.length()) goto L5;
        return true;
    L5:
        return false;
    }

    public String nextToken() {
        if (this.index != this.value.length()) goto L6;
        return null;
    L6:
        int r100 = this.index + 1;
        this.buf.setLength(0);
        boolean r101 = false;
        boolean r102 = false;
    L8:
        if (r100 == this.value.length()) goto L25;
        char r103 = this.value.charAt(r100);
        if (r103 != '\"') goto L13;
        if (r101 == true) goto L23;
        r102 = !r102;
    L23:
        this.buf.append(r103);
        r101 = false;
    L24:
        r100 = r100 + 1;
        goto L8
    L13:
        if (r101 == true) goto L23;
        if (r102 == true) goto L23;
        if (r103 != '\\') goto L20;
        this.buf.append(r103);
        r101 = true;
        goto L24
    L20:
        if (r103 == this.separator) goto L25;
        this.buf.append(r103);
    L25:
        this.index = r100;
        return this.buf.toString();
    }
}
