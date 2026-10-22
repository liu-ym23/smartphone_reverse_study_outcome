package n4a;

import android.content.Context;
import android.os.Build;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes32.dex */
public final class z0 extends b1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f517975c;

    public z0(Context r100, v0 r101) {
        super(r101);
        this.f517975c = r100;
    }

    @Override // n4a.b1
    public final byte[] b(byte[] r100) {
        Context r101 = this.f517975c;
        ByteArrayOutputStream r102 = new ByteArrayOutputStream();
        byte[] r103 = new byte[0];
        f5.g(r102, "1.2.13.6");     // Catch: Throwable -> L5
        f5.g(r102, "Android");     // Catch: Throwable -> L5
        f5.g(r102, "");     // Catch: Throwable -> L5
        f5.g(r102, "");     // Catch: Throwable -> L5
        f5.g(r102, x4.q(r101));     // Catch: Throwable -> L5
        f5.g(r102, Build.MANUFACTURER);     // Catch: Throwable -> L5
        f5.g(r102, Build.MODEL);     // Catch: Throwable -> L5
        f5.g(r102, Build.DEVICE);     // Catch: Throwable -> L5
        f5.g(r102, "");     // Catch: Throwable -> L5
        f5.g(r102, v4.d(r101));     // Catch: Throwable -> L5
        f5.g(r102, v4.e(r101));     // Catch: Throwable -> L5
        f5.g(r102, v4.g(r101));     // Catch: Throwable -> L5
        r102.write(new byte[]{0});     // Catch: Throwable -> L5
        r103 = r102.toByteArray();     // Catch: Throwable -> L5
    L19:
        r102.close();     // Catch: Throwable -> L9
    L11:
        byte[] r104 = new byte[r103.length + r100.length];
        System.arraycopy(r103, 0, r104, 0, r103.length);
        System.arraycopy(r100, 0, r104, r103.length, r100.length);
        return r104;
    L9:
        th = move-exception;
        th.printStackTrace();
    L5:
        th = move-exception;
        r.f(th, SRStrategy.KEY_SR_STRATEGY_MODE, "gh");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        r102.close();     // Catch: Throwable -> L16
    L18:
        throw th;
    L16:
        th = move-exception;
        th.printStackTrace();
        goto L18
    }
}
