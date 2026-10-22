package ft3;

import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final HashMap<String, Integer> a = null;

    static {
        HashMap<String, Integer> r0 = new HashMap();
        a = r0;
        r0.put("xx", 12334);
    }

    public static Integer a(String r1) {
        return a.get(r1);
    }
}
