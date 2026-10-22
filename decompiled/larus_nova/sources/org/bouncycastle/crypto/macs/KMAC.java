package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.Xof;
import org.bouncycastle.crypto.digests.CSHAKEDigest;
import org.bouncycastle.crypto.digests.XofUtils;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes42.dex */
public class KMAC implements Mac, Xof {
    private static final byte[] padding = null;
    private final int bitLength;
    private final CSHAKEDigest cshake;
    private boolean firstOutput;
    private boolean initialised;
    private byte[] key;
    private final int outputLength;

    static {
        padding = new byte[100];
    }

    public KMAC(int r100, byte[] r101) {
        this.cshake = new CSHAKEDigest(r100, Strings.toByteArray("KMAC"), r101);
        this.bitLength = r100;
        this.outputLength = (r100 * 2) / 8;
    }

    private void bytePad(byte[] r100, int r101) {
        byte[] r102 = XofUtils.leftEncode(r101);
        update(r102, 0, r102.length);
        byte[] r103 = encode(r100);
        update(r103, 0, r103.length);
        int r104 = r101 - ((r102.length + r103.length) % r101);
        if (r104 <= 0) goto L11;
        if (r104 == r101) goto L12;
    L5:
        byte[] r105 = padding;
        if (r104 <= r105.length) goto L8;
        update(r105, 0, r105.length);
        r104 = r104 - r105.length;
        goto L5
    L8:
        update(r105, 0, r104);
        return;
    L12:
        return;
    }

    private static byte[] encode(byte[] r100) {
        return Arrays.concatenate(XofUtils.leftEncode(r100.length * 8), r100);
    }

    @Override // org.bouncycastle.crypto.Mac
    public int doFinal(byte[] r100, int r101) throws DataLengthException, IllegalStateException {
        if (this.firstOutput == true) goto L5;
    L9:
        int r102 = this.cshake.doFinal(r100, r101, getMacSize());
        reset();
        return r102;
    L5:
        if (this.initialised == false) goto L8;
        byte[] r103 = XofUtils.rightEncode(getMacSize() * 8);
        this.cshake.update(r103, 0, r103.length);
        goto L9
    L8:
        throw new IllegalStateException("KMAC not initialized");
    }

    @Override // org.bouncycastle.crypto.Xof
    public int doFinal(byte[] r100, int r101, int r102) {
        if (this.firstOutput == true) goto L5;
    L9:
        int r103 = this.cshake.doFinal(r100, r101, r102);
        reset();
        return r103;
    L5:
        if (this.initialised == false) goto L8;
        byte[] r104 = XofUtils.rightEncode(r102 * 8);
        this.cshake.update(r104, 0, r104.length);
        goto L9
    L8:
        throw new IllegalStateException("KMAC not initialized");
    }

    @Override // org.bouncycastle.crypto.Xof
    public int doOutput(byte[] r100, int r101, int r102) {
        if (this.firstOutput == false) goto L10;
        if (this.initialised == false) goto L8;
        byte[] r103 = XofUtils.rightEncode(0);
        this.cshake.update(r103, 0, r103.length);
        this.firstOutput = false;
        goto L10
    L8:
        throw new IllegalStateException("KMAC not initialized");
    L10:
        return this.cshake.doOutput(r100, r101, r102);
    }

    @Override // org.bouncycastle.crypto.Mac
    public String getAlgorithmName() {
        return "KMAC" + this.cshake.getAlgorithmName().substring(6);
    }

    @Override // org.bouncycastle.crypto.ExtendedDigest
    public int getByteLength() {
        return this.cshake.getByteLength();
    }

    @Override // org.bouncycastle.crypto.Digest
    public int getDigestSize() {
        return this.outputLength;
    }

    @Override // org.bouncycastle.crypto.Mac
    public int getMacSize() {
        return this.outputLength;
    }

    @Override // org.bouncycastle.crypto.Mac
    public void init(CipherParameters r100) throws IllegalArgumentException {
        this.key = Arrays.clone(((KeyParameter) r100).getKey());
        this.initialised = true;
        reset();
    }

    @Override // org.bouncycastle.crypto.Mac
    public void reset() {
        this.cshake.reset();
        byte[] r100 = this.key;
        if (r100 != null) goto L5;
    L9:
        this.firstOutput = true;
        return;
    L5:
        if (this.bitLength != 128) goto L7;
        int r101 = 168;
    L8:
        bytePad(r100, r101);
        goto L9
    L7:
        r101 = 136;
        goto L8
    }

    @Override // org.bouncycastle.crypto.Mac
    public void update(byte r100) throws IllegalStateException {
        if (this.initialised == false) goto L7;
        this.cshake.update(r100);
        return;
    L7:
        throw new IllegalStateException("KMAC not initialized");
    }

    @Override // org.bouncycastle.crypto.Mac
    public void update(byte[] r100, int r101, int r102) throws DataLengthException, IllegalStateException {
        if (this.initialised == false) goto L7;
        this.cshake.update(r100, r101, r102);
        return;
    L7:
        throw new IllegalStateException("KMAC not initialized");
    }
}
