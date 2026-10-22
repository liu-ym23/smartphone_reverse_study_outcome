package kotlinx.coroutines;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class l1 implements m0, o {
    public static final l1 a = null;

    static {
        a = new l1();
    }

    public l1() {
    }

    @Override // kotlinx.coroutines.o
    public final boolean b(Throwable r1) {
        return false;
    }

    @Override // kotlinx.coroutines.m0
    public final void dispose() {
    }

    @Override // kotlinx.coroutines.o
    public final Job getParent() {
        return null;
    }

    public final String toString() {
        return "NonDisposableHandle";
    }
}
