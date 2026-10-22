package kotlinx.coroutines.internal;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class v {
    public final LockFreeLinkedListNode a;

    public final String toString() {
        return "Removed[" + this.a + ']';
    }

    public v(LockFreeLinkedListNode r1) {
        this.a = r1;
    }
}
