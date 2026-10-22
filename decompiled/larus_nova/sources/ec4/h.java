package ec4;

import com.bytedance.bdturing.ttnet.INetworkApi;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.ttnet.utils.RetrofitUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class h {
    public static void a() {
        if (a.f472077b == null) goto L5;
    L14:
        RetrofitUtils.addInterceptor(a.f472077b);
        return;
    L5:
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (a.f472077b != null) goto L9;
        a.f472077b = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
        goto L14
    }

    public static INetworkApi b(String r100) {
        return (INetworkApi) RetrofitUtils.getSsRetrofit(r100).create(INetworkApi.class);
    }

    public static List<Header> c(Map<String, String> r100) {
        LinkedList r101 = new LinkedList();
        if (r100 == null) goto L8;
        Iterator<Map.Entry<String, String>> r102 = r100.entrySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        Map.Entry<String, String> r103 = r102.next();
        r101.add(new Header(r103.getKey(), r103.getValue()));
    L8:
        return r101;
    }
}
