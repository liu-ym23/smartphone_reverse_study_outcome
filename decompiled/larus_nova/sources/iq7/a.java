package iq7;

/* JADX INFO: loaded from: classes22.dex */
public abstract class a<T> implements oq7.c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f495384d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public oq7.b f495385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f495386b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f495387c;

    /* JADX INFO: renamed from: iq7.a$a, reason: collision with other inner class name */
    public static class C6348a {
        public C6348a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static void a(pq7.b r100, a r101) {
            oq7.a r102 = r100.getExtendableContext();
            r102.getClass();
            a r103 = new a[]{r101}[0];
            Class<?> r104 = r103.getClass();
            if (r102.f524892d.containsKey(r104) == true) goto L7;
            r102.b(r104, r103);
            h.a(r103);
            return;
        }
    }

    public abstract void a();

    static {
        new C6348a();
    }

    public a() {
        this.f495386b = true;
        this.f495387c = true;
    }

    public oq7.b getContext() {
        return this.f495385a;
    }
}
