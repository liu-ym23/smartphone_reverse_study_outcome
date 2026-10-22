package org.bouncycastle.pqc.crypto.lms;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.util.Encodable;
import org.bouncycastle.util.io.Streams;

/* JADX INFO: loaded from: classes42.dex */
class LMOtsPublicKey implements Encodable {
    private final byte[] I;
    private final byte[] K;
    private final LMOtsParameters parameter;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final int f525531q;

    public LMOtsPublicKey(LMOtsParameters r100, byte[] r101, int r102, byte[] r103) {
        this.parameter = r100;
        this.I = r101;
        this.f525531q = r102;
        this.K = r103;
    }

    public static LMOtsPublicKey getInstance(Object r100) throws Exception {
        if ((r100 instanceof LMOtsPublicKey) == false) goto L7;
        return (LMOtsPublicKey) r100;
    L7:
        if ((r100 instanceof DataInputStream) == false) goto L11;
        DataInputStream r101 = (DataInputStream) r100;
        LMOtsParameters r102 = LMOtsParameters.getParametersForType(r101.readInt());
        byte[] r103 = new byte[16];
        r101.readFully(r103);
        int r104 = r101.readInt();
        byte[] r105 = new byte[r102.getN()];
        r101.readFully(r105);
        return new LMOtsPublicKey(r102, r103, r104, r105);
    L11:
        if ((r100 instanceof byte[]) == false) goto L24;
        DataInputStream r106 = null;
        DataInputStream r107 = new DataInputStream(new ByteArrayInputStream((byte[]) r100));     // Catch: Throwable -> L19
        LMOtsPublicKey r108 = getInstance(r107);     // Catch: Throwable -> L17
        r107.close();
        return r108;
    L17:
        th = th;
        r106 = r107;
    L20:
        if (r106 == null) goto L22;
        r106.close();
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

    public LMSContext createOtsContext(LMOtsSignature r100) {
        Digest r101 = DigestUtil.getDigest(this.parameter.getDigestOID());
        LmsUtils.byteArray(this.I, r101);
        LmsUtils.u32str(this.f525531q, r101);
        LmsUtils.u16str(-32383, r101);
        LmsUtils.byteArray(r100.getC(), r101);
        return new LMSContext(this, r100, r101);
    }

    public LMSContext createOtsContext(LMSSignature r100) {
        Digest r101 = DigestUtil.getDigest(this.parameter.getDigestOID());
        LmsUtils.byteArray(this.I, r101);
        LmsUtils.u32str(this.f525531q, r101);
        LmsUtils.u16str(-32383, r101);
        LmsUtils.byteArray(r100.getOtsSignature().getC(), r101);
        return new LMSContext(this, r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L26:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L26;
        LMOtsPublicKey r101 = (LMOtsPublicKey) r100;
        if (this.f525531q == r101.f525531q) goto L13;
        return false;
    L13:
        LMOtsParameters r102 = this.parameter;
        if (r102 == null) goto L19;
        if (r102.equals(r101.parameter) == true) goto L22;
    L20:
        return false;
    L22:
        if (Arrays.equals(this.I, r101.I) == true) goto L25;
        return false;
    L25:
        return Arrays.equals(this.K, r101.K);
    L19:
        if (r101.parameter == null) goto L22;
        goto L20
    }

    @Override // org.bouncycastle.util.Encodable
    public byte[] getEncoded() throws IOException {
        return Composer.compose().u32str(this.parameter.getType()).bytes(this.I).u32str(this.f525531q).bytes(this.K).build();
    }

    public byte[] getI() {
        return this.I;
    }

    public byte[] getK() {
        return this.K;
    }

    public LMOtsParameters getParameter() {
        return this.parameter;
    }

    public int getQ() {
        return this.f525531q;
    }

    public int hashCode() {
        LMOtsParameters r100 = this.parameter;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (((((r101 * 31) + Arrays.hashCode(this.I)) * 31) + this.f525531q) * 31) + Arrays.hashCode(this.K);
    L5:
        r101 = 0;
        goto L7
    }
}
