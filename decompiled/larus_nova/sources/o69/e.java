package o69;

import com.bytedance.keva.Keva;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f522209a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CopyOnWriteArrayList<String> f522210b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f522211c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f522212d = null;

    static {
        f522209a = LazyKt.lazy(new c());
        CopyOnWriteArrayList<String> r100 = new CopyOnWriteArrayList();
        f522210b = r100;
        f522211c = LazyKt.lazy(new d());
        f522212d = new Object();
        c();     // Catch: Exception -> L5
        g49.d.d("DoraGTimeSyncRepo", "Initialized with " + r100.size() + " sessions, max limit: " + b());     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        g49.d.d("DoraGTimeSyncRepo", "Failed to load session list: " + e.getMessage());
    }

    public static int b() {
        return ((Number) f522211c.getValue()).intValue();
    }

    public static void c() {
        String r100 = ((Keva) f522209a.getValue()).getString("dora_g_time_sync_session_list", "");
        Intrinsics.checkNotNull(r100);
        if (r100.length() <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L23;
        List r102 = StringsKt.split$default(r100, new String[]{","}, false, 0, 6, null);
        ArrayList r103 = new ArrayList();
        Iterator r104 = r102.iterator();
    L9:
        if (r104.hasNext() == false) goto L16;
        Object r105 = r104.next();
        if (((String) r105).length() <= 0) goto L13;
        boolean r106 = true;
    L14:
        if (r106 == false) goto L9;
        r103.add(r105);
        goto L9
    L13:
        r106 = false;
        goto L14
    L16:
        CopyOnWriteArrayList<String> r107 = f522210b;
        r107.clear();
        r107.addAll(r103);
        return;
    L23:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public static void d() {
        String r100 = CollectionsKt.joinToString$default(f522210b, ",", null, null, 0, null, null, 62, null);
        ((Keva) f522209a.getValue()).storeString("dora_g_time_sync_session_list", r100);
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Object r101 = f522212d;     // Catch: Exception -> L16
        monitor-enter(r101);     // Catch: Exception -> L16
        CopyOnWriteArrayList<String> r102 = f522210b;     // Catch: Throwable -> L13
        if (r102.contains(r100) == true) goto L10;
        g49.d.d("DoraGTimeSyncRepo", "Session " + r100 + " not found for deletion");     // Catch: Throwable -> L13
        monitor-exit(r101);     // Catch: Exception -> L16
        return;
    L10:
        r102.remove(r100);     // Catch: Throwable -> L13
        ((Keva) f522209a.getValue()).erase("dora_g_time_sync_session_" + r100);     // Catch: Throwable -> L13
        d();     // Catch: Throwable -> L13
        monitor-exit(r101);     // Catch: Exception -> L16
        return;
    L13:
        th = move-exception;
        throw th;     // Catch: Exception -> L16
    L16:
        e = move-exception;
        g49.d.d("DoraGTimeSyncRepo", "Error deleting time deviation: " + e.getMessage());
    }

    public static boolean e(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Object r102 = f522212d;     // Catch: Exception -> L17
        monitor-enter(r102);     // Catch: Exception -> L17
        CopyOnWriteArrayList<String> r103 = f522210b;     // Catch: Throwable -> L14
        if (r103.contains(r100) == true) goto L10;
        g49.d.d("DoraGTimeSyncRepo", "Session " + r100 + " not found for update");     // Catch: Throwable -> L14
        monitor-exit(r102);     // Catch: Exception -> L17
        return false;
    L10:
        ((Keva) f522209a.getValue()).storeLong("dora_g_time_sync_session_" + r100, r101);     // Catch: Throwable -> L14
        r103.remove(r100);     // Catch: Throwable -> L14
        r103.add(r100);     // Catch: Throwable -> L14
        d();     // Catch: Throwable -> L14
        monitor-exit(r102);     // Catch: Exception -> L17
        return true;
    L14:
        th = move-exception;
        throw th;     // Catch: Exception -> L17
    L17:
        e = move-exception;
        g49.d.d("DoraGTimeSyncRepo", "Error updating time deviation: " + e.getMessage());
        return false;
    }
}
