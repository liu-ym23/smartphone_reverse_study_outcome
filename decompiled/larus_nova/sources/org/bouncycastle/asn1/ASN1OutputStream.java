package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes42.dex */
public class ASN1OutputStream {

    /* JADX INFO: renamed from: os, reason: collision with root package name */
    private OutputStream f525022os;

    public ASN1OutputStream(OutputStream r100) {
        this.f525022os = r100;
    }

    public static ASN1OutputStream create(OutputStream r100) {
        return new ASN1OutputStream(r100);
    }

    public static ASN1OutputStream create(OutputStream r100, String r101) {
        if (r101.equals(ASN1Encoding.DER) == false) goto L7;
        return new DEROutputStream(r100);
    L7:
        if (r101.equals(ASN1Encoding.DL) == false) goto L11;
        return new DLOutputStream(r100);
    L11:
        return new ASN1OutputStream(r100);
    }

    public void close() throws IOException {
        this.f525022os.close();
    }

    public void flush() throws IOException {
        this.f525022os.flush();
    }

    public void flushInternal() throws IOException {
    }

    public DEROutputStream getDERSubStream() {
        return new DEROutputStream(this.f525022os);
    }

    public ASN1OutputStream getDLSubStream() {
        return new DLOutputStream(this.f525022os);
    }

    public final void write(int r100) throws IOException {
        this.f525022os.write(r100);
    }

    public final void write(byte[] r100, int r101, int r102) throws IOException {
        this.f525022os.write(r100, r101, r102);
    }

    public final void writeElements(Enumeration r100) throws IOException {
    L3:
        if (r100.hasMoreElements() == false) goto L5;
        writePrimitive(((ASN1Encodable) r100.nextElement()).toASN1Primitive(), true);
        goto L3
    }

    public final void writeElements(ASN1Encodable[] r100) throws IOException {
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        writePrimitive(r100[r102].toASN1Primitive(), true);
        r102 = r102 + 1;
        goto L3
    }

    public final void writeEncoded(boolean r100, int r101, byte r102) throws IOException {
        if (r100 == false) goto L4;
        write(r101);
    L4:
        writeLength(1);
        write(r102);
    }

    public final void writeEncoded(boolean r100, int r101, byte r102, byte[] r103) throws IOException {
        if (r100 == false) goto L4;
        write(r101);
    L4:
        writeLength(r103.length + 1);
        write(r102);
        write(r103, 0, r103.length);
    }

    public final void writeEncoded(boolean r100, int r101, byte r102, byte[] r103, int r104, int r105, byte r106) throws IOException {
        if (r100 == false) goto L4;
        write(r101);
    L4:
        writeLength(r105 + 2);
        write(r102);
        write(r103, r104, r105);
        write(r106);
    }

    public final void writeEncoded(boolean r100, int r101, int r102, byte[] r103) throws IOException {
        writeTag(r100, r101, r102);
        writeLength(r103.length);
        write(r103, 0, r103.length);
    }

    public final void writeEncoded(boolean r100, int r101, byte[] r102) throws IOException {
        if (r100 == false) goto L4;
        write(r101);
    L4:
        writeLength(r102.length);
        write(r102, 0, r102.length);
    }

    public final void writeEncoded(boolean r100, int r101, byte[] r102, int r103, int r104) throws IOException {
        if (r100 == false) goto L4;
        write(r101);
    L4:
        writeLength(r104);
        write(r102, r103, r104);
    }

    public final void writeEncodedIndef(boolean r100, int r101, int r102, byte[] r103) throws IOException {
        writeTag(r100, r101, r102);
        write(128);
        write(r103, 0, r103.length);
        write(0);
        write(0);
    }

    public final void writeEncodedIndef(boolean r100, int r101, Enumeration r102) throws IOException {
        if (r100 == false) goto L4;
        write(r101);
    L4:
        write(128);
        writeElements(r102);
        write(0);
        write(0);
    }

    public final void writeEncodedIndef(boolean r100, int r101, ASN1Encodable[] r102) throws IOException {
        if (r100 == false) goto L4;
        write(r101);
    L4:
        write(128);
        writeElements(r102);
        write(0);
        write(0);
    }

    public final void writeLength(int r100) throws IOException {
        if (r100 <= 127) goto L11;
        int r101 = r100;
        int r102 = 1;
    L5:
        r101 = r101 >>> 8;
        if (r101 == 0) goto L8;
        r102 = r102 + 1;
        goto L5
    L8:
        write((byte) (r102 | 128));
        int r103 = (r102 - 1) * 8;
    L9:
        if (r103 < 0) goto L15;
        write((byte) (r100 >> r103));
        r103 = r103 - 8;
        goto L9
    L15:
        return;
    L11:
        write((byte) r100);
    }

    public void writeObject(ASN1Encodable r100) throws IOException {
        if (r100 == null) goto L6;
        writePrimitive(r100.toASN1Primitive(), true);
        flushInternal();
        return;
    L6:
        throw new IOException("null object detected");
    }

    public void writeObject(ASN1Primitive r100) throws IOException {
        if (r100 == null) goto L6;
        writePrimitive(r100, true);
        flushInternal();
        return;
    L6:
        throw new IOException("null object detected");
    }

    public void writePrimitive(ASN1Primitive r100, boolean r101) throws IOException {
        r100.encode(this, r101);
    }

    public final void writeTag(boolean r100, int r101, int r102) throws IOException {
        if (r100 == true) goto L5;
        return;
    L5:
        if (r102 >= 31) goto L7;
        write(r101 | r102);
        return;
    L7:
        write(31 | r101);
        if (r102 >= 128) goto L10;
        write(r102);
        return;
    L10:
        byte[] r103 = new byte[5];
        int r104 = 4;
        r103[4] = (byte) (r102 & 127);
    L11:
        r102 = r102 >> 7;
        r104 = r104 - 1;
        r103[r104] = (byte) ((r102 & 127) | 128);
        if (r102 > 127) goto L11;
        write(r103, r104, 5 - r104);
    }
}
