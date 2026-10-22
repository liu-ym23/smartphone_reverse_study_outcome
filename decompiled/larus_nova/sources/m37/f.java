package m37;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.mira.conig.Constants;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.news.common.settings.SettingsConfigProvider;
import com.bytedance.news.common.settings.api.SettingsData;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.larus.settings.SettingsConfigProviderImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile f f511769g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f511770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, SettingsData> f511771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SettingsData f511772c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SharedPreferences f511773d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public JSONObject f511774e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Context f511775f;

    public final synchronized k37.a c() {
        monitor-enter(this);
    L39:
        th = move-exception;
        throw th;
    L4:
        if (this.f511773d != null) goto L6;
        this.f511773d = this.f511775f.getSharedPreferences("diff_settings.sp", 0);     // Catch: Throwable -> L39
    L6:
        CopyOnWriteArrayList r100 = new CopyOnWriteArrayList();     // Catch: Throwable -> L39
        CopyOnWriteArrayList r101 = new CopyOnWriteArrayList();     // Catch: Throwable -> L39
        CopyOnWriteArrayList r102 = new CopyOnWriteArrayList();     // Catch: Throwable -> L39
        Iterator<Map.Entry<String, ?>> r103 = this.f511773d.getAll().entrySet().iterator();     // Catch: Throwable -> L39
    L8:
        if (r103.hasNext() == false) goto L36;
        Map.Entry<String, ?> r104 = r103.next();     // Catch: Throwable -> L39
        String r105 = r104.getKey();     // Catch: Throwable -> L39
        if (TextUtils.isEmpty(r105) == true) goto L8;
        if (r105.contains("key_local_app_settings_data") == true) goto L14;
        if (r105.contains("key_diff_app_settings_timestamp") == true) goto L22;
        if (r105.contains("key_local_settings_dff_last") == false) goto L8;
        String r106 = String.valueOf(r104.getValue());     // Catch: Throwable -> L39
        if (TextUtils.isEmpty(r106) == true) goto L8;
        r101.add(new JSONObject(r106));     // Catch: JSONException -> L34 Throwable -> L39
    L34:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L39
        goto L8
    L22:
        String r107 = String.valueOf(r104.getValue());     // Catch: Throwable -> L39
        if (TextUtils.isEmpty(r107) == true) goto L8;
        r102.add(new JSONObject(r107));     // Catch: JSONException -> L26 Throwable -> L39
    L26:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L39
        goto L8
    L14:
        String r108 = String.valueOf(r104.getValue());     // Catch: Throwable -> L39
        if (TextUtils.isEmpty(r108) == true) goto L8;
        r100.add(new JSONObject(r108));     // Catch: JSONException -> L18 Throwable -> L39
    L18:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L39
        goto L8
    L36:
        k37.a r109 = new k37.a(r100, r102, r101);     // Catch: Throwable -> L39
        monitor-exit(this);
        return r109;
    }

    public f(Context r100) {
        this.f511771b = new HashMap();
        SharedPreferences r101 = null;
        this.f511772c = new SettingsData(null, null, "", false);
        this.f511775f = r100;
        SettingsConfigProvider r102 = (SettingsConfigProvider) ServiceManager.getService(SettingsConfigProvider.class);
        if (r102 == null) goto L11;
        if (r102.getConfig() == null) goto L11;
        h37.e r103 = r102.getConfig().f479840c.f479857f;
        if (r103 == null) goto L9;
        r101 = r103.a("__local_settings_data.sp", 0);
    L9:
        this.f511770a = r101;
    L11:
        if (this.f511770a != null) goto L14;
        this.f511770a = r100.getSharedPreferences("__local_settings_data.sp", 0);
        return;
    }

    public static f b(Context r100) {
        if (f511769g != null) goto L15;
        monitor-enter(f.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f511769g != null) goto L9;
        f511769g = new f(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(f.class);     // Catch: Throwable -> L11
    L15:
        return f511769g;
    }

    public final synchronized SettingsData d(String r100) {
        monitor-enter(this);
        SettingsData r101 = this.f511771b.get(r100);     // Catch: Throwable -> L24
        if (r101 != null) goto L6;
        String r102 = this.f511770a.getString(a("key_local_app_settings_data", r100), "");     // Catch: Throwable -> L24
        if (TextUtils.isEmpty(r102) == false) goto L28;
    L21:
        this.f511771b.put(r100, this.f511772c);     // Catch: Throwable -> L24
        monitor-exit(this);
        return null;
    L28:
        JSONObject r103 = new JSONObject(r102);     // Catch: JSONException -> L19 Throwable -> L24
        String r104 = this.f511770a.getString(a("key_local_user_settings_data", r100), "");     // Catch: JSONException -> L19 Throwable -> L24
        if (TextUtils.isEmpty(r104) == true) goto L15;
        JSONObject r105 = new JSONObject(r104);     // Catch: JSONException -> L19 Throwable -> L24
    L16:
        SettingsData r106 = new SettingsData(r103, r105, this.f511770a.getString(a("key_last_update_token", r100), ""), false);     // Catch: JSONException -> L19 Throwable -> L24
        this.f511771b.put(r100, r106);     // Catch: JSONException -> L19 Throwable -> L24
        monitor-exit(this);
        return r106;
    L15:
        r105 = new JSONObject();     // Catch: JSONException -> L19 Throwable -> L24
    L19:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L24
        goto L21
    L6:
        if (r101 != this.f511772c) goto L8;
        r101 = null;
    L8:
        monitor-exit(this);
        return r101;
    L24:
        th = move-exception;
        throw th;
    }

    public static String a(String r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L6;
        return r100;
    L6:
        return r100 + "_" + r101;
    }

    public final void e(g37.d r110, boolean r210) {
        Context r100 = this.f511775f;
        if (r100 != null) goto L6;
        return;
    L6:
        if (this.f511773d != null) goto L8;
        this.f511773d = r100.getSharedPreferences("diff_settings.sp", 0);
    L8:
        SharedPreferences.Editor r101 = this.f511773d.edit();
        if (r210 == false) goto L17;
        String r102 = this.f511773d.getString(a("key_local_app_settings_data", r110.f479840c.f479852a), "");     // Catch: Exception -> L14
        if (TextUtils.isEmpty(r102) == true) goto L17;
        r101.putString(a("key_local_settings_dff_last", r110.f479840c.f479852a), r102);     // Catch: Exception -> L14
    L14:
        e = move-exception;
        e.printStackTrace();
    L17:
        if (this.f511774e != null) goto L62;
        r101.apply();
        return;
    L62:
        String r103 = this.f511773d.getString(a("key_diff_app_settings_timestamp", r110.f479840c.f479852a), "");     // Catch: Exception -> L45
        JSONObject r104 = new JSONObject();     // Catch: Exception -> L45
    L43:
        e = e;
        JSONObject r105 = null;
    L47:
        e.printStackTrace();
    L48:
        if (r104 != null) goto L60;
    L53:
        if (r105 != null) goto L69;
    L58:
        r101.apply();
        r110.f479840c.getClass();
        r110.a();
        this.f511774e = null;
        return;
    L69:
        r101.putString(a("key_diff_app_settings_timestamp", r110.f479840c.f479852a), r105.toString());     // Catch: Exception -> L56
    L56:
        e = move-exception;
        e.printStackTrace();
        goto L58
    L60:
        r104.put("settings_sdk_timestamp", System.currentTimeMillis());     // Catch: Exception -> L51
        r101.putString(a("key_local_app_settings_data", r110.f479840c.f479852a), r104.toString());     // Catch: Exception -> L51
    L51:
        e = move-exception;
        e.printStackTrace();
        goto L53
    L23:
        if (TextUtils.isEmpty(r103) == true) goto L25;
        r105 = new JSONObject(r103);     // Catch: Exception -> L43
    L67:
        Iterator<String> r106 = this.f511774e.keys();     // Catch: Exception -> L41
        long r107 = System.currentTimeMillis();     // Catch: Exception -> L41
    L28:
        if (r106.hasNext() == false) goto L30;
        String r111 = r106.next();     // Catch: Exception -> L41
        r104.put(r111, this.f511774e.opt(r111));     // Catch: Exception -> L41
        r105.put(r111, r107);     // Catch: Exception -> L41
        goto L28
    L30:
        Iterator<String> r108 = r105.keys();     // Catch: Exception -> L41
        ArrayList r112 = new ArrayList();     // Catch: Exception -> L41
    L32:
        if (r108.hasNext() == false) goto L36;
        String r113 = r108.next();     // Catch: Exception -> L41
        if ((r107 - r105.optLong(r113, r107)) <= Constants.DOWNLOAD_TEMP_FILE_PAST_TIME) goto L32;
        r112.add(r113);     // Catch: Exception -> L41
        goto L32
    L36:
        Iterator r109 = r112.iterator();     // Catch: Exception -> L41
    L37:
        if (r109.hasNext() == false) goto L48;
        r105.remove((String) r109.next());     // Catch: Exception -> L41
    L41:
        e = e;
        goto L47
    L25:
        r105 = new JSONObject();     // Catch: Exception -> L43
    L45:
        e = e;
        r104 = null;
        r105 = null;
        goto L47
    }

    public final synchronized void h(JSONObject r100, String r101) {
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L4:
        if (j37.a.f497127p == null) goto L20;
        ((ft9.c) j37.a.f497127p).getClass();     // Catch: Throwable -> L22
        if (SettingsConfigProviderImpl.a().booleanValue() == false) goto L20;
        String r102 = r100.keys().next();     // Catch: Throwable -> L22
        SettingsData r103 = d(r101);     // Catch: Throwable -> L22
        if (r103 == null) goto L20;
        JSONObject r104 = r103.getAppSettings();     // Catch: Throwable -> L22
        r104.put(r102, r100.opt(r102));     // Catch: JSONException -> L12 Throwable -> L22
    L14:
        this.f511771b.put(r101, r103);     // Catch: Throwable -> L22
        SharedPreferences.Editor r105 = this.f511770a.edit();     // Catch: Throwable -> L22
        r105.putString(a("key_local_app_settings_data", r101), r104.toString());     // Catch: Exception -> L17 Throwable -> L22
    L19:
        r105.apply();     // Catch: Throwable -> L22
        goto L20
    L17:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L22
        goto L19
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L22
    L20:
        monitor-exit(this);
    }

    public final synchronized void f(SettingsData r110, g37.d r111, boolean r112) {
        monitor-enter(this);
        JSONObject r100 = r110.getAppSettings();     // Catch: Throwable -> L104
        JSONObject r101 = r110.getUserSettings();     // Catch: Throwable -> L104
        SettingsData r102 = d(r111.f479840c.f479852a);     // Catch: Throwable -> L104
        if (r102 == null) goto L80;
        JSONObject r103 = r102.getAppSettings();     // Catch: Throwable -> L104
        JSONObject r104 = r102.getUserSettings();     // Catch: Throwable -> L104
        if (r103 != null) goto L8;
        r103 = new JSONObject();     // Catch: Throwable -> L104
    L8:
        if (r104 != null) goto L10;
        r104 = new JSONObject();     // Catch: Throwable -> L104
    L10:
        if (r100 == null) goto L34;
        Iterator<String> r105 = r100.keys();     // Catch: Throwable -> L104
    L13:
        if (r105.hasNext() == false) goto L34;
        String r106 = r105.next();     // Catch: Throwable -> L104
        Object r107 = r100.opt(r106);     // Catch: Exception -> L32 Throwable -> L104
        Object r108 = r103.opt(r106);     // Catch: Exception -> L32 Throwable -> L104
        String r109 = String.valueOf(r107);     // Catch: Exception -> L32 Throwable -> L104
        String r113 = String.valueOf(r108);     // Catch: Exception -> L32 Throwable -> L104
    L16:
        if ((r107 instanceof JSONObject) == false) goto L29;
        if ((r108 instanceof JSONObject) == false) goto L29;
        JsonObject r114 = (JsonObject) new JsonParser().parse(r109);     // Catch: Exception -> L25 Throwable -> L104
        JsonObject r115 = (JsonObject) new JsonParser().parse(r113);     // Catch: Exception -> L25 Throwable -> L104
        if (r114 == null) goto L13;
        if (r114.equals(r115) == true) goto L13;
        g(r103, r106, r107);     // Catch: Exception -> L25 Throwable -> L104
    L26:
        if (TextUtils.equals(r109, r113) == true) goto L13;
        g(r103, r106, r107);     // Catch: Exception -> L32 Throwable -> L104
    L29:
        if (TextUtils.equals(r109, r113) == true) goto L13;
        g(r103, r106, r107);     // Catch: Exception -> L32 Throwable -> L104
    L32:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L104
    L34:
        if (r101 == null) goto L58;
        Iterator<String> r116 = r101.keys();     // Catch: Throwable -> L104
    L37:
        if (r116.hasNext() == false) goto L58;
        String r117 = r116.next();     // Catch: Throwable -> L104
        Object r118 = r101.opt(r117);     // Catch: Exception -> L56 Throwable -> L104
        Object r119 = r104.opt(r117);     // Catch: Exception -> L56 Throwable -> L104
        String r120 = String.valueOf(r118);     // Catch: Exception -> L56 Throwable -> L104
        String r121 = String.valueOf(r119);     // Catch: Exception -> L56 Throwable -> L104
    L40:
        if ((r118 instanceof JSONObject) == false) goto L53;
        if ((r119 instanceof JSONObject) == false) goto L53;
        JsonObject r122 = (JsonObject) new JsonParser().parse(r120);     // Catch: Exception -> L49 Throwable -> L104
        JsonObject r123 = (JsonObject) new JsonParser().parse(r121);     // Catch: Exception -> L49 Throwable -> L104
        if (r122 == null) goto L37;
        if (r122.equals(r123) == true) goto L37;
        g(r104, r117, r118);     // Catch: Exception -> L49 Throwable -> L104
    L50:
        if (TextUtils.equals(r120, r121) == true) goto L37;
        g(r104, r117, r118);     // Catch: Exception -> L56 Throwable -> L104
    L53:
        if (TextUtils.equals(r120, r121) == true) goto L37;
        g(r104, r117, r118);     // Catch: Exception -> L56 Throwable -> L104
    L56:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L104
    L58:
        this.f511771b.put(r111.f479840c.f479852a, r102);     // Catch: Throwable -> L104
        SharedPreferences.Editor r124 = this.f511770a.edit();     // Catch: Throwable -> L104
        r124.putString(a("key_last_update_token", r111.f479840c.f479852a), r110.getToken());     // Catch: Exception -> L61 Throwable -> L104
    L107:
        String r125 = a("key_local_app_settings_data", r111.f479840c.f479852a);     // Catch: Exception -> L69 Throwable -> L104
        if (r100 == null) goto L66;
        String r126 = r103.toString();     // Catch: Exception -> L69 Throwable -> L104
    L67:
        r124.putString(r125, r126);     // Catch: Exception -> L69 Throwable -> L104
    L114:
        String r127 = a("key_local_user_settings_data", r111.f479840c.f479852a);     // Catch: Exception -> L77 Throwable -> L104
        if (r101 == null) goto L74;
        String r128 = r104.toString();     // Catch: Exception -> L77 Throwable -> L104
    L75:
        r124.putString(r127, r128);     // Catch: Exception -> L77 Throwable -> L104
    L79:
        r124.apply();     // Catch: Throwable -> L104
        e(r111, r112);     // Catch: Throwable -> L104
    L102:
        monitor-exit(this);
        return;
    L74:
        r128 = "";
    L77:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L104
        goto L79
    L66:
        r126 = "";
    L69:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L104
        goto L114
    L61:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L104
        goto L107
    L80:
        this.f511771b.put(r111.f479840c.f479852a, r110);     // Catch: Throwable -> L104
        SharedPreferences.Editor r129 = this.f511770a.edit();     // Catch: Throwable -> L104
        r129.putString(a("key_last_update_token", r111.f479840c.f479852a), r110.getToken());     // Catch: Exception -> L83 Throwable -> L104
    L126:
        String r130 = a("key_local_app_settings_data", r111.f479840c.f479852a);     // Catch: Exception -> L91 Throwable -> L104
        if (r100 == null) goto L88;
        String r131 = r100.toString();     // Catch: Exception -> L91 Throwable -> L104
    L89:
        r129.putString(r130, r131);     // Catch: Exception -> L91 Throwable -> L104
    L111:
        String r132 = a("key_local_user_settings_data", r111.f479840c.f479852a);     // Catch: Exception -> L99 Throwable -> L104
        if (r101 == null) goto L96;
        String r133 = r101.toString();     // Catch: Exception -> L99 Throwable -> L104
    L97:
        r129.putString(r132, r133);     // Catch: Exception -> L99 Throwable -> L104
    L101:
        r129.apply();     // Catch: Throwable -> L104
        goto L102
    L96:
        r133 = "";
    L99:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L104
        goto L101
    L88:
        r131 = "";
    L91:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L104
    L83:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L104
    L104:
        th = move-exception;
        throw th;
    }

    public final void g(JSONObject r100, String r101, Object r102) throws JSONException {
        if (this.f511774e != null) goto L5;
        this.f511774e = new JSONObject();
    L5:
        this.f511774e.put(r101, r102);
        r100.put(r101, r102);
    }
}
