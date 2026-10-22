package com.bytedance.bdturing.livedetect.view;

import com.bytedance.pitaya.api.bean.PTYError;
import com.bytedance.pitaya.api.bean.PTYTaskData;
import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONObject;
import vb4.v;

/* JADX INFO: loaded from: classes14.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f201993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PTYError f201994b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ PTYTaskData f201995c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ JSONObject f201996d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ LiveDetectView f201997e;

    public final void a() {
        JSONObject r100 = new JSONObject();     // Catch: Exception -> L7
        r100.put("success", this.f201993a);     // Catch: Exception -> L7
        r100.put("ptyError", this.f201994b);     // Catch: Exception -> L7
        r100.put("outputData", this.f201995c);     // Catch: Exception -> L7
        r100.put("convert_camera_data_time_use", this.f201996d.optLong("convert_camera_data_time_use"));     // Catch: Exception -> L7
        r100.put("pty_time_use", this.f201996d.optLong("pty_time_use"));     // Catch: Exception -> L7
        r100.put("status", this.f201996d.optInt("status", -1));     // Catch: Exception -> L7
        r100.put("debugInfo", this.f201996d.optString("debugInfo", ""));     // Catch: Exception -> L7
        vb4.b r101 = this.f201997e.f201981p;     // Catch: Exception -> L7
        if (r101 == null) goto L12;
        ((v) r101).a(r100);     // Catch: Exception -> L7
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

    public d(LiveDetectView r100, boolean r101, PTYError r102, PTYTaskData r103, JSONObject r104) {
        this.f201997e = r100;
        this.f201993a = r101;
        this.f201994b = r102;
        this.f201995c = r103;
        this.f201996d = r104;
    }
}
