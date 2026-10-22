package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.params.KeyParameter;

/* JADX INFO: loaded from: classes42.dex */
public class OldHMac implements Mac {
    private static final int BLOCK_LENGTH = 64;
    private static final byte IPAD = 54;
    private static final byte OPAD = 92;
    private Digest digest;
    private int digestSize;
    private byte[] inputPad;
    private byte[] outputPad;

    public OldHMac(Digest r100) {
        this.inputPad = new byte[64];
        this.outputPad = new byte[64];
        this.digest = r100;
        this.digestSize = r100.getDigestSize();
    }

    @Override // org.bouncycastle.crypto.Mac
    public int doFinal(byte[] r100, int r101) {
        int r102 = this.digestSize;
        byte[] r103 = new byte[r102];
        this.digest.doFinal(r103, 0);
        Digest r104 = this.digest;
        byte[] r105 = this.outputPad;
        r104.update(r105, 0, r105.length);
        this.digest.update(r103, 0, r102);
        int r106 = this.digest.doFinal(r100, r101);
        reset();
        return r106;
    }

    @Override // org.bouncycastle.crypto.Mac
    public String getAlgorithmName() {
        return this.digest.getAlgorithmName() + "/HMAC";
    }

    @Override // org.bouncycastle.crypto.Mac
    public int getMacSize() {
        return this.digestSize;
    }

    public Digest getUnderlyingDigest() {
        return this.digest;
    }

    @Override // org.bouncycastle.crypto.Mac
    public void init(CipherParameters r100) {
        this.digest.reset();
        byte[] r101 = ((KeyParameter) r100).getKey();
        if (r101.length <= 64) goto L8;
        this.digest.update(r101, 0, r101.length);
        this.digest.doFinal(this.inputPad, 0);
        int r102 = this.digestSize;
    L5:
        byte[] r103 = this.inputPad;
        if (r102 >= r103.length) goto L12;
        r103[r102] = 0;
        r102 = r102 + 1;
    L12:
        byte[] r104 = this.inputPad;
        byte[] r105 = new byte[r104.length];
        this.outputPad = r105;
        System.arraycopy(r104, 0, r105, 0, r104.length);
        int r106 = 0;
    L13:
        byte[] r107 = this.inputPad;
        if (r106 >= r107.length) goto L16;
        r107[r106] = (byte) (r107[r106] ^ IPAD);
        r106 = r106 + 1;
        goto L13
    L16:
        int r108 = 0;
    L17:
        byte[] r109 = this.outputPad;
        if (r108 >= r109.length) goto L20;
        r109[r108] = (byte) (r109[r108] ^ OPAD);
        r108 = r108 + 1;
        goto L17
    L20:
        Digest r110 = this.digest;
        byte[] r111 = this.inputPad;
        r110.update(r111, 0, r111.length);
        return;
    L8:
        System.arraycopy(r101, 0, this.inputPad, 0, r101.length);
        int r112 = r101.length;
    L9:
        byte[] r113 = this.inputPad;
        if (r112 >= r113.length) goto L12;
        r113[r112] = 0;
        r112 = r112 + 1;
        goto L9
    }

    @Override // org.bouncycastle.crypto.Mac
    public void reset() {
        this.digest.reset();
        Digest r100 = this.digest;
        byte[] r101 = this.inputPad;
        r100.update(r101, 0, r101.length);
    }

    @Override // org.bouncycastle.crypto.Mac
    public void update(byte r100) {
        this.digest.update(r100);
    }

    @Override // org.bouncycastle.crypto.Mac
    public void update(byte[] r100, int r101, int r102) {
        this.digest.update(r100, r101, r102);
    }
}
