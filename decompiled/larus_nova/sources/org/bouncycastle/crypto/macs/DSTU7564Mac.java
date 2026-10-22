package org.bouncycastle.crypto.macs;

import kotlin.jvm.internal.ByteCompanionObject;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.digests.DSTU7564Digest;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class DSTU7564Mac implements Mac {
    private static final int BITS_IN_BYTE = 8;
    private DSTU7564Digest engine;
    private long inputLength;
    private byte[] invertedKey;
    private int macSize;
    private byte[] paddedKey;

    public DSTU7564Mac(int r100) {
        this.engine = new DSTU7564Digest(r100);
        this.macSize = r100 / 8;
        this.paddedKey = null;
        this.invertedKey = null;
    }

    private void pad() {
        int r100 = this.engine.getByteLength() - ((int) (this.inputLength % ((long) this.engine.getByteLength())));
        if (r100 >= 13) goto L5;
        r100 = r100 + this.engine.getByteLength();
    L5:
        byte[] r101 = new byte[r100];
        r101[0] = ByteCompanionObject.MIN_VALUE;
        Pack.longToLittleEndian(this.inputLength * 8, r101, r100 - 12);
        this.engine.update(r101, 0, r100);
    }

    private byte[] padKey(byte[] r100) {
        int r101 = (((r100.length + this.engine.getByteLength()) - 1) / this.engine.getByteLength()) * this.engine.getByteLength();
        if ((r101 - r100.length) >= 13) goto L5;
        r101 = r101 + this.engine.getByteLength();
    L5:
        byte[] r102 = new byte[r101];
        System.arraycopy(r100, 0, r102, 0, r100.length);
        r102[r100.length] = ByteCompanionObject.MIN_VALUE;
        Pack.intToLittleEndian(r100.length * 8, r102, r101 - 12);
        return r102;
    }

    @Override // org.bouncycastle.crypto.Mac
    public int doFinal(byte[] r100, int r101) throws DataLengthException, IllegalStateException {
        if (this.paddedKey == null) goto L11;
        if ((r100.length - r101) < this.macSize) goto L9;
        pad();
        DSTU7564Digest r102 = this.engine;
        byte[] r103 = this.invertedKey;
        r102.update(r103, 0, r103.length);
        this.inputLength = 0;
        int r104 = this.engine.doFinal(r100, r101);
        reset();
        return r104;
    L9:
        throw new OutputLengthException("Output buffer too short");
    L11:
        throw new IllegalStateException(getAlgorithmName() + " not initialised");
    }

    @Override // org.bouncycastle.crypto.Mac
    public String getAlgorithmName() {
        return "DSTU7564Mac";
    }

    @Override // org.bouncycastle.crypto.Mac
    public int getMacSize() {
        return this.macSize;
    }

    @Override // org.bouncycastle.crypto.Mac
    public void init(CipherParameters r100) throws IllegalArgumentException {
        this.paddedKey = null;
        reset();
        if ((r100 instanceof KeyParameter) == false) goto L11;
        byte[] r101 = ((KeyParameter) r100).getKey();
        this.invertedKey = new byte[r101.length];
        this.paddedKey = padKey(r101);
        int r102 = 0;
    L5:
        byte[] r103 = this.invertedKey;
        if (r102 >= r103.length) goto L8;
        r103[r102] = (byte) (~r101[r102]);
        r102 = r102 + 1;
        goto L5
    L8:
        DSTU7564Digest r104 = this.engine;
        byte[] r105 = this.paddedKey;
        r104.update(r105, 0, r105.length);
        return;
    L11:
        throw new IllegalArgumentException("Bad parameter passed");
    }

    @Override // org.bouncycastle.crypto.Mac
    public void reset() {
        this.inputLength = 0;
        this.engine.reset();
        byte[] r100 = this.paddedKey;
        if (r100 == null) goto L6;
        this.engine.update(r100, 0, r100.length);
        return;
    }

    @Override // org.bouncycastle.crypto.Mac
    public void update(byte r100) throws IllegalStateException {
        this.engine.update(r100);
        this.inputLength++;
    }

    @Override // org.bouncycastle.crypto.Mac
    public void update(byte[] r100, int r101, int r102) throws DataLengthException, IllegalStateException {
        if ((r100.length - r101) < r102) goto L11;
        if (this.paddedKey == null) goto L9;
        this.engine.update(r100, r101, r102);
        this.inputLength += (long) r102;
        return;
    L9:
        throw new IllegalStateException(getAlgorithmName() + " not initialised");
    L11:
        throw new DataLengthException("Input buffer too short");
    }
}
