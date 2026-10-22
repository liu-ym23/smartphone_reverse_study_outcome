package je7;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.xbridge.cn.platform.web.WebBridgeProtocol;
import com.bytedance.sdk.xbridge.cn.platform.web.d;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import java.nio.charset.Charset;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class a extends WebBridgeProtocol {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f498831i;

    /* JADX INFO: renamed from: je7.a$a, reason: collision with other inner class name */
    public static final class C6425a<T> implements ValueCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f498832a;

        public C6425a(a r100) {
            this.f498832a = r100;
        }

        @Override // android.webkit.ValueCallback
        public final void onReceiveValue(Object r100) {
            String r101 = (String) r100;
            a r102 = this.f498832a;
            r102.getClass();
            JSONArray r103 = new JSONArray(new JSONObject("{a=" + r101 + '}').optString(BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, ""));     // Catch: Exception -> L8
            int r104 = r103.length();     // Catch: Exception -> L8
            int r105 = 0;
        L5:
            if (r105 >= r104) goto L17;
            r102.i(JSONArrayProtectorUtils.getJSONObject(r103, r105).toString());     // Catch: Exception -> L8
            r105 = r105 + 1;
            goto L5
            goto L16
        L17:
            return;
        L8:
            e = move-exception;
            e.toString();     // Catch: JSONException -> L11
            return;
        }
    }

    @Override // com.bytedance.sdk.xbridge.cn.platform.web.WebBridgeProtocol
    public final void l(WebView r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
    }

    @Override // com.bytedance.sdk.xbridge.cn.platform.web.WebBridgeProtocol
    public final void m(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "namespace");
        super(r100);
        this.f498831i = AdBaseConstants.BYTEDANCE_PACKAGE_NAME_SUFFIX;
    }

    @Override // com.bytedance.sdk.xbridge.cn.platform.web.WebBridgeProtocol
    public final com.bytedance.sdk.xbridge.cn.platform.web.b a(String r110) {
        Intrinsics.checkNotNullParameter(r110, "msg");
        JSONObject r100 = new JSONObject(r110);
        String r101 = r100.optString("__msg_type");
        String r102 = r100.optString("__callback_id");
        String r103 = "";
        String r104 = r100.optString("func", "");
        JSONObject r105 = r100.optJSONObject("params");
        if (r105 != null) goto L5;
        r105 = new JSONObject();
    L5:
        String r106 = r100.optString("JSSDK");
        String r107 = r100.optString("namespace", this.f270009f);
        long r108 = r100.optLong("__timestamp", System.currentTimeMillis());
        String r111 = r100.optString("__iframe_url");
        String r112 = h();
        if (r112 == null) goto L9;
        r103 = r112;
    L9:
        com.bytedance.sdk.xbridge.cn.platform.web.b r113 = new com.bytedance.sdk.xbridge.cn.platform.web.b(r104, r105, r103);
        Intrinsics.checkNotNullParameter(r111, "<set-?>");
        r113.P = r111;
        r113.f508944b = r108;
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r113.e(WebBridgeProtocol.o(r107));
        Intrinsics.checkNotNullParameter(r110, "<set-?>");
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r113.Q = r102;
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r113.f508961s = Integer.valueOf(r100.optInt(com.heytap.mcssdk.constant.b.f276371u, 0));
        r113.D = this.f270011h.getCode();
        Intrinsics.checkNotNullParameter("1", "<set-?>");
        r113.R = "1";
        String r114 = r100.optString("__bridgeAuthToken");
        Intrinsics.checkNotNullParameter(r114, "<set-?>");
        r113.S = r114;
        return r113;
    }

    @Override // com.bytedance.sdk.xbridge.cn.platform.web.WebBridgeProtocol
    public final void k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        p(r100);
    }

    @Override // com.bytedance.sdk.xbridge.cn.platform.web.WebBridgeProtocol
    public final boolean n(String r100) {
        if (r100 != null) goto L5;
    L18:
        return false;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L18;
        if (TextUtils.isEmpty(this.f498831i) == true) goto L18;
        String r101 = UriProtector.parse(r100).getScheme();
        if (r101 == null) goto L12;
        String r102 = r101.toLowerCase();
    L14:
        if (Intrinsics.areEqual(this.f498831i, r102) == false) goto L18;
        if (p(r100) == false) goto L18;
        return true;
    L12:
        r102 = null;
        goto L14
    }

    public final boolean p(String r100) {
        if (StringsKt.startsWith$default(r100, this.f498831i, false, 2, null) == true) goto L5;
        return false;
    L5:
        String r101 = this.f498831i + "://dispatch_message/";
        String r102 = this.f498831i + "://private/setresult/";
    L17:
        e = move-exception;
        e.toString();
    L19:
        return false;
    L7:
        if (Intrinsics.areEqual(r100, r101) == false) goto L15;
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L11;
        this.f270010g = f();     // Catch: Exception -> L17
    L12:
        c("javascript:ToutiaoJSBridge._fetchQueue()", new C6425a(this));     // Catch: Exception -> L17
        return true;
    L11:
        this.f270007d.post(new d(this));     // Catch: Exception -> L17
        goto L12
    L15:
        if (StringsKt.startsWith$default(r100, r102, false, 2, null) == false) goto L19;
        return true;
    }

    @Override // com.bytedance.sdk.xbridge.cn.platform.web.WebBridgeProtocol
    public final String b(com.bytedance.sdk.xbridge.cn.platform.web.b r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r101, "data");
        if (TextUtils.isEmpty(r100.P) == true) goto L13;
        JSONObject r102 = new JSONObject();
        r102.put("__msg_type", "callback");
        r102.put("__callback_id", r100.Q);
        r102.put("__params", r101);
        String r103 = r100.P;
        Charset r104 = Charsets.UTF_8;
        if (r103 == null) goto L12;
        String r105 = Base64.encodeToString(r103.getBytes(r104), 2);
        StringCompanionObject r106 = StringCompanionObject.INSTANCE;
        String r107 = String.format("iframe[src=\"%s\"", Arrays.copyOf(new Object[]{r103}, 1));
        if (r107 == null) goto L10;
        return String.format("javascript:(function(){   const iframe = document.querySelector(atob('%s'));   if (iframe && iframe.contentWindow) {        iframe.contentWindow.postMessage(%s, atob('%s'));   }})()", Arrays.copyOf(new Object[]{Base64.encodeToString(r107.getBytes(r104), 2), r102.toString(), r105}, 3));
    L10:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L12:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L13:
        JSONObject r108 = new JSONObject();
        r108.put("__msg_type", "callback");
        r108.put("__callback_id", r100.Q);
        r108.put("__params", r101);
        return "javascript:ToutiaoJSBridge._handleMessageFromToutiao(" + r108 + ')';
    }
}
