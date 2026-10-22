package nd7;

import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.sdk.xbridge.cn.auth.g;
import java.nio.charset.Charset;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class e extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f518805b;

    @Override // nd7.a
    public final JSONObject b() {
        g r100 = this.f518796a;
        if (r100 == null) goto L35;
        r100.a();
        JSONObject r101 = new JSONObject();
        g r102 = this.f518796a;     // Catch: JSONException -> L13
        if (r102 == null) goto L15;
        JSONObject r103 = new JSONObject();     // Catch: JSONException -> L13
        r103.put("aid", r102.g());     // Catch: JSONException -> L13
        r103.put("app_version", r102.e());     // Catch: JSONException -> L13
        r103.put("os", 0);     // Catch: JSONException -> L13
        r103.put("device_id", r102.i());     // Catch: JSONException -> L13
        JSONArray r104 = new JSONArray();     // Catch: JSONException -> L13
        JSONObject r105 = new JSONObject();     // Catch: JSONException -> L13
        r105.put("channel", "_jsb_auth");     // Catch: JSONException -> L13
        r105.put("local_version", 0);     // Catch: JSONException -> L13
        r104.put(r105);     // Catch: JSONException -> L13
        Iterator<String> r106 = r102.c().iterator();     // Catch: JSONException -> L13
    L9:
        if (r106.hasNext() == false) goto L11;
        String r107 = r106.next();     // Catch: JSONException -> L13
        JSONObject r110 = new JSONObject();     // Catch: JSONException -> L13
        r110.put("channel", "_jsb_auth." + r107);     // Catch: JSONException -> L13
        r110.put("local_version", 0);     // Catch: JSONException -> L13
        r104.put(r110);     // Catch: JSONException -> L13
        goto L9
    L11:
        JSONObject r108 = new JSONObject();     // Catch: JSONException -> L13
        r108.put(r102.d(), r104);     // Catch: JSONException -> L13
        r101.put("common", r103);     // Catch: JSONException -> L13
        r101.put("deployment", r108);     // Catch: JSONException -> L13
    L15:
        String r109 = r101.toString();
        g r111 = this.f518796a;
        if (r111 == null) goto L22;
        Charset r112 = Charsets.UTF_8;
        if (r109 == null) goto L21;
        String r113 = r111.h("https://jsb.snssdk.com/src/server/v2/package", r109.getBytes(r112));
    L23:
        if (r113 == null) goto L35;
        JSONObject r114 = new JSONObject(r113);     // Catch: Exception -> L30
        int r115 = r114.optInt("status");     // Catch: Exception -> L30
        if (r115 != 0) goto L27;
        JSONObject r116 = r114.optJSONObject("data");     // Catch: Exception -> L30
    L28:
        int r117 = com.bytedance.sdk.xbridge.cn.utils.a.f270258a;     // Catch: Exception -> L30
        d(r116);     // Catch: Exception -> L30
        return r114;
    L27:
        id7.c.a(this.f518805b + ": load failed, status=" + r115);     // Catch: Exception -> L30
        r116 = null;
    L30:
        e = move-exception;
        StringBuilder r118 = new StringBuilder();
        r118.append(this.f518805b);
        r118.append(": load failed, e=");
        String r119 = e.getMessage();
        if (r119 != null) goto L34;
        r119 = "unknown";
    L34:
        r118.append(r119);
        id7.c.a(r118.toString());
        e.printStackTrace();
        Unit r120 = Unit.INSTANCE;
        goto L35
    L21:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L22:
        r113 = null;
    L13:
        e = move-exception;
        e.printStackTrace();
    L35:
        return null;
    }

    public e() {
        this.f518805b = "RemotePermissionConfigLoader";
    }

    @Override // nd7.a
    public final String a() {
        return this.f518805b;
    }

    public final void d(JSONObject r100) {
        if (r100 == null) goto L34;
        g r101 = this.f518796a;
        Iterator<String> r102 = null;
        if (r101 == null) goto L8;
        com.ivy.ivykit.plugin.impl.jsb.auth.a r103 = r101.b();
        if (r103 == null) goto L8;
        int r104 = com.bytedance.sdk.xbridge.cn.utils.e.f270259a;
        Intrinsics.checkNotNullParameter(r103, "localStorage");
        Intrinsics.checkNotNullParameter("com.bytedance.sdk.xbridge.cn.protocol.permission.permission_config_response", "key");
        String r105 = r103.a();
    L10:
        if (com.bytedance.sdk.xbridge.cn.utils.e.a(r105) == true) goto L26;
        Intrinsics.checkNotNull(r105);
        JSONObject r106 = com.bytedance.sdk.xbridge.cn.utils.e.b(r105);
        JSONObject r107 = r106.optJSONObject("packages");
        if (r107 == null) goto L26;
        JSONObject r108 = r100.optJSONObject("packages");
        if (r108 == null) goto L18;
        r102 = r108.keys();
    L18:
        if (r102 == null) goto L22;
        boolean r109 = true;
        if (r102.hasNext() != true) goto L22;
    L23:
        if (r109 == false) goto L25;
        String r110 = r102.next();
        r107.put(r110, JSONObjectProtectorUtils.getJSONArray(r108, r110));
        goto L18
    L25:
        r100 = r106;
    L22:
        r109 = false;
    L26:
        int r111 = com.bytedance.sdk.xbridge.cn.utils.e.f270259a;
        g r112 = this.f518796a;
        if (r112 == null) goto L35;
        com.ivy.ivykit.plugin.impl.jsb.auth.a r113 = r112.b();
        if (r113 == null) goto L36;
        r113.b(r100.toString());
        return;
    L36:
        return;
    L35:
        return;
    L8:
        r105 = null;
        goto L10
    }
}
