package hqb;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, a> f486833b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gqb.a f486834a;

    static {
        f486833b = new HashMap();
    }

    public a() {
    }

    public static a a(String r100) {
        HashMap r101 = (HashMap) f486833b;
        if (r101.containsKey(r100) == true) goto L7;
        a r102 = new a();
        r101.put(r100, r102);
        return r102;
    L7:
        return (a) r101.get(r100);
    }

    public static void b(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        Map<String, a> r101 = f486833b;
        if (((HashMap) r101).containsKey(r100) == false) goto L9;
        ((HashMap) r101).remove(r100);
        return;
    }
}
