package ex7;

/* JADX INFO: loaded from: classes23.dex */
public final class c<T> implements a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f474721a;

    @Override // ex7.b
    public final void release() {
        this.f474721a = null;
    }

    @Override // ex7.a
    public final T provideInstance() {
        return this.f474721a;
    }

    public c(T r100) {
        this.f474721a = r100;
    }
}
