package com.bytedance.reparo.core.common.event;

import android.os.SystemClock;
import com.alipay.sdk.m.u.i;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.reparo.core.exception.PatchException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import v87.a;
import w87.d;
import w87.e;

/* JADX INFO: loaded from: classes3.dex */
public final class Event {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static volatile String f267340o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static volatile Boolean f267341p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f267342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f267343b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f267344c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f267345d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f267346e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f267347f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f267348g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f267349h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public PatchException f267350i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f267351j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public HashMap<String, Object> f267352k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public HashMap<String, Object> f267353l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public HashMap<String, Object> f267354m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public a f267355n;

    /* JADX INFO: loaded from: classes21.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface EventType {
        public static final int TYPE_ERROR_EXCEPTION = 2;
        public static final int TYPE_ERROR_MSG = 1;
        public static final int TYPE_MSG = 0;
    }

    public final JSONObject b() throws JSONException {
        JSONObject r100 = new JSONObject();
        r100.putOpt("is_success", Boolean.valueOf(this.f267348g));
        r100.putOpt(LocationMonitorConst.IS_MAIN_PROCESS, d.a(f267341p));
        HashMap<String, Object> r101 = this.f267353l;
        if (r101 != null) goto L5;
    L11:
        return r100;
    L5:
        if (r101.size() == 0) goto L11;
        Iterator<Map.Entry<String, Object>> r102 = this.f267353l.entrySet().iterator();
    L9:
        if (r102.hasNext() == false) goto L11;
        Map.Entry<String, Object> r103 = r102.next();
        r100.putOpt(r103.getKey(), r103.getValue());
        goto L9
    }

    public final JSONObject c() throws JSONException {
        JSONObject r100 = new JSONObject();
        r100.putOpt("process_name", d.a(f267340o));
        r100.putOpt("tag", d.a(this.f267342a));
        r100.putOpt("step", d.a(this.f267344c));
        r100.putOpt("step_desc", d.a(""));
        long r101 = this.f267345d;
        if (r101 != (-1)) goto L5;
        Object r102 = "";
    L6:
        r100.putOpt(ILoadStallMonitor.START_TIME, r102);
        long r103 = this.f267346e;
        if (r103 != (-1)) goto L9;
        Object r104 = "";
    L10:
        r100.putOpt("end_time", r104);
        int r105 = this.f267343b;
        if (r105 != 2) goto L14;
        r100.putOpt("error_msg", e.a(this.f267350i));
    L18:
        HashMap<String, Object> r106 = this.f267354m;
        if (r106 != null) goto L21;
    L27:
        return r100;
    L21:
        if (r106.size() == 0) goto L27;
        Iterator<Map.Entry<String, Object>> r107 = this.f267354m.entrySet().iterator();
    L25:
        if (r107.hasNext() == false) goto L27;
        Map.Entry<String, Object> r108 = r107.next();
        r100.putOpt(r108.getKey(), r108.getValue());
        goto L25
    L14:
        if (r105 != 1) goto L16;
        r100.putOpt("error_msg", d.a(""));
        goto L18
    L16:
        if (r105 != 0) goto L18;
        r100.putOpt("msg", d.a(this.f267351j));
        goto L18
    L9:
        r104 = Long.valueOf(r103);
        goto L10
    L5:
        r102 = Long.valueOf(r101);
        goto L6
    }

    public final JSONObject d() throws JSONException {
        JSONObject r100 = new JSONObject();
        if (this.f267347f == false) goto L7;
        long r101 = this.f267345d;
        if (r101 == (-1)) goto L7;
        r100.putOpt("duration", Long.valueOf(this.f267346e - r101));
    L7:
        HashMap<String, Object> r102 = this.f267352k;
        if (r102 != null) goto L10;
    L16:
        return r100;
    L10:
        if (r102.size() == 0) goto L16;
        Iterator<Map.Entry<String, Object>> r103 = this.f267352k.entrySet().iterator();
    L14:
        if (r103.hasNext() == false) goto L16;
        Map.Entry<String, Object> r104 = r103.next();
        r100.putOpt(r104.getKey(), r104.getValue());
        goto L14
    }

    public final HashMap<String, Object> f() {
        if (this.f267353l != null) goto L6;
        this.f267353l = new HashMap();
    L6:
        return this.f267353l;
    }

    public final long g() {
        if (this.f267347f == true) goto L5;
    L11:
        return -1;
    L5:
        if (this.f267345d == (-1)) goto L11;
        if (this.f267346e != (-1)) goto L10;
        this.f267346e = SystemClock.elapsedRealtime();
    L10:
        return this.f267346e - this.f267345d;
    }

    public final String h() {
        int r100 = this.f267343b;
        if (r100 != 2) goto L7;
        return e.a(this.f267350i);
    L7:
        if (r100 == 1) goto L9;
        return "";
    L9:
        return d.a("");
    }

    public final void j() {
        if (this.f267355n != null) goto L6;
        return;
    L6:
        if (this.f267347f == true) goto L8;
    L12:
        this.f267355n.a(this);
        return;
    L8:
        if (this.f267345d == (-1)) goto L12;
        if (this.f267346e != (-1)) goto L12;
        this.f267346e = SystemClock.elapsedRealtime();
        goto L12
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append("{    \n");
        a(r100, "tag", this.f267342a, false);
        int r101 = this.f267343b;
        if (r101 != 0) goto L5;
        String r102 = "msg";
    L11:
        a(r100, "event_type", r102, false);
        a(r100, "step", this.f267344c, false);
        a(r100, "step_desc", "", false);
        a(r100, ILoadStallMonitor.START_TIME, Long.valueOf(this.f267345d), false);
        a(r100, "end_time", Long.valueOf(this.f267346e), false);
        a(r100, "collectDuration", Boolean.valueOf(this.f267347f), false);
        a(r100, "is_success", Boolean.valueOf(this.f267348g), false);
        a(r100, "msg", this.f267351j, false);
        a(r100, "error_msg", "", false);
        a(r100, "metrics_map", this.f267352k, false);
        a(r100, "category_map", this.f267353l, false);
        a(r100, "extra_map", this.f267354m, false);
        a(r100, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION, this.f267350i, true);
        r100.append(i.f25855d);
        return r100.toString();
    L5:
        if (r101 != 1) goto L8;
        r102 = "error_msg";
        goto L11
    L8:
        if (r101 != 2) goto L10;
        r102 = "error_exception";
        goto L11
    L10:
        r102 = "";
        goto L11
    }

    public Event() {
        this.f267342a = "";
        this.f267343b = 0;
        this.f267344c = "";
        this.f267345d = -1;
        this.f267346e = -1;
        this.f267347f = false;
        this.f267348g = true;
        this.f267349h = 0;
        this.f267350i = null;
        this.f267351j = "";
        this.f267355n = null;
        this.f267346e = SystemClock.elapsedRealtime();
    }

    public final void e(PatchException r100) {
        this.f267350i = r100;
        this.f267349h = r100.getErrorCode();
    }

    public final void i(String r100, Object r101) {
        f().put(r100, r101);
    }

    public static void a(StringBuilder r100, String r101, Object r102, boolean r103) {
        r100.append("\"");
        r100.append(r101);
        r100.append("\"");
        r100.append(":");
        r100.append("\"");
        r100.append(r102);
        r100.append("\"");
        if (r103 == false) goto L5;
        r100.append("\n");
        return;
    L5:
        r100.append(",\n");
    }
}
