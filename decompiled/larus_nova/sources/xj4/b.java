package xj4;

import java.nio.charset.StandardCharsets;
import pk4.n;

/* JADX INFO: loaded from: classes15.dex */
public final class b extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f564092a;

    public final String toString() {
        return "DoraFileReceivedAckEvent{fileName='" + this.f564092a + "'}";
    }

    public b(String r100) {
        this.f564092a = r100;
    }

    @Override // qk4.e
    public final byte[] getData(int r100) {
        byte[] r101 = n.u(new byte[]{1, 4}, n.l(r100));
        byte[] r102 = this.f564092a.getBytes(StandardCharsets.UTF_8);
        byte[] r103 = n.u(r101, n.u(new byte[]{2, (byte) r102.length}, r102));
        return n.u(new byte[]{-127, (byte) r103.length}, r103);
    }
}
