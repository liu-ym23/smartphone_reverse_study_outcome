package com.bytedance.ee.bear.task;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.bytedance.ee.bear.contract.d;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import eu5.b;
import eu5.g;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
import tt5.a;

/* JADX INFO: loaded from: classes18.dex */
public class ReportLaunchTask extends BaseAsyncLaunchTask {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f238745c;

    @Override // com.larksuite.framework.launch.task.AbstractLaunchTask, com.larksuite.framework.launch.task.ILaunchTask
    public final int c() {
        return 5;
    }

    public ReportLaunchTask(Map<String, String> r100) {
        this.f238745c = r100;
    }

    @Override // com.bytedance.ee.bear.task.BaseAsyncLaunchTask, com.larksuite.framework.launch.task.AbstractLaunchTask, com.larksuite.framework.launch.task.ILaunchTask
    public final void a(Context r100) {
        Application r101 = b.f474075a;     // Catch: Throwable -> L16
        String r102 = g.h();     // Catch: Throwable -> L16
        if (TextUtils.isEmpty(r102) == false) goto L6;
        r102 = PullConfiguration.PROCESS_NAME_MAIN;
    L6:
        Map<String, String> r103 = this.f238745c;     // Catch: Throwable -> L16
        if (r103 == null) goto L24;
        String r104 = r103.remove("is_main_thread");     // Catch: Throwable -> L16
        a.h("ReportLaunchTask", "report launch time = " + this.f238745c.toString() + " for " + r102 + "   is_main_thread: " + r104);     // Catch: Throwable -> L16
        Iterator<Map.Entry<String, String>> r105 = this.f238745c.entrySet().iterator();     // Catch: Throwable -> L16
    L9:
        if (r105.hasNext() == false) goto L25;
        Map.Entry<String, String> r106 = r105.next();     // Catch: Throwable -> L16
        JSONObject r107 = new JSONObject();     // Catch: Throwable -> L16
        r107.put("process", r102);     // Catch: Throwable -> L16
        if (TextUtils.isEmpty(r104) == true) goto L14;
        r107.put("is_main_thread", r104);     // Catch: Throwable -> L16
    L14:
        r107.put(HiAnalyticsConstant.BI_KEY_COST_TIME, String.valueOf(r106.getValue()));     // Catch: Throwable -> L16
        r107.put("docs_task", String.valueOf(r106.getKey()));     // Catch: Throwable -> L16
        ((d) org.koin.java.a.a(d.class)).a("dev_performance_lark_launch", r107);     // Catch: Throwable -> L16
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
