package pq4;

import com.bytedance.ee.bear.bitable.card.viewmodel.share.ShareMeta;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements NetService.c<ShareMeta> {

    /* JADX INFO: renamed from: pq4.a$a, reason: collision with other inner class name */
    public static final class C7227a {
    }

    static {
    }

    public a() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r110) {
        ShareMeta r111 = new ShareMeta(0, null, 0, 0, 0, false, false, null, 255, null);
        JSONObject r112 = new JSONObject(r110).optJSONObject("data");     // Catch: Exception -> L9
        if (r112 == null) goto L11;
        String r113 = r112.optString("addRecordToken");     // Catch: Exception -> L9
        if (r113 == null) goto L11;
        r111.setShareToken(r113);     // Catch: Exception -> L9
    L11:
        return r111;
    L9:
        e = move-exception;
        tt5.a.d("BaseAddShareTokenParser", "get base add share token err : " + e);
        goto L11
    }
}
