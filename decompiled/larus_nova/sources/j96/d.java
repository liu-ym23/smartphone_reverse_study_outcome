package j96;

import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f497795c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f497796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, b> f497797b;

    public static final class a {
        public static JSONObject a(String r100) {
            JSONObject r101 = new JSONObject(r100);     // Catch: JSONException -> L5
            int r102 = f96.a.f475971a;     // Catch: JSONException -> L5
            f96.a.d("interactive_predefine", "meta json init success", null);     // Catch: JSONException -> L5
            return r101;
        L5:
            e = move-exception;
            int r103 = f96.a.f475971a;
            f96.a.a("interactive_predefine", "meta json init failed:" + e.getMessage(), null);
            return null;
        }
    }

    static {
    }

    public d(JSONObject r110) {
        this.f497796a = r110.optString("publicPath");
        JSONArray r111 = r110.optJSONArray("externals");
        if (r111 == null) goto L34;
        HashMap<String, b> r100 = new HashMap();
        int r101 = r111.length();     // Catch: Exception -> L32
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L35;
        Object r103 = r111.get(r102);     // Catch: Exception -> L32
        if ((r103 instanceof JSONObject) == true) goto L10;
        r103 = null;
    L10:
        JSONObject r104 = (JSONObject) r103;     // Catch: Exception -> L32
        if (r104 == null) goto L13;
        r104.optString("name");     // Catch: Exception -> L32
    L13:
        if (r104 == null) goto L15;
        JSONObject r105 = r104.optJSONObject("requiredDependencies");     // Catch: Exception -> L32
    L17:
        if (r104 == null) goto L19;
        JSONObject r106 = r104.optJSONObject("filePath");     // Catch: Exception -> L32
    L20:
        c r107 = new c(r106);     // Catch: Exception -> L32
        if (r104 == null) goto L23;
        String r108 = r104.optString("matchRule");     // Catch: Exception -> L32
    L25:
        if (r104 == null) goto L27;
        JSONObject r109 = r104.optJSONObject("signature");     // Catch: Exception -> L32
    L28:
        b r112 = new b(r105, r107, new e(r109));     // Catch: Exception -> L32
        int r113 = f96.a.f475971a;     // Catch: Exception -> L32
        f96.a.d("interactive_predefine", "convert success:" + r112, null);     // Catch: Exception -> L32
        if (r108 == null) goto L31;
        r100.put(r108, r112);     // Catch: Exception -> L32
    L31:
        r102 = r102 + 1;
        goto L6
    L27:
        r109 = null;
        goto L28
    L23:
        r108 = null;
        goto L25
    L19:
        r106 = null;
        goto L20
    L15:
        r105 = null;
    L35:
        this.f497797b = r100;
        int r114 = f96.a.f475971a;
        f96.a.d("interactive_predefine", "metaModel init", null);
        return;
    L32:
        e = move-exception;
        int r115 = f96.a.f475971a;
        f96.a.a("interactive_predefine", "convert error:" + e.getMessage(), null);
        goto L35
    L34:
        r100 = null;
        goto L35
    }
}
