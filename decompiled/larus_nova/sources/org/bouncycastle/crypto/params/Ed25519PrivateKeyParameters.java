package org.bouncycastle.crypto.params;

import faceverify.q;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import org.bouncycastle.math.ec.rfc8032.Ed25519;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.io.Streams;

/* JADX INFO: loaded from: classes42.dex */
public final class Ed25519PrivateKeyParameters extends AsymmetricKeyParameter {
    public static final int KEY_SIZE = 32;
    public static final int SIGNATURE_SIZE = 64;
    private Ed25519PublicKeyParameters cachedPublicKey;
    private final byte[] data;

    public Ed25519PrivateKeyParameters(InputStream r100) throws IOException {
        super(true);
        byte[] r101 = new byte[32];
        this.data = r101;
        if (32 != Streams.readFully(r100, r101)) goto L6;
        return;
    L6:
        throw new EOFException("EOF encountered in middle of Ed25519 private key");
    }

    public Ed25519PrivateKeyParameters(SecureRandom r100) {
        super(true);
        byte[] r101 = new byte[32];
        this.data = r101;
        Ed25519.generatePrivateKey(r100, r101);
    }

    public Ed25519PrivateKeyParameters(byte[] r100, int r101) {
        super(true);
        byte[] r102 = new byte[32];
        this.data = r102;
        System.arraycopy(r100, r101, r102, 0, 32);
    }

    public void encode(byte[] r100, int r101) {
        System.arraycopy(this.data, 0, r100, r101, 32);
    }

    public Ed25519PublicKeyParameters generatePublicKey() {
        byte[] r100 = this.data;
        monitor-enter(r100);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.cachedPublicKey != null) goto L7;
        byte[] r101 = new byte[32];     // Catch: Throwable -> L10
        Ed25519.generatePublicKey(this.data, 0, r101, 0);     // Catch: Throwable -> L10
        this.cachedPublicKey = new Ed25519PublicKeyParameters(r101, 0);     // Catch: Throwable -> L10
    L7:
        Ed25519PublicKeyParameters r102 = this.cachedPublicKey;     // Catch: Throwable -> L10
        monitor-exit(r100);     // Catch: Throwable -> L10
        return r102;
    }

    public byte[] getEncoded() {
        return Arrays.clone(this.data);
    }

    public void sign(int r100, Ed25519PublicKeyParameters r110, byte[] r111, byte[] r112, int r113, int r114, byte[] r115, int r116) {
        sign(r100, r111, r112, r113, r114, r115, r116);
    }

    public void sign(int r110, byte[] r111, byte[] r112, int r113, int r114, byte[] r210, int r211) {
        byte[] r100 = new byte[32];
        generatePublicKey().encode(r100, 0);
        if (r110 == 0) goto L17;
        if (r110 != 1) goto L7;
        Ed25519.sign(this.data, 0, r100, 0, r111, r112, r113, r114, r210, r211);
        return;
    L7:
        if (r110 != 2) goto L14;
        if (64 != r114) goto L12;
        Ed25519.signPrehash(this.data, 0, r100, 0, r111, r112, r113, r210, r211);
        return;
    L12:
        throw new IllegalArgumentException("msgLen");
    L14:
        throw new IllegalArgumentException(q.KEY_ALGORITHM_CONFIG);
    L17:
        if (r111 != null) goto L21;
        Ed25519.sign(this.data, 0, r100, 0, r112, r113, r114, r210, r211);
        return;
    L21:
        throw new IllegalArgumentException("ctx");
    }
}
