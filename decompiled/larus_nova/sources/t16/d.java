package t16;

import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f544158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, b> f544159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f544160c;

    public static final class a {
    }

    static {
    }

    public d(JSONObject r110) {
        this.f544160c = Boolean.valueOf(r110.optBoolean("predefineEnable"));
        JSONObject r111 = r110.optJSONObject("meta");
        if (r111 == null) goto L5;
        String r100 = r111.optString("publicPath");
    L6:
        this.f544158a = r100;
        if (r111 == null) goto L9;
        JSONArray r112 = r111.optJSONArray("externals");
    L11:
        if (r112 == null) goto L42;
        HashMap<String, b> r101 = new HashMap();
        int r102 = r112.length();     // Catch: Exception -> L40
        int r103 = 0;
    L14:
        if (r103 >= r102) goto L43;
        Object r104 = r112.get(r103);     // Catch: Exception -> L40
        if ((r104 instanceof JSONObject) == false) goto L18;
        JSONObject r105 = (JSONObject) r104;     // Catch: Exception -> L40
    L19:
        if (r105 == null) goto L21;
        r105.optString("name");     // Catch: Exception -> L40
    L21:
        if (r105 == null) goto L23;
        JSONObject r106 = r105.optJSONObject("requiredDependencies");     // Catch: Exception -> L40
    L25:
        if (r105 == null) goto L27;
        JSONObject r107 = r105.optJSONObject("filePath");     // Catch: Exception -> L40
    L28:
        c r108 = new c(r107);     // Catch: Exception -> L40
        if (r105 == null) goto L31;
        String r109 = r105.optString("matchRule");     // Catch: Exception -> L40
    L33:
        if (r105 == null) goto L35;
        JSONObject r113 = r105.optJSONObject("signature");     // Catch: Exception -> L40
    L36:
        b r114 = new b(r106, r108, new e(r113));     // Catch: Exception -> L40
        HybridLogger r115 = HybridLogger.f246343a;     // Catch: Exception -> L40
        HybridLogger.f("predefine", "convert success:" + r114, null, 12);     // Catch: Exception -> L40
        if (r109 == null) goto L39;
        r101.put(r109, r114);     // Catch: Exception -> L40
    L39:
        r103 = r103 + 1;
        goto L14
    L35:
        r113 = null;
        goto L36
    L31:
        r109 = null;
        goto L33
    L27:
        r107 = null;
        goto L28
    L23:
        r106 = null;
        goto L25
    L18:
        r105 = null;
    L43:
        this.f544159b = r101;
        HybridLogger.m("XPredefine", "metaModel init", null, null, 12);
        return;
    L40:
        e = move-exception;
        HybridLogger r116 = HybridLogger.f246343a;
        HybridLogger.i("XPredefine", "convert error:" + e.getMessage(), null, 12);
        goto L43
    L42:
        r101 = null;
        goto L43
    L9:
        r112 = null;
        goto L11
    L5:
        r100 = null;
        goto L6
    }
}
