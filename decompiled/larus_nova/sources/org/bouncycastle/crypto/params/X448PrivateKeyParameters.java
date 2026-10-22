package org.bouncycastle.crypto.params;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import org.bouncycastle.math.ec.rfc7748.X448;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.io.Streams;

/* JADX INFO: loaded from: classes42.dex */
public final class X448PrivateKeyParameters extends AsymmetricKeyParameter {
    public static final int KEY_SIZE = 56;
    public static final int SECRET_SIZE = 56;
    private final byte[] data;

    public X448PrivateKeyParameters(InputStream r100) throws IOException {
        super(true);
        byte[] r101 = new byte[56];
        this.data = r101;
        if (56 != Streams.readFully(r100, r101)) goto L6;
        return;
    L6:
        throw new EOFException("EOF encountered in middle of X448 private key");
    }

    public X448PrivateKeyParameters(SecureRandom r100) {
        super(true);
        byte[] r101 = new byte[56];
        this.data = r101;
        X448.generatePrivateKey(r100, r101);
    }

    public X448PrivateKeyParameters(byte[] r100, int r101) {
        super(true);
        byte[] r102 = new byte[56];
        this.data = r102;
        System.arraycopy(r100, r101, r102, 0, 56);
    }

    public void encode(byte[] r100, int r101) {
        System.arraycopy(this.data, 0, r100, r101, 56);
    }

    public X448PublicKeyParameters generatePublicKey() {
        byte[] r100 = new byte[56];
        X448.generatePublicKey(this.data, 0, r100, 0);
        return new X448PublicKeyParameters(r100, 0);
    }

    public void generateSecret(X448PublicKeyParameters r100, byte[] r101, int r110) {
        byte[] r102 = new byte[56];
        r100.encode(r102, 0);
        if (X448.calculateAgreement(this.data, 0, r102, 0, r101, r110) == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("X448 agreement failed");
    }

    public byte[] getEncoded() {
        return Arrays.clone(this.data);
    }
}
