package xs4;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f564972a = 0;

    static {
    }

    public static void a(String r100, Map r101) {
        if (r101 != null) goto L4;
        Map r102 = new LinkedHashMap();
    L5:
        r102.put("file_type", "bitable_workspace");
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).n(r100, r101);
        return;
    L4:
        r102 = r101;
        goto L5
    }
}
