package ct3;

import android.text.TextUtils;
import com.bytedance.apm.block.trace.MethodCollector;
import com.bytedance.monitor.collector.c;
import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONObject;
import ou3.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e implements Runnable {
    public final /* synthetic */ long[] a;
    public final /* synthetic */ long b;
    public final /* synthetic */ long c;
    public final /* synthetic */ long d;
    public final /* synthetic */ int e;
    public final /* synthetic */ String f;

    public final void a() {
        String r1 = MethodCollector.getInstance().evilMethodString(this.a, this.b);     // Catch: Throwable -> L8
        if (TextUtils.isEmpty(r1) == false) goto L6;
        return;
    L6:
        long r2 = this.c - this.d;     // Catch: Throwable -> L8
        JSONObject r4 = c.e().b();     // Catch: Throwable -> L8
        JSONObject r5 = new JSONObject();     // Catch: Throwable -> L8
        r5.put("is_main_process", com.bytedance.apm.d.k());     // Catch: Throwable -> L8
        r5.put("block_duration", r2);     // Catch: Throwable -> L8
        r5.put("stack", r1);     // Catch: Throwable -> L8
        r5.put("stack_key", "1048574\n");     // Catch: Throwable -> L8
        r5.put("scene", "launchTrace");     // Catch: Throwable -> L8
        r5.put("cost_time", r2);     // Catch: Throwable -> L8
        r5.put("method_time", r2);     // Catch: Throwable -> L8
        r5.put("message", "launchTrace");     // Catch: Throwable -> L8
        r5.put("event_type", "lag_drop_frame");     // Catch: Throwable -> L8
        JSONObject r3 = a.a().c(true);     // Catch: Throwable -> L8
        r3.put("crash_section", com.bytedance.apm.d.i(System.currentTimeMillis()));     // Catch: Throwable -> L8
        r3.put("trace_type", "launchTrace");     // Catch: Throwable -> L8
        r3.put("launchMode", String.valueOf(this.e));     // Catch: Throwable -> L8
        r3.put("customLaunchMode", this.f);     // Catch: Throwable -> L8
        r5.put("custom", r4);     // Catch: Throwable -> L8
        r5.put("filters", r3);     // Catch: Throwable -> L8
        is3.a.h().b(new js3.c("drop_frame_stack", r5));     // Catch: Throwable -> L8
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

    public e(long[] r1, long r2, long r4, long r6, int r8) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r6;
        this.e = r8;
        this.f = "";
    }
}
