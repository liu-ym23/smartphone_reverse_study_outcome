package org.apache.commons.lang3.tuple;

/* JADX INFO: loaded from: classes42.dex */
public class MutablePair<L, R> extends Pair<L, R> {
    private static final long serialVersionUID = 4954918890077093841L;
    public L left;
    public R right;

    public MutablePair() {
    }

    @Override // org.apache.commons.lang3.tuple.Pair
    public L getLeft() {
        return this.left;
    }

    @Override // org.apache.commons.lang3.tuple.Pair
    public R getRight() {
        return this.right;
    }

    public void setLeft(L r100) {
        this.left = r100;
    }

    public void setRight(R r100) {
        this.right = r100;
    }

    @Override // java.util.Map.Entry
    public R setValue(R r100) {
        R r101 = getRight();
        setRight(r100);
        return r101;
    }

    public MutablePair(L r100, R r101) {
        this.left = r100;
        this.right = r101;
    }

    public static <L, R> MutablePair<L, R> of(L r100, R r101) {
        return new MutablePair(r100, r101);
    }
}
