package androidx.camera.core.impl.utils;

import android.view.Surface;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class SurfaceUtil {
    public static final String JNI_LIB_NAME = "surface_util_jni";
    private static final String TAG = "SurfaceUtil";

    public static class SurfaceInfo {
        public int format;
        public int height;
        public int width;

        public SurfaceInfo() {
            this.format = 0;
            this.width = 0;
            this.height = 0;
        }
    }

    public static /* synthetic */ void access$000(String r0) {
        System.loadLibrary(r0);
    }

    private static native int[] nativeGetSurfaceInfo(Surface r0);

    static {
        INVOKESTATIC_androidx_camera_core_impl_utils_SurfaceUtil_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(JNI_LIB_NAME);
    }

    private SurfaceUtil() {
    }

    @JvmStatic
    public static void INVOKESTATIC_androidx_camera_core_impl_utils_SurfaceUtil_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r4) {
        Intrinsics.checkNotNullParameter(r4, "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> " + r4);
        com.bytedance.librarian.a.c(r4);
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r4);
    }

    public static SurfaceInfo getSurfaceInfo(Surface r2) {
        int[] r3 = nativeGetSurfaceInfo(r2);
        SurfaceInfo r0 = new SurfaceInfo();
        r0.format = r3[0];
        r0.width = r3[1];
        r0.height = r3[2];
        return r0;
    }
}
