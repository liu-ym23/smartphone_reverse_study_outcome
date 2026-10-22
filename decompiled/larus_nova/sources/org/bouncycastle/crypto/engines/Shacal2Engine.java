package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;

/* JADX INFO: loaded from: classes42.dex */
public class Shacal2Engine implements BlockCipher {
    private static final int BLOCK_SIZE = 32;
    private static final int[] K = null;
    private static final int ROUNDS = 64;
    private boolean forEncryption;
    private int[] workingKey;

    static {
        K = new int[]{1116352408, 1899447441, -1245643825, -373957723, 961987163, 1508970993, -1841331548, -1424204075, -670586216, 310598401, 607225278, 1426881987, 1925078388, -2132889090, -1680079193, -1046744716, -459576895, -272742522, 264347078, 604807628, 770255983, 1249150122, 1555081692, 1996064986, -1740746414, -1473132947, -1341970488, -1084653625, -958395405, -710438585, 113926993, 338241895, 666307205, 773529912, 1294757372, 1396182291, 1695183700, 1986661051, -2117940946, -1838011259, -1564481375, -1474664885, -1035236496, -949202525, -778901479, -694614492, -200395387, 275423344, 430227734, 506948616, 659060556, 883997877, 958139571, 1322822218, 1537002063, 1747873779, 1955562222, 2024104815, -2067236844, -1933114872, -1866530822, -1538233109, -1090935817, -965641998};
    }

    public Shacal2Engine() {
        this.forEncryption = false;
        this.workingKey = null;
    }

    private void byteBlockToInts(byte[] r100, int[] r101, int r102, int r103) {
    L3:
        if (r103 >= 8) goto L5;
        int r104 = r102 + 1;
        int r105 = r104 + 1;
        int r106 = ((r100[r102] & 255) << 24) | ((r100[r104] & 255) << 16);
        int r107 = r105 + 1;
        int r108 = r106 | ((r100[r105] & 255) << 8);
        int r109 = r107 + 1;
        r101[r103] = r108 | (r100[r107] & 255);
        r103 = r103 + 1;
        r102 = r109;
        goto L3
    }

    private void bytes2ints(byte[] r100, int[] r101, int r102, int r103) {
    L3:
        if (r103 >= (r100.length / 4)) goto L5;
        int r104 = r102 + 1;
        int r105 = r104 + 1;
        int r106 = ((r100[r102] & 255) << 24) | ((r100[r104] & 255) << 16);
        int r107 = r105 + 1;
        int r108 = r106 | ((r100[r105] & 255) << 8);
        int r109 = r107 + 1;
        r101[r103] = r108 | (r100[r107] & 255);
        r103 = r103 + 1;
        r102 = r109;
        goto L3
    }

    private void decryptBlock(byte[] r110, int r111, byte[] r112, int r113) {
        int[] r100 = new int[8];
        byteBlockToInts(r110, r100, r111, 0);
        int r114 = 63;
    L4:
        if (r114 <= (-1)) goto L6;
        int r115 = r100[0];
        int r101 = r100[1];
        int r102 = r100[2];
        int r103 = r100[3];
        int r116 = (r115 - ((((r101 >>> 2) | (r101 << (-2))) ^ ((r101 >>> 13) | (r101 << (-13)))) ^ ((r101 >>> 22) | (r101 << (-22))))) - (((r101 & r102) ^ (r101 & r103)) ^ (r102 & r103));
        r100[0] = r101;
        r100[1] = r102;
        r100[2] = r103;
        r100[3] = r100[4] - r116;
        int r104 = r100[5];
        r100[4] = r104;
        int r105 = r100[6];
        r100[5] = r105;
        int r106 = r100[7];
        r100[6] = r106;
        r100[7] = (((r116 - K[r114]) - this.workingKey[r114]) - ((((r104 >>> 6) | (r104 << (-6))) ^ ((r104 >>> 11) | (r104 << (-11)))) ^ ((r104 >>> 25) | (r104 << (-25))))) - ((r104 & r105) ^ ((~r104) & r106));
        r114 = r114 - 1;
        goto L4
    L6:
        ints2bytes(r100, r112, r113);
    }

    private void encryptBlock(byte[] r110, int r111, byte[] r112, int r113) {
        int[] r100 = new int[8];
        byteBlockToInts(r110, r100, r111, 0);
        int r114 = 0;
    L4:
        if (r114 >= 64) goto L6;
        int r101 = r100[4];
        int r102 = (((r101 >>> 6) | (r101 << (-6))) ^ ((r101 >>> 11) | (r101 << (-11)))) ^ ((r101 >>> 25) | (r101 << (-25)));
        int r103 = r100[5];
        int r104 = ~r101;
        int r105 = r100[6];
        int r106 = (((r102 + ((r101 & r103) ^ (r104 & r105))) + r100[7]) + K[r114]) + this.workingKey[r114];
        r100[7] = r105;
        r100[6] = r103;
        r100[5] = r101;
        r100[4] = r100[3] + r106;
        int r107 = r100[2];
        r100[3] = r107;
        int r108 = r100[1];
        r100[2] = r108;
        int r115 = r100[0];
        r100[1] = r115;
        int r109 = r106 + ((((r115 >>> 2) | (r115 << (-2))) ^ ((r115 >>> 13) | (r115 << (-13)))) ^ ((r115 >>> 22) | (r115 << (-22))));
        int r116 = r115 & r108;
        r100[0] = r109 + (((r115 & r107) ^ r116) ^ (r108 & r107));
        r114 = r114 + 1;
        goto L4
    L6:
        ints2bytes(r100, r112, r113);
    }

    private void ints2bytes(int[] r100, byte[] r101, int r102) {
        int r103 = 0;
    L4:
        if (r103 >= r100.length) goto L6;
        int r104 = r102 + 1;
        int r105 = r100[r103];
        r101[r102] = (byte) (r105 >>> 24);
        int r106 = r104 + 1;
        r101[r104] = (byte) (r105 >>> 16);
        int r107 = r106 + 1;
        r101[r106] = (byte) (r105 >>> 8);
        r102 = r107 + 1;
        r101[r107] = (byte) r105;
        r103 = r103 + 1;
        goto L4
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "Shacal2";
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 32;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean r100, CipherParameters r101) throws IllegalArgumentException {
        if ((r101 instanceof KeyParameter) == false) goto L7;
        this.forEncryption = r100;
        this.workingKey = new int[64];
        setKey(((KeyParameter) r101).getKey());
        return;
    L7:
        throw new IllegalArgumentException("only simple KeyParameter expected.");
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] r100, int r101, byte[] r102, int r103) throws DataLengthException, IllegalStateException {
        if (this.workingKey == null) goto L19;
        if ((r101 + 32) > r100.length) goto L17;
        if ((r103 + 32) > r102.length) goto L15;
        if (this.forEncryption == false) goto L11;
        encryptBlock(r100, r101, r102, r103);
        return 32;
    L11:
        decryptBlock(r100, r101, r102, r103);
        return 32;
    L15:
        throw new OutputLengthException("output buffer too short");
    L17:
        throw new DataLengthException("input buffer too short");
    L19:
        throw new IllegalStateException("Shacal2 not initialised");
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
    }

    public void setKey(byte[] r100) {
        if (r100.length == 0) goto L15;
        if (r100.length > 64) goto L15;
        int r101 = 16;
        if (r100.length < 16) goto L15;
        if ((r100.length % 8) != 0) goto L15;
        bytes2ints(r100, this.workingKey, 0, 0);
    L11:
        if (r101 >= 64) goto L13;
        int[] r102 = this.workingKey;
        int r103 = r102[r101 - 2];
        int r104 = ((r103 >>> 10) ^ (((r103 >>> 17) | (r103 << (-17))) ^ ((r103 >>> 19) | (r103 << (-19))))) + r102[r101 - 7];
        int r105 = r102[r101 - 15];
        r102[r101] = (r104 + ((r105 >>> 3) ^ (((r105 >>> 7) | (r105 << (-7))) ^ ((r105 >>> 18) | (r105 << (-18)))))) + r102[r101 - 16];
        r101 = r101 + 1;
        goto L11
    L13:
        return;
    L15:
        throw new IllegalArgumentException("Shacal2-key must be 16 - 64 bytes and multiple of 8");
    }
}
