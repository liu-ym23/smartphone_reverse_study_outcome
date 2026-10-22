package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.manager.ClientReportClient;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public class dr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f463408a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static Map<String, go> f455a;

    public interface a {
        void uploader(Context r100, gi r101);
    }

    public static int a(int r100) {
        if (r100 > 0) goto L6;
        return -1;
    L6:
        return r100 + 1000;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static String m9025a(int r100) {
        if (r100 != 1000) goto L7;
        return "E100000";
    L7:
        if (r100 != 3000) goto L11;
        return "E100002";
    L11:
        if (r100 != 2000) goto L15;
        return "E100001";
    L15:
        if (r100 != 6000) goto L18;
        return "E100003";
    L18:
        return "";
    }

    public static PerfClientReport a() {
        PerfClientReport r100 = new PerfClientReport();
        r100.production = 1000;
        r100.reportType = 1000;
        r100.clientInterfaceId = "P100000";
        return r100;
    }

    public static Config a(Context r100) {
        boolean r101 = com.xiaomi.push.service.ah.a(r100).a(gj.aA.a(), false);
        boolean r102 = com.xiaomi.push.service.ah.a(r100).a(gj.aU.a(), false);
        return Config.getBuilder().setEventUploadSwitchOpen(r102).setEventUploadFrequency(com.xiaomi.push.service.ah.a(r100).a(gj.aB.a(), 86400)).setPerfUploadSwitchOpen(r101).setPerfUploadFrequency(com.xiaomi.push.service.ah.a(r100).a(gj.aC.a(), 86400)).build(r100);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static go m9024a(String r100) {
        if (f455a == null) goto L5;
    L16:
        go r101 = f455a.get(r100.toLowerCase());
        if (r101 == null) goto L20;
        return r101;
    L20:
        return go.f463801a;
    L5:
        monitor-enter(go.class);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (f455a != null) goto L11;
        f455a = new HashMap();     // Catch: Throwable -> L13
        go[] r102 = go.values();     // Catch: Throwable -> L13
        int r103 = r102.length;     // Catch: Throwable -> L13
        int r104 = 0;
    L9:
        if (r104 >= r103) goto L11;
        go r105 = r102[r104];     // Catch: Throwable -> L13
        f455a.put(r105.f650a.toLowerCase(), r105);     // Catch: Throwable -> L13
        r104 = r104 + 1;     // Catch: Throwable -> L13
    L11:
        monitor-exit(go.class);     // Catch: Throwable -> L13
        goto L16
    }

    public static int a(Enum r100) {
        if (r100 != null) goto L4;
    L12:
        return -1;
    L4:
        if ((r100 instanceof ge) == false) goto L7;
        return r100.ordinal() + 1001;
    L7:
        if ((r100 instanceof go) == false) goto L10;
        return r100.ordinal() + 2001;
    L10:
        if ((r100 instanceof ec) == false) goto L12;
        return r100.ordinal() + 3001;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m9027a(Context r100) {
        if (r100 != null) goto L4;
    L8:
        return false;
    L4:
        if (TextUtils.isEmpty(r100.getPackageName()) == true) goto L8;
        if ("com.xiaomi.xmsf".equals(r100.getPackageName()) == false) goto L8;
        return true;
    }

    public static EventClientReport a(String r100) {
        EventClientReport r101 = new EventClientReport();
        r101.production = 1000;
        r101.reportType = 1001;
        r101.clientInterfaceId = r100;
        return r101;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m9026a(Context r100) {
        ClientReportClient.updateConfig(r100, a(r100));
    }

    public static void a(a r100) {
        f463408a = r100;
    }

    public static gi a(Context r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L6;
        return null;
    L6:
        gi r102 = new gi();
        r102.d("category_client_report_data");
        r102.a("push_sdk_channel");
        r102.a(1);
        r102.b(r101);
        r102.a(true);
        r102.b(System.currentTimeMillis());
        r102.g(r100.getPackageName());
        r102.e("com.xiaomi.xmsf");
        r102.f(com.xiaomi.push.service.az.a());
        r102.c("quality_support");
        return r102;
    }

    public static void a(Context r100, List<String> r101) {
        if (r101 != null) goto L15;
        return;
    L15:
        Iterator<String> r102 = r101.iterator();     // Catch: Throwable -> L12
    L6:
        if (r102.hasNext() == false) goto L23;
        gi r103 = a(r100, r102.next());     // Catch: Throwable -> L12
        if (com.xiaomi.push.service.az.a(r103, false) == true) goto L6;
        a(r100, r103);     // Catch: Throwable -> L12
        goto L6
    L23:
        return;
    L12:
        th = move-exception;
        com.xiaomi.channel.commonutils.logger.b.d(th.getMessage());
    }

    private static void a(Context r100, gi r101) {
        if (m9027a(r100.getApplicationContext()) == false) goto L5;
        com.xiaomi.push.service.ba.a(r100.getApplicationContext(), r101);
        return;
    L5:
        a r102 = f463408a;
        if (r102 == null) goto L10;
        r102.uploader(r100, r101);
        return;
    }

    public static void a(Context r100, Config r101) {
        ClientReportClient.init(r100, r101, new dp(r100), new dq(r100));
    }

    public static PerfClientReport a(Context r100, int r101, long r102, long r103) {
        PerfClientReport r104 = a();
        r104.code = r101;
        r104.perfCounts = r102;
        r104.perfLatencies = r103;
        return r104;
    }

    public static EventClientReport a(Context r100, String r101, String r102, int r103, long r104, String r105) {
        EventClientReport r106 = a(r101);
        r106.eventId = r102;
        r106.eventType = r103;
        r106.eventTime = r104;
        r106.eventContent = r105;
        return r106;
    }
}
