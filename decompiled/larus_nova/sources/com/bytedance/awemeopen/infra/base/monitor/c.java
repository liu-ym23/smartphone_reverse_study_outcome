package com.bytedance.awemeopen.infra.base.monitor;

import com.bytedance.awemeopen.infra.base.log.AoLogger;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AoMonitor.MonitorType f198660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f198661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f198662c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ JSONObject f198663d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ JSONObject f198664e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f198665f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ JSONObject f198666g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ JSONObject f198667h;

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        AoMonitor.MonitorType r100 = this.f198660a;
        String r101 = this.f198661b;
        int r102 = this.f198662c;
        JSONObject r103 = this.f198663d;
        JSONObject r104 = this.f198664e;
        String r105 = this.f198665f;
        JSONObject r106 = this.f198666g;
        JSONObject r107 = this.f198667h;
        monitor-enter(AoMonitor.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (AoMonitor.f198649b == null) goto L7;
        AoMonitor.f198649b.add(new AoMonitor.b(r100, r101, r102, r103, r104, r105, r106, r107));     // Catch: Throwable -> L11
    L8:
        monitor-exit(AoMonitor.class);
        return null;
    L7:
        AoLogger.c("AoAppMonitor", new Object[]{"queueCacheItem error"});     // Catch: Throwable -> L11
        goto L8
    }

    public c(AoMonitor.MonitorType r100, String r101, int r102, JSONObject r103, JSONObject r104, JSONObject r105) {
        this.f198660a = r100;
        this.f198661b = r101;
        this.f198662c = r102;
        this.f198663d = null;
        this.f198664e = r103;
        this.f198665f = null;
        this.f198666g = r104;
        this.f198667h = r105;
    }
}
