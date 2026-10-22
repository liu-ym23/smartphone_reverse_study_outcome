package g87;

import android.content.SharedPreferences;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.message.util.ToolUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f480434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f480435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f480436c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ d f480437d;

    public final void a() {
        SharedPreferences r100 = this.f480437d.f480427a.getSharedPreferences("ttpush_statistics_" + ToolUtils.getCurProcessName(this.f480437d.f480427a), 0);
        a r101 = this.f480434a;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.f480415f = this.f480437d.f480428b.get(new Object[0]);
        String r102 = "push_stats_" + this.f480434a.f480415f;
        JSONObject r103 = null;
        String r104 = r100.getString(r102, null);
        if (r104 == null) goto L38;
        r103 = new JSONObject(r104);     // Catch: JSONException -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
    L38:
        if (r103 != null) goto L23;
        JSONObject r105 = new JSONObject();     // Catch: JSONException -> L28
        r105.put(AppbrandHostConstants.SCHEMA_INSPECT.SESSION, this.f480434a.f480415f);     // Catch: JSONException -> L20
        r105.put("process", ToolUtils.getCurProcessName(this.f480437d.f480427a));     // Catch: JSONException -> L20
        a r106 = this.f480434a;     // Catch: JSONException -> L20
        if (r106.f480414e == false) goto L17;
        r105.put("bg_duration", r106.f480413d - r106.f480410a);     // Catch: JSONException -> L20
    L18:
        d.a(this.f480437d, this.f480434a);     // Catch: JSONException -> L20
    L31:
        r103 = r105;
    L32:
        this.f480437d.f480429c.d("push_proc_stat", "save: " + r103);
        r100.edit().putString(r102, r103.toString()).apply();
        if (this.f480435b == false) goto L41;
        this.f480437d.d(this.f480436c);
        return;
    L41:
        return;
    L17:
        r105.put("fg_duration", r106.f480413d - r106.f480410a);     // Catch: JSONException -> L20
    L20:
        JSONException e100 = e;
    L30:
        e100.printStackTrace();
        goto L31
    L23:
        if (this.f480434a.f480414e == false) goto L25;
        long r107 = r103.optLong("bg_duration");     // Catch: JSONException -> L28
        a r108 = this.f480434a;     // Catch: JSONException -> L28
        r103.put("bg_duration", r107 + (r108.f480413d - r108.f480410a));     // Catch: JSONException -> L28
    L26:
        d.a(this.f480437d, this.f480434a);     // Catch: JSONException -> L28
        goto L32
    L25:
        long r109 = r103.optLong("fg_duration");     // Catch: JSONException -> L28
        a r110 = this.f480434a;     // Catch: JSONException -> L28
        r103.put("fg_duration", r109 + (r110.f480413d - r110.f480410a));     // Catch: JSONException -> L28
    L28:
        e = move-exception;
        r105 = r103;
        e100 = e;
        goto L30
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

    public f(d r100, a r101, boolean r102) {
        this.f480437d = r100;
        this.f480434a = r101;
        this.f480435b = r102;
        this.f480436c = true;
    }
}
