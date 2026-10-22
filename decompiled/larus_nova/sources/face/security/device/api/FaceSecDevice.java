package face.security.device.api;

import android.app.Activity;
import android.content.Context;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes41.dex */
public class FaceSecDevice {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FaceSecDevice f476085a = null;

    public static final enum DataSwitch extends Enum<DataSwitch> {
        public static final DataSwitch INIT_COLLECT_DATA = null;
        public static final DataSwitch TOKEN_COLLECT_DATA = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DataSwitch[] f476086a = null;

        static {
            DataSwitch r100 = new DataSwitch("INIT_COLLECT_DATA", 0);
            INIT_COLLECT_DATA = r100;
            DataSwitch r101 = new DataSwitch("TOKEN_COLLECT_DATA", 1);
            TOKEN_COLLECT_DATA = r101;
            f476086a = new DataSwitch[]{r100, r101};
        }

        public static DataSwitch[] values() {
            return (DataSwitch[]) f476086a.clone();
        }

        public static DataSwitch valueOf(String r100) {
            return (DataSwitch) a.a(DataSwitch.class, r100);
        }

        public DataSwitch(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static native void ascRaw(Activity r100);

    private native FaceSecSession getBizSessionRaw(String r100);

    private native FaceSecSessionId getSessionIdRaw();

    private native FaceSecSession getSessionRaw();

    private static native String getVersionRaw();

    public static native String gsRaw(String r100);

    private native int initExFirstRaw(Context r100);

    private native int initExSecondRaw(Context r100);

    private native void lpRaw(int r100, String r101);

    private native void lxRaw();

    private native void mpRaw(Context r100);

    private native void otiRaw(Context r100);

    private native void reportUserDataRaw(String r100, String r101);

    public static native void reserved0();

    public static native void reserved1();

    private native void setOptionsRaw(Context r100, Map<String, String> r101);

    static {
        Intrinsics.checkNotNullParameter("facedevice", "libName");
        FLogger r100 = FLogger.f375446a;
        r100.i("Librarian_loadLib", "loadLibrary start libName -> facedevice");
        com.bytedance.librarian.a.c("facedevice");
        r100.i("Librarian_loadLib", "loadLibrary success by librarian -> facedevice");
        f476085a = new FaceSecDevice();
    }

    public final FaceSecSession a() {
        return getSessionRaw();
    L4:
        FaceSecSession r100 = new FaceSecSession();
        r100.f476087a = 10013;
        r100.f476088b = "";
        return r100;
    }

    public FaceSecDevice() {
    }
}
