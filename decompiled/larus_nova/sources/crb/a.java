package crb;

import android.os.SystemClock;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f465137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<Integer, Long> f465138b = null;

    static {
        f465137a = true;
        f465138b = new ConcurrentHashMap();
    }

    public static void a(int r100, boolean r101) {
        Log.d("AtSelectMonitor", "recordPageEnd hashCode: " + r100 + ", isSuccess: " + r101);
        Long r102 = f465138b.remove(Integer.valueOf(r100));
        if (r102 == null) goto L12;
        long r103 = SystemClock.uptimeMillis() - r102.longValue();
        JSONObject r104 = new JSONObject();     // Catch: Exception -> L7
        r104.put("time_cost", r103);     // Catch: Exception -> L7
        r104.put("is_success", r101);     // Catch: Exception -> L7
        r104.put("scene", "chat");     // Catch: Exception -> L7
        r104.put("is_remote", false);     // Catch: Exception -> L7
        r104.put(LocationMonitorConst.IS_COLD_BOOT, f465137a);     // Catch: Exception -> L7
        Statistics.sendEvent("lark_mention_first_render_perf", r104);     // Catch: Exception -> L7
        f465137a = false;     // Catch: Exception -> L7
        Log.e("AtSelectMonitor", "reportMentionFirstRenderPref success");     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        Log.e("AtSelectMonitor", "reportMentionFirstRenderPref fail: ", e);
        return;
    }

    public static void b(int r100, long r101) {
        Log.d("AtSelectMonitor", "recordPageStart hashCode: " + r100 + ", startTime: " + r101);
        f465138b.put(Integer.valueOf(r100), Long.valueOf(r101));
    }
}
