package nw3;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.bdinstall.y;
import com.bytedance.bdinstall.z;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import nx3.k;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements z {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final List<String> f520974e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.applog.b f520975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile SharedPreferences f520976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile JSONObject f520977c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final y f520978d;

    static {
        f520974e = Collections.singletonList("CustomHeaderAdapter");
    }

    public final JSONObject b() {
        if (this.f520977c != null) goto L14;
        SharedPreferences r100 = c();     // Catch: Throwable -> L11
        if (r100 == null) goto L15;
        String r101 = r100.getString("header_custom_info", null);     // Catch: Throwable -> L11
        if (k.h(r101) == false) goto L9;
        this.f520977c = new JSONObject(r101);     // Catch: Throwable -> L11
        goto L15
    L9:
        this.f520977c = new JSONObject();     // Catch: Throwable -> L11
    L15:
    L11:
        th = move-exception;
        this.f520975a.f192434t0.s(f520974e, "getCustomInfo failed", th, new Object[0]);
    L14:
        return this.f520977c;
    }

    public final SharedPreferences c() {
        if (this.f520976b != null) goto L8;
        if (this.f520975a.getContext() == null) goto L8;
        this.f520976b = this.f520975a.getContext().getSharedPreferences(com.bytedance.applog.a.b(this.f520975a, "header_custom"), 0);
    L8:
        return this.f520976b;
    }

    public final void a(Map<String, Object> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isEmpty() == false) goto L37;
        return;
    L37:
        JSONObject r101 = b();     // Catch: Throwable -> L34
        boolean r102 = true;
        if (r101 == null) goto L20;
        Iterator<Map.Entry<String, Object>> r103 = r100.entrySet().iterator();     // Catch: Throwable -> L34
    L12:
        if (r103.hasNext() == false) goto L19;
        Map.Entry<String, Object> r104 = r103.next();     // Catch: Throwable -> L34
        if (k.g(r104.getKey()) == true) goto L12;
        if ((!Objects.equals(r101.opt(r104.getKey()), r104.getValue())) == false) goto L12;
    L19:
        r102 = false;
    L20:
        if (r102 == true) goto L23;
        this.f520975a.f192434t0.k(0, f520974e, "appendHeaderInfo no value changed", new Object[0]);     // Catch: Throwable -> L34
        return;
    L23:
        JSONObject r105 = new JSONObject();     // Catch: Throwable -> L34
        if (r101 == null) goto L26;
        k.d(r105, r101);     // Catch: Throwable -> L34
    L26:
        Iterator<Map.Entry<String, Object>> r106 = r100.entrySet().iterator();     // Catch: Throwable -> L34
    L28:
        if (r106.hasNext() == false) goto L32;
        Map.Entry<String, Object> r107 = r106.next();     // Catch: Throwable -> L34
        if (k.h(r107.getKey()) == false) goto L28;
        r105.put(r107.getKey(), r107.getValue());     // Catch: Throwable -> L34
        goto L28
    L32:
        d(r105);     // Catch: Throwable -> L34
        return;
    L34:
        th = move-exception;
        this.f520975a.f192434t0.s(f520974e, "appendHeaderInfo failed", th, new Object[0]);
    }

    public final void d(JSONObject r100) {
        this.f520977c = r100;
        SharedPreferences r101 = c();
        if (r101 == null) goto L5;
        r101.edit().putString("header_custom_info", r100.toString()).apply();
    L5:
        y r102 = this.f520978d;
        Context r103 = this.f520975a.getContext();
        com.bytedance.bdinstall.k r104 = (com.bytedance.bdinstall.k) r102;
        r104.getClass();
        HashMap r105 = new HashMap();
        r105.put("custom", r100);
        r104.f199681h.b(new Object[]{r103}).c(r105);
    }

    public g(com.bytedance.applog.b r100, y r101) {
        this.f520975a = r100;
        this.f520978d = r101;
    }
}
