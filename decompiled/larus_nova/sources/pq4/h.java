package pq4;

import com.bytedance.ee.bear.bitable.card.viewmodel.share.ShareMeta;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class h implements NetService.c<ShareMeta> {

    public static final class a {
    }

    static {
    }

    public h() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r110) {
        ShareMeta r111 = new ShareMeta(0, null, 0, 0, 0, false, false, null, 255, null);     // Catch: Exception -> L8
        JSONObject r112 = new JSONObject(r110).optJSONObject("data");     // Catch: Exception -> L8
        if (r112 == null) goto L13;
        String r113 = r112.optString("recordShareToken");     // Catch: Exception -> L8
        if (r113 == null) goto L14;
        r111.setRecordShareToken(r113);     // Catch: Exception -> L8
        return r111;
    L14:
        return r111;
    L13:
        return r111;
    L8:
        e = move-exception;
        tt5.a.d("ShareMetaParser", "parse: " + e);
        return new ShareMeta(0, null, 0, 0, 0, false, false, null, 255, null);
    }
}
