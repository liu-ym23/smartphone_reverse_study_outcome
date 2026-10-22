package qm;

import com.bytedance.android.ec.monitor.duration.d;
import com.bytedance.android.ec.monitor.duration.i;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, String> f533835a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Map<String, Long>> f533836b = null;

    static {
        f533835a = new LinkedHashMap();
        f533836b = new LinkedHashMap();
    }

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "business");
        f533835a.put(r100, i.f47987a.create(r100));
        f533836b.put(r100, new LinkedHashMap());
    }

    public static void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "business");
        String r101 = (String) ((LinkedHashMap) f533835a).get(r100);
        if (r101 == null) goto L22;
        Map r102 = (Map) ((LinkedHashMap) f533836b).get(r100);
        if (r102 == null) goto L12;
        Iterator r103 = r102.entrySet().iterator();
    L8:
        if (r103.hasNext() == false) goto L12;
        Map.Entry r104 = (Map.Entry) r103.next();
        d r105 = i.f47987a.get(r101);
        if (r105 == null) goto L8;
        r105.d((String) r104.getKey(), ((Number) r104.getValue()).longValue());
    L12:
        d r106 = i.f47987a.get(r101);
        if (r106 == null) goto L15;
        r106.report();
    L15:
        f533835a.remove(r100);
        Map<String, Long> r107 = f533836b.remove(r100);
        return;
    }

    public static void a(String r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "business");
        Intrinsics.checkNotNullParameter(r101, "key");
        Map r103 = (Map) ((LinkedHashMap) f533836b).get(r100);
        if (r103 != null) goto L5;
        return;
    L5:
        if (r103.get(r101) != null) goto L9;
        r103.put(r101, Long.valueOf(r102));
        return;
    }
}
