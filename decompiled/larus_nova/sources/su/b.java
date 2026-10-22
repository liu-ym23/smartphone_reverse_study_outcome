package su;

import android.content.Context;
import android.hardware.Camera;
import com.bytedance.bpea.cert.token.TokenCert;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TokenCert f543579a = null;

    public b() {
    }

    static {
        f543579a = TokenCert.with("bpea-live_camerachecker_check_camara");
    }

    public static boolean b(TokenCert r100) {
        Camera r101 = c(r100);     // Catch: Exception -> L5
    L7:
        if (r101 != null) goto L30;
        return false;
    L30:
        Field r102 = r101.getClass().getDeclaredField("mHasPermission");     // Catch: NoSuchFieldException -> L12
    L15:
        if (r102 != null) goto L28;
        gv.b.a(r101, r100);
        return true;
    L28:
        r102.setAccessible(true);     // Catch: IllegalAccessException -> L21 Throwable -> L25
        boolean r103 = r102.getBoolean(r101);     // Catch: IllegalAccessException -> L21 Throwable -> L25
        gv.b.a(r101, r100);
        return r103;
    L21:
        e = move-exception;
        yr.b.d("CameraChecker", null, e);     // Catch: Throwable -> L25
        gv.b.a(r101, r100);
        return true;
    L25:
        th = move-exception;
        gv.b.a(r101, r100);
        throw th;
    L12:
        e = move-exception;
        yr.b.d("CameraChecker", null, e);
        r102 = null;
    L5:
        e = move-exception;
        yr.b.d("CameraChecker", null, e);
        r101 = null;
        goto L7
    }

    public static Camera c(TokenCert r100) {
        int r101 = Camera.getNumberOfCameras();
        int r102 = 0;
    L4:
        if (r102 >= r101) goto L33;
        Camera.CameraInfo r103 = new Camera.CameraInfo();
        Camera.getCameraInfo(r102, r103);
        if (r103.facing == 1) goto L25;
        if (r101 == 1) goto L25;
        r102 = r102 + 1;
    L25:
        int r104 = gv.b.f482808a;     // Catch: Exception -> L17 RuntimeException -> L19
        int r105 = com.bytedance.bpea.entry.api.camera.a.f202181a;     // Catch: Exception -> L17 RuntimeException -> L19
        Camera r106 = com.bytedance.bpea.entry.api.camera.a.C2917a.a(r102, r100);     // Catch: Exception -> L17 RuntimeException -> L19
        if (r106 == null) goto L30;
        r106.setParameters(r106.getParameters());     // Catch: RuntimeException -> L14 Exception -> L17
    L14:
        RuntimeException e100 = e;
    L21:
        e100.getLocalizedMessage();
        if (r106 == null) goto L32;
        gv.b.a(r106, r100);
        return null;
    L32:
        return null;
    L30:
        return r106;
    L19:
        e = move-exception;
        e100 = e;
        r106 = null;
    L17:
        e = move-exception;
        yr.b.d("CameraChecker", null, e);
        return null;
    L33:
        return null;
    }

    @Override // su.d
    public final boolean a(Context r100, String r101) {
        return b(f543579a);
    }
}
