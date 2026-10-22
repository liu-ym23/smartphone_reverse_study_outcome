package xj4;

import com.bytedance.dora.file.DoraInterruptLogFileReason;
import java.nio.charset.StandardCharsets;
import pk4.n;

/* JADX INFO: loaded from: classes15.dex */
public final class e extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f564098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DoraInterruptLogFileReason f564099b;

    public final String toString() {
        return "DoraInterruptLogFileTransferEvent{fileName='" + this.f564098a + "', reason=" + this.f564099b + '}';
    }

    @Override // qk4.e
    public final byte[] getData(int r100) {
        byte[] r101 = n.u(new byte[]{1, 4}, n.l(r100));
        byte[] r102 = this.f564098a.getBytes(StandardCharsets.UTF_8);
        byte[] r103 = n.u(new byte[]{2, (byte) r102.length}, r102);
        byte[] r104 = this.f564099b.getValue().getBytes(StandardCharsets.UTF_8);
        byte[] r105 = n.u(n.u(r101, r103), n.u(new byte[]{3, (byte) r104.length}, r104));
        return n.u(new byte[]{-124, (byte) r105.length}, r105);
    }

    public e(String r100, DoraInterruptLogFileReason r101) {
        this.f564098a = r100;
        this.f564099b = r101;
    }
}
