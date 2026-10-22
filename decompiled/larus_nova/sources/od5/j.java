package od5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NetService f522845a;

    public interface a {
        void onFail(int r100, Throwable r101);

        void onSuccess();
    }

    public class b implements NetService.c<Result> {
        public b() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result parse(String r100) {
            Result r101 = new Result();
            if (r100 != null) goto L9;
        L8:
            return r101;
        L9:
            r101.code = new JSONObject(r100).optInt("code");     // Catch: JSONException -> L6
        L6:
            e = move-exception;
            e.printStackTrace();
            goto L8
        }
    }

    public j(NetService r100) {
        this.f522845a = r100;
    }

    public static NetService.f a(String r100, String r101, int r102) {
        NetService.f r103 = new NetService.f(r100);
        r103.f216906c = 1;
        HashMap r104 = new HashMap();
        r104.put("token", r101);
        r104.put("type", String.valueOf(r102));
        if (qc5.a.h() == false) goto L5;
        r104.put("pin_to_first", String.valueOf(true));
    L5:
        r103.d(r104);
        return r103;
    }
}
