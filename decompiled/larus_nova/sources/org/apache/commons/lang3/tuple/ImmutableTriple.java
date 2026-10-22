package org.apache.commons.lang3.tuple;

/* JADX INFO: loaded from: classes42.dex */
public final class ImmutableTriple<L, M, R> extends Triple<L, M, R> {
    private static final ImmutableTriple NULL = null;
    private static final long serialVersionUID = 1;
    public final L left;
    public final M middle;
    public final R right;

    static {
        NULL = of(null, null, null);
    }

    public static <L, M, R> ImmutableTriple<L, M, R> nullTriple() {
        return NULL;
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

    public ImmutableTriple(L r100, M r101, R r102) {
        this.left = r100;
        this.middle = r101;
        this.right = r102;
    }

    public static <L, M, R> ImmutableTriple<L, M, R> of(L r100, M r101, R r102) {
        return new ImmutableTriple(r100, r101, r102);
    }
}
