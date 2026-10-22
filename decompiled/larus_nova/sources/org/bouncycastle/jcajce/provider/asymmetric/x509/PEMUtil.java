package org.bouncycastle.jcajce.provider.asymmetric.x509;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.util.encoders.Base64;

/* JADX INFO: loaded from: classes42.dex */
class PEMUtil {
    private final Boundaries[] _supportedBoundaries;

    /* JADX INFO: renamed from: org.bouncycastle.jcajce.provider.asymmetric.x509.PEMUtil$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class Boundaries {
        private final String _footer;
        private final String _header;
        final /* synthetic */ PEMUtil this$0;

        private Boundaries(PEMUtil r100, String r101) {
            this.this$0 = r100;
            this._header = "-----BEGIN " + r101 + "-----";
            this._footer = "-----END " + r101 + "-----";
        }

        public /* synthetic */ Boundaries(PEMUtil r100, String r101, AnonymousClass1 r102) {
            this(r100, r101);
        }

        public boolean isTheExpectedFooter(String r100) {
            return r100.startsWith(this._footer);
        }

        public boolean isTheExpectedHeader(String r100) {
            return r100.startsWith(this._header);
        }
    }

    public PEMUtil(String r100) {
        AnonymousClass1 r101 = null;
        this._supportedBoundaries = new Boundaries[]{new Boundaries(this, r100, r101), new Boundaries(this, "X509 " + r100, r101), new Boundaries(this, "PKCS7", r101)};
    }

    private Boundaries getBoundaries(String r100) {
        int r101 = 0;
    L3:
        Boundaries[] r102 = this._supportedBoundaries;
        if (r101 == r102.length) goto L12;
        Boundaries r103 = r102[r101];
        if (r103.isTheExpectedHeader(r100) == true) goto L11;
        if (r103.isTheExpectedFooter(r100) == true) goto L11;
        r101 = r101 + 1;
    L11:
        return r103;
    L12:
        return null;
    }

    private String readLine(InputStream r100) throws IOException {
        StringBuffer r101 = new StringBuffer();
    L3:
        int r102 = r100.read();
        if (r102 == 13) goto L8;
        if (r102 == 10) goto L8;
        if (r102 < 0) goto L8;
        r101.append((char) r102);
    L8:
        if (r102 < 0) goto L11;
        if (r101.length() == 0) goto L3;
    L11:
        if (r102 < 0) goto L13;
        if (r102 != 13) goto L25;
        r100.mark(1);
        int r103 = r100.read();
        if (r103 != 10) goto L22;
        r100.mark(1);
    L22:
        if (r103 <= 0) goto L25;
        r100.reset();
    L25:
        return r101.toString();
    L13:
        if (r101.length() != 0) goto L17;
        return null;
    L17:
        return r101.toString();
    }

    public ASN1Sequence readPEMObject(InputStream r100) throws IOException {
        StringBuffer r101 = new StringBuffer();
        Boundaries r102 = null;
    L3:
        if (r102 != null) goto L13;
        String r103 = readLine(r100);
        if (r103 == null) goto L13;
        r102 = getBoundaries(r103);
        if (r102 == null) goto L3;
        if (r102.isTheExpectedHeader(r103) == true) goto L3;
        throw new IOException("malformed PEM data: found footer where header was expected");
    L13:
        if (r102 == null) goto L37;
        Boundaries r104 = null;
    L15:
        if (r104 != null) goto L26;
        String r105 = readLine(r100);
        if (r105 == null) goto L26;
        r104 = getBoundaries(r105);
        if (r104 != null) goto L21;
        r101.append(r105);
        goto L15
    L21:
        if (r102.isTheExpectedFooter(r105) == true) goto L15;
        throw new IOException("malformed PEM data: header/footer mismatch");
    L26:
        if (r104 == null) goto L35;
        if (r101.length() != 0) goto L38;
        return null;
    L38:
        return ASN1Sequence.getInstance(Base64.decode(r101.toString()));
    L32:
        throw new IOException("malformed PEM data encountered");
    L35:
        throw new IOException("malformed PEM data: no footer found");
    L37:
        throw new IOException("malformed PEM data: no header found");
    }
}
