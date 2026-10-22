package n4a;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes32.dex */
public final class u0 extends b1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ByteArrayOutputStream f517767c;

    public u0(z0 r100) {
        super(r100);
        this.f517767c = new ByteArrayOutputStream();
    }

    @Override // n4a.b1
    public final byte[] b(byte[] r100) {
        byte[] r101 = this.f517767c.toByteArray();
        this.f517767c.close();     // Catch: IOException -> L5
    L7:
        this.f517767c = new ByteArrayOutputStream();
        return r101;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    @Override // n4a.b1
    public final void c(byte[] r100) {
        this.f517767c.write(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }
}
