package org.bouncycastle.crypto.params;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.io.Streams;

/* JADX INFO: loaded from: classes42.dex */
public final class Ed25519PublicKeyParameters extends AsymmetricKeyParameter {
    public static final int KEY_SIZE = 32;
    private final byte[] data;

    public Ed25519PublicKeyParameters(InputStream r100) throws IOException {
        super(false);
        byte[] r101 = new byte[32];
        this.data = r101;
        if (32 != Streams.readFully(r100, r101)) goto L6;
        return;
    L6:
        throw new EOFException("EOF encountered in middle of Ed25519 public key");
    }

    public Ed25519PublicKeyParameters(byte[] r100, int r101) {
        super(false);
        byte[] r102 = new byte[32];
        this.data = r102;
        System.arraycopy(r100, r101, r102, 0, 32);
    }

    public void encode(byte[] r100, int r101) {
        System.arraycopy(this.data, 0, r100, r101, 32);
    }

    public byte[] getEncoded() {
        return Arrays.clone(this.data);
    }
}
