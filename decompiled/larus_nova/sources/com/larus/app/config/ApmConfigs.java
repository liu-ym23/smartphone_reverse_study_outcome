package com.larus.app.config;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.larus.apm.api.IApmConfigs;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0001\n\u0002\b\n\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0014\u0010\u000e\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0007¨\u0006\u001b"}, d2 = {"Lcom/larus/app/config/ApmConfigs;", "Lcom/larus/apm/api/IApmConfigs;", "<init>", "()V", "npthJavaCrashUploadUrl", "", "getNpthJavaCrashUploadUrl", "()Ljava/lang/String;", "npthLaunchCrashUploadUrl", "getNpthLaunchCrashUploadUrl", "npthNativeCrashUploadUrl", "getNpthNativeCrashUploadUrl", "npthAlogUploadUrl", "getNpthAlogUploadUrl", "npthConfigGetUrl", "getNpthConfigGetUrl", "monConfigUrls", "", "getMonConfigUrls", "()Ljava/lang/Void;", "monReportUrls", "getMonReportUrls", "monExceptionReportUrls", "getMonExceptionReportUrls", "hybridMonitorHost", "getHybridMonitorHost", "Companion", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ApmConfigs implements IApmConfigs {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f286980g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f286981h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f286982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f286983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f286984c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f286985d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f286986e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f286987f;

    public static final class a {
    }

    @Override // com.larus.apm.api.IApmConfigs
    public final /* bridge */ /* synthetic */ void b() {
    }

    @Override // com.larus.apm.api.IApmConfigs
    public final /* bridge */ /* synthetic */ void e() {
    }

    @Override // com.larus.apm.api.IApmConfigs
    public final /* bridge */ /* synthetic */ void g() {
    }

    static {
        new ArrayList();
        new ArrayList();
        new ArrayList();
        f286980g = ReportConstant.DEFAULT_URL_RULES;
        f286981h = "https://mon.zijieapi.com";
    }

    public ApmConfigs() {
        this.f286982a = "https://mon.snssdk.com/monitor/collect/c/crash";
        this.f286983b = "https://mon.snssdk.com/monitor/collect/c/exception";
        this.f286984c = "https://mon.snssdk.com/monitor/collect/c/native_bin_crash";
        this.f286985d = "https://mon.snssdk.com/monitor/collect/c/logcollect";
        this.f286986e = f286980g;
        this.f286987f = f286981h;
    }

    @Override // com.larus.apm.api.IApmConfigs
    public final String a() {
        return this.f286987f;
    }

    @Override // com.larus.apm.api.IApmConfigs
    public final String c() {
        return this.f286983b;
    }

    @Override // com.larus.apm.api.IApmConfigs
    public final String d() {
        return this.f286984c;
    }

    @Override // com.larus.apm.api.IApmConfigs
    public final String f() {
        return this.f286982a;
    }

    @Override // com.larus.apm.api.IApmConfigs
    public final String h() {
        return this.f286986e;
    }

    @Override // com.larus.apm.api.IApmConfigs
    public final String i() {
        return this.f286985d;
    }
}
