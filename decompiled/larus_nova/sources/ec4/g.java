package ec4;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public final class g implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map f472084a;

    public g(Map r100) {
        this.f472084a = r100;
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public final SsResponse intercept(Interceptor.Chain r100) throws Exception {
        Request r101 = r100.request();
        LinkedList r102 = new LinkedList();
        r102.addAll(r101.getHeaders());
        Iterator r103 = this.f472084a.keySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L7;
        String r104 = (String) r103.next();
        r102.add(new Header(r104, (String) this.f472084a.get(r104)));
        goto L4
    L7:
        return r100.proceed(r101.newBuilder().headers(r102).build());
    }
}
