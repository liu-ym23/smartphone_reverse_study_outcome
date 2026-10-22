package com.bytedance.bdlocation.monitor;

import android.util.Log;
import com.bytedance.bdlocation.utils.json.JsonUtil;
import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class LocationMonitor$1 implements Runnable {
    final /* synthetic */ long val$duration;
    final /* synthetic */ Throwable val$e;
    final /* synthetic */ RuntimeException val$exceptionForStackTrace;
    final /* synthetic */ boolean val$hasCompanionObj;
    final /* synthetic */ boolean val$hasReflectMethod;
    final /* synthetic */ boolean val$mainThread;
    final /* synthetic */ boolean val$reflectAwemeSuccess;
    final /* synthetic */ String val$result;

    @Override // java.lang.Runnable
    public void run() {
        com_bytedance_bdlocation_monitor_LocationMonitor$1_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void com_bytedance_bdlocation_monitor_LocationMonitor$1__run$___twin___() {
        JSONObject r0 = new JSONObject();
        JsonUtil.safePutBoolean(r0, "is_main_thread", this.val$mainThread);
        JsonUtil.safePutBoolean(r0, "has_reflect_method", this.val$hasReflectMethod);
        JsonUtil.safePutBoolean(r0, "has_companion_obj", this.val$hasCompanionObj);
        JsonUtil.safePutBoolean(r0, "reflect_aweme_success", this.val$reflectAwemeSuccess);
        JsonUtil.safePutString(r0, "result", this.val$result);
        JSONObject r1 = new JSONObject();
        JsonUtil.safePutLong(r1, "duration", this.val$duration);
        JSONObject r2 = new JSONObject();
        JsonUtil.safePutString(r2, "passive_init_stack_trace", Log.getStackTraceString(this.val$exceptionForStackTrace));
        Throwable r3 = this.val$e;
        if (r3 == null) goto L5;
        JsonUtil.safePutString(r2, "err_stack_trace", Log.getStackTraceString(r3));
    L5:
        r0.toString();
        r1.toString();
        r2.toString();
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_PASSIVE_INIT, r0, r1, r2);
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_bytedance_bdlocation_monitor_LocationMonitor$1_com_larus_apm_impl_protector_RunnableLancet_run(LocationMonitor$1 r1) {
        r1.com_bytedance_bdlocation_monitor_LocationMonitor$1__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public LocationMonitor$1(boolean r1, boolean r2, boolean r3, boolean r4, String r5, long r6, RuntimeException r8, Throwable r9) {
        this.val$mainThread = r1;
        this.val$hasReflectMethod = r2;
        this.val$hasCompanionObj = r3;
        this.val$reflectAwemeSuccess = r4;
        this.val$result = r5;
        this.val$duration = r6;
        this.val$exceptionForStackTrace = r8;
        this.val$e = r9;
    }
}
