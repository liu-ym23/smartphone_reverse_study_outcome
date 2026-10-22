package ou7;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes23.dex */
public final class l extends f {
    public l(i r100, d r101) throws IOException {
        ByteBuffer r102 = ByteBuffer.allocate(4);
        if (r101.f526779a == false) goto L5;
        ByteOrder r103 = ByteOrder.BIG_ENDIAN;
    L6:
        r102.order(r103);
        this.f526789a = r100.d(r102, (r101.f526781c + ((long) (0 * r101.f526784f))) + 28);
        return;
    L5:
        r103 = ByteOrder.LITTLE_ENDIAN;
        goto L6
    }
}
