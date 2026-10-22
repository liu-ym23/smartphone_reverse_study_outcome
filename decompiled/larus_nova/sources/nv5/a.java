package nv5;

import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.falconx.statistic.InterceptorModel;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.common.util.UriUtil;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f520865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<qv5.c> f520866b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f520867c;

    /* JADX INFO: renamed from: nv5.a$a, reason: collision with other inner class name */
    public class RunnableC6978a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WebView f520868a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ InterceptorModel f520869b;

        @Override // java.lang.Runnable
        public final void run() {
            String r100 = this.f520868a.getUrl();     // Catch: Throwable -> L4 Exception -> L6
            this.f520869b.pageUrl = r100;     // Catch: Throwable -> L4
        L15:
            return;
        L6:
            e = move-exception;
            GeckoLogger.w("WebOffline-falcon", "getUrl:", e);     // Catch: Throwable -> L4
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        }

        public RunnableC6978a(WebView r100, InterceptorModel r101) {
            this.f520868a = r100;
            this.f520869b = r101;
        }
    }

    public a(f r100) {
        this.f520866b = new ArrayList();
        this.f520865a = r100;
        this.f520867c = new Handler(r100.getContext().getMainLooper());
        Iterator<Uri> r101 = r100.f520880d.iterator();
    L4:
        if (r101.hasNext() == false) goto L22;
        Uri r102 = r101.next();
        String r103 = r102.getScheme();
        if (r103 != null) goto L8;
        String r104 = "";
    L10:
        if ("".equals(r104) == true) goto L21;
        if ("file".equals(r104) == true) goto L21;
        if (UriUtil.LOCAL_ASSET_SCHEME.equals(r104) == true) goto L16;
        GeckoLogger.w("WebOffline-falcon", "unknown scheme:" + r102);
        goto L4
    L16:
        String r105 = r102.getPath();
        if (r105.startsWith(HTTP.URL_DEFAULT) == false) goto L19;
        r105 = r105.substring(1);
    L19:
        ((ArrayList) this.f520866b).add(new qv5.a(r100.getContext(), new PolarisFileWrapper(r105)));
    L21:
        ((ArrayList) this.f520866b).add(new qv5.b(r100.getContext(), r100.f520878b, new PolarisFileWrapper(r102.getPath())));
        goto L4
    L8:
        r104 = r103.toLowerCase();
        goto L10
    }

    @Override // nv5.d
    public final WebResourceResponse shouldInterceptRequest(WebView r100, String r101) {
        List<Pattern> r102 = this.f520865a.f520879c;     // Catch: Exception -> L17
        if (r102 != null) goto L6;
    L16:
        return null;
    L6:
        if (r102.isEmpty() == true) goto L16;
        if (TextUtils.isEmpty(r101) == true) goto L16;
        InterceptorModel r103 = new InterceptorModel();     // Catch: Exception -> L17
        r103.url = r101;     // Catch: Exception -> L17
        WebResourceResponse r104 = a(r100, r101, r103);     // Catch: Exception -> L17
        if (r104 == null) goto L13;
    L15:
        return r104;
    L13:
        if (r103.offlineRule == null) goto L15;
        this.f520867c.post(new c(r100, r103));     // Catch: Exception -> L17
    L17:
        e = move-exception;
        GeckoLogger.w("WebOffline-falcon", "shouldInterceptRequest:", e);
        return null;
    }

    public final WebResourceResponse a(WebView r110, String r111, InterceptorModel r210) throws Exception {
        r210.accessKey = this.f520865a.f520878b;
        if (r110 == null) goto L5;
        r110.post(new RunnableC6978a(r110, r210));
    L5:
        Iterator<Pattern> r100 = this.f520865a.f520879c.iterator();
    L7:
        if (r100.hasNext() == false) goto L91;
        Pattern r101 = r100.next();
        if (r101 == null) goto L7;
        Matcher r102 = PatternProtector.compile(r101.pattern() + "??").matcher(r111);
        boolean r112 = true;
        if (r102.find() == false) goto L39;
        r210.offlineRule = r101.pattern();
        int r103 = r111.indexOf("??");
        if (r103 <= 0) goto L39;
        String r113 = r111.substring(r102.end() + 1, r103);
        String[] r104 = r111.substring(r103 + 2).split(",");
        if (r104.length <= 1) goto L39;
        String r105 = r113 + r104[0];
        r104[0] = r105;
        String r114 = sv5.a.a(r105);
        int r106 = 1;
    L22:
        if (r106 >= r104.length) goto L27;
        String r115 = r113 + r104[r106];
        r104[r106] = r115;
        if (TextUtils.equals(sv5.a.a(r115), r114) == false) goto L39;
        r106 = r106 + 1;
        goto L22
    L27:
        ArrayList r116 = new ArrayList();
        int r117 = r104.length;
        int r118 = 0;
    L28:
        if (r118 >= r117) goto L41;
        String r107 = r104[r118];
        Iterator r119 = ((ArrayList) this.f520866b).iterator();
    L31:
        if (r119.hasNext() == false) goto L37;
        qv5.c r108 = (qv5.c) r119.next();
        r210.resRootDir = r108.a();     // Catch: Throwable -> L35
        Map<String, Long> r109 = r108.b();     // Catch: Throwable -> L35
        r210.channel = r113;     // Catch: Throwable -> L35
        r210.mimeType = r114;     // Catch: Throwable -> L35
        r210.pkgVersion = r109.get(r113);     // Catch: Throwable -> L35
        r210.isCombo = r112;     // Catch: Throwable -> L35
        InputStream r120 = r108.getInputStream(r107);     // Catch: Throwable -> L35
    L38:
        if (r120 == null) goto L39;
        r116.add(r120);
        r118 = r118 + 1;
        r112 = true;
    L35:
        th = move-exception;
        GeckoLogger.w("WebOffline-falcon", "handleCombo:", th);
        r112 = true;
        goto L31
    L37:
        r120 = null;
        goto L38
    L41:
        WebResourceResponse r121 = sv5.b.a(r114, "", new SequenceInputStream(Collections.enumeration(r116)));
    L42:
        if (r121 != null) goto L43;
        Matcher r122 = r101.matcher(r111);
        if (r122.find() == false) goto L7;
        r210.offlineRule = r101.pattern();
        int r123 = r111.indexOf("?");
        int r124 = r111.indexOf("#");
        int r125 = Math.min(r123, r124);
        if (r125 != (-1)) goto L54;
        r125 = Math.max(r123, r124);
    L54:
        if (r125 == (-1)) goto L56;
        String r126 = r111.substring(r122.end(), r125);
    L58:
        if (r126.endsWith(HTTP.URL_DEFAULT) == false) goto L60;
        int r127 = 1;
        r126 = r126.substring(0, r126.length() - 1);
    L62:
        if (r126.startsWith(HTTP.URL_DEFAULT) == false) goto L64;
        r126 = r126.substring(r127);
    L64:
        String r128 = r126;
        Iterator r129 = ((ArrayList) this.f520866b).iterator();
    L66:
        if (r129.hasNext() == false) goto L7;
        qv5.c r130 = (qv5.c) r129.next();
        String r131 = sv5.a.a(r128);
        r210.resRootDir = r130.a();     // Catch: Throwable -> L87 FileNotFoundException -> L89
        Map<String, Long> r132 = r130.b();     // Catch: Throwable -> L87 FileNotFoundException -> L89
        String r133 = r128.substring(0, r128.indexOf(HTTP.URL_DEFAULT));     // Catch: Throwable -> L87 FileNotFoundException -> L89
        r210.channel = r133;     // Catch: Throwable -> L87 FileNotFoundException -> L89
        r210.pkgVersion = r132.get(r133);     // Catch: Throwable -> L87 FileNotFoundException -> L89
        r210.mimeType = r131;     // Catch: Throwable -> L87 FileNotFoundException -> L89
    L69:
        WebResourceResponse r134 = sv5.b.a(r131, "", r130.getInputStream(r128));
        if (r134 == null) goto L85;
        String r135 = "path:".concat(r128);
        long r136 = r210.getVersion();
        if (ov5.b.f526910a == true) goto L74;
        List<pv5.a> r137 = ov5.a.f526904a;
    L78:
        InputStream r138 = r134.getData();
        if (r138 == null) goto L86;
        r134.setData(new b(this, r138, r210, r110));
    L86:
        return r134;
    L74:
        List<ov5.a.C7115a> r139 = ov5.a.f526905b;
        monitor-enter(r139);
        ((ArrayList) r139).add(new ov5.a.C7115a(true, r111, r135, r136));     // Catch: Throwable -> L82
        monitor-exit(r139);     // Catch: Throwable -> L82
    L82:
        th = move-exception;
        throw th;
    L85:
        ov5.a.a(r111, "not found local resource", r210.getVersion());
    L89:
        e = move-exception;
        ov5.a.a(r111, "not found local resource", r210.getVersion());
        GeckoLogger.w("WebOffline-falcon", "tryLoadLocalResource:not found local resource: path:".concat(r128), e);
    L87:
        th = move-exception;
        ov5.a.a(r111, "not found local resource" + th, r210.getVersion());
        GeckoLogger.w("WebOffline-falcon", "tryLoadLocalResource:", th);
        goto L66
    L60:
        r127 = 1;
        goto L62
    L56:
        r126 = r111.substring(r122.end());
        goto L58
    L43:
        InputStream r140 = r121.getData();
        if (r140 == null) goto L47;
        r121.setData(new b(this, r140, r210, r110));
    L47:
        return r121;
    L39:
        r121 = null;
        goto L42
    L91:
        r210.setErrorCode("100");
        r210.setErrorMsg("not found");
        r210.loadFinish(false);
        return null;
    }
}
