package com.larus.init.task;

import android.util.EventsUtils;
import bf6.d;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.flowsdk.common.experiment.FlowExperimentDefaultScope;
import com.larus.flowsdk.common.experiment.IFlowClientExperimentRegistry;
import com.larus.im.depend.IAIJobExperimentProvider;
import com.larus.init.task.experiment.FlowClientExperimentSettingsRuntime;
import com.larus.platform.service.AccountService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/larus/init/task/InitFlowClientExperimentTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "Lcom/larus/init/task/base/IFlowInitReportTask;", "<init>", "()V", "scene", XmlPullParser.NO_NAMESPACE, "getScene", "()Ljava/lang/String;", "runInternal", XmlPullParser.NO_NAMESPACE, "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class InitFlowClientExperimentTask extends d implements bg9.i {
    public final String a;

    @Override // bg9.i
    public final String v() {
        return "normal";
    }

    @Override // bg9.i
    public final void runInternal() {
        AtomicReference r0 = ga9.a.a;
        a r1 = new a();
        Intrinsics.checkNotNullParameter(r1, "logger");
        AtomicReference r2 = ga9.a.b;
        r2.set(r1);
        ga9.c r3 = FlowClientExperimentSettingsRuntime.a;
        FlowExperimentDefaultScope r4 = FlowExperimentDefaultScope.Doubao;
        Intrinsics.checkNotNullParameter(r3, "runtime");
        Intrinsics.checkNotNullParameter(r4, "defaultScope");
        ga9.a.a r5 = new ga9.a.a(r3, r4);
        AtomicReference r6 = ga9.a.a;
        ga9.a.a r7 = (ga9.a.a) r6.getAndSet(r5);
        Long r8 = null;
        if (r7 == null) goto L5;
        ga9.c r9 = r7.a;
    L6:
        if (r9 != r3) goto L11;
        if (r7 == null) goto L9;
        FlowExperimentDefaultScope r10 = r7.b;
    L10:
        if (r10 != r4) goto L11;
    L12:
        r3.getClass();
        if (FlowClientExperimentSettingsRuntime.d.compareAndSet(false, true) == true) goto L81;
    L16:
        IFlowClientExperimentRegistry.a.getClass();
        if (((ga9.a.a) r6.get()) == null) goto L19;
        r8 = Long.valueOf(ga9.a.c.get());
    L19:
        if (r8 == null) goto L74;
        long r11 = r8.longValue();
        long r12 = System.nanoTime();
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L23
        Object r14 = Result.m49constructorimpl(IFlowClientExperimentRegistry.a.a());     // Catch: Throwable -> L23
    L25:
        Throwable r15 = Result.m52exceptionOrNullimpl(r14);
        if (r15 != null) goto L70;
        List r16 = (List) r14;
        ArrayList r17 = new ArrayList();
        Iterator r18 = r16.iterator();
        int r19 = 0;
        int r110 = 0;
    L29:
        if (r18.hasNext() == false) goto L67;
        IFlowClientExperimentRegistry r111 = (IFlowClientExperimentRegistry) r18.next();
        String r112 = r11 + ':' + r111.getClass().getName();
        Object r113 = IFlowClientExperimentRegistry.a.b;
        monitor-enter(r113);
    L64:
        th = move-exception;
        throw th;
    L33:
        if (IFlowClientExperimentRegistry.a.d.contains(r112) == true) goto L39;
        HashSet r20 = IFlowClientExperimentRegistry.a.c;     // Catch: Throwable -> L64
        if (r20.contains(r112) == true) goto L39;
        r20.add(r112);     // Catch: Throwable -> L64
        boolean r21 = true;
    L40:
        monitor-exit(r113);
        if (r21 == false) goto L42;
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L45
        r111.register();     // Catch: Throwable -> L45
        Object r23 = Result.m49constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L45
    L47:
        Object r114 = IFlowClientExperimentRegistry.a.b;
        monitor-enter(r114);
        IFlowClientExperimentRegistry.a.c.remove(r112);     // Catch: Throwable -> L61
        if (Result.m56isSuccessimpl(r23) == false) goto L52;
        IFlowClientExperimentRegistry.a.d.add(r112);     // Catch: Throwable -> L61
    L52:
        Unit r24 = Unit.INSTANCE;     // Catch: Throwable -> L61
        monitor-exit(r114);
        if (Result.m56isSuccessimpl(r23) == false) goto L57;
        Unit r25 = (Unit) r23;
        r19 = r19 + 1;
    L57:
        Throwable r26 = Result.m52exceptionOrNullimpl(r23);
        if (r26 == null) goto L29;
        r17.add(r111.getClass().getName() + ':' + r26.getClass().getName());
    L61:
        th = move-exception;
        throw th;
    L45:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r23 = Result.m49constructorimpl(ResultKt.createFailure(th));
        goto L47
    L42:
        r110 = r110 + 1;
    L39:
        r21 = false;
        goto L40
    L67:
        long r28 = (System.nanoTime() - r12) / 1000000;
        AtomicReference r29 = ga9.a.a;
        String r30 = "registerAll: runtimeVersion=" + r11 + ", discovered=" + r16.size() + ", registered=" + r19 + ", skipped=" + r110 + ", failed=" + r17.size() + ", durationMs=" + r28;
        Intrinsics.checkNotNullParameter(r30, "message");
        AtomicReference r31 = ga9.a.b;
        ((ga9.b) r31.get()).i(r30);
        if ((!r17.isEmpty()) == false) goto L74;
        String r32 = "registerAll failed: runtimeVersion=" + r11 + ", registries=" + CollectionsKt.joinToString$default(r17, null, null, null, 0, null, null, 63, null);
        Intrinsics.checkNotNullParameter(r32, "message");
        ((ga9.b) r31.get()).w(r32);
        goto L74
    L70:
        AtomicReference r33 = ga9.a.a;
        StringBuilder r34 = new StringBuilder("registerAll discovery failed: runtimeVersion=");
        r34.append(r11);
        r34.append(", error=");
        r34.append(r15.getClass().getName());
        r34.append(':');
        String r35 = r15.getMessage();
        if (r35 != null) goto L73;
        r35 = XmlPullParser.NO_NAMESPACE;
    L73:
        r34.append(r35);
        String r36 = r34.toString();
        Intrinsics.checkNotNullParameter(r36, "message");
        ((ga9.b) ga9.a.b.get()).w(r36);
    L23:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        r14 = Result.m49constructorimpl(ResultKt.createFailure(th));
    L74:
        IAIJobExperimentProvider r38 = (IAIJobExperimentProvider) ServiceManager.get().getService(IAIJobExperimentProvider.class);
        if (r38 == null) goto L96;
        r38.a();
        return;
    L96:
        return;
    L81:
        AccountService.a.E(new com.larus.init.task.experiment.a());     // Catch: Throwable -> L78
    L78:
        th = move-exception;
        FlowClientExperimentSettingsRuntime.d.set(false);
        throw th;
    L9:
        r10 = null;
    L11:
        ((ga9.b) r2.get()).i("installRuntime: runtime=" + r3.getClass().getName() + ", defaultScope=" + r4 + ", version=" + ga9.a.c.incrementAndGet());
        goto L12
    L5:
        r9 = null;
        goto L6
    }

    public InitFlowClientExperimentTask() {
        this.a = "Infra";
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
        return this.a;
    }
}
