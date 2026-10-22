package com.bytedance.bdturing.livedetect.view;

import com.bytedance.pitaya.api.bean.PTYError;
import com.bytedance.pitaya.api.bean.PTYTaskData;
import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONObject;
import vb4.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d implements Runnable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ PTYError b;
    public final /* synthetic */ PTYTaskData c;
    public final /* synthetic */ JSONObject d;
    public final /* synthetic */ LiveDetectView e;

    public final void a() {
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L7
        r4.put("success", this.a);     // Catch: Exception -> L7
        r4.put("ptyError", this.b);     // Catch: Exception -> L7
        r4.put("outputData", this.c);     // Catch: Exception -> L7
        r4.put("convert_camera_data_time_use", this.d.optLong("convert_camera_data_time_use"));     // Catch: Exception -> L7
        r4.put("pty_time_use", this.d.optLong("pty_time_use"));     // Catch: Exception -> L7
        r4.put("status", this.d.optInt("status", -1));     // Catch: Exception -> L7
        r4.put("debugInfo", this.d.optString("debugInfo", ""));     // Catch: Exception -> L7
        vb4.b r0 = this.e.p;     // Catch: Exception -> L7
        if (r0 == null) goto L12;
        ((v) r0).a(r4);     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
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

    public d(LiveDetectView r1, boolean r2, PTYError r3, PTYTaskData r4, JSONObject r5) {
        this.e = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
