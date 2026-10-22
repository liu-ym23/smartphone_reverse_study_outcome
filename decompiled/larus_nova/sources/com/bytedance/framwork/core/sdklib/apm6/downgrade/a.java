package com.bytedance.framwork.core.sdklib.apm6.downgrade;

import by5.n;
import com.heytap.mcssdk.constant.b;
import com.optimize.statistics.FrescoMonitorConst;
import fy5.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile DowngradeInfo f244859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public cy5.a f244860b;

    /* JADX INFO: renamed from: com.bytedance.framwork.core.sdklib.apm6.downgrade.a$a, reason: collision with other inner class name */
    public static class C3505a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f244861a = null;

        static {
            f244861a = new a();
        }
    }

    public a() {
    }

    public final void a(DowngradeInfo r100, boolean r101) {
        if (r100 == null) goto L25;
        monitor-enter(this);
        this.f244859a = r100;     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
        if (r101 == false) goto L32;
        cy5.a r102 = this.f244860b;
        if (r102 != null) goto L10;
        return;
    L10:
        if (r102.f465788a == null) goto L34;
        JSONObject r103 = new JSONObject();     // Catch: JSONException -> L16
        r103.put("expire_time", r100.f244854a);     // Catch: JSONException -> L16
        Iterator r104 = ((HashMap) r100.f244855b).entrySet().iterator();     // Catch: JSONException -> L16
    L13:
        if (r104.hasNext() == false) goto L17;
        Map.Entry r105 = (Map.Entry) r104.next();     // Catch: JSONException -> L16
        r103.put(((DowngradeInfo.LogType) r105.getKey()).logType, ((DowngradeInfo.a) r105.getValue()).b());     // Catch: JSONException -> L16
    L17:
        if (r103 == null) goto L35;
        String r106 = r103.toString();
        if (n.f21462e == false) goto L21;
        c.d("SDK-Downgrade", "DowngradeData-save-" + r106);
    L21:
        r102.f465788a.edit().putString(b.f276366p, r106).apply();
        return;
    L35:
        return;
    L16:
        r103 = null;
        goto L17
    L34:
        return;
    L32:
        return;
    L22:
        th = move-exception;
        throw th;
    }

    public final boolean b(JSONObject r100, int r101) {
        boolean r102 = true;
        if (this.f244859a != null) goto L5;
    L52:
        return true;
    L5:
        if (System.currentTimeMillis() > this.f244859a.f244854a) goto L52;
        String r103 = String.valueOf(r101);
        String r104 = r100.optString(FrescoMonitorConst.LOG_TYPE);
        DowngradeInfo.LogType r105 = DowngradeInfo.LogType.SERVICE_MONITOR;
        if (r105.logType.equals(r104) == false) goto L31;
        String r106 = r100.optString("service");
        monitor-enter(this);
        DowngradeInfo.a r107 = (DowngradeInfo.a) ((HashMap) this.f244859a.f244855b).get(r105);     // Catch: Throwable -> L28
        if (r107 == null) goto L26;
        JSONObject r108 = (JSONObject) ((HashMap) r107.f244858b).get(r103);     // Catch: Throwable -> L28
        if (r108 != null) goto L16;
    L23:
        boolean r109 = r107.f244857a;     // Catch: Throwable -> L28
        monitor-exit(this);     // Catch: Throwable -> L28
        return r109;
    L16:
        if (r108.optInt(r106, -1) == (-1)) goto L23;
        if (r108.optInt(r106, -1) == 1) goto L21;
        r102 = false;
    L21:
        monitor-exit(this);     // Catch: Throwable -> L28
        return r102;
    L26:
        monitor-exit(this);     // Catch: Throwable -> L28
    L48:
        return true;
    L28:
        th = move-exception;
        throw th;
    L31:
        monitor-enter(this);
        Map<DowngradeInfo.LogType, DowngradeInfo.a> r110 = this.f244859a.f244855b;     // Catch: Throwable -> L49
        HashMap r111 = (HashMap) r110;     // Catch: Throwable -> L49
        DowngradeInfo.a r112 = (DowngradeInfo.a) r111.get(DowngradeInfo.LogType.OTHER_LOG_TYPE);     // Catch: Throwable -> L49
        if (r112 == null) goto L47;
        JSONObject r113 = (JSONObject) ((HashMap) r112.f244858b).get(r103);     // Catch: Throwable -> L49
        if (r113 != null) goto L37;
    L44:
        boolean r114 = r112.f244857a;     // Catch: Throwable -> L49
        monitor-exit(this);     // Catch: Throwable -> L49
        return r114;
    L37:
        if (r113.optInt(r104, -1) == (-1)) goto L44;
        if (r113.optInt(r104, -1) == 1) goto L42;
        r102 = false;
    L42:
        monitor-exit(this);     // Catch: Throwable -> L49
        return r102;
    L47:
        monitor-exit(this);     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        throw th;
    }
}
