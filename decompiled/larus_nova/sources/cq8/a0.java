package cq8;

/* JADX INFO: loaded from: classes26.dex */
public abstract class a0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f464800b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f464801a;

    public static final class a {
        public static String a() {
            long r100 = a0.f464800b + 1;
            a0.f464800b = r100;
            return String.valueOf(r100);
        }
    }

    static {
    }

    public abstract String a();

    public a0(String r100) {
        this.f464801a = r100;
    }
}
