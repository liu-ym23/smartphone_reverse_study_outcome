package org.bouncycastle.pqc.crypto.lms;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import org.bouncycastle.util.Encodable;
import org.bouncycastle.util.io.Streams;

/* JADX INFO: loaded from: classes42.dex */
class LMSSignature implements Encodable {
    private final LMOtsSignature otsSignature;
    private final LMSigParameters parameter;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final int f525534q;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final byte[][] f525535y;

    public LMSSignature(int r100, LMOtsSignature r101, LMSigParameters r102, byte[][] r103) {
        this.f525534q = r100;
        this.otsSignature = r101;
        this.parameter = r102;
        this.f525535y = r103;
    }

    public static LMSSignature getInstance(Object r100) throws IOException {
        if ((r100 instanceof LMSSignature) == false) goto L7;
        return (LMSSignature) r100;
    L7:
        if ((r100 instanceof DataInputStream) == false) goto L14;
        DataInputStream r101 = (DataInputStream) r100;
        int r102 = r101.readInt();
        LMOtsSignature r103 = LMOtsSignature.getInstance(r100);
        LMSigParameters r104 = LMSigParameters.getParametersForType(r101.readInt());
        int r105 = r104.getH();
        byte[][] r106 = new byte[r105][];
        int r107 = 0;
    L9:
        if (r107 >= r105) goto L12;
        byte[] r108 = new byte[r104.getM()];
        r106[r107] = r108;
        r101.readFully(r108);
        r107 = r107 + 1;
        goto L9
    L12:
        return new LMSSignature(r102, r103, r104, r106);
    L14:
        if ((r100 instanceof byte[]) == false) goto L27;
        DataInputStream r109 = null;
        DataInputStream r110 = new DataInputStream(new ByteArrayInputStream((byte[]) r100));     // Catch: Throwable -> L22
        LMSSignature r111 = getInstance(r110);     // Catch: Throwable -> L20
        r110.close();
        return r111;
    L20:
        th = th;
        r109 = r110;
    L23:
        if (r109 == null) goto L25;
        r109.close();
    L25:
        throw th;
    L22:
        th = th;
        goto L23
    L27:
        if ((r100 instanceof InputStream) == false) goto L31;
        return getInstance(Streams.readAll((InputStream) r100));
    L31:
        throw new IllegalArgumentException("cannot parse " + r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L31:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L31;
        LMSSignature r101 = (LMSSignature) r100;
        if (this.f525534q == r101.f525534q) goto L13;
        return false;
    L13:
        LMOtsSignature r102 = this.otsSignature;
        if (r102 == null) goto L19;
        if (r102.equals(r101.otsSignature) == false) goto L20;
    L21:
        LMSigParameters r103 = this.parameter;
        if (r103 == null) goto L27;
        if (r103.equals(r101.parameter) == true) goto L30;
    L28:
        return false;
    L30:
        return Arrays.deepEquals(this.f525535y, r101.f525535y);
    L27:
        if (r101.parameter == null) goto L30;
    L20:
        return false;
    L19:
        if (r101.otsSignature == null) goto L21;
        goto L20
    }

    @Override // org.bouncycastle.util.Encodable
    public byte[] getEncoded() throws IOException {
        return Composer.compose().u32str(this.f525534q).bytes(this.otsSignature.getEncoded()).u32str(this.parameter.getType()).bytes(this.f525535y).build();
    }

    public LMOtsSignature getOtsSignature() {
        return this.otsSignature;
    }

    public LMSigParameters getParameter() {
        return this.parameter;
    }

    public int getQ() {
        return this.f525534q;
    }

    public byte[][] getY() {
        return this.f525535y;
    }

    public int hashCode() {
        int r100 = this.f525534q * 31;
        LMOtsSignature r101 = this.otsSignature;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        LMSigParameters r105 = this.parameter;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        return ((r104 + r102) * 31) + Arrays.deepHashCode(this.f525535y);
    L5:
        r103 = 0;
        goto L6
    }
}
