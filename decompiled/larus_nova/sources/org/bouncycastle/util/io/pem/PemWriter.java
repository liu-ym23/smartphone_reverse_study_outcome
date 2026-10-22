package org.bouncycastle.util.io.pem;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Base64;

/* JADX INFO: loaded from: classes42.dex */
public class PemWriter extends BufferedWriter {
    private static final int LINE_LENGTH = 64;
    private char[] buf;
    private final int nlLength;

    public PemWriter(Writer r100) {
        super(r100);
        this.buf = new char[64];
        String r101 = Strings.lineSeparator();
        if (r101 == null) goto L5;
        int r102 = r101.length();
    L6:
        this.nlLength = r102;
        return;
    L5:
        r102 = 2;
        goto L6
    }

    private void writeEncoded(byte[] r100) throws IOException {
        byte[] r101 = Base64.encode(r100);
        int r102 = 0;
    L4:
        if (r102 >= r101.length) goto L13;
        int r103 = 0;
    L6:
        char[] r104 = this.buf;
        if (r103 == r104.length) goto L12;
        int r105 = r102 + r103;
        if (r105 >= r101.length) goto L12;
        r104[r103] = (char) r101[r105];
        r103 = r103 + 1;
    L12:
        write(r104, 0, r103);
        newLine();
        r102 = r102 + this.buf.length;
        goto L4
    }

    private void writePostEncapsulationBoundary(String r100) throws IOException {
        write("-----END " + r100 + "-----");
        newLine();
    }

    private void writePreEncapsulationBoundary(String r100) throws IOException {
        write("-----BEGIN " + r100 + "-----");
        newLine();
    }

    public int getOutputSize(PemObject r100) {
        int r101 = ((((r100.getType().length() + 10) + this.nlLength) * 2) + 6) + 4;
        if (r100.getHeaders().isEmpty() == true) goto L9;
        Iterator r102 = r100.getHeaders().iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        PemHeader r103 = (PemHeader) r102.next();
        r101 = r101 + (((r103.getName().length() + 2) + r103.getValue().length()) + this.nlLength);
        goto L6
    L8:
        r101 = r101 + this.nlLength;
    L9:
        int r104 = ((r100.getContent().length + 2) / 3) * 4;
        return r101 + (r104 + ((((r104 + 64) - 1) / 64) * this.nlLength));
    }

    public void writeObject(PemObjectGenerator r100) throws IOException {
        PemObject r101 = r100.generate();
        writePreEncapsulationBoundary(r101.getType());
        if (r101.getHeaders().isEmpty() == true) goto L9;
        Iterator r102 = r101.getHeaders().iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        PemHeader r103 = (PemHeader) r102.next();
        write(r103.getName());
        write(": ");
        write(r103.getValue());
        newLine();
        goto L6
    L8:
        newLine();
    L9:
        writeEncoded(r101.getContent());
        writePostEncapsulationBoundary(r101.getType());
    }
}
