package lx3;

import android.text.TextUtils;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.applog.log.n;
import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f511122a;

    public final void a() {
        d r100 = this.f511122a;
        String r101 = r100.f511124a.getSharedPreferences(r100.b(), 0).getString("key_task_session", "");
        if (TextUtils.isEmpty(r101) == false) goto L14;
    L9:
        k r102 = null;
    L10:
        if (r102 == null) goto L12;
        this.f511122a.c(r102);
    L12:
        this.f511122a.a();
        return;
    L14:
        JSONObject r103 = new JSONObject(r101);     // Catch: Throwable -> L7
        String r104 = r103.optString("session_id", "");     // Catch: Throwable -> L7
        r102 = new k();     // Catch: Throwable -> L7
        r102.f511156b = r104;     // Catch: Throwable -> L7
        r102.f511155a = nx3.k.i(r103, ILoadStallMonitor.START_TIME);     // Catch: Throwable -> L7
        r102.f511157c = r103.optBoolean("is_front_continuous", false);     // Catch: Throwable -> L7
        r102.f511158d = r103.optString("front_session_id", "");     // Catch: Throwable -> L7
        r102.f511159e = r103.optBoolean("is_end_continuous", false);     // Catch: Throwable -> L7
        r102.f511160f = r103.optString("end_session_id", "");     // Catch: Throwable -> L7
        r102.f511162h = nx3.k.i(r103, "latest_end_time");     // Catch: Throwable -> L7
        r102.f511163i = nx3.k.i(r103, "non_task_time");     // Catch: Throwable -> L7
        r102.f511164j = nx3.k.i(r103, "tea_event_index");     // Catch: Throwable -> L7
        r102.f511161g = r103.optJSONObject("flatParams");     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        n.w().q("[Task] get session from string failed", th, new Object[0]);
        goto L9
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c(d r100) {
        this.f511122a = r100;
    }
}
