package am3;

import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class e implements f {
    public static final Charset a = null;

    public e() {
    }

    static {
        a = Charset.forName("UTF-8");
    }

    @Override // am3.f
    public final long readLongLe() throws IOException {
        long r0 = 0;
        int r2 = 0;
    L4:
        if (r2 >= 8) goto L6;
        r0 = r0 | ((((long) readByte()) & 255) << (r2 * 8));
        r2 = r2 + 1;
        goto L4
    L6:
        return r0;
    }

    @Override // am3.f
    public final int readIntLe() throws IOException {
        byte r0 = readByte();
        byte r1 = readByte();
        byte r2 = readByte();
        return (((r0 & 255) | ((r1 & 255) << 8)) | ((r2 & 255) << 16)) | ((readByte() & 255) << 24);
    }
}
