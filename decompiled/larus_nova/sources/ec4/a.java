package ec4;

import android.text.TextUtils;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Interceptor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile a f472077b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, String> f472078a;

    public a() {
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public final SsResponse intercept(Interceptor.Chain r100) throws Exception {
        Request r101 = r100.request();
        LinkedList r102 = new LinkedList();
        r102.addAll(r101.getHeaders());
        if (this.f472078a != null) goto L6;
        this.f472078a = new HashMap();
    L6:
        if (TextUtils.isEmpty((CharSequence) ((HashMap) this.f472078a).get("x-vc-bdturing-sdk-version")) == false) goto L8;
        ((HashMap) this.f472078a).put("x-vc-bdturing-sdk-version", "4.1.1.cn");
    L8:
        Map<String, String> r103 = this.f472078a;
        if (r103 == null) goto L15;
        Iterator r104 = ((HashMap) r103).entrySet().iterator();
    L12:
        if (r104.hasNext() == false) goto L15;
        Map.Entry r105 = (Map.Entry) r104.next();
        r102.add(new Header((String) r105.getKey(), (String) r105.getValue()));
    L15:
        return r100.proceed(r101.newBuilder().headers(r102).build());
    }
}
