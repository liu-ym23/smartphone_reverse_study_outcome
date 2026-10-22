package me7;

/* JADX INFO: loaded from: classes22.dex */
public final class e<T> implements j<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f513523a;

    @Override // me7.j
    public final void release() {
        this.f513523a = null;
    }

    @Override // me7.j
    public final T provideInstance() {
        return this.f513523a;
    }

    public e(T r100) {
        this.f513523a = r100;
    }
}
