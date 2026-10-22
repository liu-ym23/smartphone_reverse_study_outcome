package ux5;

import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.retrofit2.client.Request;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public abstract class c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f551988h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f551989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f551990b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f551991c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<String> f551992d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<String> f551993e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set<String> f551994f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Set<Pattern> f551995g;

    public abstract boolean a(Request r100, Map<String, List<String>> r101);

    public abstract void d(JSONObject r100);

    static {
        f551988h = c.class.getSimpleName();
    }

    public c(int r100) {
        this.f551991c = false;
        this.f551992d = new HashSet();
        this.f551993e = new HashSet();
        this.f551994f = new HashSet();
        this.f551995g = new HashSet();
        this.f551989a = r100;
        this.f551990b = r100;
    }

    public static boolean b(Set<?> r100) {
        if (r100 != null) goto L4;
        return true;
    L4:
        if (r100.isEmpty() == true) goto L10;
        return false;
    L10:
        return true;
    }

    public final boolean c(Request r100) {
        if (this.f551991c == false) goto L8;
        if (d.c().f551997c.get() == true) goto L8;
        return false;
    L8:
        if (b(this.f551992d) == true) goto L21;
        String r101 = r100.getHost();
        if (TextUtils.isEmpty(r101) == true) goto L18;
        Iterator r102 = ((HashSet) this.f551992d).iterator();
    L14:
        if (r102.hasNext() == false) goto L18;
        if (UrlUtils.matchPattern(r101, (String) r102.next()) == false) goto L14;
        boolean r103 = true;
    L19:
        if (r103 == true) goto L21;
        return false;
    L18:
        r103 = false;
    L21:
        String r104 = r100.getPath();
        if (TextUtils.isEmpty(r104) == true) goto L24;
        int r105 = r104.length();
        if (r105 <= 1) goto L33;
        int r106 = r105 - 1;
        if (r104.substring(r106).equals(HTTP.URL_DEFAULT) == false) goto L33;
        r104 = r104.substring(0, r106);
    L33:
        if (b(this.f551993e) == true) goto L38;
        if (((HashSet) this.f551993e).contains(r104) == false) goto L38;
        return true;
    L38:
        if (b(this.f551994f) == true) goto L46;
        Iterator r107 = ((HashSet) this.f551994f).iterator();
    L41:
        if (r107.hasNext() == false) goto L46;
        if (r104.startsWith((String) r107.next()) == false) goto L41;
        return true;
    L46:
        if (b(this.f551995g) == true) goto L56;
        Iterator r108 = ((HashSet) this.f551995g).iterator();
    L49:
        if (r108.hasNext() == false) goto L56;
        Pattern r109 = (Pattern) r108.next();
        if (r109 == null) goto L49;
        if (r109.matcher(r104).matches() == false) goto L49;
        return true;
    L56:
        return false;
    L24:
        if (Logger.debug() == false) goto L26;
        Logger.d(f551988h, "Path is empty: " + r104);
    L26:
        return false;
    }

    public final void e(JSONObject r100) {
        f(r100.optJSONArray("host_group"), this.f551992d);
        f(r100.optJSONArray("equal_group"), this.f551993e);
        f(r100.optJSONArray("prefix_group"), this.f551994f);
        JSONArray r101 = r100.optJSONArray("pattern_group");
        Set<Pattern> r102 = this.f551995g;
        if (r101 == null) goto L14;
        if (r102 == null) goto L24;
        int r103 = 0;
    L19:
        if (r103 >= r101.length()) goto L26;
        String r104 = JSONArrayProtectorUtils.getString(r101, r103);     // Catch: JSONException -> L16
        if (TextUtils.isEmpty(r104) == true) goto L13;
        HashSet r105 = (HashSet) r102;     // Catch: Throwable -> L15
        r105.add(PatternProtector.compile(r104, 2));     // Catch: Throwable -> L15
    L13:
        r103 = r103 + 1;
        goto L19
    L26:
        return;
    L25:
        return;
    L24:
        return;
    }

    public static void f(JSONArray r100, Set r101) {
        if (r100 == null) goto L12;
        if (r101 == null) goto L19;
        int r102 = 0;
    L14:
        if (r102 >= r100.length()) goto L21;
        String r103 = JSONArrayProtectorUtils.getString(r100, r102);     // Catch: JSONException -> L13
        if (TextUtils.isEmpty(r103) == true) goto L11;
        ((HashSet) r101).add(r103);     // Catch: JSONException -> L13
    L11:
        r102 = r102 + 1;
        goto L14
    L21:
        return;
    L20:
        return;
    L19:
        return;
    }
}
