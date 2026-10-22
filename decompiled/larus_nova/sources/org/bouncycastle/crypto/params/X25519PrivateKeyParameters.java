package org.bouncycastle.crypto.params;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import org.bouncycastle.math.ec.rfc7748.X25519;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.io.Streams;

/* JADX INFO: loaded from: classes42.dex */
public final class X25519PrivateKeyParameters extends AsymmetricKeyParameter {
    public static final int KEY_SIZE = 32;
    public static final int SECRET_SIZE = 32;
    private final byte[] data;

    public X25519PrivateKeyParameters(InputStream r100) throws IOException {
        super(true);
        byte[] r101 = new byte[32];
        this.data = r101;
        if (32 != Streams.readFully(r100, r101)) goto L6;
        return;
    L6:
        throw new EOFException("EOF encountered in middle of X25519 private key");
    }

    public X25519PrivateKeyParameters(SecureRandom r100) {
        super(true);
        byte[] r101 = new byte[32];
        this.data = r101;
        X25519.generatePrivateKey(r100, r101);
    }

    public X25519PrivateKeyParameters(byte[] r100, int r101) {
        super(true);
        byte[] r102 = new byte[32];
        this.data = r102;
        System.arraycopy(r100, r101, r102, 0, 32);
    }

    public void encode(byte[] r100, int r101) {
        System.arraycopy(this.data, 0, r100, r101, 32);
    }

    public X25519PublicKeyParameters generatePublicKey() {
        byte[] r100 = new byte[32];
        X25519.generatePublicKey(this.data, 0, r100, 0);
        return new X25519PublicKeyParameters(r100, 0);
    }

    public void generateSecret(X25519PublicKeyParameters r100, byte[] r101, int r110) {
        byte[] r102 = new byte[32];
        r100.encode(r102, 0);
        if (X25519.calculateAgreement(this.data, 0, r102, 0, r101, r110) == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("X25519 agreement failed");
    }

    public byte[] getEncoded() {
        return Arrays.clone(this.data);
    }
}
