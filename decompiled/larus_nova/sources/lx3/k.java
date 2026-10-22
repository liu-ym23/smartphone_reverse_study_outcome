package lx3;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import org.json.JSONException;
import org.json.JSONObject;
import rw3.n;

/* JADX INFO: loaded from: classes14.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f511155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f511156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f511157c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f511158d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f511159e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f511160f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public JSONObject f511161g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f511162h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f511163i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f511164j;

    public final String a() {
        JSONObject r100 = new JSONObject();
        r100.put(ILoadStallMonitor.START_TIME, this.f511155a);     // Catch: JSONException -> L8
        r100.put("session_id", this.f511156b);     // Catch: JSONException -> L8
        r100.put("is_front_continuous", this.f511157c);     // Catch: JSONException -> L8
        r100.put("front_session_id", this.f511158d);     // Catch: JSONException -> L8
        r100.put("is_end_continuous", this.f511159e);     // Catch: JSONException -> L8
        r100.put("end_session_id", this.f511160f);     // Catch: JSONException -> L8
        r100.put("latest_end_time", this.f511162h);     // Catch: JSONException -> L8
        r100.put("non_task_time", this.f511163i);     // Catch: JSONException -> L8
        r100.put("tea_event_index", this.f511164j);     // Catch: JSONException -> L8
        JSONObject r101 = this.f511161g;     // Catch: JSONException -> L8
        if (r101 == null) goto L6;
        r100.put("flatParams", r101);     // Catch: JSONException -> L8
    L6:
        return r100.toString();
    L8:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    public k() {
        this.f511157c = false;
        this.f511158d = null;
        this.f511159e = false;
        this.f511160f = null;
        this.f511161g = null;
        this.f511163i = 0;
        this.f511164j = 0;
    }

    public final String toString() {
        return a();
    }

    public k(long r100, long r101) {
        this.f511157c = false;
        this.f511158d = null;
        this.f511159e = false;
        this.f511160f = null;
        this.f511161g = null;
        this.f511163i = 0;
        this.f511164j = 0;
        this.f511155a = r100;
        this.f511156b = n.c();
        this.f511164j = r101;
    }
}
