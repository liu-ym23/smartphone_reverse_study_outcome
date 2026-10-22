package gta;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.ss.android.common.applog.AppLog;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f482704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f482705b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f482706c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f482707d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f482708e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f482709f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f482710g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f482711h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f482712i;

    public final String a() {
        JSONObject r100 = new JSONObject();
        r100.put(ILoadStallMonitor.START_TIME, this.f482704a);     // Catch: JSONException -> L5
        r100.put("session_id", this.f482705b);     // Catch: JSONException -> L5
        r100.put("is_front_continuous", this.f482706c);     // Catch: JSONException -> L5
        r100.put("front_session_id", this.f482707d);     // Catch: JSONException -> L5
        r100.put("is_end_continuous", this.f482708e);     // Catch: JSONException -> L5
        r100.put("end_session_id", this.f482709f);     // Catch: JSONException -> L5
        r100.put("latest_end_time", this.f482710g);     // Catch: JSONException -> L5
        r100.put("non_task_time", this.f482711h);     // Catch: JSONException -> L5
        r100.put("tea_event_index", this.f482712i);     // Catch: JSONException -> L5
        return r100.toString();
    L5:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    public g() {
        this.f482706c = false;
        this.f482707d = null;
        this.f482708e = false;
        this.f482709f = null;
        this.f482711h = 0;
        this.f482712i = 0;
    }

    public final String toString() {
        return a();
    }

    public g(long r100) {
        this.f482706c = false;
        this.f482707d = null;
        this.f482708e = false;
        this.f482709f = null;
        this.f482711h = 0;
        this.f482712i = 0;
        this.f482704a = r100;
        boolean r101 = AppLog.L;
        this.f482705b = UUID.randomUUID().toString();
        AppLog r102 = AppLog.f408016s0;
        if (r102 == null) goto L5;
        long r103 = r102.I.getAndIncrement();
    L6:
        this.f482712i = r103;
        return;
    L5:
        r103 = -1;
        goto L6
    }
}
