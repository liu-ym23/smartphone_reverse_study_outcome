package ze4;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f571533a;

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        this.f571533a = r100;
    }

    @JavascriptInterface
    public final void onCJEvent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        boolean r101 = false;
        Boolean r102 = null;
        if (StringsKt.startsWith$default(r100, "cjevent://cj_DOMContentLoaded", false, 2, null) == false) goto L20;
        Uri r103 = UriProtector.parse(r100);     // Catch: Exception -> L17
        String r104 = r103.getHost();     // Catch: Exception -> L17
        String r105 = UriProtector.getQueryParameter(r103, "time");     // Catch: Exception -> L17
        if (r105 == null) goto L7;
        r102 = Boolean.valueOf(new Regex("\\d+").matches(r105));     // Catch: Exception -> L17
    L7:
        if (r102 == null) goto L9;
        r101 = r102.booleanValue();     // Catch: Exception -> L17
    L9:
        if (r101 == true) goto L12;
        return;
    L12:
        if (TextUtils.equals("cj_DOMContentLoaded", r104) == true) goto L14;
        return;
    L14:
        if (TextUtils.isEmpty(r105) == true) goto L22;
        JSONObject r106 = new JSONObject();     // Catch: Exception -> L17
        r106.put("url", this.f571533a);     // Catch: Exception -> L17
        r106.put(ReportCardMonitorPlugin.EVENT_NAME, "cj_DOMContentLoaded");     // Catch: Exception -> L17
        r106.put("event_time", r105);     // Catch: Exception -> L17
        cf4.a.f23507a.c(new kd4.a("cjpay_webview_dom_event", r106, 4));     // Catch: Exception -> L17
        return;
    L22:
        return;
    L23:
        return;
    }
}
