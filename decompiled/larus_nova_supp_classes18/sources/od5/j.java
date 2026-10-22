package od5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j {
    public final NetService a;

    public interface a {
        void onFail(int r1, Throwable r2);

        void onSuccess();
    }

    public class b implements NetService.c<Result> {
        public b() {
        }

        public final Result parse(String r3) {
            Result r0 = new Result();
            if (r3 != null) goto L9;
        L8:
            return r0;
        L9:
            r0.code = new JSONObject(r3).optInt("code");     // Catch: JSONException -> L6
        L6:
            e = move-exception;
            e.printStackTrace();
            goto L8
        }
    }

    public j(NetService r1) {
        this.a = r1;
    }

    public static NetService.f a(String r3, String r4, int r5) {
        NetService.f r0 = new NetService.f(r3);
        ((NetService.e) r0).c = 1;
        HashMap r1 = new HashMap();
        r1.put(ResourceData.KEY_TOKEN, r4);
        r1.put(ResourceData.KEY_TYPE, String.valueOf(r5));
        if (qc5.a.h() == false) goto L5;
        r1.put("pin_to_first", String.valueOf(true));
    L5:
        r0.d(r1);
        return r0;
    }
}
