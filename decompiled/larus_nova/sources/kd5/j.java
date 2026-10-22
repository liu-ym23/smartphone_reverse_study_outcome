package kd5;

import com.bytedance.ee.bear.list.DocumentListInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class j extends com.bytedance.ee.bear.list.u {
    public j() {
    }

    @Override // com.bytedance.ee.bear.list.u
    public final DocumentListInfo e(DocumentListInfo r100, JSONObject r101) {
        super.e(r100, r101);     // Catch: Exception -> L4
    L5:
        return r100;
    L4:
        tt5.a.d("ManualOfflineListParser", "parseList exception");
        goto L5
    }
}
