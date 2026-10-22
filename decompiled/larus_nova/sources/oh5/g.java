package oh5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.permission.escape.request.InstanceListResult;
import com.google.gson.Gson;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class g implements NetService.c<InstanceListResult> {

    public static final class a {
    }

    static {
    }

    public g() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r100) {
        if (r100 == null) goto L19;
        JSONObject r101 = new JSONObject(r100);     // Catch: Throwable -> L11
        if (r101.optInt("code") != 0) goto L16;
        InstanceListResult r102 = (InstanceListResult) new Gson().fromJson(r101.optString("data"), InstanceListResult.class);     // Catch: Throwable -> L11
        if (r102 != null) goto L18;
        return null;
    L18:
        return r102;
    L16:
        return null;
    L11:
        th = move-exception;
        tt5.a.f("CreateInstanceParser", th, false);
        return null;
    L19:
        return null;
    }
}
