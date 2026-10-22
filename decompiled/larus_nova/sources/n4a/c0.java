package n4a;

/* JADX INFO: loaded from: classes32.dex */
public final class c0 extends d0 {
    public c0(e0 r100) {
        super(r100);
    }

    @Override // n4a.d0
    public final byte[] a(byte[] r100) {
        String r101 = y4.g(r100);     // Catch: Throwable -> L4
    L7:
        return f5.j(r101);
    L4:
        th = move-exception;
        th.printStackTrace();
        r101 = null;
        goto L7
    }
}
