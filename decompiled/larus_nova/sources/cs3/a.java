package cs3;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class a extends b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f465168e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f465169f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f465170g;

    public final JSONObject b() {
        JSONObject r100 = new JSONObject();     // Catch: Throwable -> L4
        r100.put(ILoadStallMonitor.START_TIME, this.f465171a);     // Catch: Throwable -> L4
        r100.put("end_time", this.f465172b);     // Catch: Throwable -> L4
        r100.put("thread_name", this.f465173c);     // Catch: Throwable -> L4
        r100.put("thread_stack", a());     // Catch: Throwable -> L4
        r100.put(VideoThumbInfo.KEY_INTERVAL, this.f465169f);     // Catch: Throwable -> L4
        r100.put("type", this.f465168e);     // Catch: Throwable -> L4
        r100.put("intent_info", this.f465170g);     // Catch: Throwable -> L4
        return r100;
    L4:
        return null;
    }

    public final String toString() {
        return "AlarmInfo{type=" + this.f465168e + ", interval=" + this.f465169f + ", intentInfo=" + this.f465170g + ", startTime=" + this.f465171a + ", endTime=" + this.f465172b + ", threadName=" + this.f465173c + ", threadStack=" + a() + '}';
    }

    public a() {
    }
}
