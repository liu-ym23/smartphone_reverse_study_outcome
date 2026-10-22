package kotlinx.coroutines.internal;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class m {
    public static final void a(int r2) {
        boolean r0 = true;
        if (r2 >= 1) goto L6;
        r0 = false;
    L6:
        if (r0 == false) goto L9;
        return;
    L9:
        throw new IllegalArgumentException(("Expected positive parallelism level, but got " + r2).toString());
    }
}
