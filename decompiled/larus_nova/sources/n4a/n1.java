package n4a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes32.dex */
public abstract class n1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p1 f517554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ByteBuffer f517555b;

    public n1(int r100) {
        ByteBuffer r101 = ByteBuffer.allocate(r100);
        this.f517555b = r101;
        r101.order(ByteOrder.LITTLE_ENDIAN);
        this.f517554a = new p1(r101);
    }
}
