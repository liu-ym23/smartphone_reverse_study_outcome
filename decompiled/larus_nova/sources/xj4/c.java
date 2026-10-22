package xj4;

import java.nio.charset.StandardCharsets;
import pk4.n;

/* JADX INFO: loaded from: classes15.dex */
public final class c extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f564093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f564094b;

    public final String toString() {
        return "DoraGetLogFileEvent{fileName='" + this.f564093a + "', fileOffset=" + this.f564094b + '}';
    }

    @Override // qk4.e
    public final byte[] getData(int r100) {
        byte[] r101 = n.u(new byte[]{1, 4}, n.l(r100));
        byte[] r102 = this.f564093a.getBytes(StandardCharsets.UTF_8);
        byte[] r103 = n.u(n.u(r101, n.u(new byte[]{2, (byte) r102.length}, r102)), n.u(new byte[]{3, 4}, n.l(this.f564094b)));
        return n.u(new byte[]{-125, (byte) r103.length}, r103);
    }

    public c(String r100, long r101) {
        this.f564093a = r100;
        this.f564094b = r101;
    }
}
