package g66;

/* JADX INFO: loaded from: classes19.dex */
public final class b<T> implements a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f480165a;

    @Override // p56.e
    public final void release() {
        this.f480165a = null;
    }

    @Override // g66.a
    public final T provideInstance() {
        return this.f480165a;
    }

    public b(T r100) {
        this.f480165a = r100;
    }
}
