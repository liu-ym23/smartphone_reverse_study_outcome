package flb;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f477765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f477766b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f477767a;

        public a() {
            this.f477767a = -1;
        }

        public final void a(int r100) {
            boolean r101 = true;
            if (1 <= r100) goto L5;
        L7:
            r101 = false;
        L8:
            if (r101 == false) goto L11;
            this.f477767a = r100;
            return;
        L11:
            return;
        L5:
            if (r100 >= 101) goto L7;
            goto L7
        }
    }

    public b(int r100, int r101) {
        this.f477765a = r100;
        this.f477766b = r101;
    }
}
