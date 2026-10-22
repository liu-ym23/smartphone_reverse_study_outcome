package jdc;

import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f498780a = 0;

    public static final class a {
        @JvmStatic
        public static void a(Biz r100, Scene r101, String r102, boolean r103, int r104, String r105, boolean r106) {
            Intrinsics.checkNotNullParameter(r102, "totalCost");
            Intrinsics.checkNotNullParameter(r105, "imageKey");
            JSONObject r107 = new JSONObject();
            if (r100 == null) goto L5;
            r107.put("biz", r100.getValue());
        L5:
            if (r101 == null) goto L7;
            r107.put("scene", r101.getValue());
        L7:
            r107.put("total_cost", r102).put("is_success", r103).put("from_net", true).put("from_type", r104).put("image_key", r105).put("media_is_origin_type", r106).put("resource_content_length", 0);
            Log.d("ImageDownloadHitPoint", r107.toString());
            Statistics.sendEvent("image_donwload_dev", r107);
        }
    }

    static {
    }
}
