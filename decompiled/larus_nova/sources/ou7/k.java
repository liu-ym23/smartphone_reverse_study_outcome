package ou7;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes23.dex */
public final class k extends e {
    public k(i r100, d r101, long r102) throws IOException {
        ByteBuffer r103 = ByteBuffer.allocate(8);
        if (r101.f526779a == false) goto L5;
        ByteOrder r104 = ByteOrder.BIG_ENDIAN;
    L6:
        r103.order(r104);
        long r105 = r101.f526780b + (r102 * ((long) r101.f526782d));
        this.f526785a = r100.d(r103, r105);
        r100.b(r103, 8 + r105, 8);
        this.f526786b = r103.getLong();
        r100.b(r103, 16 + r105, 8);
        this.f526787c = r103.getLong();
        r100.b(r103, r105 + 40, 8);
        this.f526788d = r103.getLong();
        return;
    L5:
        r104 = ByteOrder.LITTLE_ENDIAN;
        goto L6
    }
}
