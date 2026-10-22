package g36;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, a> f479820a = null;

    static {
        f479820a = new LinkedHashMap();
    }

    public static void a(int r100) {
        Map<String, a> r101 = f479820a;
        monitor-enter(r101);
        Iterator r102 = ((LinkedHashMap) r101).entrySet().iterator();     // Catch: Throwable -> L11
    L6:
        if (r102.hasNext() == false) goto L8;
        ((a) ((Map.Entry) r102.next()).getValue()).a();     // Catch: Throwable -> L11
        goto L6
    L8:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r101);
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
