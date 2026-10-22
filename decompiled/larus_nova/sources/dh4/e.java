package dh4;

import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.IOException;

/* JADX INFO: loaded from: classes15.dex */
public final class e implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PolarisFileOutputStreamWrapper f468600a;

    @Override // dh4.d
    public final void flush() {
        PolarisFileOutputStreamWrapper r100 = this.f468600a;
        if (r100 == null) goto L9;
        r100.flush();     // Catch: IOException -> L6
        return;
    L10:
        return;
    }

    @Override // dh4.d
    public final void release() {
        PolarisFileOutputStreamWrapper r100 = this.f468600a;
        if (r100 == null) goto L9;
        r100.close();     // Catch: IOException -> L6
        return;
    L10:
        return;
    }

    public e(String r100) {
        PolarisFileOutputStreamWrapper r101 = new PolarisFileOutputStreamWrapper(new PolarisFileWrapper(r100));     // Catch: IOException -> L5
    L6:
        this.f468600a = r101;
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // dh4.d
    public final void a(String r100) {
        PolarisFileOutputStreamWrapper r101 = this.f468600a;
        if (r101 == null) goto L9;
        r101.write(r100.getBytes());     // Catch: IOException -> L6
        return;
    L10:
        return;
    }

    @Override // dh4.d
    public final void b(int r100) {
        a(Integer.toString(r100));
    }

    @Override // dh4.d
    public final void c(long r100) {
        a(Long.toString(r100));
    }

    @Override // dh4.d
    public final void d(char[] r100, int r101) {
        StringBuilder r102 = new StringBuilder();
        r102.append(r100);
        a(r102.toString());
    }
}
