package gk4;

import pk4.n;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements vj4.c {
    @Override // qk4.e
    public final int getCid() {
        return 4;
    }

    @Override // qk4.e
    public final int getSid() {
        return 32;
    }

    public b() {
    }

    @Override // qk4.e
    public final byte[] getData(int r100) {
        byte[] r101 = n.u(n.u(new byte[]{1, 4}, n.l(r100)), new byte[]{2, 1, 1});
        return n.u(new byte[]{-127, (byte) r101.length}, r101);
    }
}
