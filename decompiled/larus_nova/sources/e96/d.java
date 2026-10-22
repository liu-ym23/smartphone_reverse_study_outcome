package e96;

import android.os.Build;
import com.bytedance.news.common.settings.api.SettingsData;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.sdk.open.douyin.settings.f;
import com.bytedance.ug.sdk.luckycat.base.network.CommonApi;
import com.bytedance.ug.sdk.luckycat.impl.manager.m;
import com.ss.android.common.applog.AppLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import jta.g;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class d implements h37.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f471509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c96.c f471510b;

    @Override // h37.b
    public final h37.c request() {
        int r100 = f96.a.f475971a;
        f96.a.d("settings", "SettingsRequestServiceImpl:startRequest", null);
        StringBuilder r101 = new StringBuilder("https://is.snssdk.com/service/settings/v3/");
        StringBuilder r102 = new StringBuilder("?aid=");
        boolean r103 = AppLog.L;
        r102.append(g.c());
        r101.append(r102.toString());
        r101.append("&iid=" + AppLog.r());
        r101.append("&device_id=" + AppLog.v());
        StringBuilder r104 = new StringBuilder("&channel=");
        c96.a r105 = this.f471510b.f22852a;
        if (r105 == null) goto L5;
        String r106 = r105.f22851d;
    L6:
        r104.append(r106);
        r101.append(r104.toString());
        r101.append("&device_platform=android&version_code=&caller_name=interaction_sdk");
        AppLog.f408004g0.G();
        r101.append("&ctx_infos=" + this.f471509a);
        r101.append("&os_version=" + Build.VERSION.SDK_INT);
        r101.append("&device_type=" + Build.MODEL);
        f96.a.d("settings", "SettingsRequestServiceImpl:startRequest:url = " + r101, null);
        if (this.f471510b.f22853b == null) goto L34;
        String r107 = r101.toString();
        LinkedHashMap r108 = new LinkedHashMap();
        r108.put("Content-Type", "application/json");
        r108.put(DBDefinition.MIME_TYPE, "application/json");
        Unit r109 = Unit.INSTANCE;
        LinkedHashMap r110 = new LinkedHashMap();
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("SettingsNetworkConfig", "SettingsNetworkConfig post, url = " + r107 + ", headers=" + r108 + ", body=" + r110);
        ArrayList r111 = new ArrayList(r108.size());
        Iterator r112 = r108.entrySet().iterator();
    L10:
        if (r112.hasNext() == false) goto L57;
        Map.Entry r113 = (Map.Entry) r112.next();
        r111.add(new Header((String) r113.getKey(), (String) r113.getValue()));
        goto L10
    L57:
        JSONObject r114 = new JSONObject(r110);     // Catch: Exception -> L32
        Iterator r115 = r111.iterator();     // Catch: Exception -> L32
    L14:
        if (r115.hasNext() == false) goto L18;
        Header r116 = (Header) r115.next();     // Catch: Exception -> L32
        if (StringsKt.equals(com.alipay.sdk.m.p.e.f25658f, r116.getName(), true) == false) goto L14;
        String r117 = r116.getValue();     // Catch: Exception -> L32
    L19:
        if (r117 != null) goto L21;
    L23:
        String r118 = r114.toString();     // Catch: Exception -> L32
        Charset r119 = Charset.forName("UTF-8");     // Catch: Exception -> L32
        if (r118 == null) goto L31;
        TypedOutput r120 = new TypedByteArray("application/json", r118.getBytes(r119), new String[0]);     // Catch: Exception -> L32
    L26:
        wi7.c.a();     // Catch: Exception -> L32
        SsResponse<String> r121 = wi7.c.b(((CommonApi) wi7.a.a(CommonApi.class)).getDataForPost(m.a.f271349a.b(r107), r120, r111), r107);     // Catch: Exception -> L32
        if (r121 == null) goto L29;
        c96.d r122 = new c96.d();     // Catch: Exception -> L32
        r122.f22856a = r121.body();     // Catch: Exception -> L32
        r122.f22857b = r121.code();     // Catch: Exception -> L32
    L35:
        h37.c r123 = new h37.c();
        r123.f483721a = false;
        int r124 = f96.a.f475971a;
        f96.a.d("settings", "SettingsRequestServiceImpl:res = " + r123, null);
        Result.Companion r125 = Result.Companion;     // Catch: Throwable -> L54
        if (r122 == null) goto L39;
        Integer r126 = Integer.valueOf(r122.f22857b);     // Catch: Throwable -> L54
    L40:
        if (r126 != null) goto L43;
        Intrinsics.throwNpe();     // Catch: Throwable -> L54
    L43:
        if (r126.intValue() >= 200) goto L45;
    L52:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L54
    L56:
        return r123;
    L45:
        if (r122 == null) goto L47;
        String r127 = r122.f22856a;     // Catch: Throwable -> L54
    L48:
        JSONObject r128 = new JSONObject(r127).optJSONObject("data");     // Catch: Throwable -> L54
        r123.f483722b = new SettingsData(r128.optJSONObject("settings"), null);     // Catch: Throwable -> L54
        JSONObject r129 = r128.optJSONObject(f.f269710g);     // Catch: Throwable -> L54
        r123.f483723c = r129;     // Catch: Throwable -> L54
        if (r129 == null) goto L51;
        com.bytedance.interaction.game.base.settings.model.c r130 = new com.bytedance.interaction.game.base.settings.model.c(r129);     // Catch: Throwable -> L54
        Map<Class<?>, Object> r131 = c.f471508a;     // Catch: Throwable -> L54
        c.a(com.bytedance.interaction.game.base.settings.model.c.class, r130);     // Catch: Throwable -> L54
    L51:
        String r132 = r128.optString("ctx_infos");     // Catch: Throwable -> L54
        r123.f483724d = r132;     // Catch: Throwable -> L54
        this.f471509a = r132;     // Catch: Throwable -> L54
        r123.f483721a = true;     // Catch: Throwable -> L54
        goto L52
    L47:
        r127 = null;
        goto L48
    L39:
        r126 = null;
    L54:
        th = move-exception;
        Result.Companion r133 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L56
    L29:
        r122 = new c96.d();     // Catch: Exception -> L32
        goto L35
    L31:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");     // Catch: Exception -> L32
    L21:
        if (StringsKt.startsWith(r117, "application/x-www-form-urlencoded", true) != true) goto L23;
        r120 = com.bytedance.ug.sdk.luckycat.impl.model.g.a(r114);     // Catch: Exception -> L32
        goto L26
    L18:
        r117 = "";
    L32:
        e = move-exception;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.b("SettingsNetworkConfig", "post Exception: " + e.getMessage());
        r122 = new c96.d();
        goto L35
    L34:
        r122 = null;
        goto L35
    L5:
        r106 = null;
        goto L6
    }

    public d(c96.c r100) {
        this.f471510b = r100;
        this.f471509a = "";
    }
}
