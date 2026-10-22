package com.larus.init.task.feed;

import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.bmhome.chat.input.IChatInputService;
import com.larus.network.http.ServiceType;
import com.larus.utils.t0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\u0007\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u0018\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0002J\u0018\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0002J\b\u0010\u0019\u001a\u00020\u0013H\u0002J\b\u0010\u001a\u001a\u00020\u0013H\u0002J\b\u0010\u001b\u001a\u00020\u0013H\u0002J\b\u0010\u001c\u001a\u00020\u0013H\u0002J\b\u0010\u001d\u001a\u00020\u0010H\u0002J\b\u0010\u001e\u001a\u00020\u0013H\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/larus/init/task/feed/InitInfraReportTask;", "Lcom/bytedance/lego/init/model/BaseFeedShowTask;", "Lcom/larus/init/task/base/IFlowInitReportTask;", "<init>", "()V", "scene", "", "getScene", "()Ljava/lang/String;", "IS_DORA_USER", "IS_IGNORING_BATTERY_OPTIMIZATIONS", "APP_CLOSE_REASON", "DELAY_TIME", "", "KEY_DORA_LINK_STATE", "DORA_LINK_STATE_CONNECTED", "", "VALUE_TRUE", "runInternal", "", "reportDoraState", "setPerfAndStabilityMonitorTag", "key", "value", "monitorEvent", "initTickManager", "reportAppRestartReason", "initDoraInfo", "initNetWorkInfo", "isIgnoringBatteryOptimizations", "reportPrivacyDialogShow", "Companion", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InitInfraReportTask extends bf6.a implements bg9.i {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f351236i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f351237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f351238b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f351239c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f351240d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f351241e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f351242f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f351243g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f351244h;

    public static final class a {
    }

    static {
    }

    @Override // bg9.i
    public final String v() {
        return "normal";
    }

    @Override // bg9.i
    public final void runInternal() {
        t0.d(new k(), this.f351241e);
        ThreadPlus.submitRunnable(new j(this));
        int r100 = xp9.m.f564773a;
        IChatInputService r101 = (IChatInputService) ServiceManager.get().getService(IChatInputService.class);
        if (r101 == null) goto L6;
        r101.c();
        return;
    }

    public InitInfraReportTask() {
        this.f351237a = ServiceType.BASIC_TEC;
        this.f351238b = "f_dora_user";
        this.f351239c = "f_ignoring_battery_optimizations";
        this.f351240d = "app_close_reason";
        this.f351241e = 1000;
        this.f351242f = "dora_link_state";
        this.f351243g = 2;
        this.f351244h = "1";
    }

    @Override // java.lang.Runnable, bg9.i
    public final void run() {
        bg9.i.a.a(this);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    @Override // bg9.i
    public final String getScene() {
        return this.f351237a;
    }
}
