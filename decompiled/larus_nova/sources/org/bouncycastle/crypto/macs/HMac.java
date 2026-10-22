package org.bouncycastle.crypto.macs;

import java.util.Hashtable;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Memoable;

/* JADX INFO: loaded from: classes42.dex */
public class HMac implements Mac {
    private static final byte IPAD = 54;
    private static final byte OPAD = 92;
    private static Hashtable blockLengths;
    private int blockLength;
    private Digest digest;
    private int digestSize;
    private byte[] inputPad;
    private Memoable ipadState;
    private Memoable opadState;
    private byte[] outputBuf;

    static {
        Hashtable r100 = new Hashtable();
        blockLengths = r100;
        r100.put("GOST3411", Integers.valueOf(32));
        blockLengths.put("MD2", Integers.valueOf(16));
        blockLengths.put("MD4", Integers.valueOf(64));
        blockLengths.put("MD5", Integers.valueOf(64));
        blockLengths.put("RIPEMD128", Integers.valueOf(64));
        blockLengths.put("RIPEMD160", Integers.valueOf(64));
        blockLengths.put("SHA-1", Integers.valueOf(64));
        blockLengths.put(McElieceCCA2KeyGenParameterSpec.SHA224, Integers.valueOf(64));
        blockLengths.put("SHA-256", Integers.valueOf(64));
        blockLengths.put(McElieceCCA2KeyGenParameterSpec.SHA384, Integers.valueOf(128));
        blockLengths.put("SHA-512", Integers.valueOf(128));
        blockLengths.put("Tiger", Integers.valueOf(64));
        blockLengths.put("Whirlpool", Integers.valueOf(64));
    }

    public HMac(Digest r100) {
        this(r100, getByteLength(r100));
    }

    private HMac(Digest r100, int r101) {
        this.digest = r100;
        int r102 = r100.getDigestSize();
        this.digestSize = r102;
        this.blockLength = r101;
        this.inputPad = new byte[r101];
        this.outputBuf = new byte[r101 + r102];
    }

    private static int getByteLength(Digest r100) {
        if ((r100 instanceof ExtendedDigest) == true) goto L5;
        Integer r101 = (Integer) blockLengths.get(r100.getAlgorithmName());
        if (r101 == null) goto L11;
        return r101.intValue();
    L11:
        throw new IllegalArgumentException("unknown digest passed: " + r100.getAlgorithmName());
    L5:
        return ((ExtendedDigest) r100).getByteLength();
    }

    private static void xorPad(byte[] r100, int r101, byte r102) {
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L5;
        r100[r103] = (byte) (r100[r103] ^ r102);
        r103 = r103 + 1;
        goto L3
    }

    @Override // org.bouncycastle.crypto.Mac
    public int doFinal(byte[] r100, int r101) {
        this.digest.doFinal(this.outputBuf, this.blockLength);
        Memoable r102 = this.opadState;
        if (r102 == null) goto L5;
        ((Memoable) this.digest).reset(r102);
        Digest r103 = this.digest;
        r103.update(this.outputBuf, this.blockLength, r103.getDigestSize());
    L6:
        int r104 = this.digest.doFinal(r100, r101);
        int r105 = this.blockLength;
    L7:
        byte[] r106 = this.outputBuf;
        if (r105 >= r106.length) goto L10;
        r106[r105] = 0;
        r105 = r105 + 1;
        goto L7
    L10:
        Memoable r107 = this.ipadState;
        if (r107 == null) goto L13;
        ((Memoable) this.digest).reset(r107);
    L14:
        return r104;
    L13:
        Digest r108 = this.digest;
        byte[] r109 = this.inputPad;
        r108.update(r109, 0, r109.length);
        goto L14
    L5:
        Digest r110 = this.digest;
        byte[] r111 = this.outputBuf;
        r110.update(r111, 0, r111.length);
        goto L6
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
        int r102 = r101.length;
        if (r102 <= this.blockLength) goto L5;
        this.digest.update(r101, 0, r102);
        this.digest.doFinal(this.inputPad, 0);
        r102 = this.digestSize;
    L6:
        byte[] r103 = this.inputPad;
        if (r102 >= r103.length) goto L9;
        r103[r102] = 0;
        r102 = r102 + 1;
        goto L6
    L9:
        System.arraycopy(r103, 0, this.outputBuf, 0, this.blockLength);
        xorPad(this.inputPad, this.blockLength, IPAD);
        xorPad(this.outputBuf, this.blockLength, OPAD);
        Digest r104 = this.digest;
        if ((r104 instanceof Memoable) == false) goto L12;
        Memoable r105 = ((Memoable) r104).copy();
        this.opadState = r105;
        ((Digest) r105).update(this.outputBuf, 0, this.blockLength);
    L12:
        Digest r106 = this.digest;
        byte[] r107 = this.inputPad;
        r106.update(r107, 0, r107.length);
        Digest r108 = this.digest;
        if ((r108 instanceof Memoable) == false) goto L18;
        this.ipadState = ((Memoable) r108).copy();
        return;
    L18:
        return;
    L5:
        System.arraycopy(r101, 0, this.inputPad, 0, r102);
        goto L6
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
