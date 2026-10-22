package org.bouncycastle.jce.provider;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.util.encoders.Base64;

/* JADX INFO: loaded from: classes42.dex */
public class PEMUtil {
    private final String _footer1;
    private final String _footer2;
    private final String _header1;
    private final String _header2;

    public PEMUtil(String r100) {
        this._header1 = "-----BEGIN " + r100 + "-----";
        this._header2 = "-----BEGIN X509 " + r100 + "-----";
        this._footer1 = "-----END " + r100 + "-----";
        this._footer2 = "-----END X509 " + r100 + "-----";
    }

    private String readLine(InputStream r100) throws IOException {
        StringBuffer r101 = new StringBuffer();
    L3:
        int r102 = r100.read();
        if (r102 == 13) goto L11;
        if (r102 == 10) goto L11;
        if (r102 < 0) goto L11;
        if (r102 == 13) goto L3;
        r101.append((char) r102);
    L11:
        if (r102 < 0) goto L14;
        if (r101.length() == 0) goto L3;
    L14:
        if (r102 >= 0) goto L18;
        return null;
    L18:
        return r101.toString();
    }

    public ASN1Sequence readPEMObject(InputStream r100) throws IOException {
        StringBuffer r101 = new StringBuffer();
    L3:
        String r102 = readLine(r100);
        if (r102 == null) goto L9;
        if (r102.startsWith(this._header1) == true) goto L9;
        if (r102.startsWith(this._header2) == false) goto L3;
    L9:
        String r103 = readLine(r100);
        if (r103 == null) goto L18;
        if (r103.startsWith(this._footer1) == true) goto L18;
        if (r103.startsWith(this._footer2) == true) goto L18;
        r101.append(r103);
    L18:
        if (r101.length() == 0) goto L25;
        ASN1Primitive r104 = new ASN1InputStream(Base64.decode(r101.toString())).readObject();
        if ((r104 instanceof ASN1Sequence) == false) goto L24;
        return (ASN1Sequence) r104;
    L24:
        throw new IOException("malformed PEM data encountered");
    L25:
        return null;
    }
}
