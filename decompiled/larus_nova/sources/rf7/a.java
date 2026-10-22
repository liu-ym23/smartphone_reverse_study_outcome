package rf7;

import com.bytedance.supervisor.runtime.common.Logger;
import com.bytedance.supervisor.token.Token;
import com.bytedance.supervisor.token.TokenConfig;
import com.bytedance.supervisor.wrapper.common.SensitiveAPIException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import mf7.c;
import nf7.d;
import of7.b;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class a {
    public static final void a(Token r110, b r111) throws SensitiveAPIException {
        Intrinsics.checkNotNullParameter(r110, "token");
        Intrinsics.checkNotNullParameter(r111, "psdaContext");
        if (nf7.a.a() == true) goto L6;
        Logger.c("beforeCall", "SensitiveApiSupervisor disable");
        d.a("beforeCall", "SensitiveApiSupervisor disable");
        return;
    L6:
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r111, "psdaContext");
        List<c> r100 = mf7.b.f513645a;
        Intrinsics.checkNotNullParameter(r110, "token");
        Intrinsics.checkNotNullParameter(r111, "psdaContext");
        int r101 = Logger.f270338a;
        Logger.c("CheckerManager", "doCheck, token: " + r110.getIdentifier() + ", psdaContext: " + r111);
        Iterator r102 = ((ArrayList) mf7.b.f513645a).iterator();
    L7:
        boolean r103 = false;
        if (r102.hasNext() == false) goto L12;
        of7.a r104 = ((c) r102.next()).a(r110, r111);
        if (r104.f523109b == 0) goto L7;
    L13:
        int r105 = Logger.f270338a;
        Logger.c("beforeCall", "token: " + r110.getIdentifier() + ", psdaContext: " + r111 + ", checkResult: " + r104);
        int r112 = nf7.a.f518959a;
        lf7.b r113 = lf7.d.f509087a;
        if (r113 != null) goto L16;
        boolean r114 = false;
    L18:
        if (r114 == true) goto L35;
        int r115 = nf7.b.f518960a;
        Intrinsics.checkNotNullParameter(r104, "checkResult");
        JSONObject r116 = new JSONObject();
        r116.put("token_id", r104.f523108a.getIdentifier());
        if (r104.f523109b != 3) goto L22;
        int r117 = 1;
    L23:
        r116.put("status", r117);
        r116.put("method_name", null);
        r116.put("sdk_name", null);
        JSONObject r118 = new JSONObject();
        r118.put("error_type", r104.f523109b);
        r118.put("strategy_rule_id", r104.f523110c);
        ConcurrentHashMap<String, TokenConfig> r119 = com.bytedance.supervisor.runtime.config.b.f270342b;
        r118.put("remote_info", com.bytedance.supervisor.runtime.config.b.c(r104.f523108a));
        r118.put("local_info", r111.f523111a);
        lf7.b r120 = lf7.d.f509087a;
        if (r120 == null) goto L27;
        r103 = r120.f509073g;
    L27:
        r118.put("is_boe", r103);
        r116.put("reason", r118);
        lf7.b r106 = lf7.d.f509087a;
        if (r106 != null) goto L30;
        kf7.a r107 = null;
    L31:
        if (r107 == null) goto L35;
        r107.a(r116);
        goto L35
    L30:
        r107 = r106.f509069c;
        goto L31
    L22:
        r117 = 0;
    L35:
        if (r104.f523109b == 0) goto L83;
        int r121 = d.f518962a;
        Intrinsics.checkNotNullParameter(r104, "checkResult");
        Intrinsics.checkNotNullParameter(r111, "psdaContext");
        int r122 = r104.f523109b;
        if (r122 == 1) goto L70;
        if (r122 == 2) goto L89;
        if (r122 != 3) goto L83;
        ConcurrentHashMap<String, TokenConfig> r123 = com.bytedance.supervisor.runtime.config.b.f270342b;
        JSONObject r124 = new JSONObject();     // Catch: JSONException -> L51
        r124.put("scene", "token_disable");     // Catch: JSONException -> L51
        r124.put("token", r104.f523108a.getIdentifier());     // Catch: JSONException -> L51
        r124.put("token_source", com.bytedance.supervisor.runtime.config.b.f270343c);     // Catch: JSONException -> L51
        lf7.b r125 = lf7.d.f509087a;     // Catch: JSONException -> L51
        if (r125 != null) goto L46;
        kf7.c r126 = null;
    L47:
        if (r126 == null) goto L83;
        r126.a("scs_psda_error_monitor", r124, null);     // Catch: JSONException -> L51
        goto L83
    L46:
        r126 = r125.f509070d;     // Catch: JSONException -> L51
    L51:
        e = move-exception;
        int r127 = Logger.f270338a;
        Logger.b("MonitorUtil", Intrinsics.stringPlus("monitorTokenDisable，JSONException: ", e.getMessage()));
        goto L83
    L89:
        JSONObject r128 = new JSONObject();     // Catch: JSONException -> L67
        r128.put("scene", "token_atomicInfo_not_match");     // Catch: JSONException -> L67
        r128.put("token", r104.f523108a.getIdentifier());     // Catch: JSONException -> L67
        r128.put("local_info", r111.f523111a);     // Catch: JSONException -> L67
        ConcurrentHashMap<String, TokenConfig> r108 = com.bytedance.supervisor.runtime.config.b.f270342b;     // Catch: JSONException -> L67
        r128.put("remote_info", com.bytedance.supervisor.runtime.config.b.c(r104.f523108a));     // Catch: JSONException -> L67
        if (r111.f523111a.isEmpty() == false) goto L59;
        Object[] r129 = r111.f523112b;     // Catch: JSONException -> L67
        if (r129 == null) goto L59;
        r128.put("local_apiparams", new JSONArray(r129));     // Catch: JSONException -> L67
    L59:
        r128.put("token_source", com.bytedance.supervisor.runtime.config.b.f270343c);     // Catch: JSONException -> L67
        lf7.b r130 = lf7.d.f509087a;     // Catch: JSONException -> L67
        if (r130 != null) goto L62;
        kf7.c r131 = null;
    L63:
        if (r131 == null) goto L83;
        r131.a("scs_psda_error_monitor", r128, null);     // Catch: JSONException -> L67
        goto L83
    L62:
        r131 = r130.f509070d;     // Catch: JSONException -> L67
    L67:
        e = move-exception;
        int r132 = Logger.f270338a;
        Logger.b("MonitorUtil", Intrinsics.stringPlus("monitorTokenNotMatch，JSONException: ", e.getMessage()));
        goto L83
    L70:
        if (com.bytedance.supervisor.runtime.config.b.f270342b.isEmpty() == true) goto L83;
        JSONObject r133 = new JSONObject();     // Catch: JSONException -> L80
        r133.put("scene", "token_not_exist");     // Catch: JSONException -> L80
        r133.put("token", r104.f523108a.getIdentifier());     // Catch: JSONException -> L80
        r133.put("token_source", com.bytedance.supervisor.runtime.config.b.f270343c);     // Catch: JSONException -> L80
        lf7.b r134 = lf7.d.f509087a;     // Catch: JSONException -> L80
        if (r134 != null) goto L75;
        kf7.c r135 = null;
    L76:
        if (r135 == null) goto L83;
        r135.a("scs_psda_error_monitor", r133, null);     // Catch: JSONException -> L80
        goto L83
    L75:
        r135 = r134.f509070d;     // Catch: JSONException -> L80
    L80:
        e = move-exception;
        int r136 = Logger.f270338a;
        Logger.b("MonitorUtil", Intrinsics.stringPlus("monitorTokenNotExit，JSONException: ", e.getMessage()));
    L83:
        if (r104.f523109b == 3) goto L86;
        return;
    L86:
        throw new SensitiveAPIException(1003, "Token is intercepted by config");
    L16:
        r114 = r113.f509076j;
        goto L18
    L12:
        r104 = new of7.a(r110, 0);
        goto L13
    }
}
