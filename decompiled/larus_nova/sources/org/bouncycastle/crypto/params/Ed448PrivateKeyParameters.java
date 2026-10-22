package org.bouncycastle.crypto.params;

import faceverify.q;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import org.bouncycastle.math.ec.rfc8032.Ed448;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.io.Streams;

/* JADX INFO: loaded from: classes42.dex */
public final class Ed448PrivateKeyParameters extends AsymmetricKeyParameter {
    public static final int KEY_SIZE = 57;
    public static final int SIGNATURE_SIZE = 114;
    private Ed448PublicKeyParameters cachedPublicKey;
    private final byte[] data;

    public Ed448PrivateKeyParameters(InputStream r100) throws IOException {
        super(true);
        byte[] r101 = new byte[57];
        this.data = r101;
        if (57 != Streams.readFully(r100, r101)) goto L6;
        return;
    L6:
        throw new EOFException("EOF encountered in middle of Ed448 private key");
    }

    public Ed448PrivateKeyParameters(SecureRandom r100) {
        super(true);
        byte[] r101 = new byte[57];
        this.data = r101;
        Ed448.generatePrivateKey(r100, r101);
    }

    public Ed448PrivateKeyParameters(byte[] r100, int r101) {
        super(true);
        byte[] r102 = new byte[57];
        this.data = r102;
        System.arraycopy(r100, r101, r102, 0, 57);
    }

    public void encode(byte[] r100, int r101) {
        System.arraycopy(this.data, 0, r100, r101, 57);
    }

    public Ed448PublicKeyParameters generatePublicKey() {
        byte[] r100 = this.data;
        monitor-enter(r100);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.cachedPublicKey != null) goto L7;
        byte[] r101 = new byte[57];     // Catch: Throwable -> L10
        Ed448.generatePublicKey(this.data, 0, r101, 0);     // Catch: Throwable -> L10
        this.cachedPublicKey = new Ed448PublicKeyParameters(r101, 0);     // Catch: Throwable -> L10
    L7:
        Ed448PublicKeyParameters r102 = this.cachedPublicKey;     // Catch: Throwable -> L10
        monitor-exit(r100);     // Catch: Throwable -> L10
        return r102;
    }

    public byte[] getEncoded() {
        return Arrays.clone(this.data);
    }

    public void sign(int r100, Ed448PublicKeyParameters r110, byte[] r111, byte[] r112, int r113, int r114, byte[] r115, int r116) {
        sign(r100, r111, r112, r113, r114, r115, r116);
    }

    public void sign(int r110, byte[] r111, byte[] r112, int r113, int r114, byte[] r210, int r211) {
        byte[] r100 = new byte[57];
        generatePublicKey().encode(r100, 0);
        if (r110 != 0) goto L5;
        Ed448.sign(this.data, 0, r100, 0, r111, r112, r113, r114, r210, r211);
        return;
    L5:
        if (r110 != 1) goto L12;
        if (64 != r114) goto L10;
        Ed448.signPrehash(this.data, 0, r100, 0, r111, r112, r113, r210, r211);
        return;
    L10:
        throw new IllegalArgumentException("msgLen");
    L12:
        throw new IllegalArgumentException(q.KEY_ALGORITHM_CONFIG);
    }
}
