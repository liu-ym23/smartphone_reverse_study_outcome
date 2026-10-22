package gh4;

import android.os.Process;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.i;

/* JADX INFO: loaded from: classes15.dex */
public final class b {
    public static eh4.a a(com.bytedance.crash.monitor.a r100, String r101, long r102, String r103, String r104, String r105) {
        eh4.a r106 = new eh4.a();
        r106.a("data", r105);     // Catch: Throwable -> L6
        r106.a("crash_type", CrashType.GAME.getName());     // Catch: Throwable -> L6
        r106.a("crash_time", Long.valueOf(r102));     // Catch: Throwable -> L6
        r106.a("crash_name", r103);     // Catch: Throwable -> L6
        r106.a("crash_reason", r104);     // Catch: Throwable -> L6
        r106.a("crash_thread_name", r101);     // Catch: Throwable -> L6
        r106.a("process_name", com.bytedance.crash.util.b.c());     // Catch: Throwable -> L6
        r106.a("app_start_time", Long.valueOf(i.b()));     // Catch: Throwable -> L6
        r106.a("upload_scene", "direct");     // Catch: Throwable -> L6
    L4:
        int r107 = Process.myPid();
        Header r108 = Header.b(r100, r102, CrashType.GAME, r107);
        r106.a("header", r108.f203195a);
        r106.f472654b = r108;
        return r106;
    }
}
