package kotlinx.coroutines.internal;

/* JADX INFO: loaded from: classes.dex */
public final class m {
    public static final void a(int r100) {
        boolean r101 = true;
        if (r100 >= 1) goto L6;
        r101 = false;
    L6:
        if (r101 == false) goto L9;
        return;
    L9:
        throw new IllegalArgumentException(("Expected positive parallelism level, but got " + r100).toString());
    }
}
