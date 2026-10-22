package djc;

import android.text.TextUtils;
import android.util.Pair;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes40.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinkedHashMap<String, Pair<Long, Long>> f468981a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LinkedHashMap<String, Boolean> f468982b = null;

    static {
        f468981a = new LinkedHashMap(10, 0.75f, true);
        f468982b = new LinkedHashMap(10, 0.75f, true);
    }

    public static void a(String r100, long r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        if (r101 <= 0) goto L20;
        LinkedHashMap<String, Pair<Long, Long>> r102 = f468981a;
        monitor-enter(r102);
        r102.put(r100, new Pair(Long.valueOf(r101), 0L));     // Catch: Throwable -> L14
        r102.get(r100);     // Catch: Throwable -> L14
        if (r102.size() <= 10) goto L12;
        Iterator<Map.Entry<String, Pair<Long, Long>>> r103 = r102.entrySet().iterator();     // Catch: Throwable -> L14
        r103.next();     // Catch: Throwable -> L14
        r103.remove();     // Catch: Throwable -> L14
    L12:
        monitor-exit(r102);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }
}
