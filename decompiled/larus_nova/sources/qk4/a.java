package qk4;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes15.dex */
public final class a extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f533489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long[] f533490b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long[] f533491c;

    public final String toString() {
        return "DoraDeleteAlbumDataEvent(2, 15)";
    }

    @Override // qk4.e
    public final byte[] getData(int r100) {
        byte[] r101 = pk4.n.u(new byte[]{1, 4}, pk4.n.l(r100));
        byte[] r102 = this.f533489a.getBytes(StandardCharsets.UTF_8);
        byte[] r103 = pk4.n.u(new byte[]{2, (byte) r102.length}, r102);
        byte[] r104 = pk4.n.t(this.f533490b);
        byte[] r105 = pk4.n.u(pk4.n.u(new byte[]{3}, pk4.n.s(r104.length)), r104);
        byte[] r106 = pk4.n.t(this.f533491c);
        byte[] r107 = pk4.n.u(pk4.n.u(pk4.n.u(r101, r103), r105), pk4.n.u(pk4.n.u(new byte[]{4}, pk4.n.s(r106.length)), r106));
        return pk4.n.u(pk4.n.u(new byte[]{19}, pk4.n.s(r107.length)), r107);
    }

    public a(String r100, long[] r101, long[] r102) {
        this.f533489a = r100;
        this.f533490b = r101;
        this.f533491c = r102;
    }
}
