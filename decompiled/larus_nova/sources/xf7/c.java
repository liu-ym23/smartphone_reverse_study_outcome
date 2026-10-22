package xf7;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f563446a;

    /* JADX INFO: loaded from: classes22.dex */
    public static final class a implements yf7.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile boolean f563447a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile yf7.j f563448b;

        @Override // yf7.j
        public final void remove() {
            this.f563447a = false;
            if (this.f563448b == null) goto L6;
            this.f563448b.remove();
            return;
        }

        public a() {
            this.f563447a = true;
        }
    }

    public c() {
        this.f563446a = new i();
    }
}
