package mv4;

import com.bytedance.ee.bear.bitable.workbench.WorkBenchStatus;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
public final class f implements NetService.c<WorkBenchStatus> {
    public f() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r100) {
        boolean r101 = false;
        if (r100 != null) goto L13;
        tt5.a.d("WorkBenchDataParser", "get bench status return null json");
        return new WorkBenchStatus(false, 1, null);
    L13:
        JSONObject r102 = new JSONObject(r100).optJSONObject("data");     // Catch: Exception -> L8
        if (r102 == null) goto L15;
        r101 = r102.optBoolean("isAdded");     // Catch: Exception -> L8
    L15:
        return new WorkBenchStatus(r101);
    L8:
        e = move-exception;
        tt5.a.d("WorkBenchDataParser", "get error while parse result ... " + e.getMessage());
        goto L15
    }
}
