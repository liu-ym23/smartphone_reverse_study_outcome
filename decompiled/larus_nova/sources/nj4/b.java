package nj4;

import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import java.util.HashMap;
import java.util.Map;
import pk4.l;

/* JADX INFO: loaded from: classes15.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f519439a = 0;

    static {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        long r100 = Process.getStartElapsedRealtime();
    L6:
        f519439a = r100;
        return;
    L5:
        r100 = SystemClock.elapsedRealtime();
        goto L6
    }

    public static Map<String, Object> a(int r100) {
        HashMap r101 = new HashMap();
        r101.put("error_type", Integer.valueOf(r100));
        r101.put("process_duration", Long.valueOf(Math.max(0, SystemClock.elapsedRealtime() - f519439a)));
        return r101;
    }

    public static Map<String, Object> b(int r100, int r101, int r102, int r103) {
        Map<String, Object> r104 = a(r100);
        HashMap r105 = (HashMap) r104;
        r105.put("channel_id", 0);
        r105.put("data_len", Integer.valueOf(r101));
        r105.put("pending_count", Integer.valueOf(r102));
        r105.put("pending_bytes", Integer.valueOf(r103));
        return r104;
    }

    public static void c(String r100, int r101, int r102, int r103, int r104) {
        Map<String, Object> r105 = b(5, r101, r103, r104);
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        HashMap r106 = (HashMap) r105;
        r106.put("reason", r100);
        r106.put("drop_count", Integer.valueOf(r102));
        l.c("d_bt_rtc_error", r105);
    }
}
