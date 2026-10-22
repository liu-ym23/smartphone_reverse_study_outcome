package kotlinx.coroutines.sync;

import kotlinx.coroutines.internal.b0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class b {
    public static final b0 a = null;
    public static final b0 b = null;

    static {
        a = new b0("NO_OWNER");
        b = new b0("ALREADY_LOCKED_BY_OWNER");
    }

    public static MutexImpl a() {
        return new MutexImpl(false);
    }
}
