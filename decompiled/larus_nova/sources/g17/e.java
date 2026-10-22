package g17;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.bytedance.lynx.webview.glue.IWebViewExtension;
import com.bytedance.mt.protector.impl.UriProtector;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes21.dex */
public final class e implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n07.a f479620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, n07.d> f479621b;

    public e(n07.a r100) {
        this.f479620a = r100;
        this.f479621b = new ConcurrentHashMap();
    }

    public final void a(String r100, n07.d r101) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        Uri r102 = UriProtector.parse(r100);
        this.f479621b.put(r102.getHost() + r102.getPath() + "?" + r102.getQuery(), r101);
        return;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object r100, Method r101, Object[] r102) throws Throwable {
        Map r103 = (Map) r102[2];
        Object[] r104 = (Object[]) r103.get("args");
        String r105 = (String) r103.get("name");
        if ("loadUrl".equals(r105) == false) goto L9;
        WebView r106 = (WebView) r104[0];
        String r107 = (String) r104[1];
        if (c.a(r106, r107) == false) goto L7;
        this.f479620a.b(r107);
    L7:
        return null;
    L9:
        if ("reload".equals(r105) == false) goto L15;
        WebView r108 = (WebView) r104[0];
        if (c.a(r108, r108.getUrl()) == false) goto L13;
        this.f479620a.b(r108.getUrl());
    L13:
        return null;
    L15:
        if ("shouldOverrideUrlLoading".equals(r105) == false) goto L24;
        WebView r109 = (WebView) r104[0];
        Object r110 = r104[1];
        if ((r110 instanceof WebResourceRequest) == false) goto L19;
        String r111 = ((WebResourceRequest) r110).getUrl().toString();
    L21:
        if (c.a(r109, r111) == false) goto L23;
        this.f479620a.b(r111);
    L23:
        return null;
    L19:
        r111 = null;
        goto L21
    L24:
        "shouldInterceptRequest".equals(r105);
        if ("onPageStarted".equals(r105) == false) goto L40;
        WebView r112 = (WebView) r104[0];
        final String r113 = (String) r104[1];
        if (c.f479616a != null) goto L29;
        IWebViewExtension.TTSafeBrowsingListener r114 = null;
    L30:
        if (r114 != null) goto L33;
        return null;
    L33:
        if (TextUtils.isEmpty(r113) == false) goto L35;
        n07.d r115 = null;
    L36:
        if (r115 == null) goto L40;
        if (r115.a() == false) goto L40;
        r114.onSDKSafeBrowsingHit(r112, r113, new a(), new d(this, r113));
        goto L40
    L35:
        Uri r116 = UriProtector.parse(r113);
        r115 = this.f479621b.remove(r116.getHost() + r116.getPath() + "?" + r116.getQuery());
        goto L36
    L29:
        r114 = c.f479616a.get(r112);
    L40:
        return null;
    }
}
