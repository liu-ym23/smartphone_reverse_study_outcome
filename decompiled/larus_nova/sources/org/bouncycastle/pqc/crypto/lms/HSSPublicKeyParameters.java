package org.bouncycastle.pqc.crypto.lms;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.util.io.Streams;

/* JADX INFO: loaded from: classes42.dex */
public class HSSPublicKeyParameters extends LMSKeyParameters implements LMSContextBasedVerifier {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f525525l;
    private final LMSPublicKeyParameters lmsPublicKey;

    public HSSPublicKeyParameters(int r100, LMSPublicKeyParameters r101) {
        super(false);
        this.f525525l = r100;
        this.lmsPublicKey = r101;
    }

    public static HSSPublicKeyParameters getInstance(Object r100) throws IOException {
        if ((r100 instanceof HSSPublicKeyParameters) == false) goto L7;
        return (HSSPublicKeyParameters) r100;
    L7:
        if ((r100 instanceof DataInputStream) == false) goto L11;
        return new HSSPublicKeyParameters(((DataInputStream) r100).readInt(), LMSPublicKeyParameters.getInstance(r100));
    L11:
        if ((r100 instanceof byte[]) == false) goto L24;
        DataInputStream r101 = null;
        DataInputStream r102 = new DataInputStream(new ByteArrayInputStream((byte[]) r100));     // Catch: Throwable -> L19
        HSSPublicKeyParameters r103 = getInstance(r102);     // Catch: Throwable -> L17
        r102.close();
        return r103;
    L17:
        th = th;
        r101 = r102;
    L20:
        if (r101 == null) goto L22;
        r101.close();
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
    L15:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L15;
        HSSPublicKeyParameters r101 = (HSSPublicKeyParameters) r100;
        if (this.f525525l == r101.f525525l) goto L14;
        return false;
    L14:
        return this.lmsPublicKey.equals(r101.lmsPublicKey);
    }

    @Override // org.bouncycastle.pqc.crypto.lms.LMSContextBasedVerifier
    public LMSContext generateLMSContext(byte[] r100) {
        HSSSignature r101 = HSSSignature.getInstance(r100, getL());     // Catch: IOException -> L5
        LMSSignedPubKey[] r102 = r101.getSignedPubKey();
        return r102[r102.length - 1].getPublicKey().generateOtsContext(r101.getSignature()).withSignedPublicKeys(r102);
    L5:
        e = move-exception;
        throw new IllegalStateException("cannot parse signature: " + e.getMessage());
    }

    @Override // org.bouncycastle.pqc.crypto.lms.LMSKeyParameters, org.bouncycastle.util.Encodable
    public byte[] getEncoded() throws IOException {
        return Composer.compose().u32str(this.f525525l).bytes(this.lmsPublicKey.getEncoded()).build();
    }

    public int getL() {
        return this.f525525l;
    }

    public LMSPublicKeyParameters getLMSPublicKey() {
        return this.lmsPublicKey;
    }

    public int hashCode() {
        return (this.f525525l * 31) + this.lmsPublicKey.hashCode();
    }

    @Override // org.bouncycastle.pqc.crypto.lms.LMSContextBasedVerifier
    public boolean verify(LMSContext r100) {
        LMSSignedPubKey[] r101 = r100.getSignedPubKeys();
        int r102 = 0;
        if (r101.length == (getL() - 1)) goto L5;
        return false;
    L5:
        LMSPublicKeyParameters r103 = getLMSPublicKey();
        boolean r104 = false;
    L7:
        if (r102 >= r101.length) goto L13;
        if (LMS.verifySignature(r103, r101[r102].getSignature(), r101[r102].getPublicKey().toByteArray()) == true) goto L11;
        r104 = true;
    L11:
        r103 = r101[r102].getPublicKey();
        r102 = r102 + 1;
        goto L7
    L13:
        return r103.verify(r100) & (!r104);
    }
}
