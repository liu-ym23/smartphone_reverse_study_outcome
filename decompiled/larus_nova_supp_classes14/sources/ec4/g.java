package ec4;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g implements Interceptor {
    public final /* synthetic */ Map a;

    public g(Map r1) {
        this.a = r1;
    }

    public final SsResponse intercept(Interceptor.Chain r7) throws Exception {
        Request r0 = r7.request();
        LinkedList r1 = new LinkedList();
        r1.addAll(r0.getHeaders());
        Iterator r2 = this.a.keySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L7;
        String r3 = (String) r2.next();
        r1.add(new Header(r3, (String) this.a.get(r3)));
        goto L4
    L7:
        return r7.proceed(r0.newBuilder().headers(r1).build());
    }
}
