package com.ss.android.ugc.route_monitor.impl;

import android.os.SystemClock;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import ihc.o;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public abstract class b implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f454404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f454405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f454406c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f454407d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f454408e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f454409f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f454410g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, Object> f454411h;

    @Override // ihc.o
    public final JSONObject c() {
        JSONObject r100 = new JSONObject();
        r100.put("name", this.f454404a);
        r100.put("occurred_page", this.f454405b);
        r100.put("describe", this.f454408e);
        r100.put("stage_start_time", this.f454406c);
        r100.put("total_cost_time", this.f454410g);
        r100.put(HiAnalyticsConstant.BI_KEY_COST_TIME, this.f454407d);
        r100.put("app_is_foreground", this.f454409f);
        JSONObject r101 = new JSONObject();
        Iterator r102 = ((ConcurrentHashMap) this.f454411h).entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Map.Entry r103 = (Map.Entry) r102.next();
        r101.put((String) r103.getKey(), r103.getValue());
        goto L4
    L6:
        r100.put("extra_data", r101);
        return r100;
    }

    public final String toString() {
        return "BasicStage(stageName='" + this.f454404a + "', describe='" + this.f454408e + "', timestamp=" + this.f454406c + ')';
    }

    @Override // ihc.o
    public final String a() {
        return this.f454405b;
    }

    @Override // ihc.o
    public final String getDescribe() {
        return this.f454408e;
    }

    @Override // ihc.o
    public final long getTimestamp() {
        return this.f454406c;
    }

    public b(String r100) {
        this.f454404a = r100;
        this.f454405b = "";
        this.f454406c = SystemClock.uptimeMillis();
        this.f454408e = "";
        this.f454409f = com.ss.android.ugc.route_monitor.utils.c.t();
        this.f454411h = new ConcurrentHashMap();
    }

    @Override // ihc.o
    public final void b(long r100) {
        this.f454407d = r100;
    }
}
