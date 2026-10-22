package sy2;

import java.util.HashMap;

/* JADX INFO: loaded from: classes12.dex */
public final class d extends a implements my2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile d f543863a;

    public static my2.b a() {
        if (f543863a != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f543863a != null) goto L9;
        f543863a = new d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return f543863a;
    }

    public d() {
        new HashMap();
    }
}
