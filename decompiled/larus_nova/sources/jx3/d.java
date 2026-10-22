package jx3;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.bytedance.applog.monitor.v3.StageEventType;
import com.optimize.statistics.FrescoMonitorConst;
import com.ss.android.dypay.api.DyPayConstant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends a {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f500797y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f500798z;

    @Override // jx3.a
    public final String j() {
        return "event_misc";
    }

    @Override // jx3.a
    public final String g() {
        return "logType:" + this.f500798z;
    }

    @Override // jx3.a
    public final JSONObject r() throws JSONException {
        JSONObject r100 = new JSONObject();
        r100.put("local_time_ms", this.f500758b);
        r100.put("tea_event_index", this.f500759c);
        r100.put("session_id", this.f500760d);
        c(r100);
        if (TextUtils.isEmpty(this.f500763g) == true) goto L5;
        r100.put(DyPayConstant.KEY_USER_UNIQUE_ID, this.f500763g);
    L5:
        r100.put(FrescoMonitorConst.LOG_TYPE, this.f500798z);
        JSONObject r101 = new JSONObject(this.f500797y);     // Catch: Exception -> L14
        Iterator<String> r102 = r101.keys();     // Catch: Exception -> L14
    L7:
        if (r102.hasNext() == false) goto L16;
        String r103 = r102.next();     // Catch: Exception -> L14
        Object r104 = r101.get(r103);     // Catch: Exception -> L14
        if (r100.opt(r103) == null) goto L12;
        i().f(4, this.f500776t, "misc event exists key already!", new Object[0]);     // Catch: Exception -> L14
    L12:
        r100.put(r103, r104);     // Catch: Exception -> L14
    L16:
        long r105 = this.f500773q;
        if (r105 <= 0) goto L19;
        r100.put("event_id", r105);
    L19:
        long r106 = this.f500774r;
        if (r106 <= 0) goto L22;
        r100.put("monitor_id", String.valueOf(r106));
    L22:
        int r107 = this.f500775s;
        if (r107 <= 0) goto L25;
        r100.put("event_stained", r107);
    L25:
        return r100;
    L14:
        e = move-exception;
        i().o(4, "parse misc event params failed", e, new Object[0]);
        goto L16
    }

    @Override // jx3.a
    public final List<String> e() {
        List<String> r100 = super.e();
        ArrayList r101 = new ArrayList(r100.size());
        r101.addAll(r100);
        r101.addAll(Arrays.asList(new String[]{"params", "varchar", FrescoMonitorConst.LOG_TYPE, "varchar"}));
        return r101;
    }

    @Override // jx3.a
    public final String f() {
        return this.f500797y;
    }

    @Override // jx3.a
    public final String h() {
        return this.f500798z;
    }

    @Override // jx3.a
    public final void k(Cursor r100) {
        super.k(r100);
        this.f500797y = r100.getString(18);
        this.f500798z = r100.getString(19);
    }

    @Override // jx3.a
    public final a l(JSONObject r100) {
        super.l(r100);
        this.f500797y = r100.optString("params", null);
        this.f500798z = r100.optString(FrescoMonitorConst.LOG_TYPE, null);
        return this;
    }

    @Override // jx3.a
    public final void p(ContentValues r100) {
        super.p(r100);
        if (mw3.d.f515934a == false) goto L5;
        String r101 = this.f500769m;
        StageEventType r102 = StageEventType.V3_EVENT;
        r100.put("params", mw3.c.c(r101, this.f500797y));
    L6:
        r100.put(FrescoMonitorConst.LOG_TYPE, this.f500798z);
        return;
    L5:
        r100.put("params", this.f500797y);
        goto L6
    }

    @Override // jx3.a
    public final void q(JSONObject r100) throws JSONException {
        super.q(r100);
        r100.put("params", this.f500797y);
        r100.put(FrescoMonitorConst.LOG_TYPE, this.f500798z);
    }

    public d(String r100, String r101, JSONObject r102) {
        this.f500798z = r101;
        this.f500797y = r102.toString();
        this.f500769m = r100;
    }
}
