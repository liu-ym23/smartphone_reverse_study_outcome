package uw3;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.applog.monitor.MonitorKey;
import com.bytedance.keva.Keva;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C7939a f551930c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashSet<String> f551931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, HashSet<String>> f551932b;

    /* JADX INFO: renamed from: uw3.a$a, reason: collision with other inner class name */
    public static class C7939a extends com.bytedance.applog.log.b<Keva> {
        public C7939a() {
        }

        @Override // com.bytedance.applog.log.b
        public final Keva a(Object[] r100) {
            return Keva.getRepo("applog_server_filter.keva");
        }
    }

    public abstract boolean d(String r100);

    public abstract boolean e(HashSet<String> r100, String r101);

    static {
        f551930c = new C7939a();
    }

    public a(HashSet r100, HashMap r101) {
        this.f551931a = r100;
        this.f551932b = r101;
    }

    public boolean c(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        HashSet<String> r102 = this.f551931a;
        if (r102 != null) goto L8;
    L41:
        return true;
    L8:
        if (r102.isEmpty() == true) goto L41;
        if (d(r100) == false) goto L14;
        return false;
    L14:
        if (TextUtils.isEmpty(r101) == false) goto L16;
        return true;
    L16:
        HashMap<String, HashSet<String>> r103 = this.f551932b;
        if (r103 == null) goto L41;
        if (r103.isEmpty() == true) goto L41;
        if (this.f551932b.containsKey(r100) == false) goto L41;
        HashSet<String> r104 = this.f551932b.get(r100);
        if (r104 == null) goto L41;
        if (r104.isEmpty() == true) goto L41;
        JSONObject r105 = new JSONObject(r101);     // Catch: Throwable -> L30
    L31:
        if (r105 != null) goto L33;
        return true;
    L33:
        Iterator<String> r106 = r105.keys();
    L35:
        if (r106.hasNext() == false) goto L41;
        if (e(r104, r106.next()) == false) goto L35;
        r106.remove();     // Catch: Throwable -> L40
    L30:
        r105 = null;
        goto L31
    }

    public static a f(com.bytedance.applog.b r110, String r111, JSONObject r112) {
        boolean r100 = r110.f192424o0;     // Catch: Throwable -> L73
        C7939a r101 = f551930c;
        if (r100 == false) goto L7;
        r101.b(new Object[0]).clear();     // Catch: Throwable -> L73
        SharedPreferences.Editor r102 = null;
    L8:
        if (r112 != null) goto L10;
    L72:
        return null;
    L10:
        if (r112.has("event_list") == false) goto L72;
        JSONObject r103 = r112.optJSONObject("event_list");     // Catch: Throwable -> L73
        if (r103 != null) goto L15;
        return null;
    L15:
        int r104 = r103.optInt("is_block", 0);     // Catch: Throwable -> L73
        if (r100 == false) goto L18;
        r101.b(new Object[0]).storeInt("is_block", r104);     // Catch: Throwable -> L73
    L19:
        HashSet r105 = new HashSet();     // Catch: Throwable -> L73
        JSONArray r113 = r103.optJSONArray("events");     // Catch: Throwable -> L73
        if (r113 == null) goto L31;
        if (r113.length() <= 0) goto L31;
        int r114 = 0;
    L25:
        if (r114 >= r113.length()) goto L31;
        String r115 = r113.optString(r114);     // Catch: Throwable -> L73
        if (TextUtils.isEmpty(r115) == true) goto L29;
        r105.add(r115);     // Catch: Throwable -> L73
    L29:
        r114 = r114 + 1;     // Catch: Throwable -> L73
    L31:
        if (r105.size() <= 0) goto L35;
        if (r100 == false) goto L34;
        r101.b(new Object[0]).storeStringSetJustDisk("events", r105);     // Catch: Throwable -> L73
        goto L35
    L34:
        r102.putStringSet("events", r105);     // Catch: Throwable -> L73
    L35:
        HashMap r106 = new HashMap();     // Catch: Throwable -> L73
        JSONObject r107 = r103.optJSONObject("params");     // Catch: Throwable -> L73
        if (r107 == null) goto L58;
        Iterator<String> r116 = r107.keys();     // Catch: Throwable -> L73
    L39:
        if (r116.hasNext() == false) goto L58;
        String r117 = r116.next();     // Catch: Throwable -> L73
        if (TextUtils.isEmpty(r117) == true) goto L39;
        HashSet r118 = new HashSet();     // Catch: Throwable -> L73
        JSONArray r119 = r107.optJSONArray(r117);     // Catch: Throwable -> L73
        if (r119 == null) goto L55;
        if (r119.length() <= 0) goto L55;
        int r120 = 0;
    L49:
        if (r120 >= r119.length()) goto L55;
        String r121 = r119.optString(r120);     // Catch: Throwable -> L73
        if (TextUtils.isEmpty(r121) == true) goto L53;
        r118.add(r121);     // Catch: Throwable -> L73
    L53:
        r120 = r120 + 1;     // Catch: Throwable -> L73
    L55:
        if (r118.size() <= 0) goto L39;
        r106.put(r117, r118);     // Catch: Throwable -> L73
    L58:
        if (r106.size() <= 0) goto L66;
        Iterator r108 = r106.entrySet().iterator();     // Catch: Throwable -> L73
    L61:
        if (r108.hasNext() == false) goto L66;
        Map.Entry r122 = (Map.Entry) r108.next();     // Catch: Throwable -> L73
        if (r100 == true) goto L64;
        r102.putStringSet((String) r122.getKey(), (Set) r122.getValue());     // Catch: Throwable -> L73
        goto L61
    L64:
        r101.b(new Object[0]).storeStringSetJustDisk((String) r122.getKey(), (Set) r122.getValue());     // Catch: Throwable -> L73
    L66:
        if (r102 == null) goto L68;
        r102.apply();     // Catch: Throwable -> L73
    L68:
        if (r104 <= 0) goto L70;
        a r109 = new c(r105, r106);     // Catch: Throwable -> L73
    L97:
        return r109;
    L70:
        r109 = new b(r105, r106);     // Catch: Throwable -> L73
        goto L97
    L18:
        r102.putInt("is_block", r104);     // Catch: Throwable -> L73
        goto L19
    L7:
        r102 = r110.getContext().getSharedPreferences(r111, 0).edit();     // Catch: Throwable -> L73
        r102.clear().apply();     // Catch: Throwable -> L73
    L73:
        th = move-exception;
        r110.f192434t0.s(null, "parseFilterFromServer error: ", th, new Object[0]);
        return null;
    }

    @Override // uw3.e
    public final boolean a(MonitorKey r100, String r101, String r102, JSONObject r103) {
        if (MonitorKey.event_v3.equals(r100) == true) goto L7;
        return false;
    L7:
        return !c(r101, r102);
    }
}
