package ou7;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes23.dex */
public final class j extends e {
    public j(i r100, d r101, long r102) throws IOException {
        ByteBuffer r103 = ByteBuffer.allocate(4);
        if (r101.f526779a == false) goto L5;
        ByteOrder r104 = ByteOrder.BIG_ENDIAN;
    L6:
        r103.order(r104);
        long r105 = r101.f526780b + (r102 * ((long) r101.f526782d));
        this.f526785a = r100.d(r103, r105);
        this.f526786b = r100.d(r103, 4 + r105);
        this.f526787c = r100.d(r103, 8 + r105);
        this.f526788d = r100.d(r103, r105 + 20);
        return;
    L5:
        r104 = ByteOrder.LITTLE_ENDIAN;
        goto L6
    }
}
