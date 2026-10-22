package qk4;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes15.dex */
public final class c extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f533492a;

    public final String toString() {
        return "DoraRequestAlbumListEvent(2, 15)";
    }

    public c(String r100) {
        this.f533492a = r100;
    }

    @Override // qk4.e
    public final byte[] getData(int r100) {
        byte[] r101 = pk4.n.u(new byte[]{1, 4}, pk4.n.l(r100));
        byte[] r102 = this.f533492a.getBytes(StandardCharsets.UTF_8);
        byte[] r103 = pk4.n.u(r101, pk4.n.u(new byte[]{2, (byte) r102.length}, r102));
        return pk4.n.u(new byte[]{16, (byte) r103.length}, r103);
    }
}
