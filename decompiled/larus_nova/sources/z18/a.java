package z18;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.larksuite.framework.http.request.HttpHeaders;
import com.larksuite.framework.http.request.HttpMethod;
import com.larksuite.framework.http.request.HttpParams;
import com.larksuite.framework.http.request.RequestBody;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Random;
import x18.d;
import x18.e;

/* JADX INFO: loaded from: classes24.dex */
public final class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HttpParams f569678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HttpHeaders f569679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f569680c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HttpMethod f569681d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RequestBody f569682e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f569683f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile com.larksuite.framework.http.call.b f569684g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final d f569685h;

    public final HttpHeaders a() {
        if (this.f569679b.headersMap.containsKey("X-BaseRequest-ID") == true) goto L6;
        HttpHeaders r100 = this.f569679b;
        long r101 = System.currentTimeMillis();
        r100.put("X-BaseRequest-ID", String.valueOf(r101) + Math.abs(new Random(r101).nextInt()));
    L6:
        return this.f569679b;
    }

    public final String b() {
        String r100 = this.f569680c + "";
        LinkedHashMap<String, String> r101 = this.f569678a.urlParamsMap;
        int r102 = c28.b.f22218a;
        if (TextUtils.isEmpty(r100) == true) goto L31;
        if (r101 != null) goto L6;
        return r100;
    L6:
        if (r101.size() <= 0) goto L33;
        StringBuilder r103 = new StringBuilder(r100);
        if (r100.endsWith("?") == true) goto L11;
        r103.append("?");
    L11:
        Iterator<String> r104 = r101.keySet().iterator();
        boolean r105 = true;
    L13:
        if (r104.hasNext() == false) goto L23;
        String r106 = r104.next();
        if (TextUtils.isEmpty(r106) == true) goto L13;
        if (TextUtils.isEmpty(r101.get(r106)) == true) goto L13;
        if (r105 == false) goto L20;
        r105 = false;
    L21:
        r103.append(r106);
        r103.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r103.append(r101.get(r106));
        goto L13
    L20:
        r103.append("&");
        goto L21
    L23:
        return r103.toString();
    L33:
        return r100;
    L31:
        return r100;
    }

    public a() {
        this.f569678a = new HttpParams();
        this.f569679b = new HttpHeaders();
        this.f569681d = HttpMethod.GET;
        this.f569683f = "BaseRequest";
        this.f569684g = null;
        this.f569685h = e.a.f562147a.f562146a;
    }

    public final void c(b<T> r100) {
        d r101 = this.f569685h;
        r101.getClass();
        this.f569684g = new com.larksuite.framework.http.call.b(r101, this);
        com.larksuite.framework.http.call.b r102 = this.f569684g;
        r102.f285571c.enqueue(new com.larksuite.framework.http.call.a(r102, r100));
    }

    public a(HttpMethod r100, String r101) {
        this.f569678a = new HttpParams();
        this.f569679b = new HttpHeaders();
        this.f569681d = HttpMethod.GET;
        this.f569683f = "BaseRequest";
        this.f569684g = null;
        this.f569685h = e.a.f562147a.f562146a;
        this.f569681d = r100;
        this.f569680c = r101;
    }
}
