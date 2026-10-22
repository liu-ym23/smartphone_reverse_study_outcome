package u10;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f548264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f548265b;

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public final SsResponse intercept(Interceptor.Chain r100) throws Exception {
        Request r101 = r100.request();
        ArrayList r102 = new ArrayList(r101.getHeaders());
        Header r103 = new Header(AppConstants.HTTP_H_REFERER, "https://tmaservice.developer.toutiao.com?appid=" + this.f548264a + "&version=" + this.f548265b);
        String r104 = System.getProperty("http.agent") + " " + ((IHostContext) jc1.k.f(IHostContext.class)).appName() + HTTP.URL_DEFAULT + ((IHostContext) jc1.k.f(IHostContext.class)).getVersionCode() + " ToutiaoMicroApp/" + com.bytedance.android.livesdk.sharedpref.b.B2.getValue() + " PluginVersion/" + this.f548265b;     // Catch: Exception -> L5
    L6:
        Header r105 = new Header("User-Agent", r104);
        a(r102, r103);
        a(r102, r105);
        return r100.proceed(r101.newBuilder().headers(r102).build());
    L5:
        r104 = "android";
        goto L6
    }

    public a(String r100, String r101) {
        this.f548264a = "";
        this.f548265b = "";
        this.f548264a = r100;
        this.f548265b = r101;
    }

    public final void a(List<Header> r100, Header r101) {
        ArrayList r102 = (ArrayList) r100;
        Iterator r103 = r102.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        if (((Header) r103.next()).getName().equals(r101.getName()) == false) goto L4;
        r103.remove();
        goto L4
    L8:
        r102.add(r101);
    }
}
