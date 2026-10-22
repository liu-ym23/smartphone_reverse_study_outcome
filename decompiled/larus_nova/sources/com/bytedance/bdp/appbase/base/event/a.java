package com.bytedance.bdp.appbase.base.event;

import com.bytedance.bdp.appbase.base.bdptask.BdpTask;
import com.bytedance.bdp.bdpbase.util.g;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f200543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f200544b;

    /* JADX INFO: renamed from: com.bytedance.bdp.appbase.base.event.a$a, reason: collision with other inner class name */
    public class RunnableC2888a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f200545a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONArray f200546b;

        public final void a() {
            int r100 = 0;
        L4:
            if (r100 >= 100) goto L19;
            JSONObject r101 = (JSONObject) ((ConcurrentLinkedQueue) BdpAppBatchEventUtils.f200539c).poll();
            if (r101 == null) goto L19;
            JSONObjectProtectorUtils.getString(r101, "__batch_event_name__");     // Catch: Exception -> L16
            JSONObject r102 = JSONObjectProtectorUtils.getJSONObject(r101, "__batch_event_params__");     // Catch: Exception -> L16
            JSONObject r103 = this.f200545a;     // Catch: Exception -> L16
            g.f201338a.getClass();     // Catch: Exception -> L16
            Iterator<String> r104 = r103.keys();     // Catch: Exception -> L16
        L10:
            if (r104.hasNext() == false) goto L14;
            String r105 = r104.next();     // Catch: Exception -> L16
            r102.put(r105, r103.opt(r105));     // Catch: JSONException -> L30 Exception -> L16
            goto L10
        L14:
            BdpAppBatchEventUtils.f200537a.e0();     // Catch: Exception -> L16
        L18:
            r100 = r100 + 1;
        L16:
            e = move-exception;
            g94.b.b("BdpAppBatchEventUtils", new Object[]{"#batchSendEventV3Impl (catch err) index=" + r100 + " nameParamsJa=" + this.f200546b + " commonParamsJo=" + this.f200545a, e});
        L19:
            Queue<JSONObject> r106 = BdpAppBatchEventUtils.f200539c;
            monitor-enter(r106);
        L27:
            th = move-exception;
            throw th;
        L22:
            if (((ConcurrentLinkedQueue) r106).isEmpty() == false) goto L24;
            BdpAppBatchEventUtils.f200540d = null;     // Catch: Throwable -> L27
        L25:
            monitor-exit(r106);     // Catch: Throwable -> L27
            return;
        L24:
            BdpAppBatchEventUtils.f200540d = Integer.valueOf(new BdpTask.Builder().onCPU().delayedMillis(300).runnable(this).start());     // Catch: Throwable -> L27
            goto L25
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

        public RunnableC2888a(JSONObject r100, JSONArray r101) {
            this.f200545a = r100;
            this.f200546b = r101;
        }
    }

    public final void a() {
        String r100 = this.f200543a;
        g.f201338a.getClass();
        JSONObject r101 = new JSONObject(r100);     // Catch: Exception -> L5
    L6:
        String r102 = this.f200544b;
        g.f201338a.getClass();
        JSONArray r103 = new JSONArray(r102);     // Catch: Exception -> L9
    L10:
        int r104 = r103.length();
        int r105 = 0;
    L11:
        if (r105 >= r104) goto L16;
        JSONObject r106 = r103.optJSONObject(r105);
        if (r106 == null) goto L15;
        ((ConcurrentLinkedQueue) BdpAppBatchEventUtils.f200539c).offer(r106);
    L15:
        r105 = r105 + 1;
        goto L11
    L16:
        RunnableC2888a r107 = new RunnableC2888a(r101, r103);
        Queue<JSONObject> r108 = BdpAppBatchEventUtils.f200539c;
        monitor-enter(r108);
    L23:
        th = move-exception;
        throw th;
    L19:
        if (BdpAppBatchEventUtils.f200540d != null) goto L21;
        BdpAppBatchEventUtils.f200540d = Integer.valueOf(new BdpTask.Builder().onCPU().delayedMillis(10).runnable(r107).start());     // Catch: Throwable -> L23
    L21:
        monitor-exit(r108);     // Catch: Throwable -> L23
        return;
    L9:
        r103 = new JSONArray();
    L5:
        r101 = new JSONObject();
        goto L6
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

    public a(String r100, String r101) {
        this.f200543a = r100;
        this.f200544b = r101;
    }
}
