package xx8;

import com.larus.camera.impl.utils.capture.CameraZoomRatioType;
import com.larus.camera.impl.utils.k;
import com.larus.utils.logger.FLogger;
import kotlin.Pair;

/* JADX INFO: loaded from: classes26.dex */
public interface c {

    public static final class a {
        public static boolean a(c r100) {
            if (r100.d() == false) goto L5;
        L8:
            return true;
        L5:
            if (r100.h() == true) goto L8;
            return false;
        }

        public static boolean b(c r100) {
            if (((oq9.d) k.f322785a.getValue()).a() != CameraZoomRatioType.MULTI_ZOOM_RATIO.getType()) goto L5;
            boolean r101 = true;
        L6:
            FLogger.f375446a.i(r100.getClass().getName(), "isMultiZoomRatioEnable res=" + r101 + " isCheckMaxZoomSupport=" + r100.g());
            if (r101 == true) goto L9;
            return false;
        L9:
            if (r100.g() == false) goto L13;
            return true;
        L13:
            return false;
        L5:
            r101 = false;
            goto L6
        }

        public static boolean c(c r100) {
            if (((oq9.d) k.f322785a.getValue()).a() != CameraZoomRatioType.SINGLE_ZOOM_RATIO.getType()) goto L5;
            boolean r101 = true;
        L6:
            FLogger.f375446a.i(r100.getClass().getName(), "isSingleZoomRatioEnable res=" + r101 + " isCheckMaxZoomSupport=" + r100.g());
            if (r101 == true) goto L9;
            return false;
        L9:
            if (r100.g() == false) goto L13;
            return true;
        L13:
            return false;
        L5:
            r101 = false;
            goto L6
        }
    }

    Pair<Float, Boolean> a(float r100);

    boolean b();

    float c(float r100);

    boolean d();

    double e(float r100, double r101);

    float f(float r100);

    boolean g();

    boolean h();
}
