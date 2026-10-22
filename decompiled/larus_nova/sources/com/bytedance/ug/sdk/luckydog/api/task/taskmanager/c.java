package com.bytedance.ug.sdk.luckydog.api.task.taskmanager;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import org.json.JSONException;
import org.json.JSONObject;
import rk7.m;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f271699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f271700b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f271701c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f271702d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f271703e;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f271704a = null;

        static {
            f271704a = new c();
        }
    }

    public c() {
        this.f271701c = new Handler(Looper.getMainLooper());
        Application r100 = m.f538347a;
        if (m.f() != 1128) goto L5;
        String r101 = "https://activity-ag.awemeughun.com";
    L6:
        this.f271699a = r101;
        if (m.f() != 1128) goto L9;
        String r102 = "/aweme/ug/task/do_action";
    L10:
        this.f271700b = r102;
        this.f271702d = r101;
        this.f271703e = r102;
        return;
    L9:
        r102 = "/polaris/task/do_action";
        goto L10
    L5:
        r101 = "https://polaris.zijieapi.com";
        goto L6
    }

    public final void a(String r110, String r111, String r112, String r113, JSONObject r114) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("DoActionManager", "doActionWithToken on call, token:" + r111 + ", uniqueId: " + r112 + ", extra: " + r113);
        JSONObject r100 = new JSONObject();
        JSONObject r101 = null;
        r100.put("stage", "start");     // Catch: JSONException -> L5
        com.bytedance.ug.sdk.luckydog.api.log.e.a("luckydog_do_action_request", r100, null);     // Catch: JSONException -> L5
    L7:
        il7.m r102 = j.f271710a;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("TaskFullPathManager", "服务端尝试获取全链路参数, gid:" + r110);
        if (r110 != null) goto L10;
    L21:
        JSONObject r103 = null;
    L22:
        Application r104 = m.f538347a;
        m.d(new b(this, r114, r111, r112, r113, r103, r110));
        return;
    L10:
        if (j.a(r110) == false) goto L21;
        f r105 = j.d(r110);     // Catch: Throwable -> L18
        JSONObject r106 = new JSONObject();     // Catch: Throwable -> L18
        if (r105 != null) goto L24;
    L20:
        r103 = r106;
        goto L22
    L24:
        r106.put("session_id", r105.f271707a);     // Catch: Throwable -> L16
        r106.put("index", r105.f271708b);     // Catch: Throwable -> L16
        r106.put("global_task_id", r105.f271709c);     // Catch: Throwable -> L16
    L16:
        th = th;
        r101 = r106;
    L19:
        com.bytedance.ug.sdk.luckydog.api.log.d.b("TaskFullPathManager", th.getLocalizedMessage());
        r106 = r101;
    L18:
        th = th;
    L5:
        e = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.b("DoActionManager", e.getLocalizedMessage());
        goto L7
    }
}
