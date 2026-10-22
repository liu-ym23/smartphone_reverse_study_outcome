package iq7;

import java.util.HashMap;

/* JADX INFO: loaded from: classes22.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static HashMap<String, wq7.a> f495390a;

    static {
        f495390a = new HashMap();
    }

    public f() {
    }

    public static <T extends e> T a(String r100, Class<T> r101) {
        wq7.a r102 = f495390a.get(r100);
        if (r102 != null) goto L15;
        monitor-enter(f.class);
        wq7.a r103 = f495390a.get(r100);     // Catch: Throwable -> L16
        if (r103 == null) goto L11;
        monitor-exit(f.class);     // Catch: Throwable -> L16
    L10:
        r102 = r103;
        goto L15
    L11:
        r103 = new wq7.b(r100);     // Catch: Throwable -> L16
        HashMap<String, wq7.a> r104 = new HashMap(f495390a);     // Catch: Throwable -> L16
        r104.put(r100, r103);     // Catch: Throwable -> L16
        f495390a = r104;     // Catch: Throwable -> L16
        monitor-exit(f.class);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    L15:
        return (T) r102.a(r101);
    }
}
