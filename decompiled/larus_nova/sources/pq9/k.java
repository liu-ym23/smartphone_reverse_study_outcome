package pq9;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.platform.api.c4;
import com.larus.platform.model.camera.ve.Ratio;
import com.larus.utils.logger.FLogger;
import com.ss.android.ttvecamera.TECameraUtils;
import java.io.File;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f530291a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pair<Integer, Integer> f530292b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pair<Integer, Integer> f530293c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Pair<Integer, Integer> f530294d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f530295e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f530296f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f530297g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f530298h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f530299i = null;

    public k() {
    }

    static {
        f530291a = new k();
        f530292b = new Pair(1440, Integer.valueOf(TECameraUtils.CAPTURE_HQ_2X));
        f530293c = new Pair(1080, Integer.valueOf(TECameraUtils.CAPTURE_NORMAL));
        f530294d = new Pair(720, 1280);
        StringBuilder r100 = new StringBuilder();
        c4.f364880a.getClass();
        r100.append(c4.a.a());
        r100.append("/model");
        File r101 = b(r100.toString());
        if (r101 == null) goto L5;
        r101.getPath();
    L5:
        File r102 = b(c4.a.a() + "/camera");
        String r103 = null;
        if (r102 == null) goto L8;
        String r104 = r102.getPath();
    L9:
        String r105 = "";
        if (r104 != null) goto L12;
        r104 = "";
    L12:
        f530295e = r104;
        File r106 = b(r104.concat("/photo"));
        if (r106 == null) goto L15;
        String r107 = r106.getPath();
    L16:
        if (r107 != null) goto L18;
        r107 = "";
    L18:
        f530296f = r107;
        File r108 = b(r104.concat("/video"));
        if (r108 == null) goto L21;
        String r109 = r108.getPath();
    L22:
        if (r109 != null) goto L24;
        r109 = "";
    L24:
        f530297g = r109;
        File r110 = b(c4.a.a() + "/transition");
        if (r110 == null) goto L27;
        r103 = r110.getPath();
    L27:
        if (r103 == null) goto L30;
        r105 = r103;
    L30:
        f530298h = r105;
        f530299i = r105.concat("/transition_temp.jpg");
        return;
    L21:
        r109 = null;
        goto L22
    L15:
        r107 = null;
        goto L16
    L8:
        r104 = null;
        goto L9
    }

    public static String a(Ratio r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_RATION);
        if (r100 != Ratio.RATIO_3_4) goto L7;
        return f530298h + "/transition.jpg";
    L7:
        return f530298h + '/' + r100.name() + "_transition.jpg";
    }

    public static File b(String r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L7
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);     // Catch: Throwable -> L7
        if (r102.exists() == true) goto L5;
        r102.mkdirs();     // Catch: Throwable -> L7
    L5:
        Object r103 = Result.m9449constructorimpl(r102);     // Catch: Throwable -> L7
    L9:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L13;
        FLogger.f375446a.e("VeCameraConstants", "path:" + r100 + ", error:" + r104.getMessage());
    L13:
        if (Result.m9455isFailureimpl(r103) == false) goto L16;
        r103 = null;
    L16:
        return (File) r103;
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    }
}
