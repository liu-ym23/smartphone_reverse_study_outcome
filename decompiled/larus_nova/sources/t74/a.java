package t74;

import android.text.TextUtils;
import com.bytedance.bdinstall.dtrait.constant.DTraitRiskType;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import m74.c;
import v74.e;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC7693a f544882a;

    /* JADX INFO: renamed from: t74.a$a, reason: collision with other inner class name */
    public interface InterfaceC7693a {
        DTraitRiskType a();

        boolean b(String r100);

        int getTimeout();
    }

    public a(n09.a r100) {
        this.f544882a = r100;
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public final SsResponse intercept(Interceptor.Chain r100) throws Exception {
        Request r101 = r100.request();
        ArrayList r102 = new ArrayList(r101.getHeaders());
        String r103 = r101.getUrl();
        if (this.f544882a.b(r103) == false) goto L25;
        String r104 = r101.getPath();
        DTraitRiskType r105 = this.f544882a.a();
        int r106 = this.f544882a.getTimeout();
        c r107 = (c) e.a(c.class);
        if (r107 == null) goto L7;
        Map<String, String> r108 = r107.f512345a.a(r104, r105, r106);
    L8:
        if (r108 == null) goto L23;
        if (r108.isEmpty() == true) goto L23;
        Iterator<Map.Entry<String, String>> r109 = r108.entrySet().iterator();
    L13:
        if (r109.hasNext() == false) goto L23;
        Map.Entry<String, String> r110 = r109.next();
        if (r110 == null) goto L13;
        String r111 = r110.getKey();
        String r112 = r110.getValue();
        if (TextUtils.isEmpty(r111) == true) goto L13;
        if (TextUtils.isEmpty(r112) == true) goto L13;
        r102.add(new Header(r111, r112));
    L23:
        return r100.proceed(r101.newBuilder().headers(r102).build());
    L7:
        r108 = new HashMap();
        goto L8
    L25:
        return r100.proceed(r101);
    }
}
