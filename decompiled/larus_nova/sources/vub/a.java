package vub;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f557372a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f557373b;

    static {
        f557372a = new Object();
    }

    public static String b(String r100) {
        return "len=" + r100.length() + ",hash=" + r100.hashCode();
    }

    public static void a(String r100, long r101) {
        Object r102 = f557372a;
        monitor-enter(r102);
        monitor-exit(r102);
        lvb.a.e("MmD1204RuntimeStartup", "[tryStart] skip, trigger=user_scope_ready, user=" + b(r100) + ", generation=" + r101);
    }
}
