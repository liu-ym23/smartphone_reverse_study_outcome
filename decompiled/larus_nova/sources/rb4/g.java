package rb4;

import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.ss.android.downloadlib.constants.MimeType;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.net.URL;
import java.util.HashMap;
import java.util.Objects;
import qb4.n;

/* JADX INFO: loaded from: classes12.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f536932a;

    public final boolean d() {
        c r100 = c.e();
        Object r101 = r100.f536924f;
        monitor-enter(r101);
        boolean r102 = true;
        Boolean r103 = (Boolean) ((HashMap) r100.f536919a).get(1);     // Catch: Throwable -> L18
        if (r103 != null) goto L7;
    L10:
        boolean r104 = true;
    L12:
        if (r100.f536923e.get() == false) goto L15;
        if (r104 == false) goto L15;
    L16:
        monitor-exit(r101);     // Catch: Throwable -> L18
        return r102;
    L15:
        r102 = false;
        goto L16
    L7:
        if (r103.booleanValue() == true) goto L10;
        r104 = false;
    L18:
        th = move-exception;
        throw th;
    }

    public g(String r100) {
        this.f536932a = r100;
    }

    public static String b(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return null;
    L7:
        if (r100.endsWith(".js") == false) goto L10;
        return FastJsonJsonView.DEFAULT_JSONP_CONTENT_TYPE;
    L10:
        if (r100.endsWith(".css") == false) goto L13;
        return "text/css";
    L13:
        if (r100.endsWith(".html") == false) goto L16;
        return "text/html";
    L16:
        if (r100.endsWith(".ico") == false) goto L19;
        return "image/x-icon";
    L19:
        if (r100.endsWith(".jpeg") == false) goto L21;
    L39:
        return "image/jpeg";
    L21:
        if (r100.endsWith(".jpg") == true) goto L39;
        if (r100.endsWith(RoomIntroLabel.ICON_URL_SUFFIX_DEFAULT) == false) goto L27;
        return "image/png";
    L27:
        if (r100.endsWith(EffectConstants.GIF_FILE_SUFFIX) == false) goto L30;
        return MimeType.GIF;
    L30:
        if (r100.endsWith(".woff") == false) goto L33;
        return "font/woff";
    L33:
        if (r100.endsWith(".svg") == false) goto L36;
        return "image/svg+xml";
    L36:
        if (r100.endsWith(".ttf") == false) goto L38;
        return "font/ttf";
    L38:
        return "";
    }

    public final WebResourceResponse c(String r100) {
    L31:
        e = move-exception;
        e.printStackTrace();
        return null;
    L4:
        if (TextUtils.isEmpty(r100) == false) goto L6;
    L30:
        return null;
    L6:
        if (d() == false) goto L30;
        String r101 = new URL(r100).getPath();     // Catch: Exception -> L15
        if (TextUtils.isEmpty(r101) == true) goto L17;
        int r102 = r101.lastIndexOf(HTTP.URL_DEFAULT);     // Catch: Exception -> L15
        if (r102 < 0) goto L19;
        r101 = r101.substring(r102 + 1);     // Catch: Exception -> L15
    L19:
        if (r100.equals(this.f536932a) == false) goto L21;
        String r103 = "text/html";
    L23:
        if (TextUtils.isEmpty(r103) == false) goto L25;
        return null;
    L25:
        PolarisFileInputStreamWrapper r104 = c.e().i(r101, 1);     // Catch: Exception -> L31
        if (r104 != null) goto L28;
        return null;
    L28:
        WebResourceResponse r105 = a(r103, r104);     // Catch: Exception -> L31
        Objects.toString(r105);     // Catch: Exception -> L31
        int r106 = n.f532367a;     // Catch: Exception -> L31
        return r105;
    L21:
        r103 = b(r101);     // Catch: Exception -> L31
    L17:
        r101 = null;
    L15:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L31
        goto L17
    }

    public final void e(String r100) {
    L15:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(this.f536932a) == false) goto L7;
        return;
    L7:
        if (this.f536932a.equals(r100) == false) goto L22;
        String r101 = this.f536932a;     // Catch: Exception -> L15
        if (d() == false) goto L23;
        e r102 = e.a();     // Catch: Exception -> L15
        f r103 = new f(this, r101);     // Catch: Exception -> L15
        PThreadPoolExecutor r104 = r102.f536929a;     // Catch: Exception -> L15
        if (r104 == null) goto L24;
        r104.execute(r103);     // Catch: Exception -> L15
        return;
    L24:
        return;
    L23:
        return;
    }

    public static WebResourceResponse a(String r100, PolarisFileInputStreamWrapper r110) {
    L11:
        e = move-exception;
        e.printStackTrace();
        return null;
    L4:
        if (TextUtils.isEmpty(r100) == true) goto L15;
        HashMap r101 = new HashMap();     // Catch: Exception -> L11
        r101.put("Access-Control-Allow-Origin", "*");     // Catch: Exception -> L11
        if ("font/ttf".equals(r100) == false) goto L8;
        WebResourceResponse r102 = new WebResourceResponse(r100, "", 200, "OK", r101, r110);     // Catch: Exception -> L11
    L10:
        return r102;
    L8:
        r102 = new WebResourceResponse(r100, "", r110);     // Catch: Exception -> L11
        r102.setResponseHeaders(r101);     // Catch: Exception -> L11
        goto L10
    L15:
        return null;
    }
}
