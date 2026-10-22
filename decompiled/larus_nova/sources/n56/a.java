package n56;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.app.NotificationCompat;
import com.alipay.sdk.m.u.i;
import com.bytedance.ies.web.jsbridge.IESWebView;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WebView f518017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f518018b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<String> f518019c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<String> f518020d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<String> f518021e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map<String, c> f518022f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f518023g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HandlerC6893a f518024h;

    /* JADX INFO: renamed from: n56.a$a, reason: collision with other inner class name */
    public class HandlerC6893a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f518025a;

        @Override // android.os.Handler
        public final void handleMessage(Message r110) {
            Object r111 = r110.obj;
            if ((r111 instanceof f) == false) goto L105;
            a r100 = this.f518025a;
            f r112 = (f) r111;
            WebView r101 = r100.f518017a;
            if (r101 == null) goto L112;
            if (r112 != null) goto L9;
            return;
        L9:
            if (TextUtils.equals(NotificationCompat.CATEGORY_CALL, r112.f518029a) == false) goto L113;
            Map<String, c> r102 = r100.f518022f;
            if (r102 != null) goto L14;
            return;
        L14:
            if (((ConcurrentHashMap) r102).isEmpty() == true) goto L108;
            String r103 = r101.getUrl();
            boolean r104 = true;
            if (r100.f518023g == false) goto L18;
        L71:
            if (r104 == true) goto L80;
            JSONObject r105 = new JSONObject();
            r105.put("code", -1);     // Catch: JSONException -> L78
            if (TextUtils.isEmpty(r112.f518035g) == true) goto L76;
            r100.d(r112.f518035g, r112.f518030b, r105);     // Catch: JSONException -> L78
        L96:
            return;
        L76:
            r100.c(r112.f518030b, r105);     // Catch: JSONException -> L78
        L78:
            e = move-exception;
            e.printStackTrace();
            return;
        L80:
            JSONObject r106 = new JSONObject();
            c r107 = (c) ((ConcurrentHashMap) r100.f518022f).get(r112.f518031c);     // Catch: Exception -> L85
            if (r107 == null) goto L88;
            r107.call(r112, r106);     // Catch: Exception -> L85
        L88:
            if (r112.f518038j == true) goto L90;
            return;
        L90:
            if (TextUtils.isEmpty(r112.f518035g) == true) goto L92;
            r100.d(r112.f518035g, r112.f518030b, r106);
            return;
        L92:
            r100.c(r112.f518030b, r106);
            return;
        L85:
            e = move-exception;
            e.printStackTrace();
            goto L88
        L18:
            if (TextUtils.isEmpty(r103) == false) goto L21;
        L25:
            boolean r108 = false;
        L27:
            if (r108 == true) goto L99;
        L53:
            boolean r109 = false;
        L54:
            if (r109 == true) goto L71;
            String r113 = r112.f518031c;
            List<String> r114 = r100.f518020d;
            if (r114 != null) goto L58;
        L60:
            boolean r115 = false;
        L61:
            if (r115 == true) goto L71;
            String r116 = r112.f518031c;
            List<String> r117 = r100.f518021e;
            if (r117 != null) goto L65;
        L67:
            boolean r118 = false;
        L68:
            if (r118 == true) goto L71;
            r104 = false;
            goto L71
        L65:
            if (r117.contains(r116) == false) goto L67;
            r118 = true;
            goto L68
        L58:
            if (r114.contains(r113) == false) goto L60;
            r115 = true;
            goto L61
        L99:
            if (Build.VERSION.SDK_INT >= 27) goto L35;
            int r119 = r103.indexOf(92);     // Catch: Exception -> L52
            if (r119 != (-1)) goto L34;
            String r120 = UriProtector.parse(r103).getHost();     // Catch: Exception -> L52
        L36:
            if (r120 == null) goto L53;
            List<String> r121 = r100.f518019c;     // Catch: Exception -> L52
            if (r121 == null) goto L53;
            if (r121.isEmpty() == true) goto L53;
            int r122 = 0;
        L43:
            if (r122 >= r100.f518019c.size()) goto L53;
            String r123 = (String) ListProtector.get(r100.f518019c, r122);     // Catch: Exception -> L52
            if (r120.equals(r123) == true) goto L51;
            if (r120.endsWith('.' + r123) == true) goto L51;
            r122 = r122 + 1;
        L51:
            r109 = true;
            goto L54
        L34:
            r120 = UriProtector.parse(r103.substring(0, r119)).getHost();     // Catch: Exception -> L52
            goto L36
        L35:
            r120 = UriProtector.parse(r103).getHost();     // Catch: Exception -> L52
            goto L36
        L21:
            if (r103.startsWith("http://") == false) goto L23;
        L26:
            r108 = true;
            goto L27
        L23:
            if (r103.startsWith("https://") == false) goto L25;
        L108:
            return;
        L113:
            return;
        L112:
            return;
        }

        public HandlerC6893a(a r100, Looper r101) {
            this.f518025a = r100;
            super(r101);
        }
    }

    public class b implements ValueCallback<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f518026a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f518027b;

        @Override // android.webkit.ValueCallback
        public final void onReceiveValue(String r100) {
            String r101 = r100;
            a r102 = this.f518027b;
            String r103 = this.f518026a;
            r102.getClass();
            JSONArray r104 = new JSONArray(new JSONObject("{a=" + r101 + i.f25855d).optString(BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, ""));     // Catch: Exception -> L13
            int r105 = r104.length();     // Catch: Exception -> L13
            int r106 = 0;
        L5:
            if (r106 >= r105) goto L25;
            JSONObject r107 = JSONArrayProtectorUtils.getJSONObject(r104, r106);     // Catch: Exception -> L13
            f r108 = new f();     // Catch: Exception -> L13
            r108.f518029a = JSONObjectProtectorUtils.getString(r107, "__msg_type");     // Catch: Exception -> L13
            r108.f518030b = r107.optString("__callback_id", null);     // Catch: Exception -> L13
            r108.f518031c = r107.optString("func");     // Catch: Exception -> L13
            r108.f518032d = r107.optJSONObject("params");     // Catch: Exception -> L13
            r108.f518033e = r107.optInt("JSSDK");     // Catch: Exception -> L13
            r108.f518034f = r107.optString("namespace");     // Catch: Exception -> L13
            r108.f518035g = r107.optString("__iframe_url");     // Catch: Exception -> L13
            r108.f518036h = r103;     // Catch: Exception -> L13
            if (TextUtils.isEmpty(r108.f518029a) == true) goto L12;
            if (TextUtils.isEmpty(r108.f518031c) == true) goto L12;
            Objects.toString(ThreadMethodProxy.currentThread());     // Catch: Exception -> L13
            Message r109 = Message.obtain();     // Catch: Exception -> L13
            r109.obj = r108;     // Catch: Exception -> L13
            r102.f518024h.sendMessage(r109);     // Catch: Exception -> L13
        L12:
            r106 = r106 + 1;
            goto L5
        L25:
            return;
        L13:
            e = move-exception;
            e.toString();     // Catch: JSONException -> L16
            return;
        }

        public b(a r100, String r101) {
            this.f518027b = r100;
            this.f518026a = r101;
        }
    }

    public a(WebView r100) {
        this.f518022f = new ConcurrentHashMap();
        this.f518024h = new HandlerC6893a(this, Looper.getMainLooper());
        this.f518017a = r100;
        if (r100 != null) goto L5;
        return;
    L5:
        if ((r100 instanceof IESWebView) == false) goto L13;
        if (((IESWebView) r100).f249265a == true) goto L13;
        r100.setWebChromeClient(new WebChromeClient());
    L13:
        this.f518017a.getSettings().setJavaScriptEnabled(true);     // Catch: Exception -> L12
        return;
    }

    public final boolean a(String r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.startsWith(this.f518018b) == true) goto L8;
        return false;
    L8:
        String r101 = this.f518018b + "://dispatch_message/";
        String r102 = this.f518018b + "://private/setresult/";
        WebView r103 = this.f518017a;     // Catch: Exception -> L17
        String r104 = r103.getUrl();     // Catch: Exception -> L17
        if (r100.equals(r101) == false) goto L14;
        r103.evaluateJavascript("javascript:ToutiaoJSBridge._fetchQueue()", new b(this, r104));     // Catch: Exception -> L17
        return true;
    L14:
        if (r100.startsWith(r102) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public final boolean b(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(this.f518018b) == true) goto L16;
        String r101 = UriProtector.parse(r100).getScheme().toLowerCase();
        if (this.f518018b.equals(r101) == true) goto L10;
        return false;
    L10:
        if (a(r100) == false) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    public final void g(JSONObject r100) {
        WebView r101 = this.f518017a;
        if (r101 == null) goto L6;
        g.a(r101, "javascript:ToutiaoJSBridge._handleMessageFromToutiao(" + r100.toString() + ")");
        return;
    }

    public final void i(WebViewClient r100) {
        WebView r101 = this.f518017a;
        if (r101 != null) goto L6;
        return;
    L6:
        if ((r100 instanceof n56.b) == false) goto L8;
        ((n56.b) r100).f518028a = this;
    L8:
        r101.setWebViewClient(r100);
    }

    public final void c(String r100, JSONObject r101) {
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L7
        r102.put("__msg_type", "callback");     // Catch: Exception -> L7
        r102.put("__callback_id", r100);     // Catch: Exception -> L7
        if (r101 == null) goto L5;
        r102.put("__params", r101);     // Catch: Exception -> L7
    L5:
        g(r102);     // Catch: Exception -> L7
        return;
    }

    public final void e(String r100, c r101) {
        if (TextUtils.isEmpty(r100) == true) goto L8;
        if (r101 == null) goto L9;
        ((ConcurrentHashMap) this.f518022f).put(r100, r101);
        return;
    L9:
        return;
    }

    public final void f(String r100, JSONObject r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L7
        r102.put("__msg_type", "event");     // Catch: Exception -> L7
        r102.put("__event_id", r100);     // Catch: Exception -> L7
        r102.put("__params", r101);     // Catch: Exception -> L7
        g(r102);     // Catch: Exception -> L7
        return;
    }

    public final void h(JSONObject r100, String r101) {
        WebView r102 = this.f518017a;
        if (r102 == null) goto L6;
        String r103 = Base64.encodeToString(r101.getBytes(), 2);
        g.a(r102, String.format("javascript:(function(){   const iframe = document.querySelector(atob('%s'));   if (iframe && iframe.contentWindow) {        iframe.contentWindow.postMessage(%s, atob('%s'));   }})()", new Object[]{Base64.encodeToString(String.format("iframe[src=\"%s\"", new Object[]{r101}).getBytes(), 2), r100.toString(), r103}));
        return;
    }

    public final void d(String r100, String r101, JSONObject r102) {
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L7
        r103.put("__msg_type", "callback");     // Catch: Exception -> L7
        r103.put("__callback_id", r101);     // Catch: Exception -> L7
        if (r102 == null) goto L5;
        r103.put("__params", r102);     // Catch: Exception -> L7
    L5:
        h(r103, r100);     // Catch: Exception -> L7
        return;
    }
}
