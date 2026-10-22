package com.bytedance.ee.bear.office.common.upload;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b0 implements Runnable {
    public final /* synthetic */ List<OfficeUploadRecoveryTarget> a;

    public b0(List<OfficeUploadRecoveryTarget> r1) {
        this.a = r1;
    }

    public final void a() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L17;
        OfficeUploadRecoveryTarget r1 = (OfficeUploadRecoveryTarget) r0.next();
        OfficeUploadRecoveryCoordinator.a.getClass();
        String r2 = OfficeUploadRecoveryCoordinator.d(r1);
        String r4 = du5.b.k(r2);
        LinkedHashMap<String, OfficeUploadRecoveryCoordinator.a> r5 = OfficeUploadRecoveryCoordinator.d;
        OfficeUploadRecoveryCoordinator.a r6 = r5.get(r2);
        if (r6 != null) goto L7;
        OfficeUploadRecoveryCoordinator.RecoveryMonitor r7 = new OfficeUploadRecoveryCoordinator.RecoveryMonitor(r1);
        r5.put(r2, new OfficeUploadRecoveryCoordinator.a(r1, r7));
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L11
        OfficeUploadRecoveryCoordinator.a().m(OfficeUploadRecoveryCoordinator.b(r1), "explorer", r7);     // Catch: Throwable -> L11
        tt5.a.h("OfficeUploadRecovery", "office_upload_recovery_trace register_monitor_success target=" + r4);     // Catch: Throwable -> L11
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L16;
        tt5.a.l("OfficeUploadRecovery", "office_upload_recovery_trace register_monitor_failed target=" + r4, r9);
    L16:
        OfficeUploadRecoveryCoordinator.c(r1);
    L11:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    L7:
        r6.c++;
        tt5.a.h("OfficeUploadRecovery", "office_upload_recovery_trace target_ref_inc target=" + r4 + " ref=" + r6.c);
        OfficeUploadRecoveryCoordinator.c(r1);
        goto L4
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
}
