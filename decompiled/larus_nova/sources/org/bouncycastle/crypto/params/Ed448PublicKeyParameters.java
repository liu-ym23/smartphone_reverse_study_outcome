package org.bouncycastle.crypto.params;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.io.Streams;

/* JADX INFO: loaded from: classes42.dex */
public final class Ed448PublicKeyParameters extends AsymmetricKeyParameter {
    public static final int KEY_SIZE = 57;
    private final byte[] data;

    public Ed448PublicKeyParameters(InputStream r100) throws IOException {
        super(false);
        byte[] r101 = new byte[57];
        this.data = r101;
        if (57 != Streams.readFully(r100, r101)) goto L6;
        return;
    L6:
        throw new EOFException("EOF encountered in middle of Ed448 public key");
    }

    public Ed448PublicKeyParameters(byte[] r100, int r101) {
        super(false);
        byte[] r102 = new byte[57];
        this.data = r102;
        System.arraycopy(r100, r101, r102, 0, 57);
    }

    public void encode(byte[] r100, int r101) {
        System.arraycopy(this.data, 0, r100, r101, 57);
    }

    public byte[] getEncoded() {
        return Arrays.clone(this.data);
    }
}
