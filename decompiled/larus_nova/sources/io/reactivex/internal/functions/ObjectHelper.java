package io.reactivex.internal.functions;

import io.reactivex.functions.BiPredicate;

/* JADX INFO: loaded from: classes41.dex */
public final class ObjectHelper {
    static final BiPredicate<Object, Object> EQUALS = null;

    public static final class a implements BiPredicate<Object, Object> {
        public a() {
        }

        @Override // io.reactivex.functions.BiPredicate
        public final boolean test(Object r100, Object r101) {
            return ObjectHelper.equals(r100, r101);
        }
    }

    public static int compare(int r100, int r101) {
        if (r100 >= r101) goto L4;
        return -1;
    L4:
        if (r100 <= r101) goto L6;
        return 1;
    L6:
        return 0;
    }

    public static int compare(long r100, long r101) {
        if (r100 >= r101) goto L5;
        return -1;
    L5:
        if (r100 <= r101) goto L7;
        return 1;
    L7:
        return 0;
    }

    static {
        EQUALS = new a();
    }

    private ObjectHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> BiPredicate<T, T> equalsPredicate() {
        return (BiPredicate<T, T>) EQUALS;
    }

    public static int hashCode(Object r100) {
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public static boolean equals(Object r100, Object r101) {
        if (r100 == r101) goto L8;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.equals(r101) == false) goto L7;
    L8:
        return true;
    }

    public static long requireNonNull(long r100, String r101) {
        throw new InternalError("Null check on a primitive: " + r101);
    }

    public static long verifyPositive(long r100, String r101) {
        if (r100 <= 0) goto L6;
        return r100;
    L6:
        throw new IllegalArgumentException(r101 + " > 0 required but it was " + r100);
    }

    public static <T> T requireNonNull(T r100, String r101) {
        if (r100 == null) goto L5;
        return r100;
    L5:
        throw new NullPointerException(r101);
    }

    public static int verifyPositive(int r100, String r101) {
        if (r100 <= 0) goto L5;
        return r100;
    L5:
        throw new IllegalArgumentException(r101 + " > 0 required but it was " + r100);
    }
}
