package xy4;

import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.doc.resupdate.h;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f565405a = 0;

    static {
    }

    public static void a(long r100, boolean r101, String r102, int r103, boolean r110) {
        Intrinsics.checkNotNullParameter(r102, "msg");
        JSONObject r104 = new JSONObject();
        int r105 = j.a.f217090a.getNetworkState().getType();
        r104.put("duration_ms", r100);     // Catch: JSONException -> L5
        r104.put("is_success", r101);     // Catch: JSONException -> L5
        r104.put("errorMsg", r102);     // Catch: JSONException -> L5
        r104.put("retry_count", r103);     // Catch: JSONException -> L5
        r104.put("can_retry", String.valueOf(r110));     // Catch: JSONException -> L5
        r104.put(DBDefinition.DOWNLOAD_TABLE_NAME, "gecko");     // Catch: JSONException -> L5
        r104.put("doc_network_status", r105);     // Catch: JSONException -> L5
        r104.put("slim_res_version", "1.0.24.6732");     // Catch: JSONException -> L5
        tt5.a.b("ResAnalytic", "reportFullPkgDownload, params = " + r104);     // Catch: JSONException -> L5
    L7:
        ((h) org.koin.java.a.c(h.class, null, null, 6)).a("docs_dev_fullPackage_download_duration", r104);
        return;
    L5:
        e = move-exception;
        tt5.a.e("ResAnalytic", "reportFullPkgDownload failed", e, false);
        goto L7
    }
}
