package com.bytedance.ies.bullet.web.pia;

import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.kit.bridge.IBridge3Registry;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class i implements d47.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BulletContext f248320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, l47.a<JSONObject>> f248321b;

    public static final class a {
    }

    static {
    }

    public i() {
        this.f248321b = new ConcurrentHashMap();
    }

    public final void b(String r100) {
        if (StringsKt.contains$default(r100, "._handleMessageFromToutiao(", false, 2, null) == true) goto L5;
        return;
    L5:
        if (StringsKt.contains$default(r100, "__pia_jsb2_glue__", false, 2, null) == false) goto L25;
        JSONObject r101 = new JSONObject(StringsKt.substringBeforeLast$default(StringsKt.substringAfter$default(r100, "._handleMessageFromToutiao(", null, 2, null), ")", null, 2, null));     // Catch: JSONException -> L20
        String r102 = JSONObjectProtectorUtils.getString(r101, "__callback_id");     // Catch: JSONException -> L20
        if (r102 != null) goto L10;
        return;
    L10:
        JSONObject r103 = r101.optJSONObject("__params");     // Catch: JSONException -> L20
        if (r103 != null) goto L13;
        r103 = new JSONObject();     // Catch: JSONException -> L20
        r103.put("code", -4);     // Catch: JSONException -> L20
        r103.put("msg", "[GLUE] invalid result format!");     // Catch: JSONException -> L20
    L16:
        l47.a<JSONObject> r104 = this.f248321b.remove(r102);     // Catch: JSONException -> L20
        if (r104 == null) goto L24;
        r104.accept(r103);     // Catch: JSONException -> L20
        return;
    L24:
        return;
    L13:
        if (r103.has("__data") == false) goto L16;
        r103.put("data", r103.get("__data"));     // Catch: JSONException -> L20
    L26:
        return;
    }

    @Override // d47.b
    public final void a(String r100, JSONObject r101, com.bytedance.pia.core.plugins.a r102) {
        if (r100 == null) goto L10;
        if (r101 == null) goto L10;
        this.f248321b.put("__pia_jsb2_glue__" + r101.optString("__callback_id"), r102);     // Catch: JSONException -> L12
        BulletContext r103 = this.f248320a;     // Catch: JSONException -> L12
        if (r103 == null) goto L13;
        IBridge3Registry r104 = r103.f246448p;     // Catch: JSONException -> L12
        if (r104 == null) goto L13;
        r104.handle(r100, r101, new j());     // Catch: JSONException -> L12
    L13:
        return;
    L10:
        JSONObject r105 = new JSONObject();     // Catch: JSONException -> L12
        r105.put("code", -3);     // Catch: JSONException -> L12
        r102.accept(r105);     // Catch: JSONException -> L12
    }
}
