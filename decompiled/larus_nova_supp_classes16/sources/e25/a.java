package e25;

import android.os.SystemClock;
import com.bytedance.ee.bear.contract.d;
import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$RESULT;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {

    /* JADX INFO: renamed from: e25.a$a, reason: collision with other inner class name */
    public static final class C0216a {
    }

    static {
    }

    @JvmStatic
    public static final void a(long r4, int r6, String r7, int r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r7, "picFrom");
        Intrinsics.checkNotNullParameter(r9, "fileType");
        Intrinsics.checkNotNullParameter(r10, "msg");
        JSONObject r1 = new JSONObject();
        r1.put("code", r6).put("msg", r10).put("cache", DiagramData$RESULT.FAIL).put("cost_time", SystemClock.uptimeMillis() - r4).put("pic_size", -1).put("pic_from", r7).put("image_type", r8).put("file_type", r9);
        tt5.a.h("OfflineAnalytic", r1.toString());
        ((d) org.koin.java.a.c(d.class, null, null, 6)).u("docs_dev_performance_native_pic_download_result", r1);
    }

    @JvmStatic
    public static final void b(String r4, long r5, long r7, int r9, String r10, int r11, String r12) {
        Intrinsics.checkNotNullParameter(r4, "cache");
        Intrinsics.checkNotNullParameter(r10, "picFrom");
        Intrinsics.checkNotNullParameter(r12, "fileType");
        JSONObject r1 = new JSONObject();
        r1.put("code", r9).put("msg", "success").put("cache", r4).put("cost_time", SystemClock.uptimeMillis() - r5).put("pic_size", r7).put("pic_from", r10).put("image_type", r11).put("file_type", r12);
        tt5.a.h("OfflineAnalytic", r1.toString());
        ((d) org.koin.java.a.c(d.class, null, null, 6)).u("docs_dev_performance_native_pic_download_result", r1);
    }
}
