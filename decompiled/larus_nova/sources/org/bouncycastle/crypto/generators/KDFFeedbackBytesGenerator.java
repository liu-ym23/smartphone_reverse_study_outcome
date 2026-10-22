package org.bouncycastle.crypto.generators;

import androidx.collection.SieveCacheKt;
import java.math.BigInteger;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.MacDerivationFunction;
import org.bouncycastle.crypto.params.KDFFeedbackParameters;
import org.bouncycastle.crypto.params.KeyParameter;

/* JADX INFO: loaded from: classes42.dex */
public class KDFFeedbackBytesGenerator implements MacDerivationFunction {
    private static final BigInteger INTEGER_MAX = null;
    private static final BigInteger TWO = null;
    private byte[] fixedInputData;
    private int generatedBytes;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f525217h;
    private byte[] ios;

    /* JADX INFO: renamed from: iv, reason: collision with root package name */
    private byte[] f525218iv;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private byte[] f525219k;
    private int maxSizeExcl;
    private final Mac prf;
    private boolean useCounter;

    static {
        INTEGER_MAX = BigInteger.valueOf(SieveCacheKt.NodeLinkMask);
        TWO = BigInteger.valueOf(2);
    }

    public KDFFeedbackBytesGenerator(Mac r100) {
        this.prf = r100;
        int r101 = r100.getMacSize();
        this.f525217h = r101;
        this.f525219k = new byte[r101];
    }

    private void generateNext() {
        if (this.generatedBytes != 0) goto L5;
        Mac r100 = this.prf;
        byte[] r101 = this.f525218iv;
        r100.update(r101, 0, r101.length);
    L7:
        if (this.useCounter == false) goto L22;
        int r102 = (this.generatedBytes / this.f525217h) + 1;
        byte[] r103 = this.ios;
        int r104 = r103.length;
        if (r104 != 1) goto L11;
    L21:
        r103[r103.length - 1] = (byte) r102;
        this.prf.update(r103, 0, r103.length);
        goto L22
    L11:
        if (r104 != 2) goto L13;
    L20:
        r103[r103.length - 2] = (byte) (r102 >>> 8);
        goto L21
    L13:
        if (r104 != 3) goto L15;
    L19:
        r103[r103.length - 3] = (byte) (r102 >>> 16);
        goto L20
    L15:
        if (r104 != 4) goto L18;
        r103[0] = (byte) (r102 >>> 24);
        goto L19
    L18:
        throw new IllegalStateException("Unsupported size of counter i");
    L22:
        Mac r105 = this.prf;
        byte[] r106 = this.fixedInputData;
        r105.update(r106, 0, r106.length);
        this.prf.doFinal(this.f525219k, 0);
        return;
    L5:
        Mac r107 = this.prf;
        byte[] r108 = this.f525219k;
        r107.update(r108, 0, r108.length);
        goto L7
    }

    @Override // org.bouncycastle.crypto.DerivationFunction
    public int generateBytes(byte[] r100, int r101, int r102) throws DataLengthException, IllegalArgumentException {
        int r103 = this.generatedBytes;
        int r104 = r103 + r102;
        if (r104 < 0) goto L15;
        if (r104 >= this.maxSizeExcl) goto L15;
        if ((r103 % this.f525217h) != 0) goto L9;
        generateNext();
    L9:
        int r105 = this.generatedBytes;
        int r106 = this.f525217h;
        int r107 = r105 % r106;
        int r108 = Math.min(r106 - (r105 % r106), r102);
        System.arraycopy(this.f525219k, r107, r100, r101, r108);
        this.generatedBytes += r108;
        int r109 = r102 - r108;
    L10:
        r101 = r101 + r108;
        if (r109 <= 0) goto L13;
        generateNext();
        r108 = Math.min(this.f525217h, r109);
        System.arraycopy(this.f525219k, 0, r100, r101, r108);
        this.generatedBytes += r108;
        r109 = r109 - r108;
        goto L10
    L13:
        return r102;
    L15:
        throw new DataLengthException("Current KDFCTR may only be used for " + this.maxSizeExcl + " bytes");
    }

    @Override // org.bouncycastle.crypto.MacDerivationFunction
    public Mac getMac() {
        return this.prf;
    }

    @Override // org.bouncycastle.crypto.DerivationFunction
    public void init(DerivationParameters r100) {
        if ((r100 instanceof KDFFeedbackParameters) == false) goto L13;
        KDFFeedbackParameters r101 = (KDFFeedbackParameters) r100;
        this.prf.init(new KeyParameter(r101.getKI()));
        this.fixedInputData = r101.getFixedInputData();
        int r102 = r101.getR();
        this.ios = new byte[r102 / 8];
        int r103 = Integer.MAX_VALUE;
        if (r101.useCounter() == false) goto L10;
        BigInteger r104 = TWO.pow(r102).multiply(BigInteger.valueOf(this.f525217h));
        if (r104.compareTo(INTEGER_MAX) == 1) goto L10;
        r103 = r104.intValue();
    L10:
        this.maxSizeExcl = r103;
        this.f525218iv = r101.getIV();
        this.useCounter = r101.useCounter();
        this.generatedBytes = 0;
        return;
    L13:
        throw new IllegalArgumentException("Wrong type of arguments given");
    }
}
