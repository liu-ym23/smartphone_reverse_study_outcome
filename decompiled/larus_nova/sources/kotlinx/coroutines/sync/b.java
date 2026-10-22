package kotlinx.coroutines.sync;

import kotlinx.coroutines.internal.b0;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b0 f505138a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b0 f505139b = null;

    static {
        f505138a = new b0("NO_OWNER");
        f505139b = new b0("ALREADY_LOCKED_BY_OWNER");
    }

    public static MutexImpl a() {
        return new MutexImpl(false);
    }
}
