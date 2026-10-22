package com.bytedance.ee.bear.task;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.d;
import eu5.b;
import eu5.g;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
import tt5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ReportLaunchTask extends BaseAsyncLaunchTask {
    public final Map<String, String> c;

    public final int c() {
        return 5;
    }

    public ReportLaunchTask(Map<String, String> r1) {
        this.c = r1;
    }

    @Override // com.bytedance.ee.bear.task.BaseAsyncLaunchTask
    public final void a(Context r9) {
        Application r2 = b.a;     // Catch: Throwable -> L16
        String r3 = g.h();     // Catch: Throwable -> L16
        if (TextUtils.isEmpty(r3) == false) goto L6;
        r3 = "main";
    L6:
        Map<String, String> r4 = this.c;     // Catch: Throwable -> L16
        if (r4 == null) goto L24;
        String r5 = r4.remove("is_main_thread");     // Catch: Throwable -> L16
        a.h("ReportLaunchTask", "report launch time = " + this.c.toString() + " for " + r3 + "   is_main_thread: " + r5);     // Catch: Throwable -> L16
        Iterator<Map.Entry<String, String>> r1 = this.c.entrySet().iterator();     // Catch: Throwable -> L16
    L9:
        if (r1.hasNext() == false) goto L25;
        Map.Entry<String, String> r6 = r1.next();     // Catch: Throwable -> L16
        JSONObject r7 = new JSONObject();     // Catch: Throwable -> L16
        r7.put("process", r3);     // Catch: Throwable -> L16
        if (TextUtils.isEmpty(r5) == true) goto L14;
        r7.put("is_main_thread", r5);     // Catch: Throwable -> L16
    L14:
        r7.put("cost_time", String.valueOf(r6.getValue()));     // Catch: Throwable -> L16
        r7.put("docs_task", String.valueOf(r6.getKey()));     // Catch: Throwable -> L16
        ((d) org.koin.java.a.a(d.class)).a("dev_performance_lark_launch", r7);     // Catch: Throwable -> L16
        goto L9
    L25:
        return;
    L24:
        return;
    L16:
        th = move-exception;
        a.j("ReportLaunchTask", th);
    }
}
