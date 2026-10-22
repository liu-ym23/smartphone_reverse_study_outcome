package dagger.hilt.internal;

/* JADX INFO: loaded from: classes41.dex */
public final class Preconditions {
    private Preconditions() {
    }

    public static <T> T checkNotNull(T r100) {
        if (r100 == null) goto L5;
        return r100;
    L5:
        throw null;
    }

    public static <T> T checkNotNull(T r100, String r101) {
        if (r100 == null) goto L5;
        return r100;
    L5:
        throw new NullPointerException(r101);
    }

    public static void checkArgument(boolean r100, String r101, Object... r102) {
        if (r100 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(String.format(r101, r102));
    }

    public static void checkState(boolean r100, String r101, Object... r102) {
        if (r100 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(String.format(r101, r102));
    }
}
