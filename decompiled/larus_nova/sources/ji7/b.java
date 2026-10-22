package ji7;

import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.ug.sdk.deeplink.CallBackForAppLink;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.network.okhttp.GlobalNetworkGate;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import me.ele.lancet.base.annotations.Skip;
import mi7.k;
import mi7.m;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f499207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f499208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f499209c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ k.a f499210d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ CallBackForAppLink f499211e;

    public final void b() {
        String r100 = "";
        long r101 = System.currentTimeMillis();
        int r102 = 0;
        int r103 = -1;
        HttpURLConnection r104 = (HttpURLConnection) a(new URL(this.f499207a));     // Catch: Throwable -> L7
        r104.setRequestMethod("GET");     // Catch: Throwable -> L7
        r104.setRequestProperty("accept", "*/*");     // Catch: Throwable -> L7
        r104.setRequestProperty(WsConstants.KEY_CONNECTION, HTTP.KEEP_ALIVE);     // Catch: Throwable -> L7
        r104.setConnectTimeout(this.f499208b);     // Catch: Throwable -> L7
        r104.setInstanceFollowRedirects(false);     // Catch: Throwable -> L7
        String r105 = r104.getHeaderField("Location");     // Catch: Throwable -> L7
        r103 = r104.getResponseCode();     // Catch: Throwable -> L6
        r104.disconnect();     // Catch: Throwable -> L6
    L8:
        long r106 = System.currentTimeMillis() - r101;
        int r107 = r103;
        mi7.c.e(this.f499207a, r107, r106, this.f499208b, "http_url_connection");
        if (TextUtils.isEmpty(r105) == false) goto L26;
    L13:
        int r108 = a.c(r103, r100, r105, this.f499209c);
        if (TextUtils.isEmpty(r100) == true) goto L16;
        mi7.c.f(r108, this.f499207a, "http_url_connection");
        m.c(1, r100, this.f499210d);
        m.a(0, r100, this.f499210d);
        fi7.d.b(this.f499211e, r100);
        return;
    L16:
        if (r103 >= 200) goto L18;
    L20:
        m.b(r102, this.f499207a, this.f499210d);
        mi7.c.f(r108, this.f499207a, "http_url_connection");
        fi7.d.b(this.f499211e, r100);
        return;
    L18:
        if (r103 >= 400) goto L20;
        r102 = 1;
        goto L20
    L26:
        r100 = UriProtector.getQueryParameter(UriProtector.parse(r105), "scheme");     // Catch: Throwable -> L12
    L7:
        r105 = "";
        goto L8
    }

    @Override // java.lang.Runnable
    public final void run() {
        b();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection a(URL r100) throws IOException {
        String r101 = r100.getHost();     // Catch: Throwable -> L8 IOException -> L12
        String r102 = r100.getPath();     // Catch: Throwable -> L8 IOException -> L12
        if (com.obric.assistant.network.okhttp.a.c(r101, r102) == false) goto L11;
        FLogger.f375446a.i("UrlConnLancet", "openConnection drop host=" + r101 + " path=" + r102);     // Catch: Throwable -> L8 IOException -> L12
        com.obric.assistant.network.okhttp.a.b(GlobalNetworkGate.a(r101, r102), r101, r102);     // Catch: Throwable -> L8 IOException -> L12
        throw new IOException("[NetGuard] dropped " + r100);     // Catch: Throwable -> L8 IOException -> L12
    L11:
        return r100.openConnection();
    L12:
        e = move-exception;
        throw e;
    L8:
        th = move-exception;
        FLogger.f375446a.e("UrlConnLancet", "openConnection intercept failed, fallback to origin: " + th.getMessage());
        goto L11
    }

    public b(String r100, int r101, String r102, k.a r103, CallBackForAppLink r104) {
        this.f499207a = r100;
        this.f499208b = r101;
        this.f499209c = r102;
        this.f499210d = r103;
        this.f499211e = r104;
    }
}
