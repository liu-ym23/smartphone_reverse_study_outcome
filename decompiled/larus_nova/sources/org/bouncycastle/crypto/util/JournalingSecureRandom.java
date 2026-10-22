package org.bouncycastle.crypto.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class JournalingSecureRandom extends SecureRandom {
    private static byte[] EMPTY_TRANSCRIPT;
    private final SecureRandom base;
    private int index;
    private TranscriptStream tOut;
    private byte[] transcript;

    /* JADX INFO: renamed from: org.bouncycastle.crypto.util.JournalingSecureRandom$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class TranscriptStream extends ByteArrayOutputStream {
        final /* synthetic */ JournalingSecureRandom this$0;

        private TranscriptStream(JournalingSecureRandom r100) {
            this.this$0 = r100;
        }

        public /* synthetic */ TranscriptStream(JournalingSecureRandom r100, AnonymousClass1 r101) {
            this(r100);
        }

        public void clear() {
            Arrays.fill(((ByteArrayOutputStream) this).buf, (byte) 0);
        }
    }

    static {
        EMPTY_TRANSCRIPT = new byte[0];
    }

    public JournalingSecureRandom() {
        this(CryptoServicesRegistrar.getSecureRandom());
    }

    public JournalingSecureRandom(SecureRandom r100) {
        this.tOut = new TranscriptStream(this, null);
        this.index = 0;
        this.base = r100;
        this.transcript = EMPTY_TRANSCRIPT;
    }

    public JournalingSecureRandom(byte[] r100, SecureRandom r101) {
        this.tOut = new TranscriptStream(this, null);
        this.index = 0;
        this.base = r101;
        this.transcript = Arrays.clone(r100);
    }

    public void clear() {
        Arrays.fill(this.transcript, (byte) 0);
        this.tOut.clear();
    }

    public byte[] getFullTranscript() {
        int r100 = this.index;
        byte[] r101 = this.transcript;
        if (r100 != r101.length) goto L7;
        return this.tOut.toByteArray();
    L7:
        return Arrays.clone(r101);
    }

    public byte[] getTranscript() {
        return this.tOut.toByteArray();
    }

    @Override // java.security.SecureRandom, java.util.Random
    public final void nextBytes(byte[] r100) {
        if (this.index < this.transcript.length) goto L5;
        this.base.nextBytes(r100);
    L19:
        this.tOut.write(r100);     // Catch: IOException -> L16
        return;
    L16:
        e = move-exception;
        throw new IllegalStateException("unable to record transcript: " + e.getMessage());
    L5:
        int r101 = 0;
    L7:
        if (r101 == r100.length) goto L12;
        int r102 = this.index;
        byte[] r103 = this.transcript;
        if (r102 >= r103.length) goto L12;
        this.index = r102 + 1;
        r100[r101] = r103[r102];
        r101 = r101 + 1;
    L12:
        if (r101 == r100.length) goto L19;
        int r104 = r100.length - r101;
        byte[] r105 = new byte[r104];
        this.base.nextBytes(r105);
        System.arraycopy(r105, 0, r100, r101, r104);
        goto L19
    }

    public void reset() {
        this.index = 0;
        if (this.transcript.length != 0) goto L5;
        this.transcript = this.tOut.toByteArray();
    L5:
        this.tOut.reset();
    }
}
