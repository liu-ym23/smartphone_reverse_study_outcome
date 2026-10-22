package mv4;

import com.bytedance.ee.bear.bitable.workbench.WorkBenchStatus;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f implements NetService.c<WorkBenchStatus> {
    public f() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r5) {
        boolean r0 = false;
        if (r5 != null) goto L13;
        tt5.a.d("WorkBenchDataParser", "get bench status return null json");
        return new WorkBenchStatus(false, 1, null);
    L13:
        JSONObject r6 = new JSONObject(r5).optJSONObject("data");     // Catch: Exception -> L8
        if (r6 == null) goto L15;
        r0 = r6.optBoolean("isAdded");     // Catch: Exception -> L8
    L15:
        return new WorkBenchStatus(r0);
    L8:
        e = move-exception;
        tt5.a.d("WorkBenchDataParser", "get error while parse result ... " + e.getMessage());
        goto L15
    }
}
