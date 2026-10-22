package v38;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicInteger f552948a = null;

    static {
        f552948a = new AtomicInteger();
    }

    public static void a() {
    L2:
        AtomicInteger r100 = f552948a;
        int r101 = r100.get();
        if (r101 <= 0) goto L4;
        if (r100.compareAndSet(r101, r101 - 1) == false) goto L2;
        return;
    }
}
