package zx8;

import com.bytedance.keva.Keva;
import com.larus.platform.model.NotificationBusiness;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import oq9.f;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Keva f573892a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f573893b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<String> f573894c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<String> f573895d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f573896e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f573897f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f573898g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f573899h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f573900i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f573901j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static boolean f573902k;

    static {
        Keva r100 = Keva.getRepo("CAMERA_VE");
        f573892a = r100;
        Lazy r101 = LazyKt.lazy(new a());
        f573893b = r101;
        f573894c = CollectionsKt.listOf("CAPTURE_MODE_PHOTO");
        f573895d = CollectionsKt.listOf(new String[]{NotificationBusiness.REALTIME_CALL, "doc", "slides", "inject_input_camera_result_preview"});
        f573896e = ((f) r101.getValue()).f524904a;
        f573897f = ((f) r101.getValue()).f524905b;
        f573898g = ((f) r101.getValue()).f524907d;
        f573902k = r100.getBoolean("key_permission_out_side_camera", false);
        FLogger.f375446a.i("CameraRecordConfigManager", "init hasPermissionAudio:" + f573902k);
    }

    public static boolean b() {
        FLogger.f375446a.i("CameraRecordConfigManager", "isSupportRecord, settings:" + f573899h + ", mode:" + f573900i + ", scene:" + f573901j);
        if (f573899h == true) goto L5;
    L9:
        return false;
    L5:
        if (f573900i == false) goto L9;
        if (f573901j == false) goto L9;
        return true;
    }

    public static void a(boolean r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "captureMode");
        Intrinsics.checkNotNullParameter(r102, "captureScene");
        FLogger.f375446a.i("CameraRecordConfigManager", "initConfig, support:" + r100 + ", captureMode:" + r101 + ", captureScene:" + r102);
        f573899h = r100;
        f573900i = f573894c.contains(r101);
        f573901j = f573895d.contains(r102) ^ true;
    }
}
