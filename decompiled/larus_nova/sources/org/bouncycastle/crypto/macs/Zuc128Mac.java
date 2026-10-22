package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.engines.Zuc128CoreEngine;

/* JADX INFO: loaded from: classes42.dex */
public final class Zuc128Mac implements Mac {
    private static final int TOPBIT = 128;
    private int theByteIndex;
    private final InternalZuc128Engine theEngine;
    private final int[] theKeyStream;
    private int theMac;
    private Zuc128CoreEngine theState;
    private int theWordIndex;

    /* JADX INFO: renamed from: org.bouncycastle.crypto.macs.Zuc128Mac$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class InternalZuc128Engine extends Zuc128CoreEngine {
        private InternalZuc128Engine() {
        }

        public /* synthetic */ InternalZuc128Engine(AnonymousClass1 r100) {
            this();
        }

        public int createKeyStreamWord() {
            return super.makeKeyStreamWord();
        }
    }

    public Zuc128Mac() {
        this.theEngine = new InternalZuc128Engine(null);
        this.theKeyStream = new int[2];
    }

    private int getFinalWord() {
        if (this.theByteIndex != 0) goto L5;
        int r100 = this.theWordIndex + 1;
        int[] r101 = this.theKeyStream;
        int r102 = r100 % r101.length;
        this.theWordIndex = r102;
        return r101[r102];
    L5:
        return this.theEngine.createKeyStreamWord();
    }

    private int getKeyStreamWord(int r100) {
        int[] r101 = this.theKeyStream;
        int r102 = this.theWordIndex;
        int r103 = r101[r102];
        if (r100 != 0) goto L5;
        return r103;
    L5:
        int r104 = r101[(r102 + 1) % r101.length];
        int r105 = r103 << r100;
        return (r104 >>> (32 - r100)) | r105;
    }

    private void initKeyStream() {
        int r100 = 0;
        this.theMac = 0;
    L3:
        int[] r101 = this.theKeyStream;
        if (r100 >= (r101.length - 1)) goto L6;
        r101[r100] = this.theEngine.createKeyStreamWord();
        r100 = r100 + 1;
        goto L3
    L6:
        this.theWordIndex = r101.length - 1;
        this.theByteIndex = 3;
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
        int r101 = this.theMac;
        this.theMac = getKeyStreamWord(r100) ^ r101;
    }

    @Override // org.bouncycastle.crypto.Mac
    public int doFinal(byte[] r100, int r101) {
        shift4NextByte();
        int r102 = this.theMac ^ getKeyStreamWord(this.theByteIndex * 8);
        this.theMac = r102;
        int r103 = r102 ^ getFinalWord();
        this.theMac = r103;
        Zuc128CoreEngine.encode32be(r103, r100, r101);
        reset();
        return getMacSize();
    }

    @Override // org.bouncycastle.crypto.Mac
    public String getAlgorithmName() {
        return "Zuc128Mac";
    }

    @Override // org.bouncycastle.crypto.Mac
    public int getMacSize() {
        return 4;
    }

    @Override // org.bouncycastle.crypto.Mac
    public void init(CipherParameters r100) {
        this.theEngine.init(true, r100);
        this.theState = (Zuc128CoreEngine) this.theEngine.copy();
        initKeyStream();
    }

    @Override // org.bouncycastle.crypto.Mac
    public void reset() {
        Zuc128CoreEngine r100 = this.theState;
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
