package com.bytedance.bdp.appbase.base.monitor;

import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BdpAppMonitor.MonitorType f200610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f200611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f200612c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ JSONObject f200613d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ JSONObject f200614e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f200615f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ JSONObject f200616g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ JSONObject f200617h;

    public final void a() {
        BdpAppMonitor.MonitorType r100 = this.f200610a;
        String r101 = this.f200611b;
        int r102 = this.f200612c;
        JSONObject r103 = this.f200613d;
        JSONObject r104 = this.f200614e;
        String r105 = this.f200615f;
        JSONObject r106 = this.f200616g;
        JSONObject r107 = this.f200617h;
        monitor-enter(BdpAppMonitor.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (BdpAppMonitor.f200606d == null) goto L7;
        BdpAppMonitor.f200606d.add(new BdpAppMonitor.b(r100, r101, r102, r103, r104, r105, r106, r107));     // Catch: Throwable -> L10
    L8:
        monitor-exit(BdpAppMonitor.class);
        return;
    L7:
        g94.b.b("BdpAppMonitor", new Object[]{"queueCacheItem error"});     // Catch: Throwable -> L10
        goto L8
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

    public c(BdpAppMonitor.MonitorType r100, String r101, int r102, JSONObject r103, JSONObject r104, JSONObject r105) {
        this.f200610a = r100;
        this.f200611b = r101;
        this.f200612c = r102;
        this.f200613d = null;
        this.f200614e = r103;
        this.f200615f = null;
        this.f200616g = r104;
        this.f200617h = r105;
    }
}
