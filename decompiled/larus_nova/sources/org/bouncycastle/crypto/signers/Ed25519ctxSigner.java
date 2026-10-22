package org.bouncycastle.crypto.signers;

import java.io.ByteArrayOutputStream;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.params.Ed25519PrivateKeyParameters;
import org.bouncycastle.crypto.params.Ed25519PublicKeyParameters;
import org.bouncycastle.math.ec.rfc8032.Ed25519;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class Ed25519ctxSigner implements Signer {
    private final Buffer buffer;
    private final byte[] context;
    private boolean forSigning;
    private Ed25519PrivateKeyParameters privateKey;
    private Ed25519PublicKeyParameters publicKey;

    /* JADX INFO: renamed from: org.bouncycastle.crypto.signers.Ed25519ctxSigner$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Buffer extends ByteArrayOutputStream {
        private Buffer() {
        }

        public /* synthetic */ Buffer(AnonymousClass1 r100) {
            this();
        }

        public synchronized byte[] generateSignature(Ed25519PrivateKeyParameters r110, byte[] r111) {
            monitor-enter(this);
            byte[] r100 = new byte[64];     // Catch: Throwable -> L7
            r110.sign(1, r111, ((ByteArrayOutputStream) this).buf, 0, ((ByteArrayOutputStream) this).count, r100, 0);     // Catch: Throwable -> L7
            reset();     // Catch: Throwable -> L7
            monitor-exit(this);
            return r100;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.io.ByteArrayOutputStream
        public synchronized void reset() {
            monitor-enter(this);
            Arrays.fill(((ByteArrayOutputStream) this).buf, 0, ((ByteArrayOutputStream) this).count, (byte) 0);     // Catch: Throwable -> L6
            ((ByteArrayOutputStream) this).count = 0;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public synchronized boolean verifySignature(Ed25519PublicKeyParameters r100, byte[] r110, byte[] r111) {
            monitor-enter(this);
        L12:
            th = move-exception;
            throw th;
        L4:
            if (64 == r111.length) goto L9;
            reset();     // Catch: Throwable -> L12
            monitor-exit(this);
            return false;
        L9:
            boolean r101 = Ed25519.verify(r111, 0, r100.getEncoded(), 0, r110, ((ByteArrayOutputStream) this).buf, 0, ((ByteArrayOutputStream) this).count);     // Catch: Throwable -> L12
            reset();     // Catch: Throwable -> L12
            monitor-exit(this);
            return r101;
        }
    }

    public Ed25519ctxSigner(byte[] r100) {
        this.buffer = new Buffer(null);
        this.context = Arrays.clone(r100);
    }

    @Override // org.bouncycastle.crypto.Signer
    public byte[] generateSignature() {
        if (this.forSigning == false) goto L9;
        Ed25519PrivateKeyParameters r100 = this.privateKey;
        if (r100 == null) goto L9;
        return this.buffer.generateSignature(r100, this.context);
    L9:
        throw new IllegalStateException("Ed25519ctxSigner not initialised for signature generation.");
    }

    @Override // org.bouncycastle.crypto.Signer
    public void init(boolean r100, CipherParameters r101) {
        this.forSigning = r100;
        if (r100 == false) goto L5;
        this.privateKey = (Ed25519PrivateKeyParameters) r101;
        this.publicKey = null;
    L6:
        reset();
        return;
    L5:
        this.privateKey = null;
        this.publicKey = (Ed25519PublicKeyParameters) r101;
        goto L6
    }

    @Override // org.bouncycastle.crypto.Signer
    public void reset() {
        this.buffer.reset();
    }

    @Override // org.bouncycastle.crypto.Signer
    public void update(byte r100) {
        this.buffer.write(r100);
    }

    @Override // org.bouncycastle.crypto.Signer
    public void update(byte[] r100, int r101, int r102) {
        this.buffer.write(r100, r101, r102);
    }

    @Override // org.bouncycastle.crypto.Signer
    public boolean verifySignature(byte[] r100) {
        if (this.forSigning == true) goto L9;
        Ed25519PublicKeyParameters r101 = this.publicKey;
        if (r101 == null) goto L9;
        return this.buffer.verifySignature(r101, this.context, r100);
    L9:
        throw new IllegalStateException("Ed25519ctxSigner not initialised for verification");
    }
}
