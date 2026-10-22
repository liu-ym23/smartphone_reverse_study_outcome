package org.bouncycastle.crypto.macs;

import com.ss.ttm.player.MediaPlayer;
import kotlin.UByte;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.ISO7816d4Padding;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class CMac implements Mac {
    private byte[] Lu;
    private byte[] Lu2;
    private byte[] ZEROES;
    private byte[] buf;
    private int bufOff;
    private BlockCipher cipher;

    /* JADX INFO: renamed from: mac, reason: collision with root package name */
    private byte[] f525227mac;
    private int macSize;
    private byte[] poly;

    public CMac(BlockCipher r100) {
        this(r100, r100.getBlockSize() * 8);
    }

    public CMac(BlockCipher r100, int r101) {
        if ((r101 % 8) != 0) goto L11;
        if (r101 > (r100.getBlockSize() * 8)) goto L9;
        this.cipher = new CBCBlockCipher(r100);
        this.macSize = r101 / 8;
        this.poly = lookupPoly(r100.getBlockSize());
        this.f525227mac = new byte[r100.getBlockSize()];
        this.buf = new byte[r100.getBlockSize()];
        this.ZEROES = new byte[r100.getBlockSize()];
        this.bufOff = 0;
        return;
    L9:
        throw new IllegalArgumentException("MAC size must be less or equal to " + (r100.getBlockSize() * 8));
    L11:
        throw new IllegalArgumentException("MAC size must be multiple of 8");
    }

    private byte[] doubleLu(byte[] r100) {
        byte[] r101 = new byte[r100.length];
        int r102 = (-shiftLeft(r100, r101)) & 255;
        int r103 = r100.length - 3;
        byte r104 = r101[r103];
        byte[] r105 = this.poly;
        r101[r103] = (byte) (r104 ^ (r105[1] & r102));
        int r106 = r100.length - 2;
        byte r107 = r101[r106];
        r101[r106] = (byte) ((r105[2] & r102) ^ r107);
        int r108 = r100.length - 1;
        byte r109 = r101[r108];
        r101[r108] = (byte) ((r102 & r105[3]) ^ r109);
        return r101;
    }

    private static byte[] lookupPoly(int r100) {
        int r101 = r100 * 8;
        int r102 = 135;
        switch(r101) {
            case 64: goto L15;
            case 128: goto L17;
            case 160: goto L14;
            case 192: goto L17;
            case 224: goto L13;
            case 256: goto L12;
            case 320: goto L15;
            case 384: goto L11;
            case 448: goto L10;
            case 512: goto L9;
            case 768: goto L8;
            case 1024: goto L7;
            case 2048: goto L6;
            default: goto L5;
        };
    L6:
        r102 = 548865;
        goto L17
    L7:
        r102 = 524355;
        goto L17
    L8:
        r102 = 655377;
        goto L17
    L9:
        r102 = MediaPlayer.MEDIA_PLAYER_OPTION_KEEP_FORMAT_THREAD_ALIVE;
        goto L17
    L10:
        r102 = 2129;
        goto L17
    L11:
        r102 = 4109;
        goto L17
    L12:
        r102 = 1061;
        goto L17
    L13:
        r102 = 777;
        goto L17
    L14:
        r102 = 45;
        goto L17
    L15:
        r102 = 27;
        goto L17
    L5:
        throw new IllegalArgumentException("Unknown block size for CMAC: " + r101);
    L17:
        return Pack.intToBigEndian(r102);
    }

    private static int shiftLeft(byte[] r100, byte[] r101) {
        int r102 = r100.length;
        int r103 = 0;
    L3:
        r102 = r102 - 1;
        if (r102 < 0) goto L6;
        int r104 = r100[r102] & UByte.MAX_VALUE;
        r101[r102] = (byte) (r103 | (r104 << 1));
        r103 = (r104 >>> 7) & 1;
        goto L3
    L6:
        return r103;
    }

    @Override // org.bouncycastle.crypto.Mac
    public int doFinal(byte[] r100, int r101) {
        int r102 = this.cipher.getBlockSize();
        if (this.bufOff != r102) goto L5;
        byte[] r103 = this.Lu;
    L6:
        int r104 = 0;
    L7:
        byte[] r105 = this.f525227mac;
        if (r104 >= r105.length) goto L10;
        byte[] r106 = this.buf;
        r106[r104] = (byte) (r106[r104] ^ r103[r104]);
        r104 = r104 + 1;
        goto L7
    L10:
        this.cipher.processBlock(this.buf, 0, r105, 0);
        System.arraycopy(this.f525227mac, 0, r100, r101, this.macSize);
        reset();
        return this.macSize;
    L5:
        new ISO7816d4Padding().addPadding(this.buf, this.bufOff);
        r103 = this.Lu2;
        goto L6
    }

    @Override // org.bouncycastle.crypto.Mac
    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName();
    }

    @Override // org.bouncycastle.crypto.Mac
    public int getMacSize() {
        return this.macSize;
    }

    @Override // org.bouncycastle.crypto.Mac
    public void init(CipherParameters r100) {
        validate(r100);
        this.cipher.init(true, r100);
        byte[] r101 = this.ZEROES;
        byte[] r102 = new byte[r101.length];
        this.cipher.processBlock(r101, 0, r102, 0);
        byte[] r103 = doubleLu(r102);
        this.Lu = r103;
        this.Lu2 = doubleLu(r103);
        reset();
    }

    @Override // org.bouncycastle.crypto.Mac
    public void reset() {
        int r100 = 0;
    L3:
        byte[] r101 = this.buf;
        if (r100 >= r101.length) goto L6;
        r101[r100] = 0;
        r100 = r100 + 1;
        goto L3
    L6:
        this.bufOff = 0;
        this.cipher.reset();
    }

    @Override // org.bouncycastle.crypto.Mac
    public void update(byte r100) {
        int r101 = this.bufOff;
        byte[] r102 = this.buf;
        if (r101 != r102.length) goto L5;
        this.cipher.processBlock(r102, 0, this.f525227mac, 0);
        this.bufOff = 0;
    L5:
        byte[] r103 = this.buf;
        int r104 = this.bufOff;
        this.bufOff = r104 + 1;
        r103[r104] = r100;
    }

    @Override // org.bouncycastle.crypto.Mac
    public void update(byte[] r100, int r101, int r102) {
        if (r102 < 0) goto L11;
        int r103 = this.cipher.getBlockSize();
        int r104 = this.bufOff;
        int r105 = r103 - r104;
        if (r102 <= r105) goto L8;
        System.arraycopy(r100, r101, this.buf, r104, r105);
        this.cipher.processBlock(this.buf, 0, this.f525227mac, 0);
        this.bufOff = 0;
        r102 = r102 - r105;
        r101 = r101 + r105;
    L6:
        if (r102 <= r103) goto L8;
        this.cipher.processBlock(r100, r101, this.f525227mac, 0);
        r102 = r102 - r103;
        r101 = r101 + r103;
    L8:
        System.arraycopy(r100, r101, this.buf, this.bufOff, r102);
        this.bufOff += r102;
        return;
    L11:
        throw new IllegalArgumentException("Can't have a negative input length!");
    }

    public void validate(CipherParameters r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if ((r100 instanceof KeyParameter) == false) goto L7;
        return;
    L7:
        throw new IllegalArgumentException("CMac mode only permits key to be set.");
    }
}
