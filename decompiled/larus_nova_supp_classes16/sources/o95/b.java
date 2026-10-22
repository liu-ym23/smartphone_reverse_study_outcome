package o95;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements c<byte[]> {
    public final byte[] a;

    @Override // o95.c
    public final void recycle() {
    }

    @Override // o95.c
    public final byte[] get() {
        return this.a;
    }

    public b(byte[] r2) {
        if (r2 == null) goto L7;
        this.a = r2;
        return;
    L7:
        throw new NullPointerException("Bytes must not be null");
    }
}
