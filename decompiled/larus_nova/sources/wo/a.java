package wo;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, String> f560499a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Map<String, Long>> f560500b = null;

    static {
        f560499a = new LinkedHashMap();
        f560500b = new LinkedHashMap();
    }

    public static void a(String r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "business");
        Intrinsics.checkNotNullParameter(r101, "key");
        Map r103 = (Map) ((LinkedHashMap) f560500b).get(r100);
        if (r103 != null) goto L5;
        return;
    L5:
        if (r103.get(r101) != null) goto L9;
        r103.put(r101, Long.valueOf(r102));
        return;
    }
}
