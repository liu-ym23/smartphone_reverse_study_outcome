package t3c;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f544546a = 0;

    static {
    }

    public static void a(JSONObject r100) {
        Statistics.sendEvent("asl_search_view", r100);     // Catch: Exception -> L5
        Log.d("DoubaoSearchOpenReporter", "eventKey:asl_search_view param:" + r100);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.e("DoubaoSearchOpenReporter", e.getMessage());
    }
}
