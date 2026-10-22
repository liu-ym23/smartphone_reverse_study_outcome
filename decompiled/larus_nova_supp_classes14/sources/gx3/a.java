package gx3;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class a {
    public final int a;
    public final Set<String> b;
    public final Map<String, List<Set<String>>> c;
    public final Map<String, List<Map<String, Object>>> d;

    public abstract boolean c(b r1);

    public final int a() {
        int r0 = this.a;
        if (r0 > 0) goto L7;
        return -1;
    L7:
        if (r0 < 10000) goto L10;
        return 1;
    L10:
        return 0;
    }

    public final boolean b(String r7, JSONObject r8) {
        Map<String, List<Set<String>>> r0 = this.c;
        if (r0 != null) goto L5;
    L26:
        Map<String, List<Map<String, Object>>> r1 = this.d;
        if (r1 != null) goto L29;
    L61:
        return false;
    L29:
        if (r1.containsKey(r7) == false) goto L61;
        List<Map<String, Object>> r9 = this.d.get(r7);
        if (r9 == null) goto L61;
        if (r9.isEmpty() == true) goto L61;
        Iterator<Map<String, Object>> r10 = r9.iterator();
    L36:
        if (r10.hasNext() == false) goto L61;
        Map<String, Object> r2 = r10.next();
        if (r2 == null) goto L36;
        if (r2.isEmpty() == true) goto L36;
        Iterator<String> r3 = r2.keySet().iterator();
    L43:
        if (r3.hasNext() == false) goto L47;
        if (r8.has(r3.next()) == true) goto L43;
        boolean r4 = false;
    L48:
        if (r4 == false) goto L36;
        Iterator<Map.Entry<String, Object>> r5 = r2.entrySet().iterator();
    L51:
        if (r5.hasNext() == false) goto L58;
        Map.Entry<String, Object> r6 = r5.next();
        String r11 = r6.getKey();
        Object r12 = r6.getValue();
        if (TextUtils.isEmpty(r11) == true) goto L57;
        if (r12 == null) goto L57;
        if (r12.equals(r8.opt(r11)) == true) goto L51;
    L57:
        boolean r13 = false;
    L59:
        if (r13 == false) goto L36;
        return true;
    L58:
        r13 = true;
        goto L59
    L47:
        r4 = true;
        goto L48
    L5:
        if (r0.containsKey(r7) == false) goto L26;
        List<Set<String>> r14 = this.c.get(r7);
        if (r14 == null) goto L26;
        if (r14.isEmpty() == true) goto L26;
        Iterator<Set<String>> r15 = r14.iterator();
    L12:
        if (r15.hasNext() == false) goto L26;
        Set<String> r16 = r15.next();
        if (r16 == null) goto L12;
        if (r16.isEmpty() == true) goto L12;
        Iterator<String> r17 = r16.iterator();
    L19:
        if (r17.hasNext() == false) goto L23;
        if (r8.has(r17.next()) == true) goto L19;
        boolean r18 = false;
    L24:
        if (r18 == false) goto L12;
        return true;
    L23:
        r18 = true;
        goto L24
    }

    public a(int r1, Set<String> r2, Map<String, List<Set<String>>> r3, Map<String, List<Map<String, Object>>> r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
