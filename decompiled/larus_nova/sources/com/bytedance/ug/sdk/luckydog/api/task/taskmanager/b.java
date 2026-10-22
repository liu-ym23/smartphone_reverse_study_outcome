package com.bytedance.ug.sdk.luckydog.api.task.taskmanager;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import org.json.JSONObject;
import rk7.m;
import uk7.n;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f271686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f271687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f271688c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f271689d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ JSONObject f271690e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f271691f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ug.sdk.luckydog.api.task.taskmanager.c f271692g;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f271693a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f271693a.getClass();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(b r100) {
            this.f271693a = r100;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ug.sdk.luckydog.api.task.taskmanager.b$b, reason: collision with other inner class name */
    public class RunnableC3805b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f271694a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f271695b;

        @Override // java.lang.Runnable
        public final void run() {
            this.f271694a.optInt("status_code");     // Catch: Throwable -> L4
            this.f271695b.getClass();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public RunnableC3805b(b r100, JSONObject r101) {
            this.f271695b = r100;
            this.f271694a = r101;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f271696a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f271696a.getClass();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(b r100, JSONObject r101, JSONObject r102) {
            this.f271696a = r100;
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f271697a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f271697a.getClass();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public d(b r100) {
            this.f271697a = r100;
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f271698a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f271698a.getClass();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public e(b r100, Throwable r101) {
            this.f271698a = r100;
        }
    }

    public final void a() {
        HashMap r100 = null;
        String r101 = this.f271686a.optString("group");     // Catch: Throwable -> L12
        String r102 = this.f271686a.optString("task_id");     // Catch: Throwable -> L12
        if (r101.isEmpty() == false) goto L6;
    L72:
        JSONObject r103 = new JSONObject();     // Catch: Throwable -> L65
        String r104 = this.f271687b;     // Catch: Throwable -> L65
        String r105 = "";
        if (r104 != null) goto L18;
    L20:
        String r106 = "";
    L21:
        r103.put("token", r106);     // Catch: Throwable -> L65
        String r107 = this.f271688c;     // Catch: Throwable -> L65
        if (r107 != null) goto L24;
    L26:
        r103.put(BdpAppEventConstant.PARAMS_UNIQUEID, r105);     // Catch: Throwable -> L65
        String r108 = this.f271689d;     // Catch: Throwable -> L65
        if (r108 == null) goto L29;
        r103.put("extra", r108);     // Catch: Throwable -> L65
    L29:
        JSONObject r109 = this.f271686a;     // Catch: Throwable -> L65
        if (r109 == null) goto L33;
        r103.put("params", r109);     // Catch: Throwable -> L65
    L33:
        if (this.f271690e == null) goto L35;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("TaskFullPathManager", "服务端成功获取全链路参数: " + this.f271690e);     // Catch: Throwable -> L65
        r103.put("full_path_trace_params", this.f271690e);     // Catch: Throwable -> L65
    L35:
        String r110 = m.f538361o.b(this.f271692g.f271702d + this.f271692g.f271703e);     // Catch: Throwable -> L65
        com.bytedance.ug.sdk.luckydog.api.log.d.d("DoActionManager", "请求任务完成上报接口, requestUrl: " + r110);     // Catch: Throwable -> L65
        if (r100 != null) goto L38;
    L41:
        String r111 = (String) n.c(r110, r103).body();     // Catch: Throwable -> L65
    L43:
        if (TextUtils.isEmpty(r111) == false) goto L46;
        this.f271692g.f271701c.post(new a(this));     // Catch: Throwable -> L65
        return;
    L46:
        JSONObject r112 = new JSONObject(r111);     // Catch: Throwable -> L65
        this.f271692g.getClass();     // Catch: Throwable -> L65
        int r113 = r112.optInt("status_code", -1);     // Catch: Throwable -> L65
        if (r113 == 1300001) goto L51;
        if (r113 == 0) goto L51;
        boolean r114 = false;
    L52:
        if (r114 == true) goto L55;
        this.f271692g.f271701c.post(new RunnableC3805b(this, r112));     // Catch: Throwable -> L65
        return;
    L55:
        JSONObject r115 = r112.optJSONObject("data");     // Catch: Throwable -> L65
        if (r115 != null) goto L58;
        new Handler(Looper.getMainLooper()).post(new d(this));     // Catch: Throwable -> L65
        return;
    L58:
        if (this.f271690e == null) goto L62;
        String r116 = this.f271691f;     // Catch: Throwable -> L65
        if (r116 == null) goto L62;
        j.c(r116, false);     // Catch: Throwable -> L65
    L62:
        new Handler(Looper.getMainLooper()).post(new c(this, r112, r115));     // Catch: Throwable -> L65
        return;
    L51:
        r114 = true;
        goto L52
    L38:
        if (r100.isEmpty() == true) goto L41;
        r111 = (String) n.b(r110, r100, r103).body();     // Catch: Throwable -> L65
        goto L43
    L24:
        if (r107.length() <= 0) goto L26;
        r105 = this.f271688c;     // Catch: Throwable -> L65
        goto L26
    L18:
        if (r104.length() <= 0) goto L20;
        r106 = this.f271687b;     // Catch: Throwable -> L65
    L65:
        th = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.c("DoActionManager", "exception caught: " + th.getLocalizedMessage(), th);
        this.f271692g.f271701c.post(new e(this, th));
        return;
    L6:
        if (r102.isEmpty() == true) goto L72;
        com.bytedance.ug.sdk.luckydog.api.task.taskmanager.c r117 = this.f271692g;     // Catch: Throwable -> L12
        r117.f271700b = "/polaris/task/do_action";     // Catch: Throwable -> L12
        r117.f271703e = "/polaris/task/do_action";     // Catch: Throwable -> L12
        HashMap r118 = new HashMap();     // Catch: Throwable -> L12
        r118.put("group", r101);     // Catch: Throwable -> L10
        r118.put("task_id", r102);     // Catch: Throwable -> L10
        this.f271686a.remove("group");     // Catch: Throwable -> L10
        this.f271686a.remove("task_id");     // Catch: Throwable -> L10
        r100 = r118;
    L10:
        th = th;
        r100 = r118;
    L13:
        com.bytedance.ug.sdk.luckydog.api.log.d.c("DoActionManager", "exception caught: " + th.getLocalizedMessage(), th);
    L12:
        th = th;
        goto L13
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

    public b(com.bytedance.ug.sdk.luckydog.api.task.taskmanager.c r100, JSONObject r101, String r102, String r103, String r104, JSONObject r105, String r106) {
        this.f271692g = r100;
        this.f271686a = r101;
        this.f271687b = r102;
        this.f271688c = r103;
        this.f271689d = r104;
        this.f271690e = r105;
        this.f271691f = r106;
    }
}
