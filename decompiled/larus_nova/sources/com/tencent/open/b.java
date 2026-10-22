package com.tencent.open;

import android.webkit.WebView;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.tencent.open.log.SLog;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes29.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected HashMap<String, C5542b> f461702a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected WeakReference<WebView> f461703a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected long f461704b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        protected String f461705c;

        public void a() {
            WebView r100 = this.f461703a.get();
            if (r100 != null) goto L5;
            return;
        L5:
            r100.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.f461704b + ",{'r':1,'result':'no such method'})");
        }

        public void a(Object r100) {
            WebView r101 = this.f461703a.get();
            if (r101 != null) goto L6;
            return;
        L6:
            if ((r100 instanceof String) == false) goto L9;
            String r102 = "'" + ((String) r100).replace("\\", "\\\\").replace("'", "\\'") + "'";
        L24:
            r101.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.f461704b + ",{'r':0,'result':" + r102 + "});");
            return;
        L9:
            if ((r100 instanceof Number) == false) goto L11;
        L23:
            r102 = r100.toString();
            goto L24
        L11:
            if ((r100 instanceof Long) == true) goto L23;
            if ((r100 instanceof Integer) == true) goto L23;
            if ((r100 instanceof Double) == true) goto L23;
            if ((r100 instanceof Float) == true) goto L23;
            if ((r100 instanceof Boolean) == false) goto L22;
            r102 = r100.toString();
            goto L24
        L22:
            r102 = "'undefined'";
            goto L24
        }

        public void a(String r100) {
            WebView r101 = this.f461703a.get();
            if (r101 == null) goto L6;
            r101.loadUrl("javascript:" + r100);
            return;
        }

        public a(WebView r100, long r101, String r102) {
            this.f461703a = new WeakReference(r100);
            this.f461704b = r101;
            this.f461705c = r102;
        }
    }

    /* JADX INFO: renamed from: com.tencent.open.b$b, reason: collision with other inner class name */
    public static class C5542b {
        public C5542b() {
        }

        public boolean customCallback() {
            return false;
        }

        public void call(String r110, List<String> r111, a r112) {
            Method[] r100 = getClass().getDeclaredMethods();
            int r101 = r100.length;
            int r102 = 0;
        L3:
            String r103 = null;
            if (r102 >= r101) goto L11;
            Method r104 = r100[r102];
            if (r104.getName().equals(r110) == false) goto L10;
            if (r104.getParameterTypes().length != r111.size()) goto L10;
        L12:
            if (r104 != null) goto L54;
            if (r112 == null) goto L64;
            r112.a();
            return;
        L64:
            return;
        L54:
            int r113 = r111.size();     // Catch: Exception -> L46
            if (r113 != 0) goto L16;
            Object r114 = r104.invoke(this, new Object[0]);     // Catch: Exception -> L46
        L32:
            Class<?> r115 = r104.getReturnType();     // Catch: Exception -> L46
            SLog.d("openSDK_LOG.JsBridge", "-->call, result: " + r114 + " | ReturnType: " + r115.getName());     // Catch: Exception -> L46
            if ("void".equals(r115.getName()) == false) goto L35;
        L43:
            if (r112 == null) goto L62;
            r112.a(null);     // Catch: Exception -> L46
            return;
        L62:
            return;
        L35:
            if (r115 == Void.class) goto L43;
            if (r112 != null) goto L39;
            return;
        L39:
            if (customCallback() == false) goto L60;
            if (r114 == null) goto L42;
            r103 = r114.toString();     // Catch: Exception -> L46
        L42:
            r112.a(r103);     // Catch: Exception -> L46
            return;
        L60:
            return;
        L16:
            if (r113 != 1) goto L18;
            r114 = r104.invoke(this, new Object[]{ListProtector.get(r111, 0)});     // Catch: Exception -> L46
            goto L32
        L18:
            if (r113 != 2) goto L20;
            r114 = r104.invoke(this, new Object[]{ListProtector.get(r111, 0), ListProtector.get(r111, 1)});     // Catch: Exception -> L46
            goto L32
        L20:
            if (r113 != 3) goto L22;
            r114 = r104.invoke(this, new Object[]{ListProtector.get(r111, 0), ListProtector.get(r111, 1), ListProtector.get(r111, 2)});     // Catch: Exception -> L46
            goto L32
        L22:
            if (r113 != 4) goto L24;
            r114 = r104.invoke(this, new Object[]{ListProtector.get(r111, 0), ListProtector.get(r111, 1), ListProtector.get(r111, 2), ListProtector.get(r111, 3)});     // Catch: Exception -> L46
            goto L32
        L24:
            if (r113 == 5) goto L26;
            r114 = r104.invoke(this, new Object[]{ListProtector.get(r111, 0), ListProtector.get(r111, 1), ListProtector.get(r111, 2), ListProtector.get(r111, 3), ListProtector.get(r111, 4), ListProtector.get(r111, 5)});     // Catch: Exception -> L46
            goto L32
        L26:
            r114 = r104.invoke(this, new Object[]{ListProtector.get(r111, 0), ListProtector.get(r111, 1), ListProtector.get(r111, 2), ListProtector.get(r111, 3), ListProtector.get(r111, 4)});     // Catch: Exception -> L46
        L46:
            e = move-exception;
            SLog.e("openSDK_LOG.JsBridge", "-->handler call mehtod ex. targetMethod: " + r104, e);
            if (r112 == null) goto L63;
            r112.a();
            return;
        L63:
            return;
        L10:
            r102 = r102 + 1;
            goto L3
        L11:
            r104 = null;
            goto L12
        }
    }

    public b() {
        this.f461702a = new HashMap();
    }

    public boolean a(WebView r100, String r101) {
        SLog.v("openSDK_LOG.JsBridge", "-->canHandleUrl---url = " + r101);
        if (r101 != null) goto L6;
        return false;
    L6:
        if (UriProtector.parse(r101).getScheme().equals("jsbridge") == true) goto L8;
        return false;
    L8:
        ArrayList r102 = new ArrayList(Arrays.asList(r101.concat("/#").split(HTTP.URL_DEFAULT)));
        if (r102.size() >= 6) goto L11;
        return false;
    L11:
        String r103 = (String) ListProtector.get(r102, 2);
        String r104 = (String) ListProtector.get(r102, 3);
        List<String> r105 = r102.subList(4, r102.size() - 1);
        a r106 = new a(r100, 4, r101);
        r100.getUrl();
        a(r103, r104, r105, r106);
        return true;
    }

    public void a(C5542b r100, String r101) {
        this.f461702a.put(r101, r100);
    }

    public void a(String r100, String r101, List<String> r102, a r103) {
        SLog.v("openSDK_LOG.JsBridge", "getResult---objName = " + r100 + " methodName = " + r101);
        int r104 = r102.size();
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L9;
        ListProtector.set(r102, r105, URLDecoder.decode((String) ListProtector.get(r102, r105), "UTF-8"));     // Catch: UnsupportedEncodingException -> L6
    L8:
        r105 = r105 + 1;
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    L9:
        C5542b r106 = this.f461702a.get(r100);
        if (r106 == null) goto L12;
        SLog.d("openSDK_LOG.JsBridge", "call----");
        r106.call(r101, r102, r103);
        return;
    L12:
        SLog.d("openSDK_LOG.JsBridge", "not call----objName NOT FIND");
        if (r103 == null) goto L22;
        r103.a();
        return;
    }
}
