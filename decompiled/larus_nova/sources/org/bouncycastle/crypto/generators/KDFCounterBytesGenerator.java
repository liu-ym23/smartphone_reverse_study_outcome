package org.bouncycastle.crypto.generators;

import androidx.collection.SieveCacheKt;
import java.math.BigInteger;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.MacDerivationFunction;
import org.bouncycastle.crypto.params.KDFCounterParameters;
import org.bouncycastle.crypto.params.KeyParameter;

/* JADX INFO: loaded from: classes42.dex */
public class KDFCounterBytesGenerator implements MacDerivationFunction {
    private static final BigInteger INTEGER_MAX = null;
    private static final BigInteger TWO = null;
    private byte[] fixedInputDataCtrPrefix;
    private byte[] fixedInputData_afterCtr;
    private int generatedBytes;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f525212h;
    private byte[] ios;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private byte[] f525213k;
    private int maxSizeExcl;
    private final Mac prf;

    static {
        INTEGER_MAX = BigInteger.valueOf(SieveCacheKt.NodeLinkMask);
        TWO = BigInteger.valueOf(2);
    }

    public KDFCounterBytesGenerator(Mac r100) {
        this.prf = r100;
        int r101 = r100.getMacSize();
        this.f525212h = r101;
        this.f525213k = new byte[r101];
    }

    private void generateNext() {
        int r100 = (this.generatedBytes / this.f525212h) + 1;
        byte[] r101 = this.ios;
        int r102 = r101.length;
        if (r102 != 1) goto L5;
    L15:
        r101[r101.length - 1] = (byte) r100;
        Mac r103 = this.prf;
        byte[] r104 = this.fixedInputDataCtrPrefix;
        r103.update(r104, 0, r104.length);
        Mac r105 = this.prf;
        byte[] r106 = this.ios;
        r105.update(r106, 0, r106.length);
        Mac r107 = this.prf;
        byte[] r108 = this.fixedInputData_afterCtr;
        r107.update(r108, 0, r108.length);
        this.prf.doFinal(this.f525213k, 0);
        return;
    L5:
        if (r102 != 2) goto L7;
    L14:
        r101[r101.length - 2] = (byte) (r100 >>> 8);
        goto L15
    L7:
        if (r102 != 3) goto L9;
    L13:
        r101[r101.length - 3] = (byte) (r100 >>> 16);
        goto L14
    L9:
        if (r102 != 4) goto L12;
        r101[0] = (byte) (r100 >>> 24);
        goto L13
    L12:
        throw new IllegalStateException("Unsupported size of counter i");
    }

    @Override // org.bouncycastle.crypto.DerivationFunction
    public int generateBytes(byte[] r100, int r101, int r102) throws DataLengthException, IllegalArgumentException {
        int r103 = this.generatedBytes;
        int r104 = r103 + r102;
        if (r104 < 0) goto L15;
        if (r104 >= this.maxSizeExcl) goto L15;
        if ((r103 % this.f525212h) != 0) goto L9;
        generateNext();
    L9:
        int r105 = this.generatedBytes;
        int r106 = this.f525212h;
        int r107 = r105 % r106;
        int r108 = Math.min(r106 - (r105 % r106), r102);
        System.arraycopy(this.f525213k, r107, r100, r101, r108);
        this.generatedBytes += r108;
        int r109 = r102 - r108;
    L10:
        r101 = r101 + r108;
        if (r109 <= 0) goto L13;
        generateNext();
        r108 = Math.min(this.f525212h, r109);
        System.arraycopy(this.f525213k, 0, r100, r101, r108);
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
        if ((r100 instanceof KDFCounterParameters) == false) goto L11;
        KDFCounterParameters r101 = (KDFCounterParameters) r100;
        this.prf.init(new KeyParameter(r101.getKI()));
        this.fixedInputDataCtrPrefix = r101.getFixedInputDataCounterPrefix();
        this.fixedInputData_afterCtr = r101.getFixedInputDataCounterSuffix();
        int r102 = r101.getR();
        this.ios = new byte[r102 / 8];
        BigInteger r103 = TWO.pow(r102).multiply(BigInteger.valueOf(this.f525212h));
        if (r103.compareTo(INTEGER_MAX) != 1) goto L7;
        int r104 = Integer.MAX_VALUE;
    L8:
        this.maxSizeExcl = r104;
        this.generatedBytes = 0;
        return;
    L7:
        r104 = r103.intValue();
        goto L8
    L11:
        throw new IllegalArgumentException("Wrong type of arguments given");
    }
}
