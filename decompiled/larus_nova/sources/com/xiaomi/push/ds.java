package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.manager.ClientReportClient;

/* JADX INFO: loaded from: classes41.dex */
public class ds {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile ds f463409a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f456a;

    private ds(Context r100) {
        this.f456a = r100;
    }

    public static ds a(Context r100) {
        if (f463409a != null) goto L15;
        monitor-enter(ds.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f463409a != null) goto L9;
        f463409a = new ds(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(ds.class);     // Catch: Throwable -> L11
    L15:
        return f463409a;
    }

    private void a(com.xiaomi.clientreport.data.a r100) {
        if ((r100 instanceof PerfClientReport) == false) goto L6;
        ClientReportClient.reportPerf(this.f456a, (PerfClientReport) r100);
        return;
    L6:
        if ((r100 instanceof EventClientReport) == false) goto L10;
        ClientReportClient.reportEvent(this.f456a, (EventClientReport) r100);
        return;
    }

    public void a(String r110, Intent r111, String r112) {
        if (r111 != null) goto L4;
        return;
    L4:
        String r100 = r111.getStringExtra("messageId");
        a(r110, dr.m9025a(r111.getIntExtra("eventMessageType", -1)), r100, 5001, System.currentTimeMillis(), r112);
    }

    public void a(String r110, int r111, long r112, long r113) {
        if (r111 >= 0) goto L4;
        return;
    L4:
        if (r113 >= 0) goto L6;
        return;
    L6:
        if (r112 <= 0) goto L12;
        PerfClientReport r114 = dr.a(this.f456a, r111, r112, r113);
        r114.setAppPackageName(r110);
        r114.setSdkVersion(BuildConfig.VERSION_NAME);
        a(r114);
        return;
    }

    public void b(String r100, String r110, String r111, String r112) {
        a(r100, r110, r111, 5001, System.currentTimeMillis(), r112);
    }

    public void c(String r100, String r110, String r111, String r112) {
        a(r100, r110, r111, 4002, System.currentTimeMillis(), r112);
    }

    public void a(String r110, Intent r111, int r112, String r113) {
        if (r111 != null) goto L4;
        return;
    L4:
        String r100 = r111.getStringExtra("messageId");
        a(r110, dr.m9025a(r111.getIntExtra("eventMessageType", -1)), r100, r112, System.currentTimeMillis(), r113);
    }

    public void a(String r100, String r110, String r111, String r112) {
        a(r100, r110, r111, 5002, System.currentTimeMillis(), r112);
    }

    public void a(String r100, String r110, String r111, int r112, String r113) {
        a(r100, r110, r111, r112, System.currentTimeMillis(), r113);
    }

    public void a(String r100, String r110, String r111, int r112, long r113, String r114) {
        if (TextUtils.isEmpty(r110) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r111) == true) goto L10;
        EventClientReport r115 = dr.a(this.f456a, r110, r111, r112, r113, r114);
        r115.setAppPackageName(r100);
        r115.setSdkVersion(BuildConfig.VERSION_NAME);
        a(r115);
        return;
    }
}
