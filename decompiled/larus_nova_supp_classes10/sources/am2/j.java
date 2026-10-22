package am2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j {
    public static boolean d = true;
    public static j e;
    public a a;
    public c b;
    public b c;

    public interface a {
        String getDefinition();
    }

    public interface b {
        int a();
    }

    public interface c {
        int getNetQuality();
    }

    public static synchronized j a() {
        monitor-enter(j.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (e != null) goto L7;
        e = new j();     // Catch: Throwable -> L10
    L7:
        j r1 = e;     // Catch: Throwable -> L10
        monitor-exit(j.class);
        return r1;
    }

    public j() {
        this.a = null;
        this.b = null;
        this.c = null;
    }
}
