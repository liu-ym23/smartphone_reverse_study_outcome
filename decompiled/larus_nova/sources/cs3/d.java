package cs3;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class d extends b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f465176e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f465177f;

    public final JSONObject b() {
        JSONObject r100 = new JSONObject();     // Catch: Throwable -> L4
        r100.put("flags", this.f465176e);     // Catch: Throwable -> L4
        r100.put("tag", this.f465177f);     // Catch: Throwable -> L4
        r100.put(ILoadStallMonitor.START_TIME, this.f465171a);     // Catch: Throwable -> L4
        r100.put("end_time", this.f465172b);     // Catch: Throwable -> L4
        r100.put("thread_name", this.f465173c);     // Catch: Throwable -> L4
        r100.put("thread_stack", a());     // Catch: Throwable -> L4
        return r100;
    L4:
        return null;
    }

    public final String toString() {
        return "WakeLockInfo{flags=" + this.f465176e + ", tag=" + this.f465177f + ", startTime=" + this.f465171a + ", endTime=" + this.f465172b + ", threadName=" + this.f465173c + ", threadStack=" + a() + '}';
    }

    public d() {
    }
}
