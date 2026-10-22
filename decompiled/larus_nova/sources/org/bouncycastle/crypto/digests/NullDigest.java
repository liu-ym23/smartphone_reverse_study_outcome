package org.bouncycastle.crypto.digests;

import java.io.ByteArrayOutputStream;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class NullDigest implements Digest {
    private OpenByteArrayOutputStream bOut;

    /* JADX INFO: renamed from: org.bouncycastle.crypto.digests.NullDigest$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class OpenByteArrayOutputStream extends ByteArrayOutputStream {
        private OpenByteArrayOutputStream() {
        }

        public /* synthetic */ OpenByteArrayOutputStream(AnonymousClass1 r100) {
            this();
        }

        public void copy(byte[] r100, int r101) {
            System.arraycopy(((ByteArrayOutputStream) this).buf, 0, r100, r101, size());
        }

        @Override // java.io.ByteArrayOutputStream
        public void reset() {
            super.reset();
            Arrays.clear(((ByteArrayOutputStream) this).buf);
        }
    }

    public NullDigest() {
        this.bOut = new OpenByteArrayOutputStream(null);
    }

    @Override // org.bouncycastle.crypto.Digest
    public int doFinal(byte[] r100, int r101) {
        int r102 = this.bOut.size();
        this.bOut.copy(r100, r101);
        reset();
        return r102;
    }

    @Override // org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return "NULL";
    }

    @Override // org.bouncycastle.crypto.Digest
    public int getDigestSize() {
        return this.bOut.size();
    }

    @Override // org.bouncycastle.crypto.Digest
    public void reset() {
        this.bOut.reset();
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte r100) {
        this.bOut.write(r100);
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte[] r100, int r101, int r102) {
        this.bOut.write(r100, r101, r102);
    }
}
