package o95;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements c<byte[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f522472a;

    @Override // o95.c
    public final void recycle() {
    }

    @Override // o95.c
    public final byte[] get() {
        return this.f522472a;
    }

    public b(byte[] r100) {
        if (r100 == null) goto L7;
        this.f522472a = r100;
        return;
    L7:
        throw new NullPointerException("Bytes must not be null");
    }
}
