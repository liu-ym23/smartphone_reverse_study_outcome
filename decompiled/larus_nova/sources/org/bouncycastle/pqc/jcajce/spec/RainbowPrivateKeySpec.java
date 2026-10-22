package org.bouncycastle.pqc.jcajce.spec;

import java.security.spec.KeySpec;
import org.bouncycastle.pqc.crypto.rainbow.Layer;

/* JADX INFO: loaded from: classes42.dex */
public class RainbowPrivateKeySpec implements KeySpec {
    private short[][] A1inv;
    private short[][] A2inv;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    private short[] f525604b1;

    /* JADX INFO: renamed from: b2, reason: collision with root package name */
    private short[] f525605b2;
    private Layer[] layers;

    /* JADX INFO: renamed from: vi, reason: collision with root package name */
    private int[] f525606vi;

    public RainbowPrivateKeySpec(short[][] r100, short[] r101, short[][] r102, short[] r103, int[] r104, Layer[] r105) {
        this.A1inv = r100;
        this.f525604b1 = r101;
        this.A2inv = r102;
        this.f525605b2 = r103;
        this.f525606vi = r104;
        this.layers = r105;
    }

    public short[] getB1() {
        return this.f525604b1;
    }

    public short[] getB2() {
        return this.f525605b2;
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
        return this.f525606vi;
    }
}
