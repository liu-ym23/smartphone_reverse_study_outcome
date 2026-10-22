package ft1;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.crash.Npth;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, String> f478752a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f478753b;

    static {
        f478752a = new LinkedHashMap();
        f478753b = -1;
    }

    public static void a(int r100) {
    L15:
        e = move-exception;
        int r101 = b.f478750a;
        ALogger.e("LiveCrashTagRecorder", "clear tag error:" + e.toString());
        return;
    L4:
        if (r100 != f478753b) goto L6;
        boolean r102 = true;
    L7:
        if (r102 == true) goto L9;
        return;
    L9:
        LinkedHashMap r103 = new LinkedHashMap();     // Catch: Exception -> L15
        Iterator r104 = ((LinkedHashMap) f478752a).keySet().iterator();     // Catch: Exception -> L15
    L11:
        if (r104.hasNext() == false) goto L13;
        r103.put((String) r104.next(), "null");     // Catch: Exception -> L15
        goto L11
    L13:
        Npth.addTags(r103);     // Catch: Exception -> L15
        ((LinkedHashMap) f478752a).clear();     // Catch: Exception -> L15
        int r105 = b.f478750a;     // Catch: Exception -> L15
        ALogger.i("LiveCrashTagRecorder", r100 + ":clear tag");     // Catch: Exception -> L15
        return;
    L6:
        r102 = false;
        goto L7
    }

    public static void d(int r100) {
        f478753b = r100;     // Catch: Exception -> L5
        int r101 = b.f478750a;     // Catch: Exception -> L5
        ALogger.i("LiveCrashTagRecorder", "update record code, current record code:" + r100);     // Catch: Exception -> L5
        a(r100);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        int r102 = b.f478750a;
        ALogger.e("LiveCrashTagRecorder", r100 + ":update record code error:" + e.toString());
    }

    public static void b(String r100, int r101) {
        Intrinsics.checkNotNullParameter("live_room_scene", "tag");
        Intrinsics.checkNotNullParameter(r100, "tagValue");
    L11:
        e = move-exception;
        int r102 = b.f478750a;
        ALogger.e("LiveCrashTagRecorder", "record extra key value error:" + e.toString());
        return;
    L4:
        if (r101 != f478753b) goto L6;
        boolean r103 = true;
    L7:
        if (r103 == true) goto L9;
        return;
    L9:
        f478752a.put("live_room_scene", r100);     // Catch: Exception -> L11
        Npth.addTags(MapsKt.mapOf(TuplesKt.to("live_room_scene", r100)));     // Catch: Exception -> L11
        int r104 = b.f478750a;     // Catch: Exception -> L11
        ALogger.i("LiveCrashTagRecorder", r101 + ":record extra key value ");     // Catch: Exception -> L11
        return;
    L6:
        r103 = false;
        goto L7
    }

    public static void c(Map r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "outerMap");
    L15:
        e = move-exception;
        int r102 = b.f478750a;
        ALogger.e("LiveCrashTagRecorder", "record extra map error:" + e.toString());
        return;
    L4:
        if (r101 != f478753b) goto L6;
        boolean r103 = true;
    L7:
        if (r103 == true) goto L9;
        return;
    L9:
        Iterator r104 = r100.entrySet().iterator();     // Catch: Exception -> L15
    L11:
        if (r104.hasNext() == false) goto L13;
        Map.Entry r105 = (Map.Entry) r104.next();     // Catch: Exception -> L15
        f478752a.put((String) r105.getKey(), (String) r105.getValue());     // Catch: Exception -> L15
        goto L11
    L13:
        Npth.addTags(r100);     // Catch: Exception -> L15
        int r106 = b.f478750a;     // Catch: Exception -> L15
        ALogger.i("LiveCrashTagRecorder", r101 + ":record extra map");     // Catch: Exception -> L15
        return;
    L6:
        r103 = false;
        goto L7
    }
}
