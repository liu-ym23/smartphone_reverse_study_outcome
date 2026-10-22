package org.bouncycastle.pqc.math.linearalgebra;

/* JADX INFO: loaded from: classes42.dex */
public abstract class GF2nElement implements GFElement {
    protected int mDegree;
    protected GF2nField mField;

    public GF2nElement() {
    }

    public abstract void assignOne();

    public abstract void assignZero();

    @Override // org.bouncycastle.pqc.math.linearalgebra.GFElement
    public abstract Object clone();

    public final GF2nElement convert(GF2nField r100) {
        return this.mField.convert(this, r100);
    }

    public final GF2nField getField() {
        return this.mField;
    }

    public abstract GF2nElement increase();

    public abstract void increaseThis();

    public abstract GF2nElement solveQuadraticEquation() throws RuntimeException;

    public abstract GF2nElement square();

    public abstract GF2nElement squareRoot();

    public abstract void squareRootThis();

    public abstract void squareThis();

    @Override // org.bouncycastle.pqc.math.linearalgebra.GFElement
    public final GFElement subtract(GFElement r100) {
        return add(r100);
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GFElement
    public final void subtractFromThis(GFElement r100) {
        addToThis(r100);
    }

    public abstract boolean testBit(int r100);

    public abstract boolean testRightmostBit();

    public abstract int trace();
}
