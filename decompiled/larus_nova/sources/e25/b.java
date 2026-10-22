package e25;

import com.bytedance.ee.bear.contract.d;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import org.json.JSONException;
import org.json.JSONObject;
import sbb.e;

/* JADX INFO: loaded from: classes16.dex */
public final class b {
    public static long a(long r100, long r101) {
        if (r101 > 0) goto L5;
    L9:
        return 0;
    L5:
        if (r100 <= r101) goto L9;
        return r100 - r101;
    }

    public static void b(c r110) {
        JSONObject r100 = new JSONObject();
    L11:
        e = move-exception;
        tt5.a.l("PreloadAnalytic", "Failed to report preload, ", e);
        return;
    L4:
        if (r110.f470830m != 0) goto L6;
        r110.f470830m = r110.f470827j;     // Catch: JSONException -> L11
    L6:
        long r101 = System.currentTimeMillis();     // Catch: JSONException -> L11
        JSONObject r102 = r100.put("file_type", e.c(r110.f470818a)).put(ChameleonOpenTracker.ParamKey.LOAD_TYPE, r110.f470819b).put(ResourceData.KEY_LOAD_FROM, r110.f470820c).put("doc_sub_from", r110.f470821d).put("loader_type", r110.f470822e).put("priority", r110.f470823f).put("result_key", r110.f470824g).put("result_code", r110.f470825h).put("result_msg", r110.f470826i).put("wait_init_time", a(r110.f470829l, r110.f470828k)).put("wait_schedule_time", a(r110.f470830m, r110.f470829l)).put("wait_start_time", a(r110.f470827j, r110.f470830m)).put(HiAnalyticsConstant.BI_KEY_COST_TIME, a(r101, r110.f470827j)).put("total_cost_time", a(r101, r110.f470828k)).put("length", r110.f470831n).put(EventConstant.Value.RETRY, r110.f470832o);     // Catch: JSONException -> L11
        String r111 = r110.f470833p;     // Catch: JSONException -> L11
        if (r111 != null) goto L9;
        r111 = "";
    L9:
        r102.put("sheet_id", r111);     // Catch: JSONException -> L11
        tt5.a.h("PreloadAnalytic", r100.toString());     // Catch: JSONException -> L11
        ((d) org.koin.java.a.a(d.class)).u("ccm_docs_preload_data_dev", r100);     // Catch: JSONException -> L11
    }
}
