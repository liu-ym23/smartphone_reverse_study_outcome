package gta;

import android.text.TextUtils;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.common.applog.l0;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f482681a;

    public final void a() {
        String r100 = this.f482681a.f482682a.getSharedPreferences(kta.b.f506097a, 0).getString("key_task_session", "");
        if (TextUtils.isEmpty(r100) == false) goto L14;
    L9:
        g r101 = null;
    L10:
        if (r101 == null) goto L12;
        this.f482681a.b(r101);
    L12:
        this.f482681a.a();
        return;
    L14:
        JSONObject r102 = new JSONObject(r100);     // Catch: JSONException -> L7
        String r103 = r102.optString("session_id", "");     // Catch: JSONException -> L7
        r101 = new g();     // Catch: JSONException -> L7
        r101.f482705b = r103;     // Catch: JSONException -> L7
        r101.f482704a = l0.b(r102, ILoadStallMonitor.START_TIME);     // Catch: JSONException -> L7
        r101.f482706c = r102.optBoolean("is_front_continuous", false);     // Catch: JSONException -> L7
        r101.f482707d = r102.optString("front_session_id", "");     // Catch: JSONException -> L7
        r101.f482708e = r102.optBoolean("is_end_continuous", false);     // Catch: JSONException -> L7
        r101.f482709f = r102.optString("end_session_id", "");     // Catch: JSONException -> L7
        r101.f482710g = l0.b(r102, "latest_end_time");     // Catch: JSONException -> L7
        r101.f482711h = l0.b(r102, "non_task_time");     // Catch: JSONException -> L7
        r101.f482712i = l0.b(r102, "tea_event_index");     // Catch: JSONException -> L7
    L7:
        e = move-exception;
        e.printStackTrace();
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

    public a(b r100) {
        this.f482681a = r100;
    }
}
