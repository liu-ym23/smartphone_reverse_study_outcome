package gx5;

import com.bytedance.forest.utils.e;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.ttnet.http.HttpRequestInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: classes19.dex */
public final class d {
    public static final void a(Response r100, e r101) {
        Object r102 = r100.getExtraInfo();
        if ((r102 instanceof HttpRequestInfo) == true) goto L5;
        r102 = null;
    L5:
        HttpRequestInfo r103 = (HttpRequestInfo) r102;
        if (r103 == null) goto L8;
        r101.b(new String[]{"cdn_ttnet_app_level_request_start"}, Long.valueOf(r103.appLevelRequestStart));
        r101.b(new String[]{"cdn_ttnet_before_all_interceptors"}, Long.valueOf(r103.beforeAllInterceptors));
        r101.b(new String[]{"cdn_ttnet_request_start"}, Long.valueOf(r103.requestStart));
        r101.b(new String[]{"cdn_ttnet_response_back"}, Long.valueOf(r103.responseBack));
    L8:
        List<Header> r104 = r100.getHeaders();
        r101.getClass();
        ArrayList r105 = new ArrayList();
        Iterator<T> r106 = r104.iterator();
    L10:
        if (r106.hasNext() == false) goto L14;
        Object r107 = r106.next();
        if (ArraysKt.contains(e.f244536h, ((Header) r107).getName()) == false) goto L10;
        r105.add(r107);
        goto L10
    L14:
        Iterator r108 = r105.iterator();
    L16:
        if (r108.hasNext() == false) goto L18;
        Header r109 = (Header) r108.next();
        r101.f244542f.put("cdn-ttnet-" + r109.getName(), r109.getValue());
        goto L16
    }
}
