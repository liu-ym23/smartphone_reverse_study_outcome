package org.bouncycastle.pqc.crypto.lms;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import org.bouncycastle.util.Encodable;
import org.bouncycastle.util.io.Streams;

/* JADX INFO: loaded from: classes42.dex */
class LMOtsSignature implements Encodable {
    private final byte[] C;
    private final LMOtsParameters type;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final byte[] f525532y;

    public LMOtsSignature(LMOtsParameters r100, byte[] r101, byte[] r102) {
        this.type = r100;
        this.C = r101;
        this.f525532y = r102;
    }

    public static LMOtsSignature getInstance(Object r100) throws IOException {
        if ((r100 instanceof LMOtsSignature) == false) goto L7;
        return (LMOtsSignature) r100;
    L7:
        if ((r100 instanceof DataInputStream) == false) goto L11;
        DataInputStream r101 = (DataInputStream) r100;
        LMOtsParameters r102 = LMOtsParameters.getParametersForType(r101.readInt());
        byte[] r103 = new byte[r102.getN()];
        r101.readFully(r103);
        byte[] r104 = new byte[r102.getP() * r102.getN()];
        r101.readFully(r104);
        return new LMOtsSignature(r102, r103, r104);
    L11:
        if ((r100 instanceof byte[]) == false) goto L24;
        DataInputStream r105 = null;
        DataInputStream r106 = new DataInputStream(new ByteArrayInputStream((byte[]) r100));     // Catch: Throwable -> L19
        LMOtsSignature r107 = getInstance(r106);     // Catch: Throwable -> L17
        r106.close();
        return r107;
    L17:
        th = th;
        r105 = r106;
    L20:
        if (r105 == null) goto L22;
        r105.close();
    L22:
        throw th;
    L19:
        th = th;
        goto L20
    L24:
        if ((r100 instanceof InputStream) == false) goto L28;
        return getInstance(Streams.readAll((InputStream) r100));
    L28:
        throw new IllegalArgumentException("cannot parse " + r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L23:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L23;
        LMOtsSignature r101 = (LMOtsSignature) r100;
        LMOtsParameters r102 = this.type;
        if (r102 == null) goto L16;
        if (r102.equals(r101.type) == true) goto L19;
    L17:
        return false;
    L19:
        if (Arrays.equals(this.C, r101.C) == true) goto L22;
        return false;
    L22:
        return Arrays.equals(this.f525532y, r101.f525532y);
    L16:
        if (r101.type == null) goto L19;
        goto L17
    }

    public byte[] getC() {
        return this.C;
    }

    @Override // org.bouncycastle.util.Encodable
    public byte[] getEncoded() throws IOException {
        return Composer.compose().u32str(this.type.getType()).bytes(this.C).bytes(this.f525532y).build();
    }

    public LMOtsParameters getType() {
        return this.type;
    }

    public byte[] getY() {
        return this.f525532y;
    }

    public int hashCode() {
        LMOtsParameters r100 = this.type;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (((r101 * 31) + Arrays.hashCode(this.C)) * 31) + Arrays.hashCode(this.f525532y);
    L5:
        r101 = 0;
        goto L7
    }
}
