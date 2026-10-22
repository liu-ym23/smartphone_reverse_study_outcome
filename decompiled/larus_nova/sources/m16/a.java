package m16;

/* JADX INFO: loaded from: classes19.dex */
public final class a<T> implements c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f511603a;

    @Override // com.bytedance.ies.bullet.service.base.i0
    public final void release() {
        this.f511603a = null;
    }

    @Override // m16.c
    public final T provideInstance() {
        return this.f511603a;
    }

    public a(T r100) {
        this.f511603a = r100;
    }
}
