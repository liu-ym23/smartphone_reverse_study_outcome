package f25;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.offline.base.FetchModel;
import com.bytedance.ee.bear.document.offline.base.OfflineResultModel;
import com.bytedance.ee.eenet.httpclient.rust.exception.RustIOException;
import com.bytedance.ee.eenet.util.ComplexConnect;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.Iterator;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g implements FlowableOnSubscribe<OfflineResultModel> {
    public final /* synthetic */ FetchModel a;
    public final /* synthetic */ int[] b;
    public final /* synthetic */ f c;

    public class a implements Callback {
        public final /* synthetic */ Call a;
        public final /* synthetic */ FlowableEmitter b;
        public final /* synthetic */ g c;

        public final void onFailure(Call r9, IOException r10) {
            this.c.c.b.remove(this.a);
            if (this.b.isCancelled() == false) goto L5;
            return;
        L5:
            tt5.a.d(this.c.c.a, "==openDocs==fetch==    url: " + du5.b.l(this.c.a.url) + "    Exception: " + r10);
            String r11 = r10.toString();
            if ((r10 instanceof RustIOException) == false) goto L8;
            int r0 = ((RustIOException) r10).getRustSdkErrorCode();
        L9:
            this.c.c.getClass();
            if ((r10 instanceof SocketTimeoutException) == false) goto L12;
        L15:
            boolean r1 = true;
        L17:
            if (r1 == false) goto L22;
            g r2 = this.c;
            int[] r6 = r2.b;
            r6[0] = r6[0] + 1;
            tt5.a.h(r2.c.a, "==openDocs==fetch== onFailure: try count " + this.c.b[0] + "   errorCode: " + r0 + "  e: " + r10.toString());
            g r3 = this.c;
            if (r3.b[0] < r3.a.retryCount) goto L21;
            tt5.a.h(r3.c.a, "==openDocs==fetch== onFailure: have tried " + this.c.a.retryCount + " times for ");
            this.b.onNext(new OfflineResultModel(r0, r11, "{}"));
            this.b.onComplete();
            return;
        L21:
            this.b.onError(r10);
            this.b.onComplete();
            return;
        L22:
            tt5.a.d(this.c.c.a, "==openDocs==fetch== onFailure   errorCode: " + r0 + "  e: " + r10.toString());
            this.b.onNext(new OfflineResultModel(r0, r11, "{}"));
            this.b.onComplete();
            return;
        L12:
            if ((r10 instanceof ConnectException) == true) goto L15;
            r1 = false;
            goto L17
        L8:
            r0 = ax4.c.a(r10);
            goto L9
        }

        public final void onResponse(Call r8, Response r9) throws IOException {
            this.c.c.b.remove(this.a);
            if (this.b.isCancelled() == false) goto L5;
            return;
        L5:
            tt5.a.h(this.c.c.a, "==openDocs==fetch== onResponse: request success for " + r8 + "   url: " + du5.b.l(this.c.a.url));
            ResponseBody r0 = r9.body();
            if (r0 != null) goto L8;
            String r1 = "";
        L9:
            tt5.a.h(this.c.c.a, "==openDocs==fetch== responseStr length: " + r1.length());
            if (TextUtils.isEmpty(r1) == true) goto L15;
            if (r1.endsWith(DocViewModel.ENTER_CHAR) == false) goto L15;
            r1 = yu5.c.i(r1);
            tt5.a.h(this.c.c.a, "==openDocs==fetch== response replaceLast and length: " + r1.length());
        L15:
            if (TextUtils.isEmpty(r1) == false) goto L17;
        L19:
            OfflineResultModel r2 = new OfflineResultModel();
            r2.setData(r1);
            int r4 = 0;
            if (TextUtils.isEmpty(r1) == true) goto L26;
            g r3 = this.c;
            if (r3.a.checkResponseDataJSONValid == false) goto L26;
            tt5.a.h(r3.c.a, "==openDocs==fetch== checkResponseDataJSONValid");     // Catch: Exception -> L25
            JSON.parseObject(r1);     // Catch: Exception -> L25
            r2.setDataJsonInvalid(false);     // Catch: Exception -> L25
        L25:
            r2.setDataJsonInvalid(true);
        L26:
            r2.setMessage("");
            int r10 = r9.code();
            if (r10 == 200) goto L30;
            r4 = r10;
        L30:
            if (r4 <= 0) goto L32;
            int r11 = -r4;
        L33:
            r2.setCode(r11);
            if (r4 == 0) goto L36;
            tt5.a.d(this.c.c.a, "==openDocs==fetch== requestNetResource()... code = " + r4 + ", responseStr = " + r1 + ", for " + r8);
        L36:
            this.b.onNext(r2);
            this.b.onComplete();
            return;
        L32:
            r11 = r4;
            goto L33
        L17:
            if (r1.length() <= f.j) goto L19;
            iu5.d.a("NET_RESPONSE", new Throwable("url: " + this.c.a.url + " and response length: " + r1.length()));
            goto L19
        L8:
            r1 = r0.string();
            goto L9
        }

        public a(g r1, Call r2, FlowableEmitter r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public final void subscribe(FlowableEmitter<OfflineResultModel> r6) throws Exception {
        if (r6.isCancelled() == false) goto L5;
        return;
    L5:
        tt5.a.h(this.c.a, "==openDocs==fetch== subscribe: begin request for " + du5.b.l(this.a.url));
        f r0 = this.c;
        FetchModel r1 = this.a;
        r0.getClass();
        r1.headers.remove("Accept-Encoding");
        Request.Builder r2 = new Request.Builder();
        r2.url(r1.url);
        Map<String, String> r3 = r1.headers;
        if (r3 == null) goto L12;
        Iterator<Map.Entry<String, String>> r4 = r3.entrySet().iterator();
    L9:
        if (r4.hasNext() == false) goto L12;
        Map.Entry<String, String> r5 = r4.next();
        r2.addHeader(r5.getKey(), r5.getValue());
    L12:
        if ("get".equalsIgnoreCase(r1.method) == false) goto L14;
        r2.method(r1.method, null);
    L19:
        r2.addHeader("EENet-Request-Tag", "docJSFetchRequest");
        r2.addHeader("fromsource", "mobileweb");
        f r7 = this.c;
        String r8 = this.a.key;
        r7.getClass();
        if (TextUtils.equals(r8, "CLIENT_VARS") == false) goto L22;
        r2.addHeader("EENet-Request-Enable-Complex-Connect", ComplexConnect.TRUE.toString());
    L22:
        Call r9 = this.c.d.b().newCall(r2.build());
        this.c.b.add(r9);
        r9.enqueue(new a(this, r9, r6));
        return;
    L14:
        String r10 = r1.method;
        MediaType r11 = MediaType.parse(r1.headers.get("Content-Type"));
        if (TextUtils.isEmpty(r1.body) == false) goto L17;
        String r12 = "";
    L18:
        r2.method(r10, RequestBody.create(r11, r12));
        goto L19
    L17:
        r12 = r1.body;
        goto L18
    }

    public g(f r1, FetchModel r2, int[] r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
