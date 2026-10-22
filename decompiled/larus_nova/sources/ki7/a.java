package ki7;

import android.app.Application;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import ci7.l;
import ci7.p;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.bytedance.ug.sdk.deeplink.IZlinkDepend;
import com.bytedance.ug.sdk.deeplink.ZlinkDependAbility;
import com.ttnet.org.chromium.base.TimeUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f503640a = null;

    static {
        f503640a = new AtomicBoolean(false);
    }

    public static void a(String r210) {
        long r100 = System.currentTimeMillis();
        ZlinkDependAbility r101 = p.f23879a;
        JSONObject r102 = null;
        if (r101 != null) goto L5;
        String r103 = null;
    L6:
        if (r103 == null) goto L8;
        String r104 = r103.concat("service/settings/v3/");
    L9:
        Uri.Builder r105 = UriProtector.parse(r104).buildUpon();
        r105.appendQueryParameter(Constant.KEY_CALL_NAME, "zlink");
        IZlinkDepend r106 = p.a();
        if (r106 != null) goto L12;
    L14:
        r105.appendQueryParameter("device_platform", "android");
        r105.appendQueryParameter("zlink_sdk_version", "1.2.5-alpha.0");
        Application r107 = l.a();
        List<WeakReference<b>> r108 = c.f503641a;
        r105.appendQueryParameter("settings_time", Long.toString(d.b(r107).optLong("settings_time", 0)));
        String r109 = mi7.f.c(r105.toString(), new HashMap(), new byte[0], 0, null);
        if (TextUtils.isEmpty(r109) == false) goto L145;
        int r110 = 0;
    L37:
        if (r102 != null) goto L39;
        r102 = new JSONObject();
    L39:
        if (r110 == 0) goto L41;
        boolean r111 = true;
    L42:
        String r112 = g.f503645a;
        if (r111 == false) goto L100;
        long r113 = r102.optLong("update_settings_interval", TimeUtils.SECONDS_PER_HOUR);
        fi7.d.f477413c = r102.optLong("settings_app_link_interval", 1000);
        Application r114 = l.a();
        if (r102.length() > 1) goto L47;
    L46:
        long r115 = r113;
    L78:
        Application r116 = l.a();
        JSONObject r117 = d.b(r116);
        Iterator<String> r118 = r117.keys();
    L80:
        if (r118.hasNext() == false) goto L87;
        String r119 = r118.next();     // Catch: JSONException -> L85
        if (r102.has(r119) == true) goto L80;
        r102.put(r119, r117.opt(r119));     // Catch: JSONException -> L85
    L85:
        e = move-exception;
        mi7.e.d(6, "ZlinkSettingsCacheHelper", "settings update error:", e);
        goto L80
    L87:
        d.f503643b = r102;
        SharedPreferences r120 = d.a(r116);
        if (r120 == null) goto L90;
        SharedPreferences.Editor r121 = r120.edit();
        r121.putString("deeplink_setting_data", r102.toString());
        r121.apply();
    L90:
        IZlinkDepend r122 = p.a();
        if (r122 == null) goto L93;
        boolean r123 = r122.settingsRefactorEnable();
    L94:
        if (r123 == false) goto L98;
        SharedPreferences r124 = d.a(l.a());
        if (r124 == null) goto L98;
        r124.edit().putLong("key_settings_lastest_update_time", System.currentTimeMillis()).apply();
    L98:
        long r125 = r115;
    L112:
        if (r111 == false) goto L134;
        AtomicBoolean r126 = f503640a;
        if (r126.get() == true) goto L134;
        int r127 = 0;
        r126.compareAndSet(false, true);
        int r128 = c.f503641a.size();
    L116:
        if (r127 >= r128) goto L126;
        WeakReference r129 = (WeakReference) ListProtector.get(c.f503641a, r127);
        if (r129 == null) goto L125;
        b r130 = (b) r129.get();
        if (r130 == null) goto L125;
        r130.a();     // Catch: Exception -> L123
    L123:
        e = move-exception;
        e.printStackTrace();
    L125:
        r127 = r127 + 1;
        goto L116
    L126:
        int r131 = g.f503647c + 1;
        if (g.f503648d == true) goto L134;
        JSONObject r132 = new JSONObject();
        r132.put("result", r131);     // Catch: JSONException -> L131
    L133:
        mi7.c.a("zlink_first_setting_result", r132);
        g.f503648d = true;
    L131:
        e = move-exception;
        e.printStackTrace();
    L134:
        g.a(r125);
        long r133 = System.currentTimeMillis() - r100;
        SharedPreferences r134 = d.a(l.a());
        if (r134 == null) goto L137;
        long r135 = r134.getLong("key_settings_lastest_update_time", 0);
    L138:
        long r136 = r135 - r100;
        JSONObject r137 = new JSONObject();
        r137.put("result", r110).put("time_consume", r133).put("settings_interval", r136).put("source", r210);     // Catch: JSONException -> L141
    L143:
        mi7.c.a("zlink_every_setting_result", r137);
        return;
    L141:
        e = move-exception;
        e.printStackTrace();
        goto L143
    L137:
        r135 = 0;
        goto L138
    L93:
        r123 = false;
        goto L94
    L47:
        JSONObject r138 = d.b(r114);
        if ("".equals(r138.toString()) == true) goto L46;
        if (r138.length() <= 1) goto L46;
        ArrayList r139 = new ArrayList();
        HashSet r140 = new HashSet();
        Iterator<String> r141 = r102.keys();
    L55:
        if (r141.hasNext() == false) goto L60;
        String r142 = r141.next();
        r139.add(r142);
        long r143 = r113;
        if (TextUtils.equals(String.valueOf(r102.opt(r142)), String.valueOf(r138.opt(r142))) == true) goto L59;
        r140.add(r142);
    L59:
        r113 = r143;
        goto L55
    L60:
        r115 = r113;
        Iterator<String> r144 = r138.keys();
    L62:
        if (r144.hasNext() == false) goto L66;
        String r145 = r144.next();
        if (r139.contains(r145) == true) goto L62;
        r140.add(r145);
        goto L62
    L66:
        r140.remove("settings_time");
        if (r140.isEmpty() == true) goto L78;
        ArrayList r146 = new ArrayList(r140);
        Collections.sort(r146);
        IZlinkDepend r147 = p.a();
        if (r147 == null) goto L71;
        mi7.e.c("zlink_settings_diff_key_" + r147.getUpdateVersionCode(), r146.toString());
    L71:
        JSONObject r148 = new JSONObject();
        JSONObject r149 = new JSONObject();
        r148.put("zlink_settings_diff_keys", r146);     // Catch: Exception -> L76
        r149.put("zlink_settings_diff_count", r146.size());     // Catch: Exception -> L76
        JSONObject r150 = new JSONObject();     // Catch: Exception -> L76
        IZlinkDepend r151 = p.a();     // Catch: Exception -> L76
        if (r151 == null) goto L78;
        r151.monitorEvent("settings_diff_monitor", r148, r149, r150);     // Catch: Exception -> L76
    L76:
        e = move-exception;
        e.printStackTrace();
        goto L78
    L100:
        if (f503640a.get() == true) goto L104;
        int r152 = g.f503647c;
        if (r152 >= 3) goto L104;
        g.f503647c = r152 + 1;
        r125 = 5;
    L104:
        r125 = r102.optLong("update_settings_interval", TimeUtils.SECONDS_PER_HOUR);
        if (g.f503648d == true) goto L112;
        JSONObject r153 = new JSONObject();
        r153.put("result", 0);     // Catch: JSONException -> L109
    L111:
        mi7.c.a("zlink_first_setting_result", r153);
        g.f503648d = true;
    L109:
        e = move-exception;
        e.printStackTrace();
        goto L111
    L41:
        r111 = false;
        goto L42
    L145:
        JSONObject r154 = new JSONObject(r109);     // Catch: JSONException -> L33
        if ("success".equalsIgnoreCase(r154.optString("message")) == false) goto L19;
        r110 = 1;
    L23:
        if (r110 == 0) goto L37;
        JSONObject r155 = r154.optJSONObject("data");     // Catch: JSONException -> L31
        if (r155 != null) goto L27;
        r155 = new JSONObject();     // Catch: JSONException -> L31
    L27:
        r102 = r155.optJSONObject("settings");     // Catch: JSONException -> L31
        if (r102 == null) goto L37;
        r102.put("settings_time", r155.optLong("settings_time", 0));     // Catch: JSONException -> L31
    L31:
        e = e;
    L35:
        e.printStackTrace();
        goto L37
    L19:
        if ("demotion".equalsIgnoreCase(r154.optString("message")) == false) goto L22;
        r110 = 2;
        goto L23
    L22:
        r110 = 0;
    L33:
        e = e;
        r110 = 0;
        goto L35
    L12:
        if (TextUtils.isEmpty(r106.getAppId()) == true) goto L14;
        r105.appendQueryParameter("aid", r106.getAppId());
        goto L14
    L8:
        r104 = "https://zlink.ugsdk.cn/service/settings/v3/";
        goto L9
    L5:
        r103 = r101.getSettingHost();
        goto L6
    }
}
