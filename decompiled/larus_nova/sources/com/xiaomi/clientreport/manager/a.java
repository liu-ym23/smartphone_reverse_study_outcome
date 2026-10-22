package com.xiaomi.clientreport.manager;

import android.content.Context;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.processor.IEventProcessor;
import com.xiaomi.clientreport.processor.IPerfProcessor;
import com.xiaomi.push.ad;
import com.xiaomi.push.ba;
import com.xiaomi.push.bh;
import com.xiaomi.push.bi;
import com.xiaomi.push.bj;
import com.xiaomi.push.bk;
import com.xiaomi.push.bl;
import com.xiaomi.push.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes41.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f463014a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static volatile a f130a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f131a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Config f132a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private IEventProcessor f133a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private IPerfProcessor f134a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String f135a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> f136a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ExecutorService f137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> f463015b;

    private int a() {
        HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> r100 = this.f463015b;
        if (r100 == null) goto L17;
        Iterator<String> r101 = r100.keySet().iterator();
        int r102 = 0;
    L6:
        if (r101.hasNext() == false) goto L13;
        String r103 = r101.next();
        ArrayList<com.xiaomi.clientreport.data.a> r104 = this.f463015b.get(r103);
        if (r104 == null) goto L10;
        int r105 = r104.size();
    L11:
        r102 = r102 + r105;
        goto L6
    L10:
        r105 = 0;
        goto L11
    L13:
        return r102;
    L17:
        return 0;
    }

    private int b() {
        HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> r100 = this.f136a;
        int r101 = 0;
        if (r100 == null) goto L15;
        Iterator<String> r102 = r100.keySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L15;
        String r103 = r102.next();
        HashMap<String, com.xiaomi.clientreport.data.a> r104 = this.f136a.get(r103);
        if (r104 == null) goto L6;
        Iterator<String> r105 = r104.keySet().iterator();
    L11:
        if (r105.hasNext() == false) goto L6;
        com.xiaomi.clientreport.data.a r106 = r104.get(r105.next());
        if ((r106 instanceof PerfClientReport) == false) goto L11;
        r101 = (int) (((long) r101) + ((PerfClientReport) r106).perfCounts);
    L15:
        return r101;
    }

    private void d() {
        this.f133a.b();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        b.d("we: " + e.getMessage());
    }

    private void e() {
        this.f134a.b();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        b.d("wp: " + e.getMessage());
    }

    private void f() {
        if (a(this.f131a).m8727a().isEventUploadSwitchOpen() == true) goto L5;
        return;
    L5:
        final bh r100 = new bh(this.f131a);
        int r101 = (int) a(this.f131a).m8727a().getEventUploadFrequency();
        if (r101 >= 1800) goto L9;
        r101 = 1800;
    L9:
        if ((System.currentTimeMillis() - bl.a(this.f131a).a("sp_client_report_status", "event_last_upload_time", 0)) <= (r101 * 1000)) goto L12;
        ad.a(this.f131a).a(new AnonymousClass5(this, r100), 10);
    L12:
        monitor-enter(a.class);
    L18:
        th = move-exception;
        throw th;
    L14:
        if (ad.a(this.f131a).a(r100, r101) == true) goto L16;
        ad.a(this.f131a).m8799a("100886");     // Catch: Throwable -> L18
        ad.a(this.f131a).a(r100, r101);     // Catch: Throwable -> L18
    L16:
        monitor-exit(a.class);     // Catch: Throwable -> L18
    }

    private void g() {
        if (a(this.f131a).m8727a().isPerfUploadSwitchOpen() == true) goto L5;
        return;
    L5:
        final bi r100 = new bi(this.f131a);
        int r101 = (int) a(this.f131a).m8727a().getPerfUploadFrequency();
        if (r101 >= 1800) goto L9;
        r101 = 1800;
    L9:
        if ((System.currentTimeMillis() - bl.a(this.f131a).a("sp_client_report_status", "perf_last_upload_time", 0)) <= (r101 * 1000)) goto L12;
        ad.a(this.f131a).a(new AnonymousClass6(this, r100), 15);
    L12:
        monitor-enter(a.class);
    L18:
        th = move-exception;
        throw th;
    L14:
        if (ad.a(this.f131a).a(r100, r101) == true) goto L16;
        ad.a(this.f131a).m8799a("100887");     // Catch: Throwable -> L18
        ad.a(this.f131a).a(r100, r101);     // Catch: Throwable -> L18
    L16:
        monitor-exit(a.class);     // Catch: Throwable -> L18
    }

    static {
        if (j.m9294a() == false) goto L5;
        int r100 = 30;
    L6:
        f463014a = r100;
        return;
    L5:
        r100 = 10;
        goto L6
    }

    public void c() {
        if (m8727a().isPerfUploadSwitchOpen() == false) goto L6;
        bj r100 = new bj();
        r100.a(this.f134a);
        r100.a(this.f131a);
        this.f137a.execute(r100);
        return;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized Config m8727a() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f132a != null) goto L6;
        this.f132a = Config.defaultConfig(this.f131a);     // Catch: Throwable -> L9
    L6:
        Config r100 = this.f132a;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r100;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public void m8729b() {
        if (m8727a().isEventUploadSwitchOpen() == false) goto L6;
        bj r100 = new bj();
        r100.a(this.f131a);
        r100.a(this.f133a);
        this.f137a.execute(r100);
        return;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m8728a() {
        a(this.f131a).f();
        a(this.f131a).g();
    }

    private a(Context r100) {
        this.f137a = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("ort/manager/a"));
        this.f136a = new HashMap();
        this.f463015b = new HashMap();
        this.f131a = r100;
    }

    public static a a(Context r100) {
        if (f130a != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f130a != null) goto L9;
        f130a = new a(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f130a;
    }

    private void b(EventClientReport r100) {
        IEventProcessor r101 = this.f133a;
        if (r101 == null) goto L9;
        r101.mo8730a(r100);
        if (a() < 10) goto L7;
        d();
        ad.a(this.f131a).m8799a("100888");
        return;
    L7:
        a(new AnonymousClass3(this), f463014a);
        return;
    }

    private void b(PerfClientReport r100) {
        IPerfProcessor r101 = this.f134a;
        if (r101 == null) goto L9;
        r101.mo8730a(r100);
        if (b() < 10) goto L7;
        e();
        ad.a(this.f131a).m8799a("100889");
        return;
    L7:
        a(new AnonymousClass4(this), f463014a);
        return;
    }

    public void a(final EventClientReport r100) {
        if (m8727a().isEventUploadSwitchOpen() == false) goto L6;
        this.f137a.execute(new AnonymousClass1(this, r100));
        return;
    }

    public static /* synthetic */ int b(a r100) {
        return r100.b();
    }

    public void a(final PerfClientReport r100) {
        if (m8727a().isPerfUploadSwitchOpen() == false) goto L6;
        this.f137a.execute(new AnonymousClass2(this, r100));
        return;
    }

    public static /* synthetic */ int a(a r100) {
        return r100.a();
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public static /* synthetic */ void m8726b(a r100) {
        r100.e();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static /* synthetic */ void m8725a(a r100) {
        r100.d();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static /* synthetic */ ExecutorService m8724a(a r100) {
        return r100.f137a;
    }

    public void a(String r100) {
        this.f135a = r100;
    }

    public EventClientReport a(int r100, String r101) {
        EventClientReport r102 = new EventClientReport();
        r102.eventContent = r101;
        r102.eventTime = System.currentTimeMillis();
        r102.eventType = r100;
        r102.eventId = ba.a(6);
        r102.production = 1000;
        r102.reportType = 1001;
        r102.clientInterfaceId = "E100004";
        r102.setAppPackageName(this.f131a.getPackageName());
        r102.setSdkVersion(this.f135a);
        return r102;
    }

    private void a(ad.a r100, int r101) {
        ad.a(this.f131a).b(r100, r101);
    }

    public static /* synthetic */ void a(a r100, EventClientReport r101) {
        r100.b(r101);
    }

    public static /* synthetic */ void a(a r100, PerfClientReport r101) {
        r100.b(r101);
    }

    public void a(Config r100, IEventProcessor r101, IPerfProcessor r102) {
        this.f132a = r100;
        this.f133a = r101;
        this.f134a = r102;
        r101.setEventMap(this.f463015b);
        this.f134a.setPerfMap(this.f136a);
    }

    public void a(boolean r100, boolean r101, long r102, long r110) {
        Config r103 = this.f132a;
        if (r103 != null) goto L5;
        return;
    L5:
        if (r100 == r103.isEventUploadSwitchOpen()) goto L7;
    L12:
        long r104 = this.f132a.getEventUploadFrequency();
        long r105 = this.f132a.getPerfUploadFrequency();
        Config r106 = Config.getBuilder().setAESKey(bk.a(this.f131a)).setEventEncrypted(this.f132a.isEventEncrypted()).setEventUploadSwitchOpen(r100).setEventUploadFrequency(r102).setPerfUploadSwitchOpen(r101).setPerfUploadFrequency(r110).build(this.f131a);
        this.f132a = r106;
        if (r106.isEventUploadSwitchOpen() == true) goto L16;
        ad.a(this.f131a).m8799a("100886");
    L19:
        if (this.f132a.isPerfUploadSwitchOpen() == true) goto L22;
        ad.a(this.f131a).m8799a("100887");
        return;
    L22:
        if (r105 == r106.getPerfUploadFrequency()) goto L28;
        b.c(this.f131a.getPackageName() + " reset perf job " + r106.getPerfUploadFrequency());
        g();
        return;
    L28:
        return;
    L16:
        if (r104 == r106.getEventUploadFrequency()) goto L19;
        b.c(this.f131a.getPackageName() + "reset event job " + r106.getEventUploadFrequency());
        f();
        goto L19
    L7:
        if (r101 != this.f132a.isPerfUploadSwitchOpen()) goto L12;
        if (r102 != this.f132a.getEventUploadFrequency()) goto L12;
        if (r110 != this.f132a.getPerfUploadFrequency()) goto L12;
    }
}
