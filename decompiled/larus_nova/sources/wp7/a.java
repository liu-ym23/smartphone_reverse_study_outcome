package wp7;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.dataplatform.o;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile a f560599f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f560600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f560601b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HashMap<String, Object> f560602c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<String, Object> f560603d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Context f560604e;

    public static a b() {
        if (f560599f != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f560599f != null) goto L9;
        f560599f = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f560599f;
    }

    public final HashMap<String, Object> d() {
        SharedPreferences r100 = this.f560600a;
        if (r100 != null) goto L6;
        return null;
    L6:
        if (r100.contains("vmsdk_settings") == true) goto L8;
        return null;
    L8:
        String r101 = this.f560600a.getString("vmsdk_settings", "");
        if (this.f560600a.contains("vmsdk_settings_time") == false) goto L11;
        this.f560601b = Integer.valueOf(this.f560600a.getInt("vmsdk_settings_time", 0));
    L19:
        Gson r102 = new Gson();     // Catch: Throwable -> L16
        JsonElement r103 = (JsonElement) r102.fromJson(r101, JsonElement.class);     // Catch: Throwable -> L16
        if (r103 == null) goto L18;
        return (HashMap) r102.fromJson(r103.getAsJsonObject(), HashMap.class);
    L18:
        return null;
    L16:
        th = move-exception;
        th.toString();
        goto L18
    L11:
        this.f560601b = 0;
        goto L19
    }

    public a() {
        this.f560600a = null;
        this.f560601b = 0;
        this.f560602c = null;
        this.f560603d = new HashMap();
        this.f560604e = null;
    }

    public final boolean a(String r110) {
        if (TextUtils.isEmpty(r110) == false) goto L5;
        return false;
    L5:
        Object r100 = null;
        r100 = this.f560603d.getOrDefault(r110, null);     // Catch: Throwable -> L16
        if (r100 != null) goto L19;
        Object r101 = o.d(r110, "".getClass(), "", false, true, null);     // Catch: Throwable -> L16
        if (r101 != null) goto L11;
        Intrinsics.throwNpe();     // Catch: Throwable -> L16
    L11:
        if (r101 != null) goto L13;
        r100 = "";
    L14:
        this.f560603d.put(r110, r100);     // Catch: Throwable -> L16
        goto L19
    L13:
        r100 = r101;
    L19:
        if (r100 != null) goto L21;
    L22:
        HashMap<String, Object> r102 = this.f560602c;
        if (r102 != null) goto L48;
        return false;
    L48:
        Map r103 = (Map) r102.get("vmsdk_common");     // Catch: Throwable -> L37
        if (r103 == null) goto L39;
        Object r111 = r103.get(r110);     // Catch: Throwable -> L37
        Objects.toString(r111);     // Catch: Throwable -> L37
        if (r111 == null) goto L39;
        if ("all".equalsIgnoreCase(r111.toString()) == false) goto L32;
    L35:
        Boolean r112 = Boolean.TRUE;     // Catch: Throwable -> L37
    L36:
        r100 = r112;
        goto L39
    L32:
        if ("true".equalsIgnoreCase(r111.toString()) == true) goto L35;
        r112 = Boolean.FALSE;     // Catch: Throwable -> L37
    L39:
        if (r100 != null) goto L41;
    L45:
        return false;
    L41:
        if (r100.equals("") == true) goto L45;
        return "true".equalsIgnoreCase(r100.toString());
    L37:
        th = move-exception;
        th.toString();
        goto L39
    L21:
        if (r100.equals("") == false) goto L39;
    L16:
        th = move-exception;
        th.toString();
        goto L19
    }

    public final void c(String r100, Integer r101, Context r102) {
        Gson r103 = new Gson();     // Catch: Throwable -> L7
        JsonElement r104 = (JsonElement) r103.fromJson(r100, JsonElement.class);     // Catch: Throwable -> L7
        if (r104 == null) goto L10;
        this.f560602c = (HashMap) r103.fromJson(r104.getAsJsonObject(), HashMap.class);     // Catch: Throwable -> L7
    L10:
        if (this.f560604e != null) goto L14;
        if (r102 == null) goto L14;
        this.f560604e = r102;
    L14:
        if (this.f560604e != null) goto L16;
        return;
    L16:
        monitor-enter(this);
        this.f560601b = r101;     // Catch: Throwable -> L27
        SharedPreferences r105 = this.f560600a;     // Catch: Throwable -> L27
        if (r105 != null) goto L24;
        Context r106 = this.f560604e;     // Catch: Throwable -> L27
        this.f560604e = r106;     // Catch: Throwable -> L27
        if (r105 != null) goto L23;
        r105 = r106.getSharedPreferences("vmsdk_settings_manager_sp", 0);     // Catch: Throwable -> L27
    L23:
        this.f560600a = r105;     // Catch: Throwable -> L27
    L24:
        this.f560600a.edit().putString("vmsdk_settings", r100).apply();     // Catch: Throwable -> L27
        this.f560600a.edit().putInt("vmsdk_settings_time", this.f560601b.intValue()).apply();     // Catch: Throwable -> L27
        monitor-exit(this);     // Catch: Throwable -> L27
        return;
    L27:
        th = move-exception;
        throw th;
    L7:
        th = move-exception;
        th.toString();
        goto L10
    }
}
