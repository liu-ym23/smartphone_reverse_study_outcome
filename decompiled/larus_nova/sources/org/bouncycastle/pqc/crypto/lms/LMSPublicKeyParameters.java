package org.bouncycastle.pqc.crypto.lms;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.io.Streams;

/* JADX INFO: loaded from: classes42.dex */
public class LMSPublicKeyParameters extends LMSKeyParameters implements LMSContextBasedVerifier {
    private final byte[] I;
    private final byte[] T1;
    private final LMOtsParameters lmOtsType;
    private final LMSigParameters parameterSet;

    public LMSPublicKeyParameters(LMSigParameters r100, LMOtsParameters r101, byte[] r102, byte[] r103) {
        super(false);
        this.parameterSet = r100;
        this.lmOtsType = r101;
        this.I = Arrays.clone(r103);
        this.T1 = Arrays.clone(r102);
    }

    public static LMSPublicKeyParameters getInstance(Object r100) throws IOException {
        if ((r100 instanceof LMSPublicKeyParameters) == false) goto L7;
        return (LMSPublicKeyParameters) r100;
    L7:
        if ((r100 instanceof DataInputStream) == false) goto L11;
        DataInputStream r101 = (DataInputStream) r100;
        LMSigParameters r102 = LMSigParameters.getParametersForType(r101.readInt());
        LMOtsParameters r103 = LMOtsParameters.getParametersForType(r101.readInt());
        byte[] r104 = new byte[16];
        r101.readFully(r104);
        byte[] r105 = new byte[r102.getM()];
        r101.readFully(r105);
        return new LMSPublicKeyParameters(r102, r103, r105, r104);
    L11:
        if ((r100 instanceof byte[]) == false) goto L24;
        DataInputStream r106 = null;
        DataInputStream r107 = new DataInputStream(new ByteArrayInputStream((byte[]) r100));     // Catch: Throwable -> L19
        LMSPublicKeyParameters r108 = getInstance(r107);     // Catch: Throwable -> L17
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

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L21:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L21;
        LMSPublicKeyParameters r101 = (LMSPublicKeyParameters) r100;
        if (this.parameterSet.equals(r101.parameterSet) == true) goto L14;
        return false;
    L14:
        if (this.lmOtsType.equals(r101.lmOtsType) == true) goto L17;
        return false;
    L17:
        if (Arrays.areEqual(this.I, r101.I) == true) goto L20;
        return false;
    L20:
        return Arrays.areEqual(this.T1, r101.T1);
    }

    @Override // org.bouncycastle.pqc.crypto.lms.LMSContextBasedVerifier
    public LMSContext generateLMSContext(byte[] r100) {
        return generateOtsContext(LMSSignature.getInstance(r100));
    L4:
        e = move-exception;
        throw new IllegalStateException("cannot parse signature: " + e.getMessage());
    }

    public LMSContext generateOtsContext(LMSSignature r100) {
        int r101 = getOtsParameters().getType();
        if (r100.getOtsSignature().getType().getType() != r101) goto L7;
        return new LMOtsPublicKey(LMOtsParameters.getParametersForType(r101), this.I, r100.getQ(), null).createOtsContext(r100);
    L7:
        throw new IllegalArgumentException("ots type from lsm signature does not match ots signature type from embedded ots signature");
    }

    @Override // org.bouncycastle.pqc.crypto.lms.LMSKeyParameters, org.bouncycastle.util.Encodable
    public byte[] getEncoded() throws IOException {
        return toByteArray();
    }

    public byte[] getI() {
        return Arrays.clone(this.I);
    }

    public LMSParameters getLMSParameters() {
        return new LMSParameters(getSigParameters(), getOtsParameters());
    }

    public LMOtsParameters getOtsParameters() {
        return this.lmOtsType;
    }

    public LMSigParameters getSigParameters() {
        return this.parameterSet;
    }

    public byte[] getT1() {
        return Arrays.clone(this.T1);
    }

    public int hashCode() {
        return (((((this.parameterSet.hashCode() * 31) + this.lmOtsType.hashCode()) * 31) + Arrays.hashCode(this.I)) * 31) + Arrays.hashCode(this.T1);
    }

    public boolean matchesT1(byte[] r100) {
        return Arrays.constantTimeAreEqual(this.T1, r100);
    }

    public byte[] refI() {
        return this.I;
    }

    public byte[] toByteArray() {
        return Composer.compose().u32str(this.parameterSet.getType()).u32str(this.lmOtsType.getType()).bytes(this.I).bytes(this.T1).build();
    }

    @Override // org.bouncycastle.pqc.crypto.lms.LMSContextBasedVerifier
    public boolean verify(LMSContext r100) {
        return LMS.verifySignature(this, r100);
    }
}
