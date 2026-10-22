package gx3;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f483091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<String> f483092b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, List<Set<String>>> f483093c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, List<Map<String, Object>>> f483094d;

    public abstract boolean c(b r100);

    public final int a() {
        int r100 = this.f483091a;
        if (r100 > 0) goto L7;
        return -1;
    L7:
        if (r100 < 10000) goto L10;
        return 1;
    L10:
        return 0;
    }

    public final boolean b(String r100, JSONObject r101) {
        Map<String, List<Set<String>>> r102 = this.f483093c;
        if (r102 != null) goto L5;
    L26:
        Map<String, List<Map<String, Object>>> r103 = this.f483094d;
        if (r103 != null) goto L29;
    L61:
        return false;
    L29:
        if (r103.containsKey(r100) == false) goto L61;
        List<Map<String, Object>> r104 = this.f483094d.get(r100);
        if (r104 == null) goto L61;
        if (r104.isEmpty() == true) goto L61;
        Iterator<Map<String, Object>> r105 = r104.iterator();
    L36:
        if (r105.hasNext() == false) goto L61;
        Map<String, Object> r106 = r105.next();
        if (r106 == null) goto L36;
        if (r106.isEmpty() == true) goto L36;
        Iterator<String> r107 = r106.keySet().iterator();
    L43:
        if (r107.hasNext() == false) goto L47;
        if (r101.has(r107.next()) == true) goto L43;
        boolean r108 = false;
    L48:
        if (r108 == false) goto L36;
        Iterator<Map.Entry<String, Object>> r109 = r106.entrySet().iterator();
    L51:
        if (r109.hasNext() == false) goto L58;
        Map.Entry<String, Object> r110 = r109.next();
        String r111 = r110.getKey();
        Object r112 = r110.getValue();
        if (TextUtils.isEmpty(r111) == true) goto L57;
        if (r112 == null) goto L57;
        if (r112.equals(r101.opt(r111)) == true) goto L51;
    L57:
        boolean r113 = false;
    L59:
        if (r113 == false) goto L36;
        return true;
    L58:
        r113 = true;
        goto L59
    L47:
        r108 = true;
        goto L48
    L5:
        if (r102.containsKey(r100) == false) goto L26;
        List<Set<String>> r114 = this.f483093c.get(r100);
        if (r114 == null) goto L26;
        if (r114.isEmpty() == true) goto L26;
        Iterator<Set<String>> r115 = r114.iterator();
    L12:
        if (r115.hasNext() == false) goto L26;
        Set<String> r116 = r115.next();
        if (r116 == null) goto L12;
        if (r116.isEmpty() == true) goto L12;
        Iterator<String> r117 = r116.iterator();
    L19:
        if (r117.hasNext() == false) goto L23;
        if (r101.has(r117.next()) == true) goto L19;
        boolean r118 = false;
    L24:
        if (r118 == false) goto L12;
        return true;
    L23:
        r118 = true;
        goto L24
    }

    public a(int r100, Set<String> r101, Map<String, List<Set<String>>> r102, Map<String, List<Map<String, Object>>> r103) {
        this.f483091a = r100;
        this.f483092b = r101;
        this.f483093c = r102;
        this.f483094d = r103;
    }
}
