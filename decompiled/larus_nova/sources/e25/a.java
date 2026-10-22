package e25;

import android.os.SystemClock;
import com.bytedance.ee.bear.contract.d;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: e25.a$a, reason: collision with other inner class name */
    public static final class C5732a {
    }

    static {
    }

    @JvmStatic
    public static final void a(long r100, int r101, String r102, int r103, String r104, String r110) {
        Intrinsics.checkNotNullParameter(r102, "picFrom");
        Intrinsics.checkNotNullParameter(r104, "fileType");
        Intrinsics.checkNotNullParameter(r110, "msg");
        JSONObject r105 = new JSONObject();
        r105.put("code", r101).put("msg", r110).put("cache", "0").put(HiAnalyticsConstant.BI_KEY_COST_TIME, SystemClock.uptimeMillis() - r100).put("pic_size", -1).put("pic_from", r102).put("image_type", r103).put("file_type", r104);
        tt5.a.h("OfflineAnalytic", r105.toString());
        ((d) org.koin.java.a.c(d.class, null, null, 6)).u("docs_dev_performance_native_pic_download_result", r105);
    }

    @JvmStatic
    public static final void b(String r100, long r101, long r102, int r103, String r110, int r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, "cache");
        Intrinsics.checkNotNullParameter(r110, "picFrom");
        Intrinsics.checkNotNullParameter(r112, "fileType");
        JSONObject r104 = new JSONObject();
        r104.put("code", r103).put("msg", "success").put("cache", r100).put(HiAnalyticsConstant.BI_KEY_COST_TIME, SystemClock.uptimeMillis() - r101).put("pic_size", r102).put("pic_from", r110).put("image_type", r111).put("file_type", r112);
        tt5.a.h("OfflineAnalytic", r104.toString());
        ((d) org.koin.java.a.c(d.class, null, null, 6)).u("docs_dev_performance_native_pic_download_result", r104);
    }
}
