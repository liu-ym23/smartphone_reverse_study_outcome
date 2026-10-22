package ct3;

import android.text.TextUtils;
import com.bytedance.apm.block.trace.MethodCollector;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long[] f465333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f465334b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f465335c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f465336d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f465337e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f465338f;

    public final void a() {
        String r100 = MethodCollector.getInstance().evilMethodString(this.f465333a, this.f465334b);     // Catch: Throwable -> L8
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return;
    L6:
        long r101 = this.f465335c - this.f465336d;     // Catch: Throwable -> L8
        JSONObject r102 = com.bytedance.monitor.collector.c.e().b();     // Catch: Throwable -> L8
        JSONObject r103 = new JSONObject();     // Catch: Throwable -> L8
        r103.put(LocationMonitorConst.IS_MAIN_PROCESS, com.bytedance.apm.d.k());     // Catch: Throwable -> L8
        r103.put("block_duration", r101);     // Catch: Throwable -> L8
        r103.put("stack", r100);     // Catch: Throwable -> L8
        r103.put("stack_key", "1048574\n");     // Catch: Throwable -> L8
        r103.put("scene", "launchTrace");     // Catch: Throwable -> L8
        r103.put(HiAnalyticsConstant.BI_KEY_COST_TIME, r101);     // Catch: Throwable -> L8
        r103.put("method_time", r101);     // Catch: Throwable -> L8
        r103.put("message", "launchTrace");     // Catch: Throwable -> L8
        r103.put("event_type", "lag_drop_frame");     // Catch: Throwable -> L8
        JSONObject r104 = ou3.a.a().c(true);     // Catch: Throwable -> L8
        r104.put("crash_section", com.bytedance.apm.d.i(System.currentTimeMillis()));     // Catch: Throwable -> L8
        r104.put("trace_type", "launchTrace");     // Catch: Throwable -> L8
        r104.put("launchMode", String.valueOf(this.f465337e));     // Catch: Throwable -> L8
        r104.put("customLaunchMode", this.f465338f);     // Catch: Throwable -> L8
        r103.put("custom", r102);     // Catch: Throwable -> L8
        r103.put("filters", r104);     // Catch: Throwable -> L8
        is3.a.h().b(new js3.c("drop_frame_stack", r103));     // Catch: Throwable -> L8
        return;
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

    public e(long[] r100, long r101, long r102, long r103, int r104) {
        this.f465333a = r100;
        this.f465334b = r101;
        this.f465335c = r102;
        this.f465336d = r103;
        this.f465337e = r104;
        this.f465338f = "";
    }
}
