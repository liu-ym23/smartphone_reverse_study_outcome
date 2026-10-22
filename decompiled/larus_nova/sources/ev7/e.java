package ev7;

import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public abstract class e {
    public e() {
    }

    public abstract void b(jv7.b r100, InputStream r101, OutputStream r102, @Nullable c r103) throws IOException;

    public final void a(PolarisFileWrapper r100, InputStream r101, PolarisFileOutputStreamWrapper r102, @Nullable c r103) throws IOException {
        jv7.d r104 = jv7.f.f(r100);
        b(r104, r101, r102, r103);     // Catch: Throwable -> L6
        r104.close();
        return;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        r104.close();     // Catch: Throwable -> L11
    L13:
        throw th;
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    }
}
