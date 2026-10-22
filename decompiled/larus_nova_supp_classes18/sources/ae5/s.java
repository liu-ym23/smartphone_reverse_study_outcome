package ae5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class s {
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

    public class c implements NetService.c<Result> {
        public final String a;

        public c(String r1) {
            this.a = r1;
        }

        public final Result parse(String r4) {
            Result r0 = new Result();
            if (r4 != null) goto L11;
        L10:
            return r0;
        L11:
            int r5 = new JSONObject(r4).optInt("code");     // Catch: JSONException -> L8
            r0.code = r5;     // Catch: JSONException -> L8
            if (r5 != 0) goto L10;
            mc5.m.a(this).a2(6, this.a);     // Catch: JSONException -> L8
        L8:
            e = move-exception;
            e.printStackTrace();
            goto L10
        }
    }

    public s(NetService r1) {
        this.a = r1;
    }

    public final void a(String r4, int r5, final a r6) {
        NetService.f r0 = new NetService.f("/api/explorer/star/new/");
        ((NetService.e) r0).c = 1;
        HashMap r1 = new HashMap();
        r1.put(ResourceData.KEY_OBJ_TOKEN, r4);
        r1.put(ResourceData.KEY_TYPE, String.valueOf(r5));
        r0.d(r1);
        this.a.Vc(new b()).a(r0).subscribe(new o(r6), new p(r6));
    }

    public final void b(String r5, int r6, final a r7) {
        NetService.d r0 = this.a.Vc(new c(r5));
        NetService.f r1 = new NetService.f("/api/explorer/star/remove/");
        ((NetService.e) r1).c = 1;
        HashMap r2 = new HashMap();
        r2.put(ResourceData.KEY_TOKEN, r5);
        r2.put(ResourceData.KEY_TYPE, String.valueOf(r6));
        r1.d(r2);
        r0.a(r1).subscribe(new q(r7), new r(r7));
    }
}
