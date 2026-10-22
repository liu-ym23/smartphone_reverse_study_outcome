package org.bouncycastle.crypto.ec;

import org.bouncycastle.math.ec.ECPoint;

/* JADX INFO: loaded from: classes42.dex */
public class ECPair {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final ECPoint f525152x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final ECPoint f525153y;

    public ECPair(ECPoint r100, ECPoint r101) {
        this.f525152x = r100;
        this.f525153y = r101;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof ECPair) == true) goto L7;
        return false;
    L7:
        return equals((ECPair) r100);
    }

    public boolean equals(ECPair r100) {
        if (r100.getX().equals(getX()) == true) goto L5;
    L7:
        return false;
    L5:
        if (r100.getY().equals(getY()) == false) goto L7;
        return true;
    }

    public ECPoint getX() {
        return this.f525152x;
    }

    public ECPoint getY() {
        return this.f525153y;
    }

    public int hashCode() {
        return this.f525152x.hashCode() + (this.f525153y.hashCode() * 37);
    }
}
