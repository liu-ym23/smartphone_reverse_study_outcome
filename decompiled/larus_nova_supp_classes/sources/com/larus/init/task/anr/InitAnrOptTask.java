package com.larus.init.task.anr;

import android.app.Application;
import android.os.Process;
import android.util.EventsUtils;
import bf6.d;
import bg9.i;
import com.bytedance.sysoptimizer.AnrThreadPriorityOptV2;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.anr.AnrListener;
import com.bytedance.sysoptimizer.anr.AnrManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.common.apphost.AppHost;
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
import org.xmlpull.v1.XmlPullParser;
import qt9.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u000bH\u0002J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u000bH\u0002J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u000bH\u0002J\b\u0010\u001b\u001a\u00020\u000bH\u0002J\b\u0010\u001c\u001a\u00020\u0013H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/larus/init/task/anr/InitAnrOptTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "Lcom/larus/init/task/base/IFlowInitReportTask;", "<init>", "()V", "TAG", XmlPullParser.NO_NAMESPACE, "scene", "getScene", "()Ljava/lang/String;", "isEnableMainThreadPriorityOpt", XmlPullParser.NO_NAMESPACE, "isEnableAdjustMainThreadPriorityOnANR", "isEnableAdjustThreadPriorityOnANROccurs", "isEnableAdjustThreadPriorityOnANRRestore", "adjustThreadPriorityInfo", XmlPullParser.NO_NAMESPACE, XmlPullParser.NO_NAMESPACE, "runInternal", XmlPullParser.NO_NAMESPACE, "optBroadcastReceiverAnr", "optScreenReceiverRegisterAnrV1", "enable", "optReceiverRegisterCrashFix", "optScreenReceiverRegisterAnrV2", "anrListener", "Lcom/bytedance/sysoptimizer/anr/AnrListener;", "isDebug", "registerActivityLifecycleCallbacks", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class InitAnrOptTask extends d implements i {
    public final String a;
    public final String b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public Map<String, Integer> g;
    public final a h;

    public static final class a implements AnrListener {
        public final /* synthetic */ InitAnrOptTask a;

        public a(InitAnrOptTask r1) {
            this.a = r1;
        }

        @Override // com.bytedance.sysoptimizer.anr.AnrListener
        public final void onAnrChange(boolean r5, int r6, AnrManager.AnrReason r7) {
            Intrinsics.checkNotNullParameter(r7, "anrReason");
            if (r5 == false) goto L24;
            FLogger.a.i(this.a.a, "anr coming...   level: " + r6 + ", anrReason: " + r7);     // Catch: Throwable -> L30
            if (this.a.d == false) goto L13;
            int r8 = f.a;     // Catch: Throwable -> L30
            Application r9 = AppHost.a.getApplication();     // Catch: Throwable -> L30
            Intrinsics.checkNotNullParameter(r9, "base");     // Catch: Throwable -> L30
            ht9.a.a.getClass();     // Catch: Throwable -> L30
            if ((ht9.a.b(r9) & 16) == 0) goto L13;
            Process.setThreadPriority(Process.myPid(), -20);     // Catch: Throwable -> L11
            Process.getThreadPriority(Process.myPid());     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            th.toString();     // Catch: Throwable -> L30
        L13:
            InitAnrOptTask r10 = this.a;     // Catch: Throwable -> L30
            if (r10.e == true) goto L16;
            return;
        L16:
            if (r10.g == null) goto L37;
            AnrThreadPriorityOptV2 r11 = AnrThreadPriorityOptV2.getInstance();     // Catch: Throwable -> L30
            AppHost.Companion r12 = AppHost.a;     // Catch: Throwable -> L30
            Application r13 = r12.getApplication();     // Catch: Throwable -> L30
            Map<String, Integer> r0 = this.a.g;     // Catch: Throwable -> L30
            boolean r1 = r12.isDebug();     // Catch: Throwable -> L30
            boolean r14 = r12.isTestChannel();     // Catch: Throwable -> L30
            if (r1 == true) goto L22;
            if (r14 == true) goto L22;
            boolean r15 = false;
        L23:
            r11.init(r13, r0, false, r15);     // Catch: Throwable -> L30
            AnrThreadPriorityOptV2.getInstance().setThreadPriority();     // Catch: Throwable -> L30
            return;
        L22:
            r15 = true;
            goto L23
        L37:
            return;
        L24:
            FLogger.a.i(this.a.a, "anr restore...   level: " + r6 + ", anrReason: " + r7);     // Catch: Throwable -> L30
            InitAnrOptTask r16 = this.a;     // Catch: Throwable -> L30
            if (r16.e == true) goto L27;
            return;
        L27:
            if (r16.f == false) goto L40;
            AnrThreadPriorityOptV2.getInstance().restoreThreadPriority();     // Catch: Throwable -> L30
            return;
        L40:
            return;
        L30:
            th = move-exception;
            FLogger.a.e(this.a.a, "onAnrChange, error: " + th);
        }
    }

    @Override // bg9.i
    public final String v() {
        return "normal";
    }

    @Override // bg9.i
    public final void runInternal() {
        FLogger r0 = FLogger.a;
        r0.i(this.a, "InitAnrOptTask runInternal");
        int r1 = f.a;
        AppHost.Companion r2 = AppHost.a;
        Application r3 = r2.getApplication();
        Intrinsics.checkNotNullParameter(r3, "base");
        ht9.a.a.getClass();
        boolean r4 = false;
        if (ht9.a.b(r3) == 0) goto L5;
        boolean r5 = true;
    L6:
        this.c = r5;
        Application r6 = r2.getApplication();
        Intrinsics.checkNotNullParameter(r6, "base");
        if ((ht9.a.b(r6) & 16) == 0) goto L9;
        boolean r7 = true;
    L10:
        this.d = r7;
        e10 r8 = e10.a;
        int r9 = l0.a;
        c r10 = (c) l0.a(new c(null), new xu());
        this.e = r10.a();
        this.f = r10.b();
        this.g = r10.c();
        if (this.c == false) goto L14;
        r2.getApplication().registerActivityLifecycleCallbacks(new b(this));
    L14:
        if (this.d == false) goto L16;
    L17:
        r0.i(this.a, "InitAnrOptTask registerAnrListener, isEnableAdjustMainThreadPriorityOnANR: " + this.d + ", isEnableAdjustThreadPriorityOnANROccurs: " + this.e);
        AnrManager.getInstance().init(r2.getApplication());
        AnrManager.getInstance().registerListener(this.h);
    L18:
        boolean r11 = r2.isDebug();
        boolean r12 = r2.isTestChannel();
        if (r11 == true) goto L21;
        if (r12 == true) goto L21;
    L22:
        AnrDispatchBoost.a = r4;
        if (((Boolean) l0.a(Boolean.TRUE, new mt())).booleanValue() == true) goto L44;
        r0.i(this.a, "receiver register crash fix disabled");
    L29:
        e10 r13 = e10.a;
        int r14 = l0.a;
        if (((Boolean) l0.a(Boolean.FALSE, new jv())).booleanValue() == true) goto L48;
        FLogger.a.i(this.a, "screen receiver optimize v2 disabled");
    L36:
        e10 r15 = e10.a;
        int r16 = l0.a;
        if (((Boolean) l0.a(Boolean.FALSE, new zr())).booleanValue() == true) goto L46;
        FLogger.a.w(this.a, "broadcast receiver register handler disabled");
        return;
    L46:
        FLogger.a.i(this.a, "broadcast receiver register handler init");     // Catch: Throwable -> L41
        ReceiverRegisterCrashOptimizer.setBroadcastReceiverRegisterHandler(new com.larus.init.task.anr.a(this));     // Catch: Throwable -> L41
        return;
    L41:
        th = move-exception;
        FLogger.a.e(this.a, "broadcast receiver register handler failed", th);
        return;
    L48:
        ReceiverRegisterAnrOptimizer.setEnableScreenReceiverOptimize(true);     // Catch: Throwable -> L34
        FLogger.a.i(this.a, "screen receiver optimize v2 enabled");     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        FLogger.a.e(this.a, "screen receiver optimize v2 failed", th);
        goto L36
    L44:
        ReceiverRegisterCrashOptimizer.fix(r2.getApplication());     // Catch: Throwable -> L27
        r0.i(this.a, "receiver register crash fix enabled");     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        FLogger.a.e(this.a, "receiver register crash fix failed", th);
    L21:
        r4 = true;
        goto L22
    L16:
        if (this.e == false) goto L18;
    L9:
        r7 = false;
        goto L10
    L5:
        r5 = false;
        goto L6
    }

    public InitAnrOptTask() {
        this.a = "AnrOptTask";
        this.b = "Infra";
        this.g = MapsKt.emptyMap();
        this.h = new a(this);
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
        return this.b;
    }
}
