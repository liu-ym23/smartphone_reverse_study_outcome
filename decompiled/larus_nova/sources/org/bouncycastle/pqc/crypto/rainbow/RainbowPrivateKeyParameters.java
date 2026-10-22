package org.bouncycastle.pqc.crypto.rainbow;

/* JADX INFO: loaded from: classes42.dex */
public class RainbowPrivateKeyParameters extends RainbowKeyParameters {
    private short[][] A1inv;
    private short[][] A2inv;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    private short[] f525586b1;

    /* JADX INFO: renamed from: b2, reason: collision with root package name */
    private short[] f525587b2;
    private Layer[] layers;

    /* JADX INFO: renamed from: vi, reason: collision with root package name */
    private int[] f525588vi;

    public RainbowPrivateKeyParameters(short[][] r100, short[] r101, short[][] r102, short[] r103, int[] r104, Layer[] r105) {
        super(true, r104[r104.length - 1] - r104[0]);
        this.A1inv = r100;
        this.f525586b1 = r101;
        this.A2inv = r102;
        this.f525587b2 = r103;
        this.f525588vi = r104;
        this.layers = r105;
    }

    public short[] getB1() {
        return this.f525586b1;
    }

    public short[] getB2() {
        return this.f525587b2;
    }

    public short[][] getInvA1() {
        return this.A1inv;
    }

    public short[][] getInvA2() {
        return this.A2inv;
    }

    public Layer[] getLayers() {
        return this.layers;
    }

    public int[] getVi() {
        return this.f525588vi;
    }
}
