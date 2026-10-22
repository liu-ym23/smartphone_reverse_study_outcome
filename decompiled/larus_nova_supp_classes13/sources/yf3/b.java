package yf3;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public static final Map<String, Map<String, Long>> a = null;
    public static final Map<String, Map<String, String>> b = null;
    public static final Map<String, Long> c = null;

    static {
        a = new LinkedHashMap();
        b = new LinkedHashMap();
        c = new LinkedHashMap();
    }

    public static void a(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "sessionId");
        Intrinsics.checkNotNullParameter(r6, "checkPoint");
        LinkedHashMap r0 = (LinkedHashMap) a;
        if (((Map) r0.get(r5)) != null) goto L5;
        return;
    L5:
        LinkedHashMap r1 = (LinkedHashMap) c;
        Long r2 = (Long) r1.get(r5);
        if (r2 == null) goto L16;
        r2.longValue();
        if (((Map) ((LinkedHashMap) b).get(r5)) != null) goto L10;
        return;
    L10:
        Long r3 = (Long) r1.get(r5);
        if (r3 == null) goto L17;
        long r4 = r3.longValue();
        Map r7 = (Map) r0.get(r5);
        if (r7 == null) goto L18;
        Long r8 = (Long) r7.put(r6, Long.valueOf(System.currentTimeMillis() - r4));
        return;
    L18:
        return;
    L17:
        return;
    }
}
