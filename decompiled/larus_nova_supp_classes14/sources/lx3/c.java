package lx3;

import android.text.TextUtils;
import com.bytedance.applog.log.n;
import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements Runnable {
    public final /* synthetic */ d a;

    public final void a() {
        d r0 = this.a;
        String r1 = r0.a.getSharedPreferences(r0.b(), 0).getString("key_task_session", "");
        if (TextUtils.isEmpty(r1) == false) goto L14;
    L9:
        k r4 = null;
    L10:
        if (r4 == null) goto L12;
        this.a.c(r4);
    L12:
        this.a.a();
        return;
    L14:
        JSONObject r2 = new JSONObject(r1);     // Catch: Throwable -> L7
        String r3 = r2.optString("session_id", "");     // Catch: Throwable -> L7
        r4 = new k();     // Catch: Throwable -> L7
        r4.b = r3;     // Catch: Throwable -> L7
        r4.a = nx3.k.i(r2, "start_time");     // Catch: Throwable -> L7
        r4.c = r2.optBoolean("is_front_continuous", false);     // Catch: Throwable -> L7
        r4.d = r2.optString("front_session_id", "");     // Catch: Throwable -> L7
        r4.e = r2.optBoolean("is_end_continuous", false);     // Catch: Throwable -> L7
        r4.f = r2.optString("end_session_id", "");     // Catch: Throwable -> L7
        r4.h = nx3.k.i(r2, "latest_end_time");     // Catch: Throwable -> L7
        r4.i = nx3.k.i(r2, "non_task_time");     // Catch: Throwable -> L7
        r4.j = nx3.k.i(r2, "tea_event_index");     // Catch: Throwable -> L7
        r4.g = r2.optJSONObject("flatParams");     // Catch: Throwable -> L7
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

    public c(d r1) {
        this.a = r1;
    }
}
