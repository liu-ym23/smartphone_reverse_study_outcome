package com.bytedance.bdturing.sensor;

import android.app.Activity;
import android.os.Handler;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.setting.e;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import hc4.d;
import org.json.JSONObject;
import qb4.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public AccMonitor a;
    public GyroMonitor b;
    public SensorStatus c;
    public PthreadHandlerThreadV2 d;
    public Handler e;
    public final JSONObject f;

    public final void a() {
        long r0 = System.currentTimeMillis();
        this.c.b.add(Long.valueOf(r0));
        GyroMonitor r2 = this.b;
        if (r2 == null) goto L5;
        r2.onPause();
    L5:
        AccMonitor r3 = this.a;
        if (r3 == null) goto L8;
        r3.onPause();
    L8:
        d.b(this.f, "onPause_" + r0, "");
    }

    public final void b() {
        long r0 = System.currentTimeMillis();
        this.c.c.add(Long.valueOf(r0));
        GyroMonitor r2 = this.b;
        if (r2 == null) goto L5;
        r2.onResume();
    L5:
        AccMonitor r3 = this.a;
        if (r3 == null) goto L8;
        r3.onResume();
    L8:
        d.b(this.f, "onResume_" + r0, "");
    }

    public a(Activity r21) {
        this.f = new JSONObject();
        PthreadHandlerThreadV2 r0 = new PthreadHandlerThreadV2("bdTuring_sensor");     // Catch: Exception -> L5
        this.d = r0;     // Catch: Exception -> L5
        ThreadMethodProxy.start(r0);     // Catch: Exception -> L5
        this.e = new Handler(this.d.getLooper());     // Catch: Exception -> L5
    L7:
        this.c = new SensorStatus();
        e r1 = e.a;
        if (e.e("common").optInt("h5_verify_acc_switch", 0) != 1) goto L10;
        boolean r2 = true;
    L12:
        if (e.e("common").optInt("h5_verify_gyro_switch", 0) != 1) goto L14;
        boolean r5 = true;
    L15:
        BdTuringConfig r6 = b.c.a.a;
        if (r6 == null) goto L18;
        boolean r7 = r6.privacyPolicyAgree();
    L19:
        SensorStatus r8 = this.c;
        r8.cb = r5;
        r8.ve = r2;
        r8.a = r7;
        double r9 = e.e("common").optDouble("sensor_update_interval", 0.05d);
        long r10 = e.e("common").optInt("sensor_max_num", 6000);
        d.b(this.f, "init_config", "h5AccEnable=" + r2 + ":h5GyroEnable=" + r5 + ":privacyPolicyAgree=" + r7 + ":updateInterval=" + r9 + ":eventNum=" + r10);
        JSONObject r3 = new JSONObject();     // Catch: Exception -> L22
        r3.put("key", "sensor_collect_start");     // Catch: Exception -> L22
        r3.put("h5AccEnable", r2);     // Catch: Exception -> L22
        r3.put("h5GyroEnable", r5);     // Catch: Exception -> L22
        r3.put("privacyPolicyAgree", r7);     // Catch: Exception -> L22
        r3.put("updateInterval", r9);     // Catch: Exception -> L22
        r3.put("eventMaxNum", r10);     // Catch: Exception -> L22
        EventReport.w("turing_verify_sdk", r3, null);     // Catch: Exception -> L22
    L24:
        if (r7 == true) goto L27;
        return;
    L27:
        if (r9 <= 1.0d) goto L30;
        r9 = 1.0d;
    L30:
        if (r9 >= 0.01d) goto L32;
        r9 = 0.01d;
    L32:
        int r4 = (int) (r9 * 1000.0d);
        if (r10 > 0) goto L37;
        r10 = 0;
    L37:
        if (r10 <= 3000) goto L40;
        r10 = 3000;
    L40:
        if (r10 == 0) goto L53;
        if (r2 == false) goto L44;
        AccMonitor r11 = new AccMonitor(r21, this.e, r4, r10);
        this.a = r11;
        this.c.ef = r11.sensorEnable();
        d.b(this.f, "acc_enbale", Boolean.valueOf(this.c.ef));
        EventReport.F(0, this.c.ef);
    L44:
        if (r5 == false) goto L51;
        GyroMonitor r12 = new GyroMonitor(r21, this.e, r4, r10);
        this.b = r12;
        this.c.ka = r12.sensorEnable();
        d.b(this.f, "gyro_enbale", Boolean.valueOf(this.c.ka));
        EventReport.F(1, this.c.ka);
        return;
    L51:
        return;
    L53:
        return;
    L22:
        e = move-exception;
        e.printStackTrace();
        goto L24
    L18:
        r7 = false;
        goto L19
    L14:
        r5 = false;
        goto L15
    L10:
        r2 = false;
    L5:
        e = move-exception;
        e.printStackTrace();
        d.b(this.f, "init_handler_error", "errorMessage:" + e);
        goto L7
    }
}
