package e25;

import com.bytedance.ee.bear.contract.d;
import org.json.JSONException;
import org.json.JSONObject;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public static long a(long r3, long r5) {
        if (r5 > 0) goto L5;
    L9:
        return 0;
    L5:
        if (r3 <= r5) goto L9;
        return r3 - r5;
    }

    public static void b(c r10) {
        JSONObject r1 = new JSONObject();
    L11:
        e = move-exception;
        tt5.a.l("PreloadAnalytic", "Failed to report preload, ", e);
        return;
    L4:
        if (r10.m != 0) goto L6;
        r10.m = r10.j;     // Catch: JSONException -> L11
    L6:
        long r2 = System.currentTimeMillis();     // Catch: JSONException -> L11
        JSONObject r3 = r1.put("file_type", e.c(r10.a)).put("load_type", r10.b).put("load_from", r10.c).put("doc_sub_from", r10.d).put("loader_type", r10.e).put("priority", r10.f).put("result_key", r10.g).put("result_code", r10.h).put("result_msg", r10.i).put("wait_init_time", a(r10.l, r10.k)).put("wait_schedule_time", a(r10.m, r10.l)).put("wait_start_time", a(r10.j, r10.m)).put("cost_time", a(r2, r10.j)).put("total_cost_time", a(r2, r10.k)).put("length", r10.n).put("retry", r10.o);     // Catch: JSONException -> L11
        String r11 = r10.p;     // Catch: JSONException -> L11
        if (r11 != null) goto L9;
        r11 = "";
    L9:
        r3.put("sheet_id", r11);     // Catch: JSONException -> L11
        tt5.a.h("PreloadAnalytic", r1.toString());     // Catch: JSONException -> L11
        ((d) org.koin.java.a.a(d.class)).u("ccm_docs_preload_data_dev", r1);     // Catch: JSONException -> L11
    }
}
