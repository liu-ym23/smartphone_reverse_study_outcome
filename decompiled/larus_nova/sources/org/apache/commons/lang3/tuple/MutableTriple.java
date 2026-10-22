package org.apache.commons.lang3.tuple;

/* JADX INFO: loaded from: classes42.dex */
public class MutableTriple<L, M, R> extends Triple<L, M, R> {
    private static final long serialVersionUID = 1;
    public L left;
    public M middle;
    public R right;

    public MutableTriple() {
    }

    @Override // org.apache.commons.lang3.tuple.Triple
    public L getLeft() {
        return this.left;
    }

    @Override // org.apache.commons.lang3.tuple.Triple
    public M getMiddle() {
        return this.middle;
    }

    @Override // org.apache.commons.lang3.tuple.Triple
    public R getRight() {
        return this.right;
    }

    public void setLeft(L r100) {
        this.left = r100;
    }

    public void setMiddle(M r100) {
        this.middle = r100;
    }

    public void setRight(R r100) {
        this.right = r100;
    }

    public MutableTriple(L r100, M r101, R r102) {
        this.left = r100;
        this.middle = r101;
        this.right = r102;
    }

    public static <L, M, R> MutableTriple<L, M, R> of(L r100, M r101, R r102) {
        return new MutableTriple(r100, r101, r102);
    }
}
