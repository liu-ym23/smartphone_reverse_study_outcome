package dc2;

import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f467876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f467877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f467878c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f467879d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f467880e;

    public f(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "syncKey");
        this.f467879d = r100;
        this.f467880e = r101;
        this.f467877b = -1;
    }

    public final void a(boolean r100, boolean r101, Long r102, String r103, Throwable r110) {
        this.f467878c = true;
        if (this.f467876a > 0) goto L5;
        return;
    L5:
        long r104 = System.currentTimeMillis() - this.f467876a;
        JSONObject r105 = new JSONObject();
        r105.put("key", this.f467879d);
        r105.put("success", r100);
        r105.put("timeout", r101);
        JSONObject r106 = new JSONObject();
        r106.put("realWaitTime", r104);
        JSONObject r107 = new JSONObject();
        r107.put("room_id", this.f467880e);
        r107.put("wait_version", this.f467877b);
        if (r102 == null) goto L8;
        r107.put("receive_version", r102.longValue());
    L8:
        if (r103 == null) goto L10;
        r107.put("bizLogId", r103);
    L10:
        if (r110 == null) goto L12;
        r107.put("error", r110.getMessage());
    L12:
        LiveTracingMonitor.f("ttlive_wrds_wait_time", LiveTracingMonitor.EventModule.LIVE_MESSAGE, r105, r106, r107);
    }
}
