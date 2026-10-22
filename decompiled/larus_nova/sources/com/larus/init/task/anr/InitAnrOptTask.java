package com.larus.init.task.anr;

import android.app.Application;
import android.os.Process;
import bg9.i;
import com.bytedance.sysoptimizer.AnrThreadPriorityOptV2;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.anr.AnrListener;
import com.bytedance.sysoptimizer.anr.AnrManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.common.apphost.AppHost;
import com.larus.network.http.ServiceType;
import com.larus.settings.value.e10;
import com.larus.settings.value.jv;
import com.larus.settings.value.mt;
import com.larus.settings.value.xu;
import com.larus.settings.value.zr;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u000bH\u0002J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u000bH\u0002J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u000bH\u0002J\b\u0010\u001b\u001a\u00020\u000bH\u0002J\b\u0010\u001c\u001a\u00020\u0013H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/larus/init/task/anr/InitAnrOptTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "Lcom/larus/init/task/base/IFlowInitReportTask;", "<init>", "()V", "TAG", "", "scene", "getScene", "()Ljava/lang/String;", "isEnableMainThreadPriorityOpt", "", "isEnableAdjustMainThreadPriorityOnANR", "isEnableAdjustThreadPriorityOnANROccurs", "isEnableAdjustThreadPriorityOnANRRestore", "adjustThreadPriorityInfo", "", "", "runInternal", "", "optBroadcastReceiverAnr", "optScreenReceiverRegisterAnrV1", "enable", "optReceiverRegisterCrashFix", "optScreenReceiverRegisterAnrV2", "anrListener", "Lcom/bytedance/sysoptimizer/anr/AnrListener;", "isDebug", "registerActivityLifecycleCallbacks", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InitAnrOptTask extends bf6.d implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f351155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f351156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f351157c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f351158d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f351159e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f351160f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Map<String, Integer> f351161g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f351162h;

    public static final class a implements AnrListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InitAnrOptTask f351163a;

        public a(InitAnrOptTask r100) {
            this.f351163a = r100;
        }

        @Override // com.bytedance.sysoptimizer.anr.AnrListener
        public final void onAnrChange(boolean r100, int r101, AnrManager.AnrReason r102) {
            Intrinsics.checkNotNullParameter(r102, "anrReason");
            if (r100 == false) goto L24;
            FLogger.f375446a.i(this.f351163a.f351155a, "anr coming...   level: " + r101 + ", anrReason: " + r102);     // Catch: Throwable -> L30
            if (this.f351163a.f351158d == false) goto L13;
            int r103 = f.f351176a;     // Catch: Throwable -> L30
            Application r104 = AppHost.f326268a.getApplication();     // Catch: Throwable -> L30
            Intrinsics.checkNotNullParameter(r104, "base");     // Catch: Throwable -> L30
            ht9.a.f487150a.getClass();     // Catch: Throwable -> L30
            if ((ht9.a.b(r104) & 16) == 0) goto L13;
            Process.setThreadPriority(Process.myPid(), -20);     // Catch: Throwable -> L11
            Process.getThreadPriority(Process.myPid());     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            th.toString();     // Catch: Throwable -> L30
        L13:
            InitAnrOptTask r105 = this.f351163a;     // Catch: Throwable -> L30
            if (r105.f351159e == true) goto L16;
            return;
        L16:
            if (r105.f351161g == null) goto L37;
            AnrThreadPriorityOptV2 r106 = AnrThreadPriorityOptV2.getInstance();     // Catch: Throwable -> L30
            AppHost.Companion r107 = AppHost.f326268a;     // Catch: Throwable -> L30
            Application r108 = r107.getApplication();     // Catch: Throwable -> L30
            Map<String, Integer> r109 = this.f351163a.f351161g;     // Catch: Throwable -> L30
            boolean r110 = r107.isDebug();     // Catch: Throwable -> L30
            boolean r111 = r107.isTestChannel();     // Catch: Throwable -> L30
            if (r110 == true) goto L22;
            if (r111 == true) goto L22;
            boolean r112 = false;
        L23:
            r106.init(r108, r109, false, r112);     // Catch: Throwable -> L30
            AnrThreadPriorityOptV2.getInstance().setThreadPriority();     // Catch: Throwable -> L30
            return;
        L22:
            r112 = true;
            goto L23
        L37:
            return;
        L24:
            FLogger.f375446a.i(this.f351163a.f351155a, "anr restore...   level: " + r101 + ", anrReason: " + r102);     // Catch: Throwable -> L30
            InitAnrOptTask r113 = this.f351163a;     // Catch: Throwable -> L30
            if (r113.f351159e == true) goto L27;
            return;
        L27:
            if (r113.f351160f == false) goto L40;
            AnrThreadPriorityOptV2.getInstance().restoreThreadPriority();     // Catch: Throwable -> L30
            return;
        L40:
            return;
        L30:
            th = move-exception;
            FLogger.f375446a.e(this.f351163a.f351155a, "onAnrChange, error: " + th);
        }
    }

    @Override // bg9.i
    public final String v() {
        return "normal";
    }

    @Override // bg9.i
    public final void runInternal() {
        FLogger r100 = FLogger.f375446a;
        r100.i(this.f351155a, "InitAnrOptTask runInternal");
        int r101 = f.f351176a;
        AppHost.Companion r102 = AppHost.f326268a;
        Application r103 = r102.getApplication();
        Intrinsics.checkNotNullParameter(r103, "base");
        ht9.a.f487150a.getClass();
        boolean r104 = false;
        if (ht9.a.b(r103) == 0) goto L5;
        boolean r105 = true;
    L6:
        this.f351157c = r105;
        Application r106 = r102.getApplication();
        Intrinsics.checkNotNullParameter(r106, "base");
        if ((ht9.a.b(r106) & 16) == 0) goto L9;
        boolean r107 = true;
    L10:
        this.f351158d = r107;
        e10 r108 = e10.f368561a;
        int r109 = l0.f375430a;
        qt9.c r110 = (qt9.c) l0.a(new qt9.c(null), new xu());
        this.f351159e = r110.a();
        this.f351160f = r110.b();
        this.f351161g = r110.c();
        if (this.f351157c == false) goto L14;
        r102.getApplication().registerActivityLifecycleCallbacks(new b(this));
    L14:
        if (this.f351158d == false) goto L16;
    L17:
        r100.i(this.f351155a, "InitAnrOptTask registerAnrListener, isEnableAdjustMainThreadPriorityOnANR: " + this.f351158d + ", isEnableAdjustThreadPriorityOnANROccurs: " + this.f351159e);
        AnrManager.getInstance().init(r102.getApplication());
        AnrManager.getInstance().registerListener(this.f351162h);
    L18:
        boolean r111 = r102.isDebug();
        boolean r112 = r102.isTestChannel();
        if (r111 == true) goto L21;
        if (r112 == true) goto L21;
    L22:
        AnrDispatchBoost.f351148a = r104;
        if (((Boolean) l0.a(Boolean.TRUE, new mt())).booleanValue() == true) goto L44;
        r100.i(this.f351155a, "receiver register crash fix disabled");
    L29:
        e10 r113 = e10.f368561a;
        int r114 = l0.f375430a;
        if (((Boolean) l0.a(Boolean.FALSE, new jv())).booleanValue() == true) goto L48;
        FLogger.f375446a.i(this.f351155a, "screen receiver optimize v2 disabled");
    L36:
        e10 r115 = e10.f368561a;
        int r116 = l0.f375430a;
        if (((Boolean) l0.a(Boolean.FALSE, new zr())).booleanValue() == true) goto L46;
        FLogger.f375446a.w(this.f351155a, "broadcast receiver register handler disabled");
        return;
    L46:
        FLogger.f375446a.i(this.f351155a, "broadcast receiver register handler init");     // Catch: Throwable -> L41
        ReceiverRegisterCrashOptimizer.setBroadcastReceiverRegisterHandler(new com.larus.init.task.anr.a(this));     // Catch: Throwable -> L41
        return;
    L41:
        th = move-exception;
        FLogger.f375446a.e(this.f351155a, "broadcast receiver register handler failed", th);
        return;
    L48:
        ReceiverRegisterAnrOptimizer.setEnableScreenReceiverOptimize(true);     // Catch: Throwable -> L34
        FLogger.f375446a.i(this.f351155a, "screen receiver optimize v2 enabled");     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        FLogger.f375446a.e(this.f351155a, "screen receiver optimize v2 failed", th);
        goto L36
    L44:
        ReceiverRegisterCrashOptimizer.fix(r102.getApplication());     // Catch: Throwable -> L27
        r100.i(this.f351155a, "receiver register crash fix enabled");     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        FLogger.f375446a.e(this.f351155a, "receiver register crash fix failed", th);
    L21:
        r104 = true;
        goto L22
    L16:
        if (this.f351159e == false) goto L18;
    L9:
        r107 = false;
        goto L10
    L5:
        r105 = false;
        goto L6
    }

    public InitAnrOptTask() {
        this.f351155a = "AnrOptTask";
        this.f351156b = ServiceType.BASIC_TEC;
        this.f351161g = MapsKt.emptyMap();
        this.f351162h = new a(this);
    }

    @Override // java.lang.Runnable, bg9.i
    public final void run() {
        i.a.a(this);     // Catch: Throwable -> L4
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
        return this.f351156b;
    }
}
