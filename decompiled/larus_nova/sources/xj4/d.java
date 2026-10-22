package xj4;

import java.util.Arrays;
import pk4.n;

/* JADX INFO: loaded from: classes15.dex */
public final class d extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f564095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f564096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f564097c;

    public final String toString() {
        return "DoraGetLogFileListEvent{fileTypes=" + Arrays.toString(this.f564095a) + ", startTime=" + this.f564096b + ", endTime=" + this.f564097c + '}';
    }

    public d(int[] r100) {
        this.f564095a = r100;
        this.f564096b = 0;
        this.f564097c = 0;
    }

    @Override // qk4.e
    public final byte[] getData(int r100) {
        byte[] r101 = n.u(new byte[]{1, 4}, n.l(r100));
        int r102 = this.f564095a.length;
        byte[] r103 = new byte[r102];
        int r104 = 0;
    L3:
        int[] r105 = this.f564095a;
        if (r104 >= r105.length) goto L6;
        r103[r104] = (byte) r105[r104];
        r104 = r104 + 1;
        goto L3
    L6:
        byte[] r106 = n.u(new byte[]{2, (byte) r102}, r103);
        byte[] r107 = n.u(n.u(n.u(r101, r106), n.u(new byte[]{3, 8}, n.m(this.f564096b))), n.u(new byte[]{4, 8}, n.m(this.f564097c)));
        return n.u(new byte[]{-126, (byte) r107.length}, r107);
    }
}
