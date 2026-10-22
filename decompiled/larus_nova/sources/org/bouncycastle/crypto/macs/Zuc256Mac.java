package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.engines.Zuc128CoreEngine;
import org.bouncycastle.crypto.engines.Zuc256CoreEngine;

/* JADX INFO: loaded from: classes42.dex */
public final class Zuc256Mac implements Mac {
    private static final int TOPBIT = 128;
    private int theByteIndex;
    private final InternalZuc256Engine theEngine;
    private final int[] theKeyStream;
    private final int[] theMac;
    private final int theMacLength;
    private Zuc256CoreEngine theState;
    private int theWordIndex;

    public static class InternalZuc256Engine extends Zuc256CoreEngine {
        public InternalZuc256Engine(int r100) {
            super(r100);
        }

        public int createKeyStreamWord() {
            return super.makeKeyStreamWord();
        }
    }

    public Zuc256Mac(int r100) {
        this.theEngine = new InternalZuc256Engine(r100);
        this.theMacLength = r100;
        int r101 = r100 / 32;
        this.theMac = new int[r101];
        this.theKeyStream = new int[r101 + 1];
    }

    private int getKeyStreamWord(int r100, int r101) {
        int[] r102 = this.theKeyStream;
        int r103 = this.theWordIndex;
        int r104 = r102[(r103 + r100) % r102.length];
        if (r101 != 0) goto L5;
        return r104;
    L5:
        int r105 = r102[((r103 + r100) + 1) % r102.length];
        int r106 = r104 << r101;
        return (r105 >>> (32 - r101)) | r106;
    }

    private void initKeyStream() {
        int r100 = 0;
        int r101 = 0;
    L3:
        int[] r102 = this.theMac;
        if (r101 >= r102.length) goto L6;
        r102[r101] = this.theEngine.createKeyStreamWord();
        r101 = r101 + 1;
    L6:
        int[] r103 = this.theKeyStream;
        if (r100 >= (r103.length - 1)) goto L9;
        r103[r100] = this.theEngine.createKeyStreamWord();
        r100 = r100 + 1;
        goto L6
    L9:
        this.theWordIndex = r103.length - 1;
        this.theByteIndex = 3;
    }

    private void shift4Final() {
        int r100 = (this.theByteIndex + 1) % 4;
        this.theByteIndex = r100;
        if (r100 != 0) goto L6;
        this.theWordIndex = (this.theWordIndex + 1) % this.theKeyStream.length;
        return;
    }

    private void shift4NextByte() {
        int r100 = (this.theByteIndex + 1) % 4;
        this.theByteIndex = r100;
        if (r100 != 0) goto L6;
        this.theKeyStream[this.theWordIndex] = this.theEngine.createKeyStreamWord();
        this.theWordIndex = (this.theWordIndex + 1) % this.theKeyStream.length;
        return;
    }

    private void updateMac(int r100) {
        int r101 = 0;
    L3:
        int[] r102 = this.theMac;
        if (r101 >= r102.length) goto L6;
        r102[r101] = r102[r101] ^ getKeyStreamWord(r101, r100);
        r101 = r101 + 1;
        goto L3
    }

    @Override // org.bouncycastle.crypto.Mac
    public int doFinal(byte[] r100, int r101) {
        shift4Final();
        updateMac(this.theByteIndex * 8);
        int r102 = 0;
    L3:
        int[] r103 = this.theMac;
        if (r102 >= r103.length) goto L6;
        Zuc128CoreEngine.encode32be(r103[r102], r100, (r102 * 4) + r101);
        r102 = r102 + 1;
        goto L3
    L6:
        reset();
        return getMacSize();
    }

    @Override // org.bouncycastle.crypto.Mac
    public String getAlgorithmName() {
        return "Zuc256Mac-" + this.theMacLength;
    }

    @Override // org.bouncycastle.crypto.Mac
    public int getMacSize() {
        return this.theMacLength / 8;
    }

    @Override // org.bouncycastle.crypto.Mac
    public void init(CipherParameters r100) {
        this.theEngine.init(true, r100);
        this.theState = (Zuc256CoreEngine) this.theEngine.copy();
        initKeyStream();
    }

    @Override // org.bouncycastle.crypto.Mac
    public void reset() {
        Zuc256CoreEngine r100 = this.theState;
        if (r100 == null) goto L5;
        this.theEngine.reset(r100);
    L5:
        initKeyStream();
    }

    @Override // org.bouncycastle.crypto.Mac
    public void update(byte r100) {
        shift4NextByte();
        int r101 = this.theByteIndex * 8;
        int r102 = 128;
        int r103 = 0;
    L3:
        if (r102 <= 0) goto L8;
        if ((r100 & r102) == 0) goto L7;
        updateMac(r101 + r103);
    L7:
        r102 = r102 >> 1;
        r103 = r103 + 1;
        goto L3
    }

    @Override // org.bouncycastle.crypto.Mac
    public void update(byte[] r100, int r101, int r102) {
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        update(r100[r101 + r103]);
        r103 = r103 + 1;
        goto L3
    }
}
