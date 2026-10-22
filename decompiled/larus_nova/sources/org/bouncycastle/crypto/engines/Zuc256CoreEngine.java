package org.bouncycastle.crypto.engines;

import com.ss.ttm.player.MediaPlayer;
import kotlin.UByte;
import org.bouncycastle.util.Memoable;

/* JADX INFO: loaded from: classes42.dex */
public class Zuc256CoreEngine extends Zuc128CoreEngine {
    private static final byte[] EK_d = null;
    private static final byte[] EK_d128 = null;
    private static final byte[] EK_d32 = null;
    private static final byte[] EK_d64 = null;
    private byte[] theD;

    static {
        EK_d = new byte[]{34, 47, 36, 42, 109, 64, 64, 64, 64, 64, 64, 64, 64, 82, 16, 48};
        EK_d32 = new byte[]{34, 47, 37, 42, 109, 64, 64, 64, 64, 64, 64, 64, 64, 82, 16, 48};
        EK_d64 = new byte[]{35, 47, 36, 42, 109, 64, 64, 64, 64, 64, 64, 64, 64, 82, 16, 48};
        EK_d128 = new byte[]{35, 47, 37, 42, 109, 64, 64, 64, 64, 64, 64, 64, 64, 82, 16, 48};
    }

    public Zuc256CoreEngine() {
        this.theD = EK_d;
    }

    public Zuc256CoreEngine(int r100) {
        if (r100 != 32) goto L5;
        this.theD = EK_d32;
        return;
    L5:
        if (r100 != 64) goto L7;
        this.theD = EK_d64;
        return;
    L7:
        if (r100 != 128) goto L10;
        this.theD = EK_d128;
        return;
    L10:
        throw new IllegalArgumentException("Unsupported length: " + r100);
    }

    public Zuc256CoreEngine(Zuc256CoreEngine r100) {
        super(r100);
    }

    private static int MAKEU31(byte r100, byte r101, byte r102, byte r103) {
        return ((((r100 & UByte.MAX_VALUE) << 23) | ((r101 & UByte.MAX_VALUE) << 16)) | ((r102 & UByte.MAX_VALUE) << 8)) | (r103 & UByte.MAX_VALUE);
    }

    @Override // org.bouncycastle.crypto.engines.Zuc128CoreEngine, org.bouncycastle.util.Memoable
    public Memoable copy() {
        return new Zuc256CoreEngine(this);
    }

    @Override // org.bouncycastle.crypto.engines.Zuc128CoreEngine, org.bouncycastle.crypto.StreamCipher
    public String getAlgorithmName() {
        return "Zuc-256";
    }

    @Override // org.bouncycastle.crypto.engines.Zuc128CoreEngine
    public int getMaxIterations() {
        return MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_CREATE_TIME;
    }

    @Override // org.bouncycastle.crypto.engines.Zuc128CoreEngine, org.bouncycastle.util.Memoable
    public void reset(Memoable r100) {
        super.reset(r100);
        this.theD = ((Zuc256CoreEngine) r100).theD;
    }

    @Override // org.bouncycastle.crypto.engines.Zuc128CoreEngine
    public void setKeyAndIV(int[] r110, byte[] r111, byte[] r112) {
        if (r111 == null) goto L14;
        if (r111.length != 32) goto L14;
        if (r112 == null) goto L12;
        if (r112.length != 25) goto L12;
        r110[0] = MAKEU31(r111[0], this.theD[0], r111[21], r111[16]);
        r110[1] = MAKEU31(r111[1], this.theD[1], r111[22], r111[17]);
        r110[2] = MAKEU31(r111[2], this.theD[2], r111[23], r111[18]);
        r110[3] = MAKEU31(r111[3], this.theD[3], r111[24], r111[19]);
        r110[4] = MAKEU31(r111[4], this.theD[4], r111[25], r111[20]);
        r110[5] = MAKEU31(r112[0], (byte) (this.theD[5] | (r112[17] & 63)), r111[5], r111[26]);
        r110[6] = MAKEU31(r112[1], (byte) (this.theD[6] | (r112[18] & 63)), r111[6], r111[27]);
        r110[7] = MAKEU31(r112[10], (byte) (this.theD[7] | (r112[19] & 63)), r111[7], r112[2]);
        r110[8] = MAKEU31(r111[8], (byte) (this.theD[8] | (r112[20] & 63)), r112[3], r112[11]);
        byte r100 = r111[9];
        byte r101 = this.theD[9];
        r110[9] = MAKEU31(r100, (byte) ((r112[21] & 63) | r101), r112[12], r112[4]);
        r110[10] = MAKEU31(r112[5], (byte) (this.theD[10] | (r112[22] & 63)), r111[10], r111[28]);
        r110[11] = MAKEU31(r111[11], (byte) (this.theD[11] | (r112[23] & 63)), r112[6], r112[13]);
        r110[12] = MAKEU31(r111[12], (byte) (this.theD[12] | (r112[24] & 63)), r112[7], r112[14]);
        r110[13] = MAKEU31(r111[13], this.theD[13], r112[15], r112[8]);
        r110[14] = MAKEU31(r111[14], (byte) (this.theD[14] | ((r111[31] >>> 4) & 15)), r112[16], r112[9]);
        r110[15] = MAKEU31(r111[15], (byte) (this.theD[15] | (r111[31] & 15)), r111[30], r111[29]);
        return;
    L12:
        throw new IllegalArgumentException("An IV of 25 bytes is needed");
    L14:
        throw new IllegalArgumentException("A key of 32 bytes is needed");
    }
}
