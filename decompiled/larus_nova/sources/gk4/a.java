package gk4;

import pk4.n;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements vj4.c {
    public a() {
    }

    @Override // qk4.e
    public final int getCid() {
        return 4;
    }

    @Override // qk4.e
    public final int getSid() {
        return 32;
    }

    public final String toString() {
        return "DoraGetSilentOTAInfoEvent(32, 4)";
    }

    @Override // qk4.e
    public final byte[] getData(int r100) {
        byte[] r101 = n.u(new byte[]{1, 4}, n.l(r100));
        return n.u(new byte[]{-127, (byte) r101.length}, r101);
    }
}
