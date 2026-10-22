package org.bouncycastle.math.ec.custom.sec;

import com.ss.ttm.player.MediaPlayer;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat320;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class SecT283FieldElement extends ECFieldElement.AbstractF2m {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    protected long[] f525476x;

    public SecT283FieldElement() {
        this.f525476x = Nat320.create64();
    }

    public SecT283FieldElement(BigInteger r100) {
        if (r100 == null) goto L11;
        if (r100.signum() < 0) goto L11;
        if (r100.bitLength() > 283) goto L11;
        this.f525476x = SecT283Field.fromBigInteger(r100);
        return;
    L11:
        throw new IllegalArgumentException("x value invalid for SecT283FieldElement");
    }

    public SecT283FieldElement(long[] r100) {
        this.f525476x = r100;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement add(ECFieldElement r100) {
        long[] r101 = Nat320.create64();
        SecT283Field.add(this.f525476x, ((SecT283FieldElement) r100).f525476x, r101);
        return new SecT283FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement addOne() {
        long[] r100 = Nat320.create64();
        SecT283Field.addOne(this.f525476x, r100);
        return new SecT283FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement divide(ECFieldElement r100) {
        return multiply(r100.invert());
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof SecT283FieldElement) == true) goto L10;
        return false;
    L10:
        return Nat320.eq64(this.f525476x, ((SecT283FieldElement) r100).f525476x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public String getFieldName() {
        return "SecT283Field";
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public int getFieldSize() {
        return MediaPlayer.MEDIA_PLAYER_OPTION_GET_CUR_UI_FPS;
    }

    public int getK1() {
        return 5;
    }

    public int getK2() {
        return 7;
    }

    public int getK3() {
        return 12;
    }

    public int getM() {
        return MediaPlayer.MEDIA_PLAYER_OPTION_GET_CUR_UI_FPS;
    }

    public int getRepresentation() {
        return 3;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement.AbstractF2m
    public ECFieldElement halfTrace() {
        long[] r100 = Nat320.create64();
        SecT283Field.halfTrace(this.f525476x, r100);
        return new SecT283FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement.AbstractF2m
    public boolean hasFastTrace() {
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f525476x, 0, 5) ^ 2831275;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement invert() {
        long[] r100 = Nat320.create64();
        SecT283Field.invert(this.f525476x, r100);
        return new SecT283FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean isOne() {
        return Nat320.isOne64(this.f525476x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean isZero() {
        return Nat320.isZero64(this.f525476x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement r100) {
        long[] r101 = Nat320.create64();
        SecT283Field.multiply(this.f525476x, ((SecT283FieldElement) r100).f525476x, r101);
        return new SecT283FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement multiplyMinusProduct(ECFieldElement r100, ECFieldElement r101, ECFieldElement r102) {
        return multiplyPlusProduct(r100, r101, r102);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement multiplyPlusProduct(ECFieldElement r100, ECFieldElement r101, ECFieldElement r102) {
        long[] r103 = this.f525476x;
        long[] r104 = ((SecT283FieldElement) r100).f525476x;
        long[] r105 = ((SecT283FieldElement) r101).f525476x;
        long[] r106 = ((SecT283FieldElement) r102).f525476x;
        long[] r107 = Nat.create64(9);
        SecT283Field.multiplyAddToExt(r103, r104, r107);
        SecT283Field.multiplyAddToExt(r105, r106, r107);
        long[] r108 = Nat320.create64();
        SecT283Field.reduce(r107, r108);
        return new SecT283FieldElement(r108);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement negate() {
        return this;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement sqrt() {
        long[] r100 = Nat320.create64();
        SecT283Field.sqrt(this.f525476x, r100);
        return new SecT283FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement square() {
        long[] r100 = Nat320.create64();
        SecT283Field.square(this.f525476x, r100);
        return new SecT283FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement squareMinusProduct(ECFieldElement r100, ECFieldElement r101) {
        return squarePlusProduct(r100, r101);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement squarePlusProduct(ECFieldElement r100, ECFieldElement r101) {
        long[] r102 = this.f525476x;
        long[] r103 = ((SecT283FieldElement) r100).f525476x;
        long[] r104 = ((SecT283FieldElement) r101).f525476x;
        long[] r105 = Nat.create64(9);
        SecT283Field.squareAddToExt(r102, r105);
        SecT283Field.multiplyAddToExt(r103, r104, r105);
        long[] r106 = Nat320.create64();
        SecT283Field.reduce(r105, r106);
        return new SecT283FieldElement(r106);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement squarePow(int r100) {
        if (r100 >= 1) goto L5;
        return this;
    L5:
        long[] r101 = Nat320.create64();
        SecT283Field.squareN(this.f525476x, r100, r101);
        return new SecT283FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement r100) {
        return add(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean testBitZero() {
        if ((this.f525476x[0] & 1) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public BigInteger toBigInteger() {
        return Nat320.toBigInteger64(this.f525476x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement.AbstractF2m
    public int trace() {
        return SecT283Field.trace(this.f525476x);
    }
}
