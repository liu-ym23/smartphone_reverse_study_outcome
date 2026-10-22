package org.bouncycastle.crypto.util;

import java.math.BigInteger;
import kotlin.UByte;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes42.dex */
class SSHBuffer {
    private final byte[] buffer;
    private int pos;

    public SSHBuffer(byte[] r100) {
        this.pos = 0;
        this.buffer = r100;
    }

    public SSHBuffer(byte[] r100, byte[] r101) {
        int r102 = 0;
        this.pos = 0;
        this.buffer = r101;
    L4:
        if (r102 == r100.length) goto L10;
        if (r100[r102] != r101[r102]) goto L9;
        r102 = r102 + 1;
        goto L4
    L9:
        throw new IllegalArgumentException("magic-number incorrect");
    L10:
        this.pos += r100.length;
    }

    public byte[] getBuffer() {
        return Arrays.clone(this.buffer);
    }

    public boolean hasRemaining() {
        if (this.pos >= this.buffer.length) goto L5;
        return true;
    L5:
        return false;
    }

    public BigInteger readBigNumPositive() {
        int r100 = readU32();
        int r101 = this.pos;
        int r102 = r101 + r100;
        byte[] r103 = this.buffer;
        if (r102 > r103.length) goto L7;
        int r104 = r100 + r101;
        this.pos = r104;
        return new BigInteger(1, Arrays.copyOfRange(r103, r101, r104));
    L7:
        throw new IllegalArgumentException("not enough data for big num");
    }

    public byte[] readBlock() {
        int r100 = readU32();
        if (r100 == 0) goto L5;
        int r101 = this.pos;
        byte[] r102 = this.buffer;
        if (r101 > (r102.length - r100)) goto L11;
        int r103 = r100 + r101;
        this.pos = r103;
        return Arrays.copyOfRange(r102, r101, r103);
    L11:
        throw new IllegalArgumentException("not enough data for block");
    L5:
        return new byte[0];
    }

    public byte[] readPaddedBlock() {
        return readPaddedBlock(8);
    }

    public byte[] readPaddedBlock(int r100) {
        int r101 = readU32();
        if (r101 == 0) goto L5;
        int r102 = this.pos;
        byte[] r103 = this.buffer;
        if (r102 > (r103.length - r101)) goto L27;
        if ((r101 % r100) != 0) goto L25;
        int r104 = r102 + r101;
        this.pos = r104;
        if (r101 <= 0) goto L23;
        int r105 = r103[r104 - 1] & UByte.MAX_VALUE;
        if (r105 <= 0) goto L23;
        if (r105 >= r100) goto L23;
        r104 = r104 - r105;
        int r106 = 1;
        int r107 = r104;
    L16:
        if (r106 > r105) goto L23;
        if (r106 != (this.buffer[r107] & UByte.MAX_VALUE)) goto L21;
        r106 = r106 + 1;
        r107 = r107 + 1;
        goto L16
    L21:
        throw new IllegalArgumentException("incorrect padding");
    L23:
        return Arrays.copyOfRange(this.buffer, r102, r104);
    L25:
        throw new IllegalArgumentException("missing padding");
    L27:
        throw new IllegalArgumentException("not enough data for block");
    L5:
        return new byte[0];
    }

    public String readString() {
        return Strings.fromByteArray(readBlock());
    }

    public int readU32() {
        int r100 = this.pos;
        byte[] r101 = this.buffer;
        if (r100 > (r101.length - 4)) goto L7;
        int r102 = r100 + 1;
        int r103 = r102 + 1;
        int r104 = ((r101[r100] & UByte.MAX_VALUE) << 24) | ((r101[r102] & UByte.MAX_VALUE) << 16);
        int r105 = r103 + 1;
        int r106 = r104 | ((r101[r103] & UByte.MAX_VALUE) << 8);
        this.pos = r105 + 1;
        return r106 | (r101[r105] & UByte.MAX_VALUE);
    L7:
        throw new IllegalArgumentException("4 bytes for U32 exceeds buffer.");
    }

    public void skipBlock() {
        int r100 = readU32();
        int r101 = this.pos;
        if (r101 > (this.buffer.length - r100)) goto L7;
        this.pos = r101 + r100;
        return;
    L7:
        throw new IllegalArgumentException("not enough data for block");
    }
}
