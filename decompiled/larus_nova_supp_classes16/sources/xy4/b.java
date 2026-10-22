package xy4;

import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.doc.resupdate.h;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(long r5, boolean r7, String r8, int r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r8, "msg");
        JSONObject r2 = new JSONObject();
        int r3 = j.a.a.getNetworkState().getType();
        r2.put("duration_ms", r5);     // Catch: JSONException -> L5
        r2.put("is_success", r7);     // Catch: JSONException -> L5
        r2.put("errorMsg", r8);     // Catch: JSONException -> L5
        r2.put("retry_count", r9);     // Catch: JSONException -> L5
        r2.put("can_retry", String.valueOf(r10));     // Catch: JSONException -> L5
        r2.put("downloader", "gecko");     // Catch: JSONException -> L5
        r2.put("doc_network_status", r3);     // Catch: JSONException -> L5
        r2.put("slim_res_version", "1.0.24.6732");     // Catch: JSONException -> L5
        tt5.a.b("ResAnalytic", "reportFullPkgDownload, params = " + r2);     // Catch: JSONException -> L5
    L7:
        ((h) org.koin.java.a.c(h.class, null, null, 6)).a("docs_dev_fullPackage_download_duration", r2);
        return;
    L5:
        e = move-exception;
        tt5.a.e("ResAnalytic", "reportFullPkgDownload failed", e, false);
        goto L7
    }
}
