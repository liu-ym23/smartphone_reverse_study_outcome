package zra;

import com.bytedance.retrofit2.client.Header;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.ss.android.bytedcert.adapter.network.NetService;
import com.ss.android.cert.manager.constants.UrlConstant;
import com.ss.android.cert.manager.utils.net.ParserUrl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public final class a {
    public static List<Header> a(Map<String, String> r100) {
        ArrayList r101 = new ArrayList();
        if (r100 != null) goto L5;
    L12:
        return r101;
    L5:
        if (r100.isEmpty() == true) goto L12;
        Iterator<Map.Entry<String, String>> r102 = r100.entrySet().iterator();
    L8:
        if (r102.hasNext() == false) goto L12;
        Map.Entry<String, String> r103 = r102.next();
        if (r103 == null) goto L8;
        r101.add(new Header(r103.getKey(), r103.getValue()));
        goto L8
    }

    public static NetService b(String r100) {
        if (r100.startsWith("http") == false) goto L5;
        ParserUrl r101 = new ParserUrl(r100);
        r101.invoke();
        return (NetService) RetrofitUtils.createSsService(r101.getBaseUrl(), NetService.class);
    L5:
        return (NetService) RetrofitUtils.createSsService(UrlConstant.getBaseUrl(), NetService.class);
    }
}
