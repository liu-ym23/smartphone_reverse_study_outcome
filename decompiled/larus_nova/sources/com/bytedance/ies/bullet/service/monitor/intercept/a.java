package com.bytedance.ies.bullet.service.monitor.intercept;

import com.bytedance.ies.bullet.service.base.b;
import com.bytedance.ies.bullet.service.base.r;
import com.bytedance.ies.bullet.service.monitor.MonitorReportService;
import fz2.d;
import kotlin.Lazy;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f247980a = null;

    static {
        f247980a = new a();
    }

    public a() {
    }

    @Override // fz2.d
    public final void a(String r100, String r101, JSONObject r102) {
        JSONObject r103 = r102.optJSONObject("extra");
        if (r103 == null) goto L7;
        JSONObject r104 = r103.optJSONObject("client_category");
        if (r104 == null) goto L7;
        String r105 = r104.optString("_bid");
    L8:
        if (r105 != null) goto L10;
        r105 = "default_bid";
    L10:
        s26.d r106 = s26.d.f540305c;
        r r107 = (r) s26.d.f540305c.d(r105, r.class);
        if (r107 != null) goto L13;
        Lazy<MonitorReportService> r108 = MonitorReportService.f247964d;
        r107 = MonitorReportService.a.a();
    L13:
        b r109 = r107.getMonitorConfig().f247900f;
        return;
    L7:
        r105 = null;
        goto L8
    }
}
