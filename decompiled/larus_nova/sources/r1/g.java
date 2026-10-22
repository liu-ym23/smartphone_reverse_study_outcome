package r1;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes39.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f535561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, Long> f535562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f535563c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f535564d;

    public final boolean b(String r100) {
        if (r100 != null) goto L4;
        r100 = "default";
    L4:
        long r101 = com.apm.lite.k.q.b(this.f535562b, "all", 1L).longValue();
        if (com.apm.lite.k.q.b(this.f535562b, r100, 1L).longValue() < this.f535563c) goto L7;
    L9:
        return false;
    L7:
        if (r101 >= this.f535564d) goto L9;
        return true;
    }

    public g(Context r110) {
        this.f535562b = null;
        this.f535563c = 50;
        this.f535564d = 100;
        this.f535561a = r110;
        PolarisFileWrapper r100 = new PolarisFileWrapper(com.apm.lite.k.n.g(r110) + "/apmlite/issueCrashTimes/current.times");
        HashMap<String, Long> r111 = new HashMap();
        r111.put("time", Long.valueOf(System.currentTimeMillis()));
        JSONArray r101 = com.apm.lite.k.h.l(r100.getAbsolutePath());     // Catch: Throwable -> L16 IOException -> L19
        if (com.apm.lite.k.k.c(r101) == true) goto L17;
        Long r102 = Long.decode(r101.optString(0, null));     // Catch: Throwable -> L16 IOException -> L19
        if ((System.currentTimeMillis() - r102.longValue()) <= 86400000) goto L9;
        a(r100);     // Catch: Throwable -> L16 IOException -> L19
        goto L17
    L9:
        r111.put("time", r102);     // Catch: Throwable -> L16 IOException -> L19
        int r103 = 1;
    L11:
        if (r103 >= r101.length()) goto L17;
        String[] r104 = r101.optString(r103, "").split(" ");     // Catch: Throwable -> L16 IOException -> L19
        if (r104.length != 2) goto L15;
        r111.put(r104[0], Long.decode(r104[1]));     // Catch: Throwable -> L16 IOException -> L19
    L15:
        r103 = r103 + 1;
    L16:
        com.apm.lite.c.a();
    L17:
        this.f535562b = r111;
        this.f535563c = com.apm.lite.k.k.a(a.b(), this.f535563c, new String[]{"custom_event_settings", "npth_simple_setting", "crash_limit_issue"});
        this.f535564d = com.apm.lite.k.k.a(a.b(), this.f535564d, new String[]{"custom_event_settings", "npth_simple_setting", "crash_limit_all"});
    }

    public final void a(PolarisFileWrapper r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(com.apm.lite.k.n.g(this.f535561a), "apmlite/issueCrashTimes");
        r100.renameTo(new PolarisFileWrapper(r101, String.valueOf(System.currentTimeMillis())));
        String[] r102 = r101.list();
        if (r102 != null) goto L6;
        return;
    L6:
        if (r102.length <= 5) goto L9;
        Arrays.sort(r102);
        new PolarisFileWrapper(r101, r102[0]).delete();
        return;
    }
}
