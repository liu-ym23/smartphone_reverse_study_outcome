package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.modes.CBCBlockCipher;

/* JADX INFO: loaded from: classes42.dex */
public class BlockCipherMac implements Mac {
    private byte[] buf;
    private int bufOff;
    private BlockCipher cipher;

    /* JADX INFO: renamed from: mac, reason: collision with root package name */
    private byte[] f525224mac;
    private int macSize;

    public BlockCipherMac(BlockCipher r100) {
        this(r100, (r100.getBlockSize() * 8) / 2);
    }

    public BlockCipherMac(BlockCipher r100, int r101) {
        if ((r101 % 8) != 0) goto L7;
        this.cipher = new CBCBlockCipher(r100);
        this.macSize = r101 / 8;
        this.f525224mac = new byte[r100.getBlockSize()];
        this.buf = new byte[r100.getBlockSize()];
        this.bufOff = 0;
        return;
    L7:
        throw new IllegalArgumentException("MAC size must be multiple of 8");
    }

    @Override // org.bouncycastle.crypto.Mac
    public int doFinal(byte[] r100, int r101) {
        int r102 = this.cipher.getBlockSize();
    L3:
        int r103 = this.bufOff;
        if (r103 >= r102) goto L6;
        this.buf[r103] = 0;
        this.bufOff = r103 + 1;
        goto L3
    L6:
        this.cipher.processBlock(this.buf, 0, this.f525224mac, 0);
        System.arraycopy(this.f525224mac, 0, r100, r101, this.macSize);
        reset();
        return this.macSize;
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
        reset();
        this.cipher.init(true, r100);
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
        this.cipher.processBlock(r102, 0, this.f525224mac, 0);
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
        this.cipher.processBlock(this.buf, 0, this.f525224mac, 0);
        this.bufOff = 0;
        r102 = r102 - r105;
        r101 = r101 + r105;
    L6:
        if (r102 <= r103) goto L8;
        this.cipher.processBlock(r100, r101, this.f525224mac, 0);
        r102 = r102 - r103;
        r101 = r101 + r103;
    L8:
        System.arraycopy(r100, r101, this.buf, this.bufOff, r102);
        this.bufOff += r102;
        return;
    L11:
        throw new IllegalArgumentException("Can't have a negative input length!");
    }
}
