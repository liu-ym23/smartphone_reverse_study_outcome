package n60;

import android.content.Context;
import android.hardware.Camera;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.bpea.cert.token.TokenCert;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes45.dex */
public final class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TokenCert f518095a = null;

    public b() {
    }

    static {
        f518095a = TokenCert.with("bpea-live_camerachecker_check_camara");
    }

    public static boolean b(TokenCert r100) {
        Field r101 = null;
        int r102 = Camera.getNumberOfCameras();     // Catch: Exception -> L24
        int r103 = 0;
    L4:
        if (r103 >= r102) goto L26;
        Camera.CameraInfo r104 = new Camera.CameraInfo();     // Catch: Exception -> L24
        Camera.getCameraInfo(r103, r104);     // Catch: Exception -> L24
        if (r104.facing == 1) goto L48;
        if (r102 == 1) goto L48;
        r103 = r103 + 1;
    L48:
        Camera r105 = g80.b.b(r103, r100);     // Catch: Exception -> L16 RuntimeException -> L18
        if (r105 != null) goto L54;
    L27:
        if (r105 != null) goto L55;
        return false;
    L55:
        r101 = r105.getClass().getDeclaredField("mHasPermission");     // Catch: NoSuchFieldException -> L31
    L51:
        if (r101 != null) goto L52;
        g80.b.c(r105, r100);
        return true;
    L52:
        r101.setAccessible(true);     // Catch: Throwable -> L39 IllegalAccessException -> L41
        boolean r106 = r101.getBoolean(r105);     // Catch: Throwable -> L39 IllegalAccessException -> L41
        g80.b.c(r105, r100);
        return r106;
    L41:
        e = move-exception;
        ALogger.e("CameraChecker", e);     // Catch: Throwable -> L39
        g80.b.c(r105, r100);
        return true;
    L39:
        th = move-exception;
        g80.b.c(r105, r100);
        throw th;
    L31:
        e = move-exception;
        ALogger.e("CameraChecker", e);
        goto L51
    L54:
        r105.setParameters(r105.getParameters());     // Catch: RuntimeException -> L14 Exception -> L16
    L14:
        e = e;
    L20:
        e.getLocalizedMessage();     // Catch: Exception -> L24
        if (r105 == null) goto L26;
        g80.b.c(r105, r100);     // Catch: Exception -> L24
    L16:
        e = move-exception;
        ALogger.e("CameraChecker", e);     // Catch: Exception -> L24
    L18:
        e = e;
        r105 = null;
    L26:
        r105 = null;
    L24:
        e = move-exception;
        ALogger.e("CameraChecker", e);
        goto L26
    }

    @Override // n60.d
    public final boolean a(Context r100, String r101) {
        return b(f518095a);
    }
}
