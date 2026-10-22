package j37;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.mira.log.MiraMonitor;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.settings.SettingsConfigProviderImpl;
import ft9.c;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import m37.b;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class a {
    public static volatile a h = null;
    public static volatile boolean i = false;
    public static volatile boolean j = false;
    public static volatile long k = -1;
    public static volatile long l = -1;
    public static final ConcurrentHashMap m = null;
    public static final ConcurrentHashMap n = null;
    public static b o;
    public static volatile h37.a p;
    public JSONObject a;
    public final SharedPreferences b;
    public final SharedPreferences c;
    public final SharedPreferences d;
    public final SharedPreferences.Editor e;
    public final SharedPreferences.Editor f;
    public volatile boolean g;

    static {
        m = new ConcurrentHashMap();
        n = new ConcurrentHashMap();
    }

    public static long c() {
        if (k >= 0) goto L5;
        k = System.currentTimeMillis();
    L5:
        l = System.currentTimeMillis() - k;
        return l;
    }

    public final String a() {
        if (this.a == null) goto L15;
        StringBuilder r0 = new StringBuilder();
        Iterator<?> r3 = this.d.getAll().values().iterator();     // Catch: Exception -> L13
    L6:
        if (r3.hasNext() == false) goto L17;
        Object r4 = r3.next();     // Catch: Exception -> L13
        if (r0.length() <= 0) goto L11;
        r0.append(",");     // Catch: Exception -> L13
    L11:
        r0.append(r4);     // Catch: Exception -> L13
    L17:
        if (this.c == null) goto L33;
        if (r0 != null) goto L37;
        r0 = new StringBuilder();
    L37:
        Iterator<Map.Entry<String, ?>> r5 = this.c.getAll().entrySet().iterator();     // Catch: Exception -> L31
    L21:
        if (r5.hasNext() == false) goto L33;
        Map.Entry<String, ?> r6 = r5.next();     // Catch: Exception -> L31
        if (TextUtils.equals(r6.getKey(), "key_update_version_code") == true) goto L21;
        Object r7 = r6.getValue();     // Catch: Exception -> L31
        if (r0.length() <= 0) goto L29;
        r0.append(",");     // Catch: Exception -> L31
    L29:
        r0.append(r7);     // Catch: Exception -> L31
    L31:
        e = move-exception;
        e.printStackTrace();
    L33:
        if (r0 != null) goto L35;
        return null;
    L35:
        return r0.toString();
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L17
    L15:
        r0 = null;
        goto L17
    }

    public static boolean d() {
        return i;
    }

    public a(Context r5) {
        SharedPreferences r0 = r5.getSharedPreferences("__ab_vid_info.sp", 0);
        this.b = r0;
        SharedPreferences r2 = r5.getSharedPreferences("__ab_exposed_info.sp", 0);
        this.d = r2;
        SharedPreferences r6 = r5.getSharedPreferences("__ab_local_exposed_info.sp", 0);
        this.c = r6;
        this.f = r6.edit();
        this.e = r2.edit();
        String r7 = r0.getString("key_vid_info", XmlPullParser.NO_NAMESPACE);
        if (TextUtils.isEmpty(r7) == true) goto L11;
        this.a = new JSONObject(r7);     // Catch: JSONException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static a b(Context r2) {
        if (h != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (h != null) goto L9;
        h = new a(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return h;
    }

    public static boolean g(String r2) {
        if (j == false) goto L8;
        ConcurrentHashMap r0 = m;
        if (r0.containsKey(r2) == true) goto L10;
        r0.put(r2, XmlPullParser.NO_NAMESPACE);
        return true;
    L10:
        return false;
    L8:
        return false;
    }

    public final void e(String r6) {
        long r0 = System.currentTimeMillis();
        n.put(r6, Long.valueOf(r0));
        if (p == null) goto L10;
        ((c) p).getClass();
        if (SettingsConfigProviderImpl.a().booleanValue() == false) goto L10;
        b r1 = o;
        if (r1 == null) goto L10;
        r1.a();
    L10:
        if (this.a == null) goto L31;
        monitor-enter(this);
        JSONObject r2 = this.a;     // Catch: Throwable -> L28
        if (r2 == null) goto L26;
        long r3 = r2.optLong(r6);     // Catch: Throwable -> L28
        if (r3 <= 0) goto L26;
        if (this.d.contains(r6) == true) goto L32;
        this.e.putString(r6, String.valueOf(r3)).apply();     // Catch: Throwable -> L28
        goto L26
    L32:
    L24:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L28
        goto L26
    L21:
        if (r3 == Long.parseLong(this.d.getString(r6, MiraMonitor.VALUE_DEFAULT))) goto L26;
        this.e.putString(r6, String.valueOf(r3)).apply();     // Catch: Exception -> L24 Throwable -> L28
    L26:
        monitor-exit(this);     // Catch: Throwable -> L28
        return;
    L28:
        th = move-exception;
        throw th;
    }

    public final void f(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return;
    L6:
        if (this.c == null) goto L18;
        monitor-enter(this);
        SharedPreferences r0 = this.c;     // Catch: Throwable -> L15
        if (r0 != null) goto L11;
    L13:
        monitor-exit(this);     // Catch: Throwable -> L15
        return;
    L11:
        if (r0.contains(r2) == true) goto L13;
        this.c.edit().putString(r2, r2).apply();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public final void h(String r5) {
        if (this.g == false) goto L5;
        return;
    L5:
        this.g = true;
        SharedPreferences r0 = this.c;
        if (r0 != null) goto L8;
        return;
    L8:
        if (this.f == null) goto L20;
        String r1 = r0.getString("key_update_version_code", XmlPullParser.NO_NAMESPACE);
        if (TextUtils.isEmpty(r1) == false) goto L16;
        if (TextUtils.isEmpty(r5) == false) goto L14;
        this.f.putString("key_update_version_code", XmlPullParser.NO_NAMESPACE).apply();
        return;
    L14:
        this.f.putString("key_update_version_code", r5).apply();
        return;
    L16:
        if (TextUtils.equals(r1, r5) == true) goto L23;
        this.f.clear().apply();
        return;
    L23:
        return;
    }

    public final synchronized void i(JSONObject r7) {
        monitor-enter(this);
        this.a = r7;     // Catch: Throwable -> L19
        this.b.edit().putString("key_vid_info", r7.toString()).apply();     // Catch: Throwable -> L19
        Iterator<String> r8 = this.d.getAll().keySet().iterator();     // Catch: Throwable -> L19
    L5:
        if (r8.hasNext() == false) goto L16;
        String r0 = r8.next();     // Catch: Throwable -> L19
        if (this.a.has(r0) == false) goto L8;
    L14:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L19
        goto L5
    L11:
        if (this.a.optLong(r0) == CastLongProtector.parseLong(this.d.getString(r0, MiraMonitor.VALUE_DEFAULT))) goto L5;
        this.e.remove(r0);     // Catch: Exception -> L14 Throwable -> L19
    L8:
        this.e.remove(r0);     // Catch: Throwable -> L19
        goto L5
    L16:
        this.e.apply();     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L19:
        th = move-exception;
        throw th;
    }
}
