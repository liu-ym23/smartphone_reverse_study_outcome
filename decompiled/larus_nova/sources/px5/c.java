package px5;

import android.text.TextUtils;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import java.net.URL;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static JSONObject f530934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lock f530935b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lock f530936c = null;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f530937a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f530938b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f530939c;

        public a() {
        }
    }

    static {
        ReentrantReadWriteLock r100 = new ReentrantReadWriteLock();
        f530935b = r100.readLock();
        f530936c = r100.writeLock();
    }

    public static int a(URL r110, a r111) {
        if (r110 != null) goto L67;
        return -1;
    L67:
        Lock r100 = f530935b;     // Catch: Throwable -> L66
        r100.lock();     // Catch: Throwable -> L66
        JSONObject r101 = f530934a;     // Catch: Throwable -> L66
        if (r101 != null) goto L10;
        r100.unlock();
        return -1;
    L10:
        if (r101.optInt("enabled", 0) <= 0) goto L12;
        boolean r102 = true;
    L13:
        if (r102 == true) goto L16;
        r100.unlock();
        return -1;
    L16:
        JSONArray r103 = f530934a.optJSONArray("rule_list");     // Catch: Throwable -> L66
        if (r103 != null) goto L19;
    L62:
        r100.unlock();
        return -1;
    L19:
        if (r103.length() == 0) goto L62;
        int r104 = 0;
    L23:
        if (r104 >= r103.length()) goto L64;
        JSONObject r112 = r103.optJSONObject(r104);     // Catch: Throwable -> L66
        if (r112 == null) goto L61;
        JSONArray r113 = null;
        if (r112.has("host_eq") == false) goto L31;
        JSONArray r114 = r112.optJSONArray("host_eq");     // Catch: Throwable -> L66
        int r115 = 1;
    L34:
        if (r114 == null) goto L61;
        if (b(r110.getHost(), r114, r115) == false) goto L61;
        if (r112.has("path_eq") == false) goto L42;
        r113 = r112.optJSONArray("path_eq");     // Catch: Throwable -> L66
        int r116 = 3;
    L51:
        if (r113 == null) goto L61;
        if (b(r110.getPath(), r113, r116) == false) goto L61;
        JSONObject r117 = r112.optJSONObject("value");     // Catch: Throwable -> L66
        if (r117 == null) goto L61;
        r111.f530937a = r117.optInt("conn_to", -1);     // Catch: Throwable -> L66
        r111.f530938b = r117.optInt("read_to", -1);     // Catch: Throwable -> L66
        r111.f530939c = r117.optInt("write_to", -1);     // Catch: Throwable -> L66
        int r105 = r117.optInt("pro_to", -1);     // Catch: Throwable -> L66
        f530935b.unlock();
        return r105;
    L42:
        if (r112.has("path_prefix") == false) goto L45;
        r113 = r112.optJSONArray("path_prefix");     // Catch: Throwable -> L66
        r116 = 4;
        goto L51
    L45:
        if (r112.has("path_contain") == false) goto L48;
        r113 = r112.optJSONArray("path_contain");     // Catch: Throwable -> L66
        r116 = 5;
        goto L51
    L48:
        if (r112.has("path_pattern") == false) goto L50;
        r113 = r112.optJSONArray("path_pattern");     // Catch: Throwable -> L66
        r116 = 6;
        goto L51
    L50:
        r116 = 0;
        goto L51
    L31:
        if (r112.has("host_wc") == false) goto L33;
        r114 = r112.optJSONArray("host_wc");     // Catch: Throwable -> L66
        r115 = 2;
        goto L34
    L33:
        r114 = null;
        r115 = 0;
    L61:
        r104 = r104 + 1;
        goto L23
    L12:
        r102 = false;
    L64:
        f530935b.unlock();
        return -1;
    }

    public static boolean b(String r100, JSONArray r101, int r102) {
        if (r100 != null) goto L5;
    L60:
        return false;
    L5:
        if (r100.isEmpty() == true) goto L60;
        if (r101.length() == 0) goto L60;
        switch(r102) {
            case 1: goto L48;
            case 2: goto L39;
            case 3: goto L48;
            case 4: goto L30;
            case 5: goto L21;
            case 6: goto L12;
            default: goto L11;
        };
    L11:
        return false;
    L12:
        int r103 = 0;
    L14:
        if (r103 >= r101.length()) goto L57;
        String r104 = r101.optString(r103);     // Catch: Throwable -> L58
        if (TextUtils.isEmpty(r104) == true) goto L20;
        if (r100.matches(r104) == false) goto L20;
        return true;
    L20:
        r103 = r103 + 1;     // Catch: Throwable -> L58
    L57:
        return false;
    L21:
        int r105 = 0;
    L23:
        if (r105 >= r101.length()) goto L57;
        String r106 = r101.optString(r105);     // Catch: Throwable -> L58
        if (TextUtils.isEmpty(r106) == true) goto L29;
        if (r100.contains(r106) == false) goto L29;
        return true;
    L29:
        r105 = r105 + 1;     // Catch: Throwable -> L58
        goto L23
    L30:
        int r107 = 0;
    L32:
        if (r107 >= r101.length()) goto L57;
        String r108 = r101.optString(r107);     // Catch: Throwable -> L58
        if (TextUtils.isEmpty(r108) == true) goto L38;
        if (r100.startsWith(r108) == false) goto L38;
        return true;
    L38:
        r107 = r107 + 1;     // Catch: Throwable -> L58
        goto L32
    L39:
        int r109 = 0;
    L41:
        if (r109 >= r101.length()) goto L57;
        String r110 = r101.optString(r109);     // Catch: Throwable -> L58
        if (TextUtils.isEmpty(r110) == true) goto L47;
        if (UrlUtils.matchPattern(r100, r110) == false) goto L47;
        return true;
    L47:
        r109 = r109 + 1;     // Catch: Throwable -> L58
        goto L41
    L48:
        int r111 = 0;
    L50:
        if (r111 >= r101.length()) goto L57;
        String r112 = r101.optString(r111);     // Catch: Throwable -> L58
        if (TextUtils.isEmpty(r112) == true) goto L56;
        if (r100.equals(r112) == false) goto L56;
        return true;
    L56:
        r111 = r111 + 1;
    L58:
        th = move-exception;
        th.printStackTrace();
        goto L60
    }
}
