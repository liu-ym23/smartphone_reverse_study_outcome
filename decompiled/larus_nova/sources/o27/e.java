package o27;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes21.dex */
public final class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static e f521790b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<d> f521791a;

    public static e a() {
        if (f521790b != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f521790b != null) goto L9;
        f521790b = new e();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f521790b;
    }

    public e() {
        this.f521791a = new CopyOnWriteArrayList();
    }
}
