package yf3;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Map<String, Long>> f567442a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Map<String, String>> f567443b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, Long> f567444c = null;

    static {
        f567442a = new LinkedHashMap();
        f567443b = new LinkedHashMap();
        f567444c = new LinkedHashMap();
    }

    public static void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "checkPoint");
        LinkedHashMap r102 = (LinkedHashMap) f567442a;
        if (((Map) r102.get(r100)) != null) goto L5;
        return;
    L5:
        LinkedHashMap r103 = (LinkedHashMap) f567444c;
        Long r104 = (Long) r103.get(r100);
        if (r104 == null) goto L16;
        r104.longValue();
        if (((Map) ((LinkedHashMap) f567443b).get(r100)) != null) goto L10;
        return;
    L10:
        Long r105 = (Long) r103.get(r100);
        if (r105 == null) goto L17;
        long r106 = r105.longValue();
        Map r107 = (Map) r102.get(r100);
        if (r107 == null) goto L18;
        Long r108 = (Long) r107.put(r101, Long.valueOf(System.currentTimeMillis() - r106));
        return;
    L18:
        return;
    L17:
        return;
    }
}
