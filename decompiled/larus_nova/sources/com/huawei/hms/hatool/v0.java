package com.huawei.hms.hatool;

import android.content.Context;
import android.util.Pair;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public class v0 implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f277466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f277467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f277468c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f277469d;

    public v0(String r100, String r101, String r102) {
        this.f277466a = q0.i();
        this.f277467b = r100;
        this.f277468c = r101;
        this.f277469d = r102;
    }

    private void a(String r100, List<b1> r101) {
        Pair<String, String> r102 = n1.a(r100);
        new u(r101, (String) r102.first, (String) r102.second, this.f277469d).a();
    }

    @Override // java.lang.Runnable
    public void run() {
        v.a("hmsSdk", "eventReportTask is running");
        boolean r100 = c0.a(this.f277466a);
        if (r100 == false) goto L46;
        v.c("hmsSdk", "workKey is refresh,begin report all data");
        this.f277468c = "alltype";
    L46:
        Map<String, List<b1>> r101 = c1.a(this.f277466a, this.f277467b, this.f277468c);     // Catch: Throwable -> L24 Exception -> L26 IllegalArgumentException -> L32
        if (r101.size() == 0) goto L9;
        Iterator<Map.Entry<String, List<b1>>> r102 = r101.entrySet().iterator();     // Catch: Throwable -> L24 Exception -> L26 IllegalArgumentException -> L32
    L17:
        if (r102.hasNext() == false) goto L21;
        Map.Entry<String, List<b1>> r103 = r102.next();     // Catch: Throwable -> L24 Exception -> L26 IllegalArgumentException -> L32
        a(r103.getKey(), r103.getValue());     // Catch: Throwable -> L24 Exception -> L26 IllegalArgumentException -> L32
        goto L17
    L21:
        if ("alltype".equals(this.f277468c) == false) goto L23;
        d.a(this.f277466a, "stat_v2_1", new String[0]);
        d.a(this.f277466a, "cached_v2_1", new String[0]);
    L38:
        if (r100 == false) goto L49;
        v.c("hmsSdk", "refresh local key");
        o0.d().b();
        return;
    L49:
        return;
    L23:
        String r104 = n1.a(this.f277467b, this.f277468c);
        d.a(this.f277466a, "stat_v2_1", new String[]{r104});
        d.a(this.f277466a, "cached_v2_1", new String[]{r104});
        goto L38
    L9:
        v.b("hmsSdk", "no events to report, tag: %s, type: %s", new Object[]{this.f277467b, this.f277468c});     // Catch: Throwable -> L24 Exception -> L26 IllegalArgumentException -> L32
        if ("alltype".equals(this.f277468c) == false) goto L13;
        d.a(this.f277466a, "stat_v2_1", new String[0]);
        d.a(this.f277466a, "cached_v2_1", new String[0]);
        return;
    L13:
        String r105 = n1.a(this.f277467b, this.f277468c);
        d.a(this.f277466a, "stat_v2_1", new String[]{r105});
        d.a(this.f277466a, "cached_v2_1", new String[]{r105});
        return;
    L24:
        th = move-exception;
        if ("alltype".equals(this.f277468c) == false) goto L44;
        d.a(this.f277466a, "stat_v2_1", new String[0]);
        d.a(this.f277466a, "cached_v2_1", new String[0]);
    L45:
        throw th;
    L44:
        String r106 = n1.a(this.f277467b, this.f277468c);
        d.a(this.f277466a, "stat_v2_1", new String[]{r106});
        d.a(this.f277466a, "cached_v2_1", new String[]{r106});
    L32:
        e = move-exception;
        v.e("hmsSdk", "readEventRecords handData IllegalArgumentException:" + e.getMessage());     // Catch: Throwable -> L24
        if ("alltype".equals(this.f277468c) == false) goto L37;
        d.a(this.f277466a, "stat_v2_1", new String[0]);
        d.a(this.f277466a, "cached_v2_1", new String[0]);
        goto L38
    L37:
        String r107 = n1.a(this.f277467b, this.f277468c);
        d.a(this.f277466a, "stat_v2_1", new String[]{r107});
        d.a(this.f277466a, "cached_v2_1", new String[]{r107});
    L26:
        e = move-exception;
        v.e("hmsSdk", "readEventRecords handData Exception:" + e.getMessage());     // Catch: Throwable -> L24
        if ("alltype".equals(this.f277468c) == false) goto L31;
        d.a(this.f277466a, "stat_v2_1", new String[0]);
        d.a(this.f277466a, "cached_v2_1", new String[0]);
        goto L38
    L31:
        String r108 = n1.a(this.f277467b, this.f277468c);
        d.a(this.f277466a, "stat_v2_1", new String[]{r108});
        d.a(this.f277466a, "cached_v2_1", new String[]{r108});
        goto L38
    }
}
