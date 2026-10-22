package fob;

/* JADX INFO: loaded from: classes36.dex */
public interface c<T, D> {

    public static final class a<D> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f478191a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final D f478192b;

        public /* synthetic */ a() {
            this(false, null);
        }

        public a(boolean r100, D r101) {
            this.f478191a = r100;
            this.f478192b = r101;
        }
    }

    a<D> resolve(T r100);
}
