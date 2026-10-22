package je7;

import android.text.TextUtils;
import android.util.Base64;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.xbridge.cn.platform.web.WebBridgeProtocol;
import java.nio.charset.Charset;
import java.util.Arrays;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class b extends WebBridgeProtocol {

    public static final class a {
    }

    static {
    }

    public b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "namespace");
        super(r100);
    }

    @Override // com.bytedance.sdk.xbridge.cn.platform.web.WebBridgeProtocol
    public final com.bytedance.sdk.xbridge.cn.platform.web.b a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        JSONObject r101 = new JSONObject(r100);
        String r102 = r101.optString("func");
        String r103 = h();
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        JSONObject r104 = r101.optJSONObject("params");
        if (r104 != null) goto L8;
        r104 = new JSONObject();
    L8:
        com.bytedance.sdk.xbridge.cn.platform.web.b r105 = new com.bytedance.sdk.xbridge.cn.platform.web.b(r102, r104, r103);
        String r106 = r101.optString("__callback_id");
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r105.Q = r106;
        Intrinsics.checkNotNullParameter(r101.optString("__msg_type"), "<set-?>");
        r105.f508944b = r101.optLong("__timestamp", System.currentTimeMillis());
        Intrinsics.checkNotNullParameter(r101.optString("JSSDK"), "<set-?>");
        r105.e(WebBridgeProtocol.o(r101.optString("namespace", this.f270009f)));
        String r107 = r101.optString("__iframe_url");
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        r105.P = r107;
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        r105.f508961s = Integer.valueOf(r101.optInt(com.heytap.mcssdk.constant.b.f276371u, 0));
        r105.D = this.f270011h.getCode();
        Intrinsics.checkNotNullParameter("2", "<set-?>");
        r105.R = "2";
        String r108 = r101.optString("__bridgeAuthToken");
        Intrinsics.checkNotNullParameter(r108, "<set-?>");
        r105.S = r108;
        return r105;
    }

    @JavascriptInterface
    public final void invokeMethod(String r100) {
        i(r100);
    }

    @Override // com.bytedance.sdk.xbridge.cn.platform.web.WebBridgeProtocol
    public final void l(WebView r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        r100.addJavascriptInterface(this, "ToutiaoJSBridge");
    }

    @Override // com.bytedance.sdk.xbridge.cn.platform.web.WebBridgeProtocol
    public final String b(com.bytedance.sdk.xbridge.cn.platform.web.b r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r101, "data");
        JSONObject r102 = new JSONObject();
        r102.put("__callback_id", r100.Q);
        r102.put("__params", r101);
        r102.put("__msg_type", "callback");
        if (TextUtils.isEmpty(r100.P) == true) goto L15;
        String r103 = r100.P;
        Charset r104 = Charsets.UTF_8;
        if (r103 == null) goto L13;
        String r105 = Base64.encodeToString(r103.getBytes(r104), 2);
        StringCompanionObject r106 = StringCompanionObject.INSTANCE;
        String r107 = String.format("iframe[src=\"%s\"", Arrays.copyOf(new Object[]{r103}, 1));
        if (r107 == null) goto L11;
        return String.format("javascript:(function(){   const iframe = document.querySelector(atob('%s'));   if (iframe && iframe.contentWindow) {        iframe.contentWindow.postMessage(%s, atob('%s'));   }})()", Arrays.copyOf(new Object[]{Base64.encodeToString(r107.getBytes(r104), 2), r102, r105}, 3));
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L13:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L15:
        return "javascript:ToutiaoJSBridge._handleMessageFromToutiao(" + r102 + ')';
    }

    @Override // com.bytedance.sdk.xbridge.cn.platform.web.WebBridgeProtocol
    public final void m(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        JSONObject r102 = new JSONObject();
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L5
        r102.put("__msg_type", "event");     // Catch: Throwable -> L5
        r102.put("__event_id", r100);     // Catch: Throwable -> L5
        r102.put("__params", r101);     // Catch: Throwable -> L5
        c("javascript:window.ToutiaoJSBridge && ToutiaoJSBridge._handleMessageFromToutiao && ToutiaoJSBridge._handleMessageFromToutiao(" + r102 + ')', null);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Throwable r105 = Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));
        if (r105 == null) goto L12;
        r105.getMessage();
        return;
    }
}
