package wt3;

import androidx.camera.video.AudioStats;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.optimize.statistics.FrescoMonitorConst;
import com.ss.videoarch.strategy.featureCenter.featureType.TypeDeviceFeaturesCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import ss3.i;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements nu3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f561195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f561196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f561197c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f561198d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<vt3.h> f561199e;

    @Override // nu3.c
    public final String getLogType() {
        return "cpu_exception_trace";
    }

    @Override // nu3.c
    public final JSONObject a() {
        JSONObject r100 = new JSONObject();
        r100.put("event_type", "cpu_exception_trace");     // Catch: Throwable -> L24
        r100.put(FrescoMonitorConst.LOG_TYPE, "cpu_exception_trace");     // Catch: Throwable -> L24
        r100.put("timestamp", System.currentTimeMillis());     // Catch: Throwable -> L24
        r100.put("crash_time", System.currentTimeMillis());     // Catch: Throwable -> L24
        r100.put(LocationMonitorConst.IS_MAIN_PROCESS, com.bytedance.apm.d.k());     // Catch: Throwable -> L24
        r100.put("process_name", com.bytedance.apm.d.c());     // Catch: Throwable -> L24
        if (this.f561198d == false) goto L7;
        r100.put("data_type", "back");     // Catch: Throwable -> L24
    L8:
        r100.put("scene", this.f561197c);     // Catch: Throwable -> L24
        r100.put("report_scene", this.f561197c);     // Catch: Throwable -> L24
        if (com.bytedance.apm.d.f190527o > com.bytedance.apm.d.h()) goto L14;
        long r101 = com.bytedance.apm.d.f190527o;     // Catch: Throwable -> L24
        if (r101 == 0) goto L14;
        r100.put("app_launch_start_time", r101);     // Catch: Throwable -> L24
    L15:
        r100.put("process_speed_avg", this.f561195a);     // Catch: Throwable -> L24
        r100.put("process_speed_max", this.f561196b);     // Catch: Throwable -> L24
        i r102 = i.a.f543398a;     // Catch: Throwable -> L24
        r100.put(TypeDeviceFeaturesCollector.BATTERY_TEMPERATURE, r102.f543396d);     // Catch: Throwable -> L24
        r100.put("battery_recharge_state", r102.f543397e);     // Catch: Throwable -> L24
        JSONArray r103 = new JSONArray();     // Catch: Throwable -> L24
        Iterator r104 = ((ArrayList) this.f561199e).iterator();     // Catch: Throwable -> L24
    L17:
        if (r104.hasNext() == false) goto L22;
        vt3.h r105 = (vt3.h) r104.next();     // Catch: Throwable -> L24
        if (r105 == null) goto L17;
        JSONObject r106 = new JSONObject();     // Catch: Throwable -> L24
        r106.put("nice", r105.f557220h);     // Catch: Throwable -> L24
        r106.put("weight", CastDoubleProtector.valueOf(r105.f557217e));     // Catch: Throwable -> L24
        r106.put("cpu_usage", r105.f557216d);     // Catch: Throwable -> L24
        r106.put("thread_name", r105.f557214b);     // Catch: Throwable -> L24
        r106.put("thread_back_trace", r105.f557218f);     // Catch: Throwable -> L24
        r106.put(CrashHianalyticsData.THREAD_ID, r105.f557213a);     // Catch: Throwable -> L24
        r103.put(r106);     // Catch: Throwable -> L24
        goto L17
    L22:
        r100.put("threads_info", r103);     // Catch: Throwable -> L24
    L27:
        r100.toString();
        return r100;
    L14:
        r100.put("app_launch_start_time", com.bytedance.apm.d.h());     // Catch: Throwable -> L24
        goto L15
    L7:
        r100.put("data_type", NewBroadcastMonitor.CAPTURE.FRONT);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        av3.b.c("APM-CPU", "cpu_exception_data_assemble", th);
        JSONObject r107 = new JSONObject();     // Catch: Throwable -> L29
        r107.put(com.bytedance.android.ec.core.event.a.KEY_EXCEPTION, th.getLocalizedMessage());     // Catch: Throwable -> L29
        jt3.a.d(new lt3.a("cpu_exception_no_stack", 0, r107, null, null, null));     // Catch: Throwable -> L29
        goto L27
    }

    @Override // nu3.c
    public final boolean isValid() {
        List<vt3.h> r100 = this.f561199e;
        if (r100 != null) goto L5;
    L11:
        return false;
    L5:
        if (((ArrayList) r100).isEmpty() == true) goto L11;
        if (this.f561195a <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L11;
        if (this.f561196b <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L11;
        return true;
    }

    public b(double r100, double r101, List<vt3.h> r102, String r103, boolean r104) {
        this.f561195a = r100;
        this.f561196b = r101;
        this.f561197c = r103;
        this.f561198d = r104;
        this.f561199e = new ArrayList(r102);
    }
}
