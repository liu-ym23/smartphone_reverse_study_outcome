package com.larus.init.task.feed;

import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.network.http.ServiceType;
import com.larus.perfdegrade.api.IPerfDegradeAbility;
import com.larus.perfdegrade.api.model.PerfDegradeType;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0002\u0014\u0015B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\nH\u0002J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/larus/init/task/feed/InitPerfDegradeTriggerTask;", "Lcom/bytedance/lego/init/model/BaseFeedShowTask;", "Lcom/larus/init/task/base/IFlowInitReportTask;", "<init>", "()V", "scene", "", "getScene", "()Ljava/lang/String;", "runInternal", "", "triggerJankDegrade", "triggerDiskOccupancyDegrade", "triggerScrollJankDegrade", "triggerDegrade", "type", "Lcom/larus/perfdegrade/api/model/PerfDegradeType;", "degradeName", "buildRequest", "Lcom/larus/perfdegrade/api/model/PerfDegradeRequest;", "Companion", "DebugPerfDegradeOverrides", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InitPerfDegradeTriggerTask extends bf6.a implements bg9.i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f351246b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f351247a;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f351248a = 0;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f351249a = null;

            static {
                int[] r100 = new int[PerfDegradeType.values().length];
                r100[PerfDegradeType.JANK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r100[PerfDegradeType.DISK_OCCUPANCY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r100[PerfDegradeType.SCROLL_JANK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                f351249a = r100;
            }
        }

        static {
        }
    }

    @Override // bg9.i
    public final String v() {
        return "normal";
    }

    static {
        f351246b = bp9.a.a("InitTriggerTask");
    }

    @Override // bg9.i
    public final void runInternal() {
        a(PerfDegradeType.JANK, "jank degrade");
        a(PerfDegradeType.DISK_OCCUPANCY, "disk occupancy degrade");
        a(PerfDegradeType.SCROLL_JANK, "scroll jank degrade");
    }

    public InitPerfDegradeTriggerTask() {
        this.f351247a = ServiceType.BASIC_TEC;
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
        return this.f351247a;
    }

    public static void a(PerfDegradeType r100, String r101) {
        IPerfDegradeAbility.Companion r102 = IPerfDegradeAbility.f363951a;
        int r103 = b.f351248a;
        Intrinsics.checkNotNullParameter(r100, "type");
        int r104 = b.a.f351249a[r100.ordinal()];
        if (r104 != 1) goto L5;
    L11:
        cp9.b r105 = r102.a(new cp9.a(r100));
        if (r105.f464728a == false) goto L14;
        FLogger.f375446a.i(f351246b, "trigger " + r101 + " success, reason=" + r105.f464729b);
        return;
    L14:
        FLogger.f375446a.w(f351246b, "trigger " + r101 + " skipped, reason=" + r105.f464729b);
        return;
    L5:
        if (r104 == 2) goto L11;
        if (r104 == 3) goto L11;
        throw new NoWhenBranchMatchedException();
    }
}
