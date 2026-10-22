package org.bouncycastle.util.io.pem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import org.bouncycastle.util.encoders.Base64;

/* JADX INFO: loaded from: classes42.dex */
public class PemReader extends BufferedReader {
    private static final String BEGIN = "-----BEGIN ";
    private static final String END = "-----END ";

    public PemReader(Reader r100) {
        super(r100);
    }

    private PemObject loadObject(String r100) throws IOException {
        String r101 = END + r100;
        StringBuffer r102 = new StringBuffer();
        ArrayList r103 = new ArrayList();
    L3:
        String r104 = readLine();
        if (r104 == null) goto L12;
        if (r104.indexOf(":") >= 0) goto L7;
        if (r104.indexOf(r101) != (-1)) goto L12;
        r102.append(r104.trim());
        goto L3
    L7:
        int r105 = r104.indexOf(58);
        r103.add(new PemHeader(r104.substring(0, r105), r104.substring(r105 + 1).trim()));
    L12:
        if (r104 == null) goto L16;
        return new PemObject(r100, r103, Base64.decode(r102.toString()));
    L16:
        throw new IOException(r101 + " not found");
    }

    public PemObject readPemObject() throws IOException {
    L2:
        String r100 = readLine();
        if (r100 == null) goto L7;
        if (r100.startsWith(BEGIN) == false) goto L2;
    L7:
        if (r100 == null) goto L16;
        String r101 = r100.substring(11);
        int r102 = r101.indexOf(45);
        if (r102 > 0) goto L11;
        return null;
    L11:
        if (r101.endsWith("-----") == true) goto L13;
        return null;
    L13:
        if ((r101.length() - r102) == 5) goto L15;
        return null;
    L15:
        return loadObject(r101.substring(0, r102));
    L16:
        return null;
    }
}
