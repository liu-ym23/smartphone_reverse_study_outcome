package pq4;

import com.bytedance.ee.bear.bitable.card.viewmodel.share.ShareMeta;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.ss.android.lark.chat.core.dependency.ForwardDependency$ForwardLocation;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class g implements NetService.c<ShareMeta> {

    public static final class a {
    }

    static {
    }

    public g() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r110) {
        JSONObject r111 = new JSONObject(r110).optJSONObject("data");     // Catch: Exception -> L16
        if (r111 == null) goto L20;
        JSONObject r100 = r111.optJSONObject("submitSettings");     // Catch: Exception -> L16
        int r101 = r111.optInt(ForwardDependency$ForwardLocation.FLAG);     // Catch: Exception -> L16
        String r102 = r111.optString("shareToken");     // Catch: Exception -> L16
        int r103 = r111.optInt("objType");     // Catch: Exception -> L16
        int r104 = r111.optInt("shareType");     // Catch: Exception -> L16
        if (r100 == null) goto L10;
        JSONObject r105 = r100.optJSONObject("submitLimit");     // Catch: Exception -> L16
        if (r105 == null) goto L10;
        int r106 = r105.optInt("frequencyLimit");     // Catch: Exception -> L16
    L11:
        if (r100 == null) goto L13;
        boolean r107 = r100.optBoolean("enableAnonymousSubmit");     // Catch: Exception -> L16
    L21:
        return new ShareMeta(r101, r102, r103, r104, r106, r107, r111.optBoolean("constraintExternal"), null, 128, null);
    L13:
        r107 = false;
    L10:
        r106 = 0;
        goto L11
    L20:
        return new ShareMeta(0, null, 0, 0, 0, false, false, null, 255, null);
    L16:
        e = move-exception;
        tt5.a.d("ShareMetaParser", "parse: " + e);
        return new ShareMeta(0, null, 0, 0, 0, false, false, null, 255, null);
    }
}
