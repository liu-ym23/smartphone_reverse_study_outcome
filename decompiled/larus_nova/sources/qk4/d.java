package qk4;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes15.dex */
public final class d extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f533493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f533494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f533495c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte f533496d;

    public final String toString() {
        return "DoraRequestAlbumThumbnailDataEvent{uid='" + this.f533493a + "', mediaId=" + this.f533494b + ", createTime=" + this.f533495c + ", type=" + this.f533496d + '}';
    }

    @Override // qk4.e
    public final byte[] getData(int r100) {
        byte[] r101 = pk4.n.u(new byte[]{1, 4}, pk4.n.l(r100));
        byte[] r102 = this.f533493a.getBytes(StandardCharsets.UTF_8);
        byte[] r103 = pk4.n.u(new byte[]{2, (byte) r102.length}, r102);
        byte[] r104 = pk4.n.u(new byte[]{3, 8}, pk4.n.m(this.f533494b));
        byte[] r105 = pk4.n.u(pk4.n.u(pk4.n.u(pk4.n.u(r101, r103), r104), pk4.n.u(new byte[]{4, 8}, pk4.n.m(this.f533495c))), new byte[]{5, 1, this.f533496d});
        return pk4.n.u(new byte[]{-111, (byte) r105.length}, r105);
    }

    public d(String r100, long r101, long r102, byte r103) {
        this.f533493a = r100;
        this.f533494b = r101;
        this.f533495c = r102;
        this.f533496d = r103;
    }
}
