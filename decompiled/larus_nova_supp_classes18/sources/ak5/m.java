package ak5;

import android.text.TextUtils;
import com.bytedance.ee.bear.net.CloudReqFun;
import com.bytedance.ee.bear.net.HttpException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Response;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m implements Callback {
    public final o a;
    public final u b;

    public m(o r1, com.bytedance.ee.bear.net.a.C0126a r2) {
        this.b = r2;
        this.a = r1;
    }

    public static FormBody a(Map r5, Map r6) {
        FormBody.Builder r0 = new FormBody.Builder();
        if (r5 == null) goto L8;
        Iterator r1 = r5.entrySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        Map.Entry r2 = (Map.Entry) r1.next();
        r0.add((String) r2.getKey(), (String) r2.getValue());
    L8:
        if (r6 == null) goto L19;
        Iterator r3 = r6.keySet().iterator();
    L11:
        if (r3.hasNext() == false) goto L19;
        String r4 = (String) r3.next();
        List r7 = (List) r6.get(r4);
        if (r5 == null) goto L11;
        Iterator r8 = r7.iterator();
    L16:
        if (r8.hasNext() == false) goto L11;
        r0.add(r4, (String) r8.next());
    L19:
        return r0.build();
    }

    public final void onFailure(Call r3, IOException r4) {
        com.bytedance.ee.bear.net.a.C0126a r5 = (com.bytedance.ee.bear.net.a.C0126a) this.b;
        if (r5.a.isCancelled() == true) goto L6;
        r5.a.onError(new CloudReqFun.OkHttpReqException(r4));
        r5.a.onComplete();
        return;
    }

    public final void onResponse(Call r5, Response r6) {
        int r0 = r6.code();
        this.b.getClass();
        String r2 = "";
        if (r5.request() == null) goto L5;
        String r7 = String.valueOf(r5.request().url());
    L20:
        if (r6.body() == null) goto L11;
        r2 = r6.body().string();     // Catch: IOException -> L10
    L11:
        tt5.a.b("OkHttpDataLoader", "onResponse() url = " + r7 + ", code = " + r0 + ", responseStr = " + r2 + ", responseHeaders = " + r6.headers());
        if (TextUtils.isEmpty(r2) == false) goto L14;
    L16:
        u r8 = this.b;
        HttpException r9 = new HttpException(r0, r2);
        com.bytedance.ee.bear.net.a.C0126a r10 = (com.bytedance.ee.bear.net.a.C0126a) r8;
        if (r10.a.isCancelled() == true) goto L23;
        r10.a.onError(new CloudReqFun.OkHttpReqException(r9));
        r10.a.onComplete();
        return;
    L23:
        return;
    L14:
        if (r0 != 200) goto L16;
        u r1 = this.b;
        com.bytedance.ee.bear.net.a.C0126a r3 = (com.bytedance.ee.bear.net.a.C0126a) r1;
        r3.a.onNext(new p(r7, r2, r6.headers().toMultimap()));
        r3.a.onComplete();
        return;
    L5:
        r7 = "";
        goto L20
    }
}
