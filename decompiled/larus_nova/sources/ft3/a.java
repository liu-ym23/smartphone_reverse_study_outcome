package ft3;

import java.util.HashMap;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, Integer> f478775a = null;

    static {
        HashMap<String, Integer> r100 = new HashMap();
        f478775a = r100;
        r100.put("xx", 12334);
    }

    public static Integer a(String r100) {
        return f478775a.get(r100);
    }
}
