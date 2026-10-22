package cl5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f {
    public final NetService a;

    public static class a implements NetService.c<Result<?>> {
        public a() {
        }

        public final Result<?> parse(String r4) {
            Result<?> r0 = new Result();
            r0.code = new JSONObject(r4).optInt("code", 0);     // Catch: JSONException -> L5
        L7:
            return r0;
        L5:
            e = move-exception;
            tt5.a.d("OperationInfoRequester", "BusinessInfoResultParser() exception = " + e);
            goto L7
        }
    }

    public f(NetService r1) {
        this.a = r1;
    }
}
