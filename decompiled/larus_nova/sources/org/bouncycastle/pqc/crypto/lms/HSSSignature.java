package org.bouncycastle.pqc.crypto.lms;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import org.bouncycastle.util.Encodable;
import org.bouncycastle.util.io.Streams;

/* JADX INFO: loaded from: classes42.dex */
public class HSSSignature implements Encodable {
    private final int lMinus1;
    private final LMSSignature signature;
    private final LMSSignedPubKey[] signedPubKey;

    public HSSSignature(int r100, LMSSignedPubKey[] r101, LMSSignature r102) {
        this.lMinus1 = r100;
        this.signedPubKey = r101;
        this.signature = r102;
    }

    public static HSSSignature getInstance(Object r100, int r101) throws IOException {
        if ((r100 instanceof HSSSignature) == false) goto L7;
        return (HSSSignature) r100;
    L7:
        if ((r100 instanceof DataInputStream) == false) goto L20;
        int r102 = ((DataInputStream) r100).readInt();
        if (r102 != (r101 - 1)) goto L18;
        LMSSignedPubKey[] r103 = new LMSSignedPubKey[r102];
        if (r102 == 0) goto L16;
        int r104 = 0;
    L13:
        if (r104 >= r102) goto L16;
        r103[r104] = new LMSSignedPubKey(LMSSignature.getInstance(r100), LMSPublicKeyParameters.getInstance(r100));
        r104 = r104 + 1;
    L16:
        return new HSSSignature(r102, r103, LMSSignature.getInstance(r100));
    L18:
        throw new IllegalStateException("nspk exceeded maxNspk");
    L20:
        if ((r100 instanceof byte[]) == false) goto L33;
        DataInputStream r105 = null;
        DataInputStream r106 = new DataInputStream(new ByteArrayInputStream((byte[]) r100));     // Catch: Throwable -> L28
        HSSSignature r107 = getInstance(r106, r101);     // Catch: Throwable -> L26
        r106.close();
        return r107;
    L26:
        th = th;
        r105 = r106;
    L29:
        if (r105 == null) goto L31;
        r105.close();
    L31:
        throw th;
    L28:
        th = th;
        goto L29
    L33:
        if ((r100 instanceof InputStream) == false) goto L37;
        return getInstance(Streams.readAll((InputStream) r100), r101);
    L37:
        throw new IllegalArgumentException("cannot parse " + r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L30:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L30;
        HSSSignature r101 = (HSSSignature) r100;
        if (this.lMinus1 == r101.lMinus1) goto L14;
        return false;
    L14:
        if (this.signedPubKey.length == r101.signedPubKey.length) goto L16;
        return false;
    L16:
        int r102 = 0;
    L17:
        LMSSignedPubKey[] r103 = this.signedPubKey;
        if (r102 >= r103.length) goto L23;
        if (r103[r102].equals(r101.signedPubKey[r102]) == false) goto L21;
        r102 = r102 + 1;
        goto L17
    L21:
        return false;
    L23:
        LMSSignature r104 = this.signature;
        LMSSignature r105 = r101.signature;
        if (r104 != null) goto L33;
        if (r105 == null) goto L34;
        return false;
    L34:
        return true;
    L33:
        return r104.equals(r105);
    }

    @Override // org.bouncycastle.util.Encodable
    public byte[] getEncoded() throws IOException {
        Composer r100 = Composer.compose();
        r100.u32str(this.lMinus1);
        LMSSignedPubKey[] r101 = this.signedPubKey;
        if (r101 == null) goto L7;
        int r102 = r101.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L7;
        r100.bytes(r101[r103]);
        r103 = r103 + 1;
    L7:
        r100.bytes(this.signature);
        return r100.build();
    }

    public LMSSignature getSignature() {
        return this.signature;
    }

    public LMSSignedPubKey[] getSignedPubKey() {
        return this.signedPubKey;
    }

    public int getlMinus1() {
        return this.lMinus1;
    }

    public int hashCode() {
        int r100 = ((this.lMinus1 * 31) + Arrays.hashCode(this.signedPubKey)) * 31;
        LMSSignature r101 = this.signature;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }
}
