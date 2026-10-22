package kd5;

import com.bytedance.ee.bear.list.DocumentListInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j extends com.bytedance.ee.bear.list.u {
    public j() {
    }

    @Override // com.bytedance.ee.bear.list.u
    public final DocumentListInfo e(DocumentListInfo r2, JSONObject r3) {
        super.e(r2, r3);     // Catch: Exception -> L4
    L5:
        return r2;
    L4:
        tt5.a.d("ManualOfflineListParser", "parseList exception");
        goto L5
    }
}
