package org.apache.commons.lang3.tuple;

/* JADX INFO: loaded from: classes42.dex */
public final class ImmutablePair<L, R> extends Pair<L, R> {
    private static final ImmutablePair NULL = null;
    private static final long serialVersionUID = 4954918890077093841L;
    public final L left;
    public final R right;

    static {
        NULL = of(null, null);
    }

    public static <L, R> ImmutablePair<L, R> nullPair() {
        return NULL;
    }

    @Override // org.apache.commons.lang3.tuple.Pair
    public L getLeft() {
        return this.left;
    }

    @Override // org.apache.commons.lang3.tuple.Pair
    public R getRight() {
        return this.right;
    }

    @Override // java.util.Map.Entry
    public R setValue(R r100) {
        throw new UnsupportedOperationException();
    }

    public ImmutablePair(L r100, R r101) {
        this.left = r100;
        this.right = r101;
    }

    public static <L, R> ImmutablePair<L, R> of(L r100, R r101) {
        return new ImmutablePair(r100, r101);
    }
}
